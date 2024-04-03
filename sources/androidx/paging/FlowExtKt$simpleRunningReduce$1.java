package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$simpleRunningReduce$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36589h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow f36590i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3 f36591j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$simpleRunningReduce$1(Flow flow, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f36590i = flow;
        this.f36591j = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        FlowExtKt$simpleRunningReduce$1 flowExtKt$simpleRunningReduce$1 = new FlowExtKt$simpleRunningReduce$1(this.f36590i, this.f36591j, continuation);
        flowExtKt$simpleRunningReduce$1.L$0 = obj;
        return flowExtKt$simpleRunningReduce$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowExtKt$simpleRunningReduce$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36589h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = FlowExtKt.NULL;
            Flow flow = this.f36590i;
            FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 flowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 = new FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1(this, (FlowCollector) this.L$0, objectRef);
            this.f36589h = 1;
            if (flow.collect(flowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
