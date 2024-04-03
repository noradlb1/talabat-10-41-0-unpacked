package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J1\u0010\u000f\u001a\u00020\u00102\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0012H\bø\u0001\u0000¢\u0006\u0002\b\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006$"}, d2 = {"Landroidx/paging/MutableLoadStateCollection;", "", "()V", "append", "Landroidx/paging/LoadState;", "mediator", "Landroidx/paging/LoadStates;", "prepend", "refresh", "source", "computeHelperState", "previousState", "sourceRefreshState", "sourceState", "remoteState", "forEach", "", "op", "Lkotlin/Function3;", "Landroidx/paging/LoadType;", "", "forEach$paging_common", "get", "type", "remote", "set", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "sourceLoadStates", "remoteLoadStates", "state", "snapshot", "terminates", "loadType", "terminates$paging_common", "updateHelperStates", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class MutableLoadStateCollection {
    private LoadState append;
    /* access modifiers changed from: private */
    public LoadStates mediator;
    private LoadState prepend;
    private LoadState refresh;
    /* access modifiers changed from: private */
    public LoadStates source = LoadStates.Companion.getIDLE();

    public MutableLoadStateCollection() {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
        this.refresh = companion.getIncomplete$paging_common();
        this.prepend = companion.getIncomplete$paging_common();
        this.append = companion.getIncomplete$paging_common();
    }

    private final LoadState computeHelperState(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadState loadState4) {
        if (loadState4 == null) {
            return loadState3;
        }
        if (!(loadState instanceof LoadState.Loading) || (((loadState2 instanceof LoadState.NotLoading) && (loadState4 instanceof LoadState.NotLoading)) || (loadState4 instanceof LoadState.Error))) {
            return loadState4;
        }
        return loadState;
    }

    private final void updateHelperStates() {
        LoadState loadState;
        LoadState loadState2;
        LoadState loadState3 = this.refresh;
        LoadState refresh2 = this.source.getRefresh();
        LoadState refresh3 = this.source.getRefresh();
        LoadStates loadStates = this.mediator;
        LoadState loadState4 = null;
        if (loadStates != null) {
            loadState = loadStates.getRefresh();
        } else {
            loadState = null;
        }
        this.refresh = computeHelperState(loadState3, refresh2, refresh3, loadState);
        LoadState loadState5 = this.prepend;
        LoadState refresh4 = this.source.getRefresh();
        LoadState prepend2 = this.source.getPrepend();
        LoadStates loadStates2 = this.mediator;
        if (loadStates2 != null) {
            loadState2 = loadStates2.getPrepend();
        } else {
            loadState2 = null;
        }
        this.prepend = computeHelperState(loadState5, refresh4, prepend2, loadState2);
        LoadState loadState6 = this.append;
        LoadState refresh5 = this.source.getRefresh();
        LoadState append2 = this.source.getAppend();
        LoadStates loadStates3 = this.mediator;
        if (loadStates3 != null) {
            loadState4 = loadStates3.getAppend();
        }
        this.append = computeHelperState(loadState6, refresh5, append2, loadState4);
    }

    public final void forEach$paging_common(@NotNull Function3<? super LoadType, ? super Boolean, ? super LoadState, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "op");
        LoadStates access$getSource$p = this.source;
        LoadType loadType = LoadType.REFRESH;
        LoadState refresh2 = access$getSource$p.getRefresh();
        Boolean bool = Boolean.FALSE;
        function3.invoke(loadType, bool, refresh2);
        LoadType loadType2 = LoadType.PREPEND;
        function3.invoke(loadType2, bool, access$getSource$p.getPrepend());
        LoadType loadType3 = LoadType.APPEND;
        function3.invoke(loadType3, bool, access$getSource$p.getAppend());
        LoadStates access$getMediator$p = this.mediator;
        if (access$getMediator$p != null) {
            LoadState refresh3 = access$getMediator$p.getRefresh();
            Boolean bool2 = Boolean.TRUE;
            function3.invoke(loadType, bool2, refresh3);
            function3.invoke(loadType2, bool2, access$getMediator$p.getPrepend());
            function3.invoke(loadType3, bool2, access$getMediator$p.getAppend());
        }
    }

    @Nullable
    public final LoadState get(@NotNull LoadType loadType, boolean z11) {
        LoadStates loadStates;
        Intrinsics.checkNotNullParameter(loadType, "type");
        if (z11) {
            loadStates = this.mediator;
        } else {
            loadStates = this.source;
        }
        if (loadStates != null) {
            return loadStates.get$paging_common(loadType);
        }
        return null;
    }

    public final void set(@NotNull CombinedLoadStates combinedLoadStates) {
        Intrinsics.checkNotNullParameter(combinedLoadStates, "combinedLoadStates");
        this.refresh = combinedLoadStates.getRefresh();
        this.prepend = combinedLoadStates.getPrepend();
        this.append = combinedLoadStates.getAppend();
        this.source = combinedLoadStates.getSource();
        this.mediator = combinedLoadStates.getMediator();
    }

    @NotNull
    public final CombinedLoadStates snapshot() {
        return new CombinedLoadStates(this.refresh, this.prepend, this.append, this.source, this.mediator);
    }

    public final boolean terminates$paging_common(@NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        LoadState loadState = get(loadType, false);
        Intrinsics.checkNotNull(loadState);
        if (!loadState.getEndOfPaginationReached()) {
            return false;
        }
        LoadState loadState2 = get(loadType, true);
        if (loadState2 == null || loadState2.getEndOfPaginationReached()) {
            return true;
        }
        return false;
    }

    public final void set(@NotNull LoadStates loadStates, @Nullable LoadStates loadStates2) {
        Intrinsics.checkNotNullParameter(loadStates, "sourceLoadStates");
        this.source = loadStates;
        this.mediator = loadStates2;
        updateHelperStates();
    }

    public final boolean set(@NotNull LoadType loadType, boolean z11, @NotNull LoadState loadState) {
        boolean z12;
        LoadStates loadStates;
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        if (z11) {
            LoadStates loadStates2 = this.mediator;
            if (loadStates2 != null) {
                loadStates = loadStates2;
            } else {
                loadStates = LoadStates.Companion.getIDLE();
            }
            LoadStates modifyState$paging_common = loadStates.modifyState$paging_common(loadType, loadState);
            this.mediator = modifyState$paging_common;
            z12 = Intrinsics.areEqual((Object) modifyState$paging_common, (Object) loadStates2);
        } else {
            LoadStates loadStates3 = this.source;
            LoadStates modifyState$paging_common2 = loadStates3.modifyState$paging_common(loadType, loadState);
            this.source = modifyState$paging_common2;
            z12 = Intrinsics.areEqual((Object) modifyState$paging_common2, (Object) loadStates3);
        }
        boolean z13 = !z12;
        updateHelperStates();
        return z13;
    }
}
