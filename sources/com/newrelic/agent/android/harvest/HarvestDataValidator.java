package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Iterator;
import java.util.List;

public class HarvestDataValidator extends HarvestAdapter {
    public void ensureActivityNameMetricsExist() {
        MachineMeasurements metrics;
        HarvestData harvestData = Harvest.getInstance().getHarvestData();
        ActivityTraces activityTraces = harvestData.getActivityTraces();
        if (activityTraces != null && activityTraces.count() != 0 && (metrics = harvestData.getMetrics()) != null && !metrics.isEmpty()) {
            for (ActivityTrace activityTrace : activityTraces.getActivityTraces()) {
                String str = activityTrace.rootTrace.displayName;
                int indexOf = str.indexOf("#");
                boolean z11 = false;
                if (indexOf > 0) {
                    str = str.substring(0, indexOf);
                }
                String str2 = TraceMachine.ACTIVITY_METRIC_PREFIX + str;
                List<Metric> allUnscoped = metrics.getMetrics().getAllUnscoped();
                if (allUnscoped != null && allUnscoped.size() > 0) {
                    Iterator<Metric> it = allUnscoped.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getName().startsWith(str2)) {
                                z11 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z11) {
                    Metric metric = new Metric(str2);
                    metric.sample(1.0d);
                    metrics.addMetric(metric);
                }
            }
        }
    }

    public void onHarvestFinalize() {
        if (Harvest.isInitialized()) {
            ensureActivityNameMetricsExist();
        }
    }
}
