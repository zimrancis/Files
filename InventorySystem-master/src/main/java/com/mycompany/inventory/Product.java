/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XYZ
 */
public class Product {
    PreparedStatement ps;
    ResultSet rs;
    public boolean addProduct (String name, int price, int quantity, File file, String description, String category){
        String query = "INSERT INTO `product`( `name`, `price`, `quantity`, `image`, `description`, `category`) VALUES (?,?,?,?,?,?)";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            InputStream in = new FileInputStream(file);
            ps.setBlob(4,in);
            ps.setString(5, description);
            ps.setString(6,category);
            if(ps.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public boolean editProduct (int id,String name, int price, int quantity, String description, String category){
        String query = "UPDATE `product` SET `name`=?, `price`=?, `quantity`=?, `description`=?, `category`=? WHERE `id`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, description);
            ps.setString(5,category);
            ps.setInt(6, id);
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public boolean removeProduct (int id){
        String query = "DELETE FROM `product` WHERE `id`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public void fillProdcutTable(JTable table){
        String query ="SELECT * FROM `product`";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getInt(4);
                ImageIcon imageIcon = new ImageIcon(rs.getBytes(5)); 
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(151,89,Image.SCALE_SMOOTH); 
                row[4] = new ImageIcon(newimg);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                tableModel.addRow(row);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void ShowTable(JTable table,String categoryname){
        String query ="SELECT * FROM `product` WHERE `category`=?";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, categoryname);
            rs = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getInt(4);
                ImageIcon imageIcon = new ImageIcon(rs.getBytes(5)); 
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(151,89,Image.SCALE_SMOOTH); 
                row[4] = new ImageIcon(newimg);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                tableModel.addRow(row);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public String ShowProductList( String categoryname){
        String query ="SELECT `name` FROM `product` WHERE `category`=?";
        String text="";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, categoryname);
            rs = ps.executeQuery();
            while(rs.next()){
                String subtext= rs.getString(1);
                text+=subtext+"\n";
            }
            return text;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
        }
        return text;
    }
    public void SearchProdcutTable(JTable table,String key) throws SQLException{
        String query ="SELECT * FROM `product` WHERE `name` LIKE ?";
        ps = DbConnection.getConnection().prepareStatement(query);
        ps.setString(1, key+"%");
        rs = ps.executeQuery();
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        try {
            Object[] row;
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getInt(4);
                ImageIcon imageIcon = new ImageIcon(rs.getBytes(5)); 
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(151,89,Image.SCALE_SMOOTH); 
                row[4] = new ImageIcon(newimg);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,ex);
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
