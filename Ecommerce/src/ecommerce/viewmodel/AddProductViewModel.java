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
        this.con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","IDKWHYUWANTIT123");
    }

    private ViewProductViewModel vpvm = new ViewProductViewModel();

    public void insertProduct( String name, double price, int Id) throws SQLException {
        String InsertProductQuery = "INSERT INTO products(name, price, id) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(InsertProductQuery);
        ps.setString(1, name);
        ps.setDouble(2, price);
        ps.setInt(3, Id);
        ps.executeUpdate();
    }

    public boolean validateThenAdd(String name, double price, int id) throws SQLException {
        ArrayList<ProductItem> productsArrayList = new ArrayList<>();

        
        try {
           
            productsArrayList = vpvm.getAllProducts();
            boolean idValidation = isIdUnique(id, productsArrayList);
            if (idValidation == true) {
                insertProduct( name, price, id);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "id must be unique");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddProductViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean isIdUnique(int id, ArrayList<ProductItem> productsArrayList) {
        for (int i = 0; i < productsArrayList.size(); i++) {
            if (id == productsArrayList.get(i).getId()) {
                return false;
            }
        }
        return true;
    }
}
