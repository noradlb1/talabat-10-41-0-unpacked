package com.instabug.apm.model;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.huawei.hms.analytics.type.HAParamType;
import com.instabug.apm.APMPlugin;
import com.instabug.apm.attributes.listeners.OnNetworkTraceListener;
import com.instabug.apm.logger.APMLogger;
import com.instabug.library.networkv2.BodyBufferHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@Instrumented
public class APMNetworkLog {
    @Nullable
    private String Carrier;
    /* access modifiers changed from: private */
    public boolean addedAttributes = false;
    private final transient com.instabug.apm.logger.internal.a apmLogger = com.instabug.apm.di.a.f();
    private int clientErrorCode;
    @Nullable
    private String errorMessage;
    private boolean executedInBackground;
    private Executor executor = com.instabug.apm.di.a.b("network_log_thread_executor");
    @Nullable
    private String graphQlQueryName;
    @Nullable
    private String grpcMethodName;
    /* access modifiers changed from: private */

    /* renamed from: id  reason: collision with root package name */
    public long f45478id = -1;
    private String method = "get";
    /* access modifiers changed from: private */
    public com.instabug.apm.handler.networklog.a networkLogHandler = com.instabug.apm.di.a.P();
    @Nullable
    private String radio;
    @Nullable
    private String requestBody;
    private long requestBodySize;
    @Nullable
    private String requestContentType;
    @Nullable
    private String requestHeaders;
    @Nullable
    private String responseBody;
    private long responseBodySize;
    private int responseCode;
    @Nullable
    private String responseContentType;
    @Nullable
    private String responseHeaders;
    @Nullable
    private String serverSideErrorMessage;
    @Nullable
    private Long startTime;
    private long totalDuration;
    @Nullable
    private String url;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Exception f45479b;

        public a(Exception exc) {
            this.f45479b = exc;
        }

