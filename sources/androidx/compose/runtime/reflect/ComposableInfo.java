package androidx.compose.runtime.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableInfo;", "", "isComposable", "", "realParamsCount", "", "changedParams", "defaultParams", "(ZIII)V", "getChangedParams", "()I", "getDefaultParams", "()Z", "getRealParamsCount", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ComposableInfo {
    private final int changedParams;
    private final int defaultParams;
    private final boolean isComposable;
    private final int realParamsCount;

    public ComposableInfo(boolean z11, int i11, int i12, int i13) {
        this.isComposable = z11;
        this.realParamsCount = i11;
        this.changedParams = i12;
        this.defaultParams = i13;
    }

    public static /* synthetic */ ComposableInfo copy$default(ComposableInfo composableInfo, boolean z11, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            z11 = composableInfo.isComposable;
        }
        if ((i14 & 2) != 0) {
            i11 = composableInfo.realParamsCount;
        }
        if ((i14 & 4) != 0) {
            i12 = composableInfo.changedParams;
        }
        if ((i14 & 8) != 0) {
            i13 = composableInfo.defaultParams;
        }
        return composableInfo.copy(z11, i11, i12, i13);
    }

    public final boolean component1() {
        return this.isComposable;
    }

    public final int component2() {
        return this.realParamsCount;
    }

    public final int component3() {
        return this.changedParams;
    }

    public final int component4() {
        return this.defaultParams;
    }

    @NotNull
    public final ComposableInfo copy(boolean z11, int i11, int i12, int i13) {
        return new ComposableInfo(z11, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComposableInfo)) {
            return false;
        }
        ComposableInfo composableInfo = (ComposableInfo) obj;
        return this.isComposable == composableInfo.isComposable && this.realParamsCount == composableInfo.realParamsCount && this.changedParams == composableInfo.changedParams && this.defaultParams == composableInfo.defaultParams;
    }

    public final int getChangedParams() {
        return this.changedParams;
    }

    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    public int hashCode() {
        boolean z11 = this.isComposable;
        if (z11) {
            z11 = true;
        }
        return ((((((z11 ? 1 : 0) * true) + this.realParamsCount) * 31) + this.changedParams) * 31) + this.defaultParams;
    }

    public final boolean isComposable() {
        return this.isComposable;
    }

    @NotNull
    public String toString() {
        return "ComposableInfo(isComposable=" + this.isComposable + ", realParamsCount=" + this.realParamsCount + ", changedParams=" + this.changedParams + ", defaultParams=" + this.defaultParams + ')';
    }
}
