package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemBurnItemRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.RedeemedOfferTrackingEvent;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToRedeemVoucher;", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherUseCase$invoke$1", f = "RedeemVoucherUseCase.kt", i = {}, l = {27, 30}, m = "invokeSuspend", n = {}, s = {})
public final class RedeemVoucherUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super Either<? extends VoucherFailures.FailToRedeemVoucher, ? extends ConfirmationDisplayModel>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61636h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherUseCase f61637i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RedeemBurnItemRequestModel f61638j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemVoucherUseCase$invoke$1(RedeemVoucherUseCase redeemVoucherUseCase, RedeemBurnItemRequestModel redeemBurnItemRequestModel, Continuation<? super RedeemVoucherUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.f61637i = redeemVoucherUseCase;
        this.f61638j = redeemBurnItemRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RedeemVoucherUseCase$invoke$1 redeemVoucherUseCase$invoke$1 = new RedeemVoucherUseCase$invoke$1(this.f61637i, this.f61638j, continuation);
        redeemVoucherUseCase$invoke$1.L$0 = obj;
        return redeemVoucherUseCase$invoke$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Either<VoucherFailures.FailToRedeemVoucher, ConfirmationDisplayModel>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((RedeemVoucherUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61636h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Either<Failure, ConfirmationDisplayModel> redeemVoucher = this.f61637i.marketPlaceRepository.redeemVoucher(this.f61638j);
            if (redeemVoucher instanceof Either.Right) {
                this.f61637i.talabatTracker.track(new RedeemedOfferTrackingEvent(this.f61638j.getRedeemTrackData()));
                Either.Right right = new Either.Right(((Either.Right) redeemVoucher).getB());
                this.f61636h = 1;
                if (flowCollector.emit(right, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (redeemVoucher instanceof Either.Left) {
                Either.Left left = new Either.Left(new VoucherFailures.FailToRedeemVoucher((Failure) ((Either.Left) redeemVoucher).getA()));
                this.f61636h = 2;
                if (flowCollector.emit(left, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
