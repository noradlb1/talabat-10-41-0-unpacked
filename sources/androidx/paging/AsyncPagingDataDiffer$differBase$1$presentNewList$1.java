package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\fH@"}, d2 = {"", "T", "Landroidx/paging/NullPaddedList;", "previousList", "newList", "Landroidx/paging/CombinedLoadStates;", "newCombinedLoadStates", "", "lastAccessedIndex", "Lkotlin/Function0;", "", "onListPresentable", "Lkotlin/coroutines/Continuation;", "continuation", "presentNewList"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$differBase$1", f = "AsyncPagingDataDiffer.kt", i = {0, 0, 0, 0, 0}, l = {99}, m = "presentNewList", n = {"this", "previousList", "newList", "onListPresentable", "lastAccessedIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
public final class AsyncPagingDataDiffer$differBase$1$presentNewList$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36462h;

    /* renamed from: i  reason: collision with root package name */
    public int f36463i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AsyncPagingDataDiffer$differBase$1 f36464j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36465k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36466l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36467m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36468n;

    /* renamed from: o  reason: collision with root package name */
    public int f36469o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$differBase$1$presentNewList$1(AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1, Continuation continuation) {
        super(continuation);
        this.f36464j = asyncPagingDataDiffer$differBase$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36462h = obj;
        this.f36463i |= Integer.MIN_VALUE;
        return this.f36464j.presentNewList((NullPaddedList) null, (NullPaddedList) null, (CombinedLoadStates) null, 0, (Function0<Unit>) null, this);
    }
}
