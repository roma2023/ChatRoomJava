
// Server.java
// Import necessary Java libraries for networking and collections.
import java.io.*;
import java.net.*;
import java.util.*;

// Define the Server class responsible for managing client connections.
public class Server {
    // Define the port number that clients will connect to.
    private static final int PORT = 15440;

    // Create a set to store active client handlers.
    private static Set<ClientHandler> clients = new HashSet<>();

    // The main method that starts the server and listens for client connections.
    public static void main(String[] args) {
        try (ServerSocket listenSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running..."); // Print a message to indicate server startup.
            while (true) {
                // Accept a new client connection.
                Socket clientSocket = listenSocket.accept();
                System.out.println("New client connected: " + clientSocket); // Print client connection information.

                // Create a new client handler for the connected client.
                ClientHandler clientHandler = new ClientHandler(clientSocket);

                // Add the client handler to the set of active clients.
                clients.add(clientHandler);

                // Start a new thread to handle communication with the client.
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print any exceptions that occur during server operation.
        }
    }

    // Broadcast a message to all connected clients.
    public static void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    // Remove a client handler from the set of active clients.
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}
