package com.huawei.location.lite.common.http;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.huawei.location.lite.common.http.adapter.IHttpSDKRequestTask;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.parse.ParseHttpUtils;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Instrumented
public class OkRequestTask implements IHttpSDKRequestTask {
    private BaseRequest baseRequest;
    private final OkHttpClient httpClient;

    public OkRequestTask(OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
    }

    public ResponseAdapter execute(BaseRequest baseRequest2) throws OnErrorException, OnFailureException, IOException {
        this.baseRequest = baseRequest2;
        Request parseRequest = ParseHttpUtils.parseRequest(baseRequest2, new Request.Builder());
        OkHttpClient okHttpClient = this.httpClient;
        Response execute = FirebasePerfOkHttpClient.execute(!(okHttpClient instanceof OkHttpClient) ? okHttpClient.newCall(parseRequest) : OkHttp3Instrumentation.newCall(okHttpClient, parseRequest));
        if (execute.body() != null) {
            return ParseHttpUtils.parseResponseAdapter(execute);
        }
        throw new OnFailureException(ErrorCode.valueOf(ErrorCode.RESPONSE_IS_NULL));
    }

    public BaseRequest request() {
        return this.baseRequest;
    }
}
