//Andriy Zasypkin
//2015-12-08
//Homework 10

public class LinkStack {
  private Digit topp;

  public LinkStack() {
    top = null;
  }

  public boolean empty() {
    return this.topp == null;
  }

  public void push(int value) {
    Digit tmp = new Digit(value);
    this.topp.setNext(tmp);
    tmp.setPrev(this.topp);
    this.topp = tmp;
  }

  public int pop() {
    this.topp.getPrev().setNext(null);
    Digit tmp = this.topp;
    this.topp = this.topp.getPrev();
    return tmp.getValue();
  }

  public int peek() {
    return this.topp.getValue();
  }

  /*No need - main only excepts 5 digits
   * public boolean full() {
   *   //No implementation for linked list stacks
   *   return false;
   * }
   */
}
