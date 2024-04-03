package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@ExperimentalMaterial3Api
@Stable
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR+\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\u0010R+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/TopAppBarState;", "", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFF)V", "_heightOffset", "Landroidx/compose/runtime/MutableState;", "collapsedFraction", "getCollapsedFraction", "()F", "<set-?>", "contentOffset", "getContentOffset", "setContentOffset", "(F)V", "contentOffset$delegate", "Landroidx/compose/runtime/MutableState;", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "heightOffsetLimit", "getHeightOffsetLimit", "setHeightOffsetLimit", "heightOffsetLimit$delegate", "overlappedFraction", "getOverlappedFraction", "Companion", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TopAppBarState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Saver<TopAppBarState, ?> Saver = ListSaverKt.listSaver(TopAppBarState$Companion$Saver$1.INSTANCE, TopAppBarState$Companion$Saver$2.INSTANCE);
    @NotNull
    private MutableState<Float> _heightOffset;
    @NotNull
    private final MutableState contentOffset$delegate;
    @NotNull
    private final MutableState heightOffsetLimit$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/TopAppBarState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TopAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<TopAppBarState, ?> getSaver() {
            return TopAppBarState.Saver;
        }
    }

    public TopAppBarState(float f11, float f12, float f13) {
        this.heightOffsetLimit$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f11), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.contentOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f13), (SnapshotMutationPolicy) null, 2, (Object) null);
        this._heightOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f12), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final float getCollapsedFraction() {
        boolean z11;
        if (getHeightOffsetLimit() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return getHeightOffset() / getHeightOffsetLimit();
        }
        return 0.0f;
    }

    public final float getContentOffset() {
        return ((Number) this.contentOffset$delegate.getValue()).floatValue();
    }

    public final float getHeightOffset() {
        return this._heightOffset.getValue().floatValue();
    }

    public final float getHeightOffsetLimit() {
        return ((Number) this.heightOffsetLimit$delegate.getValue()).floatValue();
    }

    public final float getOverlappedFraction() {
        boolean z11;
        if (getHeightOffsetLimit() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return ((float) 1) - (RangesKt___RangesKt.coerceIn(getHeightOffsetLimit() - getContentOffset(), getHeightOffsetLimit(), 0.0f) / getHeightOffsetLimit());
        }
        return 0.0f;
    }

    public final void setContentOffset(float f11) {
        this.contentOffset$delegate.setValue(Float.valueOf(f11));
    }

    public final void setHeightOffset(float f11) {
        this._heightOffset.setValue(Float.valueOf(RangesKt___RangesKt.coerceIn(f11, getHeightOffsetLimit(), 0.0f)));
    }

    public final void setHeightOffsetLimit(float f11) {
        this.heightOffsetLimit$delegate.setValue(Float.valueOf(f11));
    }
}
