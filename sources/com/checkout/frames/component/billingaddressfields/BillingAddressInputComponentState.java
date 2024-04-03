package com.checkout.frames.component.billingaddressfields;

import androidx.compose.runtime.MutableState;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020 J\u000e\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0003J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\bH\u0002J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;", "", "addressFieldName", "", "inputComponentState", "Lcom/checkout/frames/component/base/InputComponentState;", "isAddressFieldValid", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "(Ljava/lang/String;Lcom/checkout/frames/component/base/InputComponentState;Lkotlinx/coroutines/flow/MutableStateFlow;)V", "getAddressFieldName", "()Ljava/lang/String;", "addressFieldText", "Landroidx/compose/runtime/MutableState;", "getAddressFieldText", "()Landroidx/compose/runtime/MutableState;", "getInputComponentState", "()Lcom/checkout/frames/component/base/InputComponentState;", "setInputComponentState", "(Lcom/checkout/frames/component/base/InputComponentState;)V", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isInputFieldOptional", "()Z", "setInputFieldOptional", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "hideError", "", "showError", "errorMessageId", "errorMessage", "switchErrorVisibility", "isVisible", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressInputComponentState {
    @NotNull
    private final String addressFieldName;
    @NotNull
    private final MutableState<String> addressFieldText;
    @NotNull
    private InputComponentState inputComponentState;
    @NotNull
    private final MutableStateFlow<Boolean> isAddressFieldValid;
    private boolean isInputFieldOptional;

    public BillingAddressInputComponentState(@NotNull String str, @NotNull InputComponentState inputComponentState2, @NotNull MutableStateFlow<Boolean> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        Intrinsics.checkNotNullParameter(inputComponentState2, "inputComponentState");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "isAddressFieldValid");
        this.addressFieldName = str;
        this.inputComponentState = inputComponentState2;
        this.isAddressFieldValid = mutableStateFlow;
        this.isInputFieldOptional = inputComponentState2.isInputFieldOptional();
        this.addressFieldText = this.inputComponentState.getInputFieldState().getText();
    }

    public static /* synthetic */ BillingAddressInputComponentState copy$default(BillingAddressInputComponentState billingAddressInputComponentState, String str, InputComponentState inputComponentState2, MutableStateFlow<Boolean> mutableStateFlow, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = billingAddressInputComponentState.addressFieldName;
        }
        if ((i11 & 2) != 0) {
            inputComponentState2 = billingAddressInputComponentState.inputComponentState;
        }
        if ((i11 & 4) != 0) {
            mutableStateFlow = billingAddressInputComponentState.isAddressFieldValid;
        }
        return billingAddressInputComponentState.copy(str, inputComponentState2, mutableStateFlow);
    }

    private final void switchErrorVisibility(boolean z11) {
        this.inputComponentState.getInputFieldState().isError().setValue(Boolean.valueOf(z11));
        this.inputComponentState.getErrorState().isVisible().setValue(Boolean.valueOf(z11));
    }

    @NotNull
    public final String component1() {
        return this.addressFieldName;
    }

    @NotNull
    public final InputComponentState component2() {
        return this.inputComponentState;
    }

    @NotNull
    public final MutableStateFlow<Boolean> component3() {
        return this.isAddressFieldValid;
    }

    @NotNull
    public final BillingAddressInputComponentState copy(@NotNull String str, @NotNull InputComponentState inputComponentState2, @NotNull MutableStateFlow<Boolean> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        Intrinsics.checkNotNullParameter(inputComponentState2, "inputComponentState");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "isAddressFieldValid");
        return new BillingAddressInputComponentState(str, inputComponentState2, mutableStateFlow);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingAddressInputComponentState)) {
            return false;
        }
        BillingAddressInputComponentState billingAddressInputComponentState = (BillingAddressInputComponentState) obj;
        return Intrinsics.areEqual((Object) this.addressFieldName, (Object) billingAddressInputComponentState.addressFieldName) && Intrinsics.areEqual((Object) this.inputComponentState, (Object) billingAddressInputComponentState.inputComponentState) && Intrinsics.areEqual((Object) this.isAddressFieldValid, (Object) billingAddressInputComponentState.isAddressFieldValid);
    }

    @NotNull
    public final String getAddressFieldName() {
        return this.addressFieldName;
    }

    @NotNull
    public final MutableState<String> getAddressFieldText() {
        return this.addressFieldText;
    }

    @NotNull
    public final InputComponentState getInputComponentState() {
        return this.inputComponentState;
    }

    public int hashCode() {
        return (((this.addressFieldName.hashCode() * 31) + this.inputComponentState.hashCode()) * 31) + this.isAddressFieldValid.hashCode();
    }

    public final void hideError() {
        switchErrorVisibility(false);
    }

    @NotNull
    public final MutableStateFlow<Boolean> isAddressFieldValid() {
        return this.isAddressFieldValid;
    }

    public final boolean isInputFieldOptional() {
        return this.isInputFieldOptional;
    }

    public final void setInputComponentState(@NotNull InputComponentState inputComponentState2) {
        Intrinsics.checkNotNullParameter(inputComponentState2, "<set-?>");
        this.inputComponentState = inputComponentState2;
    }

    public final void setInputFieldOptional(boolean z11) {
        this.isInputFieldOptional = z11;
    }

    public final void showError(int i11) {
        this.inputComponentState.getErrorState().getTextId().setValue(Integer.valueOf(i11));
        switchErrorVisibility(true);
    }

    @NotNull
    public String toString() {
        String str = this.addressFieldName;
        InputComponentState inputComponentState2 = this.inputComponentState;
        MutableStateFlow<Boolean> mutableStateFlow = this.isAddressFieldValid;
        return "BillingAddressInputComponentState(addressFieldName=" + str + ", inputComponentState=" + inputComponentState2 + ", isAddressFieldValid=" + mutableStateFlow + ")";
    }

    public final void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        TextLabelState errorState = this.inputComponentState.getErrorState();
        errorState.getText().setValue(str);
        errorState.getTextId().setValue(null);
        switchErrorVisibility(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingAddressInputComponentState(String str, InputComponentState inputComponentState2, MutableStateFlow mutableStateFlow, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, inputComponentState2, (i11 & 4) != 0 ? StateFlowKt.MutableStateFlow(Boolean.FALSE) : mutableStateFlow);
    }
}
