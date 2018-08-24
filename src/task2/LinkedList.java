package task2;

/**
 * simple LinkedList class
 */
public class LinkedList {
    private Node head;

    /**
     * constructor
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * getter for the head of the list
     * @return Node that is at head of the LinkedList
     */
    public Node getHead(){
        return head;
    }

    /**
     * creates Node and places it at the head of the LinkedList
     * @param x
     * @param y
     * @param clusterGroup
     */
    public void addNode(double x, double y, int clusterGroup) {
        Node node = new Node(x, y, clusterGroup, head);
        head = node;
    }
}
