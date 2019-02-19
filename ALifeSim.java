package assignment4;

import java.io.PrintWriter;

public class ALifeSim {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 4) {
      throw new Exception("Incorrect number of arguments");
    } // endif

    // getting arguments from the commandline
    int iterations = Integer.parseInt(args[0]);
    Integer cooperators = Integer.parseInt(args[1]);
    Integer defectors = Integer.parseInt(args[2]);
    Integer partialCooperators = Integer.parseInt(args[3]);

    // creating the Pair<String, Integer> objects for the inputs to Population
    Pair<String, Integer> cooperatorPair = new Pair<String, Integer>("Cooperator", cooperators);
    Pair<String, Integer> defectorPair = new Pair<String, Integer>("Defector", defectors);
    Pair<String, Integer> partialCooperatorPair =
        new Pair<String, Integer>("PartialCooperator", partialCooperators);
    // create a Pair<String, Integer> array 'counts'
    Pair[] counts = {cooperatorPair, defectorPair, partialCooperatorPair};

    // instantiating Population object
    Population population = new Population(counts);

    // main loop
    for (int i = 0; i < iterations; i++) {
      population.update();
    }

    Pair[] finalCounts = population.getPopulationCounts();


    // After experiment results
    Integer finalCooperator = (Integer) finalCounts[0].getRight();
    Integer finalDefector = (Integer) finalCounts[1].getRight();
    Integer finalPartial = (Integer) finalCounts[2].getRight();

    pen.println("After " + iterations + " ticks:");
    pen.println("Cooperators = " + finalCooperator);
    pen.println("Defectors = " + finalDefector);
    pen.println("Partial = " + finalPartial);
    pen.println("Mean Cooperation Probability = " + population.calculateCooperationMean());

  }// main

}// ALifeSim
