/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XYZ
 */
public class OrderForm extends javax.swing.JFrame {

    /**
     * Creates new form OrderForm
     */
    int amount=0;
    Order order = new Order();
    Customer customer = new Customer();
    Product product = new Product();
    public OrderForm() {
        initComponents();
        customer.fillCustomerTable(jTable_customer);
        product.fillProdcutTable(jTable_product);
        jTable_customer.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable_order.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable_product.getColumnModel().getColumn(0).setPreferredWidth(20);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_customer = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_product = new javax.swing.JTable();
        jComboBox_category = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_order = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton_remove = new javax.swing.JButton();
        jButton_clear = new javax.swing.JButton();
        jButton_insert = new javax.swing.JButton();
        jButton_remove2 = new javax.swing.JButton();
        jTextField_total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Fname = new javax.swing.JTextField();
        jTextField_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jTable_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Phone", "Email"
            }
        ));
        jTable_customer.setRowHeight(25);
        jTable_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_customer);

        jTable_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Image", "Description", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, ImageIcon.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_product.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable_product.setRowHeight(89);
        jScrollPane2.setViewportView(jTable_product);

        jComboBox_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Mouse", "Keyboard", "Monitor", "Speaker", "Headset" }));
        jComboBox_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoryActionPerformed(evt);
            }
        });

        jTable_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "PriceXQuantity"
            }
        ));
        jScrollPane3.setViewportView(jTable_order);

        jButton1.setText(">>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton_remove.setText("Remove Product");
        jButton_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeActionPerformed(evt);
            }
        });

        jButton_clear.setText("Clear");
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });

        jButton_insert.setText("Insert Order");
        jButton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertActionPerformed(evt);
            }
        });

        jButton_remove2.setText("Show All Order");
        jButton_remove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_remove2ActionPerformed(evt);
            }
        });

        jTextField_total.setText("Total : 0.0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Order ID :");

        jTextField_id.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Order Date :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_insert)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_remove2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_remove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_clear))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_Fname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_id, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jComboBox_category, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jComboBox_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_remove)
                    .addComponent(jButton_clear)
                    .addComponent(jButton_insert)
                    .addComponent(jButton_remove2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(127, 127, 127))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean DuplicateOrder(String id){
        for (int i=0;i<jTable_order.getRowCount();i++){
            if(jTable_order.getValueAt(i, 0).toString().equals(id))
                return true;
        }
        return false;
    }
    private void jTable_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_customerMouseClicked
        DefaultTableModel dm = (DefaultTableModel)jTable_customer.getModel();
        int rIndex = jTable_customer.getSelectedRow();
        jTextField_id.setText(dm.getValueAt(rIndex, 0).toString());
    }//GEN-LAST:event_jTable_customerMouseClicked

    private void jComboBox_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_categoryActionPerformed
        String category = jComboBox_category.getSelectedItem().toString();
        product.clearTable(jTable_product);
        if(category.equals("All"))
            product.fillProdcutTable(jTable_product);
        else
            product.ShowTable(jTable_product, category);
        
    }//GEN-LAST:event_jComboBox_categoryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dm = (DefaultTableModel)jTable_product.getModel();
        DefaultTableModel dm2 = (DefaultTableModel)jTable_order.getModel();
        int rIndex = jTable_product.getSelectedRow();
        int qty2=0;
        Object row[] = new Object[5];
        if(rIndex==-1)
            JOptionPane.showMessageDialog(rootPane, "select product");
        else if(DuplicateOrder(dm.getValueAt(rIndex, 0).toString()))
            JOptionPane.showMessageDialog(rootPane, "Duplicate Product\nSelect another product");
        else{
            row[0]=Integer.parseInt(dm.getValueAt(rIndex, 0).toString());
            row[1]=dm.getValueAt(rIndex, 1);
            int price = Integer.parseInt(dm.getValueAt(rIndex, 2).toString());
            int qty = Integer.parseInt(dm.getValueAt(rIndex, 3).toString());
            while(true){
                try {
                    qty2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity you want"));
                    break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "value must be an integer");
            }
            }
            if(qty2==0)
                JOptionPane.showMessageDialog(rootPane, "Quantity can't be 0");
            else if(qty2>qty)
                JOptionPane.showMessageDialog(rootPane, "Unavailable Quantity");
            else{
                row[2]=price;
                row[3]=qty2;
                row[4]=price*qty2;
                amount+=price*qty2;
                jTextField_total.setText("Total :Rp."+amount);
                dm2.addRow(row);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeActionPerformed
       DefaultTableModel dm2 = (DefaultTableModel)jTable_order.getModel();
       if(jTable_order.getSelectedRow()==-1)
           JOptionPane.showMessageDialog(rootPane, "select product");
       else{
           int reply=JOptionPane.showConfirmDialog(rootPane, "remove product from order?","remove product",JOptionPane.YES_NO_OPTION);
           if(reply==JOptionPane.YES_OPTION)
            dm2.removeRow(jTable_order.getSelectedRow());
       }
       
    }//GEN-LAST:event_jButton_removeActionPerformed

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        order.clearTable(jTable_order);
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jButton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertActionPerformed
        if(jTextField_id.getText().trim().equals(""))
            JOptionPane.showMessageDialog(rootPane, "select customer");
        else if(jDateChooser1.getDate()==null)
            JOptionPane.showMessageDialog(rootPane, "select date");
        else if(jTable_order.getRowCount()==0)
            JOptionPane.showMessageDialog(rootPane, "select product to order");
        else{
            int cusid = Integer.parseInt(jTextField_id.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(jDateChooser1.getDate());
            String temp = "";
            DefaultTableModel dm = (DefaultTableModel)jTable_order.getModel();
            for(int i=0; i<jTable_order.getRowCount();i++){
                for(int j=1; j<jTable_order.getColumnCount();j++){
                    temp+=dm.getValueAt(i, j).toString()+"\t\t ";
                }
                temp+="\r\n";
            }
            if(order.addOrder(date, cusid, temp, amount))
                JOptionPane.showMessageDialog(rootPane, "Order success");
            else
                JOptionPane.showMessageDialog(rootPane, "Order failed");
            order.clearTable(jTable_order);
            amount=0;
            jTextField_total.setText("Total :Rp."+amount);
            
        }
    }//GEN-LAST:event_jButton_insertActionPerformed

    private void jButton_remove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_remove2ActionPerformed
        ShowOrderForm sof = new ShowOrderForm();
        sof.setVisible(true);
        sof.setLocationRelativeTo(null);
        sof.pack();
        sof.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton_remove2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_remove;
    private javax.swing.JButton jButton_remove2;
    private javax.swing.JComboBox<String> jComboBox_category;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_customer;
    private javax.swing.JTable jTable_order;
    private javax.swing.JTable jTable_product;
    private javax.swing.JTextField jTextField_Fname;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_total;
    // End of variables declaration//GEN-END:variables
}
