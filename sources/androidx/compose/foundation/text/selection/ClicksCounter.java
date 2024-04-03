package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/selection/ClicksCounter;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "clicks", "", "getClicks", "()I", "setClicks", "(I)V", "prevClick", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getPrevClick", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setPrevClick", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "positionIsTolerable", "", "newClick", "timeIsTolerable", "update", "", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ClicksCounter {
    private int clicks;
    @Nullable
    private PointerInputChange prevClick;
    @NotNull
    private final ViewConfiguration viewConfiguration;

    public ClicksCounter(@NotNull ViewConfiguration viewConfiguration2) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "viewConfiguration");
        this.viewConfiguration = viewConfiguration2;
    }

    public final int getClicks() {
        return this.clicks;
    }

    @Nullable
    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final boolean positionIsTolerable(@NotNull PointerInputChange pointerInputChange, @NotNull PointerInputChange pointerInputChange2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "prevClick");
        Intrinsics.checkNotNullParameter(pointerInputChange2, "newClick");
        if (((double) Offset.m2674getDistanceimpl(Offset.m2680minusMKHz9U(pointerInputChange2.m4306getPositionF1C5BW0(), pointerInputChange.m4306getPositionF1C5BW0()))) < 100.0d) {
            return true;
        }
        return false;
    }

    public final void setClicks(int i11) {
        this.clicks = i11;
    }

    public final void setPrevClick(@Nullable PointerInputChange pointerInputChange) {
        this.prevClick = pointerInputChange;
    }

    public final boolean timeIsTolerable(@NotNull PointerInputChange pointerInputChange, @NotNull PointerInputChange pointerInputChange2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "prevClick");
        Intrinsics.checkNotNullParameter(pointerInputChange2, "newClick");
        if (pointerInputChange2.getUptimeMillis() - pointerInputChange.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis()) {
            return true;
        }
        return false;
    }

    public final void update(@NotNull PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "event");
        PointerInputChange pointerInputChange = this.prevClick;
        PointerInputChange pointerInputChange2 = pointerEvent.getChanges().get(0);
        if (pointerInputChange == null || !timeIsTolerable(pointerInputChange, pointerInputChange2) || !positionIsTolerable(pointerInputChange, pointerInputChange2)) {
            this.clicks = 1;
        } else {
            this.clicks++;
        }
        this.prevClick = pointerInputChange2;
    }
}
