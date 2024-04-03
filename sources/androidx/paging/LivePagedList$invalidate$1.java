package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.LivePagedList$invalidate$1", f = "LivePagedList.kt", i = {0, 1, 1}, l = {79, 86}, m = "invokeSuspend", n = {"pagingSource", "pagingSource", "lastKey"}, s = {"L$0", "L$0", "L$1"})
public final class LivePagedList$invalidate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f36630h;

    /* renamed from: i  reason: collision with root package name */
    public Object f36631i;

    /* renamed from: j  reason: collision with root package name */
    public int f36632j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LivePagedList f36633k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LivePagedList$invalidate$1(LivePagedList livePagedList, Continuation continuation) {
        super(2, continuation);
        this.f36633k = livePagedList;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LivePagedList$invalidate$1(this.f36633k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LivePagedList$invalidate$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ad  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f36632j
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r0 = r9.f36631i
            java.lang.Object r1 = r9.f36630h
            androidx.paging.PagingSource r1 = (androidx.paging.PagingSource) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r0
            goto L_0x0090
        L_0x001a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0022:
            java.lang.Object r1 = r9.f36630h
            androidx.paging.PagingSource r1 = (androidx.paging.PagingSource) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006d
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.paging.LivePagedList r10 = r9.f36633k
            androidx.paging.PagedList r10 = r10.currentData
            androidx.paging.PagingSource r10 = r10.getPagingSource()
            androidx.paging.LivePagedList r1 = r9.f36633k
            kotlin.jvm.functions.Function0 r1 = r1.callback
            r10.unregisterInvalidatedCallback(r1)
            androidx.paging.LivePagedList r10 = r9.f36633k
            kotlin.jvm.functions.Function0 r10 = r10.pagingSourceFactory
            java.lang.Object r10 = r10.invoke()
            androidx.paging.PagingSource r10 = (androidx.paging.PagingSource) r10
            androidx.paging.LivePagedList r1 = r9.f36633k
            kotlin.jvm.functions.Function0 r1 = r1.callback
            r10.registerInvalidatedCallback(r1)
            androidx.paging.LivePagedList r1 = r9.f36633k
            kotlinx.coroutines.CoroutineDispatcher r1 = r1.notifyDispatcher
            androidx.paging.LivePagedList$invalidate$1$1 r4 = new androidx.paging.LivePagedList$invalidate$1$1
            r5 = 0
            r4.<init>(r9, r5)
            r9.f36630h = r10
            r9.f36632j = r3
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)
            if (r1 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r1 = r10
        L_0x006d:
            androidx.paging.LivePagedList r10 = r9.f36633k
            androidx.paging.PagedList r10 = r10.currentData
            java.lang.Object r10 = r10.getLastKey()
            androidx.paging.LivePagedList r3 = r9.f36633k
            androidx.paging.PagedList$Config r3 = r3.config
            androidx.paging.PagingSource$LoadParams r3 = androidx.paging.PagingSourceKt.toRefreshLoadParams(r3, r10)
            r9.f36630h = r1
            r9.f36631i = r10
            r9.f36632j = r2
            java.lang.Object r2 = r1.load(r3, r9)
            if (r2 != r0) goto L_0x008e
            return r0
        L_0x008e:
            r8 = r10
            r10 = r2
        L_0x0090:
            androidx.paging.PagingSource$LoadResult r10 = (androidx.paging.PagingSource.LoadResult) r10
            boolean r0 = r10 instanceof androidx.paging.PagingSource.LoadResult.Error
            if (r0 == 0) goto L_0x00ad
            androidx.paging.LivePagedList r0 = r9.f36633k
            androidx.paging.PagedList r0 = r0.currentData
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH
            androidx.paging.LoadState$Error r2 = new androidx.paging.LoadState$Error
            androidx.paging.PagingSource$LoadResult$Error r10 = (androidx.paging.PagingSource.LoadResult.Error) r10
            java.lang.Throwable r10 = r10.getThrowable()
            r2.<init>(r10)
            r0.setInitialLoadState(r1, r2)
            goto L_0x00eb
        L_0x00ad:
            boolean r0 = r10 instanceof androidx.paging.PagingSource.LoadResult.Page
            if (r0 == 0) goto L_0x00eb
            androidx.paging.PagedList$Companion r0 = androidx.paging.PagedList.Companion
            r2 = r10
            androidx.paging.PagingSource$LoadResult$Page r2 = (androidx.paging.PagingSource.LoadResult.Page) r2
            androidx.paging.LivePagedList r10 = r9.f36633k
            kotlinx.coroutines.CoroutineScope r3 = r10.coroutineScope
            androidx.paging.LivePagedList r10 = r9.f36633k
            kotlinx.coroutines.CoroutineDispatcher r4 = r10.notifyDispatcher
            androidx.paging.LivePagedList r10 = r9.f36633k
            kotlinx.coroutines.CoroutineDispatcher r5 = r10.fetchDispatcher
            androidx.paging.LivePagedList r10 = r9.f36633k
            androidx.paging.PagedList$BoundaryCallback r6 = r10.boundaryCallback
            androidx.paging.LivePagedList r10 = r9.f36633k
            androidx.paging.PagedList$Config r7 = r10.config
            androidx.paging.PagedList r10 = r0.create(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.paging.LivePagedList r0 = r9.f36633k
            androidx.paging.PagedList r1 = r0.currentData
            r0.onItemUpdate(r1, r10)
            androidx.paging.LivePagedList r0 = r9.f36633k
            r0.currentData = r10
            androidx.paging.LivePagedList r0 = r9.f36633k
            r0.postValue(r10)
        L_0x00eb:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.LivePagedList$invalidate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
