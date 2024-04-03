package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1 implements Flow<R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow[] f25999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f26000c;

    public FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(Flow[] flowArr, Function2 function2) {
        this.f25999b = flowArr;
        this.f26000c = function2;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Flow[] flowArr = this.f25999b;
        Function0 access$nullArrayFactory = FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
        Intrinsics.needClassReification();
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, access$nullArrayFactory, new FlowKt__ZipKt$combineUnsafe$1$1(this.f26000c, (Continuation<? super FlowKt__ZipKt$combineUnsafe$1$1>) null), continuation);
        if (combineInternal == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {

            /* renamed from: h  reason: collision with root package name */
            public /* synthetic */ Object f26001h;

            /* renamed from: i  reason: collision with root package name */
            public int f26002i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1 f26003j;

            {
                this.f26003j = r1;
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f26001h = obj;
                this.f26002i |= Integer.MIN_VALUE;
                return this.f26003j.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        Flow[] flowArr = this.f25999b;
        Function0 access$nullArrayFactory = FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combineUnsafe$1$1 flowKt__ZipKt$combineUnsafe$1$1 = new FlowKt__ZipKt$combineUnsafe$1$1(this.f26000c, (Continuation<? super FlowKt__ZipKt$combineUnsafe$1$1>) null);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, access$nullArrayFactory, flowKt__ZipKt$combineUnsafe$1$1, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
