package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.Collection;

public class BaseMeasurementConsumer extends HarvestAdapter implements MeasurementConsumer {
    private final MeasurementType measurementType;

    public BaseMeasurementConsumer(MeasurementType measurementType2) {
        this.measurementType = measurementType2;
    }

    public void consumeMeasurement(Measurement measurement) {
    }

    public void consumeMeasurements(Collection<Measurement> collection) {
        for (Measurement consumeMeasurement : collection) {
            consumeMeasurement(consumeMeasurement);
        }
    }

    public MeasurementType getMeasurementType() {
        return this.measurementType;
    }
}
