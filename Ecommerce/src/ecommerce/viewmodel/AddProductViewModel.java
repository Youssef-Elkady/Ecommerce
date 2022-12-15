package ecommerce.viewmodel;

import ecommerce.viewmodel.ViewProductViewModel;
//import Database.ProductsDatabase;
import ecommerce.model.ProductItem;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddProductViewModel {

    private Connection con;

    public AddProductViewModel() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "IDKWHYUWANTIT123");
    }

    private ViewProductViewModel vpvm = new ViewProductViewModel();
    ArrayList<ProductItem> productsArrayList = new ArrayList<>();

    public void insertProduct(String name, double price, int Id) throws SQLException {
        String InsertProductQuery = "INSERT INTO products(name, price, id) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(InsertProductQuery);
        ps.setString(1, name);
        ps.setDouble(2, price);
        ps.setInt(3, Id);
        ps.executeUpdate();
    }

    public boolean validateThenAdd(String name, String price, String id) throws SQLException {

        double p = 0;
        int ID = 0;
        try {

            p = Double.parseDouble(price);
            ID = Integer.parseInt(id);

            productsArrayList = vpvm.getAllProducts();
            boolean idValidation = isIdUnique(ID);
            if (idValidation == false) {
                JOptionPane.showMessageDialog(null, "id must be unique");
                return false;
            }
            if (p <= 0.0) {
                JOptionPane.showMessageDialog(null, "Price must be greater than 0!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddProductViewModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Number fields cannot contain characters!");
            return false;
        }
        insertProduct(name, p, ID);
        return true;
    }

    public boolean isIdUnique(int id) {
        for (int i = 0; i < productsArrayList.size(); i++) {
            if (id == productsArrayList.get(i).getId()) {
                return false;
            }
        }
        return true;
    }
}
