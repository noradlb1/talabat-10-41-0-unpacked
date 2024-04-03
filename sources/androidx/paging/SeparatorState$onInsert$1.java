package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H@"}, d2 = {"", "R", "T", "Landroidx/paging/PageEvent$Insert;", "event", "Lkotlin/coroutines/Continuation;", "continuation", "onInsert"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9}, l = {303, 366, 378, 384, 396, 405, 427, 436, 449, 460}, m = "onInsert", n = {"this", "event", "this", "event", "outList", "stashOutList", "firstNonEmptyPage", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "pageAfter", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "firstNonEmptyPage", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "firstNonEmptyPage", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "lastStash", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "lastNonEmptyPageIndex", "iterator$iv", "page", "pageBefore", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "lastNonEmptyPageIndex", "iterator$iv", "page", "pageBefore", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "lastNonEmptyPageIndex", "pageAfter", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "pageBefore"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class SeparatorState$onInsert$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37094h;

    /* renamed from: i  reason: collision with root package name */
    public int f37095i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SeparatorState f37096j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37097k;

    /* renamed from: l  reason: collision with root package name */
    public Object f37098l;

    /* renamed from: m  reason: collision with root package name */
    public Object f37099m;

    /* renamed from: n  reason: collision with root package name */
    public Object f37100n;

    /* renamed from: o  reason: collision with root package name */
    public Object f37101o;

    /* renamed from: p  reason: collision with root package name */
    public Object f37102p;

    /* renamed from: q  reason: collision with root package name */
    public Object f37103q;

    /* renamed from: r  reason: collision with root package name */
    public Object f37104r;

    /* renamed from: s  reason: collision with root package name */
    public Object f37105s;

    /* renamed from: t  reason: collision with root package name */
    public Object f37106t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f37107u;

    /* renamed from: v  reason: collision with root package name */
    public int f37108v;

    /* renamed from: w  reason: collision with root package name */
    public int f37109w;

    /* renamed from: x  reason: collision with root package name */
    public int f37110x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeparatorState$onInsert$1(SeparatorState separatorState, Continuation continuation) {
        super(continuation);
        this.f37096j = separatorState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37094h = obj;
        this.f37095i |= Integer.MIN_VALUE;
        return this.f37096j.onInsert((PageEvent.Insert) null, this);
    }
}
