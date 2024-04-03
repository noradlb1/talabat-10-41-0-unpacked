package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

public class BaseMeasurement implements Measurement {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private long endTime;
    private long exclusiveTime;
    private boolean finished;

    /* renamed from: name  reason: collision with root package name */
    private String f52783name;
    private String scope;
    private long startTime;
    private ThreadInfo threadInfo;
    private MeasurementType type;

    public BaseMeasurement(MeasurementType measurementType) {
        setType(measurementType);
    }

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

    public double asDouble() {
        throw new UnsupportedOperationException();
    }

    public void finish() {
        if (!this.finished) {
            this.finished = true;
            return;
        }
        throw new MeasurementException("Finish called on already finished Measurement");
    }

    public long getEndTime() {
        return this.endTime;
    }

    public double getEndTimeInSeconds() {
        return ((double) this.endTime) / 1000.0d;
    }

    public long getExclusiveTime() {
        return this.exclusiveTime;
    }

    public double getExclusiveTimeInSeconds() {
        return ((double) this.exclusiveTime) / 1000.0d;
    }

    public String getName() {
        return this.f52783name;
    }

    public String getScope() {
        return this.scope;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public double getStartTimeInSeconds() {
        return ((double) this.startTime) / 1000.0d;
    }

    public ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public MeasurementType getType() {
        return this.type;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isInstantaneous() {
        return this.endTime == 0;
    }

    public void setEndTime(long j11) {
        if (!logIfFinished()) {
            long j12 = this.startTime;
            if (j11 < j12) {
                AgentLog agentLog = log;
                agentLog.error("Measurement end time must not precede start time - startTime: " + j12 + " endTime: " + j11);
                return;
            }
            this.endTime = j11;
        }
    }

    public void setExclusiveTime(long j11) {
        if (!logIfFinished()) {
            this.exclusiveTime = j11;
        }
    }

    public void setName(String str) {
        if (!logIfFinished()) {
            this.f52783name = str;
        }
    }

    public void setScope(String str) {
        if (!logIfFinished()) {
            this.scope = str;
        }
    }

    public void setStartTime(long j11) {
        if (!logIfFinished()) {
            this.startTime = j11;
        }
    }

    public void setThreadInfo(ThreadInfo threadInfo2) {
        this.threadInfo = threadInfo2;
    }

    public void setType(MeasurementType measurementType) {
        if (!logIfFinished()) {
            this.type = measurementType;
        }
    }

    public String toString() {
        MeasurementType measurementType = this.type;
        String str = this.f52783name;
        String str2 = this.scope;
        long j11 = this.startTime;
        long j12 = this.endTime;
        long j13 = this.exclusiveTime;
        ThreadInfo threadInfo2 = this.threadInfo;
        boolean z11 = this.finished;
        return "BaseMeasurement{type=" + measurementType + ", name='" + str + "', scope='" + str2 + "', startTime=" + j11 + ", endTime=" + j12 + ", exclusiveTime=" + j13 + ", threadInfo=" + threadInfo2 + ", finished=" + z11 + "}";
    }

    public BaseMeasurement(Measurement measurement) {
        setType(measurement.getType());
        setName(measurement.getName());
        setScope(measurement.getScope());
        setStartTime(measurement.getStartTime());
        setEndTime(measurement.getEndTime());
        setExclusiveTime(measurement.getExclusiveTime());
        setThreadInfo(measurement.getThreadInfo());
        this.finished = measurement.isFinished();
    }
}
