package com.huawei.location.router.dispatch;

import com.huawei.location.router.entity.RouterRequest;

public class DispatchRunnable extends DispatchBaseRunnable implements Runnable {
    public DispatchRunnable(RouterRequest routerRequest) {
        super(routerRequest);
    }

    private boolean isOffLineLocation(RouterRequest routerRequest) {
        return "location.requestLocationUpdates".equals(routerRequest.getApiName()) || "location.requestLocationUpdatesEx".equals(routerRequest.getApiName()) || "location.removeLocationUpdates".equals(routerRequest.getApiName()) || "location.getLastLocation".equals(routerRequest.getApiName());
    }

    public void run() {
        this.apiRequest.setRouterRequest(this.routerRequest);
        if (!agcAuth()) {
            if (isOffLineLocation(this.routerRequest)) {
                this.routerRequest.setAgcFail(true);
            } else {
                handlerErrorResult(10808);
                return;
            }
        }
        this.apiRequest.onRequest(this.routerRequest.getRequestJson());
    }
}
