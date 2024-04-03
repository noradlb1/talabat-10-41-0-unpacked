package com.newrelic.agent.android.instrumentation;

import com.google.firebase.perf.metrics.resource.ResourceType;
import java.util.HashMap;
import java.util.Map;

public enum MetricCategory {
    NONE("None"),
    VIEW_LOADING("View Loading"),
    VIEW_LAYOUT("Layout"),
    DATABASE("Database"),
    IMAGE("Images"),
    JSON("JSON"),
    NETWORK(ResourceType.NETWORK);
    
    private static final Map<String, MetricCategory> methodMap = null;
    private String categoryName;

    /* access modifiers changed from: public */
    static {
        methodMap = new HashMap<String, MetricCategory>() {
            {
                put("onCreate", MetricCategory.VIEW_LOADING);
            }
        };
    }

    private MetricCategory(String str) {
        this.categoryName = str;
    }

    public static MetricCategory categoryForMethod(String str) {
        String str2;
        if (str == null) {
            return NONE;
        }
        int indexOf = str.indexOf("#");
        if (indexOf >= 0) {
            str2 = str.substring(indexOf + 1);
        } else {
            str2 = null;
        }
        MetricCategory metricCategory = methodMap.get(str2);
        if (metricCategory == null) {
            return NONE;
        }
        return metricCategory;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
