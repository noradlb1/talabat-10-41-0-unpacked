package com.newrelic.agent.android.metric;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricStore {
    private final Map<String, Map<String, Metric>> metricStore = new ConcurrentHashMap();

    public void add(Metric metric) {
        String stringScope = metric.getStringScope();
        String name2 = metric.getName();
        if (!this.metricStore.containsKey(stringScope)) {
            this.metricStore.put(stringScope, new HashMap());
        }
        if (this.metricStore.get(stringScope).containsKey(name2)) {
            ((Metric) this.metricStore.get(stringScope).get(name2)).aggregate(metric);
        } else {
            this.metricStore.get(stringScope).put(name2, metric);
        }
    }

    public void clear() {
        this.metricStore.clear();
    }

    public Metric get(String str) {
        return get(str, "");
    }

    public List<Metric> getAll() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Map<String, Metric>> value : this.metricStore.entrySet()) {
            for (Map.Entry value2 : ((Map) value.getValue()).entrySet()) {
                arrayList.add((Metric) value2.getValue());
            }
        }
        return arrayList;
    }

    public List<Metric> getAllByScope(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry value : this.metricStore.get(str).entrySet()) {
                arrayList.add((Metric) value.getValue());
            }
        } catch (NullPointerException unused) {
        }
        return arrayList;
    }

    public List<Metric> getAllUnscoped() {
        return getAllByScope("");
    }

    public boolean isEmpty() {
        return this.metricStore.isEmpty();
    }

    public void remove(Metric metric) {
        String stringScope = metric.getStringScope();
        String name2 = metric.getName();
        if (this.metricStore.containsKey(stringScope) && this.metricStore.get(stringScope).containsKey(name2)) {
            this.metricStore.get(stringScope).remove(name2);
        }
    }

    public void removeAll(List<Metric> list) {
        synchronized (this.metricStore) {
            for (Metric remove : list) {
                remove(remove);
            }
        }
    }

    public List<Metric> removeAllWithScope(String str) {
        List<Metric> allByScope = getAllByScope(str);
        if (!allByScope.isEmpty()) {
            removeAll(allByScope);
        }
        return allByScope;
    }

    public Metric get(String str, String str2) {
        try {
            Map<String, Map<String, Metric>> map = this.metricStore;
            if (str2 == null) {
                str2 = "";
            }
            return (Metric) map.get(str2).get(str);
        } catch (NullPointerException unused) {
            return null;
        }
    }
}
