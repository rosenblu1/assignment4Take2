package assignment4;

import java.util.Random;

public class Population {

  Organism[] pop;

  public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {

    int sumPop = 0;

    for (int i = 0; i < counts.length; i++) {
      sumPop += counts[i].right;
    }

    this.pop = new Organism[sumPop];

    int index = 0;

    for (int i = 0; i < counts.length; i++) {
      if (counts[i].left.equals("Cooperator")) {
        for (int k = 0; k < counts[i].right; k++) {
          pop[index++] = new Cooperator();
        }
      } else if (counts[i].left.equals("Defector")) {
        for (int m = 0; m < counts[i].right; m++) {
          pop[index++] = new Defector();
        }
      } else if (counts[i].left.equals("PartialCooperator")) {
        for (int n = 0; n < counts[i].right; n++) {
          pop[index++] = new PartialCooperator();
        }
      } else {
        throw new IllegalArgumentException("Invalid Organism type");
      } // endif
    } // for
  }// Population(Pair<String, Integer>[] counts)

  public void update() {
    // create pseudorandom number generator
    Random rand = new Random(System.currentTimeMillis());

    for (int i = 0; i < pop.length; i++) {

      Organism org = pop[i];
      org.update();

      // if org cooperates
      if (org.cooperates()) {
        // decrement energy
        org.decrementEnergy();
        // and give energy to 8 random organisms
        for (int k = 0; k < 8; k++) {
          pop[rand.nextInt(pop.length)].incrementEnergy();
        }
      } // if it cooperates

      // if org can reproduce
      if (org.getEnergy() >= 10) {

        // code for if we had replaced a random organism
        // pop[rand.nextInt(pop.length)] = org.reproduce();

        // replace organism with the least energy
        int lowestIndex = 0;
        for (int m = 0; m < pop.length; m++) {
          if (pop[m].getEnergy() < pop[lowestIndex].getEnergy()) {
            lowestIndex = m;
          }
        }
        pop[lowestIndex] = org.reproduce();
      }

    } // for
  }// update()

  public double calculateCooperationMean() {
    double sumProb = 0;
    for (int i = 0; i < pop.length; i++) {
      sumProb += pop[i].getCooperationProbability();
    }
    return (double) sumProb / pop.length;
  }// calculateCooperationMean()

  public Pair<String, Integer>[] getPopulationCounts() {
    int coopCount = 0;
    int defectCount = 0;
    int partialCount = 0;

    for (int i = 0; i < pop.length; i++) {
      if (pop[i] instanceof Cooperator) {
        coopCount++;
      } else if (pop[i] instanceof Defector) {
        defectCount++;
      } else if (pop[i] instanceof PartialCooperator) {
        partialCount++;
      } // endif
    } // for

    // creating the Pair<String, Integer> objects for the inputs to Population
    Pair<String, Integer> cooperatorPair = new Pair<String, Integer>("Cooperator", coopCount);
    Pair<String, Integer> defectorPair = new Pair<String, Integer>("Defector", defectCount);
    Pair<String, Integer> partialCooperatorPair =
        new Pair<String, Integer>("PartialCooperator", partialCount);
    // create a Pair<String, Integer> array 'counts'
    Pair[] counts = {cooperatorPair, defectorPair, partialCooperatorPair};

    return counts;
  }// getPopulationCounts()

}// Population
