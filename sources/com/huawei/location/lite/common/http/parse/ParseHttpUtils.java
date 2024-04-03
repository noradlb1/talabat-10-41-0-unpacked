package com.huawei.location.lite.common.http.parse;

import android.text.TextUtils;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseBodyAdapter;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.HttpUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

@Instrumented
public class ParseHttpUtils {
    private static final String TAG = "ParseHttpUtils";

    private static HashMap<String, String> getHeaders(Headers headers) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String next : headers.names()) {
            List<String> values = headers.values(next);
            if (!values.isEmpty()) {
                for (String put : values) {
                    hashMap.put(next, put);
                }
            }
        }
        return hashMap;
    }

    public static Request parseRequest(BaseRequest baseRequest, Request.Builder builder) throws OnErrorException {
        RequestBody requestBody = null;
        if (baseRequest == null) {
            return null;
        }
        LogConsole.d(TAG, "baseRequest:" + baseRequest);
        String method = baseRequest.getMethod();
        if (TextUtils.equals("POST", method)) {
            requestBody = RequestBody.create(MediaType.parse(!TextUtils.isEmpty(baseRequest.getContentType()) ? baseRequest.getContentType() : RequestJsonBody.APPLICATION_JSON_UTF_8), ByteString.of(baseRequest.getBody()));
        }
        try {
            builder.url(baseRequest.getFullUrl()).method(method, requestBody);
            HashMap<String, String> headers = baseRequest.getHeads().getHeaders();
            if (headers == null) {
                return OkHttp3Instrumentation.build(builder);
            }
            for (Map.Entry next : headers.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getValue())) {
                    builder.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
            return OkHttp3Instrumentation.build(builder);
        } catch (IllegalArgumentException unused) {
            throw new OnErrorException(ErrorCode.valueOf(ErrorCode.PARAM_ERROR_EMPTY));
        }
    }

    public static ResponseAdapter parseResponseAdapter(Response response) throws OnFailureException {
        ResponseBody body = response.body();
        if (body != null) {
            HashMap<String, String> headers = getHeaders(response.headers());
            MediaType contentType = body.contentType();
            return new ResponseAdapter.Builder().body(new ResponseBodyAdapter.Builder().bytes(HttpUtils.toByteArray(body.byteStream())).contentType(contentType != null ? contentType.toString() : "").contentLength(body.contentLength()).build()).headers(new HeadBuilder().addAll(headers)).message(response.message()).code(response.code()).url(response.request().url().toString()).build();
        }
        throw new OnFailureException(ErrorCode.valueOf(10300));
    }
}
