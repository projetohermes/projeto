package externo;

import java.io.*;
import java.util.*;

public class Config {

    private String numIP;

    public Config() {
        Properties prop = new Properties();
        try {
            numIP = "192.168.1.104";
        } catch (Exception e) {
            e.printStackTrace();
            numIP = "";
        }
    }

    public String getIP() {
        return numIP;
    }
}
