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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", i = {0, 0}, l = {42, 102}, m = "invokeSuspend", n = {"$this$flow", "accumulator"}, s = {"L$0", "L$1"})
public final class FlowExtKt$simpleScan$1 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f36592h;

    /* renamed from: i  reason: collision with root package name */
    public int f36593i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Flow f36594j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f36595k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3 f36596l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$simpleScan$1(Flow flow, Object obj, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f36594j = flow;
        this.f36595k = obj;
        this.f36596l = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        FlowExtKt$simpleScan$1 flowExtKt$simpleScan$1 = new FlowExtKt$simpleScan$1(this.f36594j, this.f36595k, this.f36596l, continuation);
        flowExtKt$simpleScan$1.L$0 = obj;
        return flowExtKt$simpleScan$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowExtKt$simpleScan$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Ref.ObjectRef objectRef;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36593i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            objectRef = new Ref.ObjectRef();
            T t11 = this.f36595k;
            objectRef.element = t11;
            this.L$0 = flowCollector2;
            this.f36592h = objectRef;
            this.f36593i = 1;
            if (flowCollector2.emit(t11, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
        } else if (i11 == 1) {
            objectRef = (Ref.ObjectRef) this.f36592h;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow flow = this.f36594j;
        FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 flowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 = new FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1(this, flowCollector, objectRef);
        this.L$0 = null;
        this.f36592h = null;
        this.f36593i = 2;
        if (flow.collect(flowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
