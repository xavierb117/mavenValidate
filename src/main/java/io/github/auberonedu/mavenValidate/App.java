package io.github.auberonedu.mavenValidate;

import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeriesCollection;
import java.time.LocalDate;
import java.util.Random;

/**
 * Entry point: builds some example data, creates the chart, and displays it.
 */
public class App {

    public static void main(String[] args) {
        // Build the data model
        DataModel model = new DataModel();
        LocalDate start = LocalDate.now().minusDays(9);
        Random rand = new Random();
        double value = rand.nextDouble() * 10;

        // Generate 10 points that roughly increase but with some variation
        for (int i = 0; i < 10; i++) {
            model.addDataPoint(new DataPoint(start.plusDays(i), value));
            value += rand.nextDouble() * 2 - 1;  // random change in [-1, +1]
            if (value < 0) value = 0;
        }

        // Create chart
        TimeSeriesCollection dataset = model.getDataset();
        ChartGenerator generator = new ChartGenerator();
        JFreeChart chart = generator.createChart(dataset);

        // Display
        displayChart(chart);
    }

    private static void displayChart(JFreeChart chart) {
        JFrame frame = new JFrame("Maven Understanding Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
