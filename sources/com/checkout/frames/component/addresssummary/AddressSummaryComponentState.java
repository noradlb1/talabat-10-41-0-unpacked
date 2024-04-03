package com.checkout.frames.component.addresssummary;

import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/checkout/frames/component/addresssummary/AddressSummaryComponentState;", "", "titleState", "Lcom/checkout/frames/view/TextLabelState;", "subTitleState", "addressPreviewState", "editAddressButtonState", "Lcom/checkout/frames/view/InternalButtonState;", "addAddressButtonState", "(Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/InternalButtonState;Lcom/checkout/frames/view/InternalButtonState;)V", "getAddAddressButtonState", "()Lcom/checkout/frames/view/InternalButtonState;", "getAddressPreviewState", "()Lcom/checkout/frames/view/TextLabelState;", "getEditAddressButtonState", "getSubTitleState", "getTitleState", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentState {
    @NotNull
    private final InternalButtonState addAddressButtonState;
    @NotNull
    private final TextLabelState addressPreviewState;
    @NotNull
    private final InternalButtonState editAddressButtonState;
    @NotNull
    private final TextLabelState subTitleState;
    @NotNull
    private final TextLabelState titleState;

    public AddressSummaryComponentState(@NotNull TextLabelState textLabelState, @NotNull TextLabelState textLabelState2, @NotNull TextLabelState textLabelState3, @NotNull InternalButtonState internalButtonState, @NotNull InternalButtonState internalButtonState2) {
        Intrinsics.checkNotNullParameter(textLabelState, "titleState");
        Intrinsics.checkNotNullParameter(textLabelState2, "subTitleState");
        Intrinsics.checkNotNullParameter(textLabelState3, "addressPreviewState");
        Intrinsics.checkNotNullParameter(internalButtonState, "editAddressButtonState");
        Intrinsics.checkNotNullParameter(internalButtonState2, "addAddressButtonState");
        this.titleState = textLabelState;
        this.subTitleState = textLabelState2;
        this.addressPreviewState = textLabelState3;
        this.editAddressButtonState = internalButtonState;
        this.addAddressButtonState = internalButtonState2;
    }

    public static /* synthetic */ AddressSummaryComponentState copy$default(AddressSummaryComponentState addressSummaryComponentState, TextLabelState textLabelState, TextLabelState textLabelState2, TextLabelState textLabelState3, InternalButtonState internalButtonState, InternalButtonState internalButtonState2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelState = addressSummaryComponentState.titleState;
        }
        if ((i11 & 2) != 0) {
            textLabelState2 = addressSummaryComponentState.subTitleState;
        }
        TextLabelState textLabelState4 = textLabelState2;
        if ((i11 & 4) != 0) {
            textLabelState3 = addressSummaryComponentState.addressPreviewState;
        }
        TextLabelState textLabelState5 = textLabelState3;
        if ((i11 & 8) != 0) {
            internalButtonState = addressSummaryComponentState.editAddressButtonState;
        }
        InternalButtonState internalButtonState3 = internalButtonState;
        if ((i11 & 16) != 0) {
            internalButtonState2 = addressSummaryComponentState.addAddressButtonState;
        }
        return addressSummaryComponentState.copy(textLabelState, textLabelState4, textLabelState5, internalButtonState3, internalButtonState2);
    }

    @NotNull
    public final TextLabelState component1() {
        return this.titleState;
    }

    @NotNull
    public final TextLabelState component2() {
        return this.subTitleState;
    }

    @NotNull
    public final TextLabelState component3() {
        return this.addressPreviewState;
    }

    @NotNull
    public final InternalButtonState component4() {
        return this.editAddressButtonState;
    }

    @NotNull
    public final InternalButtonState component5() {
        return this.addAddressButtonState;
    }

    @NotNull
    public final AddressSummaryComponentState copy(@NotNull TextLabelState textLabelState, @NotNull TextLabelState textLabelState2, @NotNull TextLabelState textLabelState3, @NotNull InternalButtonState internalButtonState, @NotNull InternalButtonState internalButtonState2) {
        Intrinsics.checkNotNullParameter(textLabelState, "titleState");
        Intrinsics.checkNotNullParameter(textLabelState2, "subTitleState");
        Intrinsics.checkNotNullParameter(textLabelState3, "addressPreviewState");
        Intrinsics.checkNotNullParameter(internalButtonState, "editAddressButtonState");
        Intrinsics.checkNotNullParameter(internalButtonState2, "addAddressButtonState");
        return new AddressSummaryComponentState(textLabelState, textLabelState2, textLabelState3, internalButtonState, internalButtonState2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressSummaryComponentState)) {
            return false;
        }
        AddressSummaryComponentState addressSummaryComponentState = (AddressSummaryComponentState) obj;
        return Intrinsics.areEqual((Object) this.titleState, (Object) addressSummaryComponentState.titleState) && Intrinsics.areEqual((Object) this.subTitleState, (Object) addressSummaryComponentState.subTitleState) && Intrinsics.areEqual((Object) this.addressPreviewState, (Object) addressSummaryComponentState.addressPreviewState) && Intrinsics.areEqual((Object) this.editAddressButtonState, (Object) addressSummaryComponentState.editAddressButtonState) && Intrinsics.areEqual((Object) this.addAddressButtonState, (Object) addressSummaryComponentState.addAddressButtonState);
    }

    @NotNull
    public final InternalButtonState getAddAddressButtonState() {
        return this.addAddressButtonState;
    }

    @NotNull
    public final TextLabelState getAddressPreviewState() {
        return this.addressPreviewState;
    }

    @NotNull
    public final InternalButtonState getEditAddressButtonState() {
        return this.editAddressButtonState;
    }

    @NotNull
    public final TextLabelState getSubTitleState() {
        return this.subTitleState;
    }

    @NotNull
    public final TextLabelState getTitleState() {
        return this.titleState;
    }

    public int hashCode() {
        return (((((((this.titleState.hashCode() * 31) + this.subTitleState.hashCode()) * 31) + this.addressPreviewState.hashCode()) * 31) + this.editAddressButtonState.hashCode()) * 31) + this.addAddressButtonState.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelState textLabelState = this.titleState;
        TextLabelState textLabelState2 = this.subTitleState;
        TextLabelState textLabelState3 = this.addressPreviewState;
        InternalButtonState internalButtonState = this.editAddressButtonState;
        InternalButtonState internalButtonState2 = this.addAddressButtonState;
        return "AddressSummaryComponentState(titleState=" + textLabelState + ", subTitleState=" + textLabelState2 + ", addressPreviewState=" + textLabelState3 + ", editAddressButtonState=" + internalButtonState + ", addAddressButtonState=" + internalButtonState2 + ")";
    }
}
