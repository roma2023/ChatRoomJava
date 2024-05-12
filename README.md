# Group Chat Room with Java

This repository contains a multi-threaded group chat room application built in Java using socket programming and JavaFX. The server manages client connections and facilitates message broadcasting, while clients connect and interact using a simple graphical user interface. 

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Files Overview](#files-overview)
- [Contributing](#contributing)

## Features
- **Multi-Client Support:** Accepts multiple client connections.
- **Message Broadcasting:** Allows clients to broadcast messages to each other.
- **Graphical User Interface (GUI):** JavaFX GUI for client chat interaction.
- **Thread-Based Management:** Manages client connections via individual threads.

## Requirements
- Java Development Kit (JDK) 8 or higher
- JavaFX (for GUI-based chat client)

## Setup Instructions
1. **Clone the Repository:**  
    ```bash
    git clone <repository_url>
    cd <repository_directory>
    ```

2. **Build & Compile:**
   - Ensure your environment is set up with JavaFX.
   - Compile the project using your favorite Java IDE or manually via the terminal.

3. **Run the Server:**
   - Execute the `Server` class to start the chat server:
   ```bash
   java Server
   ```
4. **Run the Client:**
    - Execute either the Client or ChatRoomGUI class to start a text-based or graphical chat client, respectively:
  
    ```bash
    java Client
    ```
    or
    ```bash
    java ChatRoomGUI
    ```
## Usage
- **Text Client:** The `Client` program will prompt for a username and start interacting with other connected clients via console input.
- **Graphical Client:** The `ChatRoomGUI` provides a user-friendly GUI for typing and reading messages.

## Files Overview
- **Server.java:** Manages client connections and broadcasts messages.
- **Client.java:** Connects to the server, sends, and receives messages via console input.
- **ClientHandler.java:** Handles communication for individual clients.
- **ChatRoomGUI.java:** Provides a JavaFX-based graphical chat interface.
- **SetUp.java:** A setup class for initializing JavaFX.

## Contributing
Contributions are welcome! If you find any issues or have suggestions, feel free to open a pull request or submit an issue.
