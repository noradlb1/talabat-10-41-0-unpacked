package com.huawei.location.router.interfaces;

import com.huawei.location.router.RouterResponse;

public interface IRouterCallback {
    void doExecute(RouterResponse routerResponse);

    void onComplete(RouterResponse routerResponse);
}
