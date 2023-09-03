import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatRoomGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Define GUI components and layout
        TextArea chatTextArea = new TextArea();
        TextField messageTextField = new TextField();
        Button sendButton = new Button("Send");

        VBox chatLayout = new VBox(chatTextArea, messageTextField, sendButton);
        Scene scene = new Scene(chatLayout, 400, 300);

        primaryStage.setTitle("Chat Room");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Add event handlers for sending messages
        sendButton.setOnAction(e -> {
            String message = messageTextField.getText();
            // Send the message to the server and update the chatTextArea
            chatTextArea.appendText("You: " + message + "\n");
            // Clear the messageTextField
            messageTextField.clear();
        });

        // Connect to the server and handle incoming messages
        // Implement your chat logic here
    }

    public static void main(String[] args) {
        launch(args);
    }
}
