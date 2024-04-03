package com.checkout.frames.style.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.CornerRadius;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/theme/PaymentFormCornerRadius;", "", "inputFieldCornerRadius", "Lcom/checkout/frames/model/CornerRadius;", "addressSummaryCornerRadius", "buttonCornerRadius", "screenBackgroundCornerRadius", "(Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/CornerRadius;)V", "getAddressSummaryCornerRadius", "()Lcom/checkout/frames/model/CornerRadius;", "getButtonCornerRadius", "getInputFieldCornerRadius", "getScreenBackgroundCornerRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormCornerRadius {
    public static final int $stable = 0;
    @NotNull
    private final CornerRadius addressSummaryCornerRadius;
    @NotNull
    private final CornerRadius buttonCornerRadius;
    @NotNull
    private final CornerRadius inputFieldCornerRadius;
    @NotNull
    private final CornerRadius screenBackgroundCornerRadius;

    @JvmOverloads
    public PaymentFormCornerRadius() {
        this((CornerRadius) null, (CornerRadius) null, (CornerRadius) null, (CornerRadius) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormCornerRadius(@NotNull CornerRadius cornerRadius) {
        this(cornerRadius, (CornerRadius) null, (CornerRadius) null, (CornerRadius) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(cornerRadius, "inputFieldCornerRadius");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormCornerRadius(@NotNull CornerRadius cornerRadius, @NotNull CornerRadius cornerRadius2) {
        this(cornerRadius, cornerRadius2, (CornerRadius) null, (CornerRadius) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(cornerRadius, "inputFieldCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius2, "addressSummaryCornerRadius");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormCornerRadius(@NotNull CornerRadius cornerRadius, @NotNull CornerRadius cornerRadius2, @NotNull CornerRadius cornerRadius3) {
        this(cornerRadius, cornerRadius2, cornerRadius3, (CornerRadius) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(cornerRadius, "inputFieldCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius2, "addressSummaryCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius3, "buttonCornerRadius");
    }

    @JvmOverloads
    public PaymentFormCornerRadius(@NotNull CornerRadius cornerRadius, @NotNull CornerRadius cornerRadius2, @NotNull CornerRadius cornerRadius3, @NotNull CornerRadius cornerRadius4) {
        Intrinsics.checkNotNullParameter(cornerRadius, "inputFieldCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius2, "addressSummaryCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius3, "buttonCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius4, "screenBackgroundCornerRadius");
        this.inputFieldCornerRadius = cornerRadius;
        this.addressSummaryCornerRadius = cornerRadius2;
        this.buttonCornerRadius = cornerRadius3;
        this.screenBackgroundCornerRadius = cornerRadius4;
    }

    public static /* synthetic */ PaymentFormCornerRadius copy$default(PaymentFormCornerRadius paymentFormCornerRadius, CornerRadius cornerRadius, CornerRadius cornerRadius2, CornerRadius cornerRadius3, CornerRadius cornerRadius4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cornerRadius = paymentFormCornerRadius.inputFieldCornerRadius;
        }
        if ((i11 & 2) != 0) {
            cornerRadius2 = paymentFormCornerRadius.addressSummaryCornerRadius;
        }
        if ((i11 & 4) != 0) {
            cornerRadius3 = paymentFormCornerRadius.buttonCornerRadius;
        }
        if ((i11 & 8) != 0) {
            cornerRadius4 = paymentFormCornerRadius.screenBackgroundCornerRadius;
        }
        return paymentFormCornerRadius.copy(cornerRadius, cornerRadius2, cornerRadius3, cornerRadius4);
    }

    @NotNull
    public final CornerRadius component1() {
        return this.inputFieldCornerRadius;
    }

    @NotNull
    public final CornerRadius component2() {
        return this.addressSummaryCornerRadius;
    }

    @NotNull
    public final CornerRadius component3() {
        return this.buttonCornerRadius;
    }

    @NotNull
    public final CornerRadius component4() {
        return this.screenBackgroundCornerRadius;
    }

    @NotNull
    public final PaymentFormCornerRadius copy(@NotNull CornerRadius cornerRadius, @NotNull CornerRadius cornerRadius2, @NotNull CornerRadius cornerRadius3, @NotNull CornerRadius cornerRadius4) {
        Intrinsics.checkNotNullParameter(cornerRadius, "inputFieldCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius2, "addressSummaryCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius3, "buttonCornerRadius");
        Intrinsics.checkNotNullParameter(cornerRadius4, "screenBackgroundCornerRadius");
        return new PaymentFormCornerRadius(cornerRadius, cornerRadius2, cornerRadius3, cornerRadius4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormCornerRadius)) {
            return false;
        }
        PaymentFormCornerRadius paymentFormCornerRadius = (PaymentFormCornerRadius) obj;
        return Intrinsics.areEqual((Object) this.inputFieldCornerRadius, (Object) paymentFormCornerRadius.inputFieldCornerRadius) && Intrinsics.areEqual((Object) this.addressSummaryCornerRadius, (Object) paymentFormCornerRadius.addressSummaryCornerRadius) && Intrinsics.areEqual((Object) this.buttonCornerRadius, (Object) paymentFormCornerRadius.buttonCornerRadius) && Intrinsics.areEqual((Object) this.screenBackgroundCornerRadius, (Object) paymentFormCornerRadius.screenBackgroundCornerRadius);
    }

    @NotNull
    public final CornerRadius getAddressSummaryCornerRadius() {
        return this.addressSummaryCornerRadius;
    }

    @NotNull
    public final CornerRadius getButtonCornerRadius() {
        return this.buttonCornerRadius;
    }

    @NotNull
    public final CornerRadius getInputFieldCornerRadius() {
        return this.inputFieldCornerRadius;
    }

    @NotNull
    public final CornerRadius getScreenBackgroundCornerRadius() {
        return this.screenBackgroundCornerRadius;
    }

    public int hashCode() {
        return (((((this.inputFieldCornerRadius.hashCode() * 31) + this.addressSummaryCornerRadius.hashCode()) * 31) + this.buttonCornerRadius.hashCode()) * 31) + this.screenBackgroundCornerRadius.hashCode();
    }

    @NotNull
    public String toString() {
        CornerRadius cornerRadius = this.inputFieldCornerRadius;
        CornerRadius cornerRadius2 = this.addressSummaryCornerRadius;
        CornerRadius cornerRadius3 = this.buttonCornerRadius;
        CornerRadius cornerRadius4 = this.screenBackgroundCornerRadius;
        return "PaymentFormCornerRadius(inputFieldCornerRadius=" + cornerRadius + ", addressSummaryCornerRadius=" + cornerRadius2 + ", buttonCornerRadius=" + cornerRadius3 + ", screenBackgroundCornerRadius=" + cornerRadius4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFormCornerRadius(CornerRadius cornerRadius, CornerRadius cornerRadius2, CornerRadius cornerRadius3, CornerRadius cornerRadius4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new CornerRadius(0) : cornerRadius, (i11 & 2) != 0 ? new CornerRadius(8) : cornerRadius2, (i11 & 4) != 0 ? new CornerRadius(0, 0, 0, 0, 15, (DefaultConstructorMarker) null) : cornerRadius3, (i11 & 8) != 0 ? new CornerRadius(0) : cornerRadius4);
    }
}
