package ecommerce.view;
import ecommerce.model.Node;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HomePage extends javax.swing.JFrame implements Node {
    private Connection con;
    private static HomePage H=new HomePage();
    private Node parent;
    public HomePage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddProduct = new javax.swing.JButton();
        ViewProducts = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Page");

        AddProduct.setBackground(new java.awt.Color(204, 204, 255));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        AddProduct.setText("Add Product");
        AddProduct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });

        ViewProducts.setBackground(new java.awt.Color(204, 204, 255));
        ViewProducts.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        ViewProducts.setText("View Products");
        ViewProducts.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ViewProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewProductsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to our shop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ViewProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ViewProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed
        this.setVisible(false);
        AddProductScreen a1= new AddProductScreen(con);
        a1.setParentNode(this);
        a1.setVisible(true);
        
    }//GEN-LAST:event_AddProductActionPerformed

    private void ViewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewProductsActionPerformed
        this.setVisible(false);
        ViewProductScreen v1= new ViewProductScreen(con);
        v1.setParentNode(this);
        v1.setVisible(true);
    }//GEN-LAST:event_ViewProductsActionPerformed

    public void createConnection () throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","IDKWHYUWANTIT123");
            System.out.println("connected");
            Statement stmt = con.createStatement();

        }catch(SQLException ex)
        {
            System.out.println("not found driver");
        }
        // validation serial, 
    }
   public   void createTable () throws SQLException{
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","IDKWHYUWANTIT123");
       //id,name,price
       String t = "CREATE TABLE IF NOT EXISTS Products" + "("+ "id int PRIMARY KEY,"+ "name varchar(25),"+ "price float"+ ");";        
        Statement statement = con.createStatement();
        statement.executeUpdate(t);
   }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    H.createConnection();
                   H.createTable();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProduct;
    private javax.swing.JButton ViewProducts;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }
}
