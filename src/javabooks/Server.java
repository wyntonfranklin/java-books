/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabooks;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

/**
 *
 * @author shady
 */
public class Server extends Thread{
    
    private ServerSocket server; // server socket
    private Socket connection;
    private OutputStream output; // output stream to client
    private InputStream input; // input stream from client
    private int counter = 1; // counter of number of connections
    
    public Server(){
        
    }
    
    @Override
    public void run(){
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket( 12345, 100 ); // create ServerSocket
            while ( true )
            {
                try
                {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } // end try
                catch ( EOFException eofException )
                {
                   // displayMessage( "\nServer terminated connection" );
                    System.out.println(eofException.getMessage());
                } // end catch
                finally
                {
                   closeConnection(); // close connection
                   ++counter;
                } // end finally
            } // end while
        } // end try
        catch ( IOException ioException )
        {
            ioException.printStackTrace();
        } // end catch
    }
    
    private void waitForConnection() throws IOException{
          System.out.println("Waiting for connection\n");
       // displayMessage( "Waiting for connection\n" );
        connection = server.accept(); // allow server to accept connection
         System.out.println( "Connection " + counter + " received from: " +
        connection.getInetAddress().getHostName() );
    }
    
    private void getStreams() throws IOException{
        // set up output stream for objects
        output = connection.getOutputStream();
        output.flush(); // flush output buffer to send header information
        // set up input stream for objects
        input = connection.getInputStream();
        System.out.println( "\nGot I/O streams\n" );
    } // end method getStreams
    
    
    private void processConnection() throws IOException{
        String message = "Connection successful";
        sendData( message ); // send connection successful message
        do // process messages sent from client
        {
            try // read message and display it
            {
                 BufferedReader br = new BufferedReader(new InputStreamReader(input));
                while ((message = br.readLine()) != null) {
                    System.out.println("Message received:" + message);
                    message += '\n';
                    output.write(message.getBytes());
                 }
            } // end try
            catch ( IOException ex )
            {
              //  displayMessage( "\nUnknown object type received" );
            } // end catch
        } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
    } // end method processConnection
    
    
    private void closeConnection(){
        try
        {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } // end try
        catch ( IOException ioException )
        {
            ioException.printStackTrace();

        } // end catch
    }
    
    private void sendData( String message ){
        
    }

    
    
}
