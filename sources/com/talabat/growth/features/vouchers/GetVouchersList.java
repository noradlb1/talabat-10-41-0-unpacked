package com.talabat.growth.features.vouchers;

import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModel;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VoucherListRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherListRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersApi;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/growth/features/vouchers/GetVouchersList;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VoucherListRequestModel;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersService;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VoucherListRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVouchersList extends UseCase<VoucherListDisplayModel, VoucherListRequestModel> {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final VouchersService f60575service;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetVouchersList(@NotNull NetworkHandler networkHandler2, @NotNull VouchersService vouchersService, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(vouchersService, "service");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.networkHandler = networkHandler2;
        this.f60575service = vouchersService;
    }

    @Nullable
    public Object run(@NotNull VoucherListRequestModel voucherListRequestModel, @NotNull Continuation<? super Either<? extends Failure, VoucherListDisplayModel>> continuation) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(VouchersApi.DefaultImpls.getVouchersList$default(this.f60575service, 0, voucherListRequestModel.getCountry(), voucherListRequestModel.getVoucherStatus().getValue(), voucherListRequestModel.getPageNumber(), voucherListRequestModel.getPageSize(), (String) null, 33, (Object) null), GetVouchersList$run$2.INSTANCE, new VoucherListRootResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
