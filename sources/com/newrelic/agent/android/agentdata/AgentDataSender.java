package com.newrelic.agent.android.agentdata;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.Payload;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AgentDataSender extends PayloadSender {
    public AgentDataSender(byte[] bArr, AgentConfiguration agentConfiguration) {
        super(bArr, agentConfiguration);
    }

    public HttpURLConnection getConnection() throws IOException {
        String protocol = getProtocol();
        String hexCollectorHost = this.agentConfiguration.getHexCollectorHost();
        String hexCollectorPath = this.agentConfiguration.getHexCollectorPath();
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(protocol + hexCollectorHost + hexCollectorPath).openConnection()));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", Constants.Network.ContentType.OCTET_STREAM);
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppTokenHeader(), this.agentConfiguration.getApplicationToken());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getDeviceOsNameHeader(), Agent.getDeviceInformation().getOsName());
        httpURLConnection.setRequestProperty(this.agentConfiguration.getAppVersionHeader(), Agent.getApplicationInformation().getAppVersion());
        httpURLConnection.setConnectTimeout(this.agentConfiguration.getHexCollectorTimeout());
        httpURLConnection.setReadTimeout(this.agentConfiguration.getHexCollectorTimeout());
        return httpURLConnection;
    }

    public void onFailedUpload(String str) {
        PayloadSender.log.error(str);
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HEX_FAILED_UPLOAD);
    }

    public void onRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200 || responseCode == 202) {
            StatsEngine.get().sampleTimeMs(MetricNames.SUPPORTABILITY_HEX_UPLOAD_TIME, this.timer.peek());
        } else {
            if (responseCode != 403) {
                if (responseCode == 408) {
                    String uuid = this.payload.getUuid();
                    onFailedUpload("The request to submit the payload [" + uuid + "] has timed out (will try again later) - Response code [" + responseCode + "]");
                    StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HEX_UPLOAD_TIMEOUT);
                } else if (responseCode == 429) {
                    String uuid2 = this.payload.getUuid();
                    onFailedUpload("The request to submit the payload [" + uuid2 + "] was throttled (will try again later) - Response code [" + responseCode + "]");
                    StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HEX_UPLOAD_THROTTLED);
                } else if (responseCode != 500) {
                    String uuid3 = this.payload.getUuid();
                    onFailedUpload("Something went wrong while submitting the payload [" + uuid3 + "] - (will try again later) - Response code [" + responseCode + "]");
                }
            }
            String uuid4 = this.payload.getUuid();
            onFailedUpload("The data payload [" + uuid4 + "] was rejected and will be deleted - Response code [" + responseCode + "]");
            StatsEngine.get().sampleTimeMs(MetricNames.SUPPORTABILITY_HEX_FAILED_UPLOAD, this.timer.peek());
        }
        AgentLog agentLog = PayloadSender.log;
        String uuid5 = this.payload.getUuid();
        long cVar = this.timer.toc();
        agentLog.debug("Payload [" + uuid5 + "] delivery took " + cVar + "ms");
    }

    public boolean shouldUploadOpportunistically() {
        return PayloadController.shouldUploadOpportunistically();
    }

    public AgentDataSender(Payload payload, AgentConfiguration agentConfiguration) {
        super(payload, agentConfiguration);
    }
}
