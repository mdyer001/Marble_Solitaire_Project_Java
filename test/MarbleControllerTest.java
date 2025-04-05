import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.hw05.EnglishSolitaireModel;
import cs5004.marblesolitaire.model.hw05.MarbleSolitaireModel;
import cs5004.marblesolitaire.view.MarbleSolitaireTextView;
import cs5004.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test class for the marble solitaire controller.
 */
public class MarbleControllerTest {

  /**
   * Creates the internal interface for interactions.
   */
  interface Interaction {
    void apply(StringBuilder in, StringBuilder out);

  }

  /**
   * creates the method for calling inputs.
   * @param in the input.
   * @return the input and output.
   */
  private static Interaction inputs (String in) {
    return (input, output) -> input.append(in);
  }

  /**
   * creates the method for printing the interactions.
   * @param lines of the string.
   * @return the string.
   */
  private static Interaction prints(String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line).append("\n");
      }
    };
  }

  /**
   * Listing the games that will be played with different scenarios.
   */
  private MarbleSolitaireModel game1 = new EnglishSolitaireModel();
  private MarbleSolitaireModel game2 = new EnglishSolitaireModel(5);
  private MarbleSolitaireModel game3 = new EnglishSolitaireModel(0,3);
  private MarbleSolitaireModel game4 = new EnglishSolitaireModel(3,3,6);


  /**
   * Creating a class for testing the Appendable.
   */
  private class AppendableTest implements Appendable {

    /**
     * Calling an appendable.
     * @param csq the character sequence.
     *         The character sequence to append.  If {@code csq} is
     *         {@code null}, then the four characters {@code "null"} are
     *         appended to this Appendable.
     *
     * @return and IO Exception if failed.
     * @throws IOException if Appendable fails.
     */
    @Override
    public Appendable append(CharSequence csq) throws IOException {
      throw new IOException("Failed output");
    }

    /**
     * Calling an appendable.
     * @param csq the character sequence of the appendable.
     *         The character sequence from which a subsequence will be
     *         appended.  If {@code csq} is {@code null}, then characters
     *         will be appended as if {@code csq} contained the four
     *         characters {@code "null"}.
     *
     * @param start the beginning of the string.
     *         The index of the first character in the subsequence.
     *
     * @param end the end of the string.
     *         The index of the character following the last character in the
     *         subsequence.
     *
     * @return IO Exception if failed input.
     * @throws IOException if failed input.
     */
    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
      throw new IOException("Failed output");
    }

    /**
     * Calling an appendable.
     * @param c the character in the sequence.
     *         The character to append.
     *
     * @return An IO Exception.
     * @throws IOException if output failed.
     */
    @Override
    public Appendable append(char c) throws IOException {
      throw new IOException("Failed output");
    }

    /**
     * String to test the controller using the view, model, and controller.
     * @param model the model from English Solitaire Model.
     * @param interactions the interactions of the controller.
     * @return Illegal State Exception.
     */
    private String testController(MarbleSolitaireModel model, Interaction... interactions) {

      StringBuilder actualOutput = new StringBuilder();
      actualOutput.setLength(0);
      StringBuilder fakeInput = new StringBuilder();
      StringBuilder expectedOutput = new StringBuilder();
      for (Interaction interaction : interactions) {
        interaction.apply(fakeInput, expectedOutput);
      }
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, actualOutput);
      StringReader input = new StringReader(fakeInput.toString());
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model,view,input);

      try {
        controller.playGame();
      }
      catch (IllegalStateException e){

      }
      return actualOutput.toString();

    }

  }

  /**
   * Test the readable cannot be null.
   * @throws IllegalArgumentException if null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() throws IllegalArgumentException {
    StringBuilder out = new StringBuilder();
    StringBuilder fakeInput = new StringBuilder();
    StringReader input = new StringReader(fakeInput.toString());
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(null,
            view,input);
    controller.playGame();
  }

  /**
   * Test the Appendable is not null.
   * @throws IllegalArgumentException if null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() throws IllegalArgumentException {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(null,
            view,in);
    controller.playGame();
  }

  /**
   * Test the appendable and readable cannot be null at the same time.
   * @throws IllegalArgumentException if null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendableandReadable() throws IllegalArgumentException {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(null,
            view,null);
    controller.playGame();
  }

  /**
   * Test the msg and checks if null.
   * @throws IllegalArgumentException if null.
   */
  @Test
  public void testNullMsg() throws IllegalArgumentException {
    StringBuilder out = new StringBuilder();
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Reader in = new StringReader("");
    String msg = "cannot be NULL.";
    String msgModel = "Provided cannot be read in.";

    try {
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model, view, null);
      controller.playGame();
    } catch (IllegalArgumentException e) {
      assertEquals(msg, e.getMessage());
      assertNotEquals("hey", e.getMessage());

    }
  }

  /**
   * Test if there is any following input.
   * @throws IllegalStateException if no next input.
   */
  @Test
  public void testNoNextMsg() throws IllegalStateException{
    Reader input = new StringReader(" 3");
    StringBuilder output = new StringBuilder();
    String msg2 = "No next input";
  }

  /**
   * Creating a string to test the controller.
   * @param model the English Solitaire model test.
   * @param interactions the interactions of the controller.
   * @return Illegal State Exception.
   */
  private String testController(MarbleSolitaireModel model, Interaction... interactions) {

    StringBuilder actualOutput = new StringBuilder();
    actualOutput.setLength(0);
    StringBuilder fakeInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();
    for (Interaction interaction : interactions) {
      interaction.apply(fakeInput, expectedOutput);
    }
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, actualOutput);
    StringReader input = new StringReader(fakeInput.toString());
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model,view,input);

    try {
      controller.playGame();
    }
    catch (IllegalStateException e){

    }
    return actualOutput.toString();

  }

  /**
   * Test if the test Quits without input.
   */
  @Test
  public void testQuitWithoutInput() {
    String expected = "  OOO  \n"
            + "  OOO  \n"
            + "OOOOOOO\n"
            + "OOO_OOO\n"
            + "OOOOOOO\n"
            + "  OOO  \n"
            + "  OOO  \n\n"
            + "Quit Game!\n"
            + "State of game:\n"
            + "  OOO  \n"
            + "  OOO  \n"
            + "OOOOOOO\n"
            + "OOO_OOO\n"
            + "OOOOOOO\n"
            + "  OOO  \n"
            + "  OOO  \n\n"
            + "Score: 32";

    assertEquals(expected, testController(game1, inputs(" q"),
            prints(expected)));
  }





}

