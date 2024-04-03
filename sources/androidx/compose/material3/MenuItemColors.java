package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "leadingIconColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor$material3_release", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuItemColors {
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    private MenuItemColors(long j11, long j12, long j13, long j14, long j15, long j16) {
        this.textColor = j11;
        this.leadingIconColor = j12;
        this.trailingIconColor = j13;
        this.disabledTextColor = j14;
        this.disabledLeadingIconColor = j15;
        this.disabledTrailingIconColor = j16;
    }

    public /* synthetic */ MenuItemColors(long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MenuItemColors)) {
            return false;
        }
        MenuItemColors menuItemColors = (MenuItemColors) obj;
        if (Color.m2920equalsimpl0(this.textColor, menuItemColors.textColor) && Color.m2920equalsimpl0(this.leadingIconColor, menuItemColors.leadingIconColor) && Color.m2920equalsimpl0(this.trailingIconColor, menuItemColors.trailingIconColor) && Color.m2920equalsimpl0(this.disabledTextColor, menuItemColors.disabledTextColor) && Color.m2920equalsimpl0(this.disabledLeadingIconColor, menuItemColors.disabledLeadingIconColor) && Color.m2920equalsimpl0(this.disabledTrailingIconColor, menuItemColors.disabledTrailingIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Color.m2926hashCodeimpl(this.textColor) * 31) + Color.m2926hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.trailingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledTextColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledTrailingIconColor);
    }

    @NotNull
    @Composable
    public final State<Color> leadingIconColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1521013607);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1521013607, i11, -1, "androidx.compose.material3.MenuItemColors.leadingIconColor (Menu.kt:393)");
        }
        if (z11) {
            j11 = this.leadingIconColor;
        } else {
            j11 = this.disabledLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> textColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1023108655);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1023108655, i11, -1, "androidx.compose.material3.MenuItemColors.textColor (Menu.kt:383)");
        }
        if (z11) {
            j11 = this.textColor;
        } else {
            j11 = this.disabledTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> trailingIconColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1024062809);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1024062809, i11, -1, "androidx.compose.material3.MenuItemColors.trailingIconColor (Menu.kt:403)");
        }
        if (z11) {
            j11 = this.trailingIconColor;
        } else {
            j11 = this.disabledTrailingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
