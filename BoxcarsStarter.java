import java.util.Scanner;

public class BoxcarsStarter {

  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);

    Boxcars boxcarGame = new Boxcars();
    System.out.println("Welcome to BoxCars - The Game of Dice");

    System.out.print("Who is playing against the computer? ");
    String name = kb.next();

    boxcarGame.init(name);

    boxcarGame.playGame();
  }
}