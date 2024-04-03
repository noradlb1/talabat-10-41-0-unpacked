package com.apptimize;

import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import com.apptimize.an;
import com.apptimize.bq;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41139a = "ak";

    /* renamed from: b  reason: collision with root package name */
    private final bq f41140b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ap> f41141c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f41142d = false;

    /* renamed from: e  reason: collision with root package name */
    private an f41143e = new an.b();

    /* renamed from: f  reason: collision with root package name */
    private Context f41144f;

    /* renamed from: g  reason: collision with root package name */
    private ai f41145g;

    /* renamed from: h  reason: collision with root package name */
    private al f41146h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41147i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f41148j = false;

    /* renamed from: k  reason: collision with root package name */
    private ExecutorService f41149k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public AtomicLong f41150l = new AtomicLong();

    /* renamed from: m  reason: collision with root package name */
    private boolean f41151m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f41152n = false;

    /* renamed from: o  reason: collision with root package name */
    private int f41153o = Process.myPid();

    public interface a {
        void a();

        void b();
    }

    public ak(bq bqVar) {
        this.f41140b = bqVar;
        this.f41145g = new aq(this);
        this.f41146h = new ar();
    }

    private int j() {
        return this.f41153o;
    }

    public boolean b() {
        return this.f41142d;
    }

    public boolean c() {
        if (!this.f41142d) {
            return true;
        }
        if (!this.f41152n) {
            Class<ApptimizeService> cls = ApptimizeService.class;
            this.f41151m = c.b(this.f41144f, cls.getName()).equals(c.h(this.f41144f));
            this.f41152n = true;
            String str = f41139a;
            bo.k(str, "ApptimizeService processName:" + c.b(this.f41144f, cls.getName()));
            bo.k(str, "This processName:" + c.h(this.f41144f));
        }
        return this.f41151m;
    }

    public boolean d() {
        return this.f41148j;
    }

    public boolean e() {
        if (c()) {
            return true;
        }
        bo.b(f41139a, "Illegal action performed off main process", new Exception());
        this.f41140b.a(bq.b.ActionOffMainProcess, new Exception());
        return false;
    }

    public void f() {
        bo.k(f41139a, "acquireWebSocket");
        this.f41145g.c();
    }

    public void g() {
        bo.k(f41139a, "relinquishWebSocket");
        this.f41145g.d();
    }

    public int h() {
        return this.f41145g.a();
    }

    public void i() {
        if (!this.f41147i) {
            this.f41147i = true;
            this.f41145g.f();
        }
    }

    public void a(String str, ap apVar) {
        this.f41141c.put(str, apVar);
        this.f41145g.e();
    }

    public void b(String str, String str2, ft<Long> ftVar, Object[] objArr) {
        this.f41145g.b(str, str2, ftVar, objArr);
    }

    public void b(Message message) {
        if (this.f41142d && e()) {
            this.f41146h.a(message, true);
        }
    }

    public void a(Context context) {
        am amVar;
        if (context instanceof Application) {
            this.f41144f = context;
            this.f41143e = new an.a(context, "apptimize_process_lock.pid");
            this.f41142d = true;
            this.f41149k = Executors.newSingleThreadExecutor();
            if (c()) {
                amVar = new am(this, context, this.f41140b, j(), this.f41148j);
            } else {
                amVar = null;
            }
            this.f41146h = amVar;
            aj ajVar = new aj(this, context, this.f41140b, j(), am.b());
            this.f41145g = ajVar;
            ajVar.b();
            bo.k(f41139a, "enableMultiprocessSupport");
            return;
        }
        throw new IllegalArgumentException("You must pass an Application to Apptimize.setup in order to use multiprocess support.");
    }

    public void b(fi fiVar) {
        al alVar;
        long id2 = Thread.currentThread().getId();
        if (!this.f41142d || id2 == this.f41150l.get() || (((alVar = this.f41146h) != null && alVar.a(id2)) || this.f41145g.a(id2))) {
            fiVar.run();
        } else {
            c(fiVar);
        }
    }

    public void c(final fi fiVar) {
        if (!this.f41142d) {
            return;
        }
        if (Thread.currentThread().getId() == this.f41150l.get()) {
            fiVar.run();
        } else {
            this.f41149k.submit(new Runnable() {
                public void run() {
                    ak.this.f41150l.set(Thread.currentThread().getId());
                    fiVar.run();
                }
            });
        }
    }

    public Messenger a() {
        if (this.f41142d) {
            return this.f41146h.a();
        }
        return null;
    }

    public void a(fi fiVar) {
        try {
            this.f41143e.a();
            fiVar.run();
            this.f41143e.b();
        } catch (IOException e11) {
            bo.b(f41139a, "IOException when holding process lock: ", e11);
            this.f41140b.a(bq.b.MultiprocessIOError, (Exception) e11);
        } catch (Throwable th2) {
            this.f41143e.b();
            throw th2;
        }
    }

    public void a(String str, String str2, ft<Long> ftVar, Object[] objArr) {
        this.f41145g.a(str, str2, ftVar, objArr);
    }

    public void a(String str, String str2, Object... objArr) {
        if (c()) {
            this.f41146h.a(str, str2, objArr);
        }
    }

    public void a(String str, ft<Long> ftVar) {
        if (this.f41142d && e()) {
            this.f41146h.a(str, ftVar);
        }
    }

    public void a(a aVar) {
        this.f41145g.a(aVar);
    }

    public void a(Message message) {
        if (this.f41142d && e()) {
            this.f41146h.a(message);
        }
    }

    public ap a(String str) {
        return this.f41141c.get(str);
    }
}
