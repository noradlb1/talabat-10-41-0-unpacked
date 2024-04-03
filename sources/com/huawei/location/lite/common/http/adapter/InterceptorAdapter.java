package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;

public interface InterceptorAdapter {

    public interface Chain {
        ResponseAdapter proceed(BaseRequest baseRequest) throws IOException, OnFailureException, OnErrorException;

        BaseRequest request();
    }

    ResponseAdapter intercept(Chain chain) throws IOException, OnFailureException, OnErrorException;
}
