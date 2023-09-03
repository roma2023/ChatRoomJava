
// ClientHandler.java
// Import necessary Java libraries for input/output and networking.
import java.io.*;
import java.net.*;

// Define the ClientHandler class responsible for handling individual client connections.
public class ClientHandler implements Runnable {

    // The client's socket connection.
    private Socket socket;

    // PrintWriter to send messages to the client.
    private PrintWriter out;

    // Constructor to initialize the ClientHandler with a client socket.
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    // The run method is executed when a new thread for this ClientHandler is
    // started.
    @Override
    public void run() {
        try {
            // Create BufferedReader to receive messages from the client.
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create PrintWriter to send messages to the client.
            out = new PrintWriter(socket.getOutputStream(), true);

            // Read the username sent by the client.
            String username = in.readLine();

            // Broadcast a message to inform other clients about the new user joining the
            // chat.
            Server.broadcastMessage(username + " has joined the chat.");

            String message;
            // Continuously receive and broadcast messages from the client.
            while ((message = in.readLine()) != null) {
                Server.broadcastMessage(username + ": " + message); // Broadcast the message.
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions related to input/output.
        } finally {

            Server.removeClient(this); // Remove the client from the active client list.
            Server.broadcastMessage("User disconnected: " + socket); // Inform other clients about disconnection.
            try {
                socket.close(); // Close the client's socket connection.
            } catch (IOException e) {
                e.printStackTrace(); // Handle exceptions related to socket closure.
            }
        }
    }

    // Method to send a message to the client.
    public void sendMessage(String message) {
        out.println(message); // Send the message to the client.
    }
}
