package server;

import client.Message;

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

    public String getUsername() {
        return username;
    }

    public void setUserId() {
        try {
            this.username =  input.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message received = (Message)input.readObject();
                switch (received.getOption()) {
                    case OPTION_ONE:
                        //String message =
                        //Metodo logica con su retorno :D
                        printResults(new Message("aqui va la primera", received.getUserName()));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error ocurrido " + e.getStackTrace());
        }
    }

    private void printResults(Message results){
        for( ServerThread sT: threadList) {
            try {
                if ( results.getUserName().equals(sT.getUsername())){
                    System.out.println(sT.getUsername());
                    sT.output.writeObject(new Message(results.getMessage(), sT.getUsername()));
                    System.out.println(results.getMessage());
                }
            } catch (IOException e) {
                System.out.println("Error ocurrido " +e.getStackTrace());
            }
        }
    }
}
