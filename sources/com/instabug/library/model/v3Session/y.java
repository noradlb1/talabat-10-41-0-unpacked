package com.instabug.library.model.v3Session;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class y {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final x f51634g = new x((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f51635a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f51636b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f51637c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f51638d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f51639e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f51640f;

    public y(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.f51635a = str;
        this.f51636b = str2;
        this.f51637c = str3;
        this.f51638d = str4;
        this.f51639e = z11;
        this.f51640f = str5;
    }

    @Nullable
    public final String a() {
        return this.f51638d;
    }

    @Nullable
    public final String b() {
        return this.f51637c;
    }

    @Nullable
    public final String c() {
        return this.f51640f;
    }

    @Nullable
    public final String d() {
        return this.f51636b;
    }

    public final boolean e() {
        return this.f51639e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.areEqual((Object) this.f51635a, (Object) yVar.f51635a) && Intrinsics.areEqual((Object) this.f51636b, (Object) yVar.f51636b) && Intrinsics.areEqual((Object) this.f51637c, (Object) yVar.f51637c) && Intrinsics.areEqual((Object) this.f51638d, (Object) yVar.f51638d) && this.f51639e == yVar.f51639e && Intrinsics.areEqual((Object) this.f51640f, (Object) yVar.f51640f);
    }

    @NotNull
    public final String f() {
        return this.f51635a;
    }

    public int hashCode() {
        int hashCode = this.f51635a.hashCode() * 31;
        String str = this.f51636b;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f51637c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f51638d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z11 = this.f51639e;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode4 + (z11 ? 1 : 0)) * 31;
        String str4 = this.f51640f;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return i12 + i11;
    }

    @NotNull
    public String toString() {
        return "SessionUserData(uuid=" + this.f51635a + ", userName=" + this.f51636b + ", userEmail=" + this.f51637c + ", customAttributes=" + this.f51638d + ", usersPageEnabled=" + this.f51639e + ", userEvents=" + this.f51640f + ')';
    }

    private final void b(Map map) {
        String str = this.f51639e ? "ca" : "cak";
        String str2 = this.f51638d;
        Intrinsics.checkNotNull(str2);
        map.put(str, str2);
    }

    private final Object c(Map map) {
        String str = this.f51639e ? "ue" : "uek";
        String str2 = this.f51640f;
        Intrinsics.checkNotNull(str2);
        return map.put(str, str2);
    }

    @NotNull
    public Map a(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        map.put("uu", f());
        String b11 = b();
        boolean z11 = true;
        String str = null;
        if (b11 != null) {
            if (b().length() == 0) {
                b11 = null;
            }
            if (b11 != null) {
                map.put("uem", b());
            }
        }
        String d11 = d();
        if (d11 != null) {
            if (d().length() != 0) {
                z11 = false;
            }
            if (z11) {
                d11 = null;
            }
            if (d11 != null) {
                map.put("un", d());
            }
        }
        String c11 = c();
        if (c11 != null) {
            if (a(c11)) {
                c11 = null;
            }
            if (c11 != null) {
                c(map);
            }
        }
        String a11 = a();
        if (a11 != null) {
            if (!a(a11)) {
                str = a11;
            }
            if (str != null) {
                b(map);
            }
        }
        return map;
    }

    private final boolean a(String str) {
        return Intrinsics.areEqual((Object) str, (Object) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) || Intrinsics.areEqual((Object) str, (Object) "{}");
    }
}
