package sample;

public class Node {
    private double x;
    private double y;
    private Node nextNode;
    private int clusterGroup;

    public Node(double x, double y, int clusterGroup, Node nextNode) {
        this.x = x;
        this.y = y;
        this.clusterGroup = clusterGroup;
        this.nextNode = nextNode;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getClusterGroup() {
        return clusterGroup;
    }

    public Node getNextNode() {
        return nextNode;
    }
}
