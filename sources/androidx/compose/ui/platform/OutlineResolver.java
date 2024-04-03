package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001b\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020,2\u0006\u0010$\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J6\u00103\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u00106\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00062\u0006\u00107\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003J\b\u00108\u001a\u00020,H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020(H\u0002J3\u0010@\u001a\u00020\u0006*\u0004\u0018\u00010(2\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u001fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010%\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "cacheIsDirty", "", "cachedOutline", "Landroid/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "calculatedOutline", "Landroidx/compose/ui/graphics/Outline;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "()Z", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "update-uvyYCjk", "(J)V", "alpha", "elevation", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OutlineResolver {
    private boolean cacheIsDirty;
    @NotNull
    private final Outline cachedOutline;
    @Nullable
    private Path cachedRrectPath;
    @Nullable
    private androidx.compose.ui.graphics.Outline calculatedOutline;
    @NotNull
    private Density density;
    private boolean isSupportedOutline = true;
    @NotNull
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    @Nullable
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    @NotNull
    private Shape shape;
    private long size;
    @Nullable
    private Path tmpOpPath;
    @Nullable
    private Path tmpPath;
    @Nullable
    private RoundRect tmpRoundRect;
    @Nullable
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(@NotNull Density density2) {
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        this.density = density2;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        Size.Companion companion = Size.Companion;
        this.size = companion.m2754getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m2692getZeroF1C5BW0();
        this.rectSize = companion.m2754getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    /* renamed from: isSameBounds-4L21HEs  reason: not valid java name */
    private final boolean m4869isSameBounds4L21HEs(RoundRect roundRect, long j11, long j12, float f11) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (roundRect == null || !RoundRectKt.isSimple(roundRect)) {
            return false;
        }
        if (roundRect.getLeft() == Offset.m2676getXimpl(j11)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (roundRect.getTop() == Offset.m2677getYimpl(j11)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        if (roundRect.getRight() == Offset.m2676getXimpl(j11) + Size.m2745getWidthimpl(j12)) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            return false;
        }
        if (roundRect.getBottom() == Offset.m2677getYimpl(j11) + Size.m2742getHeightimpl(j12)) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            return false;
        }
        if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == f11) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            return true;
        }
        return false;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m2692getZeroF1C5BW0();
            long j11 = this.size;
            this.rectSize = j11;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m2745getWidthimpl(j11) <= 0.0f || Size.m2742getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.ui.graphics.Outline r02 = this.shape.m3232createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = r02;
            if (r02 instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) r02).getRect());
            } else if (r02 instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) r02).getRoundRect());
            } else if (r02 instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) r02).getPath());
            }
        }
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (path instanceof AndroidPath) {
                outline.setConvexPath(((AndroidPath) path).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(MathKt__MathJVMKt.roundToInt(rect.getLeft()), MathKt__MathJVMKt.roundToInt(rect.getTop()), MathKt__MathJVMKt.roundToInt(rect.getRight()), MathKt__MathJVMKt.roundToInt(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float r02 = CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(MathKt__MathJVMKt.roundToInt(roundRect.getLeft()), MathKt__MathJVMKt.roundToInt(roundRect.getTop()), MathKt__MathJVMKt.roundToInt(roundRect.getRight()), MathKt__MathJVMKt.roundToInt(roundRect.getBottom()), r02);
            this.roundedCornerRadius = r02;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        path.addRoundRect(roundRect);
        updateCacheWithPath(path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (m4869isSameBounds4L21HEs(r1, r7.rectTopLeft, r7.rectSize, r6) == false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clipToOutline(@org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.Canvas r21) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            androidx.compose.ui.graphics.Path r0 = r20.getClipPath()
            r9 = 0
            r10 = 0
            r11 = 2
            if (r0 == 0) goto L_0x0017
            e0.z0.m(r8, r0, r9, r11, r10)
            goto L_0x00a9
        L_0x0017:
            float r6 = r7.roundedCornerRadius
            r12 = 0
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0078
            androidx.compose.ui.graphics.Path r13 = r7.tmpPath
            androidx.compose.ui.geometry.RoundRect r1 = r7.tmpRoundRect
            if (r13 == 0) goto L_0x0030
            long r2 = r7.rectTopLeft
            long r4 = r7.rectSize
            r0 = r20
            boolean r0 = r0.m4869isSameBounds4L21HEs(r1, r2, r4, r6)
            if (r0 != 0) goto L_0x0074
        L_0x0030:
            long r0 = r7.rectTopLeft
            float r14 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r15 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2745getWidthimpl(r1)
            float r16 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2742getHeightimpl(r1)
            float r17 = r0 + r1
            float r0 = r7.roundedCornerRadius
            long r18 = androidx.compose.ui.geometry.CornerRadiusKt.CornerRadius$default(r0, r12, r11, r10)
            androidx.compose.ui.geometry.RoundRect r0 = androidx.compose.ui.geometry.RoundRectKt.m2730RoundRectgG7oq9Y(r14, r15, r16, r17, r18)
            if (r13 != 0) goto L_0x006a
            androidx.compose.ui.graphics.Path r1 = androidx.compose.ui.graphics.AndroidPath_androidKt.Path()
            r13 = r1
            goto L_0x006d
        L_0x006a:
            r13.reset()
        L_0x006d:
            r13.addRoundRect(r0)
            r7.tmpRoundRect = r0
            r7.tmpPath = r13
        L_0x0074:
            e0.z0.m(r8, r13, r9, r11, r10)
            goto L_0x00a9
        L_0x0078:
            long r0 = r7.rectTopLeft
            float r9 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r10 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2745getWidthimpl(r1)
            float r11 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2742getHeightimpl(r1)
            float r12 = r0 + r1
            r13 = 0
            r14 = 16
            r15 = 0
            r8 = r21
            e0.z0.n(r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.clipToOutline(androidx.compose.ui.graphics.Canvas):void");
    }

    @Nullable
    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    @Nullable
    public final android.graphics.Outline getOutline() {
        updateCache();
        if (!this.outlineNeeded || !this.isSupportedOutline) {
            return null;
        }
        return this.cachedOutline;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    /* renamed from: isInOutline-k-4lQ0M  reason: not valid java name */
    public final boolean m4870isInOutlinek4lQ0M(long j11) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final boolean update(@NotNull Shape shape2, float f11, boolean z11, float f12, @NotNull LayoutDirection layoutDirection2, @NotNull Density density2) {
        boolean z12;
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        this.cachedOutline.setAlpha(f11);
        boolean z13 = !Intrinsics.areEqual((Object) this.shape, (Object) shape2);
        if (z13) {
            this.shape = shape2;
            this.cacheIsDirty = true;
        }
        if (z11 || f12 > 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.outlineNeeded != z12) {
            this.outlineNeeded = z12;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            this.cacheIsDirty = true;
        }
        return z13;
    }

    /* renamed from: update-uvyYCjk  reason: not valid java name */
    public final void m4871updateuvyYCjk(long j11) {
        if (!Size.m2741equalsimpl0(this.size, j11)) {
            this.size = j11;
            this.cacheIsDirty = true;
        }
    }
}
