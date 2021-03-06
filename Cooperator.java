package artificialLife;

import java.util.Random;

public class Cooperator extends Organism {

  public Cooperator() {}

  @Override
  public String getType() {
    return "Cooperator";
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
        return new Defector();
      }
    }
    
    return new Cooperator();
  }

  @Override
  public double getCooperationProbability() {
    return 1;
  }

  @Override
  public boolean cooperates() {
    return true;
  }

}