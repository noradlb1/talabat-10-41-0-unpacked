package androidx.paging;

import androidx.paging.ActiveFlowTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PagingData;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$multicastedFlow$4", f = "CachedPagingData.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class CachedPagingDataKt$cachedIn$multicastedFlow$4 extends SuspendLambda implements Function2<FlowCollector<? super PagingData<T>>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36519h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ActiveFlowTracker f36520i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachedPagingDataKt$cachedIn$multicastedFlow$4(ActiveFlowTracker activeFlowTracker, Continuation continuation) {
        super(2, continuation);
        this.f36520i = activeFlowTracker;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CachedPagingDataKt$cachedIn$multicastedFlow$4(this.f36520i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CachedPagingDataKt$cachedIn$multicastedFlow$4) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36519h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ActiveFlowTracker activeFlowTracker = this.f36520i;
            if (activeFlowTracker != null) {
                ActiveFlowTracker.FlowType flowType = ActiveFlowTracker.FlowType.PAGED_DATA_FLOW;
                this.f36519h = 1;
                if (activeFlowTracker.onStart(flowType, this) == coroutine_suspended) {
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
