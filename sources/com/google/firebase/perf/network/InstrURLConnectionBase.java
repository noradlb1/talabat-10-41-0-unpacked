package com.google.firebase.perf.network;

import android.os.Build;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

class InstrURLConnectionBase {
    private static final String USER_AGENT_PROPERTY = "User-Agent";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final HttpURLConnection httpUrlConnection;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeRequestedInMicros = -1;
    private long timeToResponseInitiatedInMicros = -1;
    private final Timer timer;

    public InstrURLConnectionBase(HttpURLConnection httpURLConnection, Timer timer2, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.httpUrlConnection = httpURLConnection;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timer = timer2;
        networkRequestMetricBuilder.setUrl(httpURLConnection.getURL().toString());
    }

    private void updateRequestInfo() {
        if (this.timeRequestedInMicros == -1) {
            this.timer.reset();
            long micros = this.timer.getMicros();
            this.timeRequestedInMicros = micros;
            this.networkMetricBuilder.setRequestStartTimeMicros(micros);
        }
        String requestMethod = getRequestMethod();
        if (requestMethod != null) {
            this.networkMetricBuilder.setHttpMethod(requestMethod);
        } else if (getDoOutput()) {
            this.networkMetricBuilder.setHttpMethod("POST");
        } else {
            this.networkMetricBuilder.setHttpMethod("GET");
        }
    }

    public void addRequestProperty(String str, String str2) {
        this.httpUrlConnection.addRequestProperty(str, str2);
    }

    public void connect() throws IOException {
        if (this.timeRequestedInMicros == -1) {
            this.timer.reset();
            long micros = this.timer.getMicros();
            this.timeRequestedInMicros = micros;
            this.networkMetricBuilder.setRequestStartTimeMicros(micros);
        }
        try {
            this.httpUrlConnection.connect();
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public void disconnect() {
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        this.networkMetricBuilder.build();
        this.httpUrlConnection.disconnect();
    }

    public boolean equals(Object obj) {
        return this.httpUrlConnection.equals(obj);
    }

    public boolean getAllowUserInteraction() {
        return this.httpUrlConnection.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.httpUrlConnection.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        try {
            Object content = this.httpUrlConnection.getContent();
            if (content instanceof InputStream) {
                this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.networkMetricBuilder, this.timer);
            }
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            this.networkMetricBuilder.setResponsePayloadBytes((long) this.httpUrlConnection.getContentLength());
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            this.networkMetricBuilder.build();
            return content;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public String getContentEncoding() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentEncoding();
    }

    public int getContentLength() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentLength();
    }

    public long getContentLengthLong() {
        updateRequestInfo();
        if (Build.VERSION.SDK_INT >= 24) {
            return this.httpUrlConnection.getContentLengthLong();
        }
        return 0;
    }

    public String getContentType() {
        updateRequestInfo();
        return this.httpUrlConnection.getContentType();
    }

    public long getDate() {
        updateRequestInfo();
        return this.httpUrlConnection.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.httpUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.httpUrlConnection.getDoInput();
    }

    public boolean getDoOutput() {
        return this.httpUrlConnection.getDoOutput();
    }

    public InputStream getErrorStream() {
        updateRequestInfo();
        try {
            this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        } catch (IOException unused) {
            logger.debug("IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.httpUrlConnection.getErrorStream();
        if (errorStream != null) {
            return new InstrHttpInputStream(errorStream, this.networkMetricBuilder, this.timer);
        }
        return errorStream;
    }

    public long getExpiration() {
        updateRequestInfo();
        return this.httpUrlConnection.getExpiration();
    }

    public String getHeaderField(int i11) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderField(i11);
    }

    public long getHeaderFieldDate(String str, long j11) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldDate(str, j11);
    }

    public int getHeaderFieldInt(String str, int i11) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldInt(str, i11);
    }

