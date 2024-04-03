package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;
import java.util.List;

public class RealInterceptorChain implements InterceptorAdapter.Chain {
    private IHttpClient httpClient;
    private int index;
    private List<InterceptorAdapter> interceptors;
    private BaseRequest request;
    private IHttpSDKRequestTask requestTask;

    public RealInterceptorChain(IHttpClient iHttpClient, BaseRequest baseRequest, List<InterceptorAdapter> list, int i11, IHttpSDKRequestTask iHttpSDKRequestTask) {
        this.httpClient = iHttpClient;
        this.request = baseRequest;
        this.interceptors = list;
        this.index = i11;
        this.requestTask = iHttpSDKRequestTask;
    }

    public IHttpSDKRequestTask getRequestTask() {
        return this.requestTask;
    }

    public ResponseAdapter proceed(BaseRequest baseRequest) throws IOException, OnFailureException, OnErrorException {
        if (this.index < this.interceptors.size()) {
            ResponseAdapter intercept = this.interceptors.get(this.index).intercept(new RealInterceptorChain(this.httpClient, baseRequest, this.interceptors, this.index + 1, this.requestTask));
            if (intercept != null) {
                return intercept;
            }
            throw new OnFailureException(ErrorCode.valueOf(ErrorCode.RESPONSE_IS_NULL));
        }
        throw new AssertionError();
    }

    public BaseRequest request() {
        return this.request;
    }
}
