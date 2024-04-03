package com.talabat.talabatlife.ui.redeemAndPay.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001e\u0010&\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;", "", "()V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "brandId", "", "getBrandId", "()I", "setBrandId", "(I)V", "discount", "getDiscount", "setDiscount", "isFree", "", "()Z", "setFree", "(Z)V", "merchantName", "", "getMerchantName", "()Ljava/lang/String;", "setMerchantName", "(Ljava/lang/String;)V", "merchantTransactionId", "getMerchantTransactionId", "setMerchantTransactionId", "selectedOfferIndex", "getSelectedOfferIndex", "setSelectedOfferIndex", "subTotal", "getSubTotal", "setSubTotal", "total", "getTotal", "()Ljava/lang/Float;", "setTotal", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "vendorId", "getVendorId", "setVendorId", "vendorOffersData", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "getVendorOffersData", "()Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "setVendorOffersData", "(Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayDisplayModel {
    private float amount;
    private int brandId;
    private float discount;
    private boolean isFree;
    @NotNull
    private String merchantName = "";
    @NotNull
    private String merchantTransactionId = "";
    private int selectedOfferIndex = -1;
    private float subTotal;
    @Nullable
    private Float total;
    @NotNull
    private String vendorId = StringUtils.empty(StringCompanionObject.INSTANCE);
    @Nullable
    private VendorOfferListDisplayModel vendorOffersData;

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

    public final float getSubTotal() {
        return this.subTotal;
    }

    @Nullable
    public final Float getTotal() {
        return this.total;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    @Nullable
    public final VendorOfferListDisplayModel getVendorOffersData() {
        return this.vendorOffersData;
    }

    public final boolean isFree() {
        return this.isFree;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setBrandId(int i11) {
        this.brandId = i11;
    }

    public final void setDiscount(float f11) {
        this.discount = f11;
    }

    public final void setFree(boolean z11) {
        this.isFree = z11;
    }

    public final void setMerchantName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantName = str;
    }

    public final void setMerchantTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantTransactionId = str;
    }

    public final void setSelectedOfferIndex(int i11) {
        this.selectedOfferIndex = i11;
    }

    public final void setSubTotal(float f11) {
        this.subTotal = f11;
    }

    public final void setTotal(@Nullable Float f11) {
        this.total = f11;
    }

    public final void setVendorId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorId = str;
    }

    public final void setVendorOffersData(@Nullable VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        this.vendorOffersData = vendorOfferListDisplayModel;
    }
}
