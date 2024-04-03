package com.talabat.talabatnavigation.tLife;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatnavigation/tLife/RedeemAndPayNavigationData;", "", "merchantName", "", "amount", "", "discount", "brandId", "", "vendorId", "selectedOfferIndex", "merchantTransactionId", "isCoffeeMode", "", "(Ljava/lang/String;FFILjava/lang/String;ILjava/lang/String;Z)V", "getAmount", "()F", "getBrandId", "()I", "getDiscount", "()Z", "getMerchantName", "()Ljava/lang/String;", "getMerchantTransactionId", "getSelectedOfferIndex", "getVendorId", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayNavigationData {
    private final float amount;
    private final int brandId;
    private final float discount;
    private final boolean isCoffeeMode;
    @NotNull
    private final String merchantName;
    @NotNull
    private final String merchantTransactionId;
    private final int selectedOfferIndex;
    @NotNull
    private final String vendorId;

    public RedeemAndPayNavigationData(@NotNull String str, float f11, float f12, int i11, @NotNull String str2, int i12, @NotNull String str3, boolean z11) {
        Intrinsics.checkNotNullParameter(str, TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_MERCHANT_NAME);
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "merchantTransactionId");
        this.merchantName = str;
        this.amount = f11;
        this.discount = f12;
        this.brandId = i11;
        this.vendorId = str2;
        this.selectedOfferIndex = i12;
        this.merchantTransactionId = str3;
        this.isCoffeeMode = z11;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getBrandId() {
        return this.brandId;
    }

    public final float getDiscount() {
        return this.discount;
    }

    @NotNull
    public final String getMerchantName() {
        return this.merchantName;
    }

    @NotNull
    public final String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    public final int getSelectedOfferIndex() {
        return this.selectedOfferIndex;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public final boolean isCoffeeMode() {
        return this.isCoffeeMode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemAndPayNavigationData(String str, float f11, float f12, int i11, String str2, int i12, String str3, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f11, f12, i11, str2, (i13 & 32) != 0 ? -1 : i12, str3, z11);
    }
}
