package com.checkout.frames.style.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/theme/PaymentFormShape;", "", "inputFieldShape", "Lcom/checkout/frames/model/Shape;", "addressSummaryShape", "buttonShape", "screenBackgroundShape", "(Lcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/Shape;)V", "getAddressSummaryShape", "()Lcom/checkout/frames/model/Shape;", "getButtonShape", "getInputFieldShape", "getScreenBackgroundShape", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormShape {
    public static final int $stable = 0;
    @NotNull
    private final Shape addressSummaryShape;
    @NotNull
    private final Shape buttonShape;
    @NotNull
    private final Shape inputFieldShape;
    @NotNull
    private final Shape screenBackgroundShape;

    @JvmOverloads
    public PaymentFormShape() {
        this((Shape) null, (Shape) null, (Shape) null, (Shape) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormShape(@NotNull Shape shape) {
        this(shape, (Shape) null, (Shape) null, (Shape) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape, "inputFieldShape");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormShape(@NotNull Shape shape, @NotNull Shape shape2) {
        this(shape, shape2, (Shape) null, (Shape) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape, "inputFieldShape");
        Intrinsics.checkNotNullParameter(shape2, "addressSummaryShape");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormShape(@NotNull Shape shape, @NotNull Shape shape2, @NotNull Shape shape3) {
        this(shape, shape2, shape3, (Shape) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape, "inputFieldShape");
        Intrinsics.checkNotNullParameter(shape2, "addressSummaryShape");
        Intrinsics.checkNotNullParameter(shape3, "buttonShape");
    }

    @JvmOverloads
    public PaymentFormShape(@NotNull Shape shape, @NotNull Shape shape2, @NotNull Shape shape3, @NotNull Shape shape4) {
        Intrinsics.checkNotNullParameter(shape, "inputFieldShape");
        Intrinsics.checkNotNullParameter(shape2, "addressSummaryShape");
        Intrinsics.checkNotNullParameter(shape3, "buttonShape");
        Intrinsics.checkNotNullParameter(shape4, "screenBackgroundShape");
        this.inputFieldShape = shape;
        this.addressSummaryShape = shape2;
        this.buttonShape = shape3;
        this.screenBackgroundShape = shape4;
    }

    public static /* synthetic */ PaymentFormShape copy$default(PaymentFormShape paymentFormShape, Shape shape, Shape shape2, Shape shape3, Shape shape4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            shape = paymentFormShape.inputFieldShape;
        }
        if ((i11 & 2) != 0) {
            shape2 = paymentFormShape.addressSummaryShape;
        }
        if ((i11 & 4) != 0) {
            shape3 = paymentFormShape.buttonShape;
        }
        if ((i11 & 8) != 0) {
            shape4 = paymentFormShape.screenBackgroundShape;
        }
        return paymentFormShape.copy(shape, shape2, shape3, shape4);
    }

    @NotNull
    public final Shape component1() {
        return this.inputFieldShape;
    }

    @NotNull
    public final Shape component2() {
        return this.addressSummaryShape;
    }

    @NotNull
    public final Shape component3() {
        return this.buttonShape;
    }

    @NotNull
    public final Shape component4() {
        return this.screenBackgroundShape;
    }

    @NotNull
    public final PaymentFormShape copy(@NotNull Shape shape, @NotNull Shape shape2, @NotNull Shape shape3, @NotNull Shape shape4) {
        Intrinsics.checkNotNullParameter(shape, "inputFieldShape");
        Intrinsics.checkNotNullParameter(shape2, "addressSummaryShape");
        Intrinsics.checkNotNullParameter(shape3, "buttonShape");
        Intrinsics.checkNotNullParameter(shape4, "screenBackgroundShape");
        return new PaymentFormShape(shape, shape2, shape3, shape4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormShape)) {
            return false;
        }
        PaymentFormShape paymentFormShape = (PaymentFormShape) obj;
        return this.inputFieldShape == paymentFormShape.inputFieldShape && this.addressSummaryShape == paymentFormShape.addressSummaryShape && this.buttonShape == paymentFormShape.buttonShape && this.screenBackgroundShape == paymentFormShape.screenBackgroundShape;
    }

    @NotNull
    public final Shape getAddressSummaryShape() {
        return this.addressSummaryShape;
    }

    @NotNull
    public final Shape getButtonShape() {
        return this.buttonShape;
    }

    @NotNull
    public final Shape getInputFieldShape() {
        return this.inputFieldShape;
    }

    @NotNull
    public final Shape getScreenBackgroundShape() {
        return this.screenBackgroundShape;
    }

    public int hashCode() {
        return (((((this.inputFieldShape.hashCode() * 31) + this.addressSummaryShape.hashCode()) * 31) + this.buttonShape.hashCode()) * 31) + this.screenBackgroundShape.hashCode();
    }

    @NotNull
    public String toString() {
        Shape shape = this.inputFieldShape;
        Shape shape2 = this.addressSummaryShape;
        Shape shape3 = this.buttonShape;
        Shape shape4 = this.screenBackgroundShape;
        return "PaymentFormShape(inputFieldShape=" + shape + ", addressSummaryShape=" + shape2 + ", buttonShape=" + shape3 + ", screenBackgroundShape=" + shape4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFormShape(Shape shape, Shape shape2, Shape shape3, Shape shape4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Shape.Rectangle : shape, (i11 & 2) != 0 ? Shape.RoundCorner : shape2, (i11 & 4) != 0 ? Shape.Rectangle : shape3, (i11 & 8) != 0 ? Shape.None : shape4);
    }
}
