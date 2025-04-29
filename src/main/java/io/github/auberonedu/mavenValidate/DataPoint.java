package io.github.auberonedu.mavenValidate;

import java.time.LocalDate;

/**
 * A single data point: a date and a value.
 */
public class DataPoint {
    private final LocalDate date;
    private final double value;

    public DataPoint(LocalDate date, double value) {
        this.date  = date;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}
