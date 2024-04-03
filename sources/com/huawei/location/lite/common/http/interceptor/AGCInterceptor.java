package com.huawei.location.lite.common.http.interceptor;

import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.agc.yn;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;

public class AGCInterceptor implements InterceptorAdapter {
    private static final String EXPIRE_TIME = "expireTime";
    private static final String TOKEN = "token";

    private BaseRequest addHeader(BaseRequest baseRequest) {
        yn agcInfo = AGCManager.getInstance().getAgcInfo();
        return agcInfo == null ? baseRequest : baseRequest.newBuilder().addHeader("expireTime", String.valueOf(agcInfo.yn())).addHeader("token", agcInfo.Vw()).build();
    }

    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws IOException, OnFailureException, OnErrorException {
        return chain.proceed(addHeader(chain.request()));
    }
}
