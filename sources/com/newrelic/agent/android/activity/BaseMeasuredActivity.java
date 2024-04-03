package com.newrelic.agent.android.activity;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.ThreadInfo;
import com.newrelic.agent.android.tracing.TraceMachine;

public class BaseMeasuredActivity implements MeasuredActivity {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private boolean autoInstrumented;
    private long endTime;
    private Measurement endingMeasurement;
    private ThreadInfo endingThread;
    private boolean finished;
    private MeasurementPool measurementPool;

    /* renamed from: name  reason: collision with root package name */
    private String f52776name;
    private long startTime;
    private Measurement startingMeasurement;
    private ThreadInfo startingThread;

    private boolean logIfFinished() {
        if (this.finished) {
            log.warn("BaseMeasuredActivity: cannot modify finished Activity");
        }
        return this.finished;
    }

    private void throwIfFinished() {
        if (this.finished) {
            throw new MeasurementException("Attempted to modify finished Measurement");
        }
    }

    public void finish() {
        this.finished = true;
    }

    public String getBackgroundMetricName() {
        return TraceMachine.formatActivityBackgroundMetricName(this.f52776name);
    }

    public long getEndTime() {
        return this.endTime;
    }

    public Measurement getEndingMeasurement() {
        return this.endingMeasurement;
    }

    public ThreadInfo getEndingThread() {
        return this.endingThread;
    }

    public MeasurementPool getMeasurementPool() {
        return this.measurementPool;
    }

    public String getMetricName() {
        return TraceMachine.formatActivityMetricName(this.f52776name);
    }

    public String getName() {
        return this.f52776name;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public Measurement getStartingMeasurement() {
        return this.startingMeasurement;
    }

    public ThreadInfo getStartingThread() {
        return this.startingThread;
    }

    public boolean isAutoInstrumented() {
        return this.autoInstrumented;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setAutoInstrumented(boolean z11) {
        if (!logIfFinished()) {
            this.autoInstrumented = z11;
        }
    }

    public void setEndTime(long j11) {
        if (!logIfFinished()) {
            this.endTime = j11;
        }
    }

    public void setEndingMeasurement(Measurement measurement) {
        if (!logIfFinished()) {
            this.endingMeasurement = measurement;
        }
    }

    public void setEndingThread(ThreadInfo threadInfo) {
        if (!logIfFinished()) {
            this.endingThread = threadInfo;
        }
    }

    public void setMeasurementPool(MeasurementPool measurementPool2) {
        if (!logIfFinished()) {
            this.measurementPool = measurementPool2;
        }
    }

    public void setName(String str) {
        if (!logIfFinished()) {
            this.f52776name = str;
        }
    }

    public void setStartTime(long j11) {
        if (!logIfFinished()) {
            this.startTime = j11;
        }
    }

    public void setStartingMeasurement(Measurement measurement) {
        if (!logIfFinished()) {
            this.startingMeasurement = measurement;
        }
    }

    public void setStartingThread(ThreadInfo threadInfo) {
        if (!logIfFinished()) {
            this.startingThread = threadInfo;
        }
    }
}
