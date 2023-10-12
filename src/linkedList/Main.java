package linkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList myLinkedList = new LinkedList(4); // head/tail ---> 4 ---> null
    myLinkedList.append(5);
    myLinkedList.append(6);
    myLinkedList.append(7);

    myLinkedList.getHead();
    myLinkedList.getTail();
    myLinkedList.getLength();

    myLinkedList.printItems();
    System.out.println();

    myLinkedList.reverse();

    myLinkedList.printItems();
  }
}
