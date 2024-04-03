package com.huawei.location.router.interfaces;

import com.huawei.location.router.entity.IRouterResponse;

public interface IRouterRequest {
    IRouterResponse onExecute(String str);

    void onRequest(String str);
}
