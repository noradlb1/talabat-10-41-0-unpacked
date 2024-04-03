package com.huawei.location.lite.common.log;

import android.util.Log;
import java.text.Normalizer;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private boolean f50150yn;

    public yn(boolean z11) {
        this.f50150yn = z11;
    }

    private FB yn(int i11, String str, String str2, Throwable th2) {
        FB fb2 = new FB(i11, "LITE_SDK-" + str, this.f50150yn);
        fb2.yn(str2);
        fb2.yn(th2);
        return fb2;
    }

    private String yn(String str) {
        return str != null ? Normalizer.normalize(str, Normalizer.Form.NFKC).replace("\\n", "").replace("\\r", "") : "";
    }

    public void Vw(int i11, String str, String str2, Throwable th2) {
        FB yn2 = yn(i11, str, str2, th2);
        Log.println(i11, str, yn(yn2.Vw() + yn2.yn()));
    }

    public void yn(int i11, String str, String str2) {
        FB yn2 = yn(i11, str, str2, (Throwable) null);
        Log.println(i11, str, yn(yn2.Vw() + yn2.yn()));
    }

    public void yn(boolean z11) {
        this.f50150yn = z11;
    }
}
