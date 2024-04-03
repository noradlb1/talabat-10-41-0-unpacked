package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010j\u0002\b\u0011j\u0002\b\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "(Ljava/lang/String;I)V", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "Vertical", "Horizontal", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum SelectionMode {
    ;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode$Horizontal;", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Horizontal extends SelectionMode {
        public Horizontal(String str, int i11) {
            super(str, i11, (DefaultConstructorMarker) null);
        }

        /* renamed from: compare-3MmeM6k$foundation_release  reason: not valid java name */
        public int m1033compare3MmeM6k$foundation_release(long j11, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
            if (rect.m2702containsk4lQ0M(j11)) {
                return 0;
            }
            if (Offset.m2676getXimpl(j11) < rect.getLeft()) {
                return -1;
            }
            if (Offset.m2677getYimpl(j11) >= rect.getTop() || Offset.m2676getXimpl(j11) >= rect.getRight()) {
                return 1;
            }
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode$Vertical;", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Vertical extends SelectionMode {
        public Vertical(String str, int i11) {
            super(str, i11, (DefaultConstructorMarker) null);
        }

        /* renamed from: compare-3MmeM6k$foundation_release  reason: not valid java name */
        public int m1034compare3MmeM6k$foundation_release(long j11, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
            if (rect.m2702containsk4lQ0M(j11)) {
                return 0;
            }
            if (Offset.m2677getYimpl(j11) < rect.getTop()) {
                return -1;
            }
            if (Offset.m2676getXimpl(j11) >= rect.getLeft() || Offset.m2677getYimpl(j11) >= rect.getBottom()) {
                return 1;
            }
            return -1;
        }
    }

    /* renamed from: compare-3MmeM6k$foundation_release  reason: not valid java name */
    public abstract int m1031compare3MmeM6k$foundation_release(long j11, @NotNull Rect rect);

    /* renamed from: isSelected-2x9bVx0$foundation_release  reason: not valid java name */
    public final boolean m1032isSelected2x9bVx0$foundation_release(@NotNull Rect rect, long j11, long j12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        boolean z12 = true;
        if (rect.m2702containsk4lQ0M(j11) || rect.m2702containsk4lQ0M(j12)) {
            return true;
        }
        int r42 = m1031compare3MmeM6k$foundation_release(j11, rect);
        int r32 = m1031compare3MmeM6k$foundation_release(j12, rect);
        if (r42 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (r32 <= 0) {
            z12 = false;
        }
        return z11 ^ z12;
    }
}
