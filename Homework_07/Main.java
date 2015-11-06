//Andriy Zasypkin
//2015-11-06
//Homework 07

public class Main {
  public static void main(String[] args) {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));

    //TODO - spellcheck
    System.out.print("Enter a frequency: ");
    double f = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a minimal capacitance value: ");
    double cmin = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a maximum capacitance value: ");
    double cmax = Double.valueOf(input.readLine()).doubleValue();

    System.out.print("Enter location to save database: ");
    String filename = input.readLine();

    Database db = new Database(filename);

    db.print();
    db.save();//TODO - implement save/load
    //close stream
    input.close();

    System.exit(0);
  }
}

