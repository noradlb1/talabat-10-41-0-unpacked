package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemBurnItemRequestModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModelImpl$redeemBurnOption$1", f = "BurnOptionsDetailsViewModelImpl.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
public final class BurnOptionsDetailsViewModelImpl$redeemBurnOption$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60613h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsViewModelImpl f60614i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60615j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LoyaltyBurnOptionType f60616k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ RedeemSourceType f60617l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ RedeemTrackData f60618m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ VoucherOptionType f60619n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsViewModelImpl$redeemBurnOption$1(BurnOptionsDetailsViewModelImpl burnOptionsDetailsViewModelImpl, String str, LoyaltyBurnOptionType loyaltyBurnOptionType, RedeemSourceType redeemSourceType, RedeemTrackData redeemTrackData, VoucherOptionType voucherOptionType, Continuation<? super BurnOptionsDetailsViewModelImpl$redeemBurnOption$1> continuation) {
        super(2, continuation);
        this.f60614i = burnOptionsDetailsViewModelImpl;
        this.f60615j = str;
        this.f60616k = loyaltyBurnOptionType;
        this.f60617l = redeemSourceType;
        this.f60618m = redeemTrackData;
        this.f60619n = voucherOptionType;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BurnOptionsDetailsViewModelImpl$redeemBurnOption$1(this.f60614i, this.f60615j, this.f60616k, this.f60617l, this.f60618m, this.f60619n, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BurnOptionsDetailsViewModelImpl$redeemBurnOption$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60613h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Either<VoucherFailures, ConfirmationDisplayModel>> invoke = this.f60614i.redeemBurnItem.invoke(new RedeemBurnItemRequestModel(this.f60615j, this.f60616k, this.f60617l, this.f60618m, this.f60619n));
            final BurnOptionsDetailsViewModelImpl burnOptionsDetailsViewModelImpl = this.f60614i;
            AnonymousClass1 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull Either<? extends VoucherFailures, ConfirmationDisplayModel> either, @NotNull Continuation<? super Unit> continuation) {
                    Object either2 = either.either(new Function1<Failure, Unit>(burnOptionsDetailsViewModelImpl) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Failure) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Failure failure) {
                            Intrinsics.checkNotNullParameter(failure, "p0");
                            ((BurnOptionsDetailsViewModelImpl) this.receiver).handleFailure(failure);
                        }
                    }, new Function1<ConfirmationDisplayModel, Unit>(burnOptionsDetailsViewModelImpl) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ConfirmationDisplayModel) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull ConfirmationDisplayModel confirmationDisplayModel) {
                            Intrinsics.checkNotNullParameter(confirmationDisplayModel, "p0");
                            ((BurnOptionsDetailsViewModelImpl) this.receiver).setupOrderNowDirection(confirmationDisplayModel);
                        }
                    });
                    if (either2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return either2;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f60613h = 1;
            if (invoke.collect(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
