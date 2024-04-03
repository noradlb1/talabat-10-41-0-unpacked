package com.huawei.hms.dtm.core;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;

public final class Qb extends Y {

    /* renamed from: a  reason: collision with root package name */
    private DisplayMetrics f48396a = new DisplayMetrics();

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                WindowManager windowManager = (WindowManager) c11.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(this.f48396a);
                }
                return new Cc(this.f48396a.widthPixels + Param.X + this.f48396a.heightPixels);
            }
            throw new V("resolution#appContext null");
        }
        throw new V("resolution#params error");
    }

    public String a() {
        return "resolution";
    }
}
