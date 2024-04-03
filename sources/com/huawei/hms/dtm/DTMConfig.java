package com.huawei.hms.dtm;

import java.util.HashMap;
import java.util.Map;

public class DTMConfig {
    public static final String AIOPS_ENABLED = "aiops_enabled";
    public static final String ANALYTICS_ENABLED = "analyticsEnabled";
    public static final String JSON_SCHEDULE_INTERVAL = "json_schedule_interval";
    public static final String REGION = "region";
    public final Map<Object, Object> config = new HashMap();

    public Map<Object, Object> getConfig() {
        return this.config;
    }

    public DTMConfig setAiopsEnabled(boolean z11) {
        this.config.put(AIOPS_ENABLED, Boolean.valueOf(z11));
        return this;
    }

    public DTMConfig setAnalyticsEnabled(boolean z11) {
        this.config.put(ANALYTICS_ENABLED, Boolean.valueOf(z11));
        return this;
    }

    public DTMConfig setJsonScheduleInterval(long j11) {
        this.config.put(JSON_SCHEDULE_INTERVAL, Long.valueOf(j11));
        return this;
    }

    public DTMConfig setRegion(String str) {
        this.config.put("region", str);
        return this;
    }
}
