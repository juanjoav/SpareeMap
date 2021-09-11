package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientThread extends Thread{

    private Socket socket;
    private ObjectInputStream input;
    // private DataOutputStream output;

    public ClientThread(Socket s) throws IOException {
        this.socket = s;

    }

    @Override
    public void run() {
        try {
            this.input = new ObjectInputStream(this.socket.getInputStream());
            try {
                while(true) {
                    Message message = (Message) input.readObject();
                    String response = message.getMessage();

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
