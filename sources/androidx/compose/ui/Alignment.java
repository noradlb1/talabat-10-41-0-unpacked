package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rJ-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment;", "", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "Companion", "Horizontal", "Vertical", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public interface Alignment {
    @NotNull
    public static final Companion Companion = Companion.f9550a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u00020\u001a8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\fR\u001c\u0010!\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0007R\u001c\u0010$\u001a\u00020\u001a8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u001dR\u001c\u0010'\u001a\u00020\u001a8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0007R\u001c\u0010-\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0002\u001a\u0004\b/\u0010\fR\u001c\u00100\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0002\u001a\u0004\b2\u0010\fR\u001c\u00103\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0002\u001a\u0004\b5\u0010\f¨\u00066"}, d2 = {"Landroidx/compose/ui/Alignment$Companion;", "", "()V", "Bottom", "Landroidx/compose/ui/Alignment$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/ui/Alignment$Vertical;", "BottomCenter", "Landroidx/compose/ui/Alignment;", "getBottomCenter$annotations", "getBottomCenter", "()Landroidx/compose/ui/Alignment;", "BottomEnd", "getBottomEnd$annotations", "getBottomEnd", "BottomStart", "getBottomStart$annotations", "getBottomStart", "Center", "getCenter$annotations", "getCenter", "CenterEnd", "getCenterEnd$annotations", "getCenterEnd", "CenterHorizontally", "Landroidx/compose/ui/Alignment$Horizontal;", "getCenterHorizontally$annotations", "getCenterHorizontally", "()Landroidx/compose/ui/Alignment$Horizontal;", "CenterStart", "getCenterStart$annotations", "getCenterStart", "CenterVertically", "getCenterVertically$annotations", "getCenterVertically", "End", "getEnd$annotations", "getEnd", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "TopCenter", "getTopCenter$annotations", "getTopCenter", "TopEnd", "getTopEnd$annotations", "getTopEnd", "TopStart", "getTopStart$annotations", "getTopStart", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final Vertical Bottom = new BiasAlignment.Vertical(1.0f);
        @NotNull
        private static final Alignment BottomCenter = new BiasAlignment(0.0f, 1.0f);
        @NotNull
        private static final Alignment BottomEnd = new BiasAlignment(1.0f, 1.0f);
        @NotNull
        private static final Alignment BottomStart = new BiasAlignment(-1.0f, 1.0f);
        @NotNull
        private static final Alignment Center = new BiasAlignment(0.0f, 0.0f);
        @NotNull
        private static final Alignment CenterEnd = new BiasAlignment(1.0f, 0.0f);
        @NotNull
        private static final Horizontal CenterHorizontally = new BiasAlignment.Horizontal(0.0f);
        @NotNull
        private static final Alignment CenterStart = new BiasAlignment(-1.0f, 0.0f);
        @NotNull
        private static final Vertical CenterVertically = new BiasAlignment.Vertical(0.0f);
        @NotNull
        private static final Horizontal End = new BiasAlignment.Horizontal(1.0f);
        @NotNull
        private static final Horizontal Start = new BiasAlignment.Horizontal(-1.0f);
        @NotNull
        private static final Vertical Top = new BiasAlignment.Vertical(-1.0f);
        @NotNull
        private static final Alignment TopCenter = new BiasAlignment(0.0f, -1.0f);
        @NotNull
        private static final Alignment TopEnd = new BiasAlignment(1.0f, -1.0f);
        @NotNull
        private static final Alignment TopStart = new BiasAlignment(-1.0f, -1.0f);

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f9550a = new Companion();

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getBottom$annotations() {
        }

        @Stable
        public static /* synthetic */ void getBottomCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getBottomEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getBottomStart$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterHorizontally$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterStart$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterVertically$annotations() {
        }

        @Stable
        public static /* synthetic */ void getEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getStart$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTop$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTopCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTopEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTopStart$annotations() {
        }

        @NotNull
        public final Vertical getBottom() {
            return Bottom;
        }

        @NotNull
        public final Alignment getBottomCenter() {
            return BottomCenter;
        }

        @NotNull
        public final Alignment getBottomEnd() {
            return BottomEnd;
        }

        @NotNull
        public final Alignment getBottomStart() {
            return BottomStart;
        }

        @NotNull
        public final Alignment getCenter() {
            return Center;
        }

        @NotNull
        public final Alignment getCenterEnd() {
            return CenterEnd;
        }

        @NotNull
        public final Horizontal getCenterHorizontally() {
            return CenterHorizontally;
        }

        @NotNull
        public final Alignment getCenterStart() {
            return CenterStart;
        }

        @NotNull
        public final Vertical getCenterVertically() {
            return CenterVertically;
        }

        @NotNull
        public final Horizontal getEnd() {
            return End;
        }

        @NotNull
        public final Horizontal getStart() {
            return Start;
        }

        @NotNull
        public final Vertical getTop() {
            return Top;
        }

        @NotNull
        public final Alignment getTopCenter() {
            return TopCenter;
        }

        @NotNull
        public final Alignment getTopEnd() {
            return TopEnd;
        }

        @NotNull
        public final Alignment getTopStart() {
            return TopStart;
        }
    }

    @Stable
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bç\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment$Horizontal;", "", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Horizontal {
        int align(int i11, int i12, @NotNull LayoutDirection layoutDirection);
    }

    @Stable
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment$Vertical;", "", "align", "", "size", "space", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Vertical {
        int align(int i11, int i12);
    }

    /* renamed from: align-KFBX0sM  reason: not valid java name */
    long m2554alignKFBX0sM(long j11, long j12, @NotNull LayoutDirection layoutDirection);
}
