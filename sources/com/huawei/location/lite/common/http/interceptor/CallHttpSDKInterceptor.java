package com.huawei.location.lite.common.http.interceptor;

import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.RealInterceptorChain;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.IOException;

public class CallHttpSDKInterceptor implements InterceptorAdapter {
    private static final String TAG = "CallHttpSDKInterceptor";

    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws IOException, OnFailureException, OnErrorException {
        long currentTimeMillis = System.currentTimeMillis();
        LogConsole.d(TAG, "RequestTask execute start");
        ResponseAdapter execute = ((RealInterceptorChain) chain).getRequestTask().execute(chain.request());
        if (execute == null) {
            return null;
        }
        return execute.newBuilder().sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
    }
}
