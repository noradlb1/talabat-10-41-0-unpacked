package androidx.paging;

import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0003*\u00020\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult$Page;", "K", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagedList$Companion$create$resolvedInitialPage$1", f = "PagedList.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
public final class PagedList$Companion$create$resolvedInitialPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult.Page<K, T>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36854h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PagingSource f36855i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f36856j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagedList$Companion$create$resolvedInitialPage$1(PagingSource pagingSource, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.f36855i = pagingSource;
        this.f36856j = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PagedList$Companion$create$resolvedInitialPage$1(this.f36855i, this.f36856j, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PagedList$Companion$create$resolvedInitialPage$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36854h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f36854h = 1;
            obj = this.f36855i.load((PagingSource.LoadParams.Refresh) this.f36856j.element, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
        if (loadResult instanceof PagingSource.LoadResult.Page) {
            return (PagingSource.LoadResult.Page) loadResult;
        }
        if (loadResult instanceof PagingSource.LoadResult.Error) {
            throw ((PagingSource.LoadResult.Error) loadResult).getThrowable();
        }
        throw new NoWhenBranchMatchedException();
    }
}
