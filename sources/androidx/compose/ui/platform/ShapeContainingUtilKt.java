package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a4\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002\u001a=\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs()) > roundRect.getWidth() || CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs()) > roundRect.getWidth() || CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m2652getYimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs()) > roundRect.getHeight() || CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs()) > roundRect.getHeight()) {
            return false;
        }
        return true;
    }

    public static final boolean isInOutline(@NotNull Outline outline, float f11, float f12, @Nullable Path path, @Nullable Path path2) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f11, f12);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f11, f12, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f11, f12, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f11, float f12, Path path, Path path2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            path = null;
        }
        if ((i11 & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f11, f12, path, path2);
    }

    private static final boolean isInPath(Path path, float f11, float f12, Path path2, Path path3) {
        Rect rect = new Rect(f11 - 0.005f, f12 - 0.005f, f11 + 0.005f, f12 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        path2.addRect(rect);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.m3152opN5in7k0(path, path2, PathOperation.Companion.m3175getIntersectb3I0S0c());
        boolean isEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !isEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f11, float f12) {
        return rect.getLeft() <= f11 && f11 < rect.getRight() && rect.getTop() <= f12 && f12 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f11, float f12, Path path, Path path2) {
        Path path3;
        float f13 = f11;
        float f14 = f12;
        Path path4 = path2;
        RoundRect roundRect = rounded.getRoundRect();
        if (f13 < roundRect.getLeft() || f13 >= roundRect.getRight() || f14 < roundRect.getTop() || f14 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            if (path4 == null) {
                path3 = AndroidPath_androidKt.Path();
            } else {
                path3 = path4;
            }
            path3.addRoundRect(roundRect);
            return isInPath(path3, f11, f12, path, path4);
        }
        float r42 = CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float r52 = CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs());
        float r72 = CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m2652getYimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs());
        float r11 = CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f13 < r42 && f14 < r52) {
            return m4879isWithinEllipseVE1yxkc(f11, f12, roundRect.m2726getTopLeftCornerRadiuskKHJgLs(), r42, r52);
        } else if (f13 < r11 && f14 > bottom2) {
            return m4879isWithinEllipseVE1yxkc(f11, f12, roundRect.m2724getBottomLeftCornerRadiuskKHJgLs(), r11, bottom2);
        } else if (f13 > right && f14 < r72) {
            return m4879isWithinEllipseVE1yxkc(f11, f12, roundRect.m2727getTopRightCornerRadiuskKHJgLs(), right, r72);
        } else if (f13 <= right2 || f14 <= bottom) {
            return true;
        } else {
            return m4879isWithinEllipseVE1yxkc(f11, f12, roundRect.m2725getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
        }
    }

    /* renamed from: isWithinEllipse-VE1yxkc  reason: not valid java name */
    private static final boolean m4879isWithinEllipseVE1yxkc(float f11, float f12, long j11, float f13, float f14) {
        float f15 = f11 - f13;
        float f16 = f12 - f14;
        float r42 = CornerRadius.m2651getXimpl(j11);
        float r22 = CornerRadius.m2652getYimpl(j11);
        if (((f15 * f15) / (r42 * r42)) + ((f16 * f16) / (r22 * r22)) <= 1.0f) {
            return true;
        }
        return false;
    }
}
