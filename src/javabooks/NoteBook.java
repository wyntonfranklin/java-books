/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabooks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author shady
 */
public class NoteBook {
    
    private int id;
    private String title;
    private int pages;
    private int sections;
    private String description;
    ArrayList<NoteBookPage> mypages;
    DefaultListModel<NoteBookPage> model = new DefaultListModel<>();
    private static int books=1;
    
   

    public NoteBook(String name){
        title = name;
        mypages =  new ArrayList<>();
      //  id = BookAdapter.currentId();
        NoteBook.books =+ 1;
    }
    
    public NoteBook( String name, int bkPages, int bkSections ){
        title = name;
        pages = bkPages;
        sections = bkSections;
     //   id = BookAdapter.currentId();
        NoteBook.books =+ 1;
    }
    
    public NoteBook(){
        mypages =  new ArrayList<>();
       // id = BookAdapter.currentId();
        NoteBook.books =+ 1;
    }
    
    public NoteBook( ResultSet column ){
        try{
            id = column.getInt("id");
            title = column.getString("book_name");
            description = column.getString("description");
        }catch(Exception e){
            
        }
        mypages =  new ArrayList<>();
       // id = BookAdapter.currentId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String bkTitle) {
        title = bkTitle;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int bkPages) {
        pages = bkPages;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int bkSections) {
        sections = bkSections;
    }
    
    public boolean addPageViaFile( String filename ){
       return true; 
    }
    
    public int getId(){
        return id;
    }
    
    public boolean addPage( NoteBookPage page ){
        mypages.add(page);
        return true;
    }
    
    public void createPage( NoteBookPage page ){
        page.createPage( getId() );
    }
    
    
    public DefaultListModel<NoteBookPage> getModel(){
        setModel();
        return model;
    }
    
    public DefaultListModel<NoteBookPage> updateModel(){
        loadAllPages();
        setModel();
        return model;
    }
    
    public void loadAllPages(){
        mypages.clear();
        Db db = new Db();
        ResultSet pagesResults = db.queryAll("SELECT * FROM pages WHERE book_id="+getId());
        try{
            while(pagesResults.next()){
                NoteBookPage pg = new NoteBookPage(pagesResults);
                addPage(pg);
            }   
        }catch(SQLException e){
           // System.out.println(e.getMessage());
        }
       // db.closeConnetion();
    }
    
    public boolean addPage(String title, String content ){
        NoteBookPage page = new NoteBookPage();
        page.setTitle(title);
        page.setContent(content);
        mypages.add(page);
        return true;
    }
    
    public void setModel(){
        model.clear();
        ArrayList<NoteBookPage> pages = mypages;
        for(int i=0; i<pages.size(); i++){
            model.addElement(pages.get(i));
        }
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String bkDescription) {
         description = bkDescription;
    }


    public void setId(int bookid) {
        id = bookid;
    }
    
   public void addBook(){
       NoteBook.books =+ 1;
   }
   
   public int getBooks(){
       return NoteBook.books;
   }
   
   public void insertBook(){
       Db db = new Db();
       String sql = "INSERT INTO books (book_name, description) values(?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,description);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NoteBook.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
 
    
}
