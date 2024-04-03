package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.md  reason: case insensitive filesystem */
public class C0406md implements C0396kd {

    /* renamed from: a  reason: collision with root package name */
    private static final C0406md f48518a = new C0406md();

    /* renamed from: b  reason: collision with root package name */
    private C0396kd f48519b = new C0401ld();

    /* renamed from: c  reason: collision with root package name */
    private boolean f48520c = true;

    private C0406md() {
    }

    public static C0406md a() {
        return f48518a;
    }

    public void a(Context context) {
        this.f48519b.a(context);
    }

    public void a(Context context, String str, Map<String, String> map) {
        if (context == null || !this.f48520c) {
            Logger.debug("DTM-Execute", "disable trace: " + str + " " + map.toString());
            return;
        }
        this.f48519b.a(context, str, map);
    }

    public void a(boolean z11) {
        this.f48520c = z11;
    }
}
