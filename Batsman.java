class Batsman extends Player {
  private int run;

  public Batsman(String name) {
    super(name);
  }

  public void setRun(int run) throws RunException {
    boolean bool = run > 99;
    int val = bool ? 1 : 0;
    switch (val) {
      case  1:
      throw new RunException("Run can't be greater than 99");
      default:
        this.run = run;
        break;
    }
  }

  public int getRun() {
    return run;
  }

  @Override
  public void announceRun() {
    System.out.println(this.getName() + " scored " + this.run + " run.");
  }
}