    public String getHeaderFieldKey(int i11) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFieldKey(i11);
    }

    public long getHeaderFieldLong(String str, long j11) {
        updateRequestInfo();
        if (Build.VERSION.SDK_INT >= 24) {
            return this.httpUrlConnection.getHeaderFieldLong(str, j11);
        }
        return 0;
    }

    public Map<String, List<String>> getHeaderFields() {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.httpUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
        try {
            InputStream inputStream = this.httpUrlConnection.getInputStream();
            if (inputStream != null) {
                return new InstrHttpInputStream(inputStream, this.networkMetricBuilder, this.timer);
            }
            return inputStream;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.httpUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        updateRequestInfo();
        return this.httpUrlConnection.getLastModified();
    }

    public OutputStream getOutputStream() throws IOException {
        try {
            OutputStream outputStream = this.httpUrlConnection.getOutputStream();
            if (outputStream != null) {
                return new InstrHttpOutputStream(outputStream, this.networkMetricBuilder, this.timer);
            }
            return outputStream;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public Permission getPermission() throws IOException {
        try {
            return this.httpUrlConnection.getPermission();
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public int getReadTimeout() {
        return this.httpUrlConnection.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.httpUrlConnection.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.httpUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.httpUrlConnection.getRequestProperty(str);
    }

    public int getResponseCode() throws IOException {
        updateRequestInfo();
        if (this.timeToResponseInitiatedInMicros == -1) {
            long durationMicros = this.timer.getDurationMicros();
            this.timeToResponseInitiatedInMicros = durationMicros;
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        try {
            int responseCode = this.httpUrlConnection.getResponseCode();
            this.networkMetricBuilder.setHttpResponseCode(responseCode);
            return responseCode;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public String getResponseMessage() throws IOException {
        updateRequestInfo();
        if (this.timeToResponseInitiatedInMicros == -1) {
            long durationMicros = this.timer.getDurationMicros();
            this.timeToResponseInitiatedInMicros = durationMicros;
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(durationMicros);
        }
        try {
            String responseMessage = this.httpUrlConnection.getResponseMessage();
            this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
            return responseMessage;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }

    public URL getURL() {
        return this.httpUrlConnection.getURL();
    }

    public boolean getUseCaches() {
        return this.httpUrlConnection.getUseCaches();
    }

    public int hashCode() {
        return this.httpUrlConnection.hashCode();
    }

    public void setAllowUserInteraction(boolean z11) {
        this.httpUrlConnection.setAllowUserInteraction(z11);
    }

    public void setChunkedStreamingMode(int i11) {
        this.httpUrlConnection.setChunkedStreamingMode(i11);
    }

    public void setConnectTimeout(int i11) {
        this.httpUrlConnection.setConnectTimeout(i11);
    }

    public void setDefaultUseCaches(boolean z11) {
        this.httpUrlConnection.setDefaultUseCaches(z11);
    }

    public void setDoInput(boolean z11) {
        this.httpUrlConnection.setDoInput(z11);
    }

    public void setDoOutput(boolean z11) {
        this.httpUrlConnection.setDoOutput(z11);
    }

    public void setFixedLengthStreamingMode(int i11) {
        this.httpUrlConnection.setFixedLengthStreamingMode(i11);
    }

    public void setIfModifiedSince(long j11) {
        this.httpUrlConnection.setIfModifiedSince(j11);
    }

    public void setInstanceFollowRedirects(boolean z11) {
        this.httpUrlConnection.setInstanceFollowRedirects(z11);
    }

    public void setReadTimeout(int i11) {
        this.httpUrlConnection.setReadTimeout(i11);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.httpUrlConnection.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        if ("User-Agent".equalsIgnoreCase(str)) {
            this.networkMetricBuilder.setUserAgent(str2);
        }
        this.httpUrlConnection.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z11) {
        this.httpUrlConnection.setUseCaches(z11);
    }

    public String toString() {
        return this.httpUrlConnection.toString();
    }

    public boolean usingProxy() {
        return this.httpUrlConnection.usingProxy();
    }

    public void setFixedLengthStreamingMode(long j11) {
        this.httpUrlConnection.setFixedLengthStreamingMode(j11);
    }

    public String getHeaderField(String str) {
        updateRequestInfo();
        return this.httpUrlConnection.getHeaderField(str);
    }

    public Object getContent(Class[] clsArr) throws IOException {
        updateRequestInfo();
        this.networkMetricBuilder.setHttpResponseCode(this.httpUrlConnection.getResponseCode());
        try {
            Object content = this.httpUrlConnection.getContent(clsArr);
            if (content instanceof InputStream) {
                this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.networkMetricBuilder, this.timer);
            }
            this.networkMetricBuilder.setResponseContentType(this.httpUrlConnection.getContentType());
            this.networkMetricBuilder.setResponsePayloadBytes((long) this.httpUrlConnection.getContentLength());
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            this.networkMetricBuilder.build();
            return content;
        } catch (IOException e11) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e11;
        }
    }
}
