package com.talabat.feature.ridertips.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionDisplayModel;", "", "value", "", "displayTipValue", "", "selected", "", "isCustomTip", "(Ljava/lang/Double;Ljava/lang/String;ZZ)V", "getDisplayTipValue", "()Ljava/lang/String;", "()Z", "getSelected", "getValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/String;ZZ)Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionDisplayModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TipOptionDisplayModel {
    public static final int $stable = 0;
    @NotNull
    private final String displayTipValue;
    private final boolean isCustomTip;
    private final boolean selected;
    @Nullable
    private final Double value;

    public TipOptionDisplayModel(@Nullable Double d11, @NotNull String str, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "displayTipValue");
        this.value = d11;
        this.displayTipValue = str;
        this.selected = z11;
        this.isCustomTip = z12;
    }

    public static /* synthetic */ TipOptionDisplayModel copy$default(TipOptionDisplayModel tipOptionDisplayModel, Double d11, String str, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = tipOptionDisplayModel.value;
        }
        if ((i11 & 2) != 0) {
            str = tipOptionDisplayModel.displayTipValue;
        }
        if ((i11 & 4) != 0) {
            z11 = tipOptionDisplayModel.selected;
        }
        if ((i11 & 8) != 0) {
            z12 = tipOptionDisplayModel.isCustomTip;
        }
        return tipOptionDisplayModel.copy(d11, str, z11, z12);
    }

    @Nullable
    public final Double component1() {
        return this.value;
    }

    @NotNull
    public final String component2() {
        return this.displayTipValue;
    }

    public final boolean component3() {
        return this.selected;
    }

    public final boolean component4() {
        return this.isCustomTip;
    }

    @NotNull
    public final TipOptionDisplayModel copy(@Nullable Double d11, @NotNull String str, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "displayTipValue");
        return new TipOptionDisplayModel(d11, str, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipOptionDisplayModel)) {
            return false;
        }
        TipOptionDisplayModel tipOptionDisplayModel = (TipOptionDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.value, (Object) tipOptionDisplayModel.value) && Intrinsics.areEqual((Object) this.displayTipValue, (Object) tipOptionDisplayModel.displayTipValue) && this.selected == tipOptionDisplayModel.selected && this.isCustomTip == tipOptionDisplayModel.isCustomTip;
    }

    @NotNull
    public final String getDisplayTipValue() {
        return this.displayTipValue;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Nullable
    public final Double getValue() {
        return this.value;
    }

    public int hashCode() {
        Double d11 = this.value;
        int hashCode = (((d11 == null ? 0 : d11.hashCode()) * 31) + this.displayTipValue.hashCode()) * 31;
        boolean z11 = this.selected;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isCustomTip;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isCustomTip() {
        return this.isCustomTip;
    }

    @NotNull
    public String toString() {
        Double d11 = this.value;
        String str = this.displayTipValue;
        boolean z11 = this.selected;
        boolean z12 = this.isCustomTip;
        return "TipOptionDisplayModel(value=" + d11 + ", displayTipValue=" + str + ", selected=" + z11 + ", isCustomTip=" + z12 + ")";
    }
}
