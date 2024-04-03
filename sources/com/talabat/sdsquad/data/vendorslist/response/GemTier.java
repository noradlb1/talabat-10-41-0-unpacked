package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/GemTier;", "", "cntid", "", "disc", "", "tieramt", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)V", "getCntid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisc", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTieramt", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lcom/talabat/sdsquad/data/vendorslist/response/GemTier;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemTier {
    @SerializedName("cntid")
    @Nullable
    private final Integer cntid;
    @SerializedName("disc")
    @Nullable
    private final Double disc;
    @SerializedName("tieramt")
    @Nullable
    private final Double tieramt;

    public GemTier(@Nullable Integer num, @Nullable Double d11, @Nullable Double d12) {
        this.cntid = num;
        this.disc = d11;
        this.tieramt = d12;
    }

    public static /* synthetic */ GemTier copy$default(GemTier gemTier, Integer num, Double d11, Double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = gemTier.cntid;
        }
        if ((i11 & 2) != 0) {
            d11 = gemTier.disc;
        }
        if ((i11 & 4) != 0) {
            d12 = gemTier.tieramt;
        }
        return gemTier.copy(num, d11, d12);
    }

    @Nullable
    public final Integer component1() {
        return this.cntid;
    }

    @Nullable
    public final Double component2() {
        return this.disc;
    }

    @Nullable
    public final Double component3() {
        return this.tieramt;
    }

    @NotNull
    public final GemTier copy(@Nullable Integer num, @Nullable Double d11, @Nullable Double d12) {
        return new GemTier(num, d11, d12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemTier)) {
            return false;
        }
        GemTier gemTier = (GemTier) obj;
        return Intrinsics.areEqual((Object) this.cntid, (Object) gemTier.cntid) && Intrinsics.areEqual((Object) this.disc, (Object) gemTier.disc) && Intrinsics.areEqual((Object) this.tieramt, (Object) gemTier.tieramt);
    }

    @Nullable
    public final Integer getCntid() {
        return this.cntid;
    }

    @Nullable
    public final Double getDisc() {
        return this.disc;
    }

    @Nullable
    public final Double getTieramt() {
        return this.tieramt;
    }

    public int hashCode() {
        Integer num = this.cntid;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Double d11 = this.disc;
        int hashCode2 = (hashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.tieramt;
        if (d12 != null) {
            i11 = d12.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.cntid;
        Double d11 = this.disc;
        Double d12 = this.tieramt;
        return "GemTier(cntid=" + num + ", disc=" + d11 + ", tieramt=" + d12 + ")";
    }
}
