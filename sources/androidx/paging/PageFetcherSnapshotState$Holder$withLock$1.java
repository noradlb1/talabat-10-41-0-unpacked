package androidx.paging;

import androidx.paging.PageFetcherSnapshotState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0001*\u00020\u0000\"\b\b\u0003\u0010\u0002*\u00020\u00002-\u0010\b\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00040\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00040\tHH"}, d2 = {"", "Key", "Value", "Lkotlin/Function1;", "Landroidx/paging/PageFetcherSnapshotState;", "Lkotlin/ParameterName;", "name", "state", "block", "Lkotlin/coroutines/Continuation;", "continuation", "withLock"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$Holder", f = "PageFetcherSnapshotState.kt", i = {0, 0, 0}, l = {415}, m = "withLock", n = {"this", "block", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$2"})
public final class PageFetcherSnapshotState$Holder$withLock$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36834h;

    /* renamed from: i  reason: collision with root package name */
    public int f36835i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshotState.Holder f36836j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36837k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36838l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36839m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshotState$Holder$withLock$1(PageFetcherSnapshotState.Holder holder, Continuation continuation) {
        super(continuation);
        this.f36836j = holder;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36834h = obj;
        this.f36835i |= Integer.MIN_VALUE;
        return this.f36836j.withLock((Function1) null, this);
    }
}
