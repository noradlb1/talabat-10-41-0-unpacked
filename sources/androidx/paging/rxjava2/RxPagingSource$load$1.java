package androidx.paging.rxjava2;

import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005H@"}, d2 = {"", "Key", "Value", "Landroidx/paging/PagingSource$LoadParams;", "params", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingSource$LoadResult;", "continuation", "load"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.rxjava2.RxPagingSource", f = "RxPagingSource.kt", i = {}, l = {37}, m = "load", n = {}, s = {})
public final class RxPagingSource$load$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37260h;

    /* renamed from: i  reason: collision with root package name */
    public int f37261i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RxPagingSource f37262j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxPagingSource$load$1(RxPagingSource rxPagingSource, Continuation continuation) {
        super(continuation);
        this.f37262j = rxPagingSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37260h = obj;
        this.f37261i |= Integer.MIN_VALUE;
        return this.f37262j.load((PagingSource.LoadParams) null, this);
    }
}
