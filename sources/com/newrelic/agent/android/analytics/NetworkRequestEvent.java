package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.logging.AgentLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NetworkRequestEvent extends AnalyticsEvent {
    public NetworkRequestEvent(Set<AnalyticsAttribute> set) {
        super((String) null, AnalyticsEventCategory.NetworkRequest, AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST, set);
    }

    public static Set<AnalyticsAttribute> createDefaultAttributeSet(HttpTransaction httpTransaction) {
        TraceContext traceContext;
        Map<String, Object> map;
        HashSet hashSet = new HashSet();
        try {
            URL url = new URL(httpTransaction.getUrl());
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_DOMAIN_ATTRIBUTE, url.getHost()));
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_PATH_ATTRIBUTE, url.getPath()));
        } catch (MalformedURLException unused) {
            AgentLog agentLog = AnalyticsEvent.log;
            String url2 = httpTransaction.getUrl();
            agentLog.error(url2 + " is not a valid URL. Unable to set host or path attributes.");
        }
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE, httpTransaction.getUrl()));
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.CONNECTION_TYPE_ATTRIBUTE, httpTransaction.getWanType()));
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.REQUEST_METHOD_ATTRIBUTE, httpTransaction.getHttpMethod()));
        double totalTime = httpTransaction.getTotalTime();
        if (totalTime != 0.0d) {
            hashSet.add(new AnalyticsAttribute("responseTime", totalTime));
        }
        double bytesSent = (double) httpTransaction.getBytesSent();
        if (bytesSent != 0.0d) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_SENT_ATTRIBUTE, bytesSent));
        }
        double bytesReceived = (double) httpTransaction.getBytesReceived();
        if (bytesReceived != 0.0d) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_RECEIVED_ATTRIBUTE, bytesReceived));
        }
        if (httpTransaction.getParams() != null) {
            for (String next : httpTransaction.getParams().keySet()) {
                hashSet.add(new AnalyticsAttribute(next, httpTransaction.getParams().get(next)));
            }
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing) && !((traceContext = httpTransaction.getTraceContext()) == null && httpTransaction.getTraceAttributes() == null)) {
            try {
                AnalyticsValidator analyticsValidator = AnalyticsEvent.validator;
                if (traceContext != null) {
                    map = traceContext.asTraceAttributes();
                } else {
                    map = httpTransaction.getTraceAttributes();
                }
                hashSet.addAll(analyticsValidator.toValidatedAnalyticsAttributes(map));
            } catch (Exception e11) {
                AnalyticsEvent.log.error("Error occurred parsing the instrinsic attribute set: ", e11);
            }
        }
        return hashSet;
    }

    public static NetworkRequestEvent createNetworkEvent(HttpTransaction httpTransaction) {
        Set<AnalyticsAttribute> createDefaultAttributeSet = createDefaultAttributeSet(httpTransaction);
        createDefaultAttributeSet.add(new AnalyticsAttribute("responseTime", httpTransaction.getTotalTime()));
        createDefaultAttributeSet.add(new AnalyticsAttribute("statusCode", (double) httpTransaction.getStatusCode()));
        createDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_SENT_ATTRIBUTE, (double) httpTransaction.getBytesSent()));
        createDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.BYTES_RECEIVED_ATTRIBUTE, (double) httpTransaction.getBytesReceived()));
        return new NetworkRequestEvent(createDefaultAttributeSet);
    }
}
