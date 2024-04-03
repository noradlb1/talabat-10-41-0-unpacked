package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerUtilKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import com.talabat.talabatcore.functional.Either;
import datamodels.CartMenuItem;
import java.util.List;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11865h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11866i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f11867j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f11868k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ List<CartMenuItem> f11869l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, boolean z11, float f11, List<? extends CartMenuItem> list, Continuation<? super ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1> continuation) {
        super(2, continuation);
        this.f11866i = applyVoucherViewModelImpl;
        this.f11867j = z11;
        this.f11868k = f11;
        this.f11869l = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1(this.f11866i, this.f11867j, this.f11868k, this.f11869l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11865h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = this.f11866i;
            Flow access$onFlowActionStarted = applyVoucherViewModelImpl.onFlowActionStarted(applyVoucherViewModelImpl.unApplyAllVoucherUseCase.invoke());
            final ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = this.f11866i;
            final boolean z11 = this.f11867j;
            final float f11 = this.f11868k;
            final List<CartMenuItem> list = this.f11869l;
            AnonymousClass1 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull Either<? extends VoucherFailures, Boolean> either, @NotNull Continuation<? super Unit> continuation) {
                    final ApplyVoucherViewModelImpl applyVoucherViewModelImpl = applyVoucherViewModelImpl2;
                    AnonymousClass1 r72 = new Function1<VoucherFailures, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((VoucherFailures) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull VoucherFailures voucherFailures) {
                            Intrinsics.checkNotNullParameter(voucherFailures, "it");
                            applyVoucherViewModelImpl.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure(voucherFailures));
                        }
                    };
                    final ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = applyVoucherViewModelImpl2;
                    final boolean z11 = z11;
                    final float f11 = f11;
                    final List<CartMenuItem> list = list;
                    Object either2 = either.either(r72, new Function1<Boolean, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z11) {
                            VoucherData access$getCurrentAppliedVoucher$p = applyVoucherViewModelImpl2.currentAppliedVoucher;
                            if (access$getCurrentAppliedVoucher$p != null) {
                                GrowthTracker.INSTANCE.onVoucherRemoved(access$getCurrentAppliedVoucher$p.getId(), access$getCurrentAppliedVoucher$p.getTitle(), GrowthTrackerUtilKt.getDiscountPrice(access$getCurrentAppliedVoucher$p, f11, list), access$getCurrentAppliedVoucher$p.getVoucherOptionType().name());
                            }
                            applyVoucherViewModelImpl2.updateViewState(new ApplyVouchersViewStates.UnAppliedVouchersDone(z11));
                        }
                    });
                    if (either2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return either2;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f11865h = 1;
            if (access$onFlowActionStarted.collect(r12, this) == coroutine_suspended) {
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
