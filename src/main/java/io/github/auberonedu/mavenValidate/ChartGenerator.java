package io.github.auberonedu.mavenValidate;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeriesCollection;

/**
 * Generates a JFreeChart line chart from a dataset.
 */
public class ChartGenerator {

    /**
     * @param dataset a TimeSeriesCollection
     * @return a JFreeChart with axes labeled appropriately
     */
    public JFreeChart createChart(TimeSeriesCollection dataset) {
        return ChartFactory.createTimeSeriesChart(
            "Understanding of Maven Over Time", // chart title
            "Time",                             // domain axis label
            "Understanding of Maven",           // range axis label
            dataset,                            // data
            false,                              // legend
            false,                              // tooltips
            false                               // URLs
        );
    }
}
