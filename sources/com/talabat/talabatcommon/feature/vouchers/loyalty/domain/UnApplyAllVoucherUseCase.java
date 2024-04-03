package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/UnApplyAllVoucherUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnApplyAllVoucherUseCase {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final VoucherRepository voucherRepository;

    public UnApplyAllVoucherUseCase(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull VoucherRepository voucherRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        this.dispatcher = coroutineDispatcher;
        this.voucherRepository = voucherRepository2;
    }

    @NotNull
    public final Flow<Either<VoucherFailures, Boolean>> invoke() {
        return FlowKt.flowOn(FlowKt.flow(new UnApplyAllVoucherUseCase$invoke$1(this, (Continuation<? super UnApplyAllVoucherUseCase$invoke$1>) null)), this.dispatcher);
    }
}
