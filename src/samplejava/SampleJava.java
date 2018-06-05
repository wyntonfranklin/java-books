/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejava;

import javax.swing.JFrame;

/**
 *
 * @author shady
 */
public class SampleJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoteBookFrame frame = new NoteBookFrame();
        frame.setTitle("Books");
        frame.setVisible(true);
       // new NoteBookFrame();
       
     // NoteBook note = createNewNoteBook();
     // NoteBookPage page = createPage();
     // note.addPage(page);
     // note.listOfPageTitles();
      
        
    }
    
    static NoteBook createNewNoteBook(){
        NoteBook note = new NoteBook();
        note.setTitle("hello my new notebook");
        return note;
    }
    
    static NoteBookPage createPage(){
        NoteBookPage page = new NoteBookPage();
        page.setTitle("My First Notebook Page");
        page.setContent("This is my first notebook page");
        return page;
    }
    
}
