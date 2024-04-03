package com.apptimize;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.apptimize.ak;
import com.apptimize.bq;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.ExoPlayer;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class aj extends ai {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41102a = "aj";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final bq f41103b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f41104c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f41105d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ak f41106e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ak.a f41107f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f41108g = false;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Future> f41109h = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f41110i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Queue<Bundle> f41111j = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Messenger f41112k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f41113l = false;

    /* renamed from: m  reason: collision with root package name */
    private CountDownLatch f41114m = new CountDownLatch(1);

    /* renamed from: n  reason: collision with root package name */
    private Messenger f41115n;

    /* renamed from: o  reason: collision with root package name */
    private ah f41116o;

    /* renamed from: p  reason: collision with root package name */
    private long f41117p = 0;

    /* renamed from: q  reason: collision with root package name */
    private ServiceConnection f41118q = new ServiceConnection() {
        public void onBindingDied(ComponentName componentName) {
            String h11 = aj.f41102a;
            bo.g(h11, "onBindingDied " + componentName);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bo.k(aj.f41102a, "onServiceConnected");
            Messenger unused = aj.this.f41112k = new Messenger(iBinder);
            aj.this.j();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            String h11 = aj.f41102a;
            bo.g(h11, "onServiceDisconnected " + componentName);
            aj.this.g();
        }
    };

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(final Message message) {
            if (aj.this.f41110i) {
                String h11 = aj.f41102a;
                bo.k(h11, "client " + aj.this.f41104c + " handleMessage " + message.what);
            }
            fe.a(aj.f41102a, new fi() {
                public void run() {
                    Message message = message;
                    switch (message.what) {
                        case 1:
                            aj.this.k();
                            return;
                        case 2:
                            aj.this.b(message);
                            return;
                        case 3:
                            aj.this.c(message);
                            return;
                        case 4:
                            if (aj.this.f41107f != null) {
                                aj.this.f41107f.a();
                                return;
                            }
                            return;
                        case 5:
                            if (aj.this.f41107f != null) {
                                aj.this.f41107f.b();
                                return;
                            }
                            return;
                        case 6:
                            boolean unused = aj.this.f41108g = true;
                            Apptimize.disable();
                            return;
                        default:
                            a.super.handleMessage(message);
                            return;
                    }
                }
            });
        }
    }

    public aj(ak akVar, Context context, bq bqVar, int i11, Messenger messenger) {
        this.f41106e = akVar;
        this.f41105d = context;
        this.f41103b = bqVar;
        this.f41104c = i11;
        this.f41112k = messenger;
        this.f41110i = av.f41239b;
        ah a11 = ah.a();
        this.f41116o = a11;
        this.f41117p = a11.getId();
        this.f41115n = new Messenger(new a(this.f41116o.b()));
    }

    /* access modifiers changed from: private */
    public void k() {
    }

    /* access modifiers changed from: private */
    public void i() throws InterruptedException {
        b();
        this.f41114m.await(2, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public void j() {
        Bundle bundle = new Bundle();
        bundle.putInt("pid", this.f41104c);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.replyTo = this.f41115n;
        obtain.setData(bundle);
        int i11 = 0;
        boolean z11 = true;
        while (z11 && i11 < 3) {
            try {
                this.f41112k.send(obtain);
                this.f41114m.countDown();
            } catch (RemoteException e11) {
                if (TransactionTooLargeException.class.isAssignableFrom(e11.getClass())) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException unused) {
                    }
                    z11 = true;
                } else {
                    bo.e(f41102a, "Error", e11);
                }
            }
            z11 = false;
            i11++;
        }
    }

    public void c() {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = this.f41104c;
        obtain.replyTo = this.f41115n;
        a(obtain);
    }

    public void d() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.arg1 = this.f41104c;
        a(obtain);
    }

    public void e() {
        this.f41106e.b((fi) new fi() {
            public void run() {
                while (!aj.this.f41111j.isEmpty()) {
                    Bundle bundle = (Bundle) aj.this.f41111j.peek();
                    if (aj.this.f41106e.a(bundle.getString("state_provider")) != null) {
                        aj.this.f41111j.poll();
                        Message obtain = Message.obtain();
                        obtain.setData(bundle);
                        aj.this.c(obtain);
                    } else {
                        return;
                    }
                }
            }
        });
    }

    public void f() {
        if (!this.f41108g) {
            this.f41108g = true;
            Message obtain = Message.obtain();
            obtain.what = 6;
            a(obtain);
        }
    }

    public void g() {
        this.f41112k = null;
        this.f41114m = new CountDownLatch(1);
        synchronized (this) {
            this.f41113l = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r5.f41105d.bindService(new android.content.Intent(r5.f41105d, com.apptimize.ApptimizeService.class), r5.f41118q, 1) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        com.apptimize.bo.k(f41102a, "bindService started");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        com.apptimize.bo.k(f41102a, "bindService failed");
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        if (r5.f41112k == null) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f41113l     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x0039 }
            return
        L_0x0007:
            r0 = 1
            r5.f41113l = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r5)     // Catch:{ all -> 0x0039 }
            android.os.Messenger r1 = r5.f41112k
            if (r1 == 0) goto L_0x0013
            r5.j()
            return
        L_0x0013:
            android.content.Context r1 = r5.f41105d
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = r5.f41105d
            java.lang.Class<com.apptimize.ApptimizeService> r4 = com.apptimize.ApptimizeService.class
            r2.<init>(r3, r4)
            android.content.ServiceConnection r3 = r5.f41118q
            boolean r0 = r1.bindService(r2, r3, r0)
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = f41102a
            java.lang.String r1 = "bindService started"
            com.apptimize.bo.k(r0, r1)
            goto L_0x0038
        L_0x002e:
            java.lang.String r0 = f41102a
            java.lang.String r1 = "bindService failed"
            com.apptimize.bo.k(r0, r1)
            r5.g()
        L_0x0038:
            return
        L_0x0039:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0039 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.aj.b():void");
    }

    public int a() {
        return this.f41104c;
    }

    private void a(final Message message) {
        this.f41106e.c(new fi() {
            public void run() {
                boolean z11 = true;
                int i11 = 0;
                while (z11 && i11 < 3) {
                    try {
                        aj.this.i();
                        aj.this.f41112k.send(message);
                    } catch (DeadObjectException unused) {
                        aj.this.g();
                    } catch (RemoteException e11) {
                        if (TransactionTooLargeException.class.isAssignableFrom(e11.getClass())) {
                            try {
                                Thread.sleep(30);
                            } catch (InterruptedException unused2) {
                            }
                            z11 = true;
                        } else {
                            bo.e(aj.f41102a, "Error", e11);
                        }
                    } catch (InterruptedException e12) {
                        bo.e(aj.f41102a, "Error", e12);
                    }
                    z11 = false;
                    i11++;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void c(Message message) {
        Bundle data = message.getData();
        String string = data.getString("state_provider");
        String string2 = data.getString("action_name");
        long j11 = data.getLong("checksum");
        Object[] objArr = (Object[]) data.getSerializable(StepData.ARGS);
        ap a11 = this.f41106e.a(string);
        if (a11 == null) {
            this.f41111j.add(data);
            return;
        }
        String str = f41102a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("performTransientAction actionName:");
        sb2.append(string2);
        sb2.append(" providerName:");
        sb2.append(string);
        sb2.append(" argsCount:");
        sb2.append(objArr == null ? "null" : Integer.valueOf(objArr.length));
        bo.k(str, sb2.toString());
        long a12 = a11.a(string2, objArr);
        if (j11 != a12) {
            bo.e(str, String.format("Mismatch in checksum when processing transient action %s  for state provider %s, args %s. Expected: %d; Actual: %d", new Object[]{string2, string, Arrays.toString(objArr), Long.valueOf(j11), Long.valueOf(a12)}));
            this.f41103b.a(bq.b.MultiprocessChecksumMismatch, (Map<String, Object>) new HashMap<String, Object>(string, string2, objArr, j11, a12) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f41130a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ String f41131b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Object[] f41132c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ long f41133d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ long f41134e;

                {
                    this.f41130a = r3;
                    this.f41131b = r4;
                    this.f41132c = r5;
                    this.f41133d = r6;
                    this.f41134e = r8;
                    put("where", "performTransientAction");
                    put("provider", r3);
                    put(NativeProtocol.WEB_DIALOG_ACTION, r4);
                    put(StepData.ARGS, Arrays.toString(r5));
                    put("msgChecksum", Long.valueOf(r6));
                    put("myChecksum", Long.valueOf(r8));
                }
            });
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object[], java.lang.Object, java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, java.lang.String r5, com.apptimize.ft<java.lang.Long> r6, java.lang.Object[] r7) {
        /*
            r3 = this;
            com.apptimize.fd.b((java.lang.Object) r7)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "state_provider"
            r0.putString(r1, r4)
            java.lang.String r1 = "action_name"
            r0.putString(r1, r5)
            java.lang.Object r6 = r6.b()
            java.lang.Long r6 = (java.lang.Long) r6
            long r1 = r6.longValue()
            java.lang.String r6 = "checksum"
            r0.putLong(r6, r1)
            java.lang.String r6 = "pid"
            int r1 = r3.f41104c
            r0.putInt(r6, r1)
            java.lang.String r6 = "args"
            r0.putSerializable(r6, r7)
            android.os.Message r6 = android.os.Message.obtain()
            r7 = 2
            r6.what = r7
            r6.setData(r0)
            java.lang.String r7 = f41102a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "notifyStateChange:"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = " "
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = r0.toString()
            com.apptimize.bo.k(r7, r4)
            com.apptimize.ak r4 = r3.f41106e
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x0063
            com.apptimize.ak r4 = r3.f41106e
            r4.a((android.os.Message) r6)
            goto L_0x0066
        L_0x0063:
            r3.a((android.os.Message) r6)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.aj.a(java.lang.String, java.lang.String, com.apptimize.ft, java.lang.Object[]):void");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object[], java.lang.Object, java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r3, java.lang.String r4, com.apptimize.ft<java.lang.Long> r5, java.lang.Object[] r6) {
        /*
            r2 = this;
            com.apptimize.fd.b((java.lang.Object) r6)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "state_provider"
            r0.putString(r1, r3)
            java.lang.String r3 = "action_name"
            r0.putString(r3, r4)
            java.lang.Object r3 = r5.b()
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            java.lang.String r5 = "checksum"
            r0.putLong(r5, r3)
            java.lang.String r3 = "pid"
            int r4 = r2.f41104c
            r0.putInt(r3, r4)
            java.lang.String r3 = "args"
            r0.putSerializable(r3, r6)
            android.os.Message r3 = android.os.Message.obtain()
            r4 = 3
            r3.what = r4
            r3.setData(r0)
            com.apptimize.ak r4 = r2.f41106e
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x0045
            com.apptimize.ak r4 = r2.f41106e
            r4.b((android.os.Message) r3)
            goto L_0x0048
        L_0x0045:
            r2.a((android.os.Message) r3)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.aj.b(java.lang.String, java.lang.String, com.apptimize.ft, java.lang.Object[]):void");
    }

    public void a(ak.a aVar) {
        this.f41107f = aVar;
    }

    public boolean a(long j11) {
        return j11 == this.f41117p;
    }

    /* access modifiers changed from: private */
    public void b(Message message) {
        Bundle data = message.getData();
        String string = data.getString("state_provider");
        final long j11 = data.getLong("checksum");
        ao a11 = this.f41106e.a(string).a();
        synchronized (a11) {
            a11.b();
            final long longValue = a11.a().b().longValue();
            if (j11 != longValue) {
                Future future = this.f41109h.get(string);
                if (future != null) {
                    future.cancel(false);
                }
                final String str = string;
                this.f41109h.put(string, fg.f42427b.schedule(new fi() {
                    public void run() {
                        fe.a(aj.f41102a, new fi() {
                            public void run() {
                                String h11 = c.h(aj.this.f41105d);
                                String h12 = aj.f41102a;
                                AnonymousClass4 r32 = AnonymousClass4.this;
                                bo.e(h12, String.format("Mismatch in checksum when reloading state provider %s in process %s. Expected: %d. Actual: %d", new Object[]{str, h11, Long.valueOf(j11), Long.valueOf(longValue)}));
                                aj.this.f41103b.a(bq.b.MultiprocessChecksumMismatch, (Map<String, Object>) new HashMap<String, Object>(h11) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ String f41128a;

                                    {
                                        this.f41128a = r4;
                                        put("where", "handleReloadRequest");
                                        put("processName", r4);
                                        put("msgChecksum", Long.valueOf(j11));
                                        put("myChecksum", Long.valueOf(longValue));
                                    }
                                });
                            }
                        });
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS));
            } else {
                Future future2 = this.f41109h.get(string);
                if (future2 != null) {
                    future2.cancel(false);
                    this.f41109h.remove(string);
                }
            }
        }
    }
}
