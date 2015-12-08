//Andriy Zasypkin
//2015-12-07
//Homework 10

public class Digit {
  private int   value;
  private Digit next;
  private Digit prev;

  public Digit() {
    this.value = 0;
    this.next  = null;
    this.prev  = null;
  }

  public Digit(int value) {
    this.value = value;
    this.next  = null;
    this.prev  = null;
  }

  public void setNext(Digit next) {
    this.next = next;
  }

  public Digit getNext() {
    return this.next;
  }

  public void setPrev(Digit prev) {
    this.prev = prev;
  }

  public Digit getPrev() {
    return this.prev;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
