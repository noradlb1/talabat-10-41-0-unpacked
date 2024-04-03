package com.talabat.talabatlife.features.vendors;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.vendors.network.VendorsApi;
import com.talabat.talabatlife.features.vendors.vendorList.models.request.VendorListRequestModel;
import com.talabat.talabatlife.features.vendors.vendorList.models.response.VendorListRootResponse;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/GetVendorsList;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/request/VendorListRequestModel;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatlife/features/vendors/network/VendorsApi;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatlife/features/vendors/network/VendorsApi;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatlife/features/vendors/vendorList/models/request/VendorListRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVendorsList extends UseCase<VendorListDisplayModel, VendorListRequestModel> {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final VendorsApi f12051service;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetVendorsList(@NotNull NetworkHandler networkHandler2, @NotNull VendorsApi vendorsApi, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(vendorsApi, "service");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.networkHandler = networkHandler2;
        this.f12051service = vendorsApi;
    }

    @Nullable
    public Object run(@NotNull VendorListRequestModel vendorListRequestModel, @NotNull Continuation<? super Either<? extends Failure, VendorListDisplayModel>> continuation) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(VendorsApi.DefaultImpls.getVendorsList$default(this.f12051service, vendorListRequestModel.getCountryCode(), 0, vendorListRequestModel.getPathParams(), vendorListRequestModel.getLat(), vendorListRequestModel.getLong(), vendorListRequestModel.getPageNumber(), vendorListRequestModel.getPageSize(), vendorListRequestModel.getSearchString(), vendorListRequestModel.getAreaID(), vendorListRequestModel.getOfferFilterId(), vendorListRequestModel.getCuisineId(), 2, (Object) null), new GetVendorsList$run$2(vendorListRequestModel), new VendorListRootResponse());
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
