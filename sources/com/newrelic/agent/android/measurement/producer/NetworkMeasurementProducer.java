package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Util;

public class NetworkMeasurementProducer extends BaseMeasurementProducer {
    public NetworkMeasurementProducer() {
        super(MeasurementType.Network);
    }

    public void produceMeasurement(String str, String str2, int i11, int i12, long j11, double d11, long j12, long j13, String str3) {
        String sanitizeUrl = Util.sanitizeUrl(str);
        if (sanitizeUrl != null) {
            produceMeasurement(new HttpTransactionMeasurement(sanitizeUrl, str2, i11, i12, j11, d11, j12, j13, str3));
        }
    }

    public void produceMeasurement(HttpTransactionMeasurement httpTransactionMeasurement) {
        String sanitizeUrl = Util.sanitizeUrl(httpTransactionMeasurement.getUrl());
        if (sanitizeUrl != null) {
            httpTransactionMeasurement.setUrl(sanitizeUrl);
            super.produceMeasurement(httpTransactionMeasurement);
        }
    }
}
