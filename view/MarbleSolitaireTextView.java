package cs5004.marblesolitaire.view;

import java.io.IOException;

import cs5004.marblesolitaire.model.hw05.MarbleSolitaireModelState;

/**
 * Class to construct the board view of Marble Solitaire.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private MarbleSolitaireModelState model;

  private Appendable out;


  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    this.model = model;
    this.out = System.out;
  }
  /**
   * constructor with exactly one argument of MarbleSolitaireModelState type.
   * This constructor can be called with the model object that provides this view all.
   * The methods it needs to query the model and print the board (but not make moves).
   * The constructor should throw an IllegalArgumentException if the provided model is null.
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable out) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    this.model = model;
    this.out = out;
  }



  /**
   * The toString method of this class returns a String which may be used to print the board.
   * The details of the output are described in the Javadoc for this method.
   * In the provided MarbleSolitaireView interface.
   */

  public String toString() {
    String str = "";
    for (int i = 0; i < this.model.getBoardSize(); i++) {
      for (int j = 0; j < this.model.getBoardSize(); j++) {
        if (this.model.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Marble) {
          str = str + "O";
        } else if (this.model.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Empty) {
          str = str + "_";
        } else if (this.model.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Invalid) {
          str = str + " ";
        }
      }
      str = str + "\n";
    }
    return str;

  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    String fullBoard = this.toString();
    this.out.append(toString());
  }

  /**
   * Render a specific message to the provided data destination.
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.out.append(message);
  }


}
