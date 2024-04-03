package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J&\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0015H\bø\u0001\u0000J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u001d\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"Landroidx/paging/LoadStates;", "", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)V", "getAppend", "()Landroidx/paging/LoadState;", "getPrepend", "getRefresh", "component1", "component2", "component3", "copy", "equals", "", "other", "forEach", "", "op", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "get", "loadType", "get$paging_common", "hashCode", "", "modifyState", "newState", "modifyState$paging_common", "toString", "", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class LoadStates {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final LoadStates IDLE;
    @NotNull
    private final LoadState append;
    @NotNull
    private final LoadState prepend;
    @NotNull
    private final LoadState refresh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/LoadStates$Companion;", "", "()V", "IDLE", "Landroidx/paging/LoadStates;", "getIDLE", "()Landroidx/paging/LoadStates;", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LoadStates getIDLE() {
            return LoadStates.IDLE;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.APPEND;
            iArr[loadType.ordinal()] = 1;
            LoadType loadType2 = LoadType.PREPEND;
            iArr[loadType2.ordinal()] = 2;
            LoadType loadType3 = LoadType.REFRESH;
            iArr[loadType3.ordinal()] = 3;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[loadType3.ordinal()] = 1;
            iArr2[loadType.ordinal()] = 2;
            iArr2[loadType2.ordinal()] = 3;
        }
    }

    static {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
        IDLE = new LoadStates(companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common());
    }

    public LoadStates(@NotNull LoadState loadState, @NotNull LoadState loadState2, @NotNull LoadState loadState3) {
        Intrinsics.checkNotNullParameter(loadState, "refresh");
        Intrinsics.checkNotNullParameter(loadState2, "prepend");
        Intrinsics.checkNotNullParameter(loadState3, "append");
        this.refresh = loadState;
        this.prepend = loadState2;
        this.append = loadState3;
    }

    public static /* synthetic */ LoadStates copy$default(LoadStates loadStates, LoadState loadState, LoadState loadState2, LoadState loadState3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            loadState = loadStates.refresh;
        }
        if ((i11 & 2) != 0) {
            loadState2 = loadStates.prepend;
        }
        if ((i11 & 4) != 0) {
            loadState3 = loadStates.append;
        }
        return loadStates.copy(loadState, loadState2, loadState3);
    }

    @NotNull
    public final LoadState component1() {
        return this.refresh;
    }

    @NotNull
    public final LoadState component2() {
        return this.prepend;
    }

    @NotNull
    public final LoadState component3() {
        return this.append;
    }

    @NotNull
    public final LoadStates copy(@NotNull LoadState loadState, @NotNull LoadState loadState2, @NotNull LoadState loadState3) {
        Intrinsics.checkNotNullParameter(loadState, "refresh");
        Intrinsics.checkNotNullParameter(loadState2, "prepend");
        Intrinsics.checkNotNullParameter(loadState3, "append");
        return new LoadStates(loadState, loadState2, loadState3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadStates)) {
            return false;
        }
        LoadStates loadStates = (LoadStates) obj;
        return Intrinsics.areEqual((Object) this.refresh, (Object) loadStates.refresh) && Intrinsics.areEqual((Object) this.prepend, (Object) loadStates.prepend) && Intrinsics.areEqual((Object) this.append, (Object) loadStates.append);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void forEach(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "op");
        function2.invoke(LoadType.REFRESH, getRefresh());
        function2.invoke(LoadType.PREPEND, getPrepend());
        function2.invoke(LoadType.APPEND, getAppend());
    }

    @NotNull
    public final LoadState get$paging_common(@NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i11 = WhenMappings.$EnumSwitchMapping$1[loadType.ordinal()];
        if (i11 == 1) {
            return this.refresh;
        }
        if (i11 == 2) {
            return this.append;
        }
        if (i11 == 3) {
            return this.prepend;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final LoadState getAppend() {
        return this.append;
    }

    @NotNull
    public final LoadState getPrepend() {
        return this.prepend;
    }

    @NotNull
    public final LoadState getRefresh() {
        return this.refresh;
    }

    public int hashCode() {
        LoadState loadState = this.refresh;
        int i11 = 0;
        int hashCode = (loadState != null ? loadState.hashCode() : 0) * 31;
        LoadState loadState2 = this.prepend;
        int hashCode2 = (hashCode + (loadState2 != null ? loadState2.hashCode() : 0)) * 31;
        LoadState loadState3 = this.append;
        if (loadState3 != null) {
            i11 = loadState3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public final LoadStates modifyState$paging_common(@NotNull LoadType loadType, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "newState");
        int i11 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i11 == 1) {
            return copy$default(this, (LoadState) null, (LoadState) null, loadState, 3, (Object) null);
        }
        if (i11 == 2) {
            return copy$default(this, (LoadState) null, loadState, (LoadState) null, 5, (Object) null);
        }
        if (i11 == 3) {
            return copy$default(this, loadState, (LoadState) null, (LoadState) null, 6, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String toString() {
        return "LoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ")";
    }
}
