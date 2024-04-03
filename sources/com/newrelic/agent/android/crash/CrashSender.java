package com.newrelic.agent.android.crash;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class CrashSender extends PayloadSender {
    private static final String CRASH_COLLECTOR_PATH = "/mobile_crash";
    public static final int CRASH_COLLECTOR_TIMEOUT = 5000;
    private final Crash crash;

    public CrashSender(Crash crash2, AgentConfiguration agentConfiguration) {
        super(crash2.toJsonString().getBytes(), agentConfiguration);
        this.crash = crash2;
    }

    public HttpURLConnection getConnection() throws IOException {
        String protocol = getProtocol();
        String crashCollectorHost = this.agentConfiguration.getCrashCollectorHost();
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(protocol + crashCollectorHost + CRASH_COLLECTOR_PATH).openConnection()));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppTokenHeader(), this.agentConfiguration.getApplicationToken());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getDeviceOsNameHeader(), Agent.getDeviceInformation().getOsName());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppVersionHeader(), Agent.getApplicationInformation().getAppVersion());
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        return httpURLConnection;
    }

    public void onFailedUpload(String str) {
        AgentLog agentLog = PayloadSender.log;
        agentLog.error("CrashSender: " + str);
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_FAILED_UPLOAD);
    }

    public void onRequestException(Exception exc) {
        AgentLog agentLog = PayloadSender.log;
        agentLog.error("CrashSender: Crash upload failed: " + exc);
    }

    public void onRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200 || responseCode == 202) {
            StatsEngine.get().sampleTimeMs(MetricNames.SUPPORTABILITY_CRASH_UPLOAD_TIME, this.timer.peek());
            AgentLog agentLog = PayloadSender.log;
            String uuid = this.crash.getUuid().toString();
            agentLog.info("CrashSender: Crash " + uuid + " successfully submitted.");
        } else if (responseCode == 408) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_UPLOAD_TIMEOUT);
            String uuid2 = this.payload.getUuid();
            onFailedUpload("The request to submit the payload [" + uuid2 + "] has timed out - (will try again later) - Response code [" + responseCode + "]");
        } else if (responseCode == 429) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_UPLOAD_THROTTLED);
            String uuid3 = this.payload.getUuid();
            onFailedUpload("The request to submit the payload [" + uuid3 + "] was has timed out - (will try again later) - Response code [" + responseCode + "]");
        } else if (responseCode != 500) {
            int responseCode2 = httpURLConnection.getResponseCode();
            onFailedUpload("Something went wrong while submitting a crash (will try again later) - Response code " + responseCode2);
        } else {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_REMOVED_REJECTED);
            int responseCode3 = httpURLConnection.getResponseCode();
            onFailedUpload("The crash was rejected and will be deleted - Response code " + responseCode3);
        }
        AgentLog agentLog2 = PayloadSender.log;
        long cVar = this.timer.toc();
        agentLog2.debug("CrashSender: Crash collection took " + cVar + "ms");
    }

    public boolean shouldUploadOpportunistically() {
        return Agent.hasReachableNetworkConnection((String) null);
    }

    public PayloadSender call() {
        setPayload(this.crash.toJsonString().getBytes());
        this.crash.incrementUploadCount();
        this.agentConfiguration.getCrashStore().store(this.crash);
        try {
            return super.call();
        } catch (Exception e11) {
            onFailedUpload("Unable to report crash to New Relic, will try again later. " + e11);
            return this;
        }
    }
}
