package com.newrelic.agent.android.measurement;

public class ActivityMeasurement extends BaseMeasurement {
    public ActivityMeasurement(String str, long j11, long j12) {
        super(MeasurementType.Activity);
        setName(str);
        setStartTime(j11);
        setEndTime(j12);
    }
}
