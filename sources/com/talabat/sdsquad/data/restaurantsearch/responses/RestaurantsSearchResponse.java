package com.talabat.sdsquad.data.restaurantsearch.responses;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b/\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¾\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0018R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b*\u0010\u0018R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001b¨\u0006A"}, d2 = {"Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "", "bid", "", "bnmAr", "", "bnmEn", "bstat", "ismtchbr", "", "mitmcnt", "mitms", "", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/Mitm;", "rid", "rnmAr", "rnmEn", "rrtng", "", "rstat", "thumbAr", "thumbEn", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBnmAr", "()Ljava/lang/String;", "getBnmEn", "getBstat", "getIsmtchbr", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMitmcnt", "getMitms", "()Ljava/util/List;", "getRid", "getRnmAr", "getRnmEn", "getRrtng", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRstat", "getThumbAr", "getThumbEn", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantsSearchResponse {
    @SerializedName("bid")
    @Nullable
    private final Integer bid;
    @SerializedName("bnm_ar")
    @Nullable
    private final String bnmAr;
    @SerializedName("bnm_en")
    @Nullable
    private final String bnmEn;
    @SerializedName("bstat")
    @Nullable
    private final Integer bstat;
    @SerializedName("ismtchbr")
    @Nullable
    private final Boolean ismtchbr;
    @SerializedName("mitmcnt")
    @Nullable
    private final Integer mitmcnt;
    @SerializedName("mitms")
    @Nullable
    private final List<Mitm> mitms;
    @SerializedName("rid")
    @Nullable
    private final Integer rid;
    @SerializedName("rnm_ar")
    @Nullable
    private final String rnmAr;
    @SerializedName("rnm_en")
    @Nullable
    private final String rnmEn;
    @SerializedName("rrtng")
    @Nullable
    private final Double rrtng;
    @SerializedName("rstat")
    @Nullable
    private final Integer rstat;
    @SerializedName("thumb_ar")
    @Nullable
    private final String thumbAr;
    @SerializedName("thumb_en")
    @Nullable
    private final String thumbEn;

    public RestaurantsSearchResponse(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Integer num3, @Nullable List<Mitm> list, @Nullable Integer num4, @Nullable String str3, @Nullable String str4, @Nullable Double d11, @Nullable Integer num5, @Nullable String str5, @Nullable String str6) {
        this.bid = num;
        this.bnmAr = str;
        this.bnmEn = str2;
        this.bstat = num2;
        this.ismtchbr = bool;
        this.mitmcnt = num3;
        this.mitms = list;
        this.rid = num4;
        this.rnmAr = str3;
        this.rnmEn = str4;
        this.rrtng = d11;
        this.rstat = num5;
        this.thumbAr = str5;
        this.thumbEn = str6;
    }

    public static /* synthetic */ RestaurantsSearchResponse copy$default(RestaurantsSearchResponse restaurantsSearchResponse, Integer num, String str, String str2, Integer num2, Boolean bool, Integer num3, List list, Integer num4, String str3, String str4, Double d11, Integer num5, String str5, String str6, int i11, Object obj) {
        RestaurantsSearchResponse restaurantsSearchResponse2 = restaurantsSearchResponse;
        int i12 = i11;
        return restaurantsSearchResponse.copy((i12 & 1) != 0 ? restaurantsSearchResponse2.bid : num, (i12 & 2) != 0 ? restaurantsSearchResponse2.bnmAr : str, (i12 & 4) != 0 ? restaurantsSearchResponse2.bnmEn : str2, (i12 & 8) != 0 ? restaurantsSearchResponse2.bstat : num2, (i12 & 16) != 0 ? restaurantsSearchResponse2.ismtchbr : bool, (i12 & 32) != 0 ? restaurantsSearchResponse2.mitmcnt : num3, (i12 & 64) != 0 ? restaurantsSearchResponse2.mitms : list, (i12 & 128) != 0 ? restaurantsSearchResponse2.rid : num4, (i12 & 256) != 0 ? restaurantsSearchResponse2.rnmAr : str3, (i12 & 512) != 0 ? restaurantsSearchResponse2.rnmEn : str4, (i12 & 1024) != 0 ? restaurantsSearchResponse2.rrtng : d11, (i12 & 2048) != 0 ? restaurantsSearchResponse2.rstat : num5, (i12 & 4096) != 0 ? restaurantsSearchResponse2.thumbAr : str5, (i12 & 8192) != 0 ? restaurantsSearchResponse2.thumbEn : str6);
    }

    @Nullable
    public final Integer component1() {
        return this.bid;
    }

    @Nullable
    public final String component10() {
        return this.rnmEn;
    }

    @Nullable
    public final Double component11() {
        return this.rrtng;
    }

    @Nullable
    public final Integer component12() {
        return this.rstat;
    }

    @Nullable
    public final String component13() {
        return this.thumbAr;
    }

    @Nullable
    public final String component14() {
        return this.thumbEn;
    }

    @Nullable
    public final String component2() {
        return this.bnmAr;
    }

    @Nullable
    public final String component3() {
        return this.bnmEn;
    }

    @Nullable
    public final Integer component4() {
        return this.bstat;
    }

    @Nullable
    public final Boolean component5() {
        return this.ismtchbr;
    }

    @Nullable
    public final Integer component6() {
        return this.mitmcnt;
    }

    @Nullable
    public final List<Mitm> component7() {
        return this.mitms;
    }

    @Nullable
    public final Integer component8() {
        return this.rid;
    }

    @Nullable
    public final String component9() {
        return this.rnmAr;
    }

    @NotNull
    public final RestaurantsSearchResponse copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Integer num3, @Nullable List<Mitm> list, @Nullable Integer num4, @Nullable String str3, @Nullable String str4, @Nullable Double d11, @Nullable Integer num5, @Nullable String str5, @Nullable String str6) {
        return new RestaurantsSearchResponse(num, str, str2, num2, bool, num3, list, num4, str3, str4, d11, num5, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestaurantsSearchResponse)) {
            return false;
        }
        RestaurantsSearchResponse restaurantsSearchResponse = (RestaurantsSearchResponse) obj;
        return Intrinsics.areEqual((Object) this.bid, (Object) restaurantsSearchResponse.bid) && Intrinsics.areEqual((Object) this.bnmAr, (Object) restaurantsSearchResponse.bnmAr) && Intrinsics.areEqual((Object) this.bnmEn, (Object) restaurantsSearchResponse.bnmEn) && Intrinsics.areEqual((Object) this.bstat, (Object) restaurantsSearchResponse.bstat) && Intrinsics.areEqual((Object) this.ismtchbr, (Object) restaurantsSearchResponse.ismtchbr) && Intrinsics.areEqual((Object) this.mitmcnt, (Object) restaurantsSearchResponse.mitmcnt) && Intrinsics.areEqual((Object) this.mitms, (Object) restaurantsSearchResponse.mitms) && Intrinsics.areEqual((Object) this.rid, (Object) restaurantsSearchResponse.rid) && Intrinsics.areEqual((Object) this.rnmAr, (Object) restaurantsSearchResponse.rnmAr) && Intrinsics.areEqual((Object) this.rnmEn, (Object) restaurantsSearchResponse.rnmEn) && Intrinsics.areEqual((Object) this.rrtng, (Object) restaurantsSearchResponse.rrtng) && Intrinsics.areEqual((Object) this.rstat, (Object) restaurantsSearchResponse.rstat) && Intrinsics.areEqual((Object) this.thumbAr, (Object) restaurantsSearchResponse.thumbAr) && Intrinsics.areEqual((Object) this.thumbEn, (Object) restaurantsSearchResponse.thumbEn);
    }

    @Nullable
    public final Integer getBid() {
        return this.bid;
    }

    @Nullable
    public final String getBnmAr() {
        return this.bnmAr;
    }

    @Nullable
    public final String getBnmEn() {
        return this.bnmEn;
    }

    @Nullable
    public final Integer getBstat() {
        return this.bstat;
    }

    @Nullable
    public final Boolean getIsmtchbr() {
        return this.ismtchbr;
    }

    @Nullable
    public final Integer getMitmcnt() {
        return this.mitmcnt;
    }

    @Nullable
    public final List<Mitm> getMitms() {
        return this.mitms;
    }

    @Nullable
    public final Integer getRid() {
        return this.rid;
    }

    @Nullable
    public final String getRnmAr() {
        return this.rnmAr;
    }

    @Nullable
    public final String getRnmEn() {
        return this.rnmEn;
    }

    @Nullable
    public final Double getRrtng() {
        return this.rrtng;
    }

    @Nullable
    public final Integer getRstat() {
        return this.rstat;
    }

    @Nullable
    public final String getThumbAr() {
        return this.thumbAr;
    }

    @Nullable
    public final String getThumbEn() {
        return this.thumbEn;
    }

    public int hashCode() {
        Integer num = this.bid;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.bnmAr;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bnmEn;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.bstat;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.ismtchbr;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num3 = this.mitmcnt;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<Mitm> list = this.mitms;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num4 = this.rid;
        int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str3 = this.rnmAr;
        int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rnmEn;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d11 = this.rrtng;
        int hashCode11 = (hashCode10 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num5 = this.rstat;
        int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str5 = this.thumbAr;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.thumbEn;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode13 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.bid;
        String str = this.bnmAr;
        String str2 = this.bnmEn;
        Integer num2 = this.bstat;
        Boolean bool = this.ismtchbr;
        Integer num3 = this.mitmcnt;
        List<Mitm> list = this.mitms;
        Integer num4 = this.rid;
        String str3 = this.rnmAr;
        String str4 = this.rnmEn;
        Double d11 = this.rrtng;
        Integer num5 = this.rstat;
        String str5 = this.thumbAr;
        String str6 = this.thumbEn;
        return "RestaurantsSearchResponse(bid=" + num + ", bnmAr=" + str + ", bnmEn=" + str2 + ", bstat=" + num2 + ", ismtchbr=" + bool + ", mitmcnt=" + num3 + ", mitms=" + list + ", rid=" + num4 + ", rnmAr=" + str3 + ", rnmEn=" + str4 + ", rrtng=" + d11 + ", rstat=" + num5 + ", thumbAr=" + str5 + ", thumbEn=" + str6 + ")";
    }
}
