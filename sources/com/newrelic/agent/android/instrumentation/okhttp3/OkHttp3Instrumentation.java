package com.newrelic.agent.android.instrumentation.okhttp3;

import androidx.webkit.ProxyConfig;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.HttpHeaders;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkUrlFactory;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.StreamAllocation;

public class OkHttp3Instrumentation {
    /* access modifiers changed from: private */
    public static final AgentLog log = AgentLogManager.getAgentLog();

    public static class OkHttp35 {
        @ReplaceCallSite
        public static StreamAllocation callEngineGetStreamAllocation(Internal internal, Call call) {
            try {
                if (call instanceof CallExtension) {
                    call = ((CallExtension) call).getImpl();
                }
                Method method = Internal.class.getMethod("callEngineGetStreamAllocation", new Class[]{Call.class});
                if (method != null) {
                    return (StreamAllocation) method.invoke(internal, new Object[]{call});
                }
                OkHttp3Instrumentation.logReflectionError("callEngineGetStreamAllocation(Lokhttp3/Call;)Lokhttp3/internal/connection/StreamAllocation;");
                return null;
            } catch (Exception e11) {
                AgentLog a11 = OkHttp3Instrumentation.log;
                String message = e11.getMessage();
                a11.error("OkHttp3Instrumentation: " + message);
                return null;
            }
        }

        @ReplaceCallSite
        public static Call newWebSocketCall(Internal internal, OkHttpClient okHttpClient, Request request) {
            CallExtension callExtension;
            try {
                Method method = Internal.class.getMethod("newWebSocketCall", new Class[]{OkHttpClient.class, Request.class});
                if (method != null) {
                    TransactionState transactionState = new TransactionState();
                    if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
                        transactionState.setTrace(DistributedTracing.getInstance().startTrace(transactionState));
                        Request distributedTraceHeaders = OkHttp3TransactionStateUtil.setDistributedTraceHeaders(transactionState, request);
                        callExtension = new CallExtension(okHttpClient, distributedTraceHeaders, (Call) method.invoke(internal, new Object[]{okHttpClient, distributedTraceHeaders}), transactionState);
                    } else {
                        callExtension = new CallExtension(okHttpClient, request, (Call) method.invoke(internal, new Object[]{okHttpClient, request}), transactionState);
                    }
                    return callExtension;
                }
                OkHttp3Instrumentation.logReflectionError("newWebSocketCall(Lokhttp3/OkHttpClient;Lokhttp3/Request;)Lokhttp3/Call;");
                return null;
            } catch (Exception e11) {
                AgentLog a11 = OkHttp3Instrumentation.log;
                String message = e11.getMessage();
                a11.error("OkHttp3Instrumentation: " + message);
                return null;
            }
        }

        @ReplaceCallSite
        public static void setCallWebSocket(Internal internal, Call call) {
            try {
                if (call instanceof CallExtension) {
                    call = ((CallExtension) call).getImpl();
                }
                Method method = Internal.class.getMethod("setCallWebSocket", new Class[]{Call.class});
                if (method != null) {
                    method.invoke(internal, new Object[]{call});
                    return;
                }
                OkHttp3Instrumentation.logReflectionError("setCallWebSocket(Lokhttp3/Call;)V");
            } catch (Exception e11) {
                AgentLog a11 = OkHttp3Instrumentation.log;
                String message = e11.getMessage();
                a11.error("OkHttp3Instrumentation: " + message);
            }
        }
    }

    private OkHttp3Instrumentation() {
    }

    private static void addHeadersAsCustomAttribute(TransactionState transactionState, Request request) {
        HashMap hashMap = new HashMap();
        for (String next : HttpHeaders.getInstance().getHttpHeaders()) {
            if (request.headers().get(next) != null) {
                hashMap.put(HttpHeaders.translateApolloHeader(next), request.headers().get(next));
            }
        }
        transactionState.setParams(hashMap);
    }

    @ReplaceCallSite
    public static Response.Builder body(Response.Builder builder, ResponseBody responseBody) {
        return new ResponseBuilderExtension(builder).body(responseBody);
    }

    @ReplaceCallSite
    public static Request build(Request.Builder builder) {
        return new RequestBuilderExtension(builder).build();
    }

    /* access modifiers changed from: private */
    public static void logReflectionError(String str) {
        String property = System.getProperty("line.separator");
        AgentLog agentLog = log;
        agentLog.error("Unable to resolve method \"" + str + "\"." + property + "This is usually due to building the app with unsupported OkHttp versions." + property + "Check your build configuration for compatibility.");
    }

    @ReplaceCallSite
    public static Response.Builder newBuilder(Response.Builder builder) {
        return new ResponseBuilderExtension(builder);
    }

    @ReplaceCallSite
    public static Call newCall(OkHttpClient okHttpClient, Request request) {
        TransactionState transactionState = new TransactionState();
        addHeadersAsCustomAttribute(transactionState, request);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            try {
                transactionState.setTrace(DistributedTracing.getInstance().startTrace(transactionState));
                Request distributedTraceHeaders = OkHttp3TransactionStateUtil.setDistributedTraceHeaders(transactionState, request);
                return new CallExtension(okHttpClient, distributedTraceHeaders, okHttpClient.newCall(distributedTraceHeaders), transactionState);
            } catch (Exception e11) {
                log.error(e11.getMessage());
            }
        }
        return new CallExtension(okHttpClient, request, okHttpClient.newCall(request), transactionState);
    }

    @ReplaceCallSite(isStatic = false, scope = "okhttp3.OkUrlFactory")
    public static HttpURLConnection open(OkUrlFactory okUrlFactory, URL url) {
        HttpURLConnection open = okUrlFactory.open(url);
        String protocol = url.getProtocol();
        if (protocol.equals(ProxyConfig.MATCH_HTTP)) {
            return new HttpURLConnectionExtension(open);
        }
        if (!protocol.equals("https") || !(open instanceof HttpsURLConnection)) {
            return new HttpURLConnectionExtension(open);
        }
        return new HttpsURLConnectionExtension((HttpsURLConnection) open);
    }
}
