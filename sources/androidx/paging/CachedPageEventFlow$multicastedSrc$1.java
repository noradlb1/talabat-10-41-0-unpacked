package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u00050\u0004H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$multicastedSrc$1", f = "CachedPageEventFlow.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
public final class CachedPageEventFlow$multicastedSrc$1 extends SuspendLambda implements Function2<FlowCollector<? super IndexedValue<? extends PageEvent<T>>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36501h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CachedPageEventFlow f36502i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Flow f36503j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$multicastedSrc$1(CachedPageEventFlow cachedPageEventFlow, Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f36502i = cachedPageEventFlow;
        this.f36503j = flow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        CachedPageEventFlow$multicastedSrc$1 cachedPageEventFlow$multicastedSrc$1 = new CachedPageEventFlow$multicastedSrc$1(this.f36502i, this.f36503j, continuation);
        cachedPageEventFlow$multicastedSrc$1.L$0 = obj;
        return cachedPageEventFlow$multicastedSrc$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CachedPageEventFlow$multicastedSrc$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36501h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            if (this.f36502i.collectedFromSource.compareAndSet(false, true)) {
                Flow withIndex = FlowKt.withIndex(this.f36503j);
                this.f36501h = 1;
                if (withIndex.collect(flowCollector, this) == coroutine_suspended) {
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
