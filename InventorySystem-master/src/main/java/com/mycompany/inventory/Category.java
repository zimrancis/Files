/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XYZ
 */

public class Category {
    PreparedStatement ps;
    ResultSet rs;
    public boolean addCategory (String name){
        String query = "INSERT INTO `category`(`categoryname`) VALUES (?)";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            if(ps.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public boolean editCategory (int id,String name){
        PreparedStatement ps;
        String query = "UPDATE `category` SET `categoryname`=? WHERE `id`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public boolean removeCategory (int id){
        String query = "DELETE FROM `category` WHERE `id`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public void fillCategoryTable(JTable table){
        String query ="SELECT * FROM `category`";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                tableModel.addRow(row);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public boolean duplicateCategory(String name){
        String query ="SELECT * FROM `category` WHERE `categoryname`=? ";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            if(rs.next())
                return true;
            else
                return false;
            
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    public void clearTable(JTable table){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }
}
