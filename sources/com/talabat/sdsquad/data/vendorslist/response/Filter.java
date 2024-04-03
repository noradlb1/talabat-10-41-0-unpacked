package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "", "dl", "", "ic", "id", "", "nm", "sl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDl", "()Ljava/lang/String;", "getIc", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNm", "getSl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Filter {
    @SerializedName("dl")
    @Nullable

    /* renamed from: dl  reason: collision with root package name */
    private final String f61314dl;
    @SerializedName("ic")
    @Nullable

    /* renamed from: ic  reason: collision with root package name */
    private final String f61315ic;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61316id;
    @SerializedName("nm")
    @Nullable

    /* renamed from: nm  reason: collision with root package name */
    private final String f61317nm;
    @SerializedName("sl")
    @Nullable

    /* renamed from: sl  reason: collision with root package name */
    private final String f61318sl;

    public Filter(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4) {
        this.f61314dl = str;
        this.f61315ic = str2;
        this.f61316id = num;
        this.f61317nm = str3;
        this.f61318sl = str4;
    }

    public static /* synthetic */ Filter copy$default(Filter filter, String str, String str2, Integer num, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = filter.f61314dl;
        }
        if ((i11 & 2) != 0) {
            str2 = filter.f61315ic;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            num = filter.f61316id;
        }
        Integer num2 = num;
        if ((i11 & 8) != 0) {
            str3 = filter.f61317nm;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = filter.f61318sl;
        }
        return filter.copy(str, str5, num2, str6, str4);
    }

    @Nullable
    public final String component1() {
        return this.f61314dl;
    }

    @Nullable
    public final String component2() {
        return this.f61315ic;
    }

    @Nullable
    public final Integer component3() {
        return this.f61316id;
    }

    @Nullable
    public final String component4() {
        return this.f61317nm;
    }

    @Nullable
    public final String component5() {
        return this.f61318sl;
    }

    @NotNull
    public final Filter copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4) {
        return new Filter(str, str2, num, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        return Intrinsics.areEqual((Object) this.f61314dl, (Object) filter.f61314dl) && Intrinsics.areEqual((Object) this.f61315ic, (Object) filter.f61315ic) && Intrinsics.areEqual((Object) this.f61316id, (Object) filter.f61316id) && Intrinsics.areEqual((Object) this.f61317nm, (Object) filter.f61317nm) && Intrinsics.areEqual((Object) this.f61318sl, (Object) filter.f61318sl);
    }

    @Nullable
    public final String getDl() {
        return this.f61314dl;
    }

    @Nullable
    public final String getIc() {
        return this.f61315ic;
    }

    @Nullable
    public final Integer getId() {
        return this.f61316id;
    }

    @Nullable
    public final String getNm() {
        return this.f61317nm;
    }

    @Nullable
    public final String getSl() {
        return this.f61318sl;
    }

    public int hashCode() {
        String str = this.f61314dl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f61315ic;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.f61316id;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.f61317nm;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f61318sl;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f61314dl;
        String str2 = this.f61315ic;
        Integer num = this.f61316id;
        String str3 = this.f61317nm;
        String str4 = this.f61318sl;
        return "Filter(dl=" + str + ", ic=" + str2 + ", id=" + num + ", nm=" + str3 + ", sl=" + str4 + ")";
    }
}
