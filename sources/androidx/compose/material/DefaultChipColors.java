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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DefaultChipColors;", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultChipColors implements ChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconContentColor;
    private final long leadingIconContentColor;

    private DefaultChipColors(long j11, long j12, long j13, long j14, long j15, long j16) {
        this.backgroundColor = j11;
        this.contentColor = j12;
        this.leadingIconContentColor = j13;
        this.disabledBackgroundColor = j14;
        this.disabledContentColor = j15;
        this.disabledLeadingIconContentColor = j16;
    }

    public /* synthetic */ DefaultChipColors(long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16);
    }

    @NotNull
    @Composable
    public State<Color> backgroundColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1593588247);
        if (z11) {
            j11 = this.backgroundColor;
        } else {
            j11 = this.disabledBackgroundColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> contentColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(483145880);
        if (z11) {
            j11 = this.contentColor;
        } else {
            j11 = this.disabledContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(DefaultChipColors.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultChipColors defaultChipColors = (DefaultChipColors) obj;
        if (Color.m2920equalsimpl0(this.backgroundColor, defaultChipColors.backgroundColor) && Color.m2920equalsimpl0(this.contentColor, defaultChipColors.contentColor) && Color.m2920equalsimpl0(this.leadingIconContentColor, defaultChipColors.leadingIconContentColor) && Color.m2920equalsimpl0(this.disabledBackgroundColor, defaultChipColors.disabledBackgroundColor) && Color.m2920equalsimpl0(this.disabledContentColor, defaultChipColors.disabledContentColor) && Color.m2920equalsimpl0(this.disabledLeadingIconContentColor, defaultChipColors.disabledLeadingIconContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Color.m2926hashCodeimpl(this.backgroundColor) * 31) + Color.m2926hashCodeimpl(this.contentColor)) * 31) + Color.m2926hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m2926hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m2926hashCodeimpl(this.disabledContentColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLeadingIconContentColor);
    }

    @NotNull
    @Composable
    public State<Color> leadingIconContentColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1955749013);
        if (z11) {
            j11 = this.leadingIconContentColor;
        } else {
            j11 = this.disabledLeadingIconContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
