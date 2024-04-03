package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016R\u001d\u0010\t\u001a\u00020\u00038@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "indicatorColor", "getIndicatorColor-0d7_KjU$material3_release", "()J", "J", "equals", "", "other", "hashCode", "", "iconColor", "Landroidx/compose/runtime/State;", "selected", "iconColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "textColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class NavigationBarItemColors {
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    private NavigationBarItemColors(long j11, long j12, long j13, long j14, long j15) {
        this.selectedIconColor = j11;
        this.selectedTextColor = j12;
        this.selectedIndicatorColor = j13;
        this.unselectedIconColor = j14;
        this.unselectedTextColor = j15;
    }

    public /* synthetic */ NavigationBarItemColors(long j11, long j12, long j13, long j14, long j15, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) obj;
        if (Color.m2920equalsimpl0(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Color.m2920equalsimpl0(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Color.m2920equalsimpl0(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Color.m2920equalsimpl0(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Color.m2920equalsimpl0(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor)) {
            return true;
        }
        return false;
    }

    /* renamed from: getIndicatorColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m1746getIndicatorColor0d7_KjU$material3_release() {
        return this.selectedIndicatorColor;
    }

    public int hashCode() {
        return (((((((Color.m2926hashCodeimpl(this.selectedIconColor) * 31) + Color.m2926hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m2926hashCodeimpl(this.selectedTextColor)) * 31) + Color.m2926hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m2926hashCodeimpl(this.selectedIndicatorColor);
    }

    @NotNull
    @Composable
    public final State<Color> iconColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1510597389);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1510597389, i11, -1, "androidx.compose.material3.NavigationBarItemColors.iconColor (NavigationBar.kt:320)");
        }
        if (z11) {
            j11 = this.selectedIconColor;
        } else {
            j11 = this.unselectedIconColor;
        }
        State<Color> r102 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j11, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r102;
    }

    @NotNull
    @Composable
    public final State<Color> textColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1773887143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1773887143, i11, -1, "androidx.compose.material3.NavigationBarItemColors.textColor (NavigationBar.kt:333)");
        }
        if (z11) {
            j11 = this.selectedTextColor;
        } else {
            j11 = this.unselectedTextColor;
        }
        State<Color> r102 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j11, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r102;
    }
}
