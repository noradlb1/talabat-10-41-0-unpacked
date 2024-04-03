package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/input/pointer/HistoricalChange;", "", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPosition-F1C5BW0", "()J", "J", "getUptimeMillis", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HistoricalChange {
    private final long position;
    private final long uptimeMillis;

    private HistoricalChange(long j11, long j12) {
        this.uptimeMillis = j11;
        this.position = j12;
    }

    public /* synthetic */ HistoricalChange(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m4236getPositionF1C5BW0() {
        return this.position;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    @NotNull
    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.m2684toStringimpl(this.position) + ')';
    }
}
