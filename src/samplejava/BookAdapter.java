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
public class BookAdapter {
    
    public static ArrayList<NoteBook> allbooks = new ArrayList<>();
    public static DefaultListModel<NoteBook> model = new DefaultListModel<>();
    public static int id=1;
    
    public BookAdapter(){
   
    }
    
    public static ArrayList<NoteBook> allbooks(){
        return BookAdapter.allbooks;
    }
    
    public static void addBook( NoteBook book ){
        BookAdapter.allbooks.add( book );
        BookAdapter.addId();
        BookAdapter.model.addElement(book);
        
    }
    
    public static void showAllBookNames(){
        String booknames="";
        for(int i=0; i<=BookAdapter.allbooks.size()-1; i++ ){
            booknames +=  BookAdapter.allbooks.get(i).getTitle() + "\n";
        }
        System.out.println(booknames);
    }
    
    public static DefaultListModel<NoteBook> getModel(){
        return BookAdapter.model;
    }
    
    public static int currentId(){
        return BookAdapter.id;
    }
    
    public static void addId(){
        BookAdapter.id += 1;
    }
    
    
    
}
