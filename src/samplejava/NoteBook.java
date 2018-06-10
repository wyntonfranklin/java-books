/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejava;

import java.util.ArrayList;
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
        id = BookAdapter.currentId();
        NoteBook.books =+ 1;
    }
    
    public NoteBook( String name, int bkPages, int bkSections ){
        title = name;
        pages = bkPages;
        sections = bkSections;
        id = BookAdapter.currentId();
        NoteBook.books =+ 1;
    }
    
    public NoteBook(){
        mypages =  new ArrayList<>();
        id = BookAdapter.currentId();
        NoteBook.books =+ 1;
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
    
    public boolean addPage( NoteBookPage page ){
        mypages.add(page);
        model.addElement(page);
        return true;
    }
    
    public DefaultListModel<NoteBookPage> getModel(){
        return model;
    }
    
    public boolean addPage(String title, String content ){
        NoteBookPage page = new NoteBookPage();
        page.setTitle(title);
        page.setContent(content);
        this.mypages.add(page);
        return true;
    }
    
    public void listOfPageTitles(){
        ArrayList<NoteBookPage> pages = this.mypages;
        System.out.println("Book Name :" + this.title +"\n");
        for(int i=0; i<pages.size(); i++){
            System.out.println(pages.get(i).getTitle());
        }
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String bkDescription) {
         description = bkDescription;
    }

    public int getId() {
        return id;
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
    
 
    
}
