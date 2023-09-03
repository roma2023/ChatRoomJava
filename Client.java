
// Client.java
// Import necessary Java libraries for networking and input/output.
import java.io.*;
import java.net.*;
import java.util.Scanner;

// Define the Client class responsible for connecting to the server and sending/receiving messages.
public class Client {
    public static void main(String[] args) {
        try (
                // Create a socket connection to the server on localhost and port 15440.
                Socket socket = new Socket("localhost", 15440);

                // Create PrintWriter to send messages to the server.
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Create BufferedReader to receive messages from the server.
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Create Scanner to read input from the user.
                Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter a username.
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            out.println(username); // Send the username to the server.

            // Create a separate thread for receiving and displaying incoming messages.
            Thread messageReceiver = new Thread(() -> {
                try {
                    String message;

                    while ((message = in.readLine()) != null) {
                        System.out.println(message); // Display incoming messages.
                    }

                } catch (IOException e) {
                    e.printStackTrace(); // Handle exceptions related to message receiving.
                }
            });
            messageReceiver.start(); // Start the message receiver thread.

            // Continuously read user input and send messages to the server.
            while (true) {
                String message = scanner.nextLine();
                out.println(message); // Send user's message to the server.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions related to socket and input/output.
        }
    }
}
