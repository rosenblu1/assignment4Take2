package assignment4;

public class Organism {

  private int energy;
  private boolean cooperates;

  public Organism() {
    this.energy = 0;
  }

  public void update() {
    this.energy += 1;
  }

  public int getEnergy() {
    return this.energy;
  }

  public void incrementEnergy() {
    this.energy += 1;
  }

  public void decrementEnergy() {
    this.energy -= 1;
  }

  public String getType() {
    return "Organism";
  }

  public Organism reproduce() {
    return new Organism();
  }

  public double getCooperationProbability() {
    return 1;
  }

  public boolean cooperates() {
    return true;
  }


}
