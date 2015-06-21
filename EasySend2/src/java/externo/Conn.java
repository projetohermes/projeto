package externo;

import java.io.*;
import java.net.*;

public class Conn {

    private Socket conn;
    private BufferedReader input;
    private DataOutputStream output;
    private String ip;

    public Conn() {
        Config cf = new Config();
        ip = cf.getIP();
        try {
            conn = new Socket(getIp(), 5038);
            input = new BufferedReader(new InputStreamReader(getConn().getInputStream()));
            output = new DataOutputStream(getConn().getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getConn() {
        return conn;
    }

    
    public void setConn(Socket conn) {
        this.conn = conn;
    }

    
    public BufferedReader getInput() {
        return input;
    }

    
    public void setInput(BufferedReader input) {
        this.input = input;
    }

   
    public DataOutputStream getOutput() {
        return output;
    }

   
    public void setOutput(DataOutputStream output) {
        this.output = output;
    }

    
    public String getIp() {
        return ip;
    }

   
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void mandaComando(String msg) throws IOException {

        output.writeBytes(msg);

    }

    public String recebeEvento() throws IOException {

        return input.readLine();

    }
}
