package com.huawei.location.lite.common.http.interceptor;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.log.LogConsole;

public class CommonInterceptor extends BaseCommonInterceptor {
    public void addCustomHeads(BaseRequest.Builder builder) {
        a(builder, HiAnalyticsConstant.HaKey.BI_KEY_APPID, AGCManager.getInstance().getAppId());
        builder.removeHeader("User-Agent");
        a(builder, "User-Agent", BaseCommonInterceptor.b());
    }

    public void addCustomQuery(BaseRequest.Builder builder) {
        LogConsole.i("CommonHeadsInterceptor", "clientLiteSDKVersion:20700300");
        builder.addQuery("clientLiteSDKVersion", String.valueOf(20700300));
    }
}
