package com.apptimize;

import com.apptimize.ak;
import com.apptimize.bj;
import com.google.android.exoplayer2.C;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class gd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42503a = "gd";

    /* renamed from: b  reason: collision with root package name */
    private final bj f42504b;

    /* renamed from: c  reason: collision with root package name */
    private final fv f42505c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42506d;

    /* renamed from: e  reason: collision with root package name */
    private final b f42507e;

    /* renamed from: f  reason: collision with root package name */
    private final au f42508f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final fo f42509g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Timer f42510h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f42511i = a.DisconnectedUntilNotice;

    /* renamed from: j  reason: collision with root package name */
    private boolean f42512j = false;

    /* renamed from: k  reason: collision with root package name */
    private final ak.a f42513k = new ak.a() {
        public void a() {
            synchronized (gd.this) {
                String f11 = gd.f42503a;
                bo.k(f11, "onAcquireWebSocket connectionStatus:" + gd.this.f42511i);
                if (gd.this.f42511i == a.WaitingToAcquire) {
                    a unused = gd.this.f42511i = a.ReadyToConnect;
                    gd.this.i();
                } else if (gd.this.f42511i == a.DisconnectedUntilNotice) {
                    gd.this.h();
                }
            }
        }

        public void b() {
            gd.this.f42509g.a(5);
        }
    };

    public enum a {
        DisconnectedUntilNotice,
        WaitingToAcquire,
        ReadyToConnect,
        ConnectPending,
        Connected,
        DisconnectPending
    }

    public interface b {
        void a();

        void a(JSONObject jSONObject);

        void b();
    }

    public class c implements bj.a {
        private c() {
        }

        public void a() {
            gd.this.j();
        }

        public void a(String str) {
            gd.this.a(str);
        }

        public void a(byte[] bArr) {
            gd.this.a(bArr);
        }

        public void a(int i11, String str) {
            gd.this.b(str);
        }

        public void a(Exception exc) {
            gd.this.a(exc);
            gd.this.d();
        }
    }

    public gd(String str, bj.b bVar, b bVar2, au auVar) {
        this.f42506d = str;
        this.f42507e = bVar2;
        this.f42508f = auVar;
        this.f42505c = auVar.b();
        List emptyList = Collections.emptyList();
        this.f42504b = bVar.a(URI.create(str), new c(), emptyList);
        this.f42509g = auVar.b().a((fi) new fi() {
            public void run() {
                synchronized (gd.this) {
                    if (gd.this.f42511i == a.WaitingToAcquire) {
                        gd.this.g();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f42508f.d().a(this.f42513k);
        this.f42508f.d().f();
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f42508f.d().g();
    }

    /* access modifiers changed from: private */
    public synchronized void i() {
        if (this.f42511i != a.ReadyToConnect) {
            String str = f42503a;
            bo.n(str, "Unexpected connection status at connectWebSocket(): " + this.f42511i);
        }
        if (this.f42511i == a.DisconnectedUntilNotice) {
            bo.k(f42503a, "Call to connectWebSocket() ignored because we are not trying to connectWebSocket");
            return;
        }
        this.f42511i = a.ConnectPending;
        this.f42504b.b();
    }

    /* access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            a aVar = this.f42511i;
            if (aVar == a.DisconnectedUntilNotice) {
                this.f42504b.c();
            } else if (aVar != a.DisconnectPending) {
                if (aVar != a.ConnectPending) {
                    String str = f42503a;
                    bo.n(str, "Unexpected connection status at clientConnected(): " + this.f42511i);
                }
                this.f42512j = false;
                this.f42511i = a.Connected;
                br.a();
                bo.o(f42503a, "Connected to websocket");
                this.f42507e.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void k() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.apptimize.gd$a r0 = r3.f42511i     // Catch:{ all -> 0x003c }
            com.apptimize.gd$a r1 = com.apptimize.gd.a.DisconnectPending     // Catch:{ all -> 0x003c }
            if (r0 == r1) goto L_0x003a
            com.apptimize.gd$a r1 = com.apptimize.gd.a.DisconnectedUntilNotice     // Catch:{ all -> 0x003c }
            if (r0 != r1) goto L_0x000c
            goto L_0x003a
        L_0x000c:
            boolean r1 = r3.f42512j     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0016
            com.apptimize.gd$a r1 = com.apptimize.gd.a.ConnectPending     // Catch:{ all -> 0x003c }
            if (r0 != r1) goto L_0x0016
            monitor-exit(r3)
            return
        L_0x0016:
            r1 = 1
            r3.f42512j = r1     // Catch:{ all -> 0x003c }
            com.apptimize.gd$a r1 = com.apptimize.gd.a.ConnectPending     // Catch:{ all -> 0x003c }
            if (r0 != r1) goto L_0x0020
            java.lang.String r0 = "Unable to connectWebSocket to websocket server"
            goto L_0x0022
        L_0x0020:
            java.lang.String r0 = "Disconnected from the websocket server"
        L_0x0022:
            java.lang.String r1 = f42503a     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r2.append(r0)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = " This device won't be able to verify the integration. Please double-check this device has internet access"
            r2.append(r0)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x003c }
            com.apptimize.bo.s(r1, r0)     // Catch:{ all -> 0x003c }
            monitor-exit(r3)
            return
        L_0x003a:
            monitor-exit(r3)
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gd.k():void");
    }

    public synchronized void c() {
        if (this.f42511i != a.DisconnectedUntilNotice) {
            bo.n(f42503a, "Ignoring attempt to start connecting when we were already connecting or connected");
            return;
        }
        this.f42511i = a.WaitingToAcquire;
        g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.apptimize.gd$a r0 = r2.f42511i     // Catch:{ all -> 0x0034 }
            com.apptimize.gd$a r1 = com.apptimize.gd.a.DisconnectedUntilNotice     // Catch:{ all -> 0x0034 }
            if (r0 != r1) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            com.apptimize.gd$a r1 = com.apptimize.gd.a.ConnectPending     // Catch:{ all -> 0x0034 }
            if (r0 != r1) goto L_0x001a
            com.apptimize.br.b()     // Catch:{ all -> 0x0034 }
            com.apptimize.gd$a r0 = com.apptimize.gd.a.DisconnectPending     // Catch:{ all -> 0x0034 }
            r2.f42511i = r0     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = "Error during connection."
            r2.b((java.lang.String) r0)     // Catch:{ all -> 0x0034 }
            goto L_0x0032
        L_0x001a:
            com.apptimize.gd$a r1 = com.apptimize.gd.a.Connected     // Catch:{ all -> 0x0034 }
            if (r0 != r1) goto L_0x002b
            com.apptimize.br.b()     // Catch:{ all -> 0x0034 }
            com.apptimize.gd$a r0 = com.apptimize.gd.a.DisconnectPending     // Catch:{ all -> 0x0034 }
            r2.f42511i = r0     // Catch:{ all -> 0x0034 }
            com.apptimize.bj r0 = r2.f42504b     // Catch:{ all -> 0x0034 }
            r0.c()     // Catch:{ all -> 0x0034 }
            goto L_0x0032
        L_0x002b:
            java.lang.String r0 = f42503a     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "Already trying to connectWebSocket; ignoring reconnect call()"
            com.apptimize.bo.k(r0, r1)     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r2)
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gd.d():void");
    }

    public synchronized void e() {
        br.b();
        this.f42504b.c();
        this.f42511i = a.DisconnectedUntilNotice;
    }

    public String b() {
        return this.f42506d;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        try {
            synchronized (this) {
                String str2 = f42503a;
                bo.k(str2, "clientDisconnect connectionStatus:" + this.f42511i);
                if (this.f42511i == a.DisconnectedUntilNotice) {
                    h();
                    this.f42507e.b();
                    return;
                }
                k();
                this.f42511i = a.ReadyToConnect;
                Timer timer = this.f42510h;
                if (timer != null) {
                    timer.cancel();
                }
                Timer a11 = this.f42505c.a();
                this.f42510h = a11;
                a11.schedule(new TimerTask() {
                    public void run() {
                        fe.a(gd.f42503a, new fi() {
                            public void run() {
                                synchronized (this) {
                                    Timer unused = gd.this.f42510h = null;
                                    gd.this.i();
                                }
                            }
                        });
                    }
                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                this.f42507e.b();
            }
        } catch (Throwable th2) {
            this.f42507e.b();
            throw th2;
        }
    }

    public synchronized boolean a() {
        return this.f42511i == a.Connected;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        com.apptimize.br.a("s", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if ((r4 instanceof org.json.JSONObject) != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r4 = r4.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r3.f42504b.a(com.apptimize.fd.a(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        com.apptimize.bo.i(f42503a, "Error when sending message", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.apptimize.gd$a r0 = r3.f42511i     // Catch:{ all -> 0x0052 }
            com.apptimize.gd$a r1 = com.apptimize.gd.a.Connected     // Catch:{ all -> 0x0052 }
            if (r0 == r1) goto L_0x002c
            java.lang.String r0 = f42503a     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "Unable to send message (not connected): "
            r1.append(r2)     // Catch:{ all -> 0x0052 }
            boolean r2 = r4 instanceof org.json.JSONObject     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x001c
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0052 }
            goto L_0x0020
        L_0x001c:
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch:{ all -> 0x0052 }
        L_0x0020:
            r1.append(r4)     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0052 }
            com.apptimize.bo.n(r0, r4)     // Catch:{ all -> 0x0052 }
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            return
        L_0x002c:
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "s"
            com.apptimize.br.a((java.lang.String) r0, (org.json.JSONObject) r4)
            boolean r0 = r4 instanceof org.json.JSONObject     // Catch:{ IOException -> 0x0049 }
            if (r0 != 0) goto L_0x003b
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0049 }
            goto L_0x003f
        L_0x003b:
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch:{ IOException -> 0x0049 }
        L_0x003f:
            byte[] r4 = com.apptimize.fd.a((java.lang.String) r4)     // Catch:{ IOException -> 0x0049 }
            com.apptimize.bj r0 = r3.f42504b     // Catch:{ IOException -> 0x0049 }
            r0.a(r4)     // Catch:{ IOException -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r4 = move-exception
            java.lang.String r0 = f42503a
            java.lang.String r1 = "Error when sending message"
            com.apptimize.bo.i(r0, r1, r4)
        L_0x0051:
            return
        L_0x0052:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gd.a(org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        synchronized (this) {
            if (this.f42511i != a.Connected) {
                String str2 = f42503a;
                bo.k(str2, "Ignoring message because we're not in a connected state: " + str);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                br.a("r", jSONObject);
                this.f42507e.a(jSONObject);
            } catch (JSONException e11) {
                bo.i(f42503a, "JSON processing error", e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(byte[] bArr) {
        synchronized (this) {
            if (this.f42511i != a.Connected) {
                bo.k(f42503a, "Ignoring binary message because we're not in a connected state");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(fd.a(bArr));
                br.a("r", jSONObject);
                this.f42507e.a(jSONObject);
            } catch (IOException unused) {
                bo.l(f42503a, "GZIP error decoding websocket message");
            } catch (JSONException e11) {
                bo.i(f42503a, "JSON processing error", e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(Exception exc) {
        a aVar = this.f42511i;
        if (aVar != a.DisconnectPending) {
            if (aVar != a.DisconnectedUntilNotice) {
                if (aVar != a.ConnectPending) {
                    bo.l(f42503a, "Error, will attempt to reconnect", exc);
                    return;
                } else if (!this.f42512j) {
                    this.f42512j = true;
                    bo.s(f42503a, "Unable to connectWebSocket to websocket server. This device won't be able to verify the integration. Please double-check this device has internet access");
                    return;
                } else {
                    return;
                }
            }
        }
        bo.h(f42503a, "Error while disconnecting. (Probably safe to ignore.)", exc);
    }
}
