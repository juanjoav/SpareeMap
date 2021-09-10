package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String EMPTY_CONDITIONAL = "empty";

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private ClientThread clientRun;
    private Scanner scanner;
    private String userName = EMPTY_CONDITIONAL;
    private String userInput = EMPTY_CONDITIONAL;


}
