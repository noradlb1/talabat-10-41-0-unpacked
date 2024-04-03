package com.talabat.talabatlife.features.offers.model.transactionDetails.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/features/offers/model/transactionDetails/request/OfferTransactionDetailsRequestModel;", "", "offerId", "", "merchantTransactionId", "", "(ILjava/lang/String;)V", "getMerchantTransactionId", "()Ljava/lang/String;", "getOfferId", "()I", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferTransactionDetailsRequestModel {
    @NotNull
    private final String merchantTransactionId;
    private final int offerId;

    public OfferTransactionDetailsRequestModel() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public OfferTransactionDetailsRequestModel(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "merchantTransactionId");
        this.offerId = i11;
        this.merchantTransactionId = str;
    }

    @NotNull
    public final String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    public final int getOfferId() {
        return this.offerId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferTransactionDetailsRequestModel(int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? "" : str);
    }
}
