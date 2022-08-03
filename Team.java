import java.util.LinkedList;

class Team {
  private String name;
  private int totalRun;
  private LinkedList<Batsman> team = new LinkedList<>();

  public Team(String name, LinkedList<Batsman> team) {
    this.name = name;
    this.team = team;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addBatsman(Batsman batsman) {
    team.add(batsman);
  }
  
  public int getTotalRun() {
    for (Batsman batsman: team) {
      totalRun += batsman.getRun();
    }
    return totalRun;
  }

  @Override
  public String toString() {
    return "Total run scored by Team " + name + " is " + getTotalRun();
  }
}