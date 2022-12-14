package ecommerce.viewmodel;

import ecommerce.model.ProductItem;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewProductViewModel {

    private Connection con;

    public ViewProductViewModel() throws SQLException {
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","IDKWHYUWANTIT123");
    }

    public ArrayList<ProductItem> getAllProducts() throws SQLException {
        ArrayList<ProductItem> productsArrayList = new ArrayList<>();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from products");
        while (rs.next()) {
            productsArrayList.add(new ProductItem(rs.getString("name"), rs.getBigDecimal("price"), rs.getInt("id")));
        }
        
        return productsArrayList;
    }
    public void DisplayAllProducts (JTable t1) throws SQLException{
        ArrayList<ProductItem> productsArrayList = new ArrayList<>();
        productsArrayList = getAllProducts();
        String name;     
        BigDecimal price;
        int id;
        DefaultTableModel t = (DefaultTableModel) t1.getModel();    
            for (int i = 0; i < productsArrayList.size(); i++) {
                name = productsArrayList.get(i).getName();
                price = (BigDecimal)productsArrayList.get(i).getPrice();
                id = productsArrayList.get(i).getId();

                int num = id;
                String pric =""+price ;
                Object data[] = {num,name,pric};
                t.addRow(data);
                
            }
       // return data;
        
    }

}
