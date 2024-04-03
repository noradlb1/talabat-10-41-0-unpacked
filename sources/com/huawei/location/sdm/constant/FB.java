package com.huawei.location.sdm.constant;

import android.content.Context;
import android.os.Build;
import com.huawei.location.lite.common.android.context.ContextUtil;
import java.io.File;

public class FB {
    public static final String Vw;

    /* renamed from: yn  reason: collision with root package name */
    public static final String f50225yn;

    static {
        File file;
        StringBuilder sb2 = new StringBuilder();
        Context context = ContextUtil.getContext();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        sb2.append(context.getFilesDir().getPath());
        String str = File.separator;
        sb2.append(str);
        f50225yn = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        Context context2 = ContextUtil.getContext();
        if (i11 >= 24) {
            file = context2.createDeviceProtectedStorageContext().getFilesDir();
        } else {
            file = context2.getFilesDir();
        }
        sb3.append(file.getPath());
        sb3.append(str);
        sb3.append("libSdm.so");
        Vw = sb3.toString();
    }
}
