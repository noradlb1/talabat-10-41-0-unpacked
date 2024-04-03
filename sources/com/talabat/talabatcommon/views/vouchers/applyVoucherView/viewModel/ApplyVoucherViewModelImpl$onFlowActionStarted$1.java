package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$onFlowActionStarted$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$onFlowActionStarted$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11844h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11845i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$onFlowActionStarted$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, Continuation<? super ApplyVoucherViewModelImpl$onFlowActionStarted$1> continuation) {
        super(2, continuation);
        this.f11845i = applyVoucherViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$onFlowActionStarted$1(this.f11845i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$onFlowActionStarted$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f11844h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f11845i.updateViewState(ApplyVouchersViewStates.Loading.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
