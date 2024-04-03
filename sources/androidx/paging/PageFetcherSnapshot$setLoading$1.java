package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, d2 = {"", "Key", "Value", "Landroidx/paging/PageFetcherSnapshotState;", "Landroidx/paging/LoadType;", "loadType", "Lkotlin/coroutines/Continuation;", "", "continuation", "setLoading"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {}, l = {506}, m = "setLoading", n = {}, s = {})
public final class PageFetcherSnapshot$setLoading$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36817h;

    /* renamed from: i  reason: collision with root package name */
    public int f36818i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36819j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$setLoading$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(continuation);
        this.f36819j = pageFetcherSnapshot;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36817h = obj;
        this.f36818i |= Integer.MIN_VALUE;
        return this.f36819j.e((PageFetcherSnapshotState) null, (LoadType) null, this);
    }
}
