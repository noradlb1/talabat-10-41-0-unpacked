package com.checkout.frames.style.component;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "", "inputStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "cardNumberSeparator", "", "(Lcom/checkout/frames/style/component/base/InputComponentStyle;C)V", "getCardNumberSeparator", "()C", "setCardNumberSeparator", "(C)V", "getInputStyle", "()Lcom/checkout/frames/style/component/base/InputComponentStyle;", "setInputStyle", "(Lcom/checkout/frames/style/component/base/InputComponentStyle;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberComponentStyle {
    public static final int $stable = 8;
    private char cardNumberSeparator;
    @NotNull
    private InputComponentStyle inputStyle;

    @JvmOverloads
    public CardNumberComponentStyle() {
        this((InputComponentStyle) null, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardNumberComponentStyle(@NotNull InputComponentStyle inputComponentStyle) {
        this(inputComponentStyle, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
    }

    @JvmOverloads
    public CardNumberComponentStyle(@NotNull InputComponentStyle inputComponentStyle, char c11) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
        this.inputStyle = inputComponentStyle;
        this.cardNumberSeparator = c11;
    }

    public static /* synthetic */ CardNumberComponentStyle copy$default(CardNumberComponentStyle cardNumberComponentStyle, InputComponentStyle inputComponentStyle, char c11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputComponentStyle = cardNumberComponentStyle.inputStyle;
        }
        if ((i11 & 2) != 0) {
            c11 = cardNumberComponentStyle.cardNumberSeparator;
        }
        return cardNumberComponentStyle.copy(inputComponentStyle, c11);
    }

    @NotNull
    public final InputComponentStyle component1() {
        return this.inputStyle;
    }

    public final char component2() {
        return this.cardNumberSeparator;
    }

    @NotNull
    public final CardNumberComponentStyle copy(@NotNull InputComponentStyle inputComponentStyle, char c11) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
        return new CardNumberComponentStyle(inputComponentStyle, c11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardNumberComponentStyle)) {
            return false;
        }
        CardNumberComponentStyle cardNumberComponentStyle = (CardNumberComponentStyle) obj;
        return Intrinsics.areEqual((Object) this.inputStyle, (Object) cardNumberComponentStyle.inputStyle) && this.cardNumberSeparator == cardNumberComponentStyle.cardNumberSeparator;
    }

    public final char getCardNumberSeparator() {
        return this.cardNumberSeparator;
    }

    @NotNull
    public final InputComponentStyle getInputStyle() {
        return this.inputStyle;
    }

    public int hashCode() {
        return (this.inputStyle.hashCode() * 31) + this.cardNumberSeparator;
    }

    public final void setCardNumberSeparator(char c11) {
        this.cardNumberSeparator = c11;
    }

    public final void setInputStyle(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "<set-?>");
        this.inputStyle = inputComponentStyle;
    }

    @NotNull
    public String toString() {
        InputComponentStyle inputComponentStyle = this.inputStyle;
        char c11 = this.cardNumberSeparator;
        return "CardNumberComponentStyle(inputStyle=" + inputComponentStyle + ", cardNumberSeparator=" + c11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberComponentStyle(InputComponentStyle inputComponentStyle, char c11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new InputComponentStyle((TextLabelStyle) null, (TextLabelStyle) null, (TextLabelStyle) null, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 127, (DefaultConstructorMarker) null) : inputComponentStyle, (i11 & 2) != 0 ? ' ' : c11);
    }
}
