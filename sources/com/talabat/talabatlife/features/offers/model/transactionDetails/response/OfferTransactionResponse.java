package com.talabat.talabatlife.features.offers.model.transactionDetails.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatlife/features/offers/model/transactionDetails/response/OfferTransactionResponse;", "", "()V", "discount", "", "getDiscount", "()Ljava/lang/Float;", "setDiscount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "subTotal", "getSubTotal", "setSubTotal", "total", "getTotal", "setTotal", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferTransactionResponse {
    @SerializedName("discount")
    @Nullable
    private Float discount;
    @SerializedName("subTotal")
    @Nullable
    private Float subTotal;
    @SerializedName("total")
    @Nullable
    private Float total;

    @Nullable
    public final Float getDiscount() {
        return this.discount;
    }

    @Nullable
    public final Float getSubTotal() {
        return this.subTotal;
    }

    @Nullable
    public final Float getTotal() {
        return this.total;
    }

    public final void setDiscount(@Nullable Float f11) {
        this.discount = f11;
    }

    public final void setSubTotal(@Nullable Float f11) {
        this.subTotal = f11;
    }

    public final void setTotal(@Nullable Float f11) {
        this.total = f11;
    }
}
