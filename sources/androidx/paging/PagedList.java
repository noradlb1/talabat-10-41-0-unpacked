package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.paging.LoadState;
import androidx.paging.PagingSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\b'\u0018\u0000 d*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0006abcdefB?\b\u0000\u0012\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0012J \u0010?\u001a\u00020(2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010B2\u0006\u0010@\u001a\u00020\u0012H\u0007J \u0010C\u001a\u00020(2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%J\b\u0010E\u001a\u00020(H&J\"\u0010F\u001a\u00020(2\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%H'J\u001d\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020'H\u0000¢\u0006\u0002\bJJ\u0018\u0010K\u001a\u0004\u0018\u00018\u00002\u0006\u0010L\u001a\u00020*H\u0002¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0007J\b\u0010P\u001a\u00020*H\u0007J\u000e\u0010Q\u001a\u00020(2\u0006\u0010L\u001a\u00020*J\u0010\u0010R\u001a\u00020(2\u0006\u0010L\u001a\u00020*H'J\u0018\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*H\u0007J\u001d\u0010V\u001a\u00020(2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*H\u0000¢\u0006\u0002\bWJ\u0018\u0010X\u001a\u00020(2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*H\u0007J\u000e\u0010Y\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0012J \u0010Z\u001a\u00020(2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%J\b\u0010[\u001a\u00020(H\u0016J\u0018\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u00020&2\u0006\u0010^\u001a\u00020'H\u0017J\u0012\u0010_\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0007J\f\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000BR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00188FX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0014\u0010 \u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u0004\u0018\u00010\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R,\u0010$\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%0\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R \u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b2\u0010,R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0014\u0010;\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010,R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006g"}, d2 = {"Landroidx/paging/PagedList;", "T", "", "Ljava/util/AbstractList;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "storage", "Landroidx/paging/PagedStorage;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedStorage;Landroidx/paging/PagedList$Config;)V", "callbacks", "", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "getConfig", "()Landroidx/paging/PagedList$Config;", "getCoroutineScope$paging_common", "()Lkotlinx/coroutines/CoroutineScope;", "dataSource", "Landroidx/paging/DataSource;", "getDataSource$annotations", "()V", "getDataSource", "()Landroidx/paging/DataSource;", "isDetached", "", "()Z", "isImmutable", "lastKey", "getLastKey", "()Ljava/lang/Object;", "loadStateListeners", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "", "loadedCount", "", "getLoadedCount", "()I", "getNotifyDispatcher$paging_common", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getPagingSource", "()Landroidx/paging/PagingSource;", "positionOffset", "getPositionOffset", "refreshRetryCallback", "Ljava/lang/Runnable;", "getRefreshRetryCallback$paging_common", "()Ljava/lang/Runnable;", "setRefreshRetryCallback$paging_common", "(Ljava/lang/Runnable;)V", "requiredRemainder", "getRequiredRemainder$paging_common", "size", "getSize", "getStorage$paging_common", "()Landroidx/paging/PagedStorage;", "addWeakCallback", "callback", "previousSnapshot", "", "addWeakLoadStateListener", "listener", "detach", "dispatchCurrentLoadState", "dispatchStateChangeAsync", "type", "state", "dispatchStateChangeAsync$paging_common", "get", "index", "(I)Ljava/lang/Object;", "getNullPaddedList", "Landroidx/paging/NullPaddedList;", "lastLoad", "loadAround", "loadAroundInternal", "notifyChanged", "position", "count", "notifyInserted", "notifyInserted$paging_common", "notifyRemoved", "removeWeakCallback", "removeWeakLoadStateListener", "retry", "setInitialLoadState", "loadType", "loadState", "setRetryCallback", "snapshot", "BoundaryCallback", "Builder", "Callback", "Companion", "Config", "LoadStateManager", "paging-common"}, k = 1, mv = {1, 4, 2})
@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
public abstract class PagedList<T> extends AbstractList<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<WeakReference<Callback>> callbacks = new ArrayList();
    @NotNull
    private final Config config;
    @NotNull
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public final List<WeakReference<Function2<LoadType, LoadState, Unit>>> loadStateListeners = new ArrayList();
    @NotNull
    private final CoroutineDispatcher notifyDispatcher;
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private final PagingSource<?, T> pagingSource;
    @Nullable
    private Runnable refreshRetryCallback;
    private final int requiredRemainder;
    @NotNull
    private final PagedStorage<T> storage;

    @MainThread
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Landroidx/paging/PagedList$BoundaryCallback;", "T", "", "()V", "onItemAtEndLoaded", "", "itemAtEnd", "(Ljava/lang/Object;)V", "onItemAtFrontLoaded", "itemAtFront", "onZeroItemsLoaded", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class BoundaryCallback<T> {
        public void onItemAtEndLoaded(@NotNull T t11) {
            Intrinsics.checkNotNullParameter(t11, "itemAtEnd");
        }

        public void onItemAtFrontLoaded(@NotNull T t11) {
            Intrinsics.checkNotNullParameter(t11, "itemAtFront");
        }

        public void onZeroItemsLoaded() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Landroidx/paging/PagedList$Callback;", "", "()V", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class Callback {
        public abstract void onChanged(int i11, int i12);

        public abstract void onInserted(int i11, int i12);

        public abstract void onRemoved(int i11, int i12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0006*\u00020\u0001\"\b\b\u0002\u0010\u0005*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00050\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u0001H\u0006H\u0007¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Landroidx/paging/PagedList$Companion;", "", "()V", "create", "Landroidx/paging/PagedList;", "T", "K", "pagingSource", "Landroidx/paging/PagingSource;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "config", "Landroidx/paging/PagedList$Config;", "key", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)Landroidx/paging/PagedList;", "dispatchNaiveUpdatesSinceSnapshot", "", "currentSize", "", "snapshotSize", "callback", "Landroidx/paging/PagedList$Callback;", "dispatchNaiveUpdatesSinceSnapshot$paging_common", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @JvmStatic
        @NotNull
        public final <K, T> PagedList<T> create(@NotNull PagingSource<K, T> pagingSource, @Nullable PagingSource.LoadResult.Page<K, T> page, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2, @Nullable BoundaryCallback<T> boundaryCallback, @NotNull Config config, @Nullable K k11) {
            PagingSource.LoadResult.Page<K, T> page2;
            PagingSource<K, T> pagingSource2 = pagingSource;
            Config config2 = config;
            Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
            CoroutineScope coroutineScope2 = coroutineScope;
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcher;
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
            Intrinsics.checkNotNullParameter(coroutineDispatcher2, "fetchDispatcher");
            Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            if (page == null) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new PagingSource.LoadParams.Refresh(k11, config2.initialLoadSizeHint, config2.enablePlaceholders);
                page2 = (PagingSource.LoadResult.Page) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new PagedList$Companion$create$resolvedInitialPage$1(pagingSource, objectRef, (Continuation) null), 1, (Object) null);
            } else {
                K k12 = k11;
                page2 = page;
            }
            return new ContiguousPagedList(pagingSource, coroutineScope, coroutineDispatcher, coroutineDispatcher2, boundaryCallback, config, page2, k11);
        }

        public final void dispatchNaiveUpdatesSinceSnapshot$paging_common(int i11, int i12, @NotNull Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (i12 < i11) {
                if (i12 > 0) {
                    callback.onChanged(0, i12);
                }
                int i13 = i11 - i12;
                if (i13 > 0) {
                    callback.onInserted(i12, i13);
                    return;
                }
                return;
            }
            if (i11 > 0) {
                callback.onChanged(0, i11);
            }
            int i14 = i12 - i11;
            if (i14 != 0) {
                callback.onRemoved(i11, i14);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/paging/PagedList$Config;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSizeHint", "maxSize", "(IIZII)V", "Builder", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Config {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
        @JvmField
        public final boolean enablePlaceholders;
        @JvmField
        public final int initialLoadSizeHint;
        @JvmField
        public final int maxSize;
        @JvmField
        public final int pageSize;
        @JvmField
        public final int prefetchDistance;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/paging/PagedList$Config$Builder;", "", "()V", "enablePlaceholders", "", "initialLoadSizeHint", "", "maxSize", "pageSize", "prefetchDistance", "build", "Landroidx/paging/PagedList$Config;", "setEnablePlaceholders", "setInitialLoadSizeHint", "setMaxSize", "setPageSize", "setPrefetchDistance", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
        public static final class Builder {
            @NotNull
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
            private boolean enablePlaceholders = true;
            private int initialLoadSizeHint = -1;
            private int maxSize = Integer.MAX_VALUE;
            private int pageSize = -1;
            private int prefetchDistance = -1;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/PagedList$Config$Builder$Companion;", "", "()V", "DEFAULT_INITIAL_PAGE_MULTIPLIER", "", "paging-common"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @NotNull
            public final Config build() {
                if (this.prefetchDistance < 0) {
                    this.prefetchDistance = this.pageSize;
                }
                if (this.initialLoadSizeHint < 0) {
                    this.initialLoadSizeHint = this.pageSize * 3;
                }
                if (this.enablePlaceholders || this.prefetchDistance != 0) {
                    int i11 = this.maxSize;
                    if (i11 == Integer.MAX_VALUE || i11 >= this.pageSize + (this.prefetchDistance * 2)) {
                        return new Config(this.pageSize, this.prefetchDistance, this.enablePlaceholders, this.initialLoadSizeHint, this.maxSize);
                    }
                    throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist" + ", pageSize=" + this.pageSize + ", prefetchDist=" + this.prefetchDistance + ", maxSize=" + this.maxSize);
                }
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }

            @NotNull
            public final Builder setEnablePlaceholders(boolean z11) {
                this.enablePlaceholders = z11;
                return this;
            }

            @NotNull
            public final Builder setInitialLoadSizeHint(@IntRange(from = 1) int i11) {
                this.initialLoadSizeHint = i11;
                return this;
            }

            @NotNull
            public final Builder setMaxSize(@IntRange(from = 2) int i11) {
                this.maxSize = i11;
                return this;
            }

            @NotNull
            public final Builder setPageSize(@IntRange(from = 1) int i11) {
                if (i11 >= 1) {
                    this.pageSize = i11;
                    return this;
                }
                throw new IllegalArgumentException("Page size must be a positive number");
            }

            @NotNull
            public final Builder setPrefetchDistance(@IntRange(from = 0) int i11) {
                this.prefetchDistance = i11;
                return this;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/paging/PagedList$Config$Companion;", "", "()V", "MAX_SIZE_UNBOUNDED", "", "getMAX_SIZE_UNBOUNDED$annotations", "paging-common"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
            }
        }

        public Config(int i11, int i12, boolean z11, int i13, int i14) {
            this.pageSize = i11;
            this.prefetchDistance = i12;
            this.enablePlaceholders = z11;
            this.initialLoadSizeHint = i13;
            this.maxSize = i14;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0012J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H'J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0018"}, d2 = {"Landroidx/paging/PagedList$LoadStateManager;", "", "()V", "endState", "Landroidx/paging/LoadState;", "getEndState", "()Landroidx/paging/LoadState;", "setEndState", "(Landroidx/paging/LoadState;)V", "refreshState", "getRefreshState", "setRefreshState", "startState", "getStartState", "setStartState", "dispatchCurrentLoadState", "", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "onStateChanged", "type", "state", "setState", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static abstract class LoadStateManager {
        @NotNull
        private LoadState endState;
        @NotNull
        private LoadState refreshState;
        @NotNull
        private LoadState startState;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LoadType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[LoadType.REFRESH.ordinal()] = 1;
                iArr[LoadType.PREPEND.ordinal()] = 2;
                iArr[LoadType.APPEND.ordinal()] = 3;
            }
        }

        public LoadStateManager() {
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
            this.refreshState = companion.getIncomplete$paging_common();
            this.startState = companion.getIncomplete$paging_common();
            this.endState = companion.getIncomplete$paging_common();
        }

        public final void dispatchCurrentLoadState(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "callback");
            function2.invoke(LoadType.REFRESH, this.refreshState);
            function2.invoke(LoadType.PREPEND, this.startState);
            function2.invoke(LoadType.APPEND, this.endState);
        }

        @NotNull
        public final LoadState getEndState() {
            return this.endState;
        }

        @NotNull
        public final LoadState getRefreshState() {
            return this.refreshState;
        }

        @NotNull
        public final LoadState getStartState() {
            return this.startState;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract void onStateChanged(@NotNull LoadType loadType, @NotNull LoadState loadState);

        public final void setEndState(@NotNull LoadState loadState) {
            Intrinsics.checkNotNullParameter(loadState, "<set-?>");
            this.endState = loadState;
        }

        public final void setRefreshState(@NotNull LoadState loadState) {
            Intrinsics.checkNotNullParameter(loadState, "<set-?>");
            this.refreshState = loadState;
        }

        public final void setStartState(@NotNull LoadState loadState) {
            Intrinsics.checkNotNullParameter(loadState, "<set-?>");
            this.startState = loadState;
        }

        public final void setState(@NotNull LoadType loadType, @NotNull LoadState loadState) {
            Intrinsics.checkNotNullParameter(loadType, "type");
            Intrinsics.checkNotNullParameter(loadState, "state");
            int i11 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (!Intrinsics.areEqual((Object) this.endState, (Object) loadState)) {
                            this.endState = loadState;
                        } else {
                            return;
                        }
                    }
                } else if (!Intrinsics.areEqual((Object) this.startState, (Object) loadState)) {
                    this.startState = loadState;
                } else {
                    return;
                }
            } else if (!Intrinsics.areEqual((Object) this.refreshState, (Object) loadState)) {
                this.refreshState = loadState;
            } else {
                return;
            }
            onStateChanged(loadType, loadState);
        }
    }

    public PagedList(@NotNull PagingSource<?, T> pagingSource2, @NotNull CoroutineScope coroutineScope2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull PagedStorage<T> pagedStorage, @NotNull Config config2) {
        Intrinsics.checkNotNullParameter(pagingSource2, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(pagedStorage, "storage");
        Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.pagingSource = pagingSource2;
        this.coroutineScope = coroutineScope2;
        this.notifyDispatcher = coroutineDispatcher;
        this.storage = pagedStorage;
        this.config = config2;
        this.requiredRemainder = (config2.prefetchDistance * 2) + config2.pageSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @JvmStatic
    @NotNull
    public static final <K, T> PagedList<T> create(@NotNull PagingSource<K, T> pagingSource2, @Nullable PagingSource.LoadResult.Page<K, T> page, @NotNull CoroutineScope coroutineScope2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2, @Nullable BoundaryCallback<T> boundaryCallback, @NotNull Config config2, @Nullable K k11) {
        return Companion.create(pagingSource2, page, coroutineScope2, coroutineDispatcher, coroutineDispatcher2, boundaryCallback, config2, k11);
    }

    @Deprecated(message = "DataSource is deprecated and has been replaced by PagingSource. PagedList offers indirect ways of controlling fetch ('loadAround()', 'retry()') so that you should not need to access the DataSource/PagingSource.")
    public static /* synthetic */ void getDataSource$annotations() {
    }

    @Deprecated(message = "Dispatching a diff since snapshot created is behavior that can be instead tracked by attaching a Callback to the PagedList that is mutating, and tracking changes since calling PagedList.snapshot().")
    public final void addWeakCallback(@Nullable List<? extends T> list, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(list == null || list == this)) {
            Companion.dispatchNaiveUpdatesSinceSnapshot$paging_common(size(), list.size(), callback);
        }
        addWeakCallback(callback);
    }

    public final void addWeakLoadStateListener(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.loadStateListeners, PagedList$addWeakLoadStateListener$1.INSTANCE);
        this.loadStateListeners.add(new WeakReference(function2));
        dispatchCurrentLoadState(function2);
    }

    public abstract void detach();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract void dispatchCurrentLoadState(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2);

    public final void dispatchStateChangeAsync$paging_common(@NotNull LoadType loadType, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.notifyDispatcher, (CoroutineStart) null, new PagedList$dispatchStateChangeAsync$1(this, loadType, loadState, (Continuation) null), 2, (Object) null);
    }

    @Nullable
    public T get(int i11) {
        return this.storage.get(i11);
    }

    @NotNull
    public final Config getConfig() {
        return this.config;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope$paging_common() {
        return this.coroutineScope;
    }

    @NotNull
    public final DataSource<?, T> getDataSource() {
        PagingSource pagingSource2 = getPagingSource();
        if (pagingSource2 instanceof LegacyPagingSource) {
            DataSource<?, T> dataSource$paging_common = ((LegacyPagingSource) pagingSource2).getDataSource$paging_common();
            if (dataSource$paging_common != null) {
                return dataSource$paging_common;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.DataSource<*, T>");
        }
        throw new IllegalStateException("Attempt to access dataSource on a PagedList that was instantiated with a " + pagingSource2.getClass().getSimpleName() + " instead of a DataSource");
    }

    @Nullable
    public abstract Object getLastKey();

    public final int getLoadedCount() {
        return this.storage.getStorageCount();
    }

    @NotNull
    public final CoroutineDispatcher getNotifyDispatcher$paging_common() {
        return this.notifyDispatcher;
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NullPaddedList<T> getNullPaddedList() {
        return this.storage;
    }

    @NotNull
    public PagingSource<?, T> getPagingSource() {
        return this.pagingSource;
    }

    public final int getPositionOffset() {
        return this.storage.getPositionOffset();
    }

    @Nullable
    public final Runnable getRefreshRetryCallback$paging_common() {
        return this.refreshRetryCallback;
    }

    public final int getRequiredRemainder$paging_common() {
        return this.requiredRemainder;
    }

    public int getSize() {
        return this.storage.size();
    }

    @NotNull
    public final PagedStorage<T> getStorage$paging_common() {
        return this.storage;
    }

    public abstract boolean isDetached();

    public boolean isImmutable() {
        return isDetached();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int lastLoad() {
        return this.storage.getLastLoadAroundIndex();
    }

    public final void loadAround(int i11) {
        if (i11 < 0 || i11 >= size()) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + size());
        }
        this.storage.setLastLoadAroundIndex(i11);
        loadAroundInternal(i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract void loadAroundInternal(int i11);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyChanged(int i11, int i12) {
        if (i12 != 0) {
            for (WeakReference weakReference : CollectionsKt___CollectionsKt.reversed(this.callbacks)) {
                Callback callback = (Callback) weakReference.get();
                if (callback != null) {
                    callback.onChanged(i11, i12);
                }
            }
        }
    }

    public final void notifyInserted$paging_common(int i11, int i12) {
        if (i12 != 0) {
            for (WeakReference weakReference : CollectionsKt___CollectionsKt.reversed(this.callbacks)) {
                Callback callback = (Callback) weakReference.get();
                if (callback != null) {
                    callback.onInserted(i11, i12);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyRemoved(int i11, int i12) {
        if (i12 != 0) {
            for (WeakReference weakReference : CollectionsKt___CollectionsKt.reversed(this.callbacks)) {
                Callback callback = (Callback) weakReference.get();
                if (callback != null) {
                    callback.onRemoved(i11, i12);
                }
            }
        }
    }

    public final /* bridge */ T remove(int i11) {
        return removeAt(i11);
    }

    public /* bridge */ Object removeAt(int i11) {
        return super.remove(i11);
    }

    public final void removeWeakCallback(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.callbacks, new PagedList$removeWeakCallback$1(callback));
    }

    public final void removeWeakLoadStateListener(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.loadStateListeners, new PagedList$removeWeakLoadStateListener$1(function2));
    }

    public void retry() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInitialLoadState(@NotNull LoadType loadType, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
    }

    public final void setRefreshRetryCallback$paging_common(@Nullable Runnable runnable) {
        this.refreshRetryCallback = runnable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setRetryCallback(@Nullable Runnable runnable) {
        this.refreshRetryCallback = runnable;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public final List<T> snapshot() {
        if (isImmutable()) {
            return this;
        }
        return new SnapshotPagedList(this);
    }

    public final void addWeakCallback(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.callbacks, PagedList$addWeakCallback$1.INSTANCE);
        this.callbacks.add(new WeakReference(callback));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u0002*\b\b\u0002\u0010\u0003*\u00020\u00022\u00020\u0002B#\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB7\b\u0016\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010B7\b\u0016\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0011J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u001cJ\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0013J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0007J!\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0017J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u0006\u0010'\u001a\u00020\"H\u0007R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/paging/PagedList$Builder;", "Key", "", "Value", "dataSource", "Landroidx/paging/DataSource;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/DataSource;Landroidx/paging/PagedList$Config;)V", "pageSize", "", "(Landroidx/paging/DataSource;I)V", "pagingSource", "Landroidx/paging/PagingSource;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/PagedList$Config;)V", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;I)V", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "initialKey", "Ljava/lang/Object;", "notifyDispatcher", "build", "Landroidx/paging/PagedList;", "setBoundaryCallback", "setCoroutineScope", "setFetchDispatcher", "setFetchExecutor", "fetchExecutor", "Ljava/util/concurrent/Executor;", "setInitialKey", "(Ljava/lang/Object;)Landroidx/paging/PagedList$Builder;", "setNotifyDispatcher", "setNotifyExecutor", "notifyExecutor", "paging-common"}, k = 1, mv = {1, 4, 2})
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData, which no longer supports constructing snapshots of loaded data manually.", replaceWith = @ReplaceWith(expression = "Pager.flow", imports = {"androidx.paging.Pager"}))
    public static final class Builder<Key, Value> {
        private BoundaryCallback<Value> boundaryCallback;
        private final Config config;
        private CoroutineScope coroutineScope;
        private DataSource<Key, Value> dataSource;
        private CoroutineDispatcher fetchDispatcher;
        private Key initialKey;
        private final PagingSource.LoadResult.Page<Key, Value> initialPage;
        private CoroutineDispatcher notifyDispatcher;
        private final PagingSource<Key, Value> pagingSource;

        public Builder(@NotNull DataSource<Key, Value> dataSource2, @NotNull Config config2) {
            Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
            Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.coroutineScope = GlobalScope.INSTANCE;
            this.pagingSource = null;
            this.dataSource = dataSource2;
            this.initialPage = null;
            this.config = config2;
        }

        @NotNull
        public final PagedList<Value> build() {
            LegacyPagingSource legacyPagingSource;
            boolean z11;
            LegacyPagingSource legacyPagingSource2;
            CoroutineDispatcher coroutineDispatcher = this.fetchDispatcher;
            if (coroutineDispatcher == null) {
                coroutineDispatcher = Dispatchers.getIO();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            PagingSource<Key, Value> pagingSource2 = this.pagingSource;
            if (pagingSource2 != null) {
                legacyPagingSource = pagingSource2;
            } else {
                DataSource<Key, Value> dataSource2 = this.dataSource;
                if (dataSource2 != null) {
                    legacyPagingSource2 = new LegacyPagingSource(coroutineDispatcher2, dataSource2);
                    legacyPagingSource2.setPageSize(this.config.pageSize);
                } else {
                    legacyPagingSource2 = null;
                }
                legacyPagingSource = legacyPagingSource2;
            }
            if (legacyPagingSource != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Companion companion = PagedList.Companion;
                PagingSource.LoadResult.Page<Key, Value> page = this.initialPage;
                CoroutineScope coroutineScope2 = this.coroutineScope;
                CoroutineDispatcher coroutineDispatcher3 = this.notifyDispatcher;
                if (coroutineDispatcher3 == null) {
                    coroutineDispatcher3 = Dispatchers.getMain().getImmediate();
                }
                return companion.create(legacyPagingSource, page, coroutineScope2, coroutineDispatcher3, coroutineDispatcher2, this.boundaryCallback, this.config, this.initialKey);
            }
            throw new IllegalStateException("PagedList cannot be built without a PagingSource or DataSource".toString());
        }

        @NotNull
        public final Builder<Key, Value> setBoundaryCallback(@Nullable BoundaryCallback<Value> boundaryCallback2) {
            this.boundaryCallback = boundaryCallback2;
            return this;
        }

        @NotNull
        public final Builder<Key, Value> setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            this.coroutineScope = coroutineScope2;
            return this;
        }

        @NotNull
        public final Builder<Key, Value> setFetchDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher) {
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "fetchDispatcher");
            this.fetchDispatcher = coroutineDispatcher;
            return this;
        }

        @NotNull
        @Deprecated(message = "Passing an executor will cause it get wrapped as a CoroutineDispatcher, consider passing a CoroutineDispatcher directly", replaceWith = @ReplaceWith(expression = "setFetchDispatcher(fetchExecutor.asCoroutineDispatcher())", imports = {"kotlinx.coroutines.asCoroutineDispatcher"}))
        public final Builder<Key, Value> setFetchExecutor(@NotNull Executor executor) {
            Intrinsics.checkNotNullParameter(executor, "fetchExecutor");
            this.fetchDispatcher = ExecutorsKt.from(executor);
            return this;
        }

        @NotNull
        public final Builder<Key, Value> setInitialKey(@Nullable Key key) {
            this.initialKey = key;
            return this;
        }

        @NotNull
        public final Builder<Key, Value> setNotifyDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher) {
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
            this.notifyDispatcher = coroutineDispatcher;
            return this;
        }

        @NotNull
        @Deprecated(message = "Passing an executor will cause it get wrapped as a CoroutineDispatcher, consider passing a CoroutineDispatcher directly", replaceWith = @ReplaceWith(expression = "setNotifyDispatcher(fetchExecutor.asCoroutineDispatcher())", imports = {"kotlinx.coroutines.asCoroutineDispatcher"}))
        public final Builder<Key, Value> setNotifyExecutor(@NotNull Executor executor) {
            Intrinsics.checkNotNullParameter(executor, "notifyExecutor");
            this.notifyDispatcher = ExecutorsKt.from(executor);
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull DataSource<Key, Value> dataSource2, int i11) {
            this(dataSource2, PagedListConfigKt.Config$default(i11, 0, false, 0, 0, 30, (Object) null));
            Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
        }

        public Builder(@NotNull PagingSource<Key, Value> pagingSource2, @NotNull PagingSource.LoadResult.Page<Key, Value> page, @NotNull Config config2) {
            Intrinsics.checkNotNullParameter(pagingSource2, "pagingSource");
            Intrinsics.checkNotNullParameter(page, "initialPage");
            Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.coroutineScope = GlobalScope.INSTANCE;
            this.pagingSource = pagingSource2;
            this.dataSource = null;
            this.initialPage = page;
            this.config = config2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull PagingSource<Key, Value> pagingSource2, @NotNull PagingSource.LoadResult.Page<Key, Value> page, int i11) {
            this(pagingSource2, page, PagedListConfigKt.Config$default(i11, 0, false, 0, 0, 30, (Object) null));
            Intrinsics.checkNotNullParameter(pagingSource2, "pagingSource");
            Intrinsics.checkNotNullParameter(page, "initialPage");
        }
    }
}
