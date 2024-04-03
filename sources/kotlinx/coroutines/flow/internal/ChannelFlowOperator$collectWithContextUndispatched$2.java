package kotlinx.coroutines.flow.internal;

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

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"S", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlowOperator$collectWithContextUndispatched$2 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26097h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26098i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChannelFlowOperator<S, T> f26099j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator<S, T> channelFlowOperator, Continuation<? super ChannelFlowOperator$collectWithContextUndispatched$2> continuation) {
        super(2, continuation);
        this.f26099j = channelFlowOperator;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.f26099j, continuation);
        channelFlowOperator$collectWithContextUndispatched$2.f26098i = obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26097h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelFlowOperator<S, T> channelFlowOperator = this.f26099j;
            this.f26097h = 1;
            if (channelFlowOperator.g((FlowCollector) this.f26098i, this) == coroutine_suspended) {
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
