package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b'\u0018\u0000 **\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0005*+,-.B\u0007¢\u0006\u0004\b)\u0010(J'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0006\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0006\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H'J\u001e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H'J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J6\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001b*\u00020\u00012\u001e\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001cJ6\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001b*\u00020\u00012\u001e\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0 J*\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001b*\u00020\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cJ*\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001b*\u00020\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 R \u0010#\u001a\u00020\"8\u0010XD¢\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Landroidx/paging/PositionalDataSource;", "", "T", "Landroidx/paging/DataSource;", "", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "loadInitial$paging_common", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInitial", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "a", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "callback", "", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "loadRange", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Integer;", "getKeyInternal", "V", "Landroidx/arch/core/util/Function;", "", "function", "mapByPage", "Lkotlin/Function1;", "map", "", "isContiguous", "Z", "isContiguous$paging_common", "()Z", "isContiguous$paging_common$annotations", "()V", "<init>", "Companion", "LoadInitialCallback", "LoadInitialParams", "LoadRangeCallback", "LoadRangeParams", "paging-common"}, k = 1, mv = {1, 4, 2})
@Deprecated(message = "PositionalDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Int, T>", imports = {"androidx.paging.PagingSource"}))
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isContiguous;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$Companion;", "", "()V", "computeInitialLoadPosition", "", "params", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "totalCount", "computeInitialLoadSize", "initialLoadPosition", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int computeInitialLoadPosition(@NotNull LoadInitialParams loadInitialParams, int i11) {
            Intrinsics.checkNotNullParameter(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
            int i12 = loadInitialParams.requestedStartPosition;
            int i13 = loadInitialParams.requestedLoadSize;
            int i14 = loadInitialParams.pageSize;
            return Math.max(0, Math.min(((((i11 - i13) + i14) - 1) / i14) * i14, (i12 / i14) * i14));
        }

        @JvmStatic
        public final int computeInitialLoadSize(@NotNull LoadInitialParams loadInitialParams, int i11, int i12) {
            Intrinsics.checkNotNullParameter(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
            return Math.min(i12 - i11, loadInitialParams.requestedLoadSize);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "T", "", "()V", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class LoadInitialCallback<T> {
        public abstract void onResult(@NotNull List<? extends T> list, int i11);

        public abstract void onResult(@NotNull List<? extends T> list, int i11, int i12);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialParams;", "", "requestedStartPosition", "", "requestedLoadSize", "pageSize", "placeholdersEnabled", "", "(IIIZ)V", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static class LoadInitialParams {
        @JvmField
        public final int pageSize;
        @JvmField
        public final boolean placeholdersEnabled;
        @JvmField
        public final int requestedLoadSize;
        @JvmField
        public final int requestedStartPosition;

        public LoadInitialParams(int i11, int i12, int i13, boolean z11) {
            boolean z12;
            boolean z13;
            this.requestedStartPosition = i11;
            this.requestedLoadSize = i12;
            this.pageSize = i13;
            this.placeholdersEnabled = z11;
            boolean z14 = true;
            if (i11 >= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i12 >= 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (!(i13 < 0 ? false : z14)) {
                        throw new IllegalStateException(("invalid page size: " + i13).toString());
                    }
                    return;
                }
                throw new IllegalStateException(("invalid load size: " + i12).toString());
            }
            throw new IllegalStateException(("invalid start position: " + i11).toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H&¨\u0006\b"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "T", "", "()V", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class LoadRangeCallback<T> {
        public abstract void onResult(@NotNull List<? extends T> list);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeParams;", "", "startPosition", "", "loadSize", "(II)V", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static class LoadRangeParams {
        @JvmField
        public final int loadSize;
        @JvmField
        public final int startPosition;

        public LoadRangeParams(int i11, int i12) {
            this.startPosition = i11;
            this.loadSize = i12;
        }
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    @JvmStatic
    public static final int computeInitialLoadPosition(@NotNull LoadInitialParams loadInitialParams, int i11) {
        return Companion.computeInitialLoadPosition(loadInitialParams, i11);
    }

    @JvmStatic
    public static final int computeInitialLoadSize(@NotNull LoadInitialParams loadInitialParams, int i11, int i12) {
        return Companion.computeInitialLoadSize(loadInitialParams, i11, i12);
    }

    public static /* synthetic */ void isContiguous$paging_common$annotations() {
    }

    public final /* synthetic */ Object a(LoadRangeParams loadRangeParams, Continuation<? super DataSource.BaseResult<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadRange(loadRangeParams, new PositionalDataSource$loadRange$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl, this, loadRangeParams));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    @Nullable
    public final Object load$paging_common(@NotNull DataSource.Params<Integer> params, @NotNull Continuation<? super DataSource.BaseResult<T>> continuation) {
        if (params.getType$paging_common() == LoadType.REFRESH) {
            int initialLoadSize = params.getInitialLoadSize();
            int i11 = 0;
            if (params.getKey() != null) {
                int intValue = params.getKey().intValue();
                if (params.getPlaceholdersEnabled()) {
                    initialLoadSize = Math.max(initialLoadSize / params.getPageSize(), 2) * params.getPageSize();
                    i11 = Math.max(0, ((intValue - (initialLoadSize / 2)) / params.getPageSize()) * params.getPageSize());
                } else {
                    i11 = Math.max(0, intValue - (initialLoadSize / 2));
                }
            }
            return loadInitial$paging_common(new LoadInitialParams(i11, initialLoadSize, params.getPageSize(), params.getPlaceholdersEnabled()), continuation);
        }
        Integer key = params.getKey();
        Intrinsics.checkNotNull(key);
        int intValue2 = key.intValue();
        int pageSize = params.getPageSize();
        if (params.getType$paging_common() == LoadType.PREPEND) {
            pageSize = Math.min(pageSize, intValue2);
            intValue2 -= pageSize;
        }
        return a(new LoadRangeParams(intValue2, pageSize), continuation);
    }

    @WorkerThread
    public abstract void loadInitial(@NotNull LoadInitialParams loadInitialParams, @NotNull LoadInitialCallback<T> loadInitialCallback);

    @VisibleForTesting
    @Nullable
    public final Object loadInitial$paging_common(@NotNull LoadInitialParams loadInitialParams, @NotNull Continuation<? super DataSource.BaseResult<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadInitial(loadInitialParams, new PositionalDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1(cancellableContinuationImpl, this, loadInitialParams));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @WorkerThread
    public abstract void loadRange(@NotNull LoadRangeParams loadRangeParams, @NotNull LoadRangeCallback<T> loadRangeCallback);

    @NotNull
    public final Integer getKeyInternal$paging_common(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    @NotNull
    public final <V> PositionalDataSource<V> map(@NotNull Function<T, V> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new PositionalDataSource$map$1(function));
    }

    @NotNull
    public final <V> PositionalDataSource<V> mapByPage(@NotNull Function<List<T>, List<V>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPositionalDataSource(this, function);
    }

    @NotNull
    public final <V> PositionalDataSource<V> map(@NotNull Function1<? super T, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return mapByPage((Function) new PositionalDataSource$map$2(function1));
    }

    @NotNull
    public final <V> PositionalDataSource<V> mapByPage(@NotNull Function1<? super List<? extends T>, ? extends List<? extends V>> function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        return mapByPage((Function) new PositionalDataSource$mapByPage$1(function1));
    }
}
