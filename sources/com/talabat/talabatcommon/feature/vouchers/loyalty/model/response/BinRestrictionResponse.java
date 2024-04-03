package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictionResponse;", "", "isRestricted", "", "eligibleBins", "", "", "(ZLjava/util/List;)V", "getEligibleBins", "()Ljava/util/List;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BinRestrictionResponse {
    @SerializedName("eligibleBins")
    @Nullable
    private final List<String> eligibleBins;
    @SerializedName("isRestricted")
    private final boolean isRestricted;

    public BinRestrictionResponse() {
        this(false, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public BinRestrictionResponse(boolean z11, @Nullable List<String> list) {
        this.isRestricted = z11;
        this.eligibleBins = list;
    }

    public static /* synthetic */ BinRestrictionResponse copy$default(BinRestrictionResponse binRestrictionResponse, boolean z11, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = binRestrictionResponse.isRestricted;
        }
        if ((i11 & 2) != 0) {
            list = binRestrictionResponse.eligibleBins;
        }
        return binRestrictionResponse.copy(z11, list);
    }

    public final boolean component1() {
        return this.isRestricted;
    }

    @Nullable
    public final List<String> component2() {
        return this.eligibleBins;
    }

    @NotNull
    public final BinRestrictionResponse copy(boolean z11, @Nullable List<String> list) {
        return new BinRestrictionResponse(z11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinRestrictionResponse)) {
            return false;
        }
        BinRestrictionResponse binRestrictionResponse = (BinRestrictionResponse) obj;
        return this.isRestricted == binRestrictionResponse.isRestricted && Intrinsics.areEqual((Object) this.eligibleBins, (Object) binRestrictionResponse.eligibleBins);
    }

    @Nullable
    public final List<String> getEligibleBins() {
        return this.eligibleBins;
    }

    public int hashCode() {
        boolean z11 = this.isRestricted;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        List<String> list = this.eligibleBins;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public final boolean isRestricted() {
        return this.isRestricted;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isRestricted;
        List<String> list = this.eligibleBins;
        return "BinRestrictionResponse(isRestricted=" + z11 + ", eligibleBins=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BinRestrictionResponse(boolean z11, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? null : list);
    }
}
