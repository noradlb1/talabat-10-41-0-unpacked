package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.metric.Metric;

public class CustomMetricMeasurement extends CategorizedMeasurement {
    private Metric customMetric;

    public CustomMetricMeasurement() {
        super(MeasurementType.Custom);
    }

    public Metric getCustomMetric() {
        return this.customMetric;
    }

    public CustomMetricMeasurement(String str, int i11, double d11, double d12) {
        this();
        setName(str);
        Metric metric = new Metric(str);
        this.customMetric = metric;
        metric.sample(d11);
        this.customMetric.setCount((long) i11);
        this.customMetric.setExclusive(Double.valueOf(d12));
    }
}
