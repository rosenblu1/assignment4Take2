package assignment4;

import java.util.Random;

public class Defector extends Organism {

  public Defector() {}

  @Override
  public String getType() {
    return "Defector";
  }

  @Override
  public Organism reproduce() {
    //will mutate and return one of the other two subtypes of Organism
    //about 10% of the time
    Random rand = new Random(System.currentTimeMillis());
    if (rand.nextInt(100) < 10) {
      if (rand.nextBoolean()) {
        return new PartialCooperator();
      } else {
        return new Cooperator();
      }
    }
    
    return new Defector();
  }

  @Override
  public double getCooperationProbability() {
    return 0;
  }

  @Override
  public boolean cooperates() {
    return false;
  }


} // Defector
