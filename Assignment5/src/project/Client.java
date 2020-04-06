package project;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    private static String input;
    int port;
    String id;
    String address;


    public Client() {
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connection_start(5000);
    }


    public void connection_start(int port) throws IOException {
        //create a socket
        Socket socket = new Socket("127.0.0.1", port);


        //set up the input and output
        Scanner my_input = new Scanner(System.in);
        DataOutputStream my_output = new DataOutputStream(socket.getOutputStream());
        DataInputStream message_from_server = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


        //check if connection success
        if (socket.isConnected()) {
            System.out.println("connection success");

            while (!input.equals("quit")) {
                //take user input
                input = my_input.nextLine();
                my_output.writeUTF(input);
                //print out what the server send
                System.out.println(message_from_server.readUTF());
            }
            //disconnected
            System.out.println("Connection End!\nBye Bye");

        } else {
            System.out.println("connection fail");
        }

        //close the connection
        socket.close();

    }
}
