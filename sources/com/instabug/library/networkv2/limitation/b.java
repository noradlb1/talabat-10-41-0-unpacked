package com.instabug.library.networkv2.limitation;

import com.instabug.library.sessionV3.di.c;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class b implements RateLimitationSettings {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f51656d;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final RateLimitedFeature f51657a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ReadWriteProperty f51658b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ReadWriteProperty f51659c;

    static {
        Class<b> cls = b.class;
        f51656d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "_limitedUntil", "get_limitedUntil()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "_lastRequestStartedAt", "get_lastRequestStartedAt()J", 0))};
        new a((DefaultConstructorMarker) null);
    }

    public b(@NotNull RateLimitedFeature rateLimitedFeature) {
        Intrinsics.checkNotNullParameter(rateLimitedFeature, "feature");
        this.f51657a = rateLimitedFeature;
        c cVar = c.f51790a;
        this.f51658b = cVar.a(Intrinsics.stringPlus(rateLimitedFeature.getFeatureName(), "_limited_until"), 0L);
        this.f51659c = cVar.a(Intrinsics.stringPlus(rateLimitedFeature.getFeatureName(), "_request_started_at"), 0L);
    }

    private final long a() {
        return ((Number) this.f51659c.getValue(this, f51656d[1])).longValue();
    }

    private final long b() {
        return ((Number) this.f51658b.getValue(this, f51656d[0])).longValue();
    }

    public boolean isRateLimited() {
        long a11 = a();
        long b11 = b();
        long currentTimeMillis = System.currentTimeMillis();
        if (a11 == 0 || b11 == 0 || currentTimeMillis <= a11 || currentTimeMillis >= b11) {
            return false;
        }
        return true;
    }

    public void setLastRequestStartedAt(long j11) {
        a(j11);
    }

    public void setLimitedUntil(int i11) {
        b(a() + TimeUnit.SECONDS.toMillis((long) i11));
    }

    private final void a(long j11) {
        this.f51659c.setValue(this, f51656d[1], Long.valueOf(j11));
    }

    private final void b(long j11) {
        this.f51658b.setValue(this, f51656d[0], Long.valueOf(j11));
    }
}
