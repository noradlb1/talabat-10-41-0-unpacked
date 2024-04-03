package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0005H@"}, d2 = {"", "Key", "Value", "Landroidx/paging/PagingSource;", "previousPagingSource", "Lkotlin/coroutines/Continuation;", "continuation", "generateNewPagingSource"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcher", f = "PageFetcher.kt", i = {0, 0}, l = {211}, m = "generateNewPagingSource", n = {"this", "previousPagingSource"}, s = {"L$0", "L$1"})
public final class PageFetcher$generateNewPagingSource$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36719h;

    /* renamed from: i  reason: collision with root package name */
    public int f36720i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageFetcher f36721j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36722k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36723l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcher$generateNewPagingSource$1(PageFetcher pageFetcher, Continuation continuation) {
        super(continuation);
        this.f36721j = pageFetcher;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36719h = obj;
        this.f36720i |= Integer.MIN_VALUE;
        return this.f36721j.a((PagingSource) null, this);
    }
}
