package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.facebook.internal.NativeProtocol;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemBurnItemRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.MarketPlaceRedeemBurnOptionRepository;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "marketPlaceRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/MarketPlaceRedeemBurnOptionRepository;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/MarketPlaceRedeemBurnOptionRepository;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemBurnItemRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherUseCase {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final MarketPlaceRedeemBurnOptionRepository marketPlaceRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final TalabatTracker talabatTracker;

    public RedeemVoucherUseCase(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull MarketPlaceRedeemBurnOptionRepository marketPlaceRedeemBurnOptionRepository, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(marketPlaceRedeemBurnOptionRepository, "marketPlaceRepository");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.dispatcher = coroutineDispatcher;
        this.marketPlaceRepository = marketPlaceRedeemBurnOptionRepository;
        this.talabatTracker = talabatTracker2;
    }

    @NotNull
    public final Flow<Either<VoucherFailures, ConfirmationDisplayModel>> invoke(@NotNull RedeemBurnItemRequestModel redeemBurnItemRequestModel) {
        Intrinsics.checkNotNullParameter(redeemBurnItemRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        return FlowKt.flowOn(FlowKt.flow(new RedeemVoucherUseCase$invoke$1(this, redeemBurnItemRequestModel, (Continuation<? super RedeemVoucherUseCase$invoke$1>) null)), this.dispatcher);
    }
}
