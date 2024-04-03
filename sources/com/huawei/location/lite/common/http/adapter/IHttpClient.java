package com.huawei.location.lite.common.http.adapter;

import java.util.List;

public interface IHttpClient {
    void evictAllConnections();

    List<InterceptorAdapter> getInterceptors();

    void init();

    IHttpSDKRequestTask newRequestTask();
}
