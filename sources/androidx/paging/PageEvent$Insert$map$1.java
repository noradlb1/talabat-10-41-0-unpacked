package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00002\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00050\u0003H@"}, d2 = {"", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "Landroidx/paging/PageEvent;", "continuation", "map"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageEvent$Insert", f = "PageEvent.kt", i = {0, 0, 0, 0, 0}, l = {74}, m = "map", n = {"transform", "this_$iv$iv", "destination$iv$iv$iv", "it", "destination$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$5", "L$7"})
public final class PageEvent$Insert$map$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36678h;

    /* renamed from: i  reason: collision with root package name */
    public int f36679i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PageEvent.Insert f36680j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36681k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36682l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36683m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36684n;

    /* renamed from: o  reason: collision with root package name */
    public Object f36685o;

    /* renamed from: p  reason: collision with root package name */
    public Object f36686p;

    /* renamed from: q  reason: collision with root package name */
    public Object f36687q;

    /* renamed from: r  reason: collision with root package name */
    public Object f36688r;

    /* renamed from: s  reason: collision with root package name */
    public Object f36689s;

    /* renamed from: t  reason: collision with root package name */
    public Object f36690t;

    /* renamed from: u  reason: collision with root package name */
    public Object f36691u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageEvent$Insert$map$1(PageEvent.Insert insert, Continuation continuation) {
        super(continuation);
        this.f36680j = insert;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36678h = obj;
        this.f36679i |= Integer.MIN_VALUE;
        return this.f36680j.map((Function2) null, this);
    }
}
