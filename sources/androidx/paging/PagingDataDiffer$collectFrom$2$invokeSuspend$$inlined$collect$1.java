package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<PageEvent<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PagingDataDiffer$collectFrom$2 f36879b;

    public PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1(PagingDataDiffer$collectFrom$2 pagingDataDiffer$collectFrom$2) {
        this.f36879b = pagingDataDiffer$collectFrom$2;
    }

    @Nullable
    public Object emit(Object obj, @NotNull Continuation continuation) {
        Object withContext = BuildersKt.withContext(this.f36879b.f36890i.mainDispatcher, new PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1((PageEvent) obj, (Continuation) null, this), continuation);
        if (withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
