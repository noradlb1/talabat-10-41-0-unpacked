package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalMaterialApi
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\fJ&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/DefaultSelectableChipColors;", "Landroidx/compose/material/SelectableChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultSelectableChipColors implements SelectableChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconColor;
    private final long leadingIconColor;
    private final long selectedBackgroundColor;
    private final long selectedContentColor;
    private final long selectedLeadingIconColor;

    private DefaultSelectableChipColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        this.backgroundColor = j11;
        this.contentColor = j12;
        this.leadingIconColor = j13;
        this.disabledBackgroundColor = j14;
        this.disabledContentColor = j15;
        this.disabledLeadingIconColor = j16;
        this.selectedBackgroundColor = j17;
        this.selectedContentColor = j18;
        this.selectedLeadingIconColor = j19;
    }

    public /* synthetic */ DefaultSelectableChipColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    @NotNull
    @Composable
    public State<Color> backgroundColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-403836585);
        if (!z11) {
            j11 = this.disabledBackgroundColor;
        } else if (!z12) {
            j11 = this.backgroundColor;
        } else {
            j11 = this.selectedBackgroundColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> contentColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(2025240134);
        if (!z11) {
            j11 = this.disabledContentColor;
        } else if (!z12) {
            j11 = this.contentColor;
        } else {
            j11 = this.selectedContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(DefaultSelectableChipColors.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = (DefaultSelectableChipColors) obj;
        if (Color.m2920equalsimpl0(this.backgroundColor, defaultSelectableChipColors.backgroundColor) && Color.m2920equalsimpl0(this.contentColor, defaultSelectableChipColors.contentColor) && Color.m2920equalsimpl0(this.leadingIconColor, defaultSelectableChipColors.leadingIconColor) && Color.m2920equalsimpl0(this.disabledBackgroundColor, defaultSelectableChipColors.disabledBackgroundColor) && Color.m2920equalsimpl0(this.disabledContentColor, defaultSelectableChipColors.disabledContentColor) && Color.m2920equalsimpl0(this.disabledLeadingIconColor, defaultSelectableChipColors.disabledLeadingIconColor) && Color.m2920equalsimpl0(this.selectedBackgroundColor, defaultSelectableChipColors.selectedBackgroundColor) && Color.m2920equalsimpl0(this.selectedContentColor, defaultSelectableChipColors.selectedContentColor) && Color.m2920equalsimpl0(this.selectedLeadingIconColor, defaultSelectableChipColors.selectedLeadingIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Color.m2926hashCodeimpl(this.backgroundColor) * 31) + Color.m2926hashCodeimpl(this.contentColor)) * 31) + Color.m2926hashCodeimpl(this.leadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m2926hashCodeimpl(this.disabledContentColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m2926hashCodeimpl(this.selectedBackgroundColor)) * 31) + Color.m2926hashCodeimpl(this.selectedContentColor)) * 31) + Color.m2926hashCodeimpl(this.selectedLeadingIconColor);
    }

    @NotNull
    @Composable
    public State<Color> leadingIconColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(189838188);
        if (!z11) {
            j11 = this.disabledLeadingIconColor;
        } else if (!z12) {
            j11 = this.leadingIconColor;
        } else {
            j11 = this.selectedLeadingIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
