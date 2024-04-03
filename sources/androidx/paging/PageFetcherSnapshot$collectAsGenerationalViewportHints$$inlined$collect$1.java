package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$collect$1 implements FlowCollector<GenerationalViewportHint> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36733b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoadType f36734c;

    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$collect$1(PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        this.f36733b = pageFetcherSnapshot;
        this.f36734c = loadType;
    }

    @Nullable
    public Object emit(Object obj, @NotNull Continuation continuation) {
        Object c11 = this.f36733b.c(this.f36734c, (GenerationalViewportHint) obj, continuation);
        if (c11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return c11;
        }
        return Unit.INSTANCE;
    }
}
