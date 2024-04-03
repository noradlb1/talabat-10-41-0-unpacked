package com.checkout.frames.style.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/checkout/frames/style/theme/PaymentFormTheme;", "", "paymentFormThemeColors", "Lcom/checkout/frames/style/theme/PaymentFormThemeColors;", "paymentFormComponents", "", "Lcom/checkout/frames/style/theme/PaymentFormComponent;", "paymentFormShape", "Lcom/checkout/frames/style/theme/PaymentFormShape;", "paymentFormCornerRadius", "Lcom/checkout/frames/style/theme/PaymentFormCornerRadius;", "paymentFormFont", "Lcom/checkout/frames/style/theme/PaymentFormFont;", "(Lcom/checkout/frames/style/theme/PaymentFormThemeColors;Ljava/util/List;Lcom/checkout/frames/style/theme/PaymentFormShape;Lcom/checkout/frames/style/theme/PaymentFormCornerRadius;Lcom/checkout/frames/style/theme/PaymentFormFont;)V", "getPaymentFormComponents", "()Ljava/util/List;", "getPaymentFormCornerRadius", "()Lcom/checkout/frames/style/theme/PaymentFormCornerRadius;", "getPaymentFormFont", "()Lcom/checkout/frames/style/theme/PaymentFormFont;", "getPaymentFormShape", "()Lcom/checkout/frames/style/theme/PaymentFormShape;", "getPaymentFormThemeColors", "()Lcom/checkout/frames/style/theme/PaymentFormThemeColors;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormTheme {
    public static final int $stable = 8;
    @NotNull
    private final List<PaymentFormComponent> paymentFormComponents;
    @NotNull
    private final PaymentFormCornerRadius paymentFormCornerRadius;
    @NotNull
    private final PaymentFormFont paymentFormFont;
    @NotNull
    private final PaymentFormShape paymentFormShape;
    @NotNull
    private final PaymentFormThemeColors paymentFormThemeColors;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormTheme(@NotNull PaymentFormThemeColors paymentFormThemeColors2) {
        this(paymentFormThemeColors2, (List) null, (PaymentFormShape) null, (PaymentFormCornerRadius) null, (PaymentFormFont) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(paymentFormThemeColors2, "paymentFormThemeColors");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormTheme(@NotNull PaymentFormThemeColors paymentFormThemeColors2, @NotNull List<PaymentFormComponent> list) {
        this(paymentFormThemeColors2, list, (PaymentFormShape) null, (PaymentFormCornerRadius) null, (PaymentFormFont) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(paymentFormThemeColors2, "paymentFormThemeColors");
        Intrinsics.checkNotNullParameter(list, "paymentFormComponents");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormTheme(@NotNull PaymentFormThemeColors paymentFormThemeColors2, @NotNull List<PaymentFormComponent> list, @NotNull PaymentFormShape paymentFormShape2) {
        this(paymentFormThemeColors2, list, paymentFormShape2, (PaymentFormCornerRadius) null, (PaymentFormFont) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(paymentFormThemeColors2, "paymentFormThemeColors");
        Intrinsics.checkNotNullParameter(list, "paymentFormComponents");
        Intrinsics.checkNotNullParameter(paymentFormShape2, "paymentFormShape");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormTheme(@NotNull PaymentFormThemeColors paymentFormThemeColors2, @NotNull List<PaymentFormComponent> list, @NotNull PaymentFormShape paymentFormShape2, @NotNull PaymentFormCornerRadius paymentFormCornerRadius2) {
        this(paymentFormThemeColors2, list, paymentFormShape2, paymentFormCornerRadius2, (PaymentFormFont) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(paymentFormThemeColors2, "paymentFormThemeColors");
        Intrinsics.checkNotNullParameter(list, "paymentFormComponents");
        Intrinsics.checkNotNullParameter(paymentFormShape2, "paymentFormShape");
        Intrinsics.checkNotNullParameter(paymentFormCornerRadius2, "paymentFormCornerRadius");
    }

    @JvmOverloads
    public PaymentFormTheme(@NotNull PaymentFormThemeColors paymentFormThemeColors2, @NotNull List<PaymentFormComponent> list, @NotNull PaymentFormShape paymentFormShape2, @NotNull PaymentFormCornerRadius paymentFormCornerRadius2, @NotNull PaymentFormFont paymentFormFont2) {
        Intrinsics.checkNotNullParameter(paymentFormThemeColors2, "paymentFormThemeColors");
        Intrinsics.checkNotNullParameter(list, "paymentFormComponents");
        Intrinsics.checkNotNullParameter(paymentFormShape2, "paymentFormShape");
        Intrinsics.checkNotNullParameter(paymentFormCornerRadius2, "paymentFormCornerRadius");
        Intrinsics.checkNotNullParameter(paymentFormFont2, "paymentFormFont");
        this.paymentFormThemeColors = paymentFormThemeColors2;
        this.paymentFormComponents = list;
        this.paymentFormShape = paymentFormShape2;
        this.paymentFormCornerRadius = paymentFormCornerRadius2;
        this.paymentFormFont = paymentFormFont2;
    }

    public static /* synthetic */ PaymentFormTheme copy$default(PaymentFormTheme paymentFormTheme, PaymentFormThemeColors paymentFormThemeColors2, List<PaymentFormComponent> list, PaymentFormShape paymentFormShape2, PaymentFormCornerRadius paymentFormCornerRadius2, PaymentFormFont paymentFormFont2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paymentFormThemeColors2 = paymentFormTheme.paymentFormThemeColors;
        }
        if ((i11 & 2) != 0) {
            list = paymentFormTheme.paymentFormComponents;
        }
        List<PaymentFormComponent> list2 = list;
        if ((i11 & 4) != 0) {
            paymentFormShape2 = paymentFormTheme.paymentFormShape;
        }
        PaymentFormShape paymentFormShape3 = paymentFormShape2;
        if ((i11 & 8) != 0) {
            paymentFormCornerRadius2 = paymentFormTheme.paymentFormCornerRadius;
        }
        PaymentFormCornerRadius paymentFormCornerRadius3 = paymentFormCornerRadius2;
        if ((i11 & 16) != 0) {
            paymentFormFont2 = paymentFormTheme.paymentFormFont;
        }
        return paymentFormTheme.copy(paymentFormThemeColors2, list2, paymentFormShape3, paymentFormCornerRadius3, paymentFormFont2);
    }

    @NotNull
    public final PaymentFormThemeColors component1() {
        return this.paymentFormThemeColors;
    }

    @NotNull
    public final List<PaymentFormComponent> component2() {
        return this.paymentFormComponents;
    }

    @NotNull
    public final PaymentFormShape component3() {
        return this.paymentFormShape;
    }

    @NotNull
    public final PaymentFormCornerRadius component4() {
        return this.paymentFormCornerRadius;
    }

    @NotNull
    public final PaymentFormFont component5() {
        return this.paymentFormFont;
    }

    @NotNull
    public final PaymentFormTheme copy(@NotNull PaymentFormThemeColors paymentFormThemeColors2, @NotNull List<PaymentFormComponent> list, @NotNull PaymentFormShape paymentFormShape2, @NotNull PaymentFormCornerRadius paymentFormCornerRadius2, @NotNull PaymentFormFont paymentFormFont2) {
        Intrinsics.checkNotNullParameter(paymentFormThemeColors2, "paymentFormThemeColors");
        Intrinsics.checkNotNullParameter(list, "paymentFormComponents");
        Intrinsics.checkNotNullParameter(paymentFormShape2, "paymentFormShape");
        Intrinsics.checkNotNullParameter(paymentFormCornerRadius2, "paymentFormCornerRadius");
        Intrinsics.checkNotNullParameter(paymentFormFont2, "paymentFormFont");
        return new PaymentFormTheme(paymentFormThemeColors2, list, paymentFormShape2, paymentFormCornerRadius2, paymentFormFont2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormTheme)) {
            return false;
        }
        PaymentFormTheme paymentFormTheme = (PaymentFormTheme) obj;
        return Intrinsics.areEqual((Object) this.paymentFormThemeColors, (Object) paymentFormTheme.paymentFormThemeColors) && Intrinsics.areEqual((Object) this.paymentFormComponents, (Object) paymentFormTheme.paymentFormComponents) && Intrinsics.areEqual((Object) this.paymentFormShape, (Object) paymentFormTheme.paymentFormShape) && Intrinsics.areEqual((Object) this.paymentFormCornerRadius, (Object) paymentFormTheme.paymentFormCornerRadius) && Intrinsics.areEqual((Object) this.paymentFormFont, (Object) paymentFormTheme.paymentFormFont);
    }

    @NotNull
    public final List<PaymentFormComponent> getPaymentFormComponents() {
        return this.paymentFormComponents;
    }

    @NotNull
    public final PaymentFormCornerRadius getPaymentFormCornerRadius() {
        return this.paymentFormCornerRadius;
    }

    @NotNull
    public final PaymentFormFont getPaymentFormFont() {
        return this.paymentFormFont;
    }

    @NotNull
    public final PaymentFormShape getPaymentFormShape() {
        return this.paymentFormShape;
    }

    @NotNull
    public final PaymentFormThemeColors getPaymentFormThemeColors() {
        return this.paymentFormThemeColors;
    }

    public int hashCode() {
        return (((((((this.paymentFormThemeColors.hashCode() * 31) + this.paymentFormComponents.hashCode()) * 31) + this.paymentFormShape.hashCode()) * 31) + this.paymentFormCornerRadius.hashCode()) * 31) + this.paymentFormFont.hashCode();
    }

    @NotNull
    public String toString() {
        PaymentFormThemeColors paymentFormThemeColors2 = this.paymentFormThemeColors;
        List<PaymentFormComponent> list = this.paymentFormComponents;
        PaymentFormShape paymentFormShape2 = this.paymentFormShape;
        PaymentFormCornerRadius paymentFormCornerRadius2 = this.paymentFormCornerRadius;
        PaymentFormFont paymentFormFont2 = this.paymentFormFont;
        return "PaymentFormTheme(paymentFormThemeColors=" + paymentFormThemeColors2 + ", paymentFormComponents=" + list + ", paymentFormShape=" + paymentFormShape2 + ", paymentFormCornerRadius=" + paymentFormCornerRadius2 + ", paymentFormFont=" + paymentFormFont2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentFormTheme(com.checkout.frames.style.theme.PaymentFormThemeColors r11, java.util.List r12, com.checkout.frames.style.theme.PaymentFormShape r13, com.checkout.frames.style.theme.PaymentFormCornerRadius r14, com.checkout.frames.style.theme.PaymentFormFont r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r10 = this;
            r0 = r16 & 2
            if (r0 == 0) goto L_0x000b
            com.checkout.frames.style.theme.DefaultPaymentFormTheme r0 = com.checkout.frames.style.theme.DefaultPaymentFormTheme.INSTANCE
            java.util.List r0 = r0.provideComponents()
            goto L_0x000c
        L_0x000b:
            r0 = r12
        L_0x000c:
            r1 = r16 & 4
            if (r1 == 0) goto L_0x001e
            com.checkout.frames.style.theme.PaymentFormShape r1 = new com.checkout.frames.style.theme.PaymentFormShape
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 15
            r8 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x001f
        L_0x001e:
            r1 = r13
        L_0x001f:
            r2 = r16 & 8
            if (r2 == 0) goto L_0x0031
            com.checkout.frames.style.theme.PaymentFormCornerRadius r2 = new com.checkout.frames.style.theme.PaymentFormCornerRadius
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 15
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L_0x0032
        L_0x0031:
            r2 = r14
        L_0x0032:
            r3 = r16 & 16
            if (r3 == 0) goto L_0x0049
            com.checkout.frames.style.theme.PaymentFormFont r3 = new com.checkout.frames.style.theme.PaymentFormFont
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r12.<init>(r13, r14, r15, r16, r17)
            goto L_0x004a
        L_0x0049:
            r3 = r15
        L_0x004a:
            r12 = r10
            r13 = r11
            r14 = r0
            r15 = r1
            r16 = r2
            r17 = r3
            r12.<init>(r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.theme.PaymentFormTheme.<init>(com.checkout.frames.style.theme.PaymentFormThemeColors, java.util.List, com.checkout.frames.style.theme.PaymentFormShape, com.checkout.frames.style.theme.PaymentFormCornerRadius, com.checkout.frames.style.theme.PaymentFormFont, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
