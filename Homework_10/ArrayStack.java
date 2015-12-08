//Andriy Zasypkin
//2015-12-08
//az

public class ArrayStack {
  private int[] nums;
  private int   topp;

  public ArrayStack() {
    this.topp = -1;
    this.nums = new int[5];
  }

  public boolean empty() {
    return this.topp < 0;
  }

  public void push(int value) {
    //TODO
  }

  public int pop() {
    //TODO
  }

  public int peek() {
    //TODO
  }

  /*No need - main only excepts 5 digits
   * public boolean full() {
   *   return this.topp == this.nums.length-1;
   * }
   */
}
