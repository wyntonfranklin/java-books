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
public class Page {
    
    private String title;
    private String content;
    private int wordCount;
    private int currentLine;
    

    public Page(){
        
    }
    
    public Page(String pageTitle){
        title = pageTitle;
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
    
    public void createTextFile(){
        
    }
    
    
    
}