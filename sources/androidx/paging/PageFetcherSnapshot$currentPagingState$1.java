package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003H@"}, d2 = {"", "Key", "Value", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingState;", "continuation", "currentPagingState"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0}, l = {595}, m = "currentPagingState", n = {"this", "this_$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$1", "L$2"})
public final class PageFetcherSnapshot$currentPagingState$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36773h;

    /* renamed from: i  reason: collision with root package name */
    public int f36774i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36775j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36776k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36777l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36778m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$currentPagingState$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(continuation);
        this.f36775j = pageFetcherSnapshot;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36773h = obj;
        this.f36774i |= Integer.MIN_VALUE;
        return this.f36775j.currentPagingState(this);
    }
}
