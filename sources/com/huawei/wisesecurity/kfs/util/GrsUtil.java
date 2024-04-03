package com.huawei.wisesecurity.kfs.util;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.wisesecurity.kfs.exception.KfsException;

public final class GrsUtil {
    public static void grsAsyncGetUrl(Context context, String str, String str2, String str3, String str4, final IQueryUrlCallBack iQueryUrlCallBack) {
        initGrs(context, str, str2).ayncGetGrsUrl(str3, str4, new IQueryUrlCallBack() {
            public void onCallBackFail(int i11) {
                iQueryUrlCallBack.onCallBackFail(i11);
            }

            public void onCallBackSuccess(String str) {
                iQueryUrlCallBack.onCallBackSuccess(str);
            }
        });
    }

    public static String grsSyncGetUrl(Context context, String str, String str2, String str3, String str4) throws KfsException {
        GrsClient initGrs = initGrs(context, str, str2);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return initGrs.synGetGrsUrl(str3, str4);
        }
        throw new KfsException("must not be called on the UI thread");
    }

    public static GrsClient initGrs(Context context, String str, String str2) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        if (!TextUtils.isEmpty(str2)) {
            grsBaseInfo.setAppName(str2);
        }
        grsBaseInfo.setSerCountry(str);
        return new GrsClient(context, grsBaseInfo);
    }
}
