package com.checkout.eventlogger.data.e;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c {
    @SerializedName("specversion")
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f44228a;
    @SerializedName("id")
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f44229b;
    @SerializedName("type")
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f44230c;
    @SerializedName("source")
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f44231d;
    @SerializedName("time")
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f44232e;
    @SerializedName("data")
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final b f44233f;
    @SerializedName("cko")
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final a f44234g;

    public c(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull b bVar, @NotNull a aVar) {
        Intrinsics.checkNotNullParameter(str, "specVersion");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "source");
        Intrinsics.checkNotNullParameter(str5, "time");
        Intrinsics.checkNotNullParameter(bVar, "data");
        Intrinsics.checkNotNullParameter(aVar, "cko");
        this.f44228a = str;
        this.f44229b = str2;
        this.f44230c = str3;
        this.f44231d = str4;
        this.f44232e = str5;
        this.f44233f = bVar;
        this.f44234g = aVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual((Object) this.f44228a, (Object) cVar.f44228a) && Intrinsics.areEqual((Object) this.f44229b, (Object) cVar.f44229b) && Intrinsics.areEqual((Object) this.f44230c, (Object) cVar.f44230c) && Intrinsics.areEqual((Object) this.f44231d, (Object) cVar.f44231d) && Intrinsics.areEqual((Object) this.f44232e, (Object) cVar.f44232e) && Intrinsics.areEqual((Object) this.f44233f, (Object) cVar.f44233f) && Intrinsics.areEqual((Object) this.f44234g, (Object) cVar.f44234g);
    }

    public int hashCode() {
        String str = this.f44228a;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f44229b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f44230c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f44231d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f44232e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        b bVar = this.f44233f;
        int hashCode6 = (hashCode5 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        a aVar = this.f44234g;
        if (aVar != null) {
            i11 = aVar.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        return "LoggingCloudEventDTO(specVersion=" + this.f44228a + ", id=" + this.f44229b + ", type=" + this.f44230c + ", source=" + this.f44231d + ", time=" + this.f44232e + ", data=" + this.f44233f + ", cko=" + this.f44234g + ")";
    }
}
