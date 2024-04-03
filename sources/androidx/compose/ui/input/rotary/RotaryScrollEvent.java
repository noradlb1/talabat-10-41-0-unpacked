package androidx.compose.ui.input.rotary;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.input.focus.FocusDirectedInputEvent;
import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;", "verticalScrollPixels", "", "horizontalScrollPixels", "uptimeMillis", "", "(FFJ)V", "getHorizontalScrollPixels", "()F", "getUptimeMillis", "()J", "getVerticalScrollPixels", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RotaryScrollEvent implements FocusDirectedInputEvent {
    public static final int $stable = 0;
    private final float horizontalScrollPixels;
    private final long uptimeMillis;
    private final float verticalScrollPixels;

    public RotaryScrollEvent(float f11, float f12, long j11) {
        this.verticalScrollPixels = f11;
        this.horizontalScrollPixels = f12;
        this.uptimeMillis = j11;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        if (!(obj instanceof RotaryScrollEvent)) {
            return false;
        }
        RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) obj;
        if (rotaryScrollEvent.verticalScrollPixels == this.verticalScrollPixels) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (rotaryScrollEvent.horizontalScrollPixels == this.horizontalScrollPixels) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12 || rotaryScrollEvent.uptimeMillis != this.uptimeMillis) {
            return false;
        }
        return true;
    }

    public final float getHorizontalScrollPixels() {
        return this.horizontalScrollPixels;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final float getVerticalScrollPixels() {
        return this.verticalScrollPixels;
    }

    public int hashCode() {
        return ((((0 + Float.floatToIntBits(this.verticalScrollPixels)) * 31) + Float.floatToIntBits(this.horizontalScrollPixels)) * 31) + a.a(this.uptimeMillis);
    }

    @NotNull
    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.verticalScrollPixels + ",horizontalScrollPixels=" + this.horizontalScrollPixels + ",uptimeMillis=" + this.uptimeMillis + ')';
    }
}
