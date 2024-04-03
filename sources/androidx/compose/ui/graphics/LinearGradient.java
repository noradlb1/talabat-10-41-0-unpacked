package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BD\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LinearGradient extends ShaderBrush {
    @NotNull
    private final List<Color> colors;
    private final long end;
    private final long start;
    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinearGradient(List list, List list2, long j11, long j12, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i12 & 2) != 0 ? null : list2, j11, j12, (i12 & 16) != 0 ? TileMode.Companion.m3274getClamp3opZhB0() : i11, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j11, j12, i11);
    }

    @NotNull
    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m3096createShaderuvyYCjk(long j11) {
        boolean z11;
        float f11;
        boolean z12;
        float f12;
        boolean z13;
        float f13;
        float f14;
        boolean z14 = true;
        if (Offset.m2676getXimpl(this.start) == Float.POSITIVE_INFINITY) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f11 = Size.m2745getWidthimpl(j11);
        } else {
            f11 = Offset.m2676getXimpl(this.start);
        }
        if (Offset.m2677getYimpl(this.start) == Float.POSITIVE_INFINITY) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            f12 = Size.m2742getHeightimpl(j11);
        } else {
            f12 = Offset.m2677getYimpl(this.start);
        }
        if (Offset.m2676getXimpl(this.end) == Float.POSITIVE_INFINITY) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            f13 = Size.m2745getWidthimpl(j11);
        } else {
            f13 = Offset.m2676getXimpl(this.end);
        }
        if (Offset.m2677getYimpl(this.end) != Float.POSITIVE_INFINITY) {
            z14 = false;
        }
        if (z14) {
            f14 = Size.m2742getHeightimpl(j11);
        } else {
            f14 = Offset.m2677getYimpl(this.end);
        }
        return ShaderKt.m3220LinearGradientShaderVjE6UOU(OffsetKt.Offset(f11, f12), OffsetKt.Offset(f13, f14), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        if (Intrinsics.areEqual((Object) this.colors, (Object) linearGradient.colors) && Intrinsics.areEqual((Object) this.stops, (Object) linearGradient.stops) && Offset.m2673equalsimpl0(this.start, linearGradient.start) && Offset.m2673equalsimpl0(this.end, linearGradient.end) && TileMode.m3270equalsimpl0(this.tileMode, linearGradient.tileMode)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m3097getIntrinsicSizeNHjbRc() {
        /*
            r6 = this;
            long r0 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            r1 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == 0) goto L_0x0044
            long r4 = r6.end
            float r0 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r4)
            boolean r4 = java.lang.Float.isInfinite(r0)
            if (r4 != 0) goto L_0x002f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x002f
            r0 = r2
            goto L_0x0030
        L_0x002f:
            r0 = r3
        L_0x0030:
            if (r0 == 0) goto L_0x0044
            long r4 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r4)
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r4)
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            long r4 = r6.start
            float r4 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L_0x0059
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L_0x0059
            r4 = r2
            goto L_0x005a
        L_0x0059:
            r4 = r3
        L_0x005a:
            if (r4 == 0) goto L_0x0083
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L_0x006f
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            if (r2 == 0) goto L_0x0083
            long r1 = r6.start
            float r1 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r1)
            long r2 = r6.end
            float r2 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r2)
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
        L_0x0083:
            long r0 = androidx.compose.ui.geometry.SizeKt.Size(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.m3097getIntrinsicSizeNHjbRc():long");
    }

    public int hashCode() {
        int i11;
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        if (list != null) {
            i11 = list.hashCode();
        } else {
            i11 = 0;
        }
        return ((((((hashCode + i11) * 31) + Offset.m2678hashCodeimpl(this.start)) * 31) + Offset.m2678hashCodeimpl(this.end)) * 31) + TileMode.m3271hashCodeimpl(this.tileMode);
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m2693isFinitek4lQ0M(this.start)) {
            str = "start=" + Offset.m2684toStringimpl(this.start) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        } else {
            str = str2;
        }
        if (OffsetKt.m2693isFinitek4lQ0M(this.end)) {
            str2 = "end=" + Offset.m2684toStringimpl(this.end) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str + str2 + "tileMode=" + TileMode.m3272toStringimpl(this.tileMode) + ')';
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j11, long j12, int i11) {
        this.colors = list;
        this.stops = list2;
        this.start = j11;
        this.end = j12;
        this.tileMode = i11;
    }
}
