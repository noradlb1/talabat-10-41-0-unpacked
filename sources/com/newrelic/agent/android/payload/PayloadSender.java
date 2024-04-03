package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.TicToc;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public abstract class PayloadSender implements Callable<PayloadSender> {
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected final AgentConfiguration agentConfiguration;
    protected Payload payload;
    protected int responseCode;
    protected final TicToc timer;

    public interface CompletionHandler {
        void onException(PayloadSender payloadSender, Exception exc);

        void onResponse(PayloadSender payloadSender);
    }

    public PayloadSender(AgentConfiguration agentConfiguration2) {
        this.agentConfiguration = agentConfiguration2;
        this.timer = new TicToc();
        this.responseCode = 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PayloadSender) || getPayload() != ((PayloadSender) obj).getPayload()) {
            return false;
        }
        return true;
    }

    public abstract HttpURLConnection getConnection() throws IOException;

    public Payload getPayload() {
        return this.payload;
    }

    public String getProtocol() {
        return "https://";
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public boolean isSuccessfulResponse() {
        int i11 = this.responseCode;
        return i11 == 200 || i11 == 202 || i11 == 500;
    }

    public void onFailedUpload(String str) {
        log.error(str);
    }

    public void onRequestContent(String str) {
    }

    public void onRequestException(Exception exc) {
        String uuid = this.payload.getUuid();
        onFailedUpload("Payload [" + uuid + "] upload failed: " + exc);
    }

    public void onRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode2 = httpURLConnection.getResponseCode();
        if (responseCode2 == 200 || responseCode2 == 202) {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                onRequestContent(readStream(inputStream, inputStream.available()));
            }
        } else {
            if (responseCode2 != 403) {
                if (responseCode2 == 408) {
                    String uuid = this.payload.getUuid();
                    onFailedUpload("The request to submit the payload [" + uuid + "] has timed out (will try again later) - Response code [" + responseCode2 + "]");
                } else if (responseCode2 == 429) {
                    String uuid2 = this.payload.getUuid();
                    onFailedUpload("The request to submit the payload [" + uuid2 + "] was throttled (will try again later) - Response code [" + responseCode2 + "]");
                } else if (responseCode2 != 500) {
                    String uuid3 = this.payload.getUuid();
                    onFailedUpload("Something went wrong while submitting the payload [" + uuid3 + "] (will try again later) - Response code [" + responseCode2 + "]");
                }
            }
            String uuid4 = this.payload.getUuid();
            onFailedUpload("Payload [" + uuid4 + "] was rejected and will be deleted - Response code [" + responseCode2 + "]");
        }
        AgentLog agentLog = log;
        String uuid5 = this.payload.getUuid();
        long cVar = this.timer.toc();
        agentLog.debug("Payload [" + uuid5 + "] delivery took " + cVar + "ms");
    }

    public String readStream(InputStream inputStream, int i11) throws IOException {
        String str;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        try {
            char[] cArr = new char[i11];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11 && i13 != -1) {
                i12 += i13;
                i13 = inputStreamReader.read(cArr, i12, i11 - i12);
            }
            if (i12 != -1) {
                str = new String(cArr, 0, Math.min(i12, i11));
            } else {
                str = null;
            }
            inputStreamReader.close();
            return str;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void setPayload(byte[] bArr) {
        this.payload.putBytes(bArr);
    }

    public boolean shouldRetry() {
        return false;
    }

    public boolean shouldUploadOpportunistically() {
        return Agent.hasReachableNetworkConnection((String) null);
    }

    public PayloadSender call() throws Exception {
        HttpURLConnection connection;
        BufferedOutputStream bufferedOutputStream;
        try {
            this.timer.tic();
            connection = getConnection();
            connection.setFixedLengthStreamingMode(this.payload.getBytes().length);
            connection.setRequestProperty("Content-Length", Integer.toString(this.payload.getBytes().length));
            try {
                connection.connect();
                bufferedOutputStream = new BufferedOutputStream(connection.getOutputStream());
                bufferedOutputStream.write(this.payload.getBytes());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                this.responseCode = connection.getResponseCode();
                onRequestResponse(connection);
            } catch (Exception e11) {
                onRequestException(e11);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            connection.disconnect();
            return this;
            throw th;
        } catch (Exception e12) {
            String uuid = this.payload.getUuid();
            onFailedUpload("Unable to upload payload [" + uuid + "]  to New Relic, will try again later. " + e12);
            return this;
        } catch (Throwable th3) {
            connection.disconnect();
            throw th3;
        }
    }

    public PayloadSender(Payload payload2, AgentConfiguration agentConfiguration2) {
        this(agentConfiguration2);
        this.payload = payload2;
    }

    public PayloadSender(byte[] bArr, AgentConfiguration agentConfiguration2) {
        this(agentConfiguration2);
        this.payload = new Payload(bArr);
    }
}
