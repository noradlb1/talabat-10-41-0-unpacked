package com.talabat.talabatlife.ui.redeemAndPay.model;

import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferResponse;
import com.talabat.talabatlife.features.offers.model.transactionDetails.response.OfferTransactionResponse;
import com.talabat.talabatlife.features.offers.model.transactionDetails.response.OfferTransactionRootResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayMapper$Companion;", "", "()V", "mapRedeemAndPayDisplayModel", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;", "response", "Lcom/talabat/talabatlife/features/offers/model/transactionDetails/response/OfferTransactionRootResponse;", "mapRedeemOfferDisplayModel", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;", "it", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferResponse;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RedeemAndPayDisplayModel mapRedeemAndPayDisplayModel(@NotNull OfferTransactionRootResponse offerTransactionRootResponse) {
            Intrinsics.checkNotNullParameter(offerTransactionRootResponse, "response");
            RedeemAndPayDisplayModel redeemAndPayDisplayModel = new RedeemAndPayDisplayModel();
            OfferTransactionResponse offerTransactionResponse = (OfferTransactionResponse) offerTransactionRootResponse.getResult();
            if (offerTransactionResponse != null) {
                redeemAndPayDisplayModel.setDiscount(FloatKt.orZero(offerTransactionResponse.getDiscount()));
                redeemAndPayDisplayModel.setSubTotal(FloatKt.orZero(offerTransactionResponse.getSubTotal()));
                redeemAndPayDisplayModel.setTotal(Float.valueOf(FloatKt.orZero(offerTransactionResponse.getTotal())));
            }
            return redeemAndPayDisplayModel;
        }

        @NotNull
        public final RedeemOfferDisplayModel mapRedeemOfferDisplayModel(@NotNull RedeemOfferResponse redeemOfferResponse) {
            boolean z11;
            Intrinsics.checkNotNullParameter(redeemOfferResponse, "it");
            RedeemOfferDisplayModel redeemOfferDisplayModel = new RedeemOfferDisplayModel();
            Boolean result = redeemOfferResponse.getResult();
            if (result != null) {
                z11 = result.booleanValue();
            } else {
                z11 = false;
            }
            redeemOfferDisplayModel.setResult(z11);
            String[] errors = redeemOfferResponse.getErrors();
            if (errors == null) {
                errors = new String[0];
            }
            redeemOfferDisplayModel.setErrors(errors);
            return redeemOfferDisplayModel;
        }
    }
}
