package com.checkout.frames.style.component.billingformdetails;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.InputComponentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/frames/style/component/billingformdetails/BillingAddressInputComponentStyle;", "", "addressFieldName", "", "inputComponentStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "(Ljava/lang/String;Lcom/checkout/frames/style/component/base/InputComponentStyle;)V", "getAddressFieldName", "()Ljava/lang/String;", "getInputComponentStyle", "()Lcom/checkout/frames/style/component/base/InputComponentStyle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressInputComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final String addressFieldName;
    @NotNull
    private final InputComponentStyle inputComponentStyle;

    public BillingAddressInputComponentStyle(@NotNull String str, @NotNull InputComponentStyle inputComponentStyle2) {
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        Intrinsics.checkNotNullParameter(inputComponentStyle2, "inputComponentStyle");
        this.addressFieldName = str;
        this.inputComponentStyle = inputComponentStyle2;
    }

    public static /* synthetic */ BillingAddressInputComponentStyle copy$default(BillingAddressInputComponentStyle billingAddressInputComponentStyle, String str, InputComponentStyle inputComponentStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = billingAddressInputComponentStyle.addressFieldName;
        }
        if ((i11 & 2) != 0) {
            inputComponentStyle2 = billingAddressInputComponentStyle.inputComponentStyle;
        }
        return billingAddressInputComponentStyle.copy(str, inputComponentStyle2);
    }

    @NotNull
    public final String component1() {
        return this.addressFieldName;
    }

    @NotNull
    public final InputComponentStyle component2() {
        return this.inputComponentStyle;
    }

    @NotNull
    public final BillingAddressInputComponentStyle copy(@NotNull String str, @NotNull InputComponentStyle inputComponentStyle2) {
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        Intrinsics.checkNotNullParameter(inputComponentStyle2, "inputComponentStyle");
        return new BillingAddressInputComponentStyle(str, inputComponentStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingAddressInputComponentStyle)) {
            return false;
        }
        BillingAddressInputComponentStyle billingAddressInputComponentStyle = (BillingAddressInputComponentStyle) obj;
        return Intrinsics.areEqual((Object) this.addressFieldName, (Object) billingAddressInputComponentStyle.addressFieldName) && Intrinsics.areEqual((Object) this.inputComponentStyle, (Object) billingAddressInputComponentStyle.inputComponentStyle);
    }

    @NotNull
    public final String getAddressFieldName() {
        return this.addressFieldName;
    }

    @NotNull
    public final InputComponentStyle getInputComponentStyle() {
        return this.inputComponentStyle;
    }

    public int hashCode() {
        return (this.addressFieldName.hashCode() * 31) + this.inputComponentStyle.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.addressFieldName;
        InputComponentStyle inputComponentStyle2 = this.inputComponentStyle;
        return "BillingAddressInputComponentStyle(addressFieldName=" + str + ", inputComponentStyle=" + inputComponentStyle2 + ")";
    }
}
