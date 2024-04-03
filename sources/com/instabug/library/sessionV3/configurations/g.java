package com.instabug.library.sessionV3.configurations;

import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.sessionV3.di.c;
import com.instabug.library.settings.SettingsManager;
import kotlin.TuplesKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class g implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final g f51773a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f51774b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final ReadWriteProperty f51775c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final ReadWriteProperty f51776d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final ReadWriteProperty f51777e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final ReadWriteProperty f51778f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final ReadWriteProperty f51779g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final ReadWriteProperty f51780h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final ReadWriteProperty f51781i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final ReadWriteProperty f51782j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final ReadWriteProperty f51783k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final ReadWriteProperty f51784l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private static final ReadWriteProperty f51785m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private static final ReadWriteProperty f51786n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private static final ReadWriteProperty f51787o;

    static {
        Class<g> cls = g.class;
        f51774b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isDebugModeEnabled", "isDebugModeEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sessionsStoreLimit", "getSessionsStoreLimit()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "droppedSessionCount", "getDroppedSessionCount()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "syncInterval", "getSyncInterval()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sessionRequestLimit", "getSessionRequestLimit()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "lastSyncTime", "getLastSyncTime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isExperimentsEnabled", "isExperimentsEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "experimentsStoreLimit", "getExperimentsStoreLimit()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "periodicDurationCaptureEnabled", "getPeriodicDurationCaptureEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "periodicDurationCaptureInterval", "getPeriodicDurationCaptureInterval()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "nonFatalStoreLimit", "getNonFatalStoreLimit()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "anrStoreLimit", "getAnrStoreLimit()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "fatalHangStoreLimit", "getFatalHangStoreLimit()I", 0))};
        c cVar = c.f51790a;
        Boolean bool = Boolean.FALSE;
        f51775c = cVar.a("v3_debug_mode_enabled", bool);
        f51776d = cVar.a(TuplesKt.to("v3_sessions_store_limit", 100));
        f51777e = cVar.a(TuplesKt.to("v3_dropped_sessions_count", 0));
        f51778f = cVar.a("v3_sync_interval", 360L);
        f51779g = cVar.a("v3_sessions_request_limit", 10);
        f51780h = cVar.a("v3_last_sync_time", -1L);
        f51781i = cVar.a("v3_experiments_enabled", bool);
        f51782j = cVar.a("v3_experiments_store_limit", 100);
        f51783k = cVar.a("v3_periodic_duration_capture_enabled", Boolean.TRUE);
        f51784l = cVar.a("v3_periodic_duration_capture_interval", Long.valueOf(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        f51785m = cVar.a("v3_non_fatal_store_limit", 100);
        f51786n = cVar.a("v3_anr_store_limit", 100);
        f51787o = cVar.a("v3_fatal-hang_store_limit", 100);
    }

    private g() {
    }

    public void a(int i11) {
        f51776d.setValue(this, f51774b[1], Integer.valueOf(i11));
    }

    public void b(boolean z11) {
        f51775c.setValue(this, f51774b[0], Boolean.valueOf(z11));
    }

    public boolean c() {
        return l() && c.f51790a.o().o();
    }

    public long d() {
        return ((Number) f51778f.getValue(this, f51774b[3])).longValue();
    }

    public void e(int i11) {
        b.a(this, i11);
    }

    public boolean f() {
        return ((Boolean) f51783k.getValue(this, f51774b[8])).booleanValue();
    }

    public boolean g() {
        return ((Boolean) f51781i.getValue(this, f51774b[6])).booleanValue();
    }

    public int getAnrStoreLimit() {
        return ((Number) f51786n.getValue(this, f51774b[11])).intValue();
    }

    public int getFatalHangStoreLimit() {
        return ((Number) f51787o.getValue(this, f51774b[12])).intValue();
    }

    public int getNonFatalStoreLimit() {
        return ((Number) f51785m.getValue(this, f51774b[10])).intValue();
    }

    public long h() {
        return ((Number) f51780h.getValue(this, f51774b[5])).longValue();
    }

    public boolean i() {
        Feature.State featureState = SettingsManager.getInstance().getFeatureState(Feature.V3_SESSION, false);
        Feature.State state = Feature.State.ENABLED;
        if (featureState == state && e0.c().b((Object) Feature.INSTABUG) == state) {
            return true;
        }
        return false;
    }

    public int j() {
        return ((Number) f51782j.getValue(this, f51774b[7])).intValue();
    }

    public int k() {
        return ((Number) f51776d.getValue(this, f51774b[1])).intValue();
    }

    public boolean l() {
        return ((Boolean) f51775c.getValue(this, f51774b[0])).booleanValue();
    }

    public void setAnrStoreLimit(int i11) {
        f51786n.setValue(this, f51774b[11], Integer.valueOf(i11));
    }

    public void setFatalHangStoreLimit(int i11) {
        f51787o.setValue(this, f51774b[12], Integer.valueOf(i11));
    }

    public void setNonFatalStoreLimit(int i11) {
        f51785m.setValue(this, f51774b[10], Integer.valueOf(i11));
    }

    public int a() {
        return ((Number) f51777e.getValue(this, f51774b[2])).intValue();
    }

    public void b(int i11) {
        f51779g.setValue(this, f51774b[4], Integer.valueOf(i11));
    }

    public void c(int i11) {
        f51777e.setValue(this, f51774b[2], Integer.valueOf(i11));
    }

    public void d(int i11) {
        f51782j.setValue(this, f51774b[7], Integer.valueOf(i11));
    }

    public int e() {
        return ((Number) f51779g.getValue(this, f51774b[4])).intValue();
    }

    public void a(long j11) {
        f51778f.setValue(this, f51774b[3], Long.valueOf(j11));
    }

    public long b() {
        return ((Number) f51784l.getValue(this, f51774b[9])).longValue();
    }

    public void c(long j11) {
        f51780h.setValue(this, f51774b[5], Long.valueOf(j11));
    }

    public void a(boolean z11) {
        f51783k.setValue(this, f51774b[8], Boolean.valueOf(z11));
    }

    public void b(long j11) {
        f51784l.setValue(this, f51774b[9], Long.valueOf(j11));
    }

    public void c(boolean z11) {
        f51781i.setValue(this, f51774b[6], Boolean.valueOf(z11));
    }
}
