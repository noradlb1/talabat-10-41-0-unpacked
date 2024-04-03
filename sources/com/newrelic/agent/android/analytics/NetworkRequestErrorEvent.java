package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.HttpTransaction;
import java.util.Set;

public class NetworkRequestErrorEvent extends AnalyticsEvent {
    static final String DISABLE_FF_RESPONSE = "NEWRELIC_RESPONSE_BODY_CAPTURE_DISABLED";

    public NetworkRequestErrorEvent(Set<AnalyticsAttribute> set) {
        super((String) null, AnalyticsEventCategory.RequestError, AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST_ERROR, set);
    }

    public static Set<AnalyticsAttribute> createErrorAttributeSet(HttpTransaction httpTransaction) {
        String str;
        Set<AnalyticsAttribute> createDefaultAttributeSet = NetworkRequestEvent.createDefaultAttributeSet(httpTransaction);
        if (FeatureFlag.featureEnabled(FeatureFlag.HttpResponseBodyCapture)) {
            String responseBody = httpTransaction.getResponseBody();
            if (responseBody != null && !responseBody.isEmpty()) {
                if (responseBody.length() > 4096) {
                    AnalyticsEvent.log.warn("NetworkRequestErrorEvent: truncating response body to 4096 bytes");
                    responseBody = responseBody.substring(0, 4096);
                }
                String encodeNoWrap = Agent.getEncoder().encodeNoWrap(responseBody.getBytes());
                if (encodeNoWrap != null && !encodeNoWrap.isEmpty()) {
                    createDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.RESPONSE_BODY_ATTRIBUTE, encodeNoWrap));
                }
            }
        } else {
            createDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.RESPONSE_BODY_ATTRIBUTE, DISABLE_FF_RESPONSE));
        }
        String appData = httpTransaction.getAppData();
        if (appData != null && !appData.isEmpty()) {
            createDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.APP_DATA_ATTRIBUTE, appData));
        }
        if (!(httpTransaction.getParams() == null || (str = httpTransaction.getParams().get("content_type")) == null || str.isEmpty())) {
            createDefaultAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE, str));
        }
        return createDefaultAttributeSet;
    }

    public static NetworkRequestErrorEvent createHttpErrorEvent(HttpTransaction httpTransaction) {
        Set<AnalyticsAttribute> createErrorAttributeSet = createErrorAttributeSet(httpTransaction);
        createErrorAttributeSet.add(new AnalyticsAttribute("statusCode", (double) httpTransaction.getStatusCode()));
        return new NetworkRequestErrorEvent(createErrorAttributeSet);
    }

    public static NetworkRequestErrorEvent createNetworkFailureEvent(HttpTransaction httpTransaction) {
        Set<AnalyticsAttribute> createErrorAttributeSet = createErrorAttributeSet(httpTransaction);
        createErrorAttributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.NETWORK_ERROR_CODE_ATTRIBUTE, (double) httpTransaction.getErrorCode()));
        return new NetworkRequestErrorEvent(createErrorAttributeSet);
    }
}
