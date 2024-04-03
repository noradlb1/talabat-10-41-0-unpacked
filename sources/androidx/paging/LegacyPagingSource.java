package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u001eB!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\u0010\tJ#\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002J+\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/paging/LegacyPagingSource;", "Key", "", "Value", "Landroidx/paging/PagingSource;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "dataSource", "Landroidx/paging/DataSource;", "(Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/DataSource;)V", "getDataSource$paging_common", "()Landroidx/paging/DataSource;", "jumpingSupported", "", "getJumpingSupported", "()Z", "pageSize", "", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "guessPageSize", "params", "Landroidx/paging/PagingSource$LoadParams;", "load", "Landroidx/paging/PagingSource$LoadResult;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPageSize", "", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_SIZE_NOT_SET = Integer.MIN_VALUE;
    @NotNull
    private final DataSource<Key, Value> dataSource;
    private final CoroutineDispatcher fetchDispatcher;
    private int pageSize = Integer.MIN_VALUE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.LegacyPagingSource$3", f = "LegacyPagingSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.LegacyPagingSource$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f36623h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ LegacyPagingSource f36624i;

        {
            this.f36624i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass3(this.f36624i, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f36623h == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.f36624i.getInvalid() && this.f36624i.getDataSource$paging_common().isInvalid()) {
                    this.f36624i.invalidate();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/LegacyPagingSource$Companion;", "", "()V", "PAGE_SIZE_NOT_SET", "", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DataSource.KeyType.POSITIONAL.ordinal()] = 1;
            iArr[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;
            iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;
        }
    }

    public LegacyPagingSource(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull DataSource<Key, Value> dataSource2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "fetchDispatcher");
        Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
        this.fetchDispatcher = coroutineDispatcher;
        this.dataSource = dataSource2;
        dataSource2.addInvalidatedCallback(new LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0(new Function0<Unit>(this) {
            public final void invoke() {
                ((LegacyPagingSource) this.receiver).invalidate();
            }
        }));
        registerInvalidatedCallback(new Function0<Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ LegacyPagingSource f36622g;

            {
                this.f36622g = r1;
            }

            public final void invoke() {
                this.f36622g.getDataSource$paging_common().removeInvalidatedCallback(new LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0(new Function0<Unit>(this.f36622g) {
                    public final void invoke() {
                        ((LegacyPagingSource) this.receiver).invalidate();
                    }
                }));
                this.f36622g.getDataSource$paging_common().invalidate();
            }
        });
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, coroutineDispatcher, (CoroutineStart) null, new AnonymousClass3(this, (Continuation) null), 2, (Object) null);
    }

    private final int guessPageSize(PagingSource.LoadParams<Key> loadParams) {
        if (!(loadParams instanceof PagingSource.LoadParams.Refresh) || loadParams.getLoadSize() % 3 != 0) {
            return loadParams.getLoadSize();
        }
        return loadParams.getLoadSize() / 3;
    }

    @NotNull
    public final DataSource<Key, Value> getDataSource$paging_common() {
        return this.dataSource;
    }

    public boolean getJumpingSupported() {
        return this.dataSource.getType$paging_common() == DataSource.KeyType.POSITIONAL;
    }

    @Nullable
    public Key getRefreshKey(@NotNull PagingState<Key, Value> pagingState) {
        int i11;
        Value closestItemToPosition;
        Intrinsics.checkNotNullParameter(pagingState, "state");
        int i12 = WhenMappings.$EnumSwitchMapping$0[this.dataSource.getType$paging_common().ordinal()];
        if (i12 == 1) {
            Integer anchorPosition = pagingState.getAnchorPosition();
            if (anchorPosition == null) {
                return null;
            }
            int intValue = anchorPosition.intValue();
            int access$getLeadingPlaceholderCount$p = intValue - pagingState.leadingPlaceholderCount;
            int i13 = 0;
            while (i13 < CollectionsKt__CollectionsKt.getLastIndex(pagingState.getPages()) && access$getLeadingPlaceholderCount$p > CollectionsKt__CollectionsKt.getLastIndex(pagingState.getPages().get(i13).getData())) {
                access$getLeadingPlaceholderCount$p -= pagingState.getPages().get(i13).getData().size();
                i13++;
            }
            PagingSource.LoadResult.Page<Key, Value> closestPageToPosition = pagingState.closestPageToPosition(intValue);
            if (closestPageToPosition == null || (i11 = closestPageToPosition.getPrevKey()) == null) {
                i11 = 0;
            }
            if (i11 != null) {
                return Integer.valueOf(((Integer) i11).intValue() + access$getLeadingPlaceholderCount$p);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } else if (i12 == 2) {
            return null;
        } else {
            if (i12 == 3) {
                Integer anchorPosition2 = pagingState.getAnchorPosition();
                if (anchorPosition2 == null || (closestItemToPosition = pagingState.closestItemToPosition(anchorPosition2.intValue())) == null) {
                    return null;
                }
                return this.dataSource.getKeyInternal$paging_common(closestItemToPosition);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object load(@NotNull PagingSource.LoadParams<Key> loadParams, @NotNull Continuation<? super PagingSource.LoadResult<Key, Value>> continuation) {
        LoadType loadType;
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else if (loadParams instanceof PagingSource.LoadParams.Prepend) {
            loadType = LoadType.PREPEND;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        LoadType loadType2 = loadType;
        if (this.pageSize == Integer.MIN_VALUE) {
            System.out.println("WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.pageSize = guessPageSize(loadParams);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DataSource.Params(loadType2, loadParams.getKey(), loadParams.getLoadSize(), loadParams.getPlaceholdersEnabled(), this.pageSize);
        return BuildersKt.withContext(this.fetchDispatcher, new LegacyPagingSource$load$2(this, objectRef, loadParams, (Continuation) null), continuation);
    }

    public final void setPageSize(int i11) {
        boolean z11;
        int i12 = this.pageSize;
        if (i12 == Integer.MIN_VALUE || i11 == i12) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.pageSize = i11;
            return;
        }
        throw new IllegalStateException(("Page size is already set to " + this.pageSize + '.').toString());
    }
}
