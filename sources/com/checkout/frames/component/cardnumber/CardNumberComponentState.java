package com.checkout.frames.component.cardnumber;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import com.checkout.base.model.CardScheme;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\rHÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\t\u0010 \u001a\u00020\tHÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/checkout/frames/component/cardnumber/CardNumberComponentState;", "", "inputState", "Lcom/checkout/frames/component/base/InputComponentState;", "cardScheme", "Landroidx/compose/runtime/MutableState;", "Lcom/checkout/base/model/CardScheme;", "(Lcom/checkout/frames/component/base/InputComponentState;Landroidx/compose/runtime/MutableState;)V", "cardNumber", "", "getCardNumber", "()Landroidx/compose/runtime/MutableState;", "cardNumberLength", "", "getCardNumberLength", "getCardScheme", "getInputState", "()Lcom/checkout/frames/component/base/InputComponentState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "hideError", "", "showError", "errorMessageId", "errorMessage", "switchErrorVisibility", "isVisible", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberComponentState {
    @NotNull
    private final MutableState<String> cardNumber;
    @NotNull
    private final MutableState<Integer> cardNumberLength;
    @NotNull
    private final MutableState<CardScheme> cardScheme;
    @NotNull
    private final InputComponentState inputState;

    public CardNumberComponentState(@NotNull InputComponentState inputComponentState, @NotNull MutableState<CardScheme> mutableState) {
        Intrinsics.checkNotNullParameter(inputComponentState, "inputState");
        Intrinsics.checkNotNullParameter(mutableState, "cardScheme");
        this.inputState = inputComponentState;
        this.cardScheme = mutableState;
        this.cardNumber = inputComponentState.getInputFieldState().getText();
        this.cardNumberLength = inputComponentState.getInputFieldState().getMaxLength();
    }

    public static /* synthetic */ CardNumberComponentState copy$default(CardNumberComponentState cardNumberComponentState, InputComponentState inputComponentState, MutableState<CardScheme> mutableState, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputComponentState = cardNumberComponentState.inputState;
        }
        if ((i11 & 2) != 0) {
            mutableState = cardNumberComponentState.cardScheme;
        }
        return cardNumberComponentState.copy(inputComponentState, mutableState);
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
    public final MutableState<CardScheme> component2() {
        return this.cardScheme;
    }

    @NotNull
    public final CardNumberComponentState copy(@NotNull InputComponentState inputComponentState, @NotNull MutableState<CardScheme> mutableState) {
        Intrinsics.checkNotNullParameter(inputComponentState, "inputState");
        Intrinsics.checkNotNullParameter(mutableState, "cardScheme");
        return new CardNumberComponentState(inputComponentState, mutableState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardNumberComponentState)) {
            return false;
        }
        CardNumberComponentState cardNumberComponentState = (CardNumberComponentState) obj;
        return Intrinsics.areEqual((Object) this.inputState, (Object) cardNumberComponentState.inputState) && Intrinsics.areEqual((Object) this.cardScheme, (Object) cardNumberComponentState.cardScheme);
    }

    @NotNull
    public final MutableState<String> getCardNumber() {
        return this.cardNumber;
    }

    @NotNull
    public final MutableState<Integer> getCardNumberLength() {
        return this.cardNumberLength;
    }

    @NotNull
    public final MutableState<CardScheme> getCardScheme() {
        return this.cardScheme;
    }

    @NotNull
    public final InputComponentState getInputState() {
        return this.inputState;
    }

    public int hashCode() {
        return (this.inputState.hashCode() * 31) + this.cardScheme.hashCode();
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
        MutableState<CardScheme> mutableState = this.cardScheme;
        return "CardNumberComponentState(inputState=" + inputComponentState + ", cardScheme=" + mutableState + ")";
    }

    public final void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        TextLabelState errorState = this.inputState.getErrorState();
        errorState.getText().setValue(str);
        errorState.getTextId().setValue(null);
        switchErrorVisibility(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberComponentState(InputComponentState inputComponentState, MutableState mutableState, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputComponentState, (i11 & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CardScheme.UNKNOWN, (SnapshotMutationPolicy) null, 2, (Object) null) : mutableState);
    }
}
