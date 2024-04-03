package com.newrelic.agent.android.activity.config;

public class ActivityTraceConfiguration {
    private int maxTotalTraceCount;

    public static ActivityTraceConfiguration defaultActivityTraceConfiguration() {
        ActivityTraceConfiguration activityTraceConfiguration = new ActivityTraceConfiguration();
        activityTraceConfiguration.setMaxTotalTraceCount(1);
        return activityTraceConfiguration;
    }

    public int getMaxTotalTraceCount() {
        return this.maxTotalTraceCount;
    }

    public void setMaxTotalTraceCount(int i11) {
        this.maxTotalTraceCount = i11;
    }

    public String toString() {
        int i11 = this.maxTotalTraceCount;
        return "ActivityTraceConfiguration{maxTotalTraceCount=" + i11 + "}";
    }
}
