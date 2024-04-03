package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemPromoCodeRequestModel;", "", "promoCode", "", "country", "", "(Ljava/lang/String;I)V", "getCountry", "()I", "getPromoCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemPromoCodeRequestModel {
    private final int country;
    @Nullable
    private final String promoCode;

    public RedeemPromoCodeRequestModel(@Nullable String str, int i11) {
        this.promoCode = str;
        this.country = i11;
    }

    public static /* synthetic */ RedeemPromoCodeRequestModel copy$default(RedeemPromoCodeRequestModel redeemPromoCodeRequestModel, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = redeemPromoCodeRequestModel.promoCode;
        }
        if ((i12 & 2) != 0) {
            i11 = redeemPromoCodeRequestModel.country;
        }
        return redeemPromoCodeRequestModel.copy(str, i11);
    }

    @Nullable
    public final String component1() {
        return this.promoCode;
    }

    public final int component2() {
        return this.country;
    }

    @NotNull
    public final RedeemPromoCodeRequestModel copy(@Nullable String str, int i11) {
        return new RedeemPromoCodeRequestModel(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemPromoCodeRequestModel)) {
            return false;
        }
        RedeemPromoCodeRequestModel redeemPromoCodeRequestModel = (RedeemPromoCodeRequestModel) obj;
        return Intrinsics.areEqual((Object) this.promoCode, (Object) redeemPromoCodeRequestModel.promoCode) && this.country == redeemPromoCodeRequestModel.country;
    }

    public final int getCountry() {
        return this.country;
    }

    @Nullable
    public final String getPromoCode() {
        return this.promoCode;
    }

    public int hashCode() {
        String str = this.promoCode;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.country;
    }

    @NotNull
    public String toString() {
        String str = this.promoCode;
        int i11 = this.country;
        return "RedeemPromoCodeRequestModel(promoCode=" + str + ", country=" + i11 + ")";
    }
}
