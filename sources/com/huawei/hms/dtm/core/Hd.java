package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.concurrent.CountDownLatch;

public class Hd implements ValueCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CountDownLatch f48317a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String[] f48318b;

    public Hd(CountDownLatch countDownLatch, String[] strArr) {
        this.f48317a = countDownLatch;
        this.f48318b = strArr;
    }

    /* renamed from: a */
    public void onReceiveValue(String str) {
        if (TextUtils.isEmpty(str) || str.equals("null")) {
            Logger.info("DTM-AutoTrace", "WebView tree is null");
        } else {
            String replace = str.replace("\\\\", "\\").replace("\\\"", "\"");
            if (replace.startsWith("\"") && replace.endsWith("\"") && replace.length() >= 2) {
                replace = replace.substring(1, replace.length() - 1);
            }
            Logger.debug("DTM-AutoTrace", "WebView tree:" + replace);
            this.f48318b[0] = replace;
        }
        this.f48317a.countDown();
    }
}
