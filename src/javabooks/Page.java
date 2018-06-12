/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabooks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shady
 */
public class Page {
    
    private int id;
    private String title;
    private String content;
    private int bookRef;
    private int wordCount;
    private int currentLine;
    

    public Page(){
        
    }
    
    public Page(String pageTitle){
        title = pageTitle;
    }
    
    
    public Page( ResultSet column ){
        try{
            id = column.getInt("id");
            title = column.getString("page_title");
            content = column.getString("page_content");
            bookRef = column.getInt("book_id");
        }catch(Exception e){
            
        }
    }

    public int getId() {
        return id;
    }

    public int getBookRef() {
        return bookRef;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String pageTitle) {
        title = pageTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String pageContent) {
        content = pageContent;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int pageWordCount) {
        wordCount = pageWordCount;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int pageCurrentLine) {
        currentLine = pageCurrentLine;
    }
    
    public void createTextFile(String filename ) throws IOException{
        File file = new File(filename + ".txt");
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
    
    public void savePage(){
        
    }
    
    public void linkPage( String book_Id ){
        Db db = new Db();
        String sql = "INSERT INTO pages (book_id) values(?)";
                try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1,book_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NoteBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createPage(int notebook_id){
        Db db = new Db();
        String sql = "INSERT INTO pages (book_id, page_title, page_content) values(?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, notebook_id);
            ps.setString(2, getTitle());
            ps.setString(3,getContent());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NoteBook.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void updatePage(){
        Db db = new Db();
        String sql = "UPDATE pages SET page_title=?, page_content=? WHERE id="+getId();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, getTitle());
            ps.setString(2, getContent());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NoteBook.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    
}
