package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ArrayList<ServerThread> threadList = new ArrayList<>();
    private ServerSocket serverSocket;
    private ServerThread serverThread;
    private Socket socket;
    private boolean running = true;

    public Server(int serverId) throws IOException {
        this.serverSocket = new ServerSocket(serverId);
        serverThread();
    }

    public void serverThread() {
        try{
            while (running) {
                socket = serverSocket.accept();
                serverThread = new ServerThread(socket, threadList);
                threadList.add(serverThread);
                serverThread.start();
            }

        } catch (IOException e) {
            System.out.printf("Error ecorrido: " + e.getStackTrace());
        }

    }

}
