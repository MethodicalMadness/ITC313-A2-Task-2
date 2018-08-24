package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class for displaying the cluster chart
 * @author Michael Coleman
 */
public class Main extends Application {

    /**
     * Initializes the chart
     * Sets the series data for chart
     * Displays the chart
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        LinkedList clusterList = processClusterTxt();
        primaryStage.setTitle("A2 Task 2 -Michael Coleman");
        final NumberAxis xAxis = new NumberAxis(-.5, 10, .5);
        final NumberAxis yAxis = new NumberAxis(-.5, 10, .5);
        final ScatterChart<Number, Number> chart;
        chart = new ScatterChart<>(xAxis, yAxis);
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        chart.setTitle("Unique Neighborhood Set Parameter " +
                "Independent Density-Based Clustering " +
                "with Outlier Detection");
        XYChart.Series cluster1 = new XYChart.Series();
        XYChart.Series cluster2 = new XYChart.Series();
        XYChart.Series cluster3 = new XYChart.Series();
        XYChart.Series cluster4 = new XYChart.Series();
        cluster1.setName("Cluster 1");
        cluster2.setName("Cluster 2");
        cluster3.setName("Cluster 3");
        cluster4.setName("Cluster 4");
        Node currentNode = clusterList.getHead();
        while (true) {
            if (currentNode == null) {
                break;
            }
            int clusterGroup = currentNode.getClusterGroup();
            double x = currentNode.getX();
            double y = currentNode.getY();
            if (clusterGroup == 1){
                cluster1.getData().add(new XYChart.Data(x, y));
            }else if (clusterGroup == 2){
                cluster2.getData().add(new XYChart.Data(x, y));
            }else if (clusterGroup == 3){
                cluster3.getData().add(new XYChart.Data(x, y));
            }else if (clusterGroup == 4){
                cluster4.getData().add(new XYChart.Data(x, y));
            }else{
                System.out.println("An error occurred while setting chart data!");
            }
            currentNode = currentNode.getNextNode();
        }
        chart.getData().addAll(cluster1, cluster2, cluster3, cluster4);
        Scene scene = new Scene(chart, 1000, 1000);
        scene.getStylesheets().add("sample/Chart.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Processes the cluster.txt
     * @return LinkedList whose Nodes contain the x,y coords for the chart and cluster group
     */
    public static LinkedList processClusterTxt() {
        LinkedList clusterList = new LinkedList();
        String pathname = "cluster.txt";
        String thisLine = "";
        try {
            Scanner fileInput = new Scanner(new File(pathname));
            fileInput.nextLine(); //ignore first line
            int j = 1;
            while (fileInput.hasNextLine()) {
                thisLine = fileInput.nextLine();
                Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)"); //digits and decimals followed by digits
                Matcher matcher = regex.matcher(thisLine);
                int i = 0;
                double x = 0;
                double y = 0;
                int c = 0;
                while (matcher.find()) {
                    try {
                        if (i == 0) {
                            x = Double.valueOf(matcher.group(1));
                            i=1;
                        } else if (i == 1) {
                            y = Double.valueOf(matcher.group(1));
                            i=2;
                        } else if (i == 2) {
                            c = Integer.valueOf(matcher.group(1));
                            i=0;
                        } else {
                            System.out.println("An error occurred while processing x and y from cluster.txt");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e);
                    }
                }
                clusterList.addNode(x, y, c);
                System.out.println("node:" + j + " x=" + x + " y=" + y + " c=" + c);
                j++;
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException error: " + e);
        }
        return clusterList;
    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
