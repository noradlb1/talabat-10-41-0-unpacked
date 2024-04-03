package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MeasurementPool extends BaseMeasurementProducer implements MeasurementConsumer {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final CopyOnWriteArrayList<MeasurementConsumer> consumers = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MeasurementProducer> producers = new CopyOnWriteArrayList<>();

    public MeasurementPool() {
        super(MeasurementType.Any);
        addMeasurementProducer(this);
    }

    public void addMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        if (measurementConsumer == null) {
            log.debug("Attempted to add null MeasurementConsumer.");
        } else if (!this.consumers.addIfAbsent(measurementConsumer)) {
            AgentLog agentLog = log;
            agentLog.debug("Attempted to add the same MeasurementConsumer " + measurementConsumer + " multiple times.");
        }
    }

    public void addMeasurementProducer(MeasurementProducer measurementProducer) {
        if (measurementProducer == null) {
            log.debug("Attempted to add null MeasurementProducer.");
        } else if (!this.producers.addIfAbsent(measurementProducer)) {
            AgentLog agentLog = log;
            agentLog.debug("Attempted to add the same MeasurementProducer " + measurementProducer + "  multiple times.");
        }
    }

    public void broadcastMeasurements() {
        ArrayList<Measurement> arrayList = new ArrayList<>();
        Iterator<MeasurementProducer> it = this.producers.iterator();
        while (it.hasNext()) {
            Collection<Measurement> drainMeasurements = it.next().drainMeasurements();
            if (drainMeasurements.size() > 0) {
                arrayList.addAll(drainMeasurements);
                do {
                } while (arrayList.remove((Object) null));
            }
        }
        if (arrayList.size() > 0) {
            Iterator<MeasurementConsumer> it2 = this.consumers.iterator();
            while (it2.hasNext()) {
                MeasurementConsumer next = it2.next();
                for (Measurement measurement : arrayList) {
                    if (next.getMeasurementType() == measurement.getType() || next.getMeasurementType() == MeasurementType.Any) {
                        try {
                            next.consumeMeasurement(measurement);
                        } catch (Exception e11) {
                            ExceptionHelper.exceptionToErrorCode(e11);
                            AgentLog agentLog = log;
                            String name2 = e11.getClass().getName();
                            agentLog.error("broadcastMeasurements exception[" + name2 + "]");
                        }
                    }
                }
            }
        }
    }

    public void consumeMeasurement(Measurement measurement) {
        produceMeasurement(measurement);
    }

    public void consumeMeasurements(Collection<Measurement> collection) {
        produceMeasurements(collection);
    }

    public Collection<MeasurementConsumer> getMeasurementConsumers() {
        return this.consumers;
    }

    public Collection<MeasurementProducer> getMeasurementProducers() {
        return this.producers;
    }

    public MeasurementType getMeasurementType() {
        return MeasurementType.Any;
    }

    public void removeMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        if (!this.consumers.remove(measurementConsumer)) {
            AgentLog agentLog = log;
            agentLog.debug("Attempted to remove MeasurementConsumer " + measurementConsumer + " which is not registered.");
        }
    }

    public void removeMeasurementProducer(MeasurementProducer measurementProducer) {
        if (!this.producers.remove(measurementProducer)) {
            AgentLog agentLog = log;
            agentLog.debug("Attempted to remove MeasurementProducer " + measurementProducer + " which is not registered.");
        }
    }
}
