package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures$FailToUnApplyVoucher;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.UnApplyAllVoucherUseCase$invoke$1", f = "UnApplyAllVoucherUseCase.kt", i = {}, l = {19, 20, 23}, m = "invokeSuspend", n = {}, s = {})
public final class UnApplyAllVoucherUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super Either<? extends VoucherFailures.FailToUnApplyVoucher, ? extends Boolean>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61639h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UnApplyAllVoucherUseCase f61640i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnApplyAllVoucherUseCase$invoke$1(UnApplyAllVoucherUseCase unApplyAllVoucherUseCase, Continuation<? super UnApplyAllVoucherUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.f61640i = unApplyAllVoucherUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UnApplyAllVoucherUseCase$invoke$1 unApplyAllVoucherUseCase$invoke$1 = new UnApplyAllVoucherUseCase$invoke$1(this.f61640i, continuation);
        unApplyAllVoucherUseCase$invoke$1.L$0 = obj;
        return unApplyAllVoucherUseCase$invoke$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Either<VoucherFailures.FailToUnApplyVoucher, Boolean>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((UnApplyAllVoucherUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Boolean bool;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61639h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Either<Failure, Boolean> unApplyAllVouchers = this.f61640i.voucherRepository.unApplyAllVouchers();
            if (unApplyAllVouchers instanceof Either.Right) {
                Object b11 = ((Either.Right) unApplyAllVouchers).getB();
                ((Boolean) b11).booleanValue();
                Boolean bool2 = (Boolean) b11;
                if (bool2 != null) {
                    Either.Right right = new Either.Right(Boxing.boxBoolean(bool2.booleanValue()));
                    this.L$0 = bool2;
                    this.f61639h = 1;
                    if (flowCollector.emit(right, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bool = bool2;
                } else {
                    Either.Left left = new Either.Left(new VoucherFailures.FailToUnApplyVoucher((Failure) null, 1, (DefaultConstructorMarker) null));
                    this.f61639h = 2;
                    if (flowCollector.emit(left, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (unApplyAllVouchers instanceof Either.Left) {
                Either.Left left2 = new Either.Left(new VoucherFailures.FailToUnApplyVoucher((Failure) ((Either.Left) unApplyAllVouchers).getA()));
                this.f61639h = 3;
                if (flowCollector.emit(left2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            bool = (Boolean) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2 || i11 == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Boxing.boxBoolean(bool.booleanValue());
        return Unit.INSTANCE;
    }
}
