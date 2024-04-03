package com.instabug.featuresrequest.ui.custom;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import nc.e;

public class t {

    /* renamed from: e  reason: collision with root package name */
    private static t f46725e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f46726a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f46727b = new Handler(Looper.getMainLooper(), new e(this));
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private s f46728c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private s f46729d;

    private t() {
    }

    private void a(s sVar) {
        synchronized (this.f46726a) {
            if (this.f46728c == sVar || this.f46729d == sVar) {
                a(sVar, 2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 0) {
            return false;
        }
        a((s) message.obj);
        return true;
    }

    private boolean a(s sVar, int i11) {
        r rVar = (r) sVar.f46723a.get();
        if (rVar == null) {
            return false;
        }
        rVar.a(i11);
        return true;
    }

    private void b() {
        s sVar = this.f46729d;
        if (sVar != null) {
            this.f46728c = sVar;
            this.f46729d = null;
            r rVar = (r) sVar.f46723a.get();
            if (rVar != null) {
                rVar.a();
            } else {
                this.f46728c = null;
            }
        }
    }

    private void b(@Nullable s sVar) {
        if (sVar != null && sVar.f46724b != -2) {
            int a11 = sVar.f46724b > 0 ? sVar.f46724b : sVar.f46724b == -1 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 2750;
            this.f46727b.removeCallbacksAndMessages(sVar);
            Handler handler = this.f46727b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, sVar), (long) a11);
        }
    }

    public static synchronized t c() {
        t tVar;
        synchronized (t.class) {
            if (f46725e == null) {
                f46725e = new t();
            }
            tVar = f46725e;
        }
        return tVar;
    }

    private boolean c(r rVar) {
        s sVar = this.f46728c;
        return sVar != null && sVar.c(rVar);
    }

    private boolean d(r rVar) {
        s sVar = this.f46729d;
        return sVar != null && sVar.c(rVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5, com.instabug.featuresrequest.ui.custom.r r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f46726a
            monitor-enter(r0)
            com.instabug.featuresrequest.ui.custom.s r1 = r4.f46728c     // Catch:{ all -> 0x0045 }
            com.instabug.featuresrequest.ui.custom.s r2 = r4.f46729d     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0043
            if (r2 != 0) goto L_0x000c
            goto L_0x0043
        L_0x000c:
            boolean r3 = r4.c(r6)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x001f
            int unused = r1.f46724b = r5     // Catch:{ all -> 0x0045 }
            android.os.Handler r5 = r4.f46727b     // Catch:{ all -> 0x0045 }
            r5.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0045 }
            r4.b((com.instabug.featuresrequest.ui.custom.s) r1)     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x001f:
            boolean r3 = r4.d(r6)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0029
            int unused = r2.f46724b = r5     // Catch:{ all -> 0x0045 }
            goto L_0x002e
        L_0x0029:
            com.instabug.featuresrequest.ui.custom.s r2 = new com.instabug.featuresrequest.ui.custom.s     // Catch:{ all -> 0x0045 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0045 }
        L_0x002e:
            r4.f46728c = r1     // Catch:{ all -> 0x0045 }
            r4.f46729d = r2     // Catch:{ all -> 0x0045 }
            r5 = 4
            boolean r5 = r4.a((com.instabug.featuresrequest.ui.custom.s) r1, (int) r5)     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x003b
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x003b:
            r5 = 0
            r4.f46728c = r5     // Catch:{ all -> 0x0045 }
            r4.b()     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.ui.custom.t.a(int, com.instabug.featuresrequest.ui.custom.r):void");
    }

    public void a(r rVar) {
        synchronized (this.f46726a) {
            if (this.f46728c != null && c(rVar)) {
                this.f46727b.removeCallbacksAndMessages(this.f46728c);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.instabug.featuresrequest.ui.custom.r r5, int r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f46726a
            monitor-enter(r0)
            com.instabug.featuresrequest.ui.custom.s r1 = r4.f46728c     // Catch:{ all -> 0x0027 }
            com.instabug.featuresrequest.ui.custom.s r2 = r4.f46729d     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0025
            if (r2 != 0) goto L_0x000c
            goto L_0x0025
        L_0x000c:
            boolean r3 = r4.c(r5)     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0016
            r4.a((com.instabug.featuresrequest.ui.custom.s) r1, (int) r6)     // Catch:{ all -> 0x0027 }
            goto L_0x001f
        L_0x0016:
            boolean r5 = r4.d(r5)     // Catch:{ all -> 0x0027 }
            if (r5 == 0) goto L_0x001f
            r4.a((com.instabug.featuresrequest.ui.custom.s) r2, (int) r6)     // Catch:{ all -> 0x0027 }
        L_0x001f:
            r4.f46728c = r1     // Catch:{ all -> 0x0027 }
            r4.f46729d = r2     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.ui.custom.t.a(com.instabug.featuresrequest.ui.custom.r, int):void");
    }

    public boolean b(r rVar) {
        boolean z11;
        synchronized (this.f46726a) {
            if (!c(rVar)) {
                if (!d(rVar)) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public void e(r rVar) {
        synchronized (this.f46726a) {
            if (c(rVar)) {
                this.f46728c = null;
                if (this.f46729d != null) {
                    b();
                }
            }
        }
    }

    public void f(r rVar) {
        synchronized (this.f46726a) {
            s sVar = this.f46728c;
            if (sVar != null) {
                if (c(rVar)) {
                    b(sVar);
                }
                this.f46728c = sVar;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(com.instabug.featuresrequest.ui.custom.r r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f46726a
            monitor-enter(r0)
            com.instabug.featuresrequest.ui.custom.s r1 = r2.f46728c     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x0009:
            boolean r3 = r2.c(r3)     // Catch:{ all -> 0x0016 }
            if (r3 == 0) goto L_0x0014
            com.instabug.featuresrequest.ui.custom.s r3 = r2.f46728c     // Catch:{ all -> 0x0016 }
            r2.b((com.instabug.featuresrequest.ui.custom.s) r3)     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x0016:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.ui.custom.t.g(com.instabug.featuresrequest.ui.custom.r):void");
    }
}
