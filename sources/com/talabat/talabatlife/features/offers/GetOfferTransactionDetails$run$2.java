package com.talabat.talabatlife.features.offers;

import com.talabat.talabatlife.features.offers.model.transactionDetails.response.OfferTransactionRootResponse;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayDisplayModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;", "it", "Lcom/talabat/talabatlife/features/offers/model/transactionDetails/response/OfferTransactionRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetOfferTransactionDetails$run$2 extends Lambda implements Function1<OfferTransactionRootResponse, RedeemAndPayDisplayModel> {
    public static final GetOfferTransactionDetails$run$2 INSTANCE = new GetOfferTransactionDetails$run$2();

    public GetOfferTransactionDetails$run$2() {
        super(1);
    }

    @NotNull
    public final RedeemAndPayDisplayModel invoke(@NotNull OfferTransactionRootResponse offerTransactionRootResponse) {
        Intrinsics.checkNotNullParameter(offerTransactionRootResponse, "it");
        return RedeemAndPayMapper.Companion.mapRedeemAndPayDisplayModel(offerTransactionRootResponse);
    }
}
