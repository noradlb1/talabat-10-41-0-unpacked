package com.huawei.location.router.dispatch;

import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.entity.RouterRequest;

public abstract class DispatchBaseRunnable implements IDispatchExceptionListener {
    private static final String TAG = "DispatchBaseRunnable";
    protected BaseRouterTaskCallImpl apiRequest;
    protected RouterRequest routerRequest;

    public DispatchBaseRunnable(RouterRequest routerRequest2) {
        this.routerRequest = routerRequest2;
    }

    public boolean agcAuth() {
        if (SDKComponentType.getComponentType() == 100) {
            return AGCManager.getInstance().checkAgc();
        }
        return true;
    }

    public BaseRouterTaskCallImpl getApiRequest() {
        return this.apiRequest;
    }

    public RouterRequest getRouterRequest() {
        return this.routerRequest;
    }

    public void handlerErrorResult(int i11) {
        ErrorTaskCall errorTaskCall = new ErrorTaskCall();
        errorTaskCall.setRouterRequest(this.routerRequest);
        errorTaskCall.onComplete(i11);
    }

    public void onDispatchError(int i11, String str) {
        if (i11 == 10001) {
            handlerErrorResult(10806);
            return;
        }
        LogConsole.e(TAG, "other error code :" + i11 + "msg:" + str);
    }

    public void setApiRequest(BaseRouterTaskCallImpl baseRouterTaskCallImpl) {
        this.apiRequest = baseRouterTaskCallImpl;
    }
}
