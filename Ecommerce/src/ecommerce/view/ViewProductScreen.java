package ecommerce.view;

import ecommerce.model.Node;
import javax.swing.table.DefaultTableModel;

import ecommerce.model.Node;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ecommerce.model.ProductItem;
import ecommerce.viewmodel.ViewProductViewModel;
import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFrame;

public class ViewProductScreen extends javax.swing.JFrame implements Node {
    private Node parent;

    public ViewProductScreen() throws SQLException {
        initComponents();
        ArrayList<ProductItem> productsArrayList = new ArrayList<>();
        ViewProductViewModel v = new ViewProductViewModel();
        DefaultTableModel t = (DefaultTableModel) jTable1.getModel();     
                v.DisplayAllProducts(jTable1);
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Viewing Products");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 153, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(225,117,225));
        jTable1.getTableHeader().setForeground( Color.WHITE);
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(153, 0, 153));
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jTable1.setSelectionForeground(new java.awt.Color(51, 0, 204));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        JFrame parent = (JFrame) this.getParentNode();
        if (parent != null)
            parent.setVisible(true);    }//GEN-LAST:event_formWindowClosing

    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
