package androidx.paging.rxjava2;

import androidx.paging.PagingSource;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J+\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/paging/rxjava2/RxPagingSource;", "Key", "", "Value", "Landroidx/paging/PagingSource;", "()V", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSingle", "Lio/reactivex/Single;", "paging-rxjava2_release"}, k = 1, mv = {1, 4, 2})
public abstract class RxPagingSource<Key, Value> extends PagingSource<Key, Value> {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull androidx.paging.PagingSource.LoadParams<Key> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<Key, Value>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.rxjava2.RxPagingSource$load$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.rxjava2.RxPagingSource$load$1 r0 = (androidx.paging.rxjava2.RxPagingSource$load$1) r0
            int r1 = r0.f37261i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37261i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.rxjava2.RxPagingSource$load$1 r0 = new androidx.paging.rxjava2.RxPagingSource$load$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f37260h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f37261i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            io.reactivex.Single r5 = r4.loadSingle(r5)
            r0.f37261i = r3
            java.lang.Object r6 = kotlinx.coroutines.rx2.RxAwaitKt.await(r5, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            java.lang.String r5 = "loadSingle(params).await()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.rxjava2.RxPagingSource.load(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public abstract Single<PagingSource.LoadResult<Key, Value>> loadSingle(@NotNull PagingSource.LoadParams<Key> loadParams);
}
