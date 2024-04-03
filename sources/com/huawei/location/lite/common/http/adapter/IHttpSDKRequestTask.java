package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;

public interface IHttpSDKRequestTask {
    ResponseAdapter execute(BaseRequest baseRequest) throws OnErrorException, OnFailureException, IOException;

    BaseRequest request();
}
