package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u00040123B\u0007¢\u0006\u0004\b/\u0010.J0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016J*\u0010\u001b\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H&J*\u0010\u001c\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH&J*\u0010\u001d\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH&J\u0017\u0010!\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u001f\u0010 J<\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\"*\u00020\u00012\u001e\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020$0#J<\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\"*\u00020\u00012\u001e\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020$0'J0\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\"*\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020#J0\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\"*\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020'R \u0010)\u001a\u00020\b8\u0010XD¢\u0006\u0012\n\u0004\b)\u0010*\u0012\u0004\b-\u0010.\u001a\u0004\b+\u0010,\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Landroidx/paging/PageKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/paging/DataSource$BaseResult;", "continuation", "", "isAppend", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "continuationAsCallback", "Landroidx/paging/DataSource$Params;", "params", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "c", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "b", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "callback", "", "loadInitial", "loadBefore", "loadAfter", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeyInternal", "ToValue", "Landroidx/arch/core/util/Function;", "", "function", "mapByPage", "Lkotlin/Function1;", "map", "supportsPageDropping", "Z", "getSupportsPageDropping$paging_common", "()Z", "getSupportsPageDropping$paging_common$annotations", "()V", "<init>", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams", "paging-common"}, k = 1, mv = {1, 4, 2})
@Deprecated(message = "PageKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {
    private final boolean supportsPageDropping;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Key", "Value", "", "()V", "onResult", "", "data", "", "adjacentPageKey", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(@NotNull List<? extends Value> list, @Nullable Key key);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00018\u00022\b\u0010\n\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u000bJ?\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00018\u00022\b\u0010\n\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Key", "Value", "", "()V", "onResult", "", "data", "", "previousPageKey", "nextPageKey", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "position", "", "totalCount", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(@NotNull List<? extends Value> list, int i11, int i12, @Nullable Key key, @Nullable Key key2);

        public abstract void onResult(@NotNull List<? extends Value> list, @Nullable Key key, @Nullable Key key2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Key", "", "requestedLoadSize", "", "placeholdersEnabled", "", "(IZ)V", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static class LoadInitialParams<Key> {
        @JvmField
        public final boolean placeholdersEnabled;
        @JvmField
        public final int requestedLoadSize;

        public LoadInitialParams(int i11, boolean z11) {
            this.requestedLoadSize = i11;
            this.placeholdersEnabled = z11;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0003\u001a\u00028\u00028\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadParams;", "Key", "", "key", "requestedLoadSize", "", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static class LoadParams<Key> {
        @NotNull
        @JvmField
        public final Key key;
        @JvmField
        public final int requestedLoadSize;

        public LoadParams(@NotNull Key key2, int i11) {
            Intrinsics.checkNotNullParameter(key2, "key");
            this.key = key2;
            this.requestedLoadSize = i11;
        }
    }

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    /* access modifiers changed from: private */
    public final LoadCallback<Key, Value> continuationAsCallback(CancellableContinuation<? super DataSource.BaseResult<Value>> cancellableContinuation, boolean z11) {
        return new PageKeyedDataSource$continuationAsCallback$1(cancellableContinuation, z11);
    }

    public static /* synthetic */ void getSupportsPageDropping$paging_common$annotations() {
    }

    public final /* synthetic */ Object a(LoadParams<Key> loadParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadAfter(loadParams, continuationAsCallback(cancellableContinuationImpl, true));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final /* synthetic */ Object b(LoadParams<Key> loadParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadBefore(loadParams, continuationAsCallback(cancellableContinuationImpl, false));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final /* synthetic */ Object c(LoadInitialParams<Key> loadInitialParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadInitial(loadInitialParams, new PageKeyedDataSource$loadInitial$2$1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public Key getKeyInternal$paging_common(@NotNull Value value) {
        Intrinsics.checkNotNullParameter(value, "item");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    public boolean getSupportsPageDropping$paging_common() {
        return this.supportsPageDropping;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load$paging_common(@org.jetbrains.annotations.NotNull androidx.paging.DataSource.Params<Key> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.DataSource.BaseResult<Value>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.paging.PageKeyedDataSource$load$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.paging.PageKeyedDataSource$load$1 r0 = (androidx.paging.PageKeyedDataSource$load$1) r0
            int r1 = r0.f36847i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36847i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageKeyedDataSource$load$1 r0 = new androidx.paging.PageKeyedDataSource$load$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f36846h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36847i
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00b0
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x008f
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.paging.LoadType r8 = r7.getType$paging_common()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.REFRESH
            if (r8 != r2) goto L_0x0064
            androidx.paging.PageKeyedDataSource$LoadInitialParams r8 = new androidx.paging.PageKeyedDataSource$LoadInitialParams
            int r2 = r7.getInitialLoadSize()
            boolean r7 = r7.getPlaceholdersEnabled()
            r8.<init>(r2, r7)
            r0.f36847i = r5
            java.lang.Object r8 = r6.c(r8, r0)
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            androidx.paging.DataSource$BaseResult r8 = (androidx.paging.DataSource.BaseResult) r8
            goto L_0x00b2
        L_0x0064:
            java.lang.Object r8 = r7.getKey()
            if (r8 != 0) goto L_0x0071
            androidx.paging.DataSource$BaseResult$Companion r7 = androidx.paging.DataSource.BaseResult.Companion
            androidx.paging.DataSource$BaseResult r8 = r7.empty$paging_common()
            goto L_0x00b2
        L_0x0071:
            androidx.paging.LoadType r8 = r7.getType$paging_common()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.PREPEND
            if (r8 != r2) goto L_0x0092
            androidx.paging.PageKeyedDataSource$LoadParams r8 = new androidx.paging.PageKeyedDataSource$LoadParams
            java.lang.Object r2 = r7.getKey()
            int r7 = r7.getPageSize()
            r8.<init>(r2, r7)
            r0.f36847i = r4
            java.lang.Object r8 = r6.b(r8, r0)
            if (r8 != r1) goto L_0x008f
            return r1
        L_0x008f:
            androidx.paging.DataSource$BaseResult r8 = (androidx.paging.DataSource.BaseResult) r8
            goto L_0x00b2
        L_0x0092:
            androidx.paging.LoadType r8 = r7.getType$paging_common()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
            if (r8 != r2) goto L_0x00b3
            androidx.paging.PageKeyedDataSource$LoadParams r8 = new androidx.paging.PageKeyedDataSource$LoadParams
            java.lang.Object r2 = r7.getKey()
            int r7 = r7.getPageSize()
            r8.<init>(r2, r7)
            r0.f36847i = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            androidx.paging.DataSource$BaseResult r8 = (androidx.paging.DataSource.BaseResult) r8
        L_0x00b2:
            return r8
        L_0x00b3:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unsupported type "
            r0.append(r1)
            androidx.paging.LoadType r7 = r7.getType$paging_common()
            java.lang.String r7 = r7.toString()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageKeyedDataSource.load$paging_common(androidx.paging.DataSource$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract void loadAfter(@NotNull LoadParams<Key> loadParams, @NotNull LoadCallback<Key, Value> loadCallback);

    public abstract void loadBefore(@NotNull LoadParams<Key> loadParams, @NotNull LoadCallback<Key, Value> loadCallback);

    public abstract void loadInitial(@NotNull LoadInitialParams<Key> loadInitialParams, @NotNull LoadInitialCallback<Key, Value> loadInitialCallback);

    @NotNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(@NotNull Function<Value, ToValue> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new PageKeyedDataSource$map$1(function));
    }

    @NotNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(@NotNull Function<List<Value>, List<ToValue>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPageKeyedDataSource(this, function);
    }

    @NotNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(@NotNull Function1<? super Value, ? extends ToValue> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return mapByPage((Function) new PageKeyedDataSource$map$2(function1));
    }

    @NotNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(@NotNull Function1<? super List<? extends Value>, ? extends List<? extends ToValue>> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return mapByPage((Function) new PageKeyedDataSource$mapByPage$1(function1));
    }
}
