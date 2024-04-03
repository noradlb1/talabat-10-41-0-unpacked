package com.talabat.feature.ridertips.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionsDetailsDisplayModel;", "", "tipOptions", "", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionDisplayModel;", "reuseTipDisplayed", "", "reuseTipSelected", "reuseTipTitleResId", "", "(Ljava/util/List;ZZI)V", "getReuseTipDisplayed", "()Z", "getReuseTipSelected", "getReuseTipTitleResId", "()I", "getTipOptions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TipOptionsDetailsDisplayModel {
    public static final int $stable = 8;
    private final boolean reuseTipDisplayed;
    private final boolean reuseTipSelected;
    private final int reuseTipTitleResId;
    @NotNull
    private final List<TipOptionDisplayModel> tipOptions;

    public TipOptionsDetailsDisplayModel(@NotNull List<TipOptionDisplayModel> list, boolean z11, boolean z12, int i11) {
        Intrinsics.checkNotNullParameter(list, "tipOptions");
        this.tipOptions = list;
        this.reuseTipDisplayed = z11;
        this.reuseTipSelected = z12;
        this.reuseTipTitleResId = i11;
    }

    public static /* synthetic */ TipOptionsDetailsDisplayModel copy$default(TipOptionsDetailsDisplayModel tipOptionsDetailsDisplayModel, List<TipOptionDisplayModel> list, boolean z11, boolean z12, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = tipOptionsDetailsDisplayModel.tipOptions;
        }
        if ((i12 & 2) != 0) {
            z11 = tipOptionsDetailsDisplayModel.reuseTipDisplayed;
        }
        if ((i12 & 4) != 0) {
            z12 = tipOptionsDetailsDisplayModel.reuseTipSelected;
        }
        if ((i12 & 8) != 0) {
            i11 = tipOptionsDetailsDisplayModel.reuseTipTitleResId;
        }
        return tipOptionsDetailsDisplayModel.copy(list, z11, z12, i11);
    }

    @NotNull
    public final List<TipOptionDisplayModel> component1() {
        return this.tipOptions;
    }

    public final boolean component2() {
        return this.reuseTipDisplayed;
    }

    public final boolean component3() {
        return this.reuseTipSelected;
    }

    public final int component4() {
        return this.reuseTipTitleResId;
    }

    @NotNull
    public final TipOptionsDetailsDisplayModel copy(@NotNull List<TipOptionDisplayModel> list, boolean z11, boolean z12, int i11) {
        Intrinsics.checkNotNullParameter(list, "tipOptions");
        return new TipOptionsDetailsDisplayModel(list, z11, z12, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipOptionsDetailsDisplayModel)) {
            return false;
        }
        TipOptionsDetailsDisplayModel tipOptionsDetailsDisplayModel = (TipOptionsDetailsDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.tipOptions, (Object) tipOptionsDetailsDisplayModel.tipOptions) && this.reuseTipDisplayed == tipOptionsDetailsDisplayModel.reuseTipDisplayed && this.reuseTipSelected == tipOptionsDetailsDisplayModel.reuseTipSelected && this.reuseTipTitleResId == tipOptionsDetailsDisplayModel.reuseTipTitleResId;
    }

    public final boolean getReuseTipDisplayed() {
        return this.reuseTipDisplayed;
    }

    public final boolean getReuseTipSelected() {
        return this.reuseTipSelected;
    }

    public final int getReuseTipTitleResId() {
        return this.reuseTipTitleResId;
    }

    @NotNull
    public final List<TipOptionDisplayModel> getTipOptions() {
        return this.tipOptions;
    }

    public int hashCode() {
        int hashCode = this.tipOptions.hashCode() * 31;
        boolean z11 = this.reuseTipDisplayed;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.reuseTipSelected;
        if (!z13) {
            z12 = z13;
        }
        return ((i11 + (z12 ? 1 : 0)) * 31) + this.reuseTipTitleResId;
    }

    @NotNull
    public String toString() {
        List<TipOptionDisplayModel> list = this.tipOptions;
        boolean z11 = this.reuseTipDisplayed;
        boolean z12 = this.reuseTipSelected;
        int i11 = this.reuseTipTitleResId;
        return "TipOptionsDetailsDisplayModel(tipOptions=" + list + ", reuseTipDisplayed=" + z11 + ", reuseTipSelected=" + z12 + ", reuseTipTitleResId=" + i11 + ")";
    }
}
