package cs5004.marblesolitaire.model.hw05;

import cs5004.marblesolitaire.model.hw05.MarbleSolitaireModel;

/**
 * Class file to create the English Marble Solitaire game.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {
  private int armThickness;
  private int sRow;
  private int sCol;
  private SlotState[][] board;

  /**
   * The first constructor should take no parameters.
   * Initialize the game board as shown above (arm thickness 3 with the empty slot at the center).
   */
  public EnglishSolitaireModel() {
    this.sRow = 3;
    this.sCol = 3;
    this.armThickness = 3;
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j =  0; j < this.getBoardSize(); j++) {
        if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        }
        else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    this.board[this.sRow][this.sCol] = SlotState.Empty;
  }

  /**
   * Second constructor initialize the game board so that the arm thickness is 3.
   * The empty slot is at the position (sRow, sCol).
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   * @throws IllegalArgumentException returns invalid if the empty cell cannot be placed.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.armThickness = 3;
    if (this.notValidPosition(sRow,sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position" + sRow + sCol);
    }
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j =  0; j < this.getBoardSize(); j++) {
        if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        }
        else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    this.board[this.sRow][this.sCol] = SlotState.Empty;
  }

  /**
   * Third constructor that initializes the game board with the empty slot in the middle.
   * @param armThickness the arm thickness of the board.
   * @throws IllegalArgumentException if the arm thickness is not a positive number.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("the thickness is not a positive odd number.");
    }
    if (armThickness < 0) {
      throw new IllegalArgumentException("The thickness has to be positive.");
    }
    this.armThickness = armThickness;
    this.sRow = (this.getBoardSize() - 1) / 2;
    this.sCol = (this.getBoardSize() - 1) / 2;
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j =  0; j < this.getBoardSize(); j++) {
        if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        }
        else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    this.board[this.sRow][this.sCol] = SlotState.Empty;
  }


  /**
   * Fourth constructor taking the arm thickness, row and column to create the board.
   * @param armThickness the arm thickness of the board.
   * @param sRow the row of the empty cell.
   * @param sCol the column of the empty cell.
   * @throws IllegalArgumentException if the arm thickness is not positive or the cell is invalid.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.armThickness = armThickness;
    if (this.notValidPosition(sRow,sCol)) {
      throw new IllegalArgumentException("Invalid empty cell.");
    }
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness must be an odd number");
    }
    if (armThickness < 0) {
      throw new IllegalArgumentException("Arm thickness must be a positive number");
    }
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j =  0; j < this.getBoardSize(); j++) {
        if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j <= ((this.getBoardSize() - armThickness) / 2) - 1) {
          this.board[i][j] = SlotState.Invalid;
        } else if (i >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
                j >= ((this.getBoardSize() - armThickness) / 2) + armThickness) {
          this.board[i][j] = SlotState.Invalid;
        }
        else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
    this.board[this.sRow][this.sCol] = SlotState.Empty;


  }

  /**
   * Function to provide the board size.
   * @return the board size.
   */
  public int getBoardSize() {
    return 3 * this.armThickness - 2;
  }

  /**
   * Function to make the move and change the board appropriately.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0).
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0).
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0).
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0).
   * @throws IllegalArgumentException if the move cannot be made.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow >= 3 * armThickness - 2 || fromCol >= 3 * armThickness - 2
            || toRow >= 3 * armThickness - 2 || toCol >= 3 * armThickness - 2
            || fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
      throw new IllegalArgumentException("Move is invalid, try again.");
    }
    if (canMoveUp(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow - 1][fromCol] = SlotState.Empty;
      board[fromRow - 2][fromCol] = SlotState.Marble;
    } else if (canMoveDown(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow + 1][fromCol] = SlotState.Empty;
      board[fromRow + 2][fromCol] = SlotState.Marble;
    } else if (canMoveLeft(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow][fromCol - 1] = SlotState.Empty;
      board[fromRow][fromCol - 2] = SlotState.Marble;
    } else if (canMoveRight(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow][fromCol + 1] = SlotState.Empty;
      board[fromRow][fromCol + 2] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("the move attempt cannot be made, try again.");
    }

  }

  /**
   * The game over function returns true when the game is over, false if not.
   * @return true or false if game is over.
   */
  @Override
  public boolean isGameOver() {
    int invalid_section_num = (this.getBoardSize() - armThickness) / 2;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (!this.notValidPosition(i,j)) {
          if (canMoveUp(i, j, i - 2, j) && i - 2 >= 0) {
            return false;
          } else if (canMoveDown(i, j, i + 2, j) && i + 2 <= this.getBoardSize()) {
            return false;
          } else if (canMoveLeft(i, j, i, j - 2) && j - 1 >= 0) {
            return false;
          } else if (canMoveRight(i, j, i, j + 2) && j + 2 <= this.getBoardSize()) {
            return false;
          }
        }
      }
    }
    return true;
  }


  /**
   * Returns the game state of the board providing a toString of the board.
   * @return a toString of the board.
   */
  public String getGameState() {
    String str = "";
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (isOccupied(board[i][j])) {
          str = str + "O";
        } else if (isEmpty(board[i][j])) {
          str = str + "_";
        } else if (isInvalid(board[i][j])) {
          str = str + " ";
        }
      }
      str = str + "\n";
    }
    return str;
  }

  /**
   * Provides the score of the game.
   * @return the score of the game as an int.
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (isOccupied(board[i][j])) {
          score = score + 1;
        }
      }
    }
    return score;
  }


  /**
   * Provides the slot that the position is at.
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return the sought position.
   */
  public SlotState getSlotAt(int row, int col) {
    if (row >= this.getBoardSize() || col >= this.getBoardSize()
            || row < 0 || col < 0) {
      throw new IllegalArgumentException("Move is invalid, try again.");
    }
    return board[row][col];

  }

  /**
   * Helper function to show if the position is occupied.
   * @param piece if the position is Marble, Empty or Invalid.
   * @return true if occupied and false if not.
   */
  private boolean isOccupied(SlotState piece) {
    return (piece == SlotState.Marble);
  }

  /**
   * Helper function to show if the position is Empty.
   * @param piece if the position is Marble, Empty or Invalid.
   * @return true if occupied and false if not.
   */
  private boolean isEmpty(SlotState piece) {
    return (piece == SlotState.Empty);
  }

  /**
   * Helper function to show if the position is Invalid.
   * @param piece if the position is Marble, Empty or Invalid.
   * @return true if occupied and false if not.
   */
  private boolean isInvalid(SlotState piece) {
    return (piece == SlotState.Invalid);
  }

  /**
   * Function to determine if the position sought is invalid.
   * @param row the row of the position sought.
   * @param col the column of the position sought.
   * @return true if it is not valid and false if it is valid.
   */
  private boolean notValidPosition(int row, int col) {
    return ((row <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
            col <= ((this.getBoardSize() - armThickness) / 2) - 1)
            || (row <= ((this.getBoardSize() - armThickness) / 2) - 1 &&
            col >= ((this.getBoardSize() - armThickness) / 2) + armThickness)
            || (row >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
            col <= ((this.getBoardSize() - armThickness) / 2) - 1)
            || (row >= ((this.getBoardSize() - armThickness) / 2) + armThickness &&
            col >= ((this.getBoardSize() - armThickness) / 2) + armThickness));
  }

  /**
   * Function to determine if the piece can move up.
   * @param fromRow the row the piece is at.
   * @param fromCol the column the piece is at.
   * @param toRow the desired row.
   * @param toCol the desired column.
   * @return true if the marble can move up and false if not.
   */
  private boolean canMoveUp(int fromRow, int fromCol, int toRow, int toCol) {
    if (notValidPosition(fromRow, fromCol)) {
      return false;
    }
    else if (notValidPosition(toRow, toCol)) {
      return false;
    } else if (fromRow <= 1) {
      return false;
    } else {
      return (fromRow - 2 == toRow) && (fromCol == toCol) &&
              (board[fromRow][fromCol] == SlotState.Marble) &&
              (board[fromRow - 1][fromCol] == SlotState.Marble) &&
              (board[fromRow - 2][fromCol] == SlotState.Empty);
    }

  }

  /**
   * Function to determine if the piece can move down.
   * @param fromRow the row the piece is at.
   * @param fromCol the column the piece is at.
   * @param toRow the desired row.
   * @param toCol the desired column.
   * @return true if the marble can move down and false if not.
   */
  private boolean canMoveDown(int fromRow, int fromCol, int toRow, int toCol) {
    if (notValidPosition(fromRow, fromCol)) {
      return false;
    } else if (notValidPosition(toRow, toCol)) {
      return false;
    }
    else if (fromRow >= this.getBoardSize() - 2) {
      return false;
    }
    else {
      return (fromRow + 2 == toRow) && (fromCol == toCol) &&
              (board[fromRow][fromCol] == SlotState.Marble) &&
              (board[fromRow + 1][fromCol] == SlotState.Marble) &&
              (board[fromRow + 2][fromCol] == SlotState.Empty);
    }
  }

  /**
   * Function to determine if the piece can move left.
   * @param fromRow the row the piece is at.
   * @param fromCol the column the piece is at.
   * @param toRow the desired row.
   * @param toCol the desired column.
   * @return true if the marble can move left and false if not.
   */
  private boolean canMoveLeft(int fromRow, int fromCol, int toRow, int toCol) {
    if (notValidPosition(fromRow, fromCol)) {
      return false;
    } else if (notValidPosition(toRow, toCol)) {
      return false;
    }
    else if (fromCol <= 1){
      return false;
    }
    else {
      return (fromRow == toRow) && (fromCol - 2 == toCol) &&
              (board[fromRow][fromCol] == SlotState.Marble) &&
              (board[fromRow][fromCol - 1] == SlotState.Marble) &&
              (board[fromRow][fromCol - 2] == SlotState.Empty);
    }
  }

  /**
   * Function to determine if the piece can move right.
   * @param fromRow the row the piece is at.
   * @param fromCol the column the piece is at.
   * @param toRow the desired row.
   * @param toCol the desired column.
   * @return true if the marble can move right and false if not.
   */
  private boolean canMoveRight(int fromRow, int fromCol, int toRow, int toCol) {
    if (notValidPosition(fromRow, fromCol)) {
      return false;
    } else if (notValidPosition(toRow, toCol)) {
      return false;
    } else if (fromCol >= this.getBoardSize() - 2) {
      return false;
    } else {
      return (fromRow == toRow) && (fromCol + 2 == toCol) &&
              (board[fromRow][fromCol] == SlotState.Marble) &&
              (board[fromRow][fromCol + 1] == SlotState.Marble) &&
              (board[fromRow][fromCol + 2] == SlotState.Empty);
    }


  }



}