        public void run() {
            synchronized (APMPlugin.lock) {
                if (APMNetworkLog.this.f45478id == -1) {
                    APMNetworkLog aPMNetworkLog = APMNetworkLog.this;
                    long unused = aPMNetworkLog.f45478id = aPMNetworkLog.networkLogHandler.b(APMNetworkLog.this);
                } else {
                    APMNetworkLog.this.networkLogHandler.a(APMNetworkLog.this);
                    APMNetworkLog.this.printLog(this.f45479b);
                }
                if (!APMNetworkLog.this.addedAttributes) {
                    APMNetworkLog.this.addAttributes(com.instabug.apm.di.a.T());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"DB_DUPLICATE_BRANCHES "})
    public void printLog(@Nullable Exception exc) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "";
        if (exc != null) {
            String replace = "Request [$method] $url has failed after $duration ms due to $error..\nAttributes: $attr".replace("$method", this.method);
            String str4 = this.url;
            if (str4 != null) {
                str3 = str4;
            }
            str = replace.replace("$url", str3).replace("$duration", String.valueOf(this.totalDuration)).replace("$error", exc.toString()).replace("$attr", JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) this.networkLogHandler.a(this.f45478id))));
            String str5 = this.url;
            if (str5 != null) {
                str = str.replace("$url", str5);
            }
        } else {
            if (this.responseCode >= 400) {
                String replace2 = "Request [$method] $url has failed after $duration ms status code $code.\nAttributes: $attr".replace("$method", this.method);
                String str6 = this.url;
                if (str6 != null) {
                    str3 = str6;
                }
                str2 = replace2.replace("$url", str3).replace("$duration", String.valueOf(this.totalDuration)).replace(HAParamType.CODE, String.valueOf(this.responseCode));
                jSONObject = new JSONObject((Map<?, ?>) this.networkLogHandler.a(this.f45478id));
            } else {
                String replace3 = "Request [$method] $url has succeeded.\nTotal duration: $duration ms\nStatus code: $code.\nAttributes: $attr".replace("$method", this.method);
                String str7 = this.url;
                if (str7 != null) {
                    str3 = str7;
                }
                str2 = replace3.replace("$url", str3).replace("$duration", String.valueOf(this.totalDuration)).replace(HAParamType.CODE, String.valueOf(this.responseCode));
                jSONObject = new JSONObject((Map<?, ?>) this.networkLogHandler.a(this.f45478id));
            }
            str = str2.replace("$attr", JSONObjectInstrumentation.toString(jSONObject));
        }
        APMLogger.d(str);
    }

    private NetworkTrace toTrace() {
        return new f().a(this.Carrier).b(this.errorMessage).c(this.method).d(this.radio).e(this.requestBody).a(this.requestBodySize).f(this.requestContentType).g(this.requestHeaders).h(this.responseBody).b(this.responseBodySize).i(this.responseContentType).j(this.responseHeaders).a(this.responseCode).a(this.startTime).k(this.url).c(this.totalDuration).a();
    }

    public void addAttributes(com.instabug.apm.handler.attributes.a aVar) {
        if (aVar != null) {
            String str = "[" + this.method + "] " + this.url;
            NetworkTrace trace = toTrace();
            List<OnNetworkTraceListener> a11 = aVar.a();
            if (a11 != null) {
                for (OnNetworkTraceListener onNetworkTraceListener : a11) {
                    Map<String, String> addAttributesOnFinish = onNetworkTraceListener.addAttributesOnFinish(trace);
                    if (this.url != null && ((onNetworkTraceListener.getPredicate() == null || onNetworkTraceListener.getPredicate().check(this.url)) && addAttributesOnFinish != null)) {
                        for (Map.Entry next : addAttributesOnFinish.entrySet()) {
                            if (this.networkLogHandler.a(str, (String) next.getKey(), (String) next.getValue())) {
                                String trim = ((String) next.getKey()).trim();
                                Object value = next.getValue();
                                String str2 = (String) next.getValue();
                                if (value != null) {
                                    str2 = str2.trim();
                                }
                                this.networkLogHandler.a(this.f45478id, str, this.executedInBackground, trim, str2);
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
        this.addedAttributes = true;
    }

    public boolean executedInBackground() {
        return this.executedInBackground;
    }

    @Nullable
    public String getCarrier() {
        return this.Carrier;
    }

    public int getClientErrorCode() {
        return this.clientErrorCode;
    }

    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public String getGraphQlQueryName() {
        return this.graphQlQueryName;
    }

    @Nullable
    public String getGrpcMethodName() {
        return this.grpcMethodName;
    }

    public long getId() {
        return this.f45478id;
    }

    @Nullable
    public String getMethod() {
        return this.method;
    }

    @Nullable
    public String getRadio() {
        return this.radio;
    }

    @Nullable
    public String getRequestBody() {
        return this.requestBody;
    }

    public long getRequestBodySize() {
        return this.requestBodySize;
    }

    @Nullable
    public String getRequestContentType() {
        return this.requestContentType;
    }

    @Nullable
    public String getRequestHeaders() {
        return this.requestHeaders;
    }

    @Nullable
    public String getResponseBody() {
        return this.responseBody;
    }

    public long getResponseBodySize() {
        return this.responseBodySize;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public String getResponseContentType() {
        return this.responseContentType;
    }

    @Nullable
    public String getResponseHeaders() {
        return this.responseHeaders;
    }

    @Nullable
    public String getServerSideErrorMessage() {
        return this.serverSideErrorMessage;
    }

    @Nullable
    public Long getStartTime() {
        return this.startTime;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public void insert(@Nullable Exception exc) {
        this.executor.execute(new a(exc));
    }

    public void setCarrier(@Nullable String str) {
        this.Carrier = str;
    }

    public void setClientErrorCode(int i11) {
        this.clientErrorCode = i11;
    }

    public void setErrorMessage(@Nullable String str) {
        this.errorMessage = str;
    }

    public void setExecutedInBackground(boolean z11) {
        this.executedInBackground = z11;
    }

    public void setGraphQlQueryName(@Nullable String str) {
        this.graphQlQueryName = str;
    }

    public void setGrpcMethodName(@Nullable String str) {
        this.grpcMethodName = str;
    }

    public void setId(long j11) {
        this.f45478id = j11;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRadio(@Nullable String str) {
        this.radio = str;
    }

    public void setRequestBody(@Nullable String str) {
        if (str != null) {
            if (!BodyBufferHelper.isBodySizeAllowed(str)) {
                str = BodyBufferHelper.MAX_SIZE_ALERT;
            }
            this.requestBody = str;
        }
    }

    public void setRequestBodySize(long j11) {
        this.requestBodySize = j11;
    }

    public void setRequestContentType(@Nullable String str) {
        this.requestContentType = str;
    }

    public void setRequestHeaders(@Nullable String str) {
        this.requestHeaders = str;
    }

    public void setResponseBody(@Nullable String str) {
        if (str != null) {
            if (!BodyBufferHelper.isBodySizeAllowed(str)) {
                str = BodyBufferHelper.MAX_SIZE_ALERT;
            }
            this.responseBody = str;
        }
    }

    public void setResponseBodySize(long j11) {
        this.responseBodySize = j11;
    }

    public void setResponseCode(int i11) {
        this.responseCode = i11;
    }

    public void setResponseContentType(@Nullable String str) {
        this.responseContentType = str;
    }

    public void setResponseHeaders(@Nullable String str) {
        this.responseHeaders = str;
    }

    public void setServerSideErrorMessage(@Nullable String str) {
        this.serverSideErrorMessage = str;
    }

    public void setStartTime(@Nullable Long l11) {
        this.startTime = l11;
    }

    public void setTotalDuration(long j11) {
        this.totalDuration = j11;
    }

    public void setUrl(@Nullable String str) {
        this.url = str;
    }

    public String toString() {
        return "APMNetworkLog{startTime=" + this.startTime + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", requestHeaders='" + this.requestHeaders + '\'' + ", responseHeaders='" + this.responseHeaders + '\'' + ", requestContentType='" + this.requestContentType + '\'' + ", responseContentType='" + this.responseContentType + '\'' + ", errorMessage='" + this.errorMessage + '\'' + ", totalDuration=" + this.totalDuration + ", responseCode=" + this.responseCode + ", requestBodySize=" + this.requestBodySize + ", responseBodySize=" + this.responseBodySize + ", requestBody='" + this.requestBody + '\'' + ", responseBody='" + this.responseBody + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
