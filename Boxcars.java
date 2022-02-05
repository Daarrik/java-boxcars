import java.util.Scanner;

public class Boxcars {

  private PairOfDice dice;
  int computerScore;
  int humanScore;
  String humanName;

  public Boxcars() {
    // Initialization of instance variables happens in method init
  }

  public void init(String name) {
    dice = new PairOfDice();
    computerScore = 0;
    humanScore = 0;
    humanName = name;
  }

  public void playGame() {
    boolean finished = false;

    while (!finished) {

      // Computer turn
      turn(true);
      printScore();
      pressEnter();

      // Human turn
      turn(false);
      printScore();
      pressEnter();

      // Check if there is a winner after both turns have been played.
      if (humanScore >= 150 || computerScore >= 150) {
        if (humanScore > computerScore) {
          System.out.println(humanName + ", Congratulations! You beat the computer!");
          finished = true;
        } else {
          System.out.println("Sorry, " + humanName + " you got beat by the computer!");
          finished = true;
        }
      }
    }
  }

  public void turn(boolean computer) {
    int turnScore = 0;
    int numOfRolls = 0;
    int multiplier = 1;
    boolean doubles = false;
    Scanner kb = new Scanner(System.in);
    String play = "y";

    // If computer is true, print out "Computer's turn: ", otherwise printout
    // humanName + "'s turn:'"
    if (computer)
      System.out.println("Computer's turn:");
    else
      System.out.println(humanName + "'s turn:");

    while (((computer && turnScore < 20) || (!computer && play.equals("y"))) && !doubles && numOfRolls < 5) {
      dice.roll();
      System.out.println("\tRolled: " + dice.toString());
      if (dice.getDie1() == dice.getDie2()) {
        if (dice.getDie1() == 1) {
          System.out.println("\tRolled snake eyes! All turn points will be doubled.");
          turnScore += 2;
          multiplier *= 2;
        } else if (dice.getDie1() == 6) {
          System.out.println("\tRolled box cars! All points are gone now!");
          turnScore = 0;
          multiplier = 1;
          if (computer)
            computerScore = 0;
          else
            humanScore = 0;
          doubles = true;
        } else {
          System.out.println("\t\tRolled double. . . lose all turn points.");
          turnScore = 0;
          multiplier = 1;
          doubles = true;
        }
      } else {
        turnScore += dice.getDie1() + dice.getDie2();
      }
      numOfRolls++;
      if (!doubles)
        System.out.println("\tCurrent score for this turn: " + turnScore);

      if (!doubles && numOfRolls < 5 && !computer) {
        System.out.print("Roll again? (y/n) ");
        play = kb.next().toLowerCase();
      } else {
        play = "n";
      }
    }

    if (multiplier != 1) {
      System.out
          .println("\t\tSnake Eyes cause " + turnScore + " points to become " + turnScore * multiplier + " points!");
      turnScore *= multiplier;
    }

    if (computer)
      computerScore += turnScore;
    else
      humanScore += turnScore;
  }

  public void printScore() {
    System.out.println("CURRENT GAME SCORE: Computer: " + computerScore + "      " + humanName + ": " + humanScore);
  }

  public void pressEnter() {
    Scanner kb = new Scanner(System.in);
    System.out.println();
    System.out.print("Press ENTER to continue ...");
    kb.nextLine();
  }
}