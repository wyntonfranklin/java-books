/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejava;

import java.util.ArrayList;

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
    

    public NoteBook(String name){
        this.title = name;
        this.mypages =  new ArrayList<>();
        this.id = BookAdapter.currentId();
    }
    
    public NoteBook( String name, int pages, int sections ){
        this.title = name;
        this.pages = pages;
        this.sections = sections;
        this.id = BookAdapter.currentId();
    }
    
    public NoteBook(){
        this.mypages =  new ArrayList<>();
        this.id = BookAdapter.currentId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }
    
    public boolean addPageViaFile( String filename ){
       return true; 
    }
    
    public boolean addPage( NoteBookPage page ){
        this.mypages.add(page);
        return true;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
 
    
}
