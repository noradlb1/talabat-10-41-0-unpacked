package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.callback.IHttpCallback;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.response.BaseResponse;

public interface ISubmitAdapter {
    <T extends BaseResponse> void enqueue(IHttpCallback<T> iHttpCallback);

    <T extends BaseResponse> T execute(Class<T> cls) throws OnErrorException, OnFailureException;

    String execute() throws OnErrorException, OnFailureException;

    byte[] executeOriginal() throws OnErrorException, OnFailureException;
}
