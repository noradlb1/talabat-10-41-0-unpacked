package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"", "Key", "Value", "Lkotlin/coroutines/Continuation;", "", "continuation", "doInitialLoad"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9}, l = {611, 272, 275, 623, 635, 647, 304, 659, 671, 329}, m = "doInitialLoad", n = {"this", "this_$iv", "$this$withLock$iv$iv", "this", "$this$withLock$iv$iv", "this", "this", "result", "this_$iv", "$this$withLock$iv$iv", "this", "result", "this_$iv", "$this$withLock$iv$iv", "insertApplied", "this", "result", "this_$iv", "$this$withLock$iv$iv", "this", "result", "$this$withLock$iv$iv", "this", "result", "this_$iv", "$this$withLock$iv$iv", "this", "result", "this_$iv", "$this$withLock$iv$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
public final class PageFetcherSnapshot$doInitialLoad$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36779h;

    /* renamed from: i  reason: collision with root package name */
    public int f36780i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36781j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36782k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36783l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36784m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36785n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f36786o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$doInitialLoad$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(continuation);
        this.f36781j = pageFetcherSnapshot;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36779h = obj;
        this.f36780i |= Integer.MIN_VALUE;
        return this.f36781j.b(this);
    }
}
