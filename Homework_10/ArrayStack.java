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

  public boolean empty() {//check if the pointer points to an element in array
    return this.topp < 0;
  }

  public void push(int value) {//append to array AFTER incrementing top pointer
    this.nums[++this.topp] = value;
  }

  public int pop() {//remove and return top value, BEFORE decrementing pointer
    return this.nums[this.topp--];
  }

  public int peek() {//return top value, WITHOUT changing pointer
    return this.nums[this.topp];
  }

  /*No need - main only excepts 5 digits
   * public boolean full() {
   *   return this.topp == this.nums.length-1;
   * }
   */
}
