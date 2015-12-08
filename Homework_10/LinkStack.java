//Andriy Zasypkin
//2015-12-08
//Homework 10

public class LinkStack {
  private Digit topp;

  public LinkStack() {
    this.topp = null;
  }

  public boolean empty() {
    return this.topp == null;
  }

  public void push(int value) {//append digit to list
    if(this.empty())
      this.topp = new Digit(value);
    else {
      Digit tmp = new Digit(value);
      this.topp.setNext(tmp);
      tmp.setPrev(this.topp);
      this.topp = tmp;
    }
  }

  public int pop() {//remove and return top digit
    if(this.topp.getPrev() != null)
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
