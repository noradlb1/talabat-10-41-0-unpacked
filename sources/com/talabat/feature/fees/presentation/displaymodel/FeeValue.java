package com.talabat.feature.fees.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/fees/presentation/displaymodel/FeeValue;", "", "label", "", "value", "", "formattedValue", "tagLabel", "standardFee", "(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFormattedValue", "()Ljava/lang/String;", "getLabel", "getStandardFee", "getTagLabel", "getValue", "()D", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pricing_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeValue {
    public static final int $stable = 0;
    @NotNull
    private final String formattedValue;
    @NotNull
    private final String label;
    @Nullable
    private final String standardFee;
    @Nullable
    private final String tagLabel;
    private final double value;

    public FeeValue(@NotNull String str, double d11, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "formattedValue");
        this.label = str;
        this.value = d11;
        this.formattedValue = str2;
        this.tagLabel = str3;
        this.standardFee = str4;
    }

    public static /* synthetic */ FeeValue copy$default(FeeValue feeValue, String str, double d11, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = feeValue.label;
        }
        if ((i11 & 2) != 0) {
            d11 = feeValue.value;
        }
        double d12 = d11;
        if ((i11 & 4) != 0) {
            str2 = feeValue.formattedValue;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            str3 = feeValue.tagLabel;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = feeValue.standardFee;
        }
        return feeValue.copy(str, d12, str5, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.label;
    }

    public final double component2() {
        return this.value;
    }

    @NotNull
    public final String component3() {
        return this.formattedValue;
    }

    @Nullable
    public final String component4() {
        return this.tagLabel;
    }

    @Nullable
    public final String component5() {
        return this.standardFee;
    }

    @NotNull
    public final FeeValue copy(@NotNull String str, double d11, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "formattedValue");
        return new FeeValue(str, d11, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeeValue)) {
            return false;
        }
        FeeValue feeValue = (FeeValue) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) feeValue.label) && Intrinsics.areEqual((Object) Double.valueOf(this.value), (Object) Double.valueOf(feeValue.value)) && Intrinsics.areEqual((Object) this.formattedValue, (Object) feeValue.formattedValue) && Intrinsics.areEqual((Object) this.tagLabel, (Object) feeValue.tagLabel) && Intrinsics.areEqual((Object) this.standardFee, (Object) feeValue.standardFee);
    }

    @NotNull
    public final String getFormattedValue() {
        return this.formattedValue;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getStandardFee() {
        return this.standardFee;
    }

    @Nullable
    public final String getTagLabel() {
        return this.tagLabel;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((((this.label.hashCode() * 31) + Double.doubleToLongBits(this.value)) * 31) + this.formattedValue.hashCode()) * 31;
        String str = this.tagLabel;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.standardFee;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.label;
        double d11 = this.value;
        String str2 = this.formattedValue;
        String str3 = this.tagLabel;
        String str4 = this.standardFee;
        return "FeeValue(label=" + str + ", value=" + d11 + ", formattedValue=" + str2 + ", tagLabel=" + str3 + ", standardFee=" + str4 + ")";
    }
}
