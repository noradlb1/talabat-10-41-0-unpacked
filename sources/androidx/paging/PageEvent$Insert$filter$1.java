package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0003H@"}, d2 = {"", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "predicate", "Landroidx/paging/PageEvent;", "continuation", "filter"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageEvent$Insert", f = "PageEvent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {104}, m = "filter", n = {"predicate", "this_$iv$iv", "destination$iv$iv$iv", "it", "originalIndices", "data", "t", "index$iv", "index"}, s = {"L$0", "L$1", "L$3", "L$5", "L$6", "L$7", "L$9", "I$0", "I$1"})
public final class PageEvent$Insert$filter$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36646h;

    /* renamed from: i  reason: collision with root package name */
    public int f36647i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageEvent.Insert f36648j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36649k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36650l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36651m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36652n;

    /* renamed from: o  reason: collision with root package name */
    public Object f36653o;

    /* renamed from: p  reason: collision with root package name */
    public Object f36654p;

    /* renamed from: q  reason: collision with root package name */
    public Object f36655q;

    /* renamed from: r  reason: collision with root package name */
    public Object f36656r;

    /* renamed from: s  reason: collision with root package name */
    public Object f36657s;

    /* renamed from: t  reason: collision with root package name */
    public Object f36658t;

    /* renamed from: u  reason: collision with root package name */
    public Object f36659u;

    /* renamed from: v  reason: collision with root package name */
    public int f36660v;

    /* renamed from: w  reason: collision with root package name */
    public int f36661w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageEvent$Insert$filter$1(PageEvent.Insert insert, Continuation continuation) {
        super(continuation);
        this.f36648j = insert;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36646h = obj;
        this.f36647i |= Integer.MIN_VALUE;
        return this.f36648j.filter((Function2) null, this);
    }
}
