package com.talabat.talabatlife.features.vendors;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.vendors.network.VendorsApi;
import com.talabat.talabatlife.features.vendors.network.VendorsService;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferListRequestModel;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferRootResponse;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/GetVendorOffers;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferListRequestModel;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatlife/features/vendors/network/VendorsService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatlife/features/vendors/network/VendorsService;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferListRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVendorOffers extends UseCase<VendorOfferListDisplayModel, VendorOfferListRequestModel> {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final VendorsService f12049service;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetVendorOffers(@NotNull NetworkHandler networkHandler2, @NotNull VendorsService vendorsService, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(vendorsService, "service");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.networkHandler = networkHandler2;
        this.f12049service = vendorsService;
    }

    @Nullable
    public Object run(@NotNull VendorOfferListRequestModel vendorOfferListRequestModel, @NotNull Continuation<? super Either<? extends Failure, VendorOfferListDisplayModel>> continuation) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(VendorsApi.DefaultImpls.getVendorOfferList$default(this.f12049service, vendorOfferListRequestModel.getRestaurantID(), 0, vendorOfferListRequestModel.getCountryCode(), 2, (Object) null), GetVendorOffers$run$2.INSTANCE, new VendorOfferRootResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
