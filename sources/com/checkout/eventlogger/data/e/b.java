package com.checkout.eventlogger.data.e;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final a f44218j = new a();
    @SerializedName("productVersion")
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f44219a;
    @SerializedName("environment")
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f44220b;
    @SerializedName("appPackageName")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f44221c;
    @SerializedName("appPackageVersion")
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f44222d;
    @SerializedName("appInstallID")
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final String f44223e;
    @SerializedName("deviceName")
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f44224f;
    @SerializedName("platform")
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f44225g;
    @SerializedName("osVersion")
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final String f44226h;
    @SerializedName("event")
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, Object> f44227i;

    public static final class a {
    }

    public b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "event");
        this.f44219a = str;
        this.f44220b = str2;
        this.f44221c = str3;
        this.f44222d = str4;
        this.f44223e = str5;
        this.f44224f = str6;
        this.f44225g = str7;
        this.f44226h = str8;
        this.f44227i = map;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual((Object) this.f44219a, (Object) bVar.f44219a) && Intrinsics.areEqual((Object) this.f44220b, (Object) bVar.f44220b) && Intrinsics.areEqual((Object) this.f44221c, (Object) bVar.f44221c) && Intrinsics.areEqual((Object) this.f44222d, (Object) bVar.f44222d) && Intrinsics.areEqual((Object) this.f44223e, (Object) bVar.f44223e) && Intrinsics.areEqual((Object) this.f44224f, (Object) bVar.f44224f) && Intrinsics.areEqual((Object) this.f44225g, (Object) bVar.f44225g) && Intrinsics.areEqual((Object) this.f44226h, (Object) bVar.f44226h) && Intrinsics.areEqual((Object) this.f44227i, (Object) bVar.f44227i);
    }

    public int hashCode() {
        String str = this.f44219a;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f44220b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f44221c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f44222d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f44223e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f44224f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f44225g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f44226h;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Map<String, Object> map = this.f44227i;
        if (map != null) {
            i11 = map.hashCode();
        }
        return hashCode8 + i11;
    }

    @NotNull
    public String toString() {
        return "LogEventDTO(productVersion=" + this.f44219a + ", environment=" + this.f44220b + ", appPackageName=" + this.f44221c + ", appPackageVersion=" + this.f44222d + ", appInstallID=" + this.f44223e + ", deviceName=" + this.f44224f + ", platform=" + this.f44225g + ", osVersion=" + this.f44226h + ", event=" + this.f44227i + ")";
    }
}
