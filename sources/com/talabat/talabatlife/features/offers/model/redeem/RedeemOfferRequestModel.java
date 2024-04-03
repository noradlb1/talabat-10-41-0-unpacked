package com.talabat.talabatlife.features.offers.model.redeem;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "", "walletTransId", "", "merchantTransId", "country", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCountry", "()Ljava/lang/Integer;", "setCountry", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMerchantTransId", "()Ljava/lang/String;", "setMerchantTransId", "(Ljava/lang/String;)V", "getWalletTransId", "setWalletTransId", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemOfferRequestModel {
    @Nullable
    private Integer country;
    @Nullable
    private String merchantTransId;
    @Nullable
    private String walletTransId;

    public RedeemOfferRequestModel() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public RedeemOfferRequestModel(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.walletTransId = str;
        this.merchantTransId = str2;
        this.country = num;
    }

    @Nullable
    public final Integer getCountry() {
        return this.country;
    }

    @Nullable
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    @Nullable
    public final String getWalletTransId() {
        return this.walletTransId;
    }

    public final void setCountry(@Nullable Integer num) {
        this.country = num;
    }

    public final void setMerchantTransId(@Nullable String str) {
        this.merchantTransId = str;
    }

    public final void setWalletTransId(@Nullable String str) {
        this.walletTransId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemOfferRequestModel(String str, String str2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2, (i11 & 4) != 0 ? 0 : num);
    }
}
