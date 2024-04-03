package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, d2 = {"", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "Lkotlin/coroutines/Continuation;", "", "continuation", "doLoad"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {684, 696, 386, 394, 708, 720, 437, 732, 456, 482, 744}, m = "doLoad", n = {"this", "loadType", "generationalHint", "itemsLoaded", "this_$iv", "$this$withLock$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "this_$iv", "$this$withLock$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "$this$withLock$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "this_$iv", "$this$withLock$iv$iv", "this", "loadType", "generationalHint", "result", "this_$iv", "$this$withLock$iv$iv", "loadType", "generationalHint", "$this$withLock$iv$iv", "state", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "dropType", "this_$iv", "$this$withLock$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "$this$withLock$iv$iv", "state", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "$this$withLock$iv$iv", "this", "loadType", "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "this_$iv", "$this$withLock$iv$iv", "endsPrepend", "endsAppend"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"})
public final class PageFetcherSnapshot$doLoad$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36787h;

    /* renamed from: i  reason: collision with root package name */
    public int f36788i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36789j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36790k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36791l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36792m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36793n;

    /* renamed from: o  reason: collision with root package name */
    public Object f36794o;

    /* renamed from: p  reason: collision with root package name */
    public Object f36795p;

    /* renamed from: q  reason: collision with root package name */
    public Object f36796q;

    /* renamed from: r  reason: collision with root package name */
    public Object f36797r;

    /* renamed from: s  reason: collision with root package name */
    public Object f36798s;

    /* renamed from: t  reason: collision with root package name */
    public Object f36799t;

    /* renamed from: u  reason: collision with root package name */
    public Object f36800u;

    /* renamed from: v  reason: collision with root package name */
    public int f36801v;

    /* renamed from: w  reason: collision with root package name */
    public int f36802w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$doLoad$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(continuation);
        this.f36789j = pageFetcherSnapshot;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36787h = obj;
        this.f36788i |= Integer.MIN_VALUE;
        return this.f36789j.c((LoadType) null, (GenerationalViewportHint) null, this);
    }
}
