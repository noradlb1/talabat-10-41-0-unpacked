package com.huawei.location.activity;

import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.util.LoadSoUtil;
import java.io.File;

public class Vw {
    public static final String Vw;

    /* renamed from: yn  reason: collision with root package name */
    public static final String f49988yn;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.huawei.location.activity.model.Vw.yn(ContextUtil.getContext()));
        String str = File.separator;
        sb2.append(str);
        f49988yn = sb2.toString();
        Vw = com.huawei.location.activity.model.Vw.yn(ContextUtil.getContext()) + str + LoadSoUtil.getCurrentCpuAbi(ContextUtil.getContext());
    }
}
