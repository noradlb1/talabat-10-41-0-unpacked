package com.instabug.library.model.v3Session;

import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class w {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final v f51627g = new v((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f51628a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f51629b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f51630c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f51631d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f51632e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f51633f;

    public w(@NotNull String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Intrinsics.checkNotNullParameter(str, "storeURL");
        this.f51628a = str;
        this.f51629b = z11;
        this.f51630c = z12;
        this.f51631d = z13;
        this.f51632e = z14;
        this.f51633f = z15;
    }

    public final boolean a() {
        return this.f51632e;
    }

    public final boolean b() {
        return this.f51629b;
    }

    public final boolean c() {
        return this.f51633f;
    }

    public final boolean d() {
        return this.f51631d;
    }

    @NotNull
    public final String e() {
        return this.f51628a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.areEqual((Object) this.f51628a, (Object) wVar.f51628a) && this.f51629b == wVar.f51629b && this.f51630c == wVar.f51630c && this.f51631d == wVar.f51631d && this.f51632e == wVar.f51632e && this.f51633f == wVar.f51633f;
    }

    public final boolean f() {
        return this.f51630c;
    }

    public int hashCode() {
        int hashCode = this.f51628a.hashCode() * 31;
        boolean z11 = this.f51629b;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.f51630c;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f51631d;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.f51632e;
        if (z15) {
            z15 = true;
        }
        int i14 = (i13 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.f51633f;
        if (!z16) {
            z12 = z16;
        }
        return i14 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SessionProductionUsage(storeURL=" + this.f51628a + ", bugs=" + this.f51629b + ", surveys=" + this.f51630c + ", featureRequest=" + this.f51631d + ", apm=" + this.f51632e + ", crashes=" + this.f51633f + ')';
    }

    @NotNull
    public Map a(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        if (InstabugCore.isFeatureAvailable(Feature.PRODUCTION_USAGE_DETECTION)) {
            map.put("su", e());
            map.put("pub", Boolean.valueOf(b()));
            map.put("pufr", Boolean.valueOf(d()));
            map.put("pus", Boolean.valueOf(f()));
            map.put("pua", Boolean.valueOf(a()));
        }
        map.put("puc", Boolean.valueOf(c()));
        return map;
    }
}
