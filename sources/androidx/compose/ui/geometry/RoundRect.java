package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001>BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0019\u0010!\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0011J\u0019\u0010#\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0011J\u0019\u0010%\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011J\u0019\u0010'\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0011J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.Jf\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J(\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0000H\u0002J\b\u0010<\u001a\u00020=H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", "min", "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoundRect {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final RoundRect Zero = RoundRectKt.m2730RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m2661getZerokKHJgLs());
    @Nullable
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        @NotNull
        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }

    private RoundRect(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14) {
        this.left = f11;
        this.top = f12;
        this.right = f13;
        this.bottom = f14;
        this.topLeftCornerRadius = j11;
        this.topRightCornerRadius = j12;
        this.bottomRightCornerRadius = j13;
        this.bottomLeftCornerRadius = j14;
    }

    public /* synthetic */ RoundRect(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, j11, j12, j13, j14);
    }

    /* renamed from: copy-MDFrsts$default  reason: not valid java name */
    public static /* synthetic */ RoundRect m2717copyMDFrsts$default(RoundRect roundRect, float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14, int i11, Object obj) {
        RoundRect roundRect2 = roundRect;
        int i12 = i11;
        return roundRect.m2723copyMDFrsts((i12 & 1) != 0 ? roundRect2.left : f11, (i12 & 2) != 0 ? roundRect2.top : f12, (i12 & 4) != 0 ? roundRect2.right : f13, (i12 & 8) != 0 ? roundRect2.bottom : f14, (i12 & 16) != 0 ? roundRect2.topLeftCornerRadius : j11, (i12 & 32) != 0 ? roundRect2.topRightCornerRadius : j12, (i12 & 64) != 0 ? roundRect2.bottomRightCornerRadius : j13, (i12 & 128) != 0 ? roundRect2.bottomLeftCornerRadius : j14);
    }

    @NotNull
    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    private final float minRadius(float f11, float f12, float f13, float f14) {
        float f15 = f12 + f13;
        if (f15 <= f14) {
            return f11;
        }
        return !((f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1)) == 0) ? Math.min(f11, f14 / f15) : f11;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float minRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m2652getYimpl(this.bottomLeftCornerRadius), CornerRadius.m2652getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m2651getXimpl(this.topLeftCornerRadius), CornerRadius.m2651getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m2652getYimpl(this.topRightCornerRadius), CornerRadius.m2652getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m2651getXimpl(this.bottomRightCornerRadius), CornerRadius.m2651getXimpl(this.bottomLeftCornerRadius), getWidth());
        RoundRect roundRect2 = r2;
        RoundRect roundRect3 = new RoundRect(this.left * minRadius, this.top * minRadius, this.right * minRadius, this.bottom * minRadius, CornerRadiusKt.CornerRadius(CornerRadius.m2651getXimpl(this.topLeftCornerRadius) * minRadius, CornerRadius.m2652getYimpl(this.topLeftCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2651getXimpl(this.topRightCornerRadius) * minRadius, CornerRadius.m2652getYimpl(this.topRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2651getXimpl(this.bottomRightCornerRadius) * minRadius, CornerRadius.m2652getYimpl(this.bottomRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2651getXimpl(this.bottomLeftCornerRadius) * minRadius, CornerRadius.m2652getYimpl(this.bottomLeftCornerRadius) * minRadius), (DefaultConstructorMarker) null);
        RoundRect roundRect4 = roundRect2;
        this._scaledRadiiRect = roundRect4;
        return roundRect4;
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* renamed from: component5-kKHJgLs  reason: not valid java name */
    public final long m2718component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs  reason: not valid java name */
    public final long m2719component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs  reason: not valid java name */
    public final long m2720component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs  reason: not valid java name */
    public final long m2721component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m2722containsk4lQ0M(long j11) {
        float f11;
        float f12;
        float f13;
        float f14;
        if (Offset.m2676getXimpl(j11) < this.left || Offset.m2676getXimpl(j11) >= this.right || Offset.m2677getYimpl(j11) < this.top || Offset.m2677getYimpl(j11) >= this.bottom) {
            return false;
        }
        RoundRect scaledRadiiRect = scaledRadiiRect();
        if (Offset.m2676getXimpl(j11) < this.left + CornerRadius.m2651getXimpl(scaledRadiiRect.topLeftCornerRadius) && Offset.m2677getYimpl(j11) < this.top + CornerRadius.m2652getYimpl(scaledRadiiRect.topLeftCornerRadius)) {
            f13 = (Offset.m2676getXimpl(j11) - this.left) - CornerRadius.m2651getXimpl(scaledRadiiRect.topLeftCornerRadius);
            f12 = (Offset.m2677getYimpl(j11) - this.top) - CornerRadius.m2652getYimpl(scaledRadiiRect.topLeftCornerRadius);
            f11 = CornerRadius.m2651getXimpl(scaledRadiiRect.topLeftCornerRadius);
            f14 = CornerRadius.m2652getYimpl(scaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m2676getXimpl(j11) > this.right - CornerRadius.m2651getXimpl(scaledRadiiRect.topRightCornerRadius) && Offset.m2677getYimpl(j11) < this.top + CornerRadius.m2652getYimpl(scaledRadiiRect.topRightCornerRadius)) {
            f13 = (Offset.m2676getXimpl(j11) - this.right) + CornerRadius.m2651getXimpl(scaledRadiiRect.topRightCornerRadius);
            f12 = (Offset.m2677getYimpl(j11) - this.top) - CornerRadius.m2652getYimpl(scaledRadiiRect.topRightCornerRadius);
            f11 = CornerRadius.m2651getXimpl(scaledRadiiRect.topRightCornerRadius);
            f14 = CornerRadius.m2652getYimpl(scaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m2676getXimpl(j11) > this.right - CornerRadius.m2651getXimpl(scaledRadiiRect.bottomRightCornerRadius) && Offset.m2677getYimpl(j11) > this.bottom - CornerRadius.m2652getYimpl(scaledRadiiRect.bottomRightCornerRadius)) {
            f13 = (Offset.m2676getXimpl(j11) - this.right) + CornerRadius.m2651getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            f12 = (Offset.m2677getYimpl(j11) - this.bottom) + CornerRadius.m2652getYimpl(scaledRadiiRect.bottomRightCornerRadius);
            f11 = CornerRadius.m2651getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            f14 = CornerRadius.m2652getYimpl(scaledRadiiRect.bottomRightCornerRadius);
        } else if (Offset.m2676getXimpl(j11) >= this.left + CornerRadius.m2651getXimpl(scaledRadiiRect.bottomLeftCornerRadius) || Offset.m2677getYimpl(j11) <= this.bottom - CornerRadius.m2652getYimpl(scaledRadiiRect.bottomLeftCornerRadius)) {
            return true;
        } else {
            f13 = (Offset.m2676getXimpl(j11) - this.left) - CornerRadius.m2651getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            f12 = (Offset.m2677getYimpl(j11) - this.bottom) + CornerRadius.m2652getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
            f11 = CornerRadius.m2651getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            f14 = CornerRadius.m2652getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
        }
        float f15 = f13 / f11;
        float f16 = f12 / f14;
        if ((f15 * f15) + (f16 * f16) <= 1.0f) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: copy-MDFrsts  reason: not valid java name */
    public final RoundRect m2723copyMDFrsts(float f11, float f12, float f13, float f14, long j11, long j12, long j13, long j14) {
        return new RoundRect(f11, f12, f13, f14, j11, j12, j13, j14, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.left), (Object) Float.valueOf(roundRect.left)) && Intrinsics.areEqual((Object) Float.valueOf(this.top), (Object) Float.valueOf(roundRect.top)) && Intrinsics.areEqual((Object) Float.valueOf(this.right), (Object) Float.valueOf(roundRect.right)) && Intrinsics.areEqual((Object) Float.valueOf(this.bottom), (Object) Float.valueOf(roundRect.bottom)) && CornerRadius.m2650equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m2650equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m2650equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m2650equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2724getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2725getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* renamed from: getTopLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2726getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2727getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.m2653hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m2653hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m2653hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m2653hashCodeimpl(this.bottomLeftCornerRadius);
    }

    @NotNull
    public String toString() {
        boolean z11;
        long j11 = this.topLeftCornerRadius;
        long j12 = this.topRightCornerRadius;
        long j13 = this.bottomRightCornerRadius;
        long j14 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + GeometryUtilsKt.toStringAsFixed(this.top, 1) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + GeometryUtilsKt.toStringAsFixed(this.right, 1) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m2650equalsimpl0(j11, j12) || !CornerRadius.m2650equalsimpl0(j12, j13) || !CornerRadius.m2650equalsimpl0(j13, j14)) {
            return "RoundRect(rect=" + str + ", topLeft=" + CornerRadius.m2657toStringimpl(j11) + ", topRight=" + CornerRadius.m2657toStringimpl(j12) + ", bottomRight=" + CornerRadius.m2657toStringimpl(j13) + ", bottomLeft=" + CornerRadius.m2657toStringimpl(j14) + ')';
        }
        if (CornerRadius.m2651getXimpl(j11) == CornerRadius.m2652getYimpl(j11)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2651getXimpl(j11), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2651getXimpl(j11), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2652getYimpl(j11), 1) + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RoundRect(float r18, float r19, float r20, float r21, long r22, long r24, long r26, long r28, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r17 = this;
            r0 = r30
            r1 = r0 & 16
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m2661getZerokKHJgLs()
            r8 = r1
            goto L_0x0010
        L_0x000e:
            r8 = r22
        L_0x0010:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001c
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m2661getZerokKHJgLs()
            r10 = r1
            goto L_0x001e
        L_0x001c:
            r10 = r24
        L_0x001e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m2661getZerokKHJgLs()
            r12 = r1
            goto L_0x002c
        L_0x002a:
            r12 = r26
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0038
            androidx.compose.ui.geometry.CornerRadius$Companion r0 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r0 = r0.m2661getZerokKHJgLs()
            r14 = r0
            goto L_0x003a
        L_0x0038:
            r14 = r28
        L_0x003a:
            r16 = 0
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRect.<init>(float, float, float, float, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
