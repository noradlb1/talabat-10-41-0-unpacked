package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a#\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aC\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a;\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001f\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RoundRectKt {
    @NotNull
    public static final RoundRect RoundRect(float f11, float f12, float f13, float f14, float f15, float f16) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f15, f16);
        return new RoundRect(f11, f12, f13, f14, CornerRadius, CornerRadius, CornerRadius, CornerRadius, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: RoundRect-ZAM2FJo  reason: not valid java name */
    public static final RoundRect m2728RoundRectZAM2FJo(@NotNull Rect rect, long j11, long j12, long j13, long j14) {
        Rect rect2 = rect;
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j11, j12, j13, j14, (DefaultConstructorMarker) null);
    }

    /* renamed from: RoundRect-ZAM2FJo$default  reason: not valid java name */
    public static /* synthetic */ RoundRect m2729RoundRectZAM2FJo$default(Rect rect, long j11, long j12, long j13, long j14, int i11, Object obj) {
        long j15;
        long j16;
        long j17;
        long j18;
        if ((i11 & 2) != 0) {
            j15 = CornerRadius.Companion.m2661getZerokKHJgLs();
        } else {
            j15 = j11;
        }
        if ((i11 & 4) != 0) {
            j16 = CornerRadius.Companion.m2661getZerokKHJgLs();
        } else {
            j16 = j12;
        }
        if ((i11 & 8) != 0) {
            j17 = CornerRadius.Companion.m2661getZerokKHJgLs();
        } else {
            j17 = j13;
        }
        if ((i11 & 16) != 0) {
            j18 = CornerRadius.Companion.m2661getZerokKHJgLs();
        } else {
            j18 = j14;
        }
        return m2728RoundRectZAM2FJo(rect, j15, j16, j17, j18);
    }

    @NotNull
    /* renamed from: RoundRect-gG7oq9Y  reason: not valid java name */
    public static final RoundRect m2730RoundRectgG7oq9Y(float f11, float f12, float f13, float f14, long j11) {
        return RoundRect(f11, f12, f13, f14, CornerRadius.m2651getXimpl(j11), CornerRadius.m2652getYimpl(j11));
    }

    @NotNull
    /* renamed from: RoundRect-sniSvfs  reason: not valid java name */
    public static final RoundRect m2731RoundRectsniSvfs(@NotNull Rect rect, long j11) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.m2651getXimpl(j11), CornerRadius.m2652getYimpl(j11));
    }

    @NotNull
    public static final Rect getBoundingRect(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final float getMaxDimension(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    @NotNull
    public static final Rect getSafeInnerRect(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs()), CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m2652getYimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(@NotNull RoundRect roundRect) {
        boolean z11;
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (roundRect.getWidth() == roundRect.getHeight()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !isEllipse(roundRect)) {
            return false;
        }
        return true;
    }

    public static final boolean isEllipse(@NotNull RoundRect roundRect) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs())) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs())) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs())) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs())) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        if (CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs())) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if (z15) {
                            if (CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs())) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16 && ((double) roundRect.getWidth()) <= ((double) CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs())) * 2.0d && ((double) roundRect.getHeight()) <= ((double) CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs())) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isEmpty(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom()) {
            return true;
        }
        return false;
    }

    public static final boolean isFinite(@NotNull RoundRect roundRect) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        float left = roundRect.getLeft();
        if (Float.isInfinite(left) || Float.isNaN(left)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            float top = roundRect.getTop();
            if (Float.isInfinite(top) || Float.isNaN(top)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                float right = roundRect.getRight();
                if (Float.isInfinite(right) || Float.isNaN(right)) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    float bottom = roundRect.getBottom();
                    if (Float.isInfinite(bottom) || Float.isNaN(bottom)) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r0 != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r0 != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r0 != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isRect(@org.jetbrains.annotations.NotNull androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m2726getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            if (r0 != 0) goto L_0x002a
            long r4 = r6.m2726getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            r0 = r2
            goto L_0x0028
        L_0x0027:
            r0 = r3
        L_0x0028:
            if (r0 == 0) goto L_0x0091
        L_0x002a:
            long r4 = r6.m2727getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0038
            r0 = r2
            goto L_0x0039
        L_0x0038:
            r0 = r3
        L_0x0039:
            if (r0 != 0) goto L_0x004c
            long r4 = r6.m2727getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0049
            r0 = r2
            goto L_0x004a
        L_0x0049:
            r0 = r3
        L_0x004a:
            if (r0 == 0) goto L_0x0091
        L_0x004c:
            long r4 = r6.m2724getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x005a
            r0 = r2
            goto L_0x005b
        L_0x005a:
            r0 = r3
        L_0x005b:
            if (r0 != 0) goto L_0x006e
            long r4 = r6.m2724getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x006b
            r0 = r2
            goto L_0x006c
        L_0x006b:
            r0 = r3
        L_0x006c:
            if (r0 == 0) goto L_0x0091
        L_0x006e:
            long r4 = r6.m2725getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x007c
            r0 = r2
            goto L_0x007d
        L_0x007c:
            r0 = r3
        L_0x007d:
            if (r0 != 0) goto L_0x0092
            long r4 = r6.m2725getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x008d
            r6 = r2
            goto L_0x008e
        L_0x008d:
            r6 = r3
        L_0x008e:
            if (r6 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r2 = r3
        L_0x0092:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isSimple(@NotNull RoundRect roundRect) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs())) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs())) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs())) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs())) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs())) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if (z15) {
                            if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs())) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                if (CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2652getYimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs())) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public static final RoundRect lerp(@NotNull RoundRect roundRect, @NotNull RoundRect roundRect2, float f11) {
        float f12 = f11;
        Intrinsics.checkNotNullParameter(roundRect, "start");
        Intrinsics.checkNotNullParameter(roundRect2, TraceLogKt.STOP_PROPERTY_NAME);
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f12), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f12), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f12), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f12), CornerRadiusKt.m2662lerp3Ry4LBc(roundRect.m2726getTopLeftCornerRadiuskKHJgLs(), roundRect2.m2726getTopLeftCornerRadiuskKHJgLs(), f12), CornerRadiusKt.m2662lerp3Ry4LBc(roundRect.m2727getTopRightCornerRadiuskKHJgLs(), roundRect2.m2727getTopRightCornerRadiuskKHJgLs(), f12), CornerRadiusKt.m2662lerp3Ry4LBc(roundRect.m2725getBottomRightCornerRadiuskKHJgLs(), roundRect2.m2725getBottomRightCornerRadiuskKHJgLs(), f12), CornerRadiusKt.m2662lerp3Ry4LBc(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m2724getBottomLeftCornerRadiuskKHJgLs(), f12), (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: translate-Uv8p0NA  reason: not valid java name */
    public static final RoundRect m2732translateUv8p0NA(@NotNull RoundRect roundRect, long j11) {
        RoundRect roundRect2 = roundRect;
        Intrinsics.checkNotNullParameter(roundRect, "$this$translate");
        return new RoundRect(roundRect.getLeft() + Offset.m2676getXimpl(j11), roundRect.getTop() + Offset.m2677getYimpl(j11), roundRect.getRight() + Offset.m2676getXimpl(j11), roundRect.getBottom() + Offset.m2677getYimpl(j11), roundRect.m2726getTopLeftCornerRadiuskKHJgLs(), roundRect.m2727getTopRightCornerRadiuskKHJgLs(), roundRect.m2725getBottomRightCornerRadiuskKHJgLs(), roundRect.m2724getBottomLeftCornerRadiuskKHJgLs(), (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final RoundRect RoundRect(@NotNull Rect rect, float f11, float f12) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f11, f12);
    }
}
