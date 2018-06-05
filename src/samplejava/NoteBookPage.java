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
        
    }
    
    public NoteBookPage( String title ){
        this.title = title;
    }
    
    public NoteBookPage(String title, String filename ){
        this.title = title;
    }
    
    public void setContentViaFile( String filename ){
        
    }

    @Override
    public void setCurrentLine(int currentLine) {
        super.setCurrentLine(currentLine); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrentLine() {
        return super.getCurrentLine(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWordCount(int wordCount) {
        super.setWordCount(wordCount); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWordCount() {
        return super.getWordCount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setContent(String content) {
        super.setContent(content); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getContent() {
        return super.getContent(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitle() {
        return super.getTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void openFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
