package com.huawei.hms.push.utils;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

public final class PushBiUtil {
    private PushBiUtil() {
    }

    public static String reportEntry(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 60700300);
    }

    public static void reportExit(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60700300);
    }

    public static void reportExit(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 60700300);
    }

    public static void reportExit(Context context, String str, String str2, int i11) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i11, 60700300);
    }
}
