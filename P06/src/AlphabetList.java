//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Alphabet Train
// Files: AlphabetList.java
// Course: CS 300, 2020 Spring
//
// Author: Zijian(Joey) Chen
// Email: zchen697@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Yiran Zhou
// Partner Email: zhou433@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understood the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a sorted doubly linked list of carts. Each cart carries one upper case alphabet
 * letter. Duplicate letters are not allowed in this list.
 * 
 * @author Yiran Zhou, Zijian Chen
 *
 */
public class AlphabetList implements SortedListADT<Cart> {

  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that
  // can be added to this sorted list
  private static final Cart MAX_CART = new Cart("Z"); // The largest cart that
  // can be added to this sorted list
  private LinkedCart head; // head of this doubly linked list
  private LinkedCart tail; // tail of this doubly linked list
  private int size; // size of this list
  private int capacity; // maximum number of carts which can be stored in this list

  /**
   * Creates an empty doubly linked list of carts with a given capacity
   * 
   * @param capacity - maximum number of carts to be connected in this list of carts
   */
  public AlphabetList(int capacity) {
    if (capacity <= 0)
      throw new IllegalArgumentException(
          "The capacity of this list must be a non-zero a positive integer.");
    else {
      this.capacity = capacity;
      head = null;
      tail = null;
      size = 0;
    }
  }

  public AlphabetList() {
    this.capacity = 26;
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  /**
   * isEmpty() Checks whether this list is empty.
   * 
   * @return true if the list is empty, false otherwise
   */
  public boolean isEmpty() {
    if (size == 0)
      return true;
    else
      return false;
  }

  @Override
  /**
   * Adds a new cart of type T to this sorted list.
   * 
   * @param newCart - to add to this list
   */
  public void add(Cart newCart) {
    if (size >= capacity)
      throw new IllegalStateException("This list is full. Cannot add another cart.");
    if (newCart.getCargo().length() == 1
        && (newCart.compareTo(MAX_CART) > 0 || newCart.compareTo(MIN_CART) < 0)) {
      throw new IllegalArgumentException(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    }
    if (head == null) {
      head = new LinkedCart(newCart);
      tail = head;
      size++;
      return;
    } else {
      if (indexOf(newCart) != -1) {
        throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
      } else {
        LinkedCart newElement = new LinkedCart(newCart);
        if (tail.getCart().compareTo(newElement.getCart()) < 0) {
          tail.setNext​(newElement);
          //System.out.println(tail.getNext().getCart().getCargo());
          newElement.setPrevious​(tail);
          //System.out.println(newElement.getPrevious().getCart().getCargo());
          tail = newElement;
          //System.out.println(tail.getCart().getCargo());
          size++;
          //System.out.println(readForward());
          //System.out.println(readBackward());
          return;
        }
        LinkedCart node = head;
        while (node != null) {
          if (node.getCart().compareTo(newCart) > 0) {
            if (node == head) {
              head.setPrevious​(newElement);
              newElement.setNext​(head);
              head = newElement;
              size++;
              return;
            }
            newElement.setNext​(node);
            newElement.setPrevious​(node.getPrevious());
            node.getPrevious().setNext​(newElement);
            node.setPrevious​(newElement);
            size++;
            return;
          } else
            node = node.getNext();
        }
      }
    }
  }



  @Override
  /**
   * Returns the size of this sorted list
   * 
   * @return the number of elements stored in this sorted list
   */
  public int size() {
    return size;
  }

  /**
   * Returns the capacity of this list in terms of maximum number of carts which can be stored in
   * it.
   * 
   * @return the capacity of this list
   */
  public int capacity() {
    return capacity;
  }

  @Override
  /**
   * Removes all the carts from this list. This list must be empty after this method returns.
   */
  public void clear() {
    while (!isEmpty()) {
      remove(0);
    }

  }

  @Override
  /**
   * Returns the cart at position index of this list without removing it
   * 
   * @param index - of the cart to return
   * @return the cart of this sorted list at the given index
   */
  public Cart get(int index) {
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("Invalid index.");
    else {
      LinkedCart node = head;
      for (int i = 0; i < index; i++)
        node = node.getNext();
      return node.getCart();
    }
  }

  @Override
  /**
   * Returns the index of the cart carrying data within this list
   * 
   * @param findCart - cart to find in this list
   * @return the index of findCart within this list or -1 if this list does not contain that cart.
   */
  public int indexOf(Cart findCart) {
    LinkedCart index = head;
    int num = 0;
    while (index.getNext() != null) {
      if (index.getCart().compareTo(findCart)==0)
        return num;
      index = index.getNext();
      num++;
    }
    return -1;
  }

  @Override
  /**
   * Returns and removes the cart from this sorted list at the given index position
   * 
   * @param index - of the cart to be removed
   * @return the removed cart
   */
  public Cart remove(int index) {
    if(head.getNext()==null)
    {
      Cart Return = head.getCart();
      size = 0;
      head = null;
      tail = null;
      return Return;
    }
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("Invalid index.");
    if (index == 0) {
      Cart Return = head.getCart();
      head.getNext().setPrevious​(null);
      head = head.getNext();
      size--;
      return Return;
    }
    if (index == size - 1) {
      Cart Return = tail.getCart();
      tail.getPrevious().setNext​(null);
      tail = tail.getPrevious();
      size--;
      return Return;
    }
    Cart Ans = get(index);
    LinkedCart node = head;
    for (int i = 0; i < index - 1; i++)
      node = node.getNext();
    node.setNext​(node.getNext().getNext());
    node.getNext().setPrevious​(node);
    size--;
    return Ans;
  }

  @Override
  /**
   * Returns a String representation of this list. Note that the implementation details of this
   * method is provided in the assignment's specification.
   * 
   * @return a String representation of this list
   */
  public java.lang.String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;
  }

  /**
   * Reads the contents of this list in the forward direction starting from its head.
   * 
   * @return a String representation of the contents of this list read in the forward direction or
   *         an empty string if this list is empty.
   */
  public java.lang.String readForward() {
    String string = "";
    if (size == 0) {
      return string;
    }
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString();
      currentCart = currentCart.getNext();
      //System.out.println(currentCart.getCart());
    }
    return string;
  }

  public java.lang.String readBackward() {
    String string = "";
    if (size == 0) {
      return string;
    }
    LinkedCart currentCart = tail;
    while (currentCart != null) {
      string += currentCart.getCart().toString();
      currentCart = currentCart.getPrevious();
    }
    return string;
  }
}
