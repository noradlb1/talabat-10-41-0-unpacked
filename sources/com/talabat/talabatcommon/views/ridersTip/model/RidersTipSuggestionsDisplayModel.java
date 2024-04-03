package com.talabat.talabatcommon.views.ridersTip.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestionsDisplayModel;", "", "tipsAmountList", "", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestedAmountDisplayModel;", "shouldShowTipsAsChips", "", "(Ljava/util/List;Z)V", "getShouldShowTipsAsChips", "()Z", "getTipsAmountList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RidersTipSuggestionsDisplayModel {
    private final boolean shouldShowTipsAsChips;
    @NotNull
    private final List<RidersTipSuggestedAmountDisplayModel> tipsAmountList;

    public RidersTipSuggestionsDisplayModel(@NotNull List<RidersTipSuggestedAmountDisplayModel> list, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "tipsAmountList");
        this.tipsAmountList = list;
        this.shouldShowTipsAsChips = z11;
    }

    public static /* synthetic */ RidersTipSuggestionsDisplayModel copy$default(RidersTipSuggestionsDisplayModel ridersTipSuggestionsDisplayModel, List<RidersTipSuggestedAmountDisplayModel> list, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = ridersTipSuggestionsDisplayModel.tipsAmountList;
        }
        if ((i11 & 2) != 0) {
            z11 = ridersTipSuggestionsDisplayModel.shouldShowTipsAsChips;
        }
        return ridersTipSuggestionsDisplayModel.copy(list, z11);
    }

    @NotNull
    public final List<RidersTipSuggestedAmountDisplayModel> component1() {
        return this.tipsAmountList;
    }

    public final boolean component2() {
        return this.shouldShowTipsAsChips;
    }

    @NotNull
    public final RidersTipSuggestionsDisplayModel copy(@NotNull List<RidersTipSuggestedAmountDisplayModel> list, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "tipsAmountList");
        return new RidersTipSuggestionsDisplayModel(list, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RidersTipSuggestionsDisplayModel)) {
            return false;
        }
        RidersTipSuggestionsDisplayModel ridersTipSuggestionsDisplayModel = (RidersTipSuggestionsDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.tipsAmountList, (Object) ridersTipSuggestionsDisplayModel.tipsAmountList) && this.shouldShowTipsAsChips == ridersTipSuggestionsDisplayModel.shouldShowTipsAsChips;
    }

    public final boolean getShouldShowTipsAsChips() {
        return this.shouldShowTipsAsChips;
    }

    @NotNull
    public final List<RidersTipSuggestedAmountDisplayModel> getTipsAmountList() {
        return this.tipsAmountList;
    }

    public int hashCode() {
        int hashCode = this.tipsAmountList.hashCode() * 31;
        boolean z11 = this.shouldShowTipsAsChips;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        List<RidersTipSuggestedAmountDisplayModel> list = this.tipsAmountList;
        boolean z11 = this.shouldShowTipsAsChips;
        return "RidersTipSuggestionsDisplayModel(tipsAmountList=" + list + ", shouldShowTipsAsChips=" + z11 + ")";
    }
}
