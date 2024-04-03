package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

public class NetworkEventController {
    static final AgentLog log = AgentLogManager.getAgentLog();

    public static void createHttpErrorEvent(HttpTransaction httpTransaction) {
        if (!FeatureFlag.featureEnabled(FeatureFlag.NetworkErrorRequests)) {
            return;
        }
        if (!AnalyticsControllerImpl.getInstance().addEvent(NetworkRequestErrorEvent.createHttpErrorEvent(httpTransaction))) {
            log.error("Failed to add MobileRequestError");
            return;
        }
        AgentLog agentLog = log;
        String obj = AnalyticsEventCategory.RequestError.toString();
        String url = httpTransaction.getUrl();
        agentLog.audit(obj + " added to event store for request: " + url);
    }

    public static void createNetworkFailureEvent(HttpTransaction httpTransaction) {
        if (!FeatureFlag.featureEnabled(FeatureFlag.NetworkErrorRequests)) {
            return;
        }
        if (!AnalyticsControllerImpl.getInstance().addEvent(NetworkRequestErrorEvent.createNetworkFailureEvent(httpTransaction))) {
            log.error("Failed to add MobileRequestError");
            return;
        }
        AgentLog agentLog = log;
        String obj = AnalyticsEventCategory.RequestError.toString();
        String url = httpTransaction.getUrl();
        agentLog.audit(obj + " added to event store for request: " + url);
    }

    public static void createNetworkRequestEvent(HttpTransaction httpTransaction) {
        if (!FeatureFlag.featureEnabled(FeatureFlag.NetworkRequests)) {
            return;
        }
        if (!AnalyticsControllerImpl.getInstance().addEvent(NetworkRequestEvent.createNetworkEvent(httpTransaction))) {
            log.error("Failed to add MobileRequest");
            return;
        }
        AgentLog agentLog = log;
        String obj = AnalyticsEventCategory.NetworkRequest.toString();
        String url = httpTransaction.getUrl();
        agentLog.audit(obj + " added to event store for request: " + url);
    }
}
