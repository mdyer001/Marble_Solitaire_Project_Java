package cs5004.marblesolitaire.controller;

/**
 * This interface is created to implement the Marble Solitaire Controller.
 */
public interface MarbleSolitaireController {


  /**
   * Plays a new game of Marble Solitaire.
   * @throws IllegalStateException if the controller is unable to successfully read input
   * or transmit output.
   */
  void playGame();
}
