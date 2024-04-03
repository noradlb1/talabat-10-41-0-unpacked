package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u0012\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/Brush;", "", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Brush {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final long intrinsicSize;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J_\u0010\u0003\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0003\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0012J_\u0010\u0013\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u0013\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0019J_\u0010\u001a\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010\u001a\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001fJK\u0010 \u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J-\u0010 \u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010#J_\u0010$\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u000fJA\u0010$\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/graphics/Brush$Companion;", "", "()V", "horizontalGradient", "Landroidx/compose/ui/graphics/Brush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "startX", "endX", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "horizontalGradient-8A-3gB4", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "colors", "", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "linearGradient", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "radialGradient", "center", "radius", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JFI)Landroidx/compose/ui/graphics/Brush;", "sweepGradient", "sweepGradient-Uv8p0NA", "([Lkotlin/Pair;J)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "startY", "endY", "verticalGradient-8A-3gB4", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: horizontalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2863horizontalGradient8A3gB4$default(Companion companion, List list, float f11, float f12, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                f11 = 0.0f;
            }
            if ((i12 & 4) != 0) {
                f12 = Float.POSITIVE_INFINITY;
            }
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2873horizontalGradient8A3gB4((List<Color>) list, f11, f12, i11);
        }

        /* renamed from: linearGradient-mHitzGk$default  reason: not valid java name */
        public static /* synthetic */ Brush m2866linearGradientmHitzGk$default(Companion companion, Pair[] pairArr, long j11, long j12, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                j11 = Offset.Companion.m2692getZeroF1C5BW0();
            }
            long j13 = j11;
            if ((i12 & 4) != 0) {
                j12 = Offset.Companion.m2690getInfiniteF1C5BW0();
            }
            long j14 = j12;
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2876linearGradientmHitzGk((Pair<Float, Color>[]) pairArr, j13, j14, i11);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default  reason: not valid java name */
        public static /* synthetic */ Brush m2868radialGradientP_VxKs$default(Companion companion, Pair[] pairArr, long j11, float f11, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                j11 = Offset.Companion.m2691getUnspecifiedF1C5BW0();
            }
            long j12 = j11;
            if ((i12 & 4) != 0) {
                f11 = Float.POSITIVE_INFINITY;
            }
            float f12 = f11;
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2878radialGradientP_VxKs((Pair<Float, Color>[]) pairArr, j12, f12, i11);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default  reason: not valid java name */
        public static /* synthetic */ Brush m2870sweepGradientUv8p0NA$default(Companion companion, Pair[] pairArr, long j11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j11 = Offset.Companion.m2691getUnspecifiedF1C5BW0();
            }
            return companion.m2880sweepGradientUv8p0NA((Pair<Float, Color>[]) pairArr, j11);
        }

        /* renamed from: verticalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2871verticalGradient8A3gB4$default(Companion companion, List list, float f11, float f12, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                f11 = 0.0f;
            }
            if ((i12 & 4) != 0) {
                f12 = Float.POSITIVE_INFINITY;
            }
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2881verticalGradient8A3gB4((List<Color>) list, f11, f12, i11);
        }

        @NotNull
        @Stable
        /* renamed from: horizontalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2873horizontalGradient8A3gB4(@NotNull List<Color> list, float f11, float f12, int i11) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return m2875linearGradientmHitzGk(list, OffsetKt.Offset(f11, 0.0f), OffsetKt.Offset(f12, 0.0f), i11);
        }

        @NotNull
        @Stable
        /* renamed from: linearGradient-mHitzGk  reason: not valid java name */
        public final Brush m2876linearGradientmHitzGk(@NotNull Pair<Float, Color>[] pairArr, long j11, long j12, int i11) {
            Pair<Float, Color>[] pairArr2 = pairArr;
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            ArrayList arrayList = new ArrayList(r1);
            for (Pair<Float, Color> second : pairArr2) {
                arrayList.add(Color.m2909boximpl(second.getSecond().m2929unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(r1);
            for (Pair<Float, Color> first : pairArr2) {
                arrayList2.add(Float.valueOf(first.getFirst().floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, j11, j12, i11, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: radialGradient-P_Vx-Ks  reason: not valid java name */
        public final Brush m2878radialGradientP_VxKs(@NotNull Pair<Float, Color>[] pairArr, long j11, float f11, int i11) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            ArrayList arrayList = new ArrayList(r0);
            for (Pair<Float, Color> second : pairArr) {
                arrayList.add(Color.m2909boximpl(second.getSecond().m2929unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(r0);
            for (Pair<Float, Color> first : pairArr) {
                arrayList2.add(Float.valueOf(first.getFirst().floatValue()));
            }
            return new RadialGradient(arrayList, arrayList2, j11, f11, i11, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: sweepGradient-Uv8p0NA  reason: not valid java name */
        public final Brush m2880sweepGradientUv8p0NA(@NotNull Pair<Float, Color>[] pairArr, long j11) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            ArrayList arrayList = new ArrayList(r0);
            for (Pair<Float, Color> second : pairArr) {
                arrayList.add(Color.m2909boximpl(second.getSecond().m2929unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(r0);
            for (Pair<Float, Color> first : pairArr) {
                arrayList2.add(Float.valueOf(first.getFirst().floatValue()));
            }
            return new SweepGradient(j11, arrayList, arrayList2, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: verticalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2881verticalGradient8A3gB4(@NotNull List<Color> list, float f11, float f12, int i11) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return m2875linearGradientmHitzGk(list, OffsetKt.Offset(0.0f, f11), OffsetKt.Offset(0.0f, f12), i11);
        }

        @NotNull
        @Stable
        /* renamed from: horizontalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2874horizontalGradient8A3gB4(@NotNull Pair<Float, Color>[] pairArr, float f11, float f12, int i11) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            return m2876linearGradientmHitzGk((Pair<Float, Color>[]) (Pair[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset(f11, 0.0f), OffsetKt.Offset(f12, 0.0f), i11);
        }

        @NotNull
        @Stable
        /* renamed from: verticalGradient-8A-3gB4  reason: not valid java name */
        public final Brush m2882verticalGradient8A3gB4(@NotNull Pair<Float, Color>[] pairArr, float f11, float f12, int i11) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            return m2876linearGradientmHitzGk((Pair<Float, Color>[]) (Pair[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset(0.0f, f11), OffsetKt.Offset(0.0f, f12), i11);
        }

        /* renamed from: horizontalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2864horizontalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f11, float f12, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                f11 = 0.0f;
            }
            if ((i12 & 4) != 0) {
                f12 = Float.POSITIVE_INFINITY;
            }
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2874horizontalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f11, f12, i11);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default  reason: not valid java name */
        public static /* synthetic */ Brush m2869sweepGradientUv8p0NA$default(Companion companion, List list, long j11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j11 = Offset.Companion.m2691getUnspecifiedF1C5BW0();
            }
            return companion.m2879sweepGradientUv8p0NA((List<Color>) list, j11);
        }

        /* renamed from: verticalGradient-8A-3gB4$default  reason: not valid java name */
        public static /* synthetic */ Brush m2872verticalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f11, float f12, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                f11 = 0.0f;
            }
            if ((i12 & 4) != 0) {
                f12 = Float.POSITIVE_INFINITY;
            }
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2882verticalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f11, f12, i11);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default  reason: not valid java name */
        public static /* synthetic */ Brush m2867radialGradientP_VxKs$default(Companion companion, List list, long j11, float f11, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                j11 = Offset.Companion.m2691getUnspecifiedF1C5BW0();
            }
            long j12 = j11;
            if ((i12 & 4) != 0) {
                f11 = Float.POSITIVE_INFINITY;
            }
            float f12 = f11;
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2877radialGradientP_VxKs((List<Color>) list, j12, f12, i11);
        }

        @NotNull
        @Stable
        /* renamed from: linearGradient-mHitzGk  reason: not valid java name */
        public final Brush m2875linearGradientmHitzGk(@NotNull List<Color> list, long j11, long j12, int i11) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return new LinearGradient(list, (List) null, j11, j12, i11, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: radialGradient-P_Vx-Ks  reason: not valid java name */
        public final Brush m2877radialGradientP_VxKs(@NotNull List<Color> list, long j11, float f11, int i11) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return new RadialGradient(list, (List) null, j11, f11, i11, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: sweepGradient-Uv8p0NA  reason: not valid java name */
        public final Brush m2879sweepGradientUv8p0NA(@NotNull List<Color> list, long j11) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return new SweepGradient(j11, list, (List) null, (DefaultConstructorMarker) null);
        }

        /* renamed from: linearGradient-mHitzGk$default  reason: not valid java name */
        public static /* synthetic */ Brush m2865linearGradientmHitzGk$default(Companion companion, List list, long j11, long j12, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                j11 = Offset.Companion.m2692getZeroF1C5BW0();
            }
            long j13 = j11;
            if ((i12 & 4) != 0) {
                j12 = Offset.Companion.m2690getInfiniteF1C5BW0();
            }
            long j14 = j12;
            if ((i12 & 8) != 0) {
                i11 = TileMode.Companion.m3274getClamp3opZhB0();
            }
            return companion.m2875linearGradientmHitzGk((List<Color>) list, j13, j14, i11);
        }
    }

    private Brush() {
        this.intrinsicSize = Size.Companion.m2753getUnspecifiedNHjbRc();
    }

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: applyTo-Pq9zytI  reason: not valid java name */
    public abstract void m2861applyToPq9zytI(long j11, @NotNull Paint paint, float f11);

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m2862getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }
}
