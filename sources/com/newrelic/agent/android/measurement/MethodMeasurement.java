package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.instrumentation.MetricCategory;

public class MethodMeasurement extends CategorizedMeasurement {
    public MethodMeasurement(String str, String str2, long j11, long j12, long j13, MetricCategory metricCategory) {
        super(MeasurementType.Method);
        setName(str);
        setScope(str2);
        setStartTime(j11);
        setEndTime(j12);
        setExclusiveTime(j13);
        setCategory(metricCategory);
    }
}
