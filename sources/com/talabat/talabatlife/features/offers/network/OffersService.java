package com.talabat.talabatlife.features.offers.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferRequestModel;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferResponse;
import com.talabat.talabatlife.features.offers.model.transactionDetails.response.OfferTransactionRootResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatlife/features/offers/network/OffersService;", "Lcom/talabat/talabatlife/features/offers/network/OffersApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/talabatlife/features/offers/network/OffersApi;", "api$delegate", "Lkotlin/Lazy;", "getOfferTransactionDetails", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/offers/model/transactionDetails/response/OfferTransactionRootResponse;", "apiVersion", "", "offerId", "merchantTransactionId", "", "redeemOffer", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferResponse;", "redeemOfferRequestModel", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OffersService implements OffersApi {
    @NotNull
    private final Lazy api$delegate;

    public OffersService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OffersService$api$2(talabatAPIBuilder));
    }

    private final OffersApi getApi() {
        return (OffersApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<OfferTransactionRootResponse> getOfferTransactionDetails(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "merchantTransactionId");
        return getApi().getOfferTransactionDetails(i11, i12, str);
    }

    @NotNull
    public Call<RedeemOfferResponse> redeemOffer(int i11, int i12, @NotNull RedeemOfferRequestModel redeemOfferRequestModel) {
        Intrinsics.checkNotNullParameter(redeemOfferRequestModel, "redeemOfferRequestModel");
        return getApi().redeemOffer(i11, i12, redeemOfferRequestModel);
    }
}
