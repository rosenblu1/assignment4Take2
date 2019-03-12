package artificialLife;

import java.io.PrintWriter;

public class LifeSimExpt {

  public static void main(String args[]) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] expt1 = {"100", "1", "9", "0"};
    pen.println("Experiment 1: Size 10, 1 Cooperator, Rest Defectors\n");
  //  for (int i = 0; i < 10; i++) {
  //    ALifeSim.main(expt2);
  //  }
    pen.println("---------------------------------------------------");

 
    String[] expt2 = {"100", "9", "1", "0"};
  //  pen.println("Experiment 2: Size 10, 1 Defector, Rest Cooperators\n");
  //  ALifeSim.main(expt2);
  //  pen.println("---------------------------------------------------");

    String[] expt3 = {"100", "3", "3", "3"};
  //  pen.println("Experiment 3: Size 10, Split Evenly Among All Types\n");
   // ALifeSim.main(expt3);
    pen.println("---------------------------------------------------");

    String[] expt4 = {"100", "1", "99", "0"};
 //   pen.println("Experiment 4: Size 100, 1 Cooperator, Rest Defector\n");
 //   ALifeSim.main(expt4);
 //   pen.println("---------------------------------------------------");

    String[] expt5 = {"100", "99", "1", "0"};
  //  pen.println("Experiment 5: Size 100, 1 Defector, Rest Cooperator\n");
  //  ALifeSim.main(expt5);
  //  pen.println("---------------------------------------------------");

    String[] expt6 = {"100", "33", "33", "33"};
  //  pen.println("Experiment 6: Size 100, Split Evenly Among All Types\n");
   // ALifeSim.main(expt6);
   // pen.println("---------------------------------------------------");

    for (int i = 0; i < 10; i++) {
      ALifeSim.main(expt5);
    }
  }// main(String[] args)
}// LifeSimExpt