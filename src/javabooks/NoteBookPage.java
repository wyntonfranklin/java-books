/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejava;

/**
 *
 * @author shady
 */
public class NoteBookPage extends Page {
    
    private String title;
    private String content;
    private int wordCount;
    private int currentLine;
    
    
    public NoteBookPage(){
        super();
    }
    
    public NoteBookPage( String pageTitle ){
        super(pageTitle);
        title = pageTitle;
    }
    
    public void setContentViaFile( String filename ){
        
    }

      
}
