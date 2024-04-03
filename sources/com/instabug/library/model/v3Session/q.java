package com.instabug.library.model.v3Session;

import com.apptimize.av;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class q {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final p f51619f = new p((DefaultConstructorMarker) null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f51620a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f51621b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f51622c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f51623d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f51624e;

    public q(@Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str2, "os");
        Intrinsics.checkNotNullParameter(str3, "device");
        this.f51620a = str;
        this.f51621b = str2;
        this.f51622c = str3;
        this.f51623d = str4;
        this.f51624e = str5;
    }

    @Nullable
    public final String a() {
        return this.f51620a;
    }

    @Nullable
    public final String b() {
        return this.f51623d;
    }

    @NotNull
    public final String c() {
        return this.f51622c;
    }

    @NotNull
    public final String d() {
        return this.f51621b;
    }

    @Nullable
    public final String e() {
        return this.f51624e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Intrinsics.areEqual((Object) this.f51620a, (Object) qVar.f51620a) && Intrinsics.areEqual((Object) this.f51621b, (Object) qVar.f51621b) && Intrinsics.areEqual((Object) this.f51622c, (Object) qVar.f51622c) && Intrinsics.areEqual((Object) this.f51623d, (Object) qVar.f51623d) && Intrinsics.areEqual((Object) this.f51624e, (Object) qVar.f51624e);
    }

    public int hashCode() {
        String str = this.f51620a;
        int i11 = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f51621b.hashCode()) * 31) + this.f51622c.hashCode()) * 31;
        String str2 = this.f51623d;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f51624e;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        return "SessionAppData(appToken=" + this.f51620a + ", os=" + this.f51621b + ", device=" + this.f51622c + ", appVersion=" + this.f51623d + ", sdkVersion=" + this.f51624e + ')';
    }

    @NotNull
    public Map a(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        map.put("os", d());
        map.put("de", c());
        if (b() != null) {
            map.put(av.f41238a, b());
        }
        if (e() != null) {
            map.put("sv", e());
        }
        if (a() != null) {
            map.put("at", a());
        }
        return map;
    }
}
