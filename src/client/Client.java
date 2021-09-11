package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String EMPTY_CONDITIONAL = "empty";

    private String name;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ClientThread clientRun;
    private Scanner scanner;
    private String userName = EMPTY_CONDITIONAL;
    private int userOption = 0;
    private String userInput = EMPTY_CONDITIONAL;

    public Client(String ip, int port) throws IOException {
        scanner = new Scanner(System.in);
        socket = new Socket(ip, port);
        clientRun = new ClientThread(socket);
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        startThread();
    }

    public String getName() {
        return name;
    }

    public void startThread(){
        new Thread(clientRun).start();
        try {
            do {
                if (userName.equals(EMPTY_CONDITIONAL)) {
                    System.out.println("Digite su nombre");
                    userInput = scanner.nextLine();
                    userName = userInput;
                    output.writeUTF(userName);

                    if (userInput.equalsIgnoreCase("exit")){
                        break;
                    }
                } else {
                    //String message = ( "(" + userName + ")" + ": ");
                    System.out.println("Seleccione una opcion del mapa");
                    userInput = scanner.nextLine();
                    output.writeObject(new Message(Integer.parseInt(userInput), userName));
                    if (userInput.equals("exit")) {
                        input.close();
                        break;
                    }
                }
            } while (!userInput.equals("exit"));

        } catch (IOException e) {
            System.out.println("Ocurrio un problema en el cliente: " + e.getStackTrace());
        }
    }
}
