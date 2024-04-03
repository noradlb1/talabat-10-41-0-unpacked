package androidx.paging;

import androidx.paging.ActiveFlowTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PagingData;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$multicastedFlow$5", f = "CachedPagingData.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class CachedPagingDataKt$cachedIn$multicastedFlow$5 extends SuspendLambda implements Function3<FlowCollector<? super PagingData<T>>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36521h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ActiveFlowTracker f36522i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachedPagingDataKt$cachedIn$multicastedFlow$5(ActiveFlowTracker activeFlowTracker, Continuation continuation) {
        super(3, continuation);
        this.f36522i = activeFlowTracker;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super PagingData<T>> flowCollector, @Nullable Throwable th2, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(flowCollector, "$this$create");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return new CachedPagingDataKt$cachedIn$multicastedFlow$5(this.f36522i, continuation);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((CachedPagingDataKt$cachedIn$multicastedFlow$5) create((FlowCollector) obj, (Throwable) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36521h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ActiveFlowTracker activeFlowTracker = this.f36522i;
            if (activeFlowTracker != null) {
                ActiveFlowTracker.FlowType flowType = ActiveFlowTracker.FlowType.PAGED_DATA_FLOW;
                this.f36521h = 1;
                if (activeFlowTracker.onComplete(flowType, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
