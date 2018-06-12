/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shady
 */
public class Db {
    
    private Connection conn;
    
    public Db(){
        setConnection();
    }
    
    private void setConnection() {
        try {
            // db parameters
            String url = "jdbc:sqlite:db_books.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
 
    
    public Connection getConnection(){
        return conn;
    }
    
    public void closeConnetion(){
        try{
            getConnection().close();
        }catch(Exception e){
            
        }
    }
    
    public ResultSet queryAll( String query ){
        Statement st;
        ResultSet rs=null;
        try{
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            //closeConnetion();
        }catch( SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Db db = new Db();
        ResultSet books = db.queryAll("Select * FROM pages WHERE book_id=1");
        try{
            while(books.next()){
                System.out.println(books.getString("page_title"));
            }   
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        db.closeConnetion();
        Db dbs = new Db();
        ResultSet bk = dbs.queryAll("Select * FROM pages WHERE book_id=1");
        try{
            while(bk.next()){
                System.out.println(bk.getString("page_title"));
            }   
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
      
    }
    
    public void addBook(){
        
    }
    
    public void addPage(){
        
    }
    
}
