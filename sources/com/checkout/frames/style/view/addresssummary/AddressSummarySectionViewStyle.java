package com.checkout.frames.style.view.addresssummary;

import androidx.compose.ui.Modifier;
import com.checkout.frames.style.view.DividerViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "", "addressTextStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "dividerStyle", "Lcom/checkout/frames/style/view/DividerViewStyle;", "editAddressButtonStyle", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/style/view/DividerViewStyle;Lcom/checkout/frames/style/view/InternalButtonViewStyle;Landroidx/compose/ui/Modifier;)V", "getAddressTextStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "getDividerStyle", "()Lcom/checkout/frames/style/view/DividerViewStyle;", "getEditAddressButtonStyle", "()Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "getModifier", "()Landroidx/compose/ui/Modifier;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummarySectionViewStyle {
    @NotNull
    private final TextLabelViewStyle addressTextStyle;
    @Nullable
    private final DividerViewStyle dividerStyle;
    @NotNull
    private final InternalButtonViewStyle editAddressButtonStyle;
    @NotNull
    private final Modifier modifier;

    public AddressSummarySectionViewStyle(@NotNull TextLabelViewStyle textLabelViewStyle, @Nullable DividerViewStyle dividerViewStyle, @NotNull InternalButtonViewStyle internalButtonViewStyle, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "addressTextStyle");
        Intrinsics.checkNotNullParameter(internalButtonViewStyle, "editAddressButtonStyle");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        this.addressTextStyle = textLabelViewStyle;
        this.dividerStyle = dividerViewStyle;
        this.editAddressButtonStyle = internalButtonViewStyle;
        this.modifier = modifier2;
    }

    public static /* synthetic */ AddressSummarySectionViewStyle copy$default(AddressSummarySectionViewStyle addressSummarySectionViewStyle, TextLabelViewStyle textLabelViewStyle, DividerViewStyle dividerViewStyle, InternalButtonViewStyle internalButtonViewStyle, Modifier modifier2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelViewStyle = addressSummarySectionViewStyle.addressTextStyle;
        }
        if ((i11 & 2) != 0) {
            dividerViewStyle = addressSummarySectionViewStyle.dividerStyle;
        }
        if ((i11 & 4) != 0) {
            internalButtonViewStyle = addressSummarySectionViewStyle.editAddressButtonStyle;
        }
        if ((i11 & 8) != 0) {
            modifier2 = addressSummarySectionViewStyle.modifier;
        }
        return addressSummarySectionViewStyle.copy(textLabelViewStyle, dividerViewStyle, internalButtonViewStyle, modifier2);
    }

    @NotNull
    public final TextLabelViewStyle component1() {
        return this.addressTextStyle;
    }

    @Nullable
    public final DividerViewStyle component2() {
        return this.dividerStyle;
    }

    @NotNull
    public final InternalButtonViewStyle component3() {
        return this.editAddressButtonStyle;
    }

    @NotNull
    public final Modifier component4() {
        return this.modifier;
    }

    @NotNull
    public final AddressSummarySectionViewStyle copy(@NotNull TextLabelViewStyle textLabelViewStyle, @Nullable DividerViewStyle dividerViewStyle, @NotNull InternalButtonViewStyle internalButtonViewStyle, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "addressTextStyle");
        Intrinsics.checkNotNullParameter(internalButtonViewStyle, "editAddressButtonStyle");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return new AddressSummarySectionViewStyle(textLabelViewStyle, dividerViewStyle, internalButtonViewStyle, modifier2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressSummarySectionViewStyle)) {
            return false;
        }
        AddressSummarySectionViewStyle addressSummarySectionViewStyle = (AddressSummarySectionViewStyle) obj;
        return Intrinsics.areEqual((Object) this.addressTextStyle, (Object) addressSummarySectionViewStyle.addressTextStyle) && Intrinsics.areEqual((Object) this.dividerStyle, (Object) addressSummarySectionViewStyle.dividerStyle) && Intrinsics.areEqual((Object) this.editAddressButtonStyle, (Object) addressSummarySectionViewStyle.editAddressButtonStyle) && Intrinsics.areEqual((Object) this.modifier, (Object) addressSummarySectionViewStyle.modifier);
    }

    @NotNull
    public final TextLabelViewStyle getAddressTextStyle() {
        return this.addressTextStyle;
    }

    @Nullable
    public final DividerViewStyle getDividerStyle() {
        return this.dividerStyle;
    }

    @NotNull
    public final InternalButtonViewStyle getEditAddressButtonStyle() {
        return this.editAddressButtonStyle;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    public int hashCode() {
        int hashCode = this.addressTextStyle.hashCode() * 31;
        DividerViewStyle dividerViewStyle = this.dividerStyle;
        return ((((hashCode + (dividerViewStyle == null ? 0 : dividerViewStyle.hashCode())) * 31) + this.editAddressButtonStyle.hashCode()) * 31) + this.modifier.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelViewStyle textLabelViewStyle = this.addressTextStyle;
        DividerViewStyle dividerViewStyle = this.dividerStyle;
        InternalButtonViewStyle internalButtonViewStyle = this.editAddressButtonStyle;
        Modifier modifier2 = this.modifier;
        return "AddressSummarySectionViewStyle(addressTextStyle=" + textLabelViewStyle + ", dividerStyle=" + dividerViewStyle + ", editAddressButtonStyle=" + internalButtonViewStyle + ", modifier=" + modifier2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressSummarySectionViewStyle(TextLabelViewStyle textLabelViewStyle, DividerViewStyle dividerViewStyle, InternalButtonViewStyle internalButtonViewStyle, Modifier modifier2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLabelViewStyle, (i11 & 2) != 0 ? null : dividerViewStyle, internalButtonViewStyle, modifier2);
    }
}
