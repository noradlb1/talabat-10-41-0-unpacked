package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1 implements Flow<R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f25595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function3 f25596c;

    public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.f25595b = flow;
        this.f25596c = function3;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.f25595b.collect(new FlowKt__EmittersKt$unsafeTransform$1$1(this.f25596c, flowCollector), continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {

            /* renamed from: h  reason: collision with root package name */
            public /* synthetic */ Object f25597h;

            /* renamed from: i  reason: collision with root package name */
            public int f25598i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1 f25599j;

            {
                this.f25599j = r1;
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f25597h = obj;
                this.f25598i |= Integer.MIN_VALUE;
                return this.f25599j.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        Flow flow = this.f25595b;
        FlowKt__EmittersKt$unsafeTransform$1$1 flowKt__EmittersKt$unsafeTransform$1$1 = new FlowKt__EmittersKt$unsafeTransform$1$1(this.f25596c, flowCollector);
        InlineMarker.mark(0);
        flow.collect(flowKt__EmittersKt$unsafeTransform$1$1, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
