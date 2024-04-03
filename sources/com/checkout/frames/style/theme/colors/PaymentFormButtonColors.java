package com.checkout.frames.style.theme.colors;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/theme/colors/PaymentFormButtonColors;", "", "containerColor", "", "disabledContainerColor", "contentColor", "disabledContentColor", "(JJJJ)V", "getContainerColor", "()J", "getContentColor", "getDisabledContainerColor", "getDisabledContentColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormButtonColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    @JvmOverloads
    public PaymentFormButtonColors() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PaymentFormButtonColors(long j11) {
        this(j11, 0, 0, 0, 14, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PaymentFormButtonColors(long j11, long j12) {
        this(j11, j12, 0, 0, 12, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PaymentFormButtonColors(long j11, long j12, long j13) {
        this(j11, j12, j13, 0, 8, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PaymentFormButtonColors(long j11, long j12, long j13, long j14) {
        this.containerColor = j11;
        this.disabledContainerColor = j12;
        this.contentColor = j13;
        this.disabledContentColor = j14;
    }

    public static /* synthetic */ PaymentFormButtonColors copy$default(PaymentFormButtonColors paymentFormButtonColors, long j11, long j12, long j13, long j14, int i11, Object obj) {
        PaymentFormButtonColors paymentFormButtonColors2 = paymentFormButtonColors;
        return paymentFormButtonColors.copy((i11 & 1) != 0 ? paymentFormButtonColors2.containerColor : j11, (i11 & 2) != 0 ? paymentFormButtonColors2.disabledContainerColor : j12, (i11 & 4) != 0 ? paymentFormButtonColors2.contentColor : j13, (i11 & 8) != 0 ? paymentFormButtonColors2.disabledContentColor : j14);
    }

    public final long component1() {
        return this.containerColor;
    }

    public final long component2() {
        return this.disabledContainerColor;
    }

    public final long component3() {
        return this.contentColor;
    }

    public final long component4() {
        return this.disabledContentColor;
    }

    @NotNull
    public final PaymentFormButtonColors copy(long j11, long j12, long j13, long j14) {
        return new PaymentFormButtonColors(j11, j12, j13, j14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormButtonColors)) {
            return false;
        }
        PaymentFormButtonColors paymentFormButtonColors = (PaymentFormButtonColors) obj;
        return this.containerColor == paymentFormButtonColors.containerColor && this.disabledContainerColor == paymentFormButtonColors.disabledContainerColor && this.contentColor == paymentFormButtonColors.contentColor && this.disabledContentColor == paymentFormButtonColors.disabledContentColor;
    }

    public final long getContainerColor() {
        return this.containerColor;
    }

    public final long getContentColor() {
        return this.contentColor;
    }

    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    public final long getDisabledContentColor() {
        return this.disabledContentColor;
    }

    public int hashCode() {
        return (((((a.a(this.containerColor) * 31) + a.a(this.disabledContainerColor)) * 31) + a.a(this.contentColor)) * 31) + a.a(this.disabledContentColor);
    }

    @NotNull
    public String toString() {
        long j11 = this.containerColor;
        long j12 = this.disabledContainerColor;
        long j13 = this.contentColor;
        long j14 = this.disabledContentColor;
        return "PaymentFormButtonColors(containerColor=" + j11 + ", disabledContainerColor=" + j12 + ", contentColor=" + j13 + ", disabledContentColor=" + j14 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentFormButtonColors(long r9, long r11, long r13, long r15, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L_0x000a
            r0 = 4278935536(0xff0b5ff0, double:2.114075049E-314)
            goto L_0x000b
        L_0x000a:
            r0 = r9
        L_0x000b:
            r2 = r17 & 2
            if (r2 == 0) goto L_0x0015
            r2 = 4291611852(0xffcccccc, double:2.1203379814E-314)
            goto L_0x0016
        L_0x0015:
            r2 = r11
        L_0x0016:
            r4 = r17 & 4
            if (r4 == 0) goto L_0x0020
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            goto L_0x0021
        L_0x0020:
            r4 = r13
        L_0x0021:
            r6 = r17 & 8
            if (r6 == 0) goto L_0x002b
            r6 = 4278190080(0xff000000, double:2.113706745E-314)
            goto L_0x002c
        L_0x002b:
            r6 = r15
        L_0x002c:
            r9 = r8
            r10 = r0
            r12 = r2
            r14 = r4
            r16 = r6
            r9.<init>(r10, r12, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.theme.colors.PaymentFormButtonColors.<init>(long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
