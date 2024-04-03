package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b+\b\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00065"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "", "bic", "", "cc", "des", "dl", "ht", "", "id", "", "isc", "its", "pnm", "sic", "sl", "wnm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBic", "()Ljava/lang/String;", "getCc", "getDes", "getDl", "getHt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIsc", "getIts", "getPnm", "getSic", "getSl", "getWnm", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Collections {
    @SerializedName("bic")
    @Nullable
    private final String bic;
    @SerializedName("cc")
    @Nullable

    /* renamed from: cc  reason: collision with root package name */
    private final String f61299cc;
    @SerializedName("des")
    @Nullable
    private final String des;
    @SerializedName("dl")
    @Nullable

    /* renamed from: dl  reason: collision with root package name */
    private final String f61300dl;
    @SerializedName("ht")
    @Nullable

    /* renamed from: ht  reason: collision with root package name */
    private final Boolean f61301ht;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61302id;
    @SerializedName("isc")
    @Nullable
    private final Boolean isc;
    @SerializedName("its")
    @Nullable
    private final Boolean its;
    @SerializedName("pnm")
    @Nullable
    private final String pnm;
    @SerializedName("sic")
    @Nullable
    private final String sic;
    @SerializedName("sl")
    @Nullable

    /* renamed from: sl  reason: collision with root package name */
    private final String f61303sl;
    @SerializedName("wnm")
    @Nullable
    private final String wnm;

    public Collections(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Integer num, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        this.bic = str;
        this.f61299cc = str2;
        this.des = str3;
        this.f61300dl = str4;
        this.f61301ht = bool;
        this.f61302id = num;
        this.isc = bool2;
        this.its = bool3;
        this.pnm = str5;
        this.sic = str6;
        this.f61303sl = str7;
        this.wnm = str8;
    }

    public static /* synthetic */ Collections copy$default(Collections collections, String str, String str2, String str3, String str4, Boolean bool, Integer num, Boolean bool2, Boolean bool3, String str5, String str6, String str7, String str8, int i11, Object obj) {
        Collections collections2 = collections;
        int i12 = i11;
        return collections.copy((i12 & 1) != 0 ? collections2.bic : str, (i12 & 2) != 0 ? collections2.f61299cc : str2, (i12 & 4) != 0 ? collections2.des : str3, (i12 & 8) != 0 ? collections2.f61300dl : str4, (i12 & 16) != 0 ? collections2.f61301ht : bool, (i12 & 32) != 0 ? collections2.f61302id : num, (i12 & 64) != 0 ? collections2.isc : bool2, (i12 & 128) != 0 ? collections2.its : bool3, (i12 & 256) != 0 ? collections2.pnm : str5, (i12 & 512) != 0 ? collections2.sic : str6, (i12 & 1024) != 0 ? collections2.f61303sl : str7, (i12 & 2048) != 0 ? collections2.wnm : str8);
    }

    @Nullable
    public final String component1() {
        return this.bic;
    }

    @Nullable
    public final String component10() {
        return this.sic;
    }

    @Nullable
    public final String component11() {
        return this.f61303sl;
    }

    @Nullable
    public final String component12() {
        return this.wnm;
    }

    @Nullable
    public final String component2() {
        return this.f61299cc;
    }

    @Nullable
    public final String component3() {
        return this.des;
    }

    @Nullable
    public final String component4() {
        return this.f61300dl;
    }

    @Nullable
    public final Boolean component5() {
        return this.f61301ht;
    }

    @Nullable
    public final Integer component6() {
        return this.f61302id;
    }

    @Nullable
    public final Boolean component7() {
        return this.isc;
    }

    @Nullable
    public final Boolean component8() {
        return this.its;
    }

    @Nullable
    public final String component9() {
        return this.pnm;
    }

    @NotNull
    public final Collections copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Integer num, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        return new Collections(str, str2, str3, str4, bool, num, bool2, bool3, str5, str6, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Collections)) {
            return false;
        }
        Collections collections = (Collections) obj;
        return Intrinsics.areEqual((Object) this.bic, (Object) collections.bic) && Intrinsics.areEqual((Object) this.f61299cc, (Object) collections.f61299cc) && Intrinsics.areEqual((Object) this.des, (Object) collections.des) && Intrinsics.areEqual((Object) this.f61300dl, (Object) collections.f61300dl) && Intrinsics.areEqual((Object) this.f61301ht, (Object) collections.f61301ht) && Intrinsics.areEqual((Object) this.f61302id, (Object) collections.f61302id) && Intrinsics.areEqual((Object) this.isc, (Object) collections.isc) && Intrinsics.areEqual((Object) this.its, (Object) collections.its) && Intrinsics.areEqual((Object) this.pnm, (Object) collections.pnm) && Intrinsics.areEqual((Object) this.sic, (Object) collections.sic) && Intrinsics.areEqual((Object) this.f61303sl, (Object) collections.f61303sl) && Intrinsics.areEqual((Object) this.wnm, (Object) collections.wnm);
    }

    @Nullable
    public final String getBic() {
        return this.bic;
    }

    @Nullable
    public final String getCc() {
        return this.f61299cc;
    }

    @Nullable
    public final String getDes() {
        return this.des;
    }

    @Nullable
    public final String getDl() {
        return this.f61300dl;
    }

    @Nullable
    public final Boolean getHt() {
        return this.f61301ht;
    }

    @Nullable
    public final Integer getId() {
        return this.f61302id;
    }

    @Nullable
    public final Boolean getIsc() {
        return this.isc;
    }

    @Nullable
    public final Boolean getIts() {
        return this.its;
    }

    @Nullable
    public final String getPnm() {
        return this.pnm;
    }

    @Nullable
    public final String getSic() {
        return this.sic;
    }

    @Nullable
    public final String getSl() {
        return this.f61303sl;
    }

    @Nullable
    public final String getWnm() {
        return this.wnm;
    }

    public int hashCode() {
        String str = this.bic;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f61299cc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.des;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f61300dl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.f61301ht;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.f61302id;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool2 = this.isc;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.its;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.pnm;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sic;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f61303sl;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.wnm;
        if (str8 != null) {
            i11 = str8.hashCode();
        }
        return hashCode11 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.bic;
        String str2 = this.f61299cc;
        String str3 = this.des;
        String str4 = this.f61300dl;
        Boolean bool = this.f61301ht;
        Integer num = this.f61302id;
        Boolean bool2 = this.isc;
        Boolean bool3 = this.its;
        String str5 = this.pnm;
        String str6 = this.sic;
        String str7 = this.f61303sl;
        String str8 = this.wnm;
        return "Collections(bic=" + str + ", cc=" + str2 + ", des=" + str3 + ", dl=" + str4 + ", ht=" + bool + ", id=" + num + ", isc=" + bool2 + ", its=" + bool3 + ", pnm=" + str5 + ", sic=" + str6 + ", sl=" + str7 + ", wnm=" + str8 + ")";
    }
}
