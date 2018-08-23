package sample;

public class LinkedList {
    private Node head;

    public LinkedList() {
    }

    public Node getHead(){
        return head;
    }

    public void addNode(double x, double y, int clusterGroup) {
        Node node = new Node(x, y, clusterGroup, head);
        head = node;
    }
}
