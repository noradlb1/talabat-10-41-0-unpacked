package library.talabat.mvp.checkout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Llibrary/talabat/mvp/checkout/LoyaltyOrderTrackData;", "", "userId", "", "orderPrice", "", "restaurant", "", "voucherName", "voucherAmount", "discountAmount", "(IFLjava/lang/String;Ljava/lang/String;FF)V", "getDiscountAmount", "()F", "getOrderPrice", "getRestaurant", "()Ljava/lang/String;", "getUserId", "()I", "getVoucherAmount", "getVoucherName", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyOrderTrackData {
    private final float discountAmount;
    private final float orderPrice;
    @NotNull
    private final String restaurant;
    private final int userId;
    private final float voucherAmount;
    @NotNull
    private final String voucherName;

    public LoyaltyOrderTrackData(int i11, float f11, @NotNull String str, @NotNull String str2, float f12, float f13) {
        Intrinsics.checkNotNullParameter(str, "restaurant");
        Intrinsics.checkNotNullParameter(str2, "voucherName");
        this.userId = i11;
        this.orderPrice = f11;
        this.restaurant = str;
        this.voucherName = str2;
        this.voucherAmount = f12;
        this.discountAmount = f13;
    }

    public final float getDiscountAmount() {
        return this.discountAmount;
    }

    public final float getOrderPrice() {
        return this.orderPrice;
    }

    @NotNull
    public final String getRestaurant() {
        return this.restaurant;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final float getVoucherAmount() {
        return this.voucherAmount;
    }

    @NotNull
    public final String getVoucherName() {
        return this.voucherName;
    }
}
