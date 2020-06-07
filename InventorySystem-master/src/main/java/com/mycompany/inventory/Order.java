package com.mycompany.inventory;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XYZ
 */
public class Order {
    PreparedStatement ps;
    ResultSet rs;
    public boolean addOrder (String date,int customer, String orderlist, int amount){
        String query = "INSERT INTO `order`( `date`, `customer`, `orderlist`, `amount`) VALUES (?,?,?,?)";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, customer);
            ps.setString(3, orderlist);
            ps.setInt(4, amount);

            if(ps.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public void fillOrderTable(JTable table){
        String query ="SELECT * FROM `order`";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next()){
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                tableModel.addRow(row);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public ArrayList<String> getOrderList(int id){
        String query ="SELECT * FROM `order` WHERE id=?";
        ArrayList<String> orderlist = new ArrayList<String>();
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){

                orderlist.add(rs.getString(4));
                orderlist.add(rs.getString(5));
            }
        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE,null,ex);
        }
        return orderlist;
    }
    public String getCustomerName(int id){
        String query = "SELECT `fname`,`lname` FROM `customer` WHERE `id`=?";
        String fname="";
        String lname="";
        String name="";
        try {
            ps = DbConnection.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                fname = rs.getString(1);
                lname = rs.getString(2);
            }
            name = fname+" "+lname;
        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE,null,ex);
        }
        return name;
    }
    public void clearTable(JTable table){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }
}
