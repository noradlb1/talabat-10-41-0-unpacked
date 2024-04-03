package com.instabug.library.okhttplogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.logging.listeners.networklogs.NetworkLogListener;
import com.instabug.library.logging.listeners.networklogs.NetworkLogSnapshotHelper;
import com.instabug.library.model.NetworkLog;
import com.instabug.library.networkv2.BodyBufferHelper;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class InstabugOkhttpInterceptor implements Interceptor {
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String FILE_DOWNLOAD_CONTENT_TYPE = "application/octet-stream";
    private static final String PROTOBUF_ERR_REQUEST_LOG = "protobuf request not supported by instabug";
    private static final String PROTOBUF_ERR_RESPONSE_LOG = "protobuf response not supported by instabug";
    private static final String PROTOBUF_REQUEST_MSG = "Request body of type protobuf";
    private static final String PROTOBUF_RESPONSE_MSG = "Response body of type protobuf";
    private static final String TAG = "InstabugOkhttpInterceptor";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static NetworkLogListener networkLogListener = null;
    private static NetworkLogSnapshotHelper networkLogSnapshotHelper = null;
    @NonNull
    private static final List<String> notAllowedRequestHeaders = new CopyOnWriteArrayList();
    @NonNull
    private static final List<String> notAllowedResponseHeaders = new CopyOnWriteArrayList();
    private boolean isFileDownload = false;
    private boolean isNotAllowedToBeLogged = true;

    public InstabugOkhttpInterceptor() {
    }

    private void addRequestHeaders(@NonNull JSONObject jSONObject, @NonNull Request request, @Nullable RequestBody requestBody) throws IOException {
        String str;
        String str2;
        String str3;
        if (requestBody != null) {
            if (requestBody.contentType() != null) {
                this.isNotAllowedToBeLogged = isContentTypeNotAllowed(requestBody.contentType().toString());
                try {
                    jSONObject.put("Content-Type", (Object) requestBody.contentType());
                } catch (JSONException e11) {
                    if (e11.getMessage() != null) {
                        str3 = e11.getMessage();
                    } else {
                        str3 = "";
                    }
                    InstabugSDKLogger.e(TAG, str3, e11);
                    e11.printStackTrace();
                }
            }
            if (requestBody.contentLength() != -1) {
                try {
                    jSONObject.put("Content-Length", requestBody.contentLength());
                } catch (JSONException e12) {
                    if (e12.getMessage() != null) {
                        str2 = e12.getMessage();
                    } else {
                        str2 = "";
                    }
                    InstabugSDKLogger.e(TAG, str2, e12);
                    e12.printStackTrace();
                }
            }
        }
        Headers headers = request.headers();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String name2 = headers.name(i11);
            if (isAllowedRequestHeaderType(name2)) {
                try {
                    jSONObject.put(name2, (Object) headers.value(i11));
                } catch (JSONException e13) {
                    if (e13.getMessage() != null) {
                        str = e13.getMessage();
                    } else {
                        str = "";
                    }
                    InstabugSDKLogger.e(TAG, str, e13);
                    e13.printStackTrace();
                }
            }
        }
    }

    private void addResponseHeaders(@NonNull JSONObject jSONObject, @NonNull Response response) {
        String str;
        Headers headers = response.headers();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (headers.name(i11).equalsIgnoreCase("Content-Type") && "application/octet-stream".equalsIgnoreCase(headers.value(i11))) {
                this.isFileDownload = true;
            }
            if (isAllowedResponseHeaderType(headers.name(i11))) {
                if (headers.name(i11).equalsIgnoreCase("Content-Type")) {
                    this.isNotAllowedToBeLogged = isContentTypeNotAllowed(headers.value(i11));
                }
                try {
                    jSONObject.put(headers.name(i11), (Object) headers.value(i11));
                } catch (JSONException e11) {
                    if (e11.getMessage() != null) {
                        str = e11.getMessage();
                    } else {
                        str = "";
                    }
                    InstabugSDKLogger.e(TAG, str, e11);
                    e11.printStackTrace();
                }
            }
        }
    }

    private boolean bodyEncoded(@NonNull Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str == null || str.equalsIgnoreCase(Constants.Network.ContentType.IDENTITY)) {
            return false;
        }
        return true;
    }

    private boolean isAllowedRequestHeaderType(String str) {
        return !notAllowedRequestHeaders.contains(str);
    }

    private boolean isAllowedResponseHeaderType(String str) {
        return !notAllowedResponseHeaders.contains(str);
    }

    private boolean isContentTypeNotAllowed(@NonNull String str) {
        if (str.contains("application/json") || str.contains(NetworkLog.XML_1) || str.contains(NetworkLog.XML_2) || str.contains(NetworkLog.PROTOBUF) || str.contains(NetworkLog.HTML) || str.contains("text/plain")) {
            return false;
        }
        return true;
    }

    private boolean isMultipart(@Nullable MediaType mediaType) {
        return mediaType != null && BodyBufferHelper.isMultipartType(mediaType.toString());
    }

    private boolean isPlaintext(@NonNull Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min(buffer.size(), 64));
            for (int i11 = 0; i11 < 16 && !buffer2.exhausted(); i11++) {
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            InstabugSDKLogger.v(TAG, "plain text buffer");
            return true;
        } catch (Exception e11) {
            InstabugSDKLogger.e(TAG, e11.getMessage(), e11);
            return false;
        }
    }

    private void notifyAndInsert(NetworkLog networkLog) {
        NetworkLogSnapshotHelper networkLogSnapshotHelper2;
        NetworkLogListener networkLogListener2 = networkLogListener;
        if (networkLogListener2 == null || (networkLogSnapshotHelper2 = networkLogSnapshotHelper) == null) {
            networkLog.insert();
            return;
        }
        networkLogSnapshotHelper.applyNetworkLogChanges(networkLog, networkLogListener2.onNetworkLogCaptured(networkLogSnapshotHelper2.getNetworkLogSnapshot(networkLog)));
    }

    private Response populateNetworkResponse(@NonNull Interceptor.Chain chain, @NonNull NetworkLog networkLog) throws IOException {
        ResponseBody body;
        InstabugSDKLogger.v(TAG, "populate network request started");
        this.isNotAllowedToBeLogged = true;
        networkLog.setDate(System.currentTimeMillis() + "");
        Request request = chain.request();
        networkLog.setMethod(request.method());
        networkLog.setUrl(request.url().toString());
        RequestBody body2 = request.body();
        JSONObject jSONObject = new JSONObject();
        addRequestHeaders(jSONObject, request, body2);
        networkLog.setRequestHeaders(JSONObjectInstrumentation.toString(jSONObject));
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (isMultipart(contentType)) {
                networkLog.setRequest(BodyBufferHelper.MULTIPART_ALERT);
            } else if (!BodyBufferHelper.isBodySizeAllowed(body2.contentLength())) {
                networkLog.setRequest(BodyBufferHelper.MAX_SIZE_ALERT);
            } else if (contentType == null || !contentType.toString().equals(NetworkLog.PROTOBUF)) {
                Buffer buffer = new Buffer();
                body2.writeTo(buffer);
                if (isPlaintext(buffer)) {
                    setRequestBodyText(networkLog, buffer.readString(UTF8));
                }
            } else {
                InstabugSDKLogger.w(TAG, PROTOBUF_ERR_REQUEST_LOG);
                if (!this.isNotAllowedToBeLogged) {
                    networkLog.setRequest(PROTOBUF_REQUEST_MSG);
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            try {
                networkLog.setTotalDuration(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
                networkLog.setResponseCode(proceed.code());
                JSONObject jSONObject2 = new JSONObject();
                addResponseHeaders(jSONObject2, proceed);
                networkLog.setResponseHeaders(JSONObjectInstrumentation.toString(jSONObject2));
                if (!this.isFileDownload && (body = proceed.body()) != null) {
                    long contentLength = body.contentLength();
                    if (HttpHeaders.hasBody(proceed) && !bodyEncoded(proceed.headers())) {
                        BufferedSource source = body.source();
                        source.request(2147483647L);
                        Buffer buffer2 = source.buffer();
                        Charset charset = UTF8;
                        MediaType contentType2 = body.contentType();
                        if (isMultipart(contentType2)) {
                            networkLog.setResponse(BodyBufferHelper.MULTIPART_ALERT);
                            networkLog.insert();
                            return proceed;
                        } else if (!BodyBufferHelper.isBodySizeAllowed(body.contentLength())) {
                            networkLog.setResponse(BodyBufferHelper.MAX_SIZE_ALERT);
                            networkLog.insert();
                            return proceed;
                        } else {
                            if (contentType2 != null) {
                                if (contentType2.toString().equals(NetworkLog.PROTOBUF)) {
                                    InstabugSDKLogger.w(TAG, PROTOBUF_ERR_RESPONSE_LOG);
                                    if (!this.isNotAllowedToBeLogged) {
                                        networkLog.setResponse(PROTOBUF_RESPONSE_MSG);
                                        InstabugSDKLogger.v(TAG, "inserting network log");
                                        notifyAndInsert(networkLog);
                                    }
                                    return proceed;
                                }
                                charset = contentType2.charset(charset);
                            }
                            if (!isPlaintext(buffer2)) {
                                return proceed;
                            }
                            if (contentLength != 0) {
                                setResponseBodyText(networkLog, buffer2.clone().readString(charset));
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e(TAG, e11.toString(), e11);
                return proceed;
            } catch (Throwable th2) {
                IBGDiagnostics.reportNonFatal(th2, "couldn't store response");
            }
            if (!this.isNotAllowedToBeLogged) {
                InstabugSDKLogger.v(TAG, "inserting network log");
                notifyAndInsert(networkLog);
            }
            return proceed;
        } catch (Exception e12) {
            networkLog.setTotalDuration(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
            String message = e12.getMessage();
            if (message == null) {
                message = e12.getClass().getSimpleName();
            }
            networkLog.setResponse(message);
            networkLog.setResponseCode(0);
            notifyAndInsert(networkLog);
            InstabugSDKLogger.e(TAG, e12.getMessage(), e12);
            throw e12;
        }
    }

    private void setRequestBodyText(@NonNull NetworkLog networkLog, @NonNull String str) {
        if (shouldIncludeMessage(str)) {
            networkLog.setRequest(str);
        }
    }

    private void setResponseBodyText(@NonNull NetworkLog networkLog, @NonNull String str) {
        if (shouldIncludeMessage(str)) {
            networkLog.setResponse(str);
        }
    }

    public synchronized void excludeRequestHeaders(@Nullable String... strArr) {
        if (strArr != null) {
            try {
                notAllowedRequestHeaders.addAll(Arrays.asList(strArr));
            } catch (ArrayIndexOutOfBoundsException e11) {
                InstabugSDKLogger.e(TAG, "Unable to add headers to notAllowedRequestHeaders", e11);
            }
        }
        return;
    }

    public synchronized void excludeResponseHeaders(@Nullable String... strArr) {
        if (strArr != null) {
            try {
                notAllowedResponseHeaders.addAll(Arrays.asList(strArr));
            } catch (ArrayIndexOutOfBoundsException e11) {
                InstabugSDKLogger.e(TAG, "Unable to add headers to notAllowedResponseHeaders", e11);
            }
        }
        return;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (!Instabug.isEnabled()) {
            return chain.proceed(chain.request());
        }
        return populateNetworkResponse(chain, new NetworkLog());
    }

    public void registerNetworkLogsListener(@NonNull NetworkLogListener networkLogListener2) {
        networkLogListener = networkLogListener2;
        networkLogSnapshotHelper = NetworkLogSnapshotHelper.INSTANCE;
    }

    public void removeNetworkLogsListener() {
        networkLogListener = null;
        networkLogSnapshotHelper = null;
    }

    public boolean shouldIncludeMessage(@NonNull String str) {
        return true;
    }

    public InstabugOkhttpInterceptor(@NonNull NetworkLogListener networkLogListener2) {
        registerNetworkLogsListener(networkLogListener2);
    }
}
