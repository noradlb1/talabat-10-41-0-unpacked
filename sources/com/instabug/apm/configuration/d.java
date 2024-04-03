package com.instabug.apm.configuration;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.instabug.apm.di.a;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;

public class d implements c, g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f45268a = a.a0();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f45269b;

    /* renamed from: c  reason: collision with root package name */
    private e f45270c = a.g();

    @SuppressLint({"CommitPrefEdits"})
    public d() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            this.f45269b = sharedPreferences.edit();
        }
    }

    private long m0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("apm_sessions_rate_limited_until", 0);
    }

    private int n0() {
        int logLevel = SettingsManager.getInstance().getLogLevel();
        if (logLevel == 0) {
            return 0;
        }
        if (logLevel != 2) {
            return logLevel != 3 ? 2 : 5;
        }
        return 4;
    }

    private long o0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("last_apm_sessions_request_started_at", 0);
    }

    public boolean A() {
        return n() && f();
    }

    public void B() {
        e(false);
    }

    public boolean C() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("UI_TRACE_ENABLED", false);
        }
        return false;
    }

    public boolean D() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("END_SCREEN_LOADING_ENABLED", false);
        }
        return false;
    }

    public void E() {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.remove("SESSION_STORE_LIMIT").apply();
        }
    }

    public void F() {
        c(1000);
    }

    public long G() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("LAST_SYNC_TIME", 0);
        }
        return 0;
    }

    public boolean H() {
        return q0() && h0() && k0();
    }

    public int I() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("NETWORK_LOGS_ATTRIBUTES_COUNT", 5);
        }
        return 5;
    }

    public boolean J() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("FRAGMENT_SPANS_ENABLED", false);
    }

    public void K() {
        q(false);
    }

    public int L() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("SESSION_STORE_LIMIT", 300);
        }
        return 300;
    }

    public void M() {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.remove("DROPPED_SESSION_COUNT_STORE_LIMIT").apply();
        }
    }

    public int N() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("TRACES_ATTRIBUTES_COUNT", 5);
        }
        return 5;
    }

    public boolean O() {
        return l() && U() && H();
    }

    public boolean P() {
        return a() && R() && H();
    }

    public boolean Q() {
        return s() && X() && H();
    }

    public boolean R() {
        return ((Boolean) this.f45270c.b("HOT_LAUNCHES_SDK_ENABLED", Boolean.TRUE)).booleanValue();
    }

    public long S() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("COLD_LAUNCHES_STORE_LIMIT", 1000);
        }
        return 1000;
    }

    public float T() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getFloat("UI_TRACE_LARGE_DROP_THRESHOLD", 250000.0f);
        }
        return 250000.0f;
    }

    public boolean U() {
        return y() && (i0() || f());
    }

    public boolean V() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("SHOULD_DEPEND_ON_V3_SESSION", false);
        }
        return false;
    }

    public int W() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences == null) {
            return 200;
        }
        return sharedPreferences.getInt("FRAGMENT_SPANS_LIMIT_PER_REQUEST", 200);
    }

    public boolean X() {
        return ((Boolean) this.f45270c.b("COLD_LAUNCHES_SDK_ENABLED", Boolean.TRUE)).booleanValue();
    }

    public void Y() {
        a(200);
    }

    public long Z() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("NETWORK_LOGS_CACHE_LIMIT", 1000);
        }
        return 1000;
    }

    public void a(float f11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putFloat("UI_TRACE_SMALL_DROP_THRESHOLD", f11).apply();
        }
    }

    public void a(int i11) {
        SharedPreferences.Editor editor;
        if (this.f45268a != null && (editor = this.f45269b) != null) {
            editor.putInt("FRAGMENT_SPANS_LIMIT_PER_REQUEST", i11).apply();
        }
    }

    public void a(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("TRACES_STORE_LIMIT", j11).apply();
        }
    }

    public void a(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("TRACES_ENABLED", z11).apply();
        }
    }

    public boolean a() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("HOT_LAUNCHES_ENABLED", false);
        }
        return false;
    }

    public boolean a0() {
        SharedPreferences sharedPreferences = this.f45268a;
        return sharedPreferences != null && sharedPreferences.getBoolean("CRASH_DETECTION_ENABLED", false) && H();
    }

    public void b(float f11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putFloat("UI_TRACE_LARGE_DROP_THRESHOLD", f11).apply();
        }
    }

    public void b(int i11) {
        int p11 = p() + i11;
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putInt("DROPPED_SESSION_COUNT_STORE_LIMIT", p11).apply();
        }
    }

    public void b(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("TRACES_PER_REQUEST_LIMIT", j11).apply();
        }
    }

    public void b(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("CRASH_DETECTION_ENABLED", z11).apply();
        }
    }

    public boolean b() {
        return J() && p0();
    }

    public boolean b0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("TRACES_ENABLED", false);
        }
        return false;
    }

    public void c() {
        i(1000);
    }

    public void c(int i11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putInt("EXPERIMENTS_LIMIT_PER_REQUEST", i11).apply();
        }
    }

    public void c(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("HOT_LAUNCHES_PER_REQUEST_LIMIT", j11).apply();
        }
    }

    public void c(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("UI_LOADING_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public boolean c0() {
        long o02 = o0();
        long m02 = m0();
        long currentTimeMillis = System.currentTimeMillis();
        return o02 != 0 && m02 != 0 && currentTimeMillis > o02 && currentTimeMillis < m02;
    }

    public float d() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getFloat("UI_TRACE_SMALL_DROP_THRESHOLD", 16700.0f);
        }
        return 16700.0f;
    }

    public void d(int i11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putInt("SESSION_STORE_LIMIT", i11).apply();
        }
    }

    public void d(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("KEY_UI_TRACE_LIMIT_PER_REQUEST", j11).apply();
        }
    }

    public void d(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("COLD_LAUNCHES_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public boolean d0() {
        return C() && i0();
    }

    public void e() {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.remove("SESSION_STORE_LIMIT_ENABLED").apply();
        }
    }

    public void e(int i11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putInt("TRACES_ATTRIBUTES_COUNT", i11).apply();
        }
    }

    public void e(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("last_apm_sessions_request_started_at", j11).apply();
        }
    }

    public void e(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("EXPERIMENTS_ENABLED", z11).apply();
        }
    }

    public boolean e0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("EXPERIMENTS_ENABLED", false);
        }
        return false;
    }

    public void f(int i11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putInt("NETWORK_LOGS_ATTRIBUTES_COUNT", i11).apply();
        }
    }

    public void f(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("COLD_LAUNCHES_STORE_LIMIT", j11).apply();
        }
    }

    public void f(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("END_SCREEN_LOADING_ENABLED", z11).apply();
        }
    }

    public boolean f() {
        return ((Boolean) this.f45270c.b("UI_LOADING_SDK_ENABLED", Boolean.TRUE)).booleanValue();
    }

    public boolean f0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("NETWORK_GRAPHQL_ENABLED", false);
        }
        return false;
    }

    public void g() {
        M();
    }

    public void g(int i11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("LOG_LEVEL", Integer.valueOf(i11));
        }
    }

    public void g(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("NETWORK_LOGS_CACHE_LIMIT", j11).apply();
        }
    }

    public void g(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("IS_APM_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public boolean g0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("SESSION_STORE_LIMIT_ENABLED", false);
        }
        return false;
    }

    public int h() {
        e eVar = this.f45270c;
        return eVar != null ? ((Integer) eVar.b("LOG_LEVEL", Integer.valueOf(n0()))).intValue() : n0();
    }

    public void h(int i11) {
        if (this.f45268a != null) {
            long o02 = o0() + (((long) i11) * 1000);
            SharedPreferences.Editor editor = this.f45269b;
            if (editor != null) {
                editor.putLong("apm_sessions_rate_limited_until", o02).apply();
            }
        }
    }

    public void h(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("KEY_UI_TRACE_STORE_LIMIT", j11).apply();
        }
    }

    public void h(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("IS_APM_FEATURE_AVAILABLE", z11).apply();
        }
    }

    public boolean h0() {
        e eVar = this.f45270c;
        if (eVar != null) {
            return ((Boolean) eVar.b("IS_APM_SDK_ENABLED", Boolean.TRUE)).booleanValue();
        }
        return true;
    }

    public void i(int i11) {
        SharedPreferences.Editor editor;
        if (this.f45268a != null && (editor = this.f45269b) != null) {
            editor.putInt("FRAGMENT_SPANS_STORE_LIMIT", i11).apply();
        }
    }

    public void i(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("COLD_LAUNCHES_PER_REQUEST_LIMIT", j11).apply();
        }
    }

    public void i(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("UI_TRACE_ENABLED", z11).apply();
        }
    }

    public boolean i() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("NETWORK_ENABLED", false);
        }
        return false;
    }

    public boolean i0() {
        e eVar = this.f45270c;
        if (eVar != null) {
            return ((Boolean) eVar.b("UI_HANG_SDK_ENABLED", Boolean.TRUE)).booleanValue();
        }
        return true;
    }

    public long j() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("NETWORK_LOGS_REQUEST_LIMIT", 200);
        }
        return 200;
    }

    public void j(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("NETWORK_LOGS_REQUEST_LIMIT", j11).apply();
        }
    }

    public void j(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("SHOULD_DEPEND_ON_V3_SESSION", z11).apply();
        }
    }

    public long j0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("KEY_UI_TRACE_STORE_LIMIT", 1000);
        }
        return 1000;
    }

    public long k() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("TRACES_PER_REQUEST_LIMIT", 200);
        }
        return 200;
    }

    public void k(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("SYNC_INTERVAL", j11).apply();
        }
    }

    public void k(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("HOT_LAUNCHES_ENABLED", z11).apply();
        }
    }

    public boolean k0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("IS_APM_FEATURE_AVAILABLE", false);
        }
        return false;
    }

    public void l(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("HOT_LAUNCHES_STORE_LIMIT", j11).apply();
        }
    }

    public void l(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("UI_HANG_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public boolean l() {
        return C() || n();
    }

    public boolean l0() {
        SharedPreferences sharedPreferences = this.f45268a;
        return sharedPreferences != null && sharedPreferences.getBoolean("END_COLD_APP_LAUNCH_ENABLED", false) && H();
    }

    public long m() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("COLD_LAUNCHES_PER_REQUEST_LIMIT", 200);
        }
        return 200;
    }

    public void m(long j11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putLong("LAST_SYNC_TIME", j11).apply();
        }
    }

    public void m(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("UI_LOADING_ENABLED", z11).apply();
        }
    }

    public void n(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("HOT_LAUNCHES_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public boolean n() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("UI_LOADING_ENABLED", false);
        }
        return false;
    }

    public long o() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("KEY_UI_TRACE_LIMIT_PER_REQUEST", 200);
        }
        return 200;
    }

    public void o(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("NETWORK_GRPC_ENABLED", z11).apply();
        }
    }

    public int p() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("DROPPED_SESSION_COUNT_STORE_LIMIT", 0);
        }
        return 0;
    }

    public void p(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("SESSION_STORE_LIMIT_ENABLED", z11).apply();
        }
    }

    public boolean p0() {
        return ((Boolean) this.f45270c.b("FRAGMENT_SPANS_SDK_ENABLED", Boolean.TRUE)).booleanValue();
    }

    public int q() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("EXPERIMENTS_LIMIT_PER_REQUEST", 1000);
        }
        return 1000;
    }

    public void q(boolean z11) {
        SharedPreferences.Editor editor;
        if (this.f45268a != null && (editor = this.f45269b) != null) {
            editor.putBoolean("FRAGMENT_SPANS_ENABLED", z11).apply();
        }
    }

    public boolean q0() {
        Feature feature = Feature.INSTABUG;
        return InstabugCore.isFeatureAvailable(feature) && InstabugCore.getFeatureState(feature) == Feature.State.ENABLED;
    }

    public void r(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("DEBUG_MODE_ENABLED", z11).apply();
        }
    }

    public boolean r() {
        return H() && i();
    }

    public boolean r0() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("NETWORK_GRPC_ENABLED", false);
        }
        return false;
    }

    public void s(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("LAUNCHES_ENABLED", z11).apply();
        }
    }

    public boolean s() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("LAUNCHES_ENABLED", false);
        }
        return false;
    }

    public void t(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("END_COLD_APP_LAUNCH_ENABLED", z11).apply();
        }
    }

    public boolean t() {
        return r0() && r();
    }

    public long u() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("SYNC_INTERVAL", 21600);
        }
        return 21600;
    }

    public void u(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("END_HOT_APP_LAUNCH_ENABLED", z11).apply();
        }
    }

    public void v(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("NETWORK_GRAPHQL_ENABLED", z11).apply();
        }
    }

    public boolean v() {
        SharedPreferences sharedPreferences = this.f45268a;
        return sharedPreferences != null && sharedPreferences.getBoolean("DEBUG_MODE_ENABLED", false) && H();
    }

    public int w() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences == null) {
            return 1000;
        }
        return sharedPreferences.getInt("FRAGMENT_SPANS_STORE_LIMIT", 1000);
    }

    public void w(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("UI_TRACE_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public long x() {
        SharedPreferences sharedPreferences = this.f45268a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("TRACES_STORE_LIMIT", 1000);
        }
        return 1000;
    }

    public void x(boolean z11) {
        e eVar = this.f45270c;
        if (eVar != null) {
            eVar.a("FRAGMENT_SPANS_SDK_ENABLED", Boolean.valueOf(z11));
        }
    }

    public void y(boolean z11) {
        SharedPreferences.Editor editor = this.f45269b;
        if (editor != null) {
            editor.putBoolean("NETWORK_ENABLED", z11).apply();
        }
    }

    public boolean y() {
        return ((Boolean) this.f45270c.b("UI_TRACE_SDK_ENABLED", Boolean.TRUE)).booleanValue();
    }

    public boolean z() {
        SharedPreferences sharedPreferences = this.f45268a;
        return sharedPreferences != null && sharedPreferences.getBoolean("END_HOT_APP_LAUNCH_ENABLED", false) && H();
    }
}
