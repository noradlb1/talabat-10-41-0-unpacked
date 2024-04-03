package com.instabug.apm;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.attributes.listeners.OnNetworkTraceListener;
import com.instabug.apm.configuration.c;
import com.instabug.apm.configuration.g;
import com.instabug.apm.fragment.u;
import com.instabug.apm.handler.uitrace.e;
import com.instabug.apm.logger.internal.a;
import com.instabug.apm.model.ExecutionTrace;
import com.instabug.apm.model.LogLevel;
import com.instabug.library.util.threading.PoolProvider;

public class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f45358a;

    public h(a aVar) {
        this.f45358a = aVar;
    }

    private void a(boolean z11) {
        u M = com.instabug.apm.di.a.M();
        if (z11) {
            M.c();
        } else {
            M.b();
        }
    }

    private void k() {
        e j02 = com.instabug.apm.di.a.j0();
        c c11 = com.instabug.apm.di.a.c();
        if (j02 != null && c11 != null) {
            if (!c11.U()) {
                j02.f();
                j02.a();
            } else if (!c11.i0()) {
                j02.d();
                j02.c();
            } else if (!c11.f()) {
                j02.b();
                j02.e();
            }
        }
    }

    public void a() {
        g h11 = com.instabug.apm.di.a.h();
        if (h11 != null) {
            h11.g();
        }
    }

    public void a(int i11) {
        c c11 = com.instabug.apm.di.a.c();
        if (i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) {
            c11.g(i11);
        } else {
            this.f45358a.i(com.instabug.apm.constants.a.f45272a.replace("$s1", String.valueOf(i11)).replace("$s2", LogLevel.a.a(c11.h())));
        }
    }

    public void a(OnNetworkTraceListener onNetworkTraceListener) {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if (c11.k0()) {
            if (!c11.H()) {
                aVar = this.f45358a;
                str = "addOnNetworkTraceListener wasn't called. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
                aVar.e(str);
            } else if (c11.i()) {
                com.instabug.apm.di.a.T().a(onNetworkTraceListener);
                return;
            }
        }
        aVar = this.f45358a;
        str = "addOnNetworkTraceListener wasn't called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        aVar.e(str);
    }

    public void a(Class cls, com.instabug.apm.model.e eVar) {
        e j02 = com.instabug.apm.di.a.j0();
        if (j02 != null) {
            j02.a(cls, eVar);
        }
    }

    public void a(@NonNull String str) {
        com.instabug.apm.di.a.b("app_launch_thread_executor").execute(new d(this, com.instabug.apm.di.a.n(), str));
    }

    @Nullable
    public ExecutionTrace b(@NonNull String str) {
        if (str == null || str.trim().isEmpty()) {
            this.f45358a.e("Execution trace wasn't created. Execution trace name can't be empty or null.");
            return null;
        }
        String trim = str.trim();
        if (trim.length() > 150) {
            trim = trim.substring(0, 150);
            this.f45358a.i("Execution trace \"$s\" was truncated as it was too long. Please limit trace names to 150 characters.".replace("$s", str));
        }
        return new ExecutionTrace(trim);
    }

    public void b() {
        com.instabug.apm.di.a.b("app_launch_thread_executor").execute(new e(this, com.instabug.apm.di.a.n()));
    }

    @RequiresApi(api = 16)
    public void b(Looper looper) {
        PoolProvider.postMainThreadTask(new g(this, looper));
    }

    public void b(OnNetworkTraceListener onNetworkTraceListener) {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if (c11.k0()) {
            if (!c11.H()) {
                aVar = this.f45358a;
                str = "removeOnNetworkTraceListener wasn't called. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
                aVar.e(str);
            } else if (c11.i()) {
                com.instabug.apm.di.a.T().b(onNetworkTraceListener);
                return;
            }
        }
        aVar = this.f45358a;
        str = "removeOnNetworkTraceListener wasn't called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        aVar.e(str);
    }

    public void b(boolean z11) {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if (!c11.H() && z11) {
            aVar = this.f45358a;
            str = "Auto UI Trace wasn't enabled. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        } else if (c11.l() || !z11) {
            c11.w(z11);
            if (!z11) {
                k();
                return;
            }
            return;
        } else {
            aVar = this.f45358a;
            str = "Auto UI Trace wasn't enabled as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        }
        aVar.e(str);
    }

    public void c() {
        d();
        b();
        h();
        i();
        e();
        a();
    }

    @RequiresApi(api = 16)
    public void c(@NonNull String str, @Nullable Looper looper) {
        PoolProvider.postMainThreadTask(new f(this, str, looper));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r5 != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r5 = "disabled";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (r5 != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(boolean r5) {
        /*
            r4 = this;
            com.instabug.apm.configuration.c r0 = com.instabug.apm.di.a.c()
            boolean r1 = r0.h0()
            java.lang.String r2 = "Cold"
            java.lang.String r3 = "\"$s1\""
            if (r1 != 0) goto L_0x0019
            com.instabug.apm.logger.internal.a r0 = r4.f45358a
            java.lang.String r1 = "\"$s1\" App launch wasn't \"$s2\". Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm"
            java.lang.String r1 = r1.replace(r3, r2)
            if (r5 == 0) goto L_0x003e
            goto L_0x003b
        L_0x0019:
            boolean r1 = r0.s()
            if (r1 == 0) goto L_0x0031
            boolean r1 = r0.k0()
            if (r1 != 0) goto L_0x0026
            goto L_0x0031
        L_0x0026:
            r0.d((boolean) r5)
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = "cold"
            r4.a((java.lang.String) r5)
            goto L_0x0049
        L_0x0031:
            com.instabug.apm.logger.internal.a r0 = r4.f45358a
            java.lang.String r1 = "\"$s1\" App launch wasn't \"$s2\" as the feature seems to be disabled for your Instabug company account. Please contact support for more information."
            java.lang.String r1 = r1.replace(r3, r2)
            if (r5 == 0) goto L_0x003e
        L_0x003b:
            java.lang.String r5 = "enabled"
            goto L_0x0040
        L_0x003e:
            java.lang.String r5 = "disabled"
        L_0x0040:
            java.lang.String r2 = "\"$s2\""
            java.lang.String r5 = r1.replace(r2, r5)
            r0.e(r5)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.h.c(boolean):void");
    }

    public void d() {
        com.instabug.apm.di.a.b("execution_traces_thread_executor").execute(new c(this, com.instabug.apm.di.a.A()));
    }

    public void d(boolean z11) {
        c c11 = com.instabug.apm.di.a.c();
        if (c11.k0() || !z11) {
            c11.g(z11);
            com.instabug.apm.eventbus.a.f45302a.post(Boolean.valueOf(z11));
            if (!z11) {
                c();
                com.instabug.apm.di.a.m0();
                return;
            }
            return;
        }
        this.f45358a.e("APM wasn't enabled as it seems to be disabled for your Instabug company account. Please, contact support to switch it on for you.");
    }

    public void e() {
        com.instabug.apm.di.a.L().a();
    }

    public void e(boolean z11) {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if ((!c11.k0() || !c11.J()) && z11) {
            aVar = this.f45358a;
            str = "setFragmentSpansEnabled wasn’t called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        } else if (c11.h0() || !z11) {
            c11.x(z11);
            a(z11);
            return;
        } else {
            aVar = this.f45358a;
            str = "setFragmentSpansEnabled wasn't called. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        }
        aVar.e(str);
    }

    public void f() {
        com.instabug.apm.handler.networklog.a P = com.instabug.apm.di.a.P();
        if (P != null) {
            com.instabug.apm.di.a.b("network_log_thread_executor").execute(new b(this, P));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r5 != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r5 = "disabled";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (r5 != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(boolean r5) {
        /*
            r4 = this;
            com.instabug.apm.configuration.c r0 = com.instabug.apm.di.a.c()
            boolean r1 = r0.h0()
            java.lang.String r2 = "Hot"
            java.lang.String r3 = "\"$s1\""
            if (r1 != 0) goto L_0x0019
            com.instabug.apm.logger.internal.a r0 = r4.f45358a
            java.lang.String r1 = "\"$s1\" App launch wasn't \"$s2\". Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm"
            java.lang.String r1 = r1.replace(r3, r2)
            if (r5 == 0) goto L_0x003e
            goto L_0x003b
        L_0x0019:
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x0031
            boolean r1 = r0.k0()
            if (r1 != 0) goto L_0x0026
            goto L_0x0031
        L_0x0026:
            r0.n(r5)
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = "hot"
            r4.a((java.lang.String) r5)
            goto L_0x0049
        L_0x0031:
            com.instabug.apm.logger.internal.a r0 = r4.f45358a
            java.lang.String r1 = "\"$s1\" App launch wasn't \"$s2\" as the feature seems to be disabled for your Instabug company account. Please contact support for more information."
            java.lang.String r1 = r1.replace(r3, r2)
            if (r5 == 0) goto L_0x003e
        L_0x003b:
            java.lang.String r5 = "enabled"
            goto L_0x0040
        L_0x003e:
            java.lang.String r5 = "disabled"
        L_0x0040:
            java.lang.String r2 = "\"$s2\""
            java.lang.String r5 = r1.replace(r2, r5)
            r0.e(r5)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.h.f(boolean):void");
    }

    public void g() {
        com.instabug.apm.handler.networklog.a P = com.instabug.apm.di.a.P();
        if (P != null) {
            com.instabug.apm.di.a.b("network_log_thread_executor").execute(new lb.e(P));
        }
    }

    public void g(boolean z11) {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if (c11 == null) {
            this.f45358a.e("Could not enable UI loading. apm configuration provider is null");
            return;
        }
        if (!c11.H() && z11) {
            aVar = this.f45358a;
            str = "Screen Loading wasn't enabled. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        } else if (!c11.n() && z11) {
            aVar = this.f45358a;
            str = "Screen Loading wasn't enabled as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        } else if (c11.y() || !z11) {
            c11.c(z11);
            if (!z11) {
                k();
                return;
            }
            return;
        } else {
            aVar = this.f45358a;
            str = "Screen Loading wasn’t enabled as Auto UI Traces seems to be disabled. Please make sure to enable Auto UI Traces first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-auto-ui-traces";
        }
        aVar.e(str);
    }

    public void h() {
        com.instabug.apm.di.a.b("network_log_thread_executor").execute(new a(this, com.instabug.apm.di.a.P()));
    }

    public void h(boolean z11) {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if (c11 == null) {
            this.f45358a.e("Could not enable UI Hangs. apm configuration provider is null");
            return;
        }
        if (!c11.H() && z11) {
            aVar = this.f45358a;
            str = "Auto UI Hangs wasn't enabled. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        } else if (!c11.C() && z11) {
            aVar = this.f45358a;
            str = "Auto UI Hangs wasn't enabled as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        } else if (c11.y() || !z11) {
            c11.l(z11);
            if (!z11) {
                k();
                return;
            }
            return;
        } else {
            aVar = this.f45358a;
            str = "Auto UI Hangs wasn’t enabled as Auto UI Traces seems to be disabled. Please make sure to enable Auto UI Traces first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-auto-ui-traces";
        }
        aVar.e(str);
    }

    public void i() {
        e j02 = com.instabug.apm.di.a.j0();
        if (j02 != null) {
            j02.a();
        }
    }

    public void j() {
        a aVar;
        String str;
        c c11 = com.instabug.apm.di.a.c();
        if (!c11.h0()) {
            aVar = this.f45358a;
            str = "endAppLaunch() wasn't called. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        } else if (!c11.k0()) {
            aVar = this.f45358a;
            str = "endAppLaunch() wasn't called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        } else {
            com.instabug.apm.lifecycle.c l11 = com.instabug.apm.di.a.l();
            if (l11 != null) {
                l11.a();
                return;
            }
            return;
        }
        aVar.e(str);
    }
}
