package linkedList;

public class LinkedList {
  // type of Node, can point to a node
  private Node head;
  // type of Node, can point to a node
  private Node tail;
  private int length;

  // inner class Node
  class Node {
    int value;
    Node next; // here we have a variable of type Node which means it is a pointer to a Node

    Node(int value) {
      this.value = value;
    }
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);  // newNode ---> value ---> null
    head = newNode; // head ---> value ---> null
    tail = newNode; // head/tail ---> value ---> null
    length = 1;
  }

  public void printItems() {
    Node temp = head; // temp ---> value ---> null
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;  // this line makes temp iterate through the list
    }
    System.out.print(temp); // am ende zeigt temp auf null
  }

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void append(int value) {
    Node newNode = new Node(value); // make new node
    if (length == 0) { // geht auch if (head == null || tail == null)
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode; // move tail pointer to new element
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0)
      return null;  // falls die liste leer ist
    Node temp = head;
    Node pre = head;
    while (tail.next != null) {
      pre = temp;
      temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;
    // falls die liste leer ist ABER da ist die length um -1 reduzierrt worden
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0)
      return null;
    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;
    if (length == 0) {
      tail = null;
    }
    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length)
      return false;

    // insert at the beginn of the list
    if (index == 0) {
      prepend(value);
      return true;
    }
    // insert at the end of the linked list
    if (index == length) {
      append(value);
      return true;
    }

    // insert in the middle of the linked list
    Node newNode = new Node(value);
    Node temp = get(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index, int value) {
    if (index < 0 || index > length)
      return null;

    if (index == 0)
      return removeFirst();

    if (index == length - 1)
      return removeLast();

    // remove an item in the middle
    Node prev = get(index - 1);
    Node temp = prev.next;
    prev.next = temp.next;
    temp.next = null;
    length--;
    return temp;
  }

  public void reverse(){
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

}

