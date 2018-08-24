package task2;

/**
 * Node class for LinkedList
 */
public class Node {
    private double x;
    private double y;
    private Node nextNode;
    private int clusterGroup;

    /**
     * Node constructor
     * @param x
     * @param y
     * @param clusterGroup
     * @param nextNode
     */
    public Node(double x, double y, int clusterGroup, Node nextNode) {
        this.x = x;
        this.y = y;
        this.clusterGroup = clusterGroup;
        this.nextNode = nextNode;
    }

    /**
     * getter for x
     * @return x coord
     */
    public double getX() {
        return x;
    }

    /**
     * getter for y
     * @return y coord
     */
    public double getY() {
        return y;
    }

    /**
     * getter for clusterGroup
     * @return cluster group this node is assigned to
     */
    public int getClusterGroup() {
        return clusterGroup;
    }

    /**
     * getter for the next Node in the LinkedList
     * @return
     */
    public Node getNextNode() {
        return nextNode;
    }
}
