package client;

import java.io.Serializable;

public class Message implements Serializable {

    private String message;
    private String userName;
    private int option;

    public Message(String message, String userName) {
        this.message = message;
        this.userName = userName;
    }

    public Message(int option, String userName) {
        this.option = option;
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return userName;
    }

    public int getOption() {
        return option;
    }
}
