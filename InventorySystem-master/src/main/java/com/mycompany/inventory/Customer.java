/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XYZ
 */
public class Customer {
    PreparedStatement ps;
    ResultSet rs;
    public boolean addCustomer (String fname,String lname, String phone, String email){
        String query = "INSERT INTO `customer`( `fname`, `lname`, `phone`, `email`) VALUES (?,?,?,?)";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, phone);
            ps.setString(4, email);

            if(ps.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public boolean editCustomer (int id,String fname,String lname, String phone, String email){
        String query = "UPDATE `customer` SET `fname`=?, `lname`=?, `phone`=?, `email`=? WHERE `id`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setInt(5, id);
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public boolean removeCustomer (int id){
        String query = "DELETE FROM `customer` WHERE `id`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public void fillCustomerTable(JTable table){
        String query ="SELECT * FROM `customer`";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                tableModel.addRow(row);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void clearTable(JTable table){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }
}
