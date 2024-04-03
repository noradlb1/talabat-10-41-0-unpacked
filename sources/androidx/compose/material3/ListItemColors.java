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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BR\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0010J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0014R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/ListItemColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "headlineColor", "leadingIconColor", "overlineColor", "supportingTextColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "containerColor$material3_release", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "enabled", "", "headlineColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "leadingIconColor$material3_release", "overlineColor$material3_release", "supportingColor", "supportingColor$material3_release", "trailingIconColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ListItemColors {
    private final long containerColor;
    private final long disabledHeadlineColor;
    private final long disabledLeadingIconColor;
    private final long disabledTrailingIconColor;
    private final long headlineColor;
    private final long leadingIconColor;
    private final long overlineColor;
    private final long supportingTextColor;
    private final long trailingIconColor;

    private ListItemColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        this.containerColor = j11;
        this.headlineColor = j12;
        this.leadingIconColor = j13;
        this.overlineColor = j14;
        this.supportingTextColor = j15;
        this.trailingIconColor = j16;
        this.disabledHeadlineColor = j17;
        this.disabledLeadingIconColor = j18;
        this.disabledTrailingIconColor = j19;
    }

    public /* synthetic */ ListItemColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    @NotNull
    @Composable
    public final State<Color> containerColor$material3_release(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-380363090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-380363090, i11, -1, "androidx.compose.material3.ListItemColors.containerColor (ListItem.kt:447)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(this.containerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> headlineColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1254314043);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1254314043, i11, -1, "androidx.compose.material3.ListItemColors.headlineColor (ListItem.kt:453)");
        }
        if (z11) {
            j11 = this.headlineColor;
        } else {
            j11 = this.disabledHeadlineColor;
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
    public final State<Color> leadingIconColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(694213044);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(694213044, i11, -1, "androidx.compose.material3.ListItemColors.leadingIconColor (ListItem.kt:461)");
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
    public final State<Color> overlineColor$material3_release(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1467587733);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1467587733, i11, -1, "androidx.compose.material3.ListItemColors.overlineColor (ListItem.kt:469)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(this.overlineColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> supportingColor$material3_release(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1251828896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1251828896, i11, -1, "androidx.compose.material3.ListItemColors.supportingColor (ListItem.kt:475)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(this.supportingTextColor), composer, 0);
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
        composer.startReplaceableGroup(-778325338);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778325338, i11, -1, "androidx.compose.material3.ListItemColors.trailingIconColor (ListItem.kt:481)");
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
