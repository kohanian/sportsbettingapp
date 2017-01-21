import java.io.*;
import java.util.*;

public class TicTacToe {

  private char[][] board;
  private int whoseTurn;
  private String[] players;
  int movesMade;
  final static private char[] pieces = {'X','O'};

  public TicTacToe(String player1, String player2) {

    board = new char[3][3];
    for (int i=0;i < 3; i++)
      for (int j=0; j < 3; j++)
        board[i][j] = '_';
    whoseTurn = 0;
    movesMade = 0;
    players = new String[2];
    players[0] = player1;
    players[1] = player2;
  }

  public boolean Move(int row, int column) {

    if ( (board[row][column] == '_') && inbounds(row,column) ) {
      board[row][column] = pieces[whoseTurn];
      movesMade++;
      return true;
    }
    else
      return false;
  }

  public boolean inbounds(int row, int column) {

    if ((row < 0) || (column < 0))
      return false;
    if ((row > 2) || (column > 2))
      return false;
    return true;
  }

  public void changeturn() {
    whoseTurn = (whoseTurn + 1)%2;
  }

  public String getCurrentPlayer() {
    return players[whoseTurn];
  }

  public void printboard() {

    System.out.println("\t0  1  2");
    for (int i=0; i<3; i++) {
      System.out.print(i+"\t");
      for (int j=0; j<3; j++)
        System.out.print(board[i][j]+"  ");
      System.out.println();
    }
  }

  public char winner() {
    for (int i=0; i<3; i++)
      if (SameArray(board[i]) && board[i][0] != '_')
        return board[i][0];

    for (int i=0; i<3; i++)
      if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && board[0][i] != '_')
         return board[0][i];

    if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
         return board[0][0];

    if ((board[2][0] == board[1][1]) && (board[1][1] == board[0][2]))
         return board[2][0];

    if (movesMade == 9)
      return 'T';

    return '_';

  }

  private static boolean SameArray(char[] word) {

    char check = word[0];
    for (int i=1; i<word.length; i++)
      if (check != word[i])
        return false;
    return true;
  }

  public String whosePiece(char x) {
    for (int i=0; i<2; i++)
      if (x == pieces[i])
        return players[i];
    return "Dummy";
  }

  public static void main(String[] args) throws IOException {

    Scanner stdin = new Scanner(System.in);

    System.out.println("Player #1, enter your name.");
    String name1 = stdin.next();

    System.out.println("Player #2, enter your name.");
    String name2 = stdin.next();

    TicTacToe mygame = new TicTacToe(name1, name2);

    while (mygame.winner() == '_') {

      int r,c;
      boolean done = false;

      do {
	
        mygame.printboard();

        System.out.print(mygame.getCurrentPlayer());            
        System.out.print(", Enter the row(0-2) and column(0-2) ");
	System.out.println("of your move.");

      	r = stdin.nextInt();
      	c = stdin.nextInt();	
        if (!mygame.inbounds(r,c)) 
          System.out.println("Sorry, those are invalid entries.");
        else {
          if (!mygame.Move(r,c))
            System.out.println("Sorry, that square is taken.");
          else
            done = true;
       }  
      } while (!done);

      mygame.changeturn();
    }

    mygame.printboard();
    char win = mygame.winner();

    if (win == 'T')
      System.out.println("Both of you played to a tie.");
    else {
      System.out.print("Congratulations, " + mygame.whosePiece(win));
      System.out.println(", you have won the game.");
    }

  }
}
