package com.checkout.frames.component.cardscheme;

import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;", "", "textLabelState", "Lcom/checkout/frames/view/TextLabelState;", "(Lcom/checkout/frames/view/TextLabelState;)V", "getTextLabelState", "()Lcom/checkout/frames/view/TextLabelState;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentState {
    @Nullable
    private final TextLabelState textLabelState;

    public CardSchemeComponentState() {
        this((TextLabelState) null, 1, (DefaultConstructorMarker) null);
    }

    public CardSchemeComponentState(@Nullable TextLabelState textLabelState2) {
        this.textLabelState = textLabelState2;
    }

    public static /* synthetic */ CardSchemeComponentState copy$default(CardSchemeComponentState cardSchemeComponentState, TextLabelState textLabelState2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelState2 = cardSchemeComponentState.textLabelState;
        }
        return cardSchemeComponentState.copy(textLabelState2);
    }

    @Nullable
    public final TextLabelState component1() {
        return this.textLabelState;
    }

    @NotNull
    public final CardSchemeComponentState copy(@Nullable TextLabelState textLabelState2) {
        return new CardSchemeComponentState(textLabelState2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CardSchemeComponentState) && Intrinsics.areEqual((Object) this.textLabelState, (Object) ((CardSchemeComponentState) obj).textLabelState);
    }

    @Nullable
    public final TextLabelState getTextLabelState() {
        return this.textLabelState;
    }

    public int hashCode() {
        TextLabelState textLabelState2 = this.textLabelState;
        if (textLabelState2 == null) {
            return 0;
        }
        return textLabelState2.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelState textLabelState2 = this.textLabelState;
        return "CardSchemeComponentState(textLabelState=" + textLabelState2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardSchemeComponentState(TextLabelState textLabelState2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : textLabelState2);
    }
}
