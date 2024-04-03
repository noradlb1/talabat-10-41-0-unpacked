package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {352}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25553h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25554i;

    /* renamed from: j  reason: collision with root package name */
    public int f25555j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25556k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f25557l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f25558m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2(long j11, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.f25557l = j11;
        this.f25558m = flow;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.f25557l, this.f25558m, continuation);
        flowKt__DelayKt$sample$2.L$0 = coroutineScope;
        flowKt__DelayKt$sample$2.f25556k = flowCollector;
        return flowKt__DelayKt$sample$2.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannel2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25555j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.f25558m, (Continuation<? super FlowKt__DelayKt$sample$2$values$1>) null);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, -1, flowKt__DelayKt$sample$2$values$1, 1, (Object) null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ReceiveChannel fixedPeriodTicker$default = FlowKt__DelayKt.fixedPeriodTicker$default(coroutineScope, this.f25557l, 0, 2, (Object) null);
            flowCollector = (FlowCollector) this.f25556k;
            receiveChannel = produce$default;
            objectRef = objectRef2;
            receiveChannel2 = fixedPeriodTicker$default;
        } else if (i11 == 1) {
            receiveChannel2 = (ReceiveChannel) this.f25554i;
            objectRef = (Ref.ObjectRef) this.f25553h;
            receiveChannel = (ReceiveChannel) this.f25556k;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (objectRef.element != NullSurrogateKt.DONE) {
            this.L$0 = flowCollector;
            this.f25556k = receiveChannel;
            this.f25553h = objectRef;
            this.f25554i = receiveChannel2;
            this.f25555j = 1;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(this);
            try {
                selectBuilderImpl.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannel2, (Continuation<? super FlowKt__DelayKt$sample$2$1$1>) null));
                selectBuilderImpl.invoke(receiveChannel2.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(objectRef, flowCollector, (Continuation<? super FlowKt__DelayKt$sample$2$1$2>) null));
            } catch (Throwable th2) {
                selectBuilderImpl.handleBuilderException(th2);
            }
            Object result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
                continue;
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
