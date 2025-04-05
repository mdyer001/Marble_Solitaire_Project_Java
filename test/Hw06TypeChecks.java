import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.hw05.EnglishSolitaireModel;
import cs5004.marblesolitaire.model.hw05.MarbleSolitaireModel;
import cs5004.marblesolitaire.view.MarbleSolitaireTextView;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw06TypeChecks {

  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helper(new EnglishSolitaireModel(),
            rd, ap);
    helper(new EnglishSolitaireModel
                    (3, 3),
            rd, ap);
  }

  private static void helper
          (MarbleSolitaireModel model,
           Readable rd, Appendable ap) {
    new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model,ap),rd);
  }

}
