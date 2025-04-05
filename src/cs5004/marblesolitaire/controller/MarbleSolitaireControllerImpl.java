package cs5004.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs5004.marblesolitaire.model.hw05.MarbleSolitaireModel;
import cs5004.marblesolitaire.view.MarbleSolitaireView;

/**
 * The class for the controller for the game of Marble Solitaire.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private Readable rd;
  private MarbleSolitaireView view;

  /**
   * Constructor to create the controller implementation.
   * @param model the English Solitaire model.
   * @param view the Marble Solitaire View.
   * @param rd readable.
   * @throws IllegalArgumentException that it cannot be null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable rd) throws IllegalArgumentException {
    if (model == null || view == null || rd == null) {
      throw new IllegalArgumentException("cannot be NULL.");
    }
    this.model = model;
    this.view = view;
    this.rd = rd;
  }

  /**
   * Method for rendering the board and returning an Illegal State Exception if invalid.
   */
  private void renderBoard() {
    try{
      view.renderBoard();
    }
    catch (IOException e) {
      throw new IllegalStateException("This message is Invalid.");
    }
  }

  /**
   * Method for rendering the message and returning an Illegal State Exception if invalid.
   * @param s the string.
   */
  private void renderMessage(String s) {
    try {
      view.renderMessage(s);
    }
    catch (IOException e) {
      throw new IllegalStateException("This message is Invalid.");
    }
  }

  /**
   * Method for retrieving the score as a String.
   */
  private void renderScore() {
    renderMessage("\nScore: " + model.getScore());
  }

  /**
   * Method for determining if the game is over or not.
   */
  private void renderGameOver() {
    renderMessage("\nGame over!\n");
    renderBoard();
    renderMessage("\n" + "Score: " + model.getScore());
  }

  /**
   * Method for reviewing if the input given was valid.
   * @param input the input given.
   * @return true if valid and false if not.
   */
  private boolean validInput(String input) {
    int in;
    try {
      in = Integer.parseInt(input);
    }
    catch (NumberFormatException e) {
      return false;
    }
    return (!(in < 1 || in > model.getBoardSize()));
  }

  /**
   * Method to play the game and call quit and end the game if necessary.
   * @throws IllegalStateException if no more input can be taken in.
   */
  @Override
  public void playGame() throws IllegalStateException {
    this.renderBoard();
    Scanner scan = new Scanner(rd);
    boolean quit = false;
    String value;
    while(!model.isGameOver()) {
      int[] validMove = new int[4];
      int index = 0;
      while (index < 4) {
        if (!scan.hasNext()) {
          throw new IllegalStateException("No more inputs.");
        }
        value = scan.next();
        if (value.equalsIgnoreCase("q")) {
          quit = true;
          break;
        }
        else if (validInput(value)) {
          validMove[index] = Integer.parseInt(value);
          index += 1;
        }
      }
      if (quit) {
        renderMessage("\nQuit Game!");
        renderMessage("\nState of game:\n");
        renderBoard();
        renderScore();
        break;
      }
      try {
        model.move(validMove[0] - 1, validMove[1] - 1, validMove[2] - 1,
                validMove[3] - 1);
        this.renderBoard();
        this.renderScore();
      }
      catch (IllegalArgumentException e) {
        renderMessage("Invalid Move. Play again.");
      }
    }
    if (!quit) {
      this.renderGameOver();
    }
  }
}


