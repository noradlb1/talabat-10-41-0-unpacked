package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BaseMeasurementProducer implements MeasurementProducer {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final MeasurementType producedMeasurementType;
    private final ArrayList<Measurement> producedMeasurements = new ArrayList<>();

    public BaseMeasurementProducer(MeasurementType measurementType) {
        this.producedMeasurementType = measurementType;
    }

    public Collection<Measurement> drainMeasurements() {
        synchronized (this.producedMeasurements) {
            if (this.producedMeasurements.size() == 0) {
                List emptyList = Collections.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList(this.producedMeasurements);
            this.producedMeasurements.clear();
            return arrayList;
        }
    }

    public MeasurementType getMeasurementType() {
        return this.producedMeasurementType;
    }

    public void produceMeasurement(Measurement measurement) {
        synchronized (this.producedMeasurements) {
            if (measurement != null) {
                this.producedMeasurements.add(measurement);
            }
        }
    }

    public void produceMeasurements(Collection<Measurement> collection) {
        synchronized (this.producedMeasurements) {
            if (collection != null) {
                this.producedMeasurements.addAll(collection);
                while (this.producedMeasurements.remove((Object) null)) {
                }
            }
        }
    }
}
