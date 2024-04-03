package com.huawei.location.router.dispatch;

import com.huawei.location.lite.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;

class ErrorTaskCall extends BaseRouterTaskCallImpl {
    public void onComplete(int i11) {
        onComplete(i11, LocationStatusCode.getStatusCodeString(i11));
    }

    public void onComplete(int i11, String str) {
        LogConsole.e("ErrorRequestApi", "handlerNoApiTask");
        onComplete(new RouterResponse("", new StatusInfo(0, i11, str)));
    }

    public void onRequest(String str) {
    }
}
