package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B[\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003Jr\u0010\u001f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006&"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/City;", "", "area", "", "cid", "", "id", "na", "", "res", "sl", "url", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getArea", "()Ljava/util/List;", "getCid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getNa", "()Ljava/lang/String;", "getRes", "getSl", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/sdsquad/data/vendorslist/response/City;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class City {
    @SerializedName("area")
    @Nullable
    private final List<Object> area;
    @SerializedName("cid")
    @Nullable
    private final Integer cid;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61296id;
    @SerializedName("na")
    @Nullable

    /* renamed from: na  reason: collision with root package name */
    private final String f61297na;
    @SerializedName("res")
    @Nullable
    private final List<Object> res;
    @SerializedName("sl")
    @Nullable

    /* renamed from: sl  reason: collision with root package name */
    private final String f61298sl;
    @SerializedName("url")
    @Nullable
    private final String url;

    public City(@Nullable List<? extends Object> list, @Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable List<? extends Object> list2, @Nullable String str2, @Nullable String str3) {
        this.area = list;
        this.cid = num;
        this.f61296id = num2;
        this.f61297na = str;
        this.res = list2;
        this.f61298sl = str2;
        this.url = str3;
    }

    public static /* synthetic */ City copy$default(City city, List<Object> list, Integer num, Integer num2, String str, List<Object> list2, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = city.area;
        }
        if ((i11 & 2) != 0) {
            num = city.cid;
        }
        Integer num3 = num;
        if ((i11 & 4) != 0) {
            num2 = city.f61296id;
        }
        Integer num4 = num2;
        if ((i11 & 8) != 0) {
            str = city.f61297na;
        }
        String str4 = str;
        if ((i11 & 16) != 0) {
            list2 = city.res;
        }
        List<Object> list3 = list2;
        if ((i11 & 32) != 0) {
            str2 = city.f61298sl;
        }
        String str5 = str2;
        if ((i11 & 64) != 0) {
            str3 = city.url;
        }
        return city.copy(list, num3, num4, str4, list3, str5, str3);
    }

    @Nullable
    public final List<Object> component1() {
        return this.area;
    }

    @Nullable
    public final Integer component2() {
        return this.cid;
    }

    @Nullable
    public final Integer component3() {
        return this.f61296id;
    }

    @Nullable
    public final String component4() {
        return this.f61297na;
    }

    @Nullable
    public final List<Object> component5() {
        return this.res;
    }

    @Nullable
    public final String component6() {
        return this.f61298sl;
    }

    @Nullable
    public final String component7() {
        return this.url;
    }

    @NotNull
    public final City copy(@Nullable List<? extends Object> list, @Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable List<? extends Object> list2, @Nullable String str2, @Nullable String str3) {
        return new City(list, num, num2, str, list2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }
        City city = (City) obj;
        return Intrinsics.areEqual((Object) this.area, (Object) city.area) && Intrinsics.areEqual((Object) this.cid, (Object) city.cid) && Intrinsics.areEqual((Object) this.f61296id, (Object) city.f61296id) && Intrinsics.areEqual((Object) this.f61297na, (Object) city.f61297na) && Intrinsics.areEqual((Object) this.res, (Object) city.res) && Intrinsics.areEqual((Object) this.f61298sl, (Object) city.f61298sl) && Intrinsics.areEqual((Object) this.url, (Object) city.url);
    }

    @Nullable
    public final List<Object> getArea() {
        return this.area;
    }

    @Nullable
    public final Integer getCid() {
        return this.cid;
    }

    @Nullable
    public final Integer getId() {
        return this.f61296id;
    }

    @Nullable
    public final String getNa() {
        return this.f61297na;
    }

    @Nullable
    public final List<Object> getRes() {
        return this.res;
    }

    @Nullable
    public final String getSl() {
        return this.f61298sl;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        List<Object> list = this.area;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.cid;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f61296id;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.f61297na;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        List<Object> list2 = this.res;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.f61298sl;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        List<Object> list = this.area;
        Integer num = this.cid;
        Integer num2 = this.f61296id;
        String str = this.f61297na;
        List<Object> list2 = this.res;
        String str2 = this.f61298sl;
        String str3 = this.url;
        return "City(area=" + list + ", cid=" + num + ", id=" + num2 + ", na=" + str + ", res=" + list2 + ", sl=" + str2 + ", url=" + str3 + ")";
    }
}
