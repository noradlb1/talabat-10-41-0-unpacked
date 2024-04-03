package com.instabug.apm.handler.networklog;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.di.a;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.library.Instabug;
import com.instabug.library.model.common.Session;
import java.util.List;
import java.util.Map;

@WorkerThread
public class c implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final com.instabug.apm.cache.handler.networklog.c f45381a = a.O();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final com.instabug.apm.cache.handler.networklog.a f45382b = a.u();

    /* renamed from: c  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45383c = a.f();

    /* renamed from: d  reason: collision with root package name */
    private final com.instabug.apm.handler.session.c f45384d = a.W();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final f f45385e = a.Y();

    @Nullable
    public List a(String str) {
        return this.f45381a.a(str);
    }

    public Map a(long j11) {
        return this.f45381a.a(j11);
    }

    public void a() {
        this.f45383c.d("Clearing cached APM network logs");
        this.f45381a.a();
        this.f45382b.a();
        f fVar = this.f45385e;
        if (fVar != null) {
            fVar.c();
        }
    }

    public void a(long j11, String str, boolean z11, String str2, String str3) {
        if (Instabug.isBuilt() && a.c().r()) {
            if (z11) {
                this.f45382b.a(j11, str, str2, str3);
            } else {
                this.f45381a.a(j11, str, str2, str3);
            }
        }
    }

    public void a(APMNetworkLog aPMNetworkLog) {
        if (Instabug.isBuilt() && a.c().r()) {
            if (aPMNetworkLog.executedInBackground()) {
                this.f45382b.a(aPMNetworkLog);
            } else {
                this.f45381a.a(aPMNetworkLog);
            }
        }
    }

    public boolean a(String str, String str2, String str3) {
        if (str2 == null || str2.trim().isEmpty()) {
            this.f45383c.e("Trace attribute wasn't added to \"$s\". Trace attribute key can't be null or empty string.".replace("$s", str));
            return false;
        }
        String trim = str2.trim();
        if (trim.length() > 30) {
            this.f45383c.e("Trace attribute \"$s1\" wasn't added to \"$s2\" as it was too long. Please limit attribute key names to 30 characters.".replace("$s1", str2).replace("$s2", str));
            return false;
        } else if (str3 == null) {
            return true;
        } else {
            String trim2 = str3.trim();
            if (trim2.length() == 0) {
                this.f45383c.e("Trace attribute \"$s1\" wasn't added to \"$s2\". Trace attribute value can't be empty string.".replace("$s1", trim).replace("$s2", str));
                return false;
            } else if (trim2.length() <= 60) {
                return true;
            } else {
                this.f45383c.e("Trace attribute \"$s1\" wasn't added to \"$s2\" as its value was too long. Please limit trace attribute values to 60 characters.".replace("$s1", str2).replace("$s2", str));
                return false;
            }
        }
    }

    public long b(APMNetworkLog aPMNetworkLog) {
        long j11 = -1;
        if (Instabug.isBuilt()) {
            com.instabug.apm.configuration.c c11 = a.c();
            Session b11 = this.f45384d.b();
            if (c11.r()) {
                aPMNetworkLog.setRadio(com.instabug.apm.util.connection.a.b());
                aPMNetworkLog.setCarrier(com.instabug.apm.util.connection.a.a());
                if (b11 == null) {
                    aPMNetworkLog.setExecutedInBackground(true);
                    long b12 = this.f45382b.b(aPMNetworkLog);
                    if (b12 != -1) {
                        com.instabug.apm.logger.internal.a aVar = this.f45383c;
                        aVar.a("Network request added to dangling table: " + aPMNetworkLog.getUrl());
                        this.f45382b.b(c11.Z());
                    }
                    j11 = b12;
                } else {
                    aPMNetworkLog.setExecutedInBackground(false);
                    long a11 = this.f45381a.a(b11.getId(), aPMNetworkLog);
                    if (a11 != -1) {
                        com.instabug.apm.logger.internal.a aVar2 = this.f45383c;
                        aVar2.a("Network request added to network table: " + aPMNetworkLog.getUrl());
                        f fVar = this.f45385e;
                        if (fVar != null) {
                            fVar.d(b11.getId(), 1);
                            int a12 = this.f45381a.a(b11.getId(), c11.j());
                            if (a12 > 0) {
                                com.instabug.apm.logger.internal.a aVar3 = this.f45383c;
                                aVar3.a("Network requests dropped count: " + a12);
                                this.f45385e.k(b11.getId(), a12);
                            }
                        }
                        this.f45381a.b(c11.Z());
                    }
                    j11 = a11;
                }
            }
            com.instabug.apm.logger.internal.a aVar4 = this.f45383c;
            aVar4.a("inserted network log, returning: " + j11);
        }
        return j11;
    }

    public void b() {
        a.b("network_log_stop_thread_executor").execute(new b(this));
    }

    public void c() {
        b();
    }

    public void d() {
        this.f45381a.d();
        this.f45382b.d();
    }

    public void e() {
        this.f45381a.e();
        this.f45382b.e();
    }
}
