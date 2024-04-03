package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, d2 = {"", "T", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "event", "Lkotlin/coroutines/Continuation;", "", "continuation", "record"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {297, 174}, m = "record", n = {"this", "event", "$this$withLock$iv", "event", "$this$withLock$iv", "destination$iv$iv", "element$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$3", "L$5"})
public final class FlattenedPageController$record$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36560h;

    /* renamed from: i  reason: collision with root package name */
    public int f36561i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlattenedPageController f36562j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36563k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36564l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36565m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36566n;

    /* renamed from: o  reason: collision with root package name */
    public Object f36567o;

    /* renamed from: p  reason: collision with root package name */
    public Object f36568p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlattenedPageController$record$1(FlattenedPageController flattenedPageController, Continuation continuation) {
        super(continuation);
        this.f36562j = flattenedPageController;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36560h = obj;
        this.f36561i |= Integer.MIN_VALUE;
        return this.f36562j.record((IndexedValue) null, this);
    }
}
