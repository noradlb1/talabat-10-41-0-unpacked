package com.instabug.apm.configuration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.apm.h;
import com.instabug.apm.handler.uitrace.e;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.model.State;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f45266a;

    /* renamed from: b  reason: collision with root package name */
    private a f45267b = com.instabug.apm.di.a.f();

    public b(c cVar) {
        this.f45266a = cVar;
    }

    private void a() {
        g h11 = com.instabug.apm.di.a.h();
        if (h11 != null) {
            h11.g();
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("launches");
        if (optJSONObject != null) {
            boolean optBoolean = optJSONObject.optBoolean("enabled", false);
            this.f45266a.s(optBoolean);
            e(optJSONObject);
            if (!optBoolean) {
                k();
                b("cold");
            } else {
                this.f45266a.i(optJSONObject.optLong("limit_per_request", 200));
                this.f45266a.f(optJSONObject.optLong("store_limit", 1000));
            }
            this.f45266a.t(optJSONObject.optBoolean("end_api_enabled", false));
            return;
        }
        this.f45267b.g("Can't parse app launches configurations, object is null.");
        k();
        p();
        b();
    }

    private void b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("traces");
        if (optJSONObject != null) {
            boolean optBoolean = optJSONObject.optBoolean("enabled", false);
            this.f45266a.a(optBoolean);
            if (optBoolean) {
                this.f45266a.b(optJSONObject.optLong("limit_per_request", 200));
                this.f45266a.a(optJSONObject.optLong("store_limit", 1000));
                this.f45266a.e(optJSONObject.optInt("store_attributes_limit", 5));
                return;
            }
        } else {
            this.f45267b.g("Can't parse execution traces configurations, object is null.");
        }
        m();
        c();
    }

    private void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(State.KEY_EXPERIMENTS);
        boolean z11 = false;
        if (optJSONObject != null) {
            z11 = optJSONObject.optBoolean("enabled", false);
            this.f45266a.e(z11);
            if (z11) {
                this.f45266a.c(optJSONObject.optInt("limit_per_request", 1000));
            } else {
                this.f45266a.F();
            }
        } else {
            n();
        }
        if (!z11) {
            d();
        }
    }

    private void d() {
        com.instabug.apm.handler.experiment.a D = com.instabug.apm.di.a.D();
        if (D != null) {
            D.a();
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("fragments");
        boolean z11 = false;
        if (optJSONObject != null) {
            z11 = optJSONObject.optBoolean("enabled", false);
            this.f45266a.q(z11);
            this.f45266a.i(optJSONObject.optInt("store_limit", 1000));
            this.f45266a.a(optJSONObject.optInt("limit_per_request", 200));
        } else {
            o();
        }
        if (!z11) {
            com.instabug.apm.di.a.M().b();
        }
    }

    private void e() {
        h e11 = com.instabug.apm.di.a.e();
        if (e11 != null) {
            e11.f();
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("hot");
        if (optJSONObject != null) {
            boolean optBoolean = optJSONObject.optBoolean("enabled", false);
            this.f45266a.k(optBoolean);
            if (!optBoolean) {
                p();
                b("hot");
            } else {
                this.f45266a.c(optJSONObject.optLong("limit_per_request", 200));
                this.f45266a.l(optJSONObject.optLong("store_limit", 1000));
            }
            this.f45266a.u(optJSONObject.optBoolean("end_api_enabled", false));
            return;
        }
        b("hot");
    }

    private void f() {
        h e11 = com.instabug.apm.di.a.e();
        if (e11 != null) {
            e11.g();
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(SDKCoreEvent.Network.TYPE_NETWORK);
        if (optJSONObject != null) {
            boolean optBoolean = optJSONObject.optBoolean("enabled", false);
            this.f45266a.y(optBoolean);
            if (optBoolean) {
                this.f45266a.j(optJSONObject.optLong("limit_per_request", 200));
                this.f45266a.g(optJSONObject.optLong("store_limit", 1000));
                this.f45266a.f(optJSONObject.optInt("store_attributes_limit", 5));
                boolean optBoolean2 = optJSONObject.optBoolean("graphql_enabled", false);
                this.f45266a.v(optBoolean2);
                if (!optBoolean2) {
                    e();
                }
                boolean optBoolean3 = optJSONObject.optBoolean("grpc_enabled", false);
                this.f45266a.o(optBoolean3);
                if (!optBoolean3) {
                    f();
                    return;
                }
                return;
            }
        } else {
            this.f45267b.g("Can't parse network logs configurations, object is null.");
        }
        q();
        g();
    }

    private void g() {
        com.instabug.apm.di.a.e().h();
    }

    private boolean g(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("enabled", false);
            boolean optBoolean2 = jSONObject.optBoolean("end_api_enabled", false);
            c cVar = this.f45266a;
            if (cVar != null) {
                cVar.m(optBoolean);
                this.f45266a.f(optBoolean2);
                return optBoolean;
            }
        }
        return false;
    }

    private void h() {
        e j02 = com.instabug.apm.di.a.j0();
        if (j02 != null) {
            j02.c();
        }
    }

    private void i() {
        e j02 = com.instabug.apm.di.a.j0();
        if (j02 != null) {
            j02.e();
        }
    }

    private void j() {
        h e11 = com.instabug.apm.di.a.e();
        if (e11 != null) {
            e11.i();
        }
    }

    private void k() {
        this.f45266a.s(false);
        this.f45266a.i(200);
        this.f45266a.f(1000);
    }

    private void l() {
        this.f45266a.h(false);
        this.f45266a.b(false);
        this.f45266a.r(false);
        this.f45266a.k(21600);
        this.f45266a.e();
        this.f45266a.E();
        q();
        g();
        t();
        j();
        m();
        c();
        k();
        p();
        b();
        n();
        o();
        d();
        a();
        com.instabug.apm.di.a.M().b();
    }

    private void n() {
        this.f45266a.B();
        this.f45266a.F();
    }

    private void o() {
        this.f45266a.K();
        this.f45266a.c();
        this.f45266a.Y();
    }

    private void p() {
        this.f45266a.k(false);
        this.f45266a.c(200);
        this.f45266a.l(1000);
    }

    private void q() {
        this.f45266a.y(false);
        this.f45266a.j(200);
        this.f45266a.g(1000);
        this.f45266a.f(5);
        this.f45266a.v(false);
        this.f45266a.o(false);
    }

    private void r() {
        c cVar = this.f45266a;
        if (cVar != null) {
            cVar.i(false);
        }
    }

    private void s() {
        c cVar = this.f45266a;
        if (cVar != null) {
            cVar.m(false);
            this.f45266a.f(false);
        }
    }

    private void t() {
        r();
        s();
        this.f45266a.d(200);
        this.f45266a.h(1000);
        this.f45266a.b(250000.0f);
        this.f45266a.a(16700.0f);
        u();
    }

    private void u() {
        e j02 = com.instabug.apm.di.a.j0();
        if (j02 != null) {
            j02.f();
        }
    }

    public boolean a(@Nullable String str) {
        boolean z11 = false;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("apm");
                if (optJSONObject != null) {
                    this.f45266a.h(optJSONObject.optBoolean("enabled", false));
                    this.f45266a.b(optJSONObject.optBoolean("crash_detection_enabled", false));
                    this.f45266a.r(optJSONObject.optBoolean("debug_mode_enabled", false));
                    this.f45266a.k(optJSONObject.optLong("sync_interval", 21600));
                    this.f45266a.p(optJSONObject.optBoolean("session_store_limit_enabled", false));
                    this.f45266a.d(optJSONObject.optInt("session_store_limit", 300));
                    a(optJSONObject);
                    b(optJSONObject);
                    f(optJSONObject);
                    i(optJSONObject);
                    c(optJSONObject);
                    d(optJSONObject);
                } else {
                    this.f45267b.g("Can't parse APM configurations, object is null.");
                }
                z11 = true;
            } catch (JSONException e11) {
                this.f45267b.a(e11.getMessage() != null ? e11.getMessage() : "", e11);
            }
        }
        if (this.f45266a.k0()) {
            a aVar = this.f45267b;
            aVar.g("APM feature configs: \nEnabled: " + this.f45266a.k0() + "\nTraces Enabled: " + this.f45266a.b0() + "\nCold App Launches Enabled: " + this.f45266a.s() + "\nHot App Launches Enabled: " + this.f45266a.a() + "\nNetwork Logs Enabled: " + this.f45266a.i() + "\nUI Traces Enabled: " + this.f45266a.C() + "\nFragment spans Enabled: " + this.f45266a.J());
        } else {
            this.f45267b.g("APM feature configs: \nEnabled: false");
            l();
        }
        return z11;
    }

    public void b() {
        com.instabug.apm.di.a.e().b();
    }

    public void b(@NonNull String str) {
        com.instabug.apm.di.a.e().a(str);
    }

    public void c() {
        com.instabug.apm.di.a.e().d();
    }

    @VisibleForTesting
    public void i(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("ui") : null;
        if (optJSONObject != null) {
            boolean z11 = false;
            boolean optBoolean = optJSONObject.optBoolean("enabled", false);
            boolean g11 = g(optJSONObject.optJSONObject("screen_loading"));
            this.f45266a.i(optBoolean);
            if (optBoolean || g11) {
                z11 = true;
            }
            if (z11) {
                this.f45266a.a((float) optJSONObject.optDouble("small_drop_duration_mus", 16700.0d));
                this.f45266a.b((float) optJSONObject.optDouble("large_drop_duration_mus", 250000.0d));
                this.f45266a.d(optJSONObject.optLong("limit_per_request", 200));
                this.f45266a.h(optJSONObject.optLong("store_limit", 1000));
                if (!optBoolean) {
                    h();
                }
                if (!g11) {
                    i();
                    return;
                }
                return;
            }
        } else {
            this.f45267b.g("Can't parse ui traces configurations, object is null.");
        }
        t();
        j();
    }

    public void m() {
        this.f45266a.a(false);
        this.f45266a.b(200);
        this.f45266a.a(1000);
        this.f45266a.e(5);
    }
}
