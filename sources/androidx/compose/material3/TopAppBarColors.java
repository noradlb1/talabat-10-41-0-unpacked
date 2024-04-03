package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001f\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001f\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001f\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionIconContentColor-0d7_KjU$material3_release", "()J", "J", "getNavigationIconContentColor-0d7_KjU$material3_release", "getTitleContentColor-0d7_KjU$material3_release", "colorTransitionFraction", "", "containerColor-XeAY9LY$material3_release", "(FLandroidx/compose/runtime/Composer;I)J", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
@Stable
public final class TopAppBarColors {
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    private TopAppBarColors(long j11, long j12, long j13, long j14, long j15) {
        this.containerColor = j11;
        this.scrolledContainerColor = j12;
        this.navigationIconContentColor = j13;
        this.titleContentColor = j14;
        this.actionIconContentColor = j15;
    }

    public /* synthetic */ TopAppBarColors(long j11, long j12, long j13, long j14, long j15, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15);
    }

    @Composable
    /* renamed from: containerColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m2004containerColorXeAY9LY$material3_release(float f11, @Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1456204135);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1456204135, i11, -1, "androidx.compose.material3.TopAppBarColors.containerColor (AppBar.kt:896)");
        }
        long r02 = ColorKt.m2971lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(f11));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        if (Color.m2920equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m2920equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m2920equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m2920equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m2920equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor)) {
            return true;
        }
        return false;
    }

    /* renamed from: getActionIconContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2005getActionIconContentColor0d7_KjU$material3_release() {
        return this.actionIconContentColor;
    }

    /* renamed from: getNavigationIconContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2006getNavigationIconContentColor0d7_KjU$material3_release() {
        return this.navigationIconContentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2007getTitleContentColor0d7_KjU$material3_release() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return (((((((Color.m2926hashCodeimpl(this.containerColor) * 31) + Color.m2926hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m2926hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m2926hashCodeimpl(this.titleContentColor)) * 31) + Color.m2926hashCodeimpl(this.actionIconContentColor);
    }
}
