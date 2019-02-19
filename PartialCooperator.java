package assignment4;

import java.util.Random;

public class PartialCooperator extends Organism {

  public PartialCooperator() {}

  @Override
  public String getType() {
    return "PartialCooperator";
  }

  @Override
  public Organism reproduce() {
    Random rand = new Random();
    if (rand.nextInt(100) < 10) {
      if (rand.nextBoolean()) {
        return new Cooperator();
      } else {
        return new Defector();
      }
    }

    return new PartialCooperator();
  }

  @Override
  public double getCooperationProbability() {
    return 0.5;
  }

  @Override
  public boolean cooperates() {
    Random randnum = new Random();
    return randnum.nextBoolean();
  }

}
