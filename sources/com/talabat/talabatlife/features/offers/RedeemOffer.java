package com.talabat.talabatlife.features.offers;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferRequestModel;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferResponse;
import com.talabat.talabatlife.features.offers.network.OffersApi;
import com.talabat.talabatlife.features.offers.network.OffersService;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemOfferDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatlife/features/offers/RedeemOffer;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;", "Lcom/talabat/talabatlife/features/offers/RedeemOffer$Params;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatlife/features/offers/network/OffersService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatlife/features/offers/network/OffersService;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatlife/features/offers/RedeemOffer$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemOffer extends UseCase<RedeemOfferDisplayModel, Params> {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final OffersService f12043service;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/features/offers/RedeemOffer$Params;", "", "offerId", "", "requestModel", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "(ILcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;)V", "getOfferId", "()I", "setOfferId", "(I)V", "getRequestModel", "()Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "setRequestModel", "(Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private int offerId;
        @NotNull
        private RedeemOfferRequestModel requestModel;

        public Params(int i11, @NotNull RedeemOfferRequestModel redeemOfferRequestModel) {
            Intrinsics.checkNotNullParameter(redeemOfferRequestModel, "requestModel");
            this.offerId = i11;
            this.requestModel = redeemOfferRequestModel;
        }

        public final int getOfferId() {
            return this.offerId;
        }

        @NotNull
        public final RedeemOfferRequestModel getRequestModel() {
            return this.requestModel;
        }

        public final void setOfferId(int i11) {
            this.offerId = i11;
        }

        public final void setRequestModel(@NotNull RedeemOfferRequestModel redeemOfferRequestModel) {
            Intrinsics.checkNotNullParameter(redeemOfferRequestModel, "<set-?>");
            this.requestModel = redeemOfferRequestModel;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemOffer(@NotNull NetworkHandler networkHandler2, @NotNull OffersService offersService, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(offersService, "service");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.networkHandler = networkHandler2;
        this.f12043service = offersService;
    }

    @Nullable
    public Object run(@NotNull Params params, @NotNull Continuation<? super Either<? extends Failure, RedeemOfferDisplayModel>> continuation) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(OffersApi.DefaultImpls.redeemOffer$default(this.f12043service, 0, params.getOfferId(), params.getRequestModel(), 1, (Object) null), RedeemOffer$run$2.INSTANCE, new RedeemOfferResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
