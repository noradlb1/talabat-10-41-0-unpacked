package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$onFlowActionCompleted$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$onFlowActionCompleted$1 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11842h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11843i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$onFlowActionCompleted$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, Continuation<? super ApplyVoucherViewModelImpl$onFlowActionCompleted$1> continuation) {
        super(3, continuation);
        this.f11843i = applyVoucherViewModelImpl;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @Nullable Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        return new ApplyVoucherViewModelImpl$onFlowActionCompleted$1(this.f11843i, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f11842h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f11843i.updateViewState(ApplyVouchersViewStates.Complete.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
