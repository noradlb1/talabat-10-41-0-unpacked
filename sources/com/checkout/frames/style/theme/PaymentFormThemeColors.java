package com.checkout.frames.style.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.theme.colors.CursorColors;
import com.checkout.frames.style.theme.colors.DividerColor;
import com.checkout.frames.style.theme.colors.ImageColors;
import com.checkout.frames.style.theme.colors.InputFieldColors;
import com.checkout.frames.style.theme.colors.PaymentFormButtonColors;
import com.checkout.frames.style.theme.colors.PaymentFormColors;
import com.checkout.frames.style.theme.colors.TextColors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nB=\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003J\t\u0010+\u001a\u00020\u0012HÆ\u0003J\t\u0010,\u001a\u00020\u0014HÆ\u0003J\t\u0010-\u001a\u00020\u0016HÆ\u0003J\t\u0010.\u001a\u00020\u0018HÆ\u0003JO\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00067"}, d2 = {"Lcom/checkout/frames/style/theme/PaymentFormThemeColors;", "", "accentColor", "", "textColor", "errorColor", "backgroundColor", "fieldBackgroundColor", "enabledButtonColor", "disabledButtonColor", "(JJJJJJJ)V", "paymentFormColors", "Lcom/checkout/frames/style/theme/colors/PaymentFormColors;", "buttonColors", "Lcom/checkout/frames/style/theme/colors/PaymentFormButtonColors;", "cursorColors", "Lcom/checkout/frames/style/theme/colors/CursorColors;", "dividerColor", "Lcom/checkout/frames/style/theme/colors/DividerColor;", "imageColors", "Lcom/checkout/frames/style/theme/colors/ImageColors;", "textColors", "Lcom/checkout/frames/style/theme/colors/TextColors;", "inputFieldColors", "Lcom/checkout/frames/style/theme/colors/InputFieldColors;", "(Lcom/checkout/frames/style/theme/colors/PaymentFormColors;Lcom/checkout/frames/style/theme/colors/PaymentFormButtonColors;Lcom/checkout/frames/style/theme/colors/CursorColors;Lcom/checkout/frames/style/theme/colors/DividerColor;Lcom/checkout/frames/style/theme/colors/ImageColors;Lcom/checkout/frames/style/theme/colors/TextColors;Lcom/checkout/frames/style/theme/colors/InputFieldColors;)V", "getButtonColors", "()Lcom/checkout/frames/style/theme/colors/PaymentFormButtonColors;", "getCursorColors", "()Lcom/checkout/frames/style/theme/colors/CursorColors;", "getDividerColor", "()Lcom/checkout/frames/style/theme/colors/DividerColor;", "getImageColors", "()Lcom/checkout/frames/style/theme/colors/ImageColors;", "getInputFieldColors", "()Lcom/checkout/frames/style/theme/colors/InputFieldColors;", "getPaymentFormColors", "()Lcom/checkout/frames/style/theme/colors/PaymentFormColors;", "getTextColors", "()Lcom/checkout/frames/style/theme/colors/TextColors;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormThemeColors {
    public static final int $stable = 0;
    @NotNull
    private final PaymentFormButtonColors buttonColors;
    @NotNull
    private final CursorColors cursorColors;
    @NotNull
    private final DividerColor dividerColor;
    @NotNull
    private final ImageColors imageColors;
    @NotNull
    private final InputFieldColors inputFieldColors;
    @NotNull
    private final PaymentFormColors paymentFormColors;
    @NotNull
    private final TextColors textColors;

    public PaymentFormThemeColors(@NotNull PaymentFormColors paymentFormColors2, @NotNull PaymentFormButtonColors paymentFormButtonColors, @NotNull CursorColors cursorColors2, @NotNull DividerColor dividerColor2, @NotNull ImageColors imageColors2, @NotNull TextColors textColors2, @NotNull InputFieldColors inputFieldColors2) {
        Intrinsics.checkNotNullParameter(paymentFormColors2, "paymentFormColors");
        Intrinsics.checkNotNullParameter(paymentFormButtonColors, "buttonColors");
        Intrinsics.checkNotNullParameter(cursorColors2, "cursorColors");
        Intrinsics.checkNotNullParameter(dividerColor2, "dividerColor");
        Intrinsics.checkNotNullParameter(imageColors2, "imageColors");
        Intrinsics.checkNotNullParameter(textColors2, "textColors");
        Intrinsics.checkNotNullParameter(inputFieldColors2, "inputFieldColors");
        this.paymentFormColors = paymentFormColors2;
        this.buttonColors = paymentFormButtonColors;
        this.cursorColors = cursorColors2;
        this.dividerColor = dividerColor2;
        this.imageColors = imageColors2;
        this.textColors = textColors2;
        this.inputFieldColors = inputFieldColors2;
    }

    public static /* synthetic */ PaymentFormThemeColors copy$default(PaymentFormThemeColors paymentFormThemeColors, PaymentFormColors paymentFormColors2, PaymentFormButtonColors paymentFormButtonColors, CursorColors cursorColors2, DividerColor dividerColor2, ImageColors imageColors2, TextColors textColors2, InputFieldColors inputFieldColors2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paymentFormColors2 = paymentFormThemeColors.paymentFormColors;
        }
        if ((i11 & 2) != 0) {
            paymentFormButtonColors = paymentFormThemeColors.buttonColors;
        }
        PaymentFormButtonColors paymentFormButtonColors2 = paymentFormButtonColors;
        if ((i11 & 4) != 0) {
            cursorColors2 = paymentFormThemeColors.cursorColors;
        }
        CursorColors cursorColors3 = cursorColors2;
        if ((i11 & 8) != 0) {
            dividerColor2 = paymentFormThemeColors.dividerColor;
        }
        DividerColor dividerColor3 = dividerColor2;
        if ((i11 & 16) != 0) {
            imageColors2 = paymentFormThemeColors.imageColors;
        }
        ImageColors imageColors3 = imageColors2;
        if ((i11 & 32) != 0) {
            textColors2 = paymentFormThemeColors.textColors;
        }
        TextColors textColors3 = textColors2;
        if ((i11 & 64) != 0) {
            inputFieldColors2 = paymentFormThemeColors.inputFieldColors;
        }
        return paymentFormThemeColors.copy(paymentFormColors2, paymentFormButtonColors2, cursorColors3, dividerColor3, imageColors3, textColors3, inputFieldColors2);
    }

    @NotNull
    public final PaymentFormColors component1() {
        return this.paymentFormColors;
    }

    @NotNull
    public final PaymentFormButtonColors component2() {
        return this.buttonColors;
    }

    @NotNull
    public final CursorColors component3() {
        return this.cursorColors;
    }

    @NotNull
    public final DividerColor component4() {
        return this.dividerColor;
    }

    @NotNull
    public final ImageColors component5() {
        return this.imageColors;
    }

    @NotNull
    public final TextColors component6() {
        return this.textColors;
    }

    @NotNull
    public final InputFieldColors component7() {
        return this.inputFieldColors;
    }

    @NotNull
    public final PaymentFormThemeColors copy(@NotNull PaymentFormColors paymentFormColors2, @NotNull PaymentFormButtonColors paymentFormButtonColors, @NotNull CursorColors cursorColors2, @NotNull DividerColor dividerColor2, @NotNull ImageColors imageColors2, @NotNull TextColors textColors2, @NotNull InputFieldColors inputFieldColors2) {
        Intrinsics.checkNotNullParameter(paymentFormColors2, "paymentFormColors");
        Intrinsics.checkNotNullParameter(paymentFormButtonColors, "buttonColors");
        Intrinsics.checkNotNullParameter(cursorColors2, "cursorColors");
        Intrinsics.checkNotNullParameter(dividerColor2, "dividerColor");
        Intrinsics.checkNotNullParameter(imageColors2, "imageColors");
        Intrinsics.checkNotNullParameter(textColors2, "textColors");
        InputFieldColors inputFieldColors3 = inputFieldColors2;
        Intrinsics.checkNotNullParameter(inputFieldColors3, "inputFieldColors");
        return new PaymentFormThemeColors(paymentFormColors2, paymentFormButtonColors, cursorColors2, dividerColor2, imageColors2, textColors2, inputFieldColors3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormThemeColors)) {
            return false;
        }
        PaymentFormThemeColors paymentFormThemeColors = (PaymentFormThemeColors) obj;
        return Intrinsics.areEqual((Object) this.paymentFormColors, (Object) paymentFormThemeColors.paymentFormColors) && Intrinsics.areEqual((Object) this.buttonColors, (Object) paymentFormThemeColors.buttonColors) && Intrinsics.areEqual((Object) this.cursorColors, (Object) paymentFormThemeColors.cursorColors) && Intrinsics.areEqual((Object) this.dividerColor, (Object) paymentFormThemeColors.dividerColor) && Intrinsics.areEqual((Object) this.imageColors, (Object) paymentFormThemeColors.imageColors) && Intrinsics.areEqual((Object) this.textColors, (Object) paymentFormThemeColors.textColors) && Intrinsics.areEqual((Object) this.inputFieldColors, (Object) paymentFormThemeColors.inputFieldColors);
    }

    @NotNull
    public final PaymentFormButtonColors getButtonColors() {
        return this.buttonColors;
    }

    @NotNull
    public final CursorColors getCursorColors() {
        return this.cursorColors;
    }

    @NotNull
    public final DividerColor getDividerColor() {
        return this.dividerColor;
    }

    @NotNull
    public final ImageColors getImageColors() {
        return this.imageColors;
    }

    @NotNull
    public final InputFieldColors getInputFieldColors() {
        return this.inputFieldColors;
    }

    @NotNull
    public final PaymentFormColors getPaymentFormColors() {
        return this.paymentFormColors;
    }

    @NotNull
    public final TextColors getTextColors() {
        return this.textColors;
    }

    public int hashCode() {
        return (((((((((((this.paymentFormColors.hashCode() * 31) + this.buttonColors.hashCode()) * 31) + this.cursorColors.hashCode()) * 31) + this.dividerColor.hashCode()) * 31) + this.imageColors.hashCode()) * 31) + this.textColors.hashCode()) * 31) + this.inputFieldColors.hashCode();
    }

    @NotNull
    public String toString() {
        PaymentFormColors paymentFormColors2 = this.paymentFormColors;
        PaymentFormButtonColors paymentFormButtonColors = this.buttonColors;
        CursorColors cursorColors2 = this.cursorColors;
        DividerColor dividerColor2 = this.dividerColor;
        ImageColors imageColors2 = this.imageColors;
        TextColors textColors2 = this.textColors;
        InputFieldColors inputFieldColors2 = this.inputFieldColors;
        return "PaymentFormThemeColors(paymentFormColors=" + paymentFormColors2 + ", buttonColors=" + paymentFormButtonColors + ", cursorColors=" + cursorColors2 + ", dividerColor=" + dividerColor2 + ", imageColors=" + imageColors2 + ", textColors=" + textColors2 + ", inputFieldColors=" + inputFieldColors2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentFormThemeColors(long r35, long r37, long r39, long r41, long r43, long r45, long r47) {
        /*
            r34 = this;
            r9 = r41
            r12 = r35
            r16 = r37
            r14 = r37
            r18 = r39
            r20 = r43
            com.checkout.frames.style.theme.colors.PaymentFormColors r11 = new com.checkout.frames.style.theme.colors.PaymentFormColors
            r11.<init>(r9)
            com.checkout.frames.style.theme.colors.PaymentFormButtonColors r32 = new com.checkout.frames.style.theme.colors.PaymentFormButtonColors
            r0 = r32
            r1 = r35
            r3 = r47
            r5 = r45
            r7 = r37
            r0.<init>(r1, r3, r5, r7)
            com.checkout.frames.style.theme.colors.CursorColors r33 = new com.checkout.frames.style.theme.colors.CursorColors
            r0 = r33
            r3 = r39
            r5 = r35
            r7 = r41
            r0.<init>(r1, r3, r5, r7)
            com.checkout.frames.style.theme.colors.DividerColor r0 = new com.checkout.frames.style.theme.colors.DividerColor
            r0.<init>(r9)
            com.checkout.frames.style.theme.colors.ImageColors r1 = new com.checkout.frames.style.theme.colors.ImageColors
            java.lang.Long r2 = java.lang.Long.valueOf(r35)
            r1.<init>(r2)
            com.checkout.frames.style.theme.colors.TextColors r2 = new com.checkout.frames.style.theme.colors.TextColors
            r22 = r2
            r23 = r35
            r25 = r37
            r27 = r37
            r29 = r39
            r22.<init>(r23, r25, r27, r29)
            com.checkout.frames.style.theme.colors.InputFieldColors r3 = new com.checkout.frames.style.theme.colors.InputFieldColors
            r4 = r11
            r11 = r3
            r22 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            r30 = 480(0x1e0, float:6.73E-43)
            r31 = 0
            r11.<init>(r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r31)
            r35 = r34
            r36 = r4
            r37 = r32
            r38 = r33
            r39 = r0
            r40 = r1
            r41 = r2
            r42 = r3
            r35.<init>((com.checkout.frames.style.theme.colors.PaymentFormColors) r36, (com.checkout.frames.style.theme.colors.PaymentFormButtonColors) r37, (com.checkout.frames.style.theme.colors.CursorColors) r38, (com.checkout.frames.style.theme.colors.DividerColor) r39, (com.checkout.frames.style.theme.colors.ImageColors) r40, (com.checkout.frames.style.theme.colors.TextColors) r41, (com.checkout.frames.style.theme.colors.InputFieldColors) r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.theme.PaymentFormThemeColors.<init>(long, long, long, long, long, long, long):void");
    }
}
