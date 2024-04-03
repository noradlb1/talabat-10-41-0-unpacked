package com.apptimize;

import android.os.Handler;
import android.os.Looper;
import com.apptimize.bq;
import com.apptimize.fr;
import com.tekartik.sqflite.Constant;
import datamodels.TypesAliasesKt;
import i.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class v {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f43194a = "v";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f43195b = new HashSet() {
        {
            add(a.class.getName());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private AtomicReference<a> f43196c = new AtomicReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final au f43197d;

    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f43199b;

        /* renamed from: c  reason: collision with root package name */
        private final int f43200c;

        /* renamed from: d  reason: collision with root package name */
        private final au f43201d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicBoolean f43202e;

        public void a() {
            this.f43202e.set(true);
        }

        public void run() {
            if (this.f43199b != null) {
                bo.k(v.f43194a, "enter SetupWatchdog thread");
                int i11 = 0;
                while (!this.f43202e.get() && i11 < 3) {
                    try {
                        Thread.sleep((long) this.f43200c);
                        if (!this.f43202e.get()) {
                            i11++;
                            bo.f(v.f43194a, this.f43200c + "ms have expired and setup not completed, dumping stacks.");
                            fr.a a11 = fr.a((Set<Long>) new TreeSet() {
                                {
                                    add(Long.valueOf(a.this.getId()));
                                }
                            }, (Set<String>) v.f43195b);
                            String str = a11.f42467c + TypesAliasesKt.separator + a11.f42465a;
                            this.f43201d.a().a(bq.b.SetupTimeout, (Map<String, Object>) new HashMap<String, Object>(str) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ String f43204a;

                                {
                                    this.f43204a = r3;
                                    put(Constant.PARAM_ERROR_CODE, "AN1027");
                                    put("attr", r3);
                                }
                            });
                            for (String f11 : str.split(TypesAliasesKt.separator)) {
                                bo.f(v.f43194a, f11);
                            }
                        }
                    } catch (InterruptedException unused) {
                        bo.k(v.f43194a, "interrupted");
                    }
                }
                bo.k(v.f43194a, "exit SetupWatchdog thread");
            }
        }

        private a(int i11, au auVar) {
            this.f43199b = Looper.getMainLooper() != null ? new Handler(Looper.getMainLooper()) : null;
            this.f43202e = new AtomicBoolean(false);
            this.f43200c = i11;
            this.f43201d = auVar;
        }
    }

    public v(au auVar) {
        this.f43197d = auVar;
        bo.k(f43194a, "start SetupWatchdog");
    }

    private void e() {
        if (this.f43196c.get() != null) {
            bo.b(f43194a, "Setup watchdog has already been started... multiple setup calls?");
        }
        a aVar = new a(20000, this.f43197d);
        if (b.a(this.f43196c, (Object) null, aVar)) {
            bo.k(f43194a, "start SetupWatchdogThread");
            aVar.setName("ApptimizeSetupWatchdog");
            aVar.start();
        }
    }

    private void f() {
        a andSet = this.f43196c.getAndSet((Object) null);
        if (andSet != null) {
            bo.k(f43194a, "interrupt SetupWatchdogThread");
            andSet.a();
            andSet.interrupt();
        }
    }

    public void a() {
        e();
    }

    public void b() {
        f();
    }
}
