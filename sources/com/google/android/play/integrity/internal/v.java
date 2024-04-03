package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.integrity.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f44589a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f44590b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final k f44591c;

    /* renamed from: d  reason: collision with root package name */
    private final String f44592d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List f44593e = new ArrayList();
    @GuardedBy("attachedRemoteTasksLock")

    /* renamed from: f  reason: collision with root package name */
    private final Set f44594f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final Object f44595g = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f44596h;

    /* renamed from: i  reason: collision with root package name */
    private final Intent f44597i;

    /* renamed from: j  reason: collision with root package name */
    private final WeakReference f44598j;

    /* renamed from: k  reason: collision with root package name */
    private final IBinder.DeathRecipient f44599k = new n(this);
    @GuardedBy("attachedRemoteTasksLock")

    /* renamed from: l  reason: collision with root package name */
    private final AtomicInteger f44600l = new AtomicInteger(0);
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public ServiceConnection f44601m;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public IInterface f44602n;

    /* renamed from: o  reason: collision with root package name */
    private final q f44603o;

    public v(Context context, k kVar, String str, Intent intent, q qVar, @Nullable q qVar2, byte[] bArr) {
        this.f44590b = context;
        this.f44591c = kVar;
        this.f44592d = "IntegrityService";
        this.f44597i = intent;
        this.f44603o = qVar;
        this.f44598j = new WeakReference((Object) null);
    }

    public static /* synthetic */ void h(v vVar) {
        vVar.f44591c.d("reportBinderDeath", new Object[0]);
        q qVar = (q) vVar.f44598j.get();
        if (qVar != null) {
            vVar.f44591c.d("calling onBinderDied", new Object[0]);
            qVar.a();
        } else {
            vVar.f44591c.d("%s : Binder has died.", vVar.f44592d);
            for (l a11 : vVar.f44593e) {
                a11.a(vVar.s());
            }
            vVar.f44593e.clear();
        }
        vVar.t();
    }

    public static /* bridge */ /* synthetic */ void m(v vVar, l lVar) {
        if (vVar.f44602n == null && !vVar.f44596h) {
            vVar.f44591c.d("Initiate binding to the service.", new Object[0]);
            vVar.f44593e.add(lVar);
            u uVar = new u(vVar, (t) null);
            vVar.f44601m = uVar;
            vVar.f44596h = true;
            if (!vVar.f44590b.bindService(vVar.f44597i, uVar, 1)) {
                vVar.f44591c.d("Failed to bind to the service.", new Object[0]);
                vVar.f44596h = false;
                for (l a11 : vVar.f44593e) {
                    a11.a(new w());
                }
                vVar.f44593e.clear();
            }
        } else if (vVar.f44596h) {
            vVar.f44591c.d("Waiting to bind to the service.", new Object[0]);
            vVar.f44593e.add(lVar);
        } else {
            lVar.run();
        }
    }

    public static /* bridge */ /* synthetic */ void n(v vVar) {
        vVar.f44591c.d("linkToDeath", new Object[0]);
        try {
            vVar.f44602n.asBinder().linkToDeath(vVar.f44599k, 0);
        } catch (RemoteException e11) {
            vVar.f44591c.c(e11, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void o(v vVar) {
        vVar.f44591c.d("unlinkToDeath", new Object[0]);
        vVar.f44602n.asBinder().unlinkToDeath(vVar.f44599k, 0);
    }

    private final RemoteException s() {
        return new RemoteException(String.valueOf(this.f44592d).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void t() {
        synchronized (this.f44595g) {
            for (TaskCompletionSource trySetException : this.f44594f) {
                trySetException.trySetException(s());
            }
            this.f44594f.clear();
        }
    }

    public final Handler c() {
        Handler handler;
        Map map = f44589a;
        synchronized (map) {
            if (!map.containsKey(this.f44592d)) {
                HandlerThread handlerThread = new HandlerThread(this.f44592d, 10);
                handlerThread.start();
                map.put(this.f44592d, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f44592d);
        }
        return handler;
    }

    @Nullable
    public final IInterface e() {
        return this.f44602n;
    }

    public final void p(l lVar, @Nullable TaskCompletionSource taskCompletionSource) {
        synchronized (this.f44595g) {
            this.f44594f.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new m(this, taskCompletionSource));
        }
        synchronized (this.f44595g) {
            if (this.f44600l.getAndIncrement() > 0) {
                this.f44591c.a("Already connected to the service.", new Object[0]);
            }
        }
        c().post(new o(this, lVar.c(), lVar));
    }

    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f44595g) {
            this.f44594f.remove(taskCompletionSource);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        c().post(new com.google.android.play.integrity.internal.p(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(com.google.android.gms.tasks.TaskCompletionSource r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f44595g
            monitor-enter(r0)
            java.util.Set r1 = r3.f44594f     // Catch:{ all -> 0x0039 }
            r1.remove(r4)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            java.lang.Object r4 = r3.f44595g
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f44600l     // Catch:{ all -> 0x0036 }
            int r0 = r0.get()     // Catch:{ all -> 0x0036 }
            if (r0 <= 0) goto L_0x0028
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f44600l     // Catch:{ all -> 0x0036 }
            int r0 = r0.decrementAndGet()     // Catch:{ all -> 0x0036 }
            if (r0 <= 0) goto L_0x0028
            com.google.android.play.integrity.internal.k r0 = r3.f44591c     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "Leaving the connection open for other ongoing calls."
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0036 }
            r0.d(r1, r2)     // Catch:{ all -> 0x0036 }
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            return
        L_0x0028:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            com.google.android.play.integrity.internal.p r4 = new com.google.android.play.integrity.internal.p
            r4.<init>(r3)
            android.os.Handler r0 = r3.c()
            r0.post(r4)
            return
        L_0x0036:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r0
        L_0x0039:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.integrity.internal.v.r(com.google.android.gms.tasks.TaskCompletionSource):void");
    }
}
