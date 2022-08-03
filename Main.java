import java.util.Scanner;
import java.util.LinkedList;

class Main {
  public static void main(String[] args) {
    
    System.out.println("Welcome to the game of Cricket!\n" +
                       "The computer will be your opponent in this game.\n" +
                       "Each team consists of five players.\n" +
                       "You have to enter five random numbers between 1-99.\n" + 
                       "Every number will represent the run scored by each individual player of your team.\n" +
                       "You win if total run scored by your team is greater than opponent's total.\n" + 
                      "Please enter your name first:" 
                      );

    Scanner sc = new Scanner(System.in);

    String teamUser = sc.next();
    LinkedList<Batsman> batsmen = new LinkedList<>();
    Team user = new Team(teamUser, batsmen);

    System.out.println("Welcome " + teamUser + "! Best of luck!");

    for(int i = 1; i <=5; i++) {
      System.out.println("Batsman " + i + " comes to bat.");
      
      System.out.println("Please enter a number between 1-99");
      
      Batsman batsman = new Batsman("Batsman " + i);
      int run = sc.nextInt();
      try {
          batsman.setRun(run);
        } catch(RunException e) {
          //e.printStackTrace();
          System.out.println("Please enter a number between 1-99 or a random number will be generated for you." );
          run = sc.nextInt();
          try {
            batsman.setRun(run);
          } catch (RunException ex) {
            e.printStackTrace();
            run = (int) (Math.random() * 100);
            try {
              batsman.setRun(run);
            } catch (RunException exc) {
              exc.printStackTrace();
            }
          }
        }
        
      batsman.announceRun();
      user.addBatsman(batsman);
    }

    
    System.out.println(user);
    sc.close();
    
    System.out.println("Your opponent is getting ready to bat.");
    Team opponent = createOpponent();
    System.out.println(opponent);

    if (user.getTotalRun() > opponent.getTotalRun()) {
        System.out.println("CONGRATULATIONS! YOUR TEAM HAS WON!");
    } else if (user.getTotalRun() < opponent.getTotalRun()) {
        System.out.println("Sorry, your team has lost :(\n" +
                          "Better luck next time!");
    } else {
      System.out.println("The game is tied!");
    }
  }

  public static Team createOpponent() {
    LinkedList<Batsman> batsmen = new LinkedList<>();
    Team opponent = new Team("Opponent", batsmen);

    for(int i = 1; i <=5; i++) {
      System.out.println("Batsman " + i + " comes to bat.");
      Batsman batsman = new Batsman("Batsman " + i);
      int run = (int) (Math.random() * 100);
      try {
        batsman.setRun(run);
      } catch(RunException e) {
        e.printStackTrace();
      }
      batsman.announceRun();
      opponent.addBatsman(batsman);
    }
    
    return opponent;
  }
}