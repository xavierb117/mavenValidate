package io.github.auberonedu.mavenValidate;

import java.util.ArrayList;
import java.util.List;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 * Holds a list of DataPoint and turns it into a JFreeChart dataset.
 */
public class DataModel {
    private final List<DataPoint> points = new ArrayList<>();

    public void addDataPoint(DataPoint point) {
        points.add(point);
    }

    public List<DataPoint> getDataPoints() {
        return List.copyOf(points);
    }

    /**
     * Builds a TimeSeriesCollection suitable for a line chart.
     */
    public TimeSeriesCollection getDataset() {
        TimeSeries series = new TimeSeries("Understanding of Maven");
        for (DataPoint p : points) {
            Day day = new Day(p.getDate().getDayOfMonth(),
                              p.getDate().getMonthValue(),
                              p.getDate().getYear());
            series.add(day, p.getValue());
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }
}
