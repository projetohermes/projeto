
package controller;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Protocolo;


public class CommClienteToServidor extends Thread{
    
   private ObjectOutputStream oos;
   private ObjectInputStream ois;
   private Socket socketCliente;
   private Cliente clienteEmissor;
      
   public CommClienteToServidor(int porta){
       super();
        try {
            socketCliente = new Socket("hostmane", porta);
            oos = new ObjectOutputStream(socketCliente.getOutputStream());
            ois = new ObjectInputStream(socketCliente.getInputStream());
        } catch (IOException ex) {
        }
        clienteEmissor = null;
   }
   public void OpenComm()
   {
        try {
            oos.writeObject((Object)null);
            try {
                ois.readObject();
            } catch (ClassNotFoundException ex) {
            }
            oos.writeObject(new Protocolo(11, null, clienteEmissor, null));
        } catch (IOException e) {
        }
   }
   
   
   public void enviaMensagem( String msg, ArrayList<Cliente> clienteDestinatario, Cliente clienteEmissor){
       this.clienteEmissor = clienteEmissor;
       Protocolo protocoloSend = new Protocolo(11, msg, this.clienteEmissor,clienteDestinatario);
       try {
           oos.writeObject(protocoloSend);
       } catch (Exception e) {
       }
   }
   
   public void CloseComm(){
       Protocolo protocoloClose = new Protocolo(33, null, clienteEmissor, null);
       try {
           oos.writeObject(protocoloClose);
           socketCliente.close();
           
       } catch (Exception e) {
       }
       
   }            
} 
    

