public class Tmp {
  public static void main(String[] args) {
    Stats tmp = new Stats("a Hello world, ajh qq97, adfvz hI only $99dot99 dot cash! stuff al-so a word? YES!");
    
    String old = tmp.toString();
    
    System.out.printf("Original:\n%s\n\nCapitilized:\n%s\n", old, tmp.capitalize());
    System.exit(0);
  }
}
