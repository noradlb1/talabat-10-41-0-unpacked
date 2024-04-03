package com.checkout.frames.style.view.addresssummary;

import androidx.compose.ui.Modifier;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lcom/checkout/frames/style/view/addresssummary/AddressSummaryComponentViewStyle;", "", "titleStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "subTitleStyle", "addAddressButtonStyle", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "summarySectionStyle", "Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/style/view/InternalButtonViewStyle;Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;Landroidx/compose/ui/Modifier;)V", "getAddAddressButtonStyle", "()Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "getModifier", "()Landroidx/compose/ui/Modifier;", "getSubTitleStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "getSummarySectionStyle", "()Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "getTitleStyle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentViewStyle {
    @NotNull
    private final InternalButtonViewStyle addAddressButtonStyle;
    @NotNull
    private final Modifier modifier;
    @Nullable
    private final TextLabelViewStyle subTitleStyle;
    @NotNull
    private final AddressSummarySectionViewStyle summarySectionStyle;
    @Nullable
    private final TextLabelViewStyle titleStyle;

    public AddressSummaryComponentViewStyle(@Nullable TextLabelViewStyle textLabelViewStyle, @Nullable TextLabelViewStyle textLabelViewStyle2, @NotNull InternalButtonViewStyle internalButtonViewStyle, @NotNull AddressSummarySectionViewStyle addressSummarySectionViewStyle, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(internalButtonViewStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(addressSummarySectionViewStyle, "summarySectionStyle");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        this.titleStyle = textLabelViewStyle;
        this.subTitleStyle = textLabelViewStyle2;
        this.addAddressButtonStyle = internalButtonViewStyle;
        this.summarySectionStyle = addressSummarySectionViewStyle;
        this.modifier = modifier2;
    }

    public static /* synthetic */ AddressSummaryComponentViewStyle copy$default(AddressSummaryComponentViewStyle addressSummaryComponentViewStyle, TextLabelViewStyle textLabelViewStyle, TextLabelViewStyle textLabelViewStyle2, InternalButtonViewStyle internalButtonViewStyle, AddressSummarySectionViewStyle addressSummarySectionViewStyle, Modifier modifier2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelViewStyle = addressSummaryComponentViewStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            textLabelViewStyle2 = addressSummaryComponentViewStyle.subTitleStyle;
        }
        TextLabelViewStyle textLabelViewStyle3 = textLabelViewStyle2;
        if ((i11 & 4) != 0) {
            internalButtonViewStyle = addressSummaryComponentViewStyle.addAddressButtonStyle;
        }
        InternalButtonViewStyle internalButtonViewStyle2 = internalButtonViewStyle;
        if ((i11 & 8) != 0) {
            addressSummarySectionViewStyle = addressSummaryComponentViewStyle.summarySectionStyle;
        }
        AddressSummarySectionViewStyle addressSummarySectionViewStyle2 = addressSummarySectionViewStyle;
        if ((i11 & 16) != 0) {
            modifier2 = addressSummaryComponentViewStyle.modifier;
        }
        return addressSummaryComponentViewStyle.copy(textLabelViewStyle, textLabelViewStyle3, internalButtonViewStyle2, addressSummarySectionViewStyle2, modifier2);
    }

    @Nullable
    public final TextLabelViewStyle component1() {
        return this.titleStyle;
    }

    @Nullable
    public final TextLabelViewStyle component2() {
        return this.subTitleStyle;
    }

    @NotNull
    public final InternalButtonViewStyle component3() {
        return this.addAddressButtonStyle;
    }

    @NotNull
    public final AddressSummarySectionViewStyle component4() {
        return this.summarySectionStyle;
    }

    @NotNull
    public final Modifier component5() {
        return this.modifier;
    }

    @NotNull
    public final AddressSummaryComponentViewStyle copy(@Nullable TextLabelViewStyle textLabelViewStyle, @Nullable TextLabelViewStyle textLabelViewStyle2, @NotNull InternalButtonViewStyle internalButtonViewStyle, @NotNull AddressSummarySectionViewStyle addressSummarySectionViewStyle, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(internalButtonViewStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(addressSummarySectionViewStyle, "summarySectionStyle");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return new AddressSummaryComponentViewStyle(textLabelViewStyle, textLabelViewStyle2, internalButtonViewStyle, addressSummarySectionViewStyle, modifier2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressSummaryComponentViewStyle)) {
            return false;
        }
        AddressSummaryComponentViewStyle addressSummaryComponentViewStyle = (AddressSummaryComponentViewStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) addressSummaryComponentViewStyle.titleStyle) && Intrinsics.areEqual((Object) this.subTitleStyle, (Object) addressSummaryComponentViewStyle.subTitleStyle) && Intrinsics.areEqual((Object) this.addAddressButtonStyle, (Object) addressSummaryComponentViewStyle.addAddressButtonStyle) && Intrinsics.areEqual((Object) this.summarySectionStyle, (Object) addressSummaryComponentViewStyle.summarySectionStyle) && Intrinsics.areEqual((Object) this.modifier, (Object) addressSummaryComponentViewStyle.modifier);
    }

    @NotNull
    public final InternalButtonViewStyle getAddAddressButtonStyle() {
        return this.addAddressButtonStyle;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Nullable
    public final TextLabelViewStyle getSubTitleStyle() {
        return this.subTitleStyle;
    }

    @NotNull
    public final AddressSummarySectionViewStyle getSummarySectionStyle() {
        return this.summarySectionStyle;
    }

    @Nullable
    public final TextLabelViewStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        TextLabelViewStyle textLabelViewStyle = this.titleStyle;
        int i11 = 0;
        int hashCode = (textLabelViewStyle == null ? 0 : textLabelViewStyle.hashCode()) * 31;
        TextLabelViewStyle textLabelViewStyle2 = this.subTitleStyle;
        if (textLabelViewStyle2 != null) {
            i11 = textLabelViewStyle2.hashCode();
        }
        return ((((((hashCode + i11) * 31) + this.addAddressButtonStyle.hashCode()) * 31) + this.summarySectionStyle.hashCode()) * 31) + this.modifier.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelViewStyle textLabelViewStyle = this.titleStyle;
        TextLabelViewStyle textLabelViewStyle2 = this.subTitleStyle;
        InternalButtonViewStyle internalButtonViewStyle = this.addAddressButtonStyle;
        AddressSummarySectionViewStyle addressSummarySectionViewStyle = this.summarySectionStyle;
        Modifier modifier2 = this.modifier;
        return "AddressSummaryComponentViewStyle(titleStyle=" + textLabelViewStyle + ", subTitleStyle=" + textLabelViewStyle2 + ", addAddressButtonStyle=" + internalButtonViewStyle + ", summarySectionStyle=" + addressSummarySectionViewStyle + ", modifier=" + modifier2 + ")";
    }
}
