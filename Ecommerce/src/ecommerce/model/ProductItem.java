package ecommerce.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author taver
 */
public class ProductItem  {
    private String name;
    private BigDecimal price;
    private int id;
    private Connection con;
    //picture
//hi
    public ProductItem(Connection con, int Id, String name, BigDecimal price ) {
        this.name = name;
        this.price = price;
        this.id = Id;
        this.con = con;
    }
    
      public Connection getCon() {
        return con;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setCon(Connection con) {
        this.con = con;
    }
    public ProductItem() {
    }

    public ProductItem(String name, BigDecimal price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

   
}


