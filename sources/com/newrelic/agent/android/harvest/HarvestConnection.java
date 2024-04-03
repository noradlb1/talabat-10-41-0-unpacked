package com.newrelic.agent.android.harvest;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.Deflator;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class HarvestConnection implements HarvestErrorCodes {
    private static final String COLLECTOR_CONNECT_URI = "/mobile/v4/connect";
    private static final String COLLECTOR_DATA_URI = "/mobile/v3/data";
    private static final int CONNECTION_TIMEOUT;
    private static final int MAX_PLAINTEXT_MESSAGE_SIZE = 512;
    private static final int READ_TIMEOUT;
    private static final int READ_TIMEOUT_IN_SECONDS = 4;
    private static final int RESPONSE_BUFFER_SIZE = 8192;
    private static final int TIMEOUT_IN_SECONDS = 20;
    private String applicationToken;
    private String collectorHost;
    private ConnectInformation connectInformation;
    private final AgentLog log = AgentLogManager.getAgentLog();
    private long serverTimestamp;
    private boolean useSsl = true;

    static {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        CONNECTION_TIMEOUT = (int) timeUnit.convert(20, timeUnit2);
        READ_TIMEOUT = (int) timeUnit.convert(4, timeUnit2);
    }

    private String getCollectorConnectUri() {
        return getCollectorUri(COLLECTOR_CONNECT_URI);
    }

    private String getCollectorDataUri() {
        return getCollectorUri(COLLECTOR_DATA_URI);
    }

    private String getCollectorUri(String str) {
        String str2 = this.collectorHost;
        return "https://" + str2 + str;
    }

    private void recordCollectorError(Exception exc) {
        AgentLog agentLog = this.log;
        String name2 = exc.getClass().getName();
        agentLog.error("HarvestConnection: Attempting to convert network exception " + name2 + " to error code.");
        StatsEngine statsEngine = StatsEngine.get();
        int exceptionToErrorCode = ExceptionHelper.exceptionToErrorCode(exc);
        statsEngine.inc("Supportability/AgentHealth/Collector/ResponseErrorCodes/" + exceptionToErrorCode);
    }

    public HttpURLConnection createConnectPost() {
        return createPost(getCollectorConnectUri());
    }

    public HttpURLConnection createDataPost() {
        return createPost(getCollectorDataUri());
    }

    public HttpURLConnection createPost(String str) {
        HttpURLConnection httpURLConnection;
        Exception e11;
        try {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                httpURLConnection.setReadTimeout(READ_TIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty(Constants.Network.APPLICATION_LICENSE_HEADER, this.applicationToken);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                String property = System.getProperty("http.agent");
                if (property != null && property.length() > 0) {
                    httpURLConnection.setRequestProperty("User-Agent", property);
                }
                long j11 = this.serverTimestamp;
                if (j11 != 0) {
                    httpURLConnection.setRequestProperty(Constants.Network.CONNECT_TIME_HEADER, Long.valueOf(j11).toString());
                }
            } catch (Exception e12) {
                e11 = e12;
                StatsEngine.get().inc("Supportability/AgentHealth/Collector/Connection/Errors");
                this.log.error("Failed to create data POST: " + e11.getMessage());
                return httpURLConnection;
            }
        } catch (Exception e13) {
            e11 = e13;
            httpURLConnection = null;
            StatsEngine.get().inc("Supportability/AgentHealth/Collector/Connection/Errors");
            this.log.error("Failed to create data POST: " + e11.getMessage());
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    public String readResponse(HttpURLConnection httpURLConnection) throws IOException {
        try {
            return readStream(httpURLConnection.getInputStream());
        } catch (IOException unused) {
            return readStream(httpURLConnection.getErrorStream());
        }
    }

    public String readStream(InputStream inputStream) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        if (inputStream != null) {
            char[] cArr = new char[8192];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    int read = bufferedReader.read(cArr);
                    if (read < 0) {
                        break;
                    }
                    sb2.append(cArr, 0, read);
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            bufferedReader.close();
        }
        return sb2.toString();
        throw th;
    }

    /* JADX INFO: finally extract failed */
    public HarvestResponse send(HttpURLConnection httpURLConnection, String str) {
        String str2;
        ByteBuffer byteBuffer;
        BufferedOutputStream bufferedOutputStream;
        float f11;
        HarvestResponse harvestResponse = new HarvestResponse();
        if (str.length() <= 512) {
            str2 = Constants.Network.ContentType.IDENTITY;
        } else {
            str2 = "deflate";
        }
        try {
            TicToc ticToc = new TicToc();
            ticToc.tic();
            if ("deflate".equals(str2.toLowerCase())) {
                byteBuffer = ByteBuffer.wrap(Deflator.deflate(str.getBytes()));
            } else {
                byteBuffer = ByteBuffer.wrap(str.getBytes());
            }
            httpURLConnection.setFixedLengthStreamingMode(byteBuffer.array().length);
            httpURLConnection.setRequestProperty("Content-Encoding", str2);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(byteBuffer.array());
            bufferedOutputStream.close();
            harvestResponse.setResponseTime(ticToc.toc());
            harvestResponse.setStatusCode(httpURLConnection.getResponseCode());
            harvestResponse.setResponseBody(readResponse(httpURLConnection));
            String replace = MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR);
            if (httpURLConnection.getURL().getFile().contains(COLLECTOR_CONNECT_URI)) {
                replace = replace.replace(MetricNames.TAG_SUBDESTINATION, "connect");
            } else if (httpURLConnection.getURL().getFile().contains(COLLECTOR_DATA_URI)) {
                replace = replace.replace(MetricNames.TAG_SUBDESTINATION, "data");
            }
            if (harvestResponse.getResponseBody() == null) {
                f11 = 0.0f;
            } else {
                f11 = (float) harvestResponse.getResponseBody().length();
            }
            StatsEngine.get().sampleMetricDataUsage(replace, (float) byteBuffer.array().length, f11);
        } catch (IOException e11) {
            AgentLog agentLog = this.log;
            String message = e11.getMessage();
            agentLog.error("Failed to retrieve collector response: " + message);
            recordCollectorError(e11);
        } catch (Exception e12) {
            try {
                AgentLog agentLog2 = this.log;
                String message2 = e12.getMessage();
                agentLog2.error("Failed to send POST to collector: " + message2);
                recordCollectorError(e12);
                httpURLConnection.disconnect();
                return null;
            } catch (Throwable th2) {
                httpURLConnection.disconnect();
                throw th2;
            }
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
        httpURLConnection.disconnect();
        return harvestResponse;
        throw th;
    }

    public HarvestResponse sendConnect() {
        if (this.connectInformation != null) {
            HttpURLConnection createConnectPost = createConnectPost();
            if (createConnectPost == null) {
                this.log.error("Failed to create connect POST");
                return null;
            }
            TicToc ticToc = new TicToc();
            ticToc.tic();
            HarvestResponse send = send(createConnectPost, this.connectInformation.toJsonString());
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Connect", ticToc.toc());
            return send;
        }
        throw new IllegalArgumentException();
    }

    public HarvestResponse sendData(Harvestable harvestable) {
        if (harvestable != null) {
            HttpURLConnection createDataPost = createDataPost();
            if (createDataPost != null) {
                return send(createDataPost, harvestable.toJsonString());
            }
            this.log.error("Failed to create data POST");
            return null;
        }
        throw new IllegalArgumentException();
    }

    public void setApplicationToken(String str) {
        this.applicationToken = str;
    }

    public void setCollectorHost(String str) {
        this.collectorHost = str;
    }

    public void setConnectInformation(ConnectInformation connectInformation2) {
        this.connectInformation = connectInformation2;
    }

    public void setServerTimestamp(long j11) {
        AgentLog agentLog = this.log;
        agentLog.debug("Setting server timestamp: " + j11);
        this.serverTimestamp = j11;
    }

    public void useSsl(boolean z11) {
        if (!z11) {
            this.log.error("Unencrypted http requests are no longer supported");
        }
        this.useSsl = true;
    }
}
