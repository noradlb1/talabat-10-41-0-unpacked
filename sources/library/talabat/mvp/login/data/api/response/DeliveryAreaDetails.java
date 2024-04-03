package library.talabat.mvp.login.data.api.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016JÂ\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0016R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b&\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b'\u0010\u0016R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b(\u0010\u0016¨\u0006?"}, d2 = {"Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetails;", "", "istgo", "", "cvgid", "", "dlvid", "pdvid", "", "dlvst", "tstxt", "tstxv", "dlfet", "dlfev", "mnovl", "dlvtm", "mntxt", "mntxv", "vndid", "chnid", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getChnid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCvgid", "getDlfet", "getDlfev", "getDlvid", "getDlvst", "getDlvtm", "getIstgo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMnovl", "getMntxt", "getMntxv", "getPdvid", "()Ljava/lang/String;", "getTstxt", "getTstxv", "getVndid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetails;", "equals", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryAreaDetails {
    @SerializedName("chnid")
    @Nullable
    private final Long chnid;
    @SerializedName("cvgid")
    @Nullable
    private final Long cvgid;
    @SerializedName("dlfet")
    @Nullable
    private final Long dlfet;
    @SerializedName("dlfev")
    @Nullable
    private final Long dlfev;
    @SerializedName("dlvid")
    @Nullable
    private final Long dlvid;
    @SerializedName("dlvst")
    @Nullable
    private final Long dlvst;
    @SerializedName("dlvtm")
    @Nullable
    private final Long dlvtm;
    @SerializedName("istgo")
    @Nullable
    private final Boolean istgo;
    @SerializedName("mnovl")
    @Nullable
    private final Long mnovl;
    @SerializedName("mntxt")
    @Nullable
    private final Long mntxt;
    @SerializedName("mntxv")
    @Nullable
    private final Long mntxv;
    @SerializedName("pdvid")
    @Nullable
    private final String pdvid;
    @SerializedName("tstxt")
    @Nullable
    private final Long tstxt;
    @SerializedName("tstxv")
    @Nullable
    private final Long tstxv;
    @SerializedName("vndid")
    @Nullable
    private final Long vndid;

    public DeliveryAreaDetails(@Nullable Boolean bool, @Nullable Long l11, @Nullable Long l12, @Nullable String str, @Nullable Long l13, @Nullable Long l14, @Nullable Long l15, @Nullable Long l16, @Nullable Long l17, @Nullable Long l18, @Nullable Long l19, @Nullable Long l21, @Nullable Long l22, @Nullable Long l23, @Nullable Long l24) {
        this.istgo = bool;
        this.cvgid = l11;
        this.dlvid = l12;
        this.pdvid = str;
        this.dlvst = l13;
        this.tstxt = l14;
        this.tstxv = l15;
        this.dlfet = l16;
        this.dlfev = l17;
        this.mnovl = l18;
        this.dlvtm = l19;
        this.mntxt = l21;
        this.mntxv = l22;
        this.vndid = l23;
        this.chnid = l24;
    }

    public static /* synthetic */ DeliveryAreaDetails copy$default(DeliveryAreaDetails deliveryAreaDetails, Boolean bool, Long l11, Long l12, String str, Long l13, Long l14, Long l15, Long l16, Long l17, Long l18, Long l19, Long l21, Long l22, Long l23, Long l24, int i11, Object obj) {
        DeliveryAreaDetails deliveryAreaDetails2 = deliveryAreaDetails;
        int i12 = i11;
        return deliveryAreaDetails.copy((i12 & 1) != 0 ? deliveryAreaDetails2.istgo : bool, (i12 & 2) != 0 ? deliveryAreaDetails2.cvgid : l11, (i12 & 4) != 0 ? deliveryAreaDetails2.dlvid : l12, (i12 & 8) != 0 ? deliveryAreaDetails2.pdvid : str, (i12 & 16) != 0 ? deliveryAreaDetails2.dlvst : l13, (i12 & 32) != 0 ? deliveryAreaDetails2.tstxt : l14, (i12 & 64) != 0 ? deliveryAreaDetails2.tstxv : l15, (i12 & 128) != 0 ? deliveryAreaDetails2.dlfet : l16, (i12 & 256) != 0 ? deliveryAreaDetails2.dlfev : l17, (i12 & 512) != 0 ? deliveryAreaDetails2.mnovl : l18, (i12 & 1024) != 0 ? deliveryAreaDetails2.dlvtm : l19, (i12 & 2048) != 0 ? deliveryAreaDetails2.mntxt : l21, (i12 & 4096) != 0 ? deliveryAreaDetails2.mntxv : l22, (i12 & 8192) != 0 ? deliveryAreaDetails2.vndid : l23, (i12 & 16384) != 0 ? deliveryAreaDetails2.chnid : l24);
    }

    @Nullable
    public final Boolean component1() {
        return this.istgo;
    }

    @Nullable
    public final Long component10() {
        return this.mnovl;
    }

    @Nullable
    public final Long component11() {
        return this.dlvtm;
    }

    @Nullable
    public final Long component12() {
        return this.mntxt;
    }

    @Nullable
    public final Long component13() {
        return this.mntxv;
    }

    @Nullable
    public final Long component14() {
        return this.vndid;
    }

    @Nullable
    public final Long component15() {
        return this.chnid;
    }

    @Nullable
    public final Long component2() {
        return this.cvgid;
    }

    @Nullable
    public final Long component3() {
        return this.dlvid;
    }

    @Nullable
    public final String component4() {
        return this.pdvid;
    }

    @Nullable
    public final Long component5() {
        return this.dlvst;
    }

    @Nullable
    public final Long component6() {
        return this.tstxt;
    }

    @Nullable
    public final Long component7() {
        return this.tstxv;
    }

    @Nullable
    public final Long component8() {
        return this.dlfet;
    }

    @Nullable
    public final Long component9() {
        return this.dlfev;
    }

    @NotNull
    public final DeliveryAreaDetails copy(@Nullable Boolean bool, @Nullable Long l11, @Nullable Long l12, @Nullable String str, @Nullable Long l13, @Nullable Long l14, @Nullable Long l15, @Nullable Long l16, @Nullable Long l17, @Nullable Long l18, @Nullable Long l19, @Nullable Long l21, @Nullable Long l22, @Nullable Long l23, @Nullable Long l24) {
        return new DeliveryAreaDetails(bool, l11, l12, str, l13, l14, l15, l16, l17, l18, l19, l21, l22, l23, l24);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryAreaDetails)) {
            return false;
        }
        DeliveryAreaDetails deliveryAreaDetails = (DeliveryAreaDetails) obj;
        return Intrinsics.areEqual((Object) this.istgo, (Object) deliveryAreaDetails.istgo) && Intrinsics.areEqual((Object) this.cvgid, (Object) deliveryAreaDetails.cvgid) && Intrinsics.areEqual((Object) this.dlvid, (Object) deliveryAreaDetails.dlvid) && Intrinsics.areEqual((Object) this.pdvid, (Object) deliveryAreaDetails.pdvid) && Intrinsics.areEqual((Object) this.dlvst, (Object) deliveryAreaDetails.dlvst) && Intrinsics.areEqual((Object) this.tstxt, (Object) deliveryAreaDetails.tstxt) && Intrinsics.areEqual((Object) this.tstxv, (Object) deliveryAreaDetails.tstxv) && Intrinsics.areEqual((Object) this.dlfet, (Object) deliveryAreaDetails.dlfet) && Intrinsics.areEqual((Object) this.dlfev, (Object) deliveryAreaDetails.dlfev) && Intrinsics.areEqual((Object) this.mnovl, (Object) deliveryAreaDetails.mnovl) && Intrinsics.areEqual((Object) this.dlvtm, (Object) deliveryAreaDetails.dlvtm) && Intrinsics.areEqual((Object) this.mntxt, (Object) deliveryAreaDetails.mntxt) && Intrinsics.areEqual((Object) this.mntxv, (Object) deliveryAreaDetails.mntxv) && Intrinsics.areEqual((Object) this.vndid, (Object) deliveryAreaDetails.vndid) && Intrinsics.areEqual((Object) this.chnid, (Object) deliveryAreaDetails.chnid);
    }

    @Nullable
    public final Long getChnid() {
        return this.chnid;
    }

    @Nullable
    public final Long getCvgid() {
        return this.cvgid;
    }

    @Nullable
    public final Long getDlfet() {
        return this.dlfet;
    }

    @Nullable
    public final Long getDlfev() {
        return this.dlfev;
    }

    @Nullable
    public final Long getDlvid() {
        return this.dlvid;
    }

    @Nullable
    public final Long getDlvst() {
        return this.dlvst;
    }

    @Nullable
    public final Long getDlvtm() {
        return this.dlvtm;
    }

    @Nullable
    public final Boolean getIstgo() {
        return this.istgo;
    }

    @Nullable
    public final Long getMnovl() {
        return this.mnovl;
    }

    @Nullable
    public final Long getMntxt() {
        return this.mntxt;
    }

    @Nullable
    public final Long getMntxv() {
        return this.mntxv;
    }

    @Nullable
    public final String getPdvid() {
        return this.pdvid;
    }

    @Nullable
    public final Long getTstxt() {
        return this.tstxt;
    }

    @Nullable
    public final Long getTstxv() {
        return this.tstxv;
    }

    @Nullable
    public final Long getVndid() {
        return this.vndid;
    }

    public int hashCode() {
        Boolean bool = this.istgo;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l11 = this.cvgid;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.dlvid;
        int hashCode3 = (hashCode2 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str = this.pdvid;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Long l13 = this.dlvst;
        int hashCode5 = (hashCode4 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.tstxt;
        int hashCode6 = (hashCode5 + (l14 == null ? 0 : l14.hashCode())) * 31;
        Long l15 = this.tstxv;
        int hashCode7 = (hashCode6 + (l15 == null ? 0 : l15.hashCode())) * 31;
        Long l16 = this.dlfet;
        int hashCode8 = (hashCode7 + (l16 == null ? 0 : l16.hashCode())) * 31;
        Long l17 = this.dlfev;
        int hashCode9 = (hashCode8 + (l17 == null ? 0 : l17.hashCode())) * 31;
        Long l18 = this.mnovl;
        int hashCode10 = (hashCode9 + (l18 == null ? 0 : l18.hashCode())) * 31;
        Long l19 = this.dlvtm;
        int hashCode11 = (hashCode10 + (l19 == null ? 0 : l19.hashCode())) * 31;
        Long l21 = this.mntxt;
        int hashCode12 = (hashCode11 + (l21 == null ? 0 : l21.hashCode())) * 31;
        Long l22 = this.mntxv;
        int hashCode13 = (hashCode12 + (l22 == null ? 0 : l22.hashCode())) * 31;
        Long l23 = this.vndid;
        int hashCode14 = (hashCode13 + (l23 == null ? 0 : l23.hashCode())) * 31;
        Long l24 = this.chnid;
        if (l24 != null) {
            i11 = l24.hashCode();
        }
        return hashCode14 + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.istgo;
        Long l11 = this.cvgid;
        Long l12 = this.dlvid;
        String str = this.pdvid;
        Long l13 = this.dlvst;
        Long l14 = this.tstxt;
        Long l15 = this.tstxv;
        Long l16 = this.dlfet;
        Long l17 = this.dlfev;
        Long l18 = this.mnovl;
        Long l19 = this.dlvtm;
        Long l21 = this.mntxt;
        Long l22 = this.mntxv;
        Long l23 = this.vndid;
        Long l24 = this.chnid;
        return "DeliveryAreaDetails(istgo=" + bool + ", cvgid=" + l11 + ", dlvid=" + l12 + ", pdvid=" + str + ", dlvst=" + l13 + ", tstxt=" + l14 + ", tstxv=" + l15 + ", dlfet=" + l16 + ", dlfev=" + l17 + ", mnovl=" + l18 + ", dlvtm=" + l19 + ", mntxt=" + l21 + ", mntxv=" + l22 + ", vndid=" + l23 + ", chnid=" + l24 + ")";
    }
}
