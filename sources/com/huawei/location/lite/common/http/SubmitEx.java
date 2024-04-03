package com.huawei.location.lite.common.http;

import android.text.TextUtils;
import cb.a;
import com.google.gson.Gson;
import com.huawei.location.lite.common.http.adapter.HttpClientAdapter;
import com.huawei.location.lite.common.http.adapter.IHttpClient;
import com.huawei.location.lite.common.http.adapter.ISubmitAdapter;
import com.huawei.location.lite.common.http.adapter.RealInterceptorChain;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.callback.IHttpCallback;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.interceptor.CallHttpSDKInterceptor;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.response.BaseResponse;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.StandardCharsets;

@Instrumented
public class SubmitEx implements ISubmitAdapter {
    private static final String TAG = "SubmitEx";
    private final IHttpClient httpClient;
    private HttpReportHelper httpReportHelper;
    private final BaseRequest request;

    public class TempResponse extends BaseResponse {
        private TempResponse() {
        }

        public String getApiCode() {
            return this.code;
        }

        public boolean isSuccess() {
            return TextUtils.isEmpty(this.code) || "0".equals(this.code);
        }
    }

    public SubmitEx(BaseRequest baseRequest, IHttpClient iHttpClient) {
        this.httpClient = iHttpClient;
        this.request = baseRequest;
        this.httpReportHelper = new HttpReportHelper(iHttpClient instanceof HttpClientAdapter ? ((HttpClientAdapter) iHttpClient).getReportBuilder() : null);
    }

    private String innerExecute() throws OnFailureException, OnErrorException {
        return new String(getResponseWithInterceptorChain().getBody().bytes(), StandardCharsets.UTF_8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$enqueue$0(IHttpCallback iHttpCallback) {
        try {
            iHttpCallback.onSuccess(execute(getClassFromInterObj(iHttpCallback)));
        } catch (OnFailureException e11) {
            iHttpCallback.onFailure(e11);
        } catch (OnErrorException e12) {
            iHttpCallback.onError(e12);
        }
    }

    public <T extends BaseResponse> void enqueue(IHttpCallback<T> iHttpCallback) {
        ExecutorUtil.getInstance().execute(new a(this, iHttpCallback));
    }

    public <T extends BaseResponse> T execute(Class<T> cls) throws OnFailureException, OnErrorException {
        return getEntity(innerExecute(), cls);
    }

    public String execute() throws OnErrorException, OnFailureException {
        String innerExecute = innerExecute();
        getEntity(innerExecute, TempResponse.class);
        return innerExecute;
    }

    public byte[] executeOriginal() throws OnErrorException, OnFailureException {
        byte[] bytes = getResponseWithInterceptorChain().getBody().bytes();
        if (bytes != null && bytes.length > 0) {
            this.httpReportHelper.reportHttpResult(this.request, String.valueOf(200), ErrorCode.valueOfKey(200));
        }
        return bytes;
    }

    public <T extends BaseResponse> Class<T> getClassFromInterObj(Object obj) {
        return (Class) ((ParameterizedType) obj.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }

    public <T extends BaseResponse> T getEntity(String str, Class<T> cls) throws OnFailureException, OnErrorException {
        try {
            Gson instance = GsonUtil.getInstance();
            T t11 = (BaseResponse) (!(instance instanceof Gson) ? instance.fromJson(str, cls) : GsonInstrumentation.fromJson(instance, str, cls));
            if (t11 == null) {
                LogConsole.e(TAG, "param exception");
                this.httpReportHelper.reportHttpResult(this.request, String.valueOf(ErrorCode.JSON_PARSE_FAILED), ErrorCode.valueOfKey(ErrorCode.JSON_PARSE_FAILED));
                throw new OnFailureException(ErrorCode.valueOf(ErrorCode.JSON_PARSE_FAILED));
            } else if (t11.isSuccess()) {
                this.httpReportHelper.reportHttpResult(this.request, String.valueOf(200), ErrorCode.valueOfKey(200));
                return t11;
            } else {
                this.httpReportHelper.reportHttpResult(this.request, t11.getApiCode(), t11.getMsg());
                throw new OnErrorException(t11.getApiCode(), t11.getMsg());
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "getEntity exception body is :" + str);
            this.httpReportHelper.reportHttpResult(this.request, String.valueOf(ErrorCode.JSON_PARSE_FAILED), ErrorCode.valueOfKey(ErrorCode.JSON_PARSE_FAILED));
            throw new OnFailureException(ErrorCode.valueOf(ErrorCode.JSON_PARSE_FAILED));
        }
    }

    public ResponseAdapter getResponseWithInterceptorChain() throws OnFailureException, OnErrorException {
        LogConsole.d(TAG, "fetch info from server by network start...");
        this.httpClient.getInterceptors().add(new CallHttpSDKInterceptor());
        IHttpClient iHttpClient = this.httpClient;
        try {
            ResponseAdapter proceed = new RealInterceptorChain(iHttpClient, this.request, iHttpClient.getInterceptors(), 0, this.httpClient.newRequestTask()).proceed(this.request);
            if (proceed == null || proceed.getBody() == null) {
                throw new OnFailureException(ErrorCode.valueOf(ErrorCode.RESPONSE_IS_NULL));
            } else if (proceed.isSuccessful()) {
                LogConsole.d(TAG, "fetch info from server by network end...");
                return proceed;
            } else {
                throw new OnFailureException(ErrorCode.valueOf(proceed.getCode()));
            }
        } catch (IOException e11) {
            LogConsole.d(TAG, e11.getMessage() + "");
            throw new OnFailureException(e11 instanceof AuthException ? ((AuthException) e11).getErrorCode() : ErrorCode.valueOf(10300));
        } catch (Throwable th2) {
            LogConsole.d(TAG, "fetch info from server by network end...");
            if (0 != 0) {
                this.httpReportHelper.reportHttpResult(this.request, String.valueOf(null.code), String.valueOf(null.msg));
            }
            throw th2;
        }
    }
}
