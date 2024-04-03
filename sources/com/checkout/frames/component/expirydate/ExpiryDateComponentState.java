package com.checkout.frames.component.expirydate;

import androidx.compose.runtime.MutableState;
import com.checkout.frames.component.base.InputComponentState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/checkout/frames/component/expirydate/ExpiryDateComponentState;", "", "inputState", "Lcom/checkout/frames/component/base/InputComponentState;", "(Lcom/checkout/frames/component/base/InputComponentState;)V", "expiryDate", "Landroidx/compose/runtime/MutableState;", "", "getExpiryDate", "()Landroidx/compose/runtime/MutableState;", "expiryDateMaxLength", "", "getExpiryDateMaxLength", "getInputState", "()Lcom/checkout/frames/component/base/InputComponentState;", "component1", "copy", "equals", "", "other", "hashCode", "hideError", "", "showError", "errorMessageId", "switchErrorVisibility", "isVisible", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateComponentState {
    @NotNull
    private final MutableState<String> expiryDate;
    @NotNull
    private final MutableState<Integer> expiryDateMaxLength;
    @NotNull
    private final InputComponentState inputState;

    public ExpiryDateComponentState(@NotNull InputComponentState inputComponentState) {
        Intrinsics.checkNotNullParameter(inputComponentState, "inputState");
        this.inputState = inputComponentState;
        this.expiryDate = inputComponentState.getInputFieldState().getText();
        this.expiryDateMaxLength = inputComponentState.getInputFieldState().getMaxLength();
    }

    public static /* synthetic */ ExpiryDateComponentState copy$default(ExpiryDateComponentState expiryDateComponentState, InputComponentState inputComponentState, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputComponentState = expiryDateComponentState.inputState;
        }
        return expiryDateComponentState.copy(inputComponentState);
    }

    private final void switchErrorVisibility(boolean z11) {
        this.inputState.getInputFieldState().isError().setValue(Boolean.valueOf(z11));
        this.inputState.getErrorState().isVisible().setValue(Boolean.valueOf(z11));
    }

    @NotNull
    public final InputComponentState component1() {
        return this.inputState;
    }

    @NotNull
    public final ExpiryDateComponentState copy(@NotNull InputComponentState inputComponentState) {
        Intrinsics.checkNotNullParameter(inputComponentState, "inputState");
        return new ExpiryDateComponentState(inputComponentState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExpiryDateComponentState) && Intrinsics.areEqual((Object) this.inputState, (Object) ((ExpiryDateComponentState) obj).inputState);
    }

    @NotNull
    public final MutableState<String> getExpiryDate() {
        return this.expiryDate;
    }

    @NotNull
    public final MutableState<Integer> getExpiryDateMaxLength() {
        return this.expiryDateMaxLength;
    }

    @NotNull
    public final InputComponentState getInputState() {
        return this.inputState;
    }

    public int hashCode() {
        return this.inputState.hashCode();
    }

    public final void hideError() {
        switchErrorVisibility(false);
    }

    public final void showError(int i11) {
        this.inputState.getErrorState().getTextId().setValue(Integer.valueOf(i11));
        switchErrorVisibility(true);
    }

    @NotNull
    public String toString() {
        InputComponentState inputComponentState = this.inputState;
        return "ExpiryDateComponentState(inputState=" + inputComponentState + ")";
    }
}
