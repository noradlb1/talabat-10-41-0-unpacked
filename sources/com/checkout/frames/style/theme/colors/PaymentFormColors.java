package com.checkout.frames.style.theme.colors;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/style/theme/colors/PaymentFormColors;", "", "background", "", "(J)V", "getBackground", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormColors {
    public static final int $stable = 0;
    private final long background;

    @JvmOverloads
    public PaymentFormColors() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PaymentFormColors(long j11) {
        this.background = j11;
    }

    public static /* synthetic */ PaymentFormColors copy$default(PaymentFormColors paymentFormColors, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = paymentFormColors.background;
        }
        return paymentFormColors.copy(j11);
    }

    public final long component1() {
        return this.background;
    }

    @NotNull
    public final PaymentFormColors copy(long j11) {
        return new PaymentFormColors(j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaymentFormColors) && this.background == ((PaymentFormColors) obj).background;
    }

    public final long getBackground() {
        return this.background;
    }

    public int hashCode() {
        return a.a(this.background);
    }

    @NotNull
    public String toString() {
        long j11 = this.background;
        return "PaymentFormColors(background=" + j11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFormColors(long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : j11);
    }
}
