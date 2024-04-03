package androidx.paging;

import androidx.paging.LoadState;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002$%B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\u0018\u00010\u001eJ\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0014J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0007J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/paging/AccessorState;", "Key", "", "Value", "()V", "blockStates", "", "Landroidx/paging/AccessorState$BlockState;", "[Landroidx/paging/AccessorState$BlockState;", "errors", "Landroidx/paging/LoadState$Error;", "[Landroidx/paging/LoadState$Error;", "pendingRequests", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/AccessorState$PendingRequest;", "add", "", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "clearErrors", "", "clearPendingRequest", "clearPendingRequests", "computeLoadStates", "Landroidx/paging/LoadStates;", "computeLoadTypeState", "Landroidx/paging/LoadState;", "getPendingBoundary", "Lkotlin/Pair;", "getPendingRefresh", "setBlockState", "state", "setError", "errorState", "BlockState", "PendingRequest", "paging-common"}, k = 1, mv = {1, 4, 2})
final class AccessorState<Key, Value> {
    private final BlockState[] blockStates;
    private final LoadState.Error[] errors;
    private final ArrayDeque<PendingRequest<Key, Value>> pendingRequests;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/AccessorState$BlockState;", "", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common"}, k = 1, mv = {1, 4, 2})
    public enum BlockState {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/AccessorState$PendingRequest;", "Key", "", "Value", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getPagingState", "()Landroidx/paging/PagingState;", "setPagingState", "(Landroidx/paging/PagingState;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class PendingRequest<Key, Value> {
        @NotNull
        private final LoadType loadType;
        @NotNull
        private PagingState<Key, Value> pagingState;

        public PendingRequest(@NotNull LoadType loadType2, @NotNull PagingState<Key, Value> pagingState2) {
            Intrinsics.checkNotNullParameter(loadType2, "loadType");
            Intrinsics.checkNotNullParameter(pagingState2, "pagingState");
            this.loadType = loadType2;
            this.pagingState = pagingState2;
        }

        @NotNull
        public final LoadType getLoadType() {
            return this.loadType;
        }

        @NotNull
        public final PagingState<Key, Value> getPagingState() {
            return this.pagingState;
        }

        public final void setPagingState(@NotNull PagingState<Key, Value> pagingState2) {
            Intrinsics.checkNotNullParameter(pagingState2, "<set-?>");
            this.pagingState = pagingState2;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BlockState.COMPLETED.ordinal()] = 1;
            iArr[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            iArr[BlockState.UNBLOCKED.ordinal()] = 3;
        }
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i11 = 0; i11 < length; i11++) {
            blockStateArr[i11] = BlockState.UNBLOCKED;
        }
        this.blockStates = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i12 = 0; i12 < length2; i12++) {
            errorArr[i12] = null;
        }
        this.errors = errorArr;
        this.pendingRequests = new ArrayDeque<>();
    }

    private final LoadState computeLoadTypeState(LoadType loadType) {
        boolean z11;
        BlockState blockState = this.blockStates[loadType.ordinal()];
        ArrayDeque<PendingRequest<Key, Value>> arrayDeque = this.pendingRequests;
        boolean z12 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<T> it = arrayDeque.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((PendingRequest) it.next()).getLoadType() == loadType) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        z12 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z12 && blockState != BlockState.REQUIRES_REFRESH) {
            return LoadState.Loading.INSTANCE;
        }
        LoadState.Error error = this.errors[loadType.ordinal()];
        if (error != null) {
            return error;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[blockState.ordinal()];
        if (i11 == 1) {
            return LoadState.NotLoading.Companion.getComplete$paging_common();
        }
        if (i11 == 2) {
            return LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        if (i11 == 3) {
            return LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean add(@NotNull LoadType loadType, @NotNull PagingState<Key, Value> pagingState) {
        T t11;
        boolean z11;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        Iterator<T> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it.next();
            if (((PendingRequest) t11).getLoadType() == loadType) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        PendingRequest pendingRequest = (PendingRequest) t11;
        if (pendingRequest != null) {
            pendingRequest.setPagingState(pagingState);
            return false;
        }
        BlockState blockState = this.blockStates[loadType.ordinal()];
        if (blockState == BlockState.REQUIRES_REFRESH && loadType != LoadType.REFRESH) {
            this.pendingRequests.add(new PendingRequest(loadType, pagingState));
            return false;
        } else if (blockState != BlockState.UNBLOCKED && loadType != LoadType.REFRESH) {
            return false;
        } else {
            LoadType loadType2 = LoadType.REFRESH;
            if (loadType == loadType2) {
                setError(loadType2, (LoadState.Error) null);
            }
            if (this.errors[loadType.ordinal()] == null) {
                return this.pendingRequests.add(new PendingRequest(loadType, pagingState));
            }
            return false;
        }
    }

    public final void clearErrors() {
        int length = this.errors.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.errors[i11] = null;
        }
    }

    public final void clearPendingRequest(@NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.pendingRequests, new AccessorState$clearPendingRequest$1(loadType));
    }

    public final void clearPendingRequests() {
        this.pendingRequests.clear();
    }

    @NotNull
    public final LoadStates computeLoadStates() {
        return new LoadStates(computeLoadTypeState(LoadType.REFRESH), computeLoadTypeState(LoadType.PREPEND), computeLoadTypeState(LoadType.APPEND));
    }

    @Nullable
    public final Pair<LoadType, PagingState<Key, Value>> getPendingBoundary() {
        T t11;
        boolean z11;
        Iterator<T> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it.next();
            PendingRequest pendingRequest = (PendingRequest) t11;
            if (pendingRequest.getLoadType() == LoadType.REFRESH || this.blockStates[pendingRequest.getLoadType().ordinal()] != BlockState.UNBLOCKED) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        PendingRequest pendingRequest2 = (PendingRequest) t11;
        if (pendingRequest2 != null) {
            return TuplesKt.to(pendingRequest2.getLoadType(), pendingRequest2.getPagingState());
        }
        return null;
    }

    @Nullable
    public final PagingState<Key, Value> getPendingRefresh() {
        T t11;
        boolean z11;
        Iterator<T> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it.next();
            if (((PendingRequest) t11).getLoadType() == LoadType.REFRESH) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        PendingRequest pendingRequest = (PendingRequest) t11;
        if (pendingRequest != null) {
            return pendingRequest.getPagingState();
        }
        return null;
    }

    public final void setBlockState(@NotNull LoadType loadType, @NotNull BlockState blockState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(blockState, "state");
        this.blockStates[loadType.ordinal()] = blockState;
    }

    public final void setError(@NotNull LoadType loadType, @Nullable LoadState.Error error) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.errors[loadType.ordinal()] = error;
    }
}
