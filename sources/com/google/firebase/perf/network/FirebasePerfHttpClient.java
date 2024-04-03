package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.newrelic.agent.android.instrumentation.ApacheInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

@Instrumented
public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return execute(httpClient, httpUriRequest, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return execute(httpClient, httpUriRequest, httpContext, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return execute(httpClient, httpUriRequest, responseHandler, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return execute(httpClient, httpUriRequest, responseHandler, httpContext, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpClient, httpHost, httpRequest, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return execute(httpClient, httpHost, httpRequest, httpContext, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpClient, httpHost, httpRequest, responseHandler, new Timer(), TransportManager.getInstance());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return execute(httpClient, httpHost, httpRequest, responseHandler, httpContext, new Timer(), TransportManager.getInstance());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse execute = !(httpClient instanceof HttpClient) ? httpClient.execute(httpUriRequest) : ApacheInstrumentation.execute(httpClient, httpUriRequest);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                builder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                builder.setResponseContentType(apacheHttpResponseContentType);
            }
            builder.build();
            return execute;
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse execute = !(httpClient instanceof HttpClient) ? httpClient.execute(httpUriRequest, httpContext) : ApacheInstrumentation.execute(httpClient, httpUriRequest, httpContext);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                builder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                builder.setResponseContentType(apacheHttpResponseContentType);
            }
            builder.build();
            return execute;
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler, timer, builder);
            return !(httpClient instanceof HttpClient) ? httpClient.execute(httpUriRequest, instrumentApacheHttpResponseHandler) : ApacheInstrumentation.execute(httpClient, httpUriRequest, instrumentApacheHttpResponseHandler);
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler, timer, builder);
            return !(httpClient instanceof HttpClient) ? httpClient.execute(httpUriRequest, instrumentApacheHttpResponseHandler, httpContext) : ApacheInstrumentation.execute(httpClient, httpUriRequest, instrumentApacheHttpResponseHandler, httpContext);
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse execute = !(httpClient instanceof HttpClient) ? httpClient.execute(httpHost, httpRequest) : ApacheInstrumentation.execute(httpClient, httpHost, httpRequest);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                builder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                builder.setResponseContentType(apacheHttpResponseContentType);
            }
            builder.build();
            return execute;
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse execute = !(httpClient instanceof HttpClient) ? httpClient.execute(httpHost, httpRequest, httpContext) : ApacheInstrumentation.execute(httpClient, httpHost, httpRequest, httpContext);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                builder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                builder.setResponseContentType(apacheHttpResponseContentType);
            }
            builder.build();
            return execute;
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler, timer, builder);
            return !(httpClient instanceof HttpClient) ? httpClient.execute(httpHost, httpRequest, instrumentApacheHttpResponseHandler) : ApacheInstrumentation.execute(httpClient, httpHost, httpRequest, instrumentApacheHttpResponseHandler);
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            builder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                builder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            builder.setRequestStartTimeMicros(timer.getMicros());
            InstrumentApacheHttpResponseHandler instrumentApacheHttpResponseHandler = new InstrumentApacheHttpResponseHandler(responseHandler, timer, builder);
            return !(httpClient instanceof HttpClient) ? httpClient.execute(httpHost, httpRequest, instrumentApacheHttpResponseHandler, httpContext) : ApacheInstrumentation.execute(httpClient, httpHost, httpRequest, instrumentApacheHttpResponseHandler, httpContext);
        } catch (IOException e11) {
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e11;
        }
    }
}
