package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.MyPossibleVouchersRequestModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetMyPossibleVouchersUseCase$invoke$1", f = "GetMyPossibleVouchersUseCase.kt", i = {}, l = {48, 51, 54}, m = "invokeSuspend", n = {}, s = {})
public final class GetMyPossibleVouchersUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super Either<? extends VoucherFailures, ? extends ApplyVoucherViewHolderDisplayModel>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61609h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetMyPossibleVouchersUseCase f61610i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MyPossibleVouchersRequestModel f61611j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetMyPossibleVouchersUseCase$invoke$1(GetMyPossibleVouchersUseCase getMyPossibleVouchersUseCase, MyPossibleVouchersRequestModel myPossibleVouchersRequestModel, Continuation<? super GetMyPossibleVouchersUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.f61610i = getMyPossibleVouchersUseCase;
        this.f61611j = myPossibleVouchersRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetMyPossibleVouchersUseCase$invoke$1 getMyPossibleVouchersUseCase$invoke$1 = new GetMyPossibleVouchersUseCase$invoke$1(this.f61610i, this.f61611j, continuation);
        getMyPossibleVouchersUseCase$invoke$1.L$0 = obj;
        return getMyPossibleVouchersUseCase$invoke$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Either<? extends VoucherFailures, ApplyVoucherViewHolderDisplayModel>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((GetMyPossibleVouchersUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61609h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            if (this.f61610i.customerRepository.isLoggedIn()) {
                Either<Failure, ApplyVoucherViewHolderDisplayModel> myPossibleVouchers = this.f61610i.voucherRepository.getMyPossibleVouchers(this.f61611j.getCountry(), this.f61611j.getBrandID(), this.f61611j.getAreaId(), this.f61611j.getVerticalId());
                if (myPossibleVouchers instanceof Either.Right) {
                    if (!this.f61610i.isFreeDeliveryTypeVouchersApplicable()) {
                        Either.Right right = (Either.Right) myPossibleVouchers;
                        ((ApplyVoucherViewHolderDisplayModel) right.getB()).setMyVouchers(this.f61610i.moveFreeDeliveryTypeVouchersToEndAndDisable(((ApplyVoucherViewHolderDisplayModel) right.getB()).getMyVouchers()));
                    }
                    Either.Right right2 = (Either.Right) myPossibleVouchers;
                    ((ApplyVoucherViewHolderDisplayModel) right2.getB()).setMyVouchers(this.f61610i.filterByRestrictions(((ApplyVoucherViewHolderDisplayModel) right2.getB()).getMyVouchers()));
                    Either.Right right3 = new Either.Right(right2.getB());
                    this.f61609h = 1;
                    if (flowCollector.emit(right3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (myPossibleVouchers instanceof Either.Left) {
                    Either.Left left = new Either.Left(new VoucherFailures.FailToLoadPossibleVouchers((Failure) ((Either.Left) myPossibleVouchers).getA()));
                    this.f61609h = 2;
                    if (flowCollector.emit(left, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                Either.Left left2 = new Either.Left(VoucherFailures.UserNotLoggedIn.INSTANCE);
                this.f61609h = 3;
                if (flowCollector.emit(left2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2 || i11 == 3) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
