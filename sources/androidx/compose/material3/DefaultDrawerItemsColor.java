package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001c\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001c\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/DefaultDrawerItemsColor;", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedContainerColor", "unselectedContainerColor", "selectedBadgeColor", "unselectedBadgeColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedBadgeColor-0d7_KjU", "()J", "J", "getSelectedContainerColor-0d7_KjU", "getSelectedIconColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedBadgeColor-0d7_KjU", "getUnselectedContainerColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "badgeColor", "Landroidx/compose/runtime/State;", "selected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "containerColor", "equals", "other", "", "hashCode", "", "iconColor", "textColor", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DefaultDrawerItemsColor implements NavigationDrawerItemColors {
    private final long selectedBadgeColor;
    private final long selectedContainerColor;
    private final long selectedIconColor;
    private final long selectedTextColor;
    private final long unselectedBadgeColor;
    private final long unselectedContainerColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    private DefaultDrawerItemsColor(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.selectedIconColor = j11;
        this.unselectedIconColor = j12;
        this.selectedTextColor = j13;
        this.unselectedTextColor = j14;
        this.selectedContainerColor = j15;
        this.unselectedContainerColor = j16;
        this.selectedBadgeColor = j17;
        this.unselectedBadgeColor = j18;
    }

    public /* synthetic */ DefaultDrawerItemsColor(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18);
    }

    @NotNull
    @Composable
    public State<Color> badgeColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-561675044);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561675044, i11, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:815)");
        }
        if (z11) {
            j11 = this.selectedBadgeColor;
        } else {
            j11 = this.unselectedBadgeColor;
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
    public State<Color> containerColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-433512770);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-433512770, i11, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:808)");
        }
        if (z11) {
            j11 = this.selectedContainerColor;
        } else {
            j11 = this.unselectedContainerColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultDrawerItemsColor)) {
            return false;
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = (DefaultDrawerItemsColor) obj;
        if (Color.m2920equalsimpl0(this.selectedIconColor, defaultDrawerItemsColor.selectedIconColor) && Color.m2920equalsimpl0(this.unselectedIconColor, defaultDrawerItemsColor.unselectedIconColor) && Color.m2920equalsimpl0(this.selectedTextColor, defaultDrawerItemsColor.selectedTextColor) && Color.m2920equalsimpl0(this.unselectedTextColor, defaultDrawerItemsColor.unselectedTextColor) && Color.m2920equalsimpl0(this.selectedContainerColor, defaultDrawerItemsColor.selectedContainerColor) && Color.m2920equalsimpl0(this.unselectedContainerColor, defaultDrawerItemsColor.unselectedContainerColor) && Color.m2920equalsimpl0(this.selectedBadgeColor, defaultDrawerItemsColor.selectedBadgeColor) && Color.m2920equalsimpl0(this.unselectedBadgeColor, defaultDrawerItemsColor.unselectedBadgeColor)) {
            return true;
        }
        return false;
    }

    /* renamed from: getSelectedBadgeColor-0d7_KjU  reason: not valid java name */
    public final long m1636getSelectedBadgeColor0d7_KjU() {
        return this.selectedBadgeColor;
    }

    /* renamed from: getSelectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1637getSelectedContainerColor0d7_KjU() {
        return this.selectedContainerColor;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m1638getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m1639getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* renamed from: getUnselectedBadgeColor-0d7_KjU  reason: not valid java name */
    public final long m1640getUnselectedBadgeColor0d7_KjU() {
        return this.unselectedBadgeColor;
    }

    /* renamed from: getUnselectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1641getUnselectedContainerColor0d7_KjU() {
        return this.unselectedContainerColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m1642getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m1643getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    public int hashCode() {
        return (((((((((((((Color.m2926hashCodeimpl(this.selectedIconColor) * 31) + Color.m2926hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m2926hashCodeimpl(this.selectedTextColor)) * 31) + Color.m2926hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m2926hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m2926hashCodeimpl(this.unselectedContainerColor)) * 31) + Color.m2926hashCodeimpl(this.selectedBadgeColor)) * 31) + Color.m2926hashCodeimpl(this.unselectedBadgeColor);
    }

    @NotNull
    @Composable
    public State<Color> iconColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1141354218);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141354218, i11, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:798)");
        }
        if (z11) {
            j11 = this.selectedIconColor;
        } else {
            j11 = this.unselectedIconColor;
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
    public State<Color> textColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1275109558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1275109558, i11, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:803)");
        }
        if (z11) {
            j11 = this.selectedTextColor;
        } else {
            j11 = this.unselectedTextColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
