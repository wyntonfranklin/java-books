/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabooks;

import java.sql.ResultSet;

/**
 *
 * @author shady
 */
public class NoteBookPage extends Page {
    
    private int id;
    private String title;
    private String content;
    private int wordCount;
    private int currentLine;
    private int bookRef;
    
    
    public NoteBookPage(){
        super();
    }
    
    public NoteBookPage( String pageTitle ){
        super(pageTitle);
        title = pageTitle;
    }

    public NoteBookPage(ResultSet column) {
        super(column);
    }
    
    
    
    public void setContentViaFile( String filename ){
        
    }

      
}
