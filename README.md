# Marble Solitaire Game - Java

## Project Overview

This project implements the classic **Marble Solitaire** game in Java. The game involves a single player who aims to clear the board by jumping marbles over each other into empty spaces, ultimately ending with just one marble left on the board. The game is controlled via the command line, with the user providing input for the moves.

The project follows the **Model-View-Controller (MVC)** architecture:
- **Model**: Represents the game state and the game logic.
- **View**: Handles rendering the board and displaying messages.
- **Controller**: Coordinates the interaction between the model and the view, managing user input and game logic.

## Features

- **Game Setup**: Start the game with the default board configuration for the English Solitaire variant.
- **Valid Moves**: Players can make valid moves by jumping a marble over an adjacent one into an empty space.
- **Quit Game**: The player can quit the game at any time by entering "q".
- **Game Over**: The game ends when no more valid moves are available, and the player's score is displayed.
- **Score Tracking**: The score is displayed during the game and at the end, showing the number of remaining marbles.

## Technology Stack

- **Programming Language**: Java
- **Design Pattern**: Model-View-Controller (MVC)

## Installation

To set up and run the application locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mdyer001/Marble_Solitaire_Project_Java.git
   cd Marble_Solitaire_Project_Java
