package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;

public abstract class MetricMeasurementConsumer extends BaseMeasurementConsumer {
    protected MetricStore metrics = new MetricStore();
    protected boolean recordUnscopedMetrics = true;

    public MetricMeasurementConsumer(MeasurementType measurementType) {
        super(measurementType);
        Harvest.addHarvestListener(this);
    }

    public void addMetric(Metric metric) {
        Metric metric2;
        if (metric.getScope() != null) {
            metric2 = this.metrics.get(metric.getName(), metric.getScope());
        } else {
            metric2 = this.metrics.get(metric.getName());
        }
        if (metric2 != null) {
            metric2.aggregate(metric);
        } else {
            this.metrics.add(metric);
        }
    }

    public void consumeMeasurement(Measurement measurement) {
        String formatMetricName = formatMetricName(measurement.getName());
        String scope = measurement.getScope();
        double endTimeInSeconds = measurement.getEndTimeInSeconds() - measurement.getStartTimeInSeconds();
        if (scope != null) {
            Metric metric = this.metrics.get(formatMetricName, scope);
            if (metric == null) {
                metric = new Metric(formatMetricName, scope);
                this.metrics.add(metric);
            }
            metric.sample(endTimeInSeconds);
            metric.addExclusive(measurement.getExclusiveTimeInSeconds());
        }
        if (this.recordUnscopedMetrics) {
            Metric metric2 = this.metrics.get(formatMetricName);
            if (metric2 == null) {
                metric2 = new Metric(formatMetricName);
                this.metrics.add(metric2);
            }
            metric2.sample(endTimeInSeconds);
            metric2.addExclusive(measurement.getExclusiveTimeInSeconds());
        }
    }

    public abstract String formatMetricName(String str);

    public void onHarvest() {
        for (Metric addMetric : this.metrics.getAll()) {
            Harvest.addMetric(addMetric);
        }
    }

    public void onHarvestComplete() {
        this.metrics.clear();
    }

    public void onHarvestError() {
        this.metrics.clear();
    }

    public void onHarvestSendFailed() {
        this.metrics.clear();
    }
}
