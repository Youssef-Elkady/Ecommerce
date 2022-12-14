package ecommerce.viewmodel;

import ecommerce.model.ProductItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

}
