package com.apptimize;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import com.apptimize.z;
import java.util.Calendar;

public class fc {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42411a = "fc";

    /* renamed from: b  reason: collision with root package name */
    private final Context f42412b;

    /* renamed from: c  reason: collision with root package name */
    private int f42413c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f42414d = new long[4];

    /* renamed from: e  reason: collision with root package name */
    private long f42415e = 0;

    public class a implements z.a {
        private a() {
        }

        public void a() {
        }

        public void a(Activity activity) {
            fc.this.a(Calendar.getInstance().getTimeInMillis());
        }

        public void b(Activity activity) {
        }
    }

    public fc(Context context) {
        this.f42412b = context;
    }

    private void b() {
        this.f42415e = Calendar.getInstance().getTimeInMillis() + 20000;
        this.f42414d = new long[4];
        this.f42413c = 0;
        String d11 = fb.d(this.f42412b);
        if (d11 == null) {
            d11 = fb.b(this.f42412b);
        }
        c.a(this.f42412b, ClipData.newPlainText("Pairing Token", "Pairing Token: " + d11), "pairing token");
        bo.f(f42411a, "Pairing token copied to clipboard");
    }

    public void a(z zVar) {
        zVar.a(new a());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x002e }
            long r0 = r0.getTimeInMillis()     // Catch:{ all -> 0x002e }
            long r2 = r4.f42415e     // Catch:{ all -> 0x002e }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0011
            monitor-exit(r4)
            return
        L_0x0011:
            int r0 = r4.f42413c     // Catch:{ all -> 0x002e }
            r1 = 4
            if (r0 < r1) goto L_0x0019
            r0 = 0
            r4.f42413c = r0     // Catch:{ all -> 0x002e }
        L_0x0019:
            long[] r0 = r4.f42414d     // Catch:{ all -> 0x002e }
            int r1 = r4.f42413c     // Catch:{ all -> 0x002e }
            r0[r1] = r5     // Catch:{ all -> 0x002e }
            int r1 = r1 + 1
            r4.f42413c = r1     // Catch:{ all -> 0x002e }
            boolean r5 = r4.a()     // Catch:{ all -> 0x002e }
            if (r5 == 0) goto L_0x002c
            r4.b()     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r4)
            return
        L_0x002e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fc.a(long):void");
    }

    private boolean a() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        for (long j11 : this.f42414d) {
            if (j11 + 20000 < timeInMillis) {
                return false;
            }
        }
        return true;
    }
}
