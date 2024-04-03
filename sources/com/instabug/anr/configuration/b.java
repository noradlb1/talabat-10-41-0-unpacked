package com.instabug.anr.configuration;

import com.instabug.commons.configurations.a;
import com.instabug.commons.utils.c;
import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class b implements a {
    static {
        new a((DefaultConstructorMarker) null);
    }

    private final boolean b() {
        Pair e11 = com.instabug.crash.a.f46376a.e();
        boolean booleanValue = ((Boolean) e11.component2()).booleanValue();
        return c.f46365a.a((String) e11.component1(), booleanValue, "instabug_crash");
    }

    private final void c() {
        c.f46365a.b((String) com.instabug.crash.a.f46376a.e().getFirst(), true, "instabug_crash");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0005
            goto L_0x0012
        L_0x0005:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0026 }
            r0.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0026 }
            java.lang.String r5 = "crashes"
            org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0014
        L_0x0012:
            r5 = 0
            goto L_0x0021
        L_0x0014:
            java.lang.String r0 = "anr"
            boolean r5 = r5.optBoolean(r0)     // Catch:{ all -> 0x0026 }
            r4.a((boolean) r5)     // Catch:{ all -> 0x0026 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0026 }
        L_0x0021:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0026 }
            goto L_0x0031
        L_0x0026:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0031:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            java.lang.String r1 = ""
            java.lang.String r2 = "Something went wrong while parsing ANR from features response "
            if (r0 != 0) goto L_0x003c
            goto L_0x004a
        L_0x003c:
            java.lang.String r3 = r0.getMessage()
            if (r3 != 0) goto L_0x0043
            r3 = r1
        L_0x0043:
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            com.instabug.library.core.InstabugCore.reportError(r0, r3)
        L_0x004a:
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r5 != 0) goto L_0x0051
            goto L_0x0062
        L_0x0051:
            java.lang.String r0 = r5.getMessage()
            if (r0 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r1 = r0
        L_0x0059:
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            java.lang.String r1 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r5)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.anr.configuration.b.a(java.lang.String):void");
    }

    public void a() {
        if (!b() && Instabug.getApplicationContext() != null) {
            a(c.f46365a.a("ANR_REPORTINGAVAIL", ((Boolean) com.instabug.crash.a.f46376a.a().getSecond()).booleanValue(), SettingsManager.INSTABUG_SHARED_PREF_NAME));
            c();
        }
    }

    private final void a(boolean z11) {
        com.instabug.anr.di.c.b().a(z11);
    }
}
