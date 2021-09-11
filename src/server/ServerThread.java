package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{

    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String username;

    public static final int OPTION_ONE = 1;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) throws IOException {
        this.socket = socket;
        this.threadList = threads;
        input = new ObjectInputStream(socket.getInputStream());
        output = new ObjectOutputStream(socket.getOutputStream());
        setUserId();
    }

    public void setUserId() {
        try {
            this.username = (String) input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                int option = input.readInt();
                switch (option) {
                    case OPTION_ONE:
                        //String message =
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error ocurrido " + e.getStackTrace());
        }
    }

    private void printResults(String results){

    }
}
