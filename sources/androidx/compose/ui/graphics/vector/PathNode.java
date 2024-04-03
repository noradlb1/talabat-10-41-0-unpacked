package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0013\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u001b\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006\u0001\u0013\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode;", "", "isCurve", "", "isQuad", "(ZZ)V", "()Z", "ArcTo", "Close", "CurveTo", "HorizontalTo", "LineTo", "MoveTo", "QuadTo", "ReflectiveCurveTo", "ReflectiveQuadTo", "RelativeArcTo", "RelativeCurveTo", "RelativeHorizontalTo", "RelativeLineTo", "RelativeMoveTo", "RelativeQuadTo", "RelativeReflectiveCurveTo", "RelativeReflectiveQuadTo", "RelativeVerticalTo", "VerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class PathNode {
    private final boolean isCurve;
    private final boolean isQuad;

    @Immutable
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartX", "arcStartY", "(FFFZZFF)V", "getArcStartX", "()F", "getArcStartY", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ArcTo extends PathNode {
        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        public ArcTo(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.horizontalEllipseRadius = f11;
            this.verticalEllipseRadius = f12;
            this.theta = f13;
            this.isMoreThanHalf = z11;
            this.isPositiveArc = z12;
            this.arcStartX = f14;
            this.arcStartY = f15;
        }

        public static /* synthetic */ ArcTo copy$default(ArcTo arcTo, float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = arcTo.horizontalEllipseRadius;
            }
            if ((i11 & 2) != 0) {
                f12 = arcTo.verticalEllipseRadius;
            }
            float f16 = f12;
            if ((i11 & 4) != 0) {
                f13 = arcTo.theta;
            }
            float f17 = f13;
            if ((i11 & 8) != 0) {
                z11 = arcTo.isMoreThanHalf;
            }
            boolean z13 = z11;
            if ((i11 & 16) != 0) {
                z12 = arcTo.isPositiveArc;
            }
            boolean z14 = z12;
            if ((i11 & 32) != 0) {
                f14 = arcTo.arcStartX;
            }
            float f18 = f14;
            if ((i11 & 64) != 0) {
                f15 = arcTo.arcStartY;
            }
            return arcTo.copy(f11, f16, f17, z13, z14, f18, f15);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartX;
        }

        public final float component7() {
            return this.arcStartY;
        }

        @NotNull
        public final ArcTo copy(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            return new ArcTo(f11, f12, f13, z11, z12, f14, f15);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.horizontalEllipseRadius), (Object) Float.valueOf(arcTo.horizontalEllipseRadius)) && Intrinsics.areEqual((Object) Float.valueOf(this.verticalEllipseRadius), (Object) Float.valueOf(arcTo.verticalEllipseRadius)) && Intrinsics.areEqual((Object) Float.valueOf(this.theta), (Object) Float.valueOf(arcTo.theta)) && this.isMoreThanHalf == arcTo.isMoreThanHalf && this.isPositiveArc == arcTo.isPositiveArc && Intrinsics.areEqual((Object) Float.valueOf(this.arcStartX), (Object) Float.valueOf(arcTo.arcStartX)) && Intrinsics.areEqual((Object) Float.valueOf(this.arcStartY), (Object) Float.valueOf(arcTo.arcStartY));
        }

        public final float getArcStartX() {
            return this.arcStartX;
        }

        public final float getArcStartY() {
            return this.arcStartY;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public int hashCode() {
            int floatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            boolean z11 = this.isMoreThanHalf;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (floatToIntBits + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isPositiveArc;
            if (!z13) {
                z12 = z13;
            }
            return ((((i11 + (z12 ? 1 : 0)) * 31) + Float.floatToIntBits(this.arcStartX)) * 31) + Float.floatToIntBits(this.arcStartY);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartX=" + this.arcStartX + ", arcStartY=" + this.arcStartY + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode;", "()V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Close extends PathNode {
        @NotNull
        public static final Close INSTANCE = new Close();

        private Close() {
            super(false, false, 3, (DefaultConstructorMarker) null);
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "x3", "y3", "(FFFFFF)V", "getX1", "()F", "getX2", "getX3", "getY1", "getY2", "getY3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CurveTo extends PathNode {

        /* renamed from: x1  reason: collision with root package name */
        private final float f9664x1;

        /* renamed from: x2  reason: collision with root package name */
        private final float f9665x2;

        /* renamed from: x3  reason: collision with root package name */
        private final float f9666x3;

        /* renamed from: y1  reason: collision with root package name */
        private final float f9667y1;

        /* renamed from: y2  reason: collision with root package name */
        private final float f9668y2;

        /* renamed from: y3  reason: collision with root package name */
        private final float f9669y3;

        public CurveTo(float f11, float f12, float f13, float f14, float f15, float f16) {
            super(true, false, 2, (DefaultConstructorMarker) null);
            this.f9664x1 = f11;
            this.f9667y1 = f12;
            this.f9665x2 = f13;
            this.f9668y2 = f14;
            this.f9666x3 = f15;
            this.f9669y3 = f16;
        }

        public static /* synthetic */ CurveTo copy$default(CurveTo curveTo, float f11, float f12, float f13, float f14, float f15, float f16, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = curveTo.f9664x1;
            }
            if ((i11 & 2) != 0) {
                f12 = curveTo.f9667y1;
            }
            float f17 = f12;
            if ((i11 & 4) != 0) {
                f13 = curveTo.f9665x2;
            }
            float f18 = f13;
            if ((i11 & 8) != 0) {
                f14 = curveTo.f9668y2;
            }
            float f19 = f14;
            if ((i11 & 16) != 0) {
                f15 = curveTo.f9666x3;
            }
            float f21 = f15;
            if ((i11 & 32) != 0) {
                f16 = curveTo.f9669y3;
            }
            return curveTo.copy(f11, f17, f18, f19, f21, f16);
        }

        public final float component1() {
            return this.f9664x1;
        }

        public final float component2() {
            return this.f9667y1;
        }

        public final float component3() {
            return this.f9665x2;
        }

        public final float component4() {
            return this.f9668y2;
        }

        public final float component5() {
            return this.f9666x3;
        }

        public final float component6() {
            return this.f9669y3;
        }

        @NotNull
        public final CurveTo copy(float f11, float f12, float f13, float f14, float f15, float f16) {
            return new CurveTo(f11, f12, f13, f14, f15, f16);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9664x1), (Object) Float.valueOf(curveTo.f9664x1)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9667y1), (Object) Float.valueOf(curveTo.f9667y1)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9665x2), (Object) Float.valueOf(curveTo.f9665x2)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9668y2), (Object) Float.valueOf(curveTo.f9668y2)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9666x3), (Object) Float.valueOf(curveTo.f9666x3)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9669y3), (Object) Float.valueOf(curveTo.f9669y3));
        }

        public final float getX1() {
            return this.f9664x1;
        }

        public final float getX2() {
            return this.f9665x2;
        }

        public final float getX3() {
            return this.f9666x3;
        }

        public final float getY1() {
            return this.f9667y1;
        }

        public final float getY2() {
            return this.f9668y2;
        }

        public final float getY3() {
            return this.f9669y3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f9664x1) * 31) + Float.floatToIntBits(this.f9667y1)) * 31) + Float.floatToIntBits(this.f9665x2)) * 31) + Float.floatToIntBits(this.f9668y2)) * 31) + Float.floatToIntBits(this.f9666x3)) * 31) + Float.floatToIntBits(this.f9669y3);
        }

        @NotNull
        public String toString() {
            return "CurveTo(x1=" + this.f9664x1 + ", y1=" + this.f9667y1 + ", x2=" + this.f9665x2 + ", y2=" + this.f9668y2 + ", x3=" + this.f9666x3 + ", y3=" + this.f9669y3 + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "(F)V", "getX", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class HorizontalTo extends PathNode {

        /* renamed from: x  reason: collision with root package name */
        private final float f9670x;

        public HorizontalTo(float f11) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9670x = f11;
        }

        public static /* synthetic */ HorizontalTo copy$default(HorizontalTo horizontalTo, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = horizontalTo.f9670x;
            }
            return horizontalTo.copy(f11);
        }

        public final float component1() {
            return this.f9670x;
        }

        @NotNull
        public final HorizontalTo copy(float f11) {
            return new HorizontalTo(f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalTo) && Intrinsics.areEqual((Object) Float.valueOf(this.f9670x), (Object) Float.valueOf(((HorizontalTo) obj).f9670x));
        }

        public final float getX() {
            return this.f9670x;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f9670x);
        }

        @NotNull
        public String toString() {
            return "HorizontalTo(x=" + this.f9670x + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LineTo extends PathNode {

        /* renamed from: x  reason: collision with root package name */
        private final float f9671x;

        /* renamed from: y  reason: collision with root package name */
        private final float f9672y;

        public LineTo(float f11, float f12) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9671x = f11;
            this.f9672y = f12;
        }

        public static /* synthetic */ LineTo copy$default(LineTo lineTo, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = lineTo.f9671x;
            }
            if ((i11 & 2) != 0) {
                f12 = lineTo.f9672y;
            }
            return lineTo.copy(f11, f12);
        }

        public final float component1() {
            return this.f9671x;
        }

        public final float component2() {
            return this.f9672y;
        }

        @NotNull
        public final LineTo copy(float f11, float f12) {
            return new LineTo(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9671x), (Object) Float.valueOf(lineTo.f9671x)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9672y), (Object) Float.valueOf(lineTo.f9672y));
        }

        public final float getX() {
            return this.f9671x;
        }

        public final float getY() {
            return this.f9672y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9671x) * 31) + Float.floatToIntBits(this.f9672y);
        }

        @NotNull
        public String toString() {
            return "LineTo(x=" + this.f9671x + ", y=" + this.f9672y + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MoveTo extends PathNode {

        /* renamed from: x  reason: collision with root package name */
        private final float f9673x;

        /* renamed from: y  reason: collision with root package name */
        private final float f9674y;

        public MoveTo(float f11, float f12) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9673x = f11;
            this.f9674y = f12;
        }

        public static /* synthetic */ MoveTo copy$default(MoveTo moveTo, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = moveTo.f9673x;
            }
            if ((i11 & 2) != 0) {
                f12 = moveTo.f9674y;
            }
            return moveTo.copy(f11, f12);
        }

        public final float component1() {
            return this.f9673x;
        }

        public final float component2() {
            return this.f9674y;
        }

        @NotNull
        public final MoveTo copy(float f11, float f12) {
            return new MoveTo(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9673x), (Object) Float.valueOf(moveTo.f9673x)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9674y), (Object) Float.valueOf(moveTo.f9674y));
        }

        public final float getX() {
            return this.f9673x;
        }

        public final float getY() {
            return this.f9674y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9673x) * 31) + Float.floatToIntBits(this.f9674y);
        }

        @NotNull
        public String toString() {
            return "MoveTo(x=" + this.f9673x + ", y=" + this.f9674y + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class QuadTo extends PathNode {

        /* renamed from: x1  reason: collision with root package name */
        private final float f9675x1;

        /* renamed from: x2  reason: collision with root package name */
        private final float f9676x2;

        /* renamed from: y1  reason: collision with root package name */
        private final float f9677y1;

        /* renamed from: y2  reason: collision with root package name */
        private final float f9678y2;

        public QuadTo(float f11, float f12, float f13, float f14) {
            super(false, true, 1, (DefaultConstructorMarker) null);
            this.f9675x1 = f11;
            this.f9677y1 = f12;
            this.f9676x2 = f13;
            this.f9678y2 = f14;
        }

        public static /* synthetic */ QuadTo copy$default(QuadTo quadTo, float f11, float f12, float f13, float f14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = quadTo.f9675x1;
            }
            if ((i11 & 2) != 0) {
                f12 = quadTo.f9677y1;
            }
            if ((i11 & 4) != 0) {
                f13 = quadTo.f9676x2;
            }
            if ((i11 & 8) != 0) {
                f14 = quadTo.f9678y2;
            }
            return quadTo.copy(f11, f12, f13, f14);
        }

        public final float component1() {
            return this.f9675x1;
        }

        public final float component2() {
            return this.f9677y1;
        }

        public final float component3() {
            return this.f9676x2;
        }

        public final float component4() {
            return this.f9678y2;
        }

        @NotNull
        public final QuadTo copy(float f11, float f12, float f13, float f14) {
            return new QuadTo(f11, f12, f13, f14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9675x1), (Object) Float.valueOf(quadTo.f9675x1)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9677y1), (Object) Float.valueOf(quadTo.f9677y1)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9676x2), (Object) Float.valueOf(quadTo.f9676x2)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9678y2), (Object) Float.valueOf(quadTo.f9678y2));
        }

        public final float getX1() {
            return this.f9675x1;
        }

        public final float getX2() {
            return this.f9676x2;
        }

        public final float getY1() {
            return this.f9677y1;
        }

        public final float getY2() {
            return this.f9678y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f9675x1) * 31) + Float.floatToIntBits(this.f9677y1)) * 31) + Float.floatToIntBits(this.f9676x2)) * 31) + Float.floatToIntBits(this.f9678y2);
        }

        @NotNull
        public String toString() {
            return "QuadTo(x1=" + this.f9675x1 + ", y1=" + this.f9677y1 + ", x2=" + this.f9676x2 + ", y2=" + this.f9678y2 + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ReflectiveCurveTo extends PathNode {

        /* renamed from: x1  reason: collision with root package name */
        private final float f9679x1;

        /* renamed from: x2  reason: collision with root package name */
        private final float f9680x2;

        /* renamed from: y1  reason: collision with root package name */
        private final float f9681y1;

        /* renamed from: y2  reason: collision with root package name */
        private final float f9682y2;

        public ReflectiveCurveTo(float f11, float f12, float f13, float f14) {
            super(true, false, 2, (DefaultConstructorMarker) null);
            this.f9679x1 = f11;
            this.f9681y1 = f12;
            this.f9680x2 = f13;
            this.f9682y2 = f14;
        }

        public static /* synthetic */ ReflectiveCurveTo copy$default(ReflectiveCurveTo reflectiveCurveTo, float f11, float f12, float f13, float f14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = reflectiveCurveTo.f9679x1;
            }
            if ((i11 & 2) != 0) {
                f12 = reflectiveCurveTo.f9681y1;
            }
            if ((i11 & 4) != 0) {
                f13 = reflectiveCurveTo.f9680x2;
            }
            if ((i11 & 8) != 0) {
                f14 = reflectiveCurveTo.f9682y2;
            }
            return reflectiveCurveTo.copy(f11, f12, f13, f14);
        }

        public final float component1() {
            return this.f9679x1;
        }

        public final float component2() {
            return this.f9681y1;
        }

        public final float component3() {
            return this.f9680x2;
        }

        public final float component4() {
            return this.f9682y2;
        }

        @NotNull
        public final ReflectiveCurveTo copy(float f11, float f12, float f13, float f14) {
            return new ReflectiveCurveTo(f11, f12, f13, f14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9679x1), (Object) Float.valueOf(reflectiveCurveTo.f9679x1)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9681y1), (Object) Float.valueOf(reflectiveCurveTo.f9681y1)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9680x2), (Object) Float.valueOf(reflectiveCurveTo.f9680x2)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9682y2), (Object) Float.valueOf(reflectiveCurveTo.f9682y2));
        }

        public final float getX1() {
            return this.f9679x1;
        }

        public final float getX2() {
            return this.f9680x2;
        }

        public final float getY1() {
            return this.f9681y1;
        }

        public final float getY2() {
            return this.f9682y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f9679x1) * 31) + Float.floatToIntBits(this.f9681y1)) * 31) + Float.floatToIntBits(this.f9680x2)) * 31) + Float.floatToIntBits(this.f9682y2);
        }

        @NotNull
        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f9679x1 + ", y1=" + this.f9681y1 + ", x2=" + this.f9680x2 + ", y2=" + this.f9682y2 + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ReflectiveQuadTo extends PathNode {

        /* renamed from: x  reason: collision with root package name */
        private final float f9683x;

        /* renamed from: y  reason: collision with root package name */
        private final float f9684y;

        public ReflectiveQuadTo(float f11, float f12) {
            super(false, true, 1, (DefaultConstructorMarker) null);
            this.f9683x = f11;
            this.f9684y = f12;
        }

        public static /* synthetic */ ReflectiveQuadTo copy$default(ReflectiveQuadTo reflectiveQuadTo, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = reflectiveQuadTo.f9683x;
            }
            if ((i11 & 2) != 0) {
                f12 = reflectiveQuadTo.f9684y;
            }
            return reflectiveQuadTo.copy(f11, f12);
        }

        public final float component1() {
            return this.f9683x;
        }

        public final float component2() {
            return this.f9684y;
        }

        @NotNull
        public final ReflectiveQuadTo copy(float f11, float f12) {
            return new ReflectiveQuadTo(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9683x), (Object) Float.valueOf(reflectiveQuadTo.f9683x)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9684y), (Object) Float.valueOf(reflectiveQuadTo.f9684y));
        }

        public final float getX() {
            return this.f9683x;
        }

        public final float getY() {
            return this.f9684y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9683x) * 31) + Float.floatToIntBits(this.f9684y);
        }

        @NotNull
        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f9683x + ", y=" + this.f9684y + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartDx", "arcStartDy", "(FFFZZFF)V", "getArcStartDx", "()F", "getArcStartDy", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeArcTo extends PathNode {
        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        public RelativeArcTo(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.horizontalEllipseRadius = f11;
            this.verticalEllipseRadius = f12;
            this.theta = f13;
            this.isMoreThanHalf = z11;
            this.isPositiveArc = z12;
            this.arcStartDx = f14;
            this.arcStartDy = f15;
        }

        public static /* synthetic */ RelativeArcTo copy$default(RelativeArcTo relativeArcTo, float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeArcTo.horizontalEllipseRadius;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeArcTo.verticalEllipseRadius;
            }
            float f16 = f12;
            if ((i11 & 4) != 0) {
                f13 = relativeArcTo.theta;
            }
            float f17 = f13;
            if ((i11 & 8) != 0) {
                z11 = relativeArcTo.isMoreThanHalf;
            }
            boolean z13 = z11;
            if ((i11 & 16) != 0) {
                z12 = relativeArcTo.isPositiveArc;
            }
            boolean z14 = z12;
            if ((i11 & 32) != 0) {
                f14 = relativeArcTo.arcStartDx;
            }
            float f18 = f14;
            if ((i11 & 64) != 0) {
                f15 = relativeArcTo.arcStartDy;
            }
            return relativeArcTo.copy(f11, f16, f17, z13, z14, f18, f15);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartDx;
        }

        public final float component7() {
            return this.arcStartDy;
        }

        @NotNull
        public final RelativeArcTo copy(float f11, float f12, float f13, boolean z11, boolean z12, float f14, float f15) {
            return new RelativeArcTo(f11, f12, f13, z11, z12, f14, f15);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.horizontalEllipseRadius), (Object) Float.valueOf(relativeArcTo.horizontalEllipseRadius)) && Intrinsics.areEqual((Object) Float.valueOf(this.verticalEllipseRadius), (Object) Float.valueOf(relativeArcTo.verticalEllipseRadius)) && Intrinsics.areEqual((Object) Float.valueOf(this.theta), (Object) Float.valueOf(relativeArcTo.theta)) && this.isMoreThanHalf == relativeArcTo.isMoreThanHalf && this.isPositiveArc == relativeArcTo.isPositiveArc && Intrinsics.areEqual((Object) Float.valueOf(this.arcStartDx), (Object) Float.valueOf(relativeArcTo.arcStartDx)) && Intrinsics.areEqual((Object) Float.valueOf(this.arcStartDy), (Object) Float.valueOf(relativeArcTo.arcStartDy));
        }

        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public int hashCode() {
            int floatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            boolean z11 = this.isMoreThanHalf;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (floatToIntBits + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isPositiveArc;
            if (!z13) {
                z12 = z13;
            }
            return ((((i11 + (z12 ? 1 : 0)) * 31) + Float.floatToIntBits(this.arcStartDx)) * 31) + Float.floatToIntBits(this.arcStartDy);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartDx=" + this.arcStartDx + ", arcStartDy=" + this.arcStartDy + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "dx3", "dy3", "(FFFFFF)V", "getDx1", "()F", "getDx2", "getDx3", "getDy1", "getDy2", "getDy3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;

        public RelativeCurveTo(float f11, float f12, float f13, float f14, float f15, float f16) {
            super(true, false, 2, (DefaultConstructorMarker) null);
            this.dx1 = f11;
            this.dy1 = f12;
            this.dx2 = f13;
            this.dy2 = f14;
            this.dx3 = f15;
            this.dy3 = f16;
        }

        public static /* synthetic */ RelativeCurveTo copy$default(RelativeCurveTo relativeCurveTo, float f11, float f12, float f13, float f14, float f15, float f16, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeCurveTo.dx1;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeCurveTo.dy1;
            }
            float f17 = f12;
            if ((i11 & 4) != 0) {
                f13 = relativeCurveTo.dx2;
            }
            float f18 = f13;
            if ((i11 & 8) != 0) {
                f14 = relativeCurveTo.dy2;
            }
            float f19 = f14;
            if ((i11 & 16) != 0) {
                f15 = relativeCurveTo.dx3;
            }
            float f21 = f15;
            if ((i11 & 32) != 0) {
                f16 = relativeCurveTo.dy3;
            }
            return relativeCurveTo.copy(f11, f17, f18, f19, f21, f16);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        public final float component5() {
            return this.dx3;
        }

        public final float component6() {
            return this.dy3;
        }

        @NotNull
        public final RelativeCurveTo copy(float f11, float f12, float f13, float f14, float f15, float f16) {
            return new RelativeCurveTo(f11, f12, f13, f14, f15, f16);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.dx1), (Object) Float.valueOf(relativeCurveTo.dx1)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy1), (Object) Float.valueOf(relativeCurveTo.dy1)) && Intrinsics.areEqual((Object) Float.valueOf(this.dx2), (Object) Float.valueOf(relativeCurveTo.dx2)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy2), (Object) Float.valueOf(relativeCurveTo.dy2)) && Intrinsics.areEqual((Object) Float.valueOf(this.dx3), (Object) Float.valueOf(relativeCurveTo.dx3)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy3), (Object) Float.valueOf(relativeCurveTo.dy3));
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDx3() {
            return this.dx3;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public final float getDy3() {
            return this.dy3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2)) * 31) + Float.floatToIntBits(this.dx3)) * 31) + Float.floatToIntBits(this.dy3);
        }

        @NotNull
        public String toString() {
            return "RelativeCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ", dx3=" + this.dx3 + ", dy3=" + this.dy3 + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "(F)V", "getDx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeHorizontalTo extends PathNode {

        /* renamed from: dx  reason: collision with root package name */
        private final float f9685dx;

        public RelativeHorizontalTo(float f11) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9685dx = f11;
        }

        public static /* synthetic */ RelativeHorizontalTo copy$default(RelativeHorizontalTo relativeHorizontalTo, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeHorizontalTo.f9685dx;
            }
            return relativeHorizontalTo.copy(f11);
        }

        public final float component1() {
            return this.f9685dx;
        }

        @NotNull
        public final RelativeHorizontalTo copy(float f11) {
            return new RelativeHorizontalTo(f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeHorizontalTo) && Intrinsics.areEqual((Object) Float.valueOf(this.f9685dx), (Object) Float.valueOf(((RelativeHorizontalTo) obj).f9685dx));
        }

        public final float getDx() {
            return this.f9685dx;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f9685dx);
        }

        @NotNull
        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f9685dx + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeLineTo extends PathNode {

        /* renamed from: dx  reason: collision with root package name */
        private final float f9686dx;

        /* renamed from: dy  reason: collision with root package name */
        private final float f9687dy;

        public RelativeLineTo(float f11, float f12) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9686dx = f11;
            this.f9687dy = f12;
        }

        public static /* synthetic */ RelativeLineTo copy$default(RelativeLineTo relativeLineTo, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeLineTo.f9686dx;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeLineTo.f9687dy;
            }
            return relativeLineTo.copy(f11, f12);
        }

        public final float component1() {
            return this.f9686dx;
        }

        public final float component2() {
            return this.f9687dy;
        }

        @NotNull
        public final RelativeLineTo copy(float f11, float f12) {
            return new RelativeLineTo(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9686dx), (Object) Float.valueOf(relativeLineTo.f9686dx)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9687dy), (Object) Float.valueOf(relativeLineTo.f9687dy));
        }

        public final float getDx() {
            return this.f9686dx;
        }

        public final float getDy() {
            return this.f9687dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9686dx) * 31) + Float.floatToIntBits(this.f9687dy);
        }

        @NotNull
        public String toString() {
            return "RelativeLineTo(dx=" + this.f9686dx + ", dy=" + this.f9687dy + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeMoveTo extends PathNode {

        /* renamed from: dx  reason: collision with root package name */
        private final float f9688dx;

        /* renamed from: dy  reason: collision with root package name */
        private final float f9689dy;

        public RelativeMoveTo(float f11, float f12) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9688dx = f11;
            this.f9689dy = f12;
        }

        public static /* synthetic */ RelativeMoveTo copy$default(RelativeMoveTo relativeMoveTo, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeMoveTo.f9688dx;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeMoveTo.f9689dy;
            }
            return relativeMoveTo.copy(f11, f12);
        }

        public final float component1() {
            return this.f9688dx;
        }

        public final float component2() {
            return this.f9689dy;
        }

        @NotNull
        public final RelativeMoveTo copy(float f11, float f12) {
            return new RelativeMoveTo(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9688dx), (Object) Float.valueOf(relativeMoveTo.f9688dx)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9689dy), (Object) Float.valueOf(relativeMoveTo.f9689dy));
        }

        public final float getDx() {
            return this.f9688dx;
        }

        public final float getDy() {
            return this.f9689dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9688dx) * 31) + Float.floatToIntBits(this.f9689dy);
        }

        @NotNull
        public String toString() {
            return "RelativeMoveTo(dx=" + this.f9688dx + ", dy=" + this.f9689dy + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeQuadTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeQuadTo(float f11, float f12, float f13, float f14) {
            super(false, true, 1, (DefaultConstructorMarker) null);
            this.dx1 = f11;
            this.dy1 = f12;
            this.dx2 = f13;
            this.dy2 = f14;
        }

        public static /* synthetic */ RelativeQuadTo copy$default(RelativeQuadTo relativeQuadTo, float f11, float f12, float f13, float f14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeQuadTo.dx1;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeQuadTo.dy1;
            }
            if ((i11 & 4) != 0) {
                f13 = relativeQuadTo.dx2;
            }
            if ((i11 & 8) != 0) {
                f14 = relativeQuadTo.dy2;
            }
            return relativeQuadTo.copy(f11, f12, f13, f14);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        @NotNull
        public final RelativeQuadTo copy(float f11, float f12, float f13, float f14) {
            return new RelativeQuadTo(f11, f12, f13, f14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.dx1), (Object) Float.valueOf(relativeQuadTo.dx1)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy1), (Object) Float.valueOf(relativeQuadTo.dy1)) && Intrinsics.areEqual((Object) Float.valueOf(this.dx2), (Object) Float.valueOf(relativeQuadTo.dx2)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy2), (Object) Float.valueOf(relativeQuadTo.dy2));
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        @NotNull
        public String toString() {
            return "RelativeQuadTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeReflectiveCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeReflectiveCurveTo(float f11, float f12, float f13, float f14) {
            super(true, false, 2, (DefaultConstructorMarker) null);
            this.dx1 = f11;
            this.dy1 = f12;
            this.dx2 = f13;
            this.dy2 = f14;
        }

        public static /* synthetic */ RelativeReflectiveCurveTo copy$default(RelativeReflectiveCurveTo relativeReflectiveCurveTo, float f11, float f12, float f13, float f14, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeReflectiveCurveTo.dx1;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeReflectiveCurveTo.dy1;
            }
            if ((i11 & 4) != 0) {
                f13 = relativeReflectiveCurveTo.dx2;
            }
            if ((i11 & 8) != 0) {
                f14 = relativeReflectiveCurveTo.dy2;
            }
            return relativeReflectiveCurveTo.copy(f11, f12, f13, f14);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        @NotNull
        public final RelativeReflectiveCurveTo copy(float f11, float f12, float f13, float f14) {
            return new RelativeReflectiveCurveTo(f11, f12, f13, f14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.dx1), (Object) Float.valueOf(relativeReflectiveCurveTo.dx1)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy1), (Object) Float.valueOf(relativeReflectiveCurveTo.dy1)) && Intrinsics.areEqual((Object) Float.valueOf(this.dx2), (Object) Float.valueOf(relativeReflectiveCurveTo.dx2)) && Intrinsics.areEqual((Object) Float.valueOf(this.dy2), (Object) Float.valueOf(relativeReflectiveCurveTo.dy2));
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        @NotNull
        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeReflectiveQuadTo extends PathNode {

        /* renamed from: dx  reason: collision with root package name */
        private final float f9690dx;

        /* renamed from: dy  reason: collision with root package name */
        private final float f9691dy;

        public RelativeReflectiveQuadTo(float f11, float f12) {
            super(false, true, 1, (DefaultConstructorMarker) null);
            this.f9690dx = f11;
            this.f9691dy = f12;
        }

        public static /* synthetic */ RelativeReflectiveQuadTo copy$default(RelativeReflectiveQuadTo relativeReflectiveQuadTo, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeReflectiveQuadTo.f9690dx;
            }
            if ((i11 & 2) != 0) {
                f12 = relativeReflectiveQuadTo.f9691dy;
            }
            return relativeReflectiveQuadTo.copy(f11, f12);
        }

        public final float component1() {
            return this.f9690dx;
        }

        public final float component2() {
            return this.f9691dy;
        }

        @NotNull
        public final RelativeReflectiveQuadTo copy(float f11, float f12) {
            return new RelativeReflectiveQuadTo(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9690dx), (Object) Float.valueOf(relativeReflectiveQuadTo.f9690dx)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9691dy), (Object) Float.valueOf(relativeReflectiveQuadTo.f9691dy));
        }

        public final float getDx() {
            return this.f9690dx;
        }

        public final float getDy() {
            return this.f9691dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9690dx) * 31) + Float.floatToIntBits(this.f9691dy);
        }

        @NotNull
        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f9690dx + ", dy=" + this.f9691dy + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dy", "", "(F)V", "getDy", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RelativeVerticalTo extends PathNode {

        /* renamed from: dy  reason: collision with root package name */
        private final float f9692dy;

        public RelativeVerticalTo(float f11) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9692dy = f11;
        }

        public static /* synthetic */ RelativeVerticalTo copy$default(RelativeVerticalTo relativeVerticalTo, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = relativeVerticalTo.f9692dy;
            }
            return relativeVerticalTo.copy(f11);
        }

        public final float component1() {
            return this.f9692dy;
        }

        @NotNull
        public final RelativeVerticalTo copy(float f11) {
            return new RelativeVerticalTo(f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeVerticalTo) && Intrinsics.areEqual((Object) Float.valueOf(this.f9692dy), (Object) Float.valueOf(((RelativeVerticalTo) obj).f9692dy));
        }

        public final float getDy() {
            return this.f9692dy;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f9692dy);
        }

        @NotNull
        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f9692dy + ')';
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "y", "", "(F)V", "getY", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VerticalTo extends PathNode {

        /* renamed from: y  reason: collision with root package name */
        private final float f9693y;

        public VerticalTo(float f11) {
            super(false, false, 3, (DefaultConstructorMarker) null);
            this.f9693y = f11;
        }

        public static /* synthetic */ VerticalTo copy$default(VerticalTo verticalTo, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = verticalTo.f9693y;
            }
            return verticalTo.copy(f11);
        }

        public final float component1() {
            return this.f9693y;
        }

        @NotNull
        public final VerticalTo copy(float f11) {
            return new VerticalTo(f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalTo) && Intrinsics.areEqual((Object) Float.valueOf(this.f9693y), (Object) Float.valueOf(((VerticalTo) obj).f9693y));
        }

        public final float getY() {
            return this.f9693y;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f9693y);
        }

        @NotNull
        public String toString() {
            return "VerticalTo(y=" + this.f9693y + ')';
        }
    }

    private PathNode(boolean z11, boolean z12) {
        this.isCurve = z11;
        this.isQuad = z12;
    }

    public /* synthetic */ PathNode(boolean z11, boolean z12, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, z12);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    public final boolean isQuad() {
        return this.isQuad;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PathNode(boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? false : z12, (DefaultConstructorMarker) null);
    }
}
