package com.instabug.apm.handler.uitrace;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.instabug.apm.logger.APMLogger;

public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private String f45434a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f45435b = "";

    /* renamed from: c  reason: collision with root package name */
    private final e f45436c;

    public g(@NonNull e eVar) {
        this.f45436c = eVar;
    }

    private void a() {
        APMLogger.d("Can not trace the current screen because Activity is null");
    }

    @RequiresApi(api = 16)
    public void a(Activity activity) {
        e eVar;
        String str = this.f45435b;
        if (str != null && !str.isEmpty() && (eVar = this.f45436c) != null) {
            eVar.a(activity, System.nanoTime(), this.f45435b);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (r5 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r5 != null) goto L_0x0060;
     */
    @androidx.annotation.RequiresApi(api = 16)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = r13.f45434a
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = r13.f45435b
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = java.lang.System.nanoTime()
            com.instabug.library.tracking.InstabugInternalTrackingDelegate r4 = com.instabug.library.tracking.InstabugInternalTrackingDelegate.getInstance()
            android.app.Activity r4 = r4.getCurrentActivity()
            if (r4 == 0) goto L_0x0069
            com.instabug.apm.handler.uitrace.e r5 = r13.f45436c
            if (r5 == 0) goto L_0x0069
            goto L_0x0060
        L_0x0029:
            com.instabug.library.tracking.InstabugInternalTrackingDelegate r0 = com.instabug.library.tracking.InstabugInternalTrackingDelegate.getInstance()
            android.app.Activity r0 = r0.getCurrentActivity()
            long r1 = java.lang.System.nanoTime()
            if (r0 == 0) goto L_0x0041
            com.instabug.apm.handler.uitrace.e r3 = r13.f45436c
            if (r3 == 0) goto L_0x0041
            java.lang.String r4 = r13.f45435b
            r3.a(r0, r1, r4)
            goto L_0x0046
        L_0x0041:
            java.lang.String r0 = "Can not stop tracing the current screen because Activity is null"
            com.instabug.apm.logger.APMLogger.d(r0)
        L_0x0046:
            java.lang.String r0 = r13.f45435b
            r13.f45434a = r0
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = java.lang.System.nanoTime()
            com.instabug.library.tracking.InstabugInternalTrackingDelegate r4 = com.instabug.library.tracking.InstabugInternalTrackingDelegate.getInstance()
            android.app.Activity r4 = r4.getCurrentActivity()
            if (r4 == 0) goto L_0x0069
            com.instabug.apm.handler.uitrace.e r5 = r13.f45436c
            if (r5 == 0) goto L_0x0069
        L_0x0060:
            r9 = r0
            r11 = r2
            r7 = r4
            r6 = r5
            r8 = r14
            r6.a(r7, r8, r9, r11)
            goto L_0x006c
        L_0x0069:
            r13.a()
        L_0x006c:
            r13.f45435b = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.handler.uitrace.g.a(java.lang.String):void");
    }
}
