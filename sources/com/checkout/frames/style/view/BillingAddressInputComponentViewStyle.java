package com.checkout.frames.style.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;", "", "addressFieldName", "", "inputComponentViewStyle", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "(Ljava/lang/String;Lcom/checkout/frames/style/view/InputComponentViewStyle;)V", "getAddressFieldName", "()Ljava/lang/String;", "getInputComponentViewStyle", "()Lcom/checkout/frames/style/view/InputComponentViewStyle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressInputComponentViewStyle {
    @NotNull
    private final String addressFieldName;
    @NotNull
    private final InputComponentViewStyle inputComponentViewStyle;

    public BillingAddressInputComponentViewStyle(@NotNull String str, @NotNull InputComponentViewStyle inputComponentViewStyle2) {
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        Intrinsics.checkNotNullParameter(inputComponentViewStyle2, "inputComponentViewStyle");
        this.addressFieldName = str;
        this.inputComponentViewStyle = inputComponentViewStyle2;
    }

    public static /* synthetic */ BillingAddressInputComponentViewStyle copy$default(BillingAddressInputComponentViewStyle billingAddressInputComponentViewStyle, String str, InputComponentViewStyle inputComponentViewStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = billingAddressInputComponentViewStyle.addressFieldName;
        }
        if ((i11 & 2) != 0) {
            inputComponentViewStyle2 = billingAddressInputComponentViewStyle.inputComponentViewStyle;
        }
        return billingAddressInputComponentViewStyle.copy(str, inputComponentViewStyle2);
    }

    @NotNull
    public final String component1() {
        return this.addressFieldName;
    }

    @NotNull
    public final InputComponentViewStyle component2() {
        return this.inputComponentViewStyle;
    }

    @NotNull
    public final BillingAddressInputComponentViewStyle copy(@NotNull String str, @NotNull InputComponentViewStyle inputComponentViewStyle2) {
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        Intrinsics.checkNotNullParameter(inputComponentViewStyle2, "inputComponentViewStyle");
        return new BillingAddressInputComponentViewStyle(str, inputComponentViewStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingAddressInputComponentViewStyle)) {
            return false;
        }
        BillingAddressInputComponentViewStyle billingAddressInputComponentViewStyle = (BillingAddressInputComponentViewStyle) obj;
        return Intrinsics.areEqual((Object) this.addressFieldName, (Object) billingAddressInputComponentViewStyle.addressFieldName) && Intrinsics.areEqual((Object) this.inputComponentViewStyle, (Object) billingAddressInputComponentViewStyle.inputComponentViewStyle);
    }

    @NotNull
    public final String getAddressFieldName() {
        return this.addressFieldName;
    }

    @NotNull
    public final InputComponentViewStyle getInputComponentViewStyle() {
        return this.inputComponentViewStyle;
    }

    public int hashCode() {
        return (this.addressFieldName.hashCode() * 31) + this.inputComponentViewStyle.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.addressFieldName;
        InputComponentViewStyle inputComponentViewStyle2 = this.inputComponentViewStyle;
        return "BillingAddressInputComponentViewStyle(addressFieldName=" + str + ", inputComponentViewStyle=" + inputComponentViewStyle2 + ")";
    }
}
