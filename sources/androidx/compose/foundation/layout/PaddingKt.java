package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001aA\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a!\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a-\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001aA\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "start", "top", "end", "bottom", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", "right", "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", "padding", "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PaddingKt {
    @NotNull
    @Stable
    /* renamed from: PaddingValues-0680j_4  reason: not valid java name */
    public static final PaddingValues m479PaddingValues0680j_4(float f11) {
        return new PaddingValuesImpl(f11, f11, f11, f11, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Stable
    /* renamed from: PaddingValues-YgX7TsA  reason: not valid java name */
    public static final PaddingValues m480PaddingValuesYgX7TsA(float f11, float f12) {
        return new PaddingValuesImpl(f11, f12, f11, f12, (DefaultConstructorMarker) null);
    }

    /* renamed from: PaddingValues-YgX7TsA$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m481PaddingValuesYgX7TsA$default(float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        return m480PaddingValuesYgX7TsA(f11, f12);
    }

    @NotNull
    @Stable
    /* renamed from: PaddingValues-a9UjIt4  reason: not valid java name */
    public static final PaddingValues m482PaddingValuesa9UjIt4(float f11, float f12, float f13, float f14) {
        return new PaddingValuesImpl(f11, f12, f13, f14, (DefaultConstructorMarker) null);
    }

    /* renamed from: PaddingValues-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m483PaddingValuesa9UjIt4$default(float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        }
        return m482PaddingValuesa9UjIt4(f11, f12, f13, f14);
    }

    @NotNull
    @Stable
    /* renamed from: absolutePadding-qDBjuR0  reason: not valid java name */
    public static final Modifier m484absolutePaddingqDBjuR0(@NotNull Modifier modifier, float f11, float f12, float f13, float f14) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$absolutePadding");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1(f11, f12, f13, f14);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new PaddingModifier(f11, f12, f13, f14, false, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: absolutePadding-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m485absolutePaddingqDBjuR0$default(Modifier modifier, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        }
        return m484absolutePaddingqDBjuR0(modifier, f11, f12, f13, f14);
    }

    @Stable
    public static final float calculateEndPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.m498calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.m497calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    public static final float calculateStartPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.m497calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.m498calculateRightPaddingu2uoSUM(layoutDirection);
    }

    @NotNull
    @Stable
    public static final Modifier padding(@NotNull Modifier modifier, @NotNull PaddingValues paddingValues) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new PaddingKt$padding$$inlined$debugInspectorInfo$1(paddingValues);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new PaddingValuesModifier(paddingValues, function1));
    }

    @NotNull
    @Stable
    /* renamed from: padding-3ABfNKs  reason: not valid java name */
    public static final Modifier m486padding3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$padding");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new PaddingKt$padding3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new PaddingModifier(f11, f11, f11, f11, true, function1, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: padding-VpY3zN4  reason: not valid java name */
    public static final Modifier m487paddingVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$padding");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new PaddingKt$paddingVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new PaddingModifier(f11, f12, f11, f12, true, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: padding-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m488paddingVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        return m487paddingVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    /* renamed from: padding-qDBjuR0  reason: not valid java name */
    public static final Modifier m489paddingqDBjuR0(@NotNull Modifier modifier, float f11, float f12, float f13, float f14) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$padding");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1(f11, f12, f13, f14);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new PaddingModifier(f11, f12, f13, f14, true, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: padding-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m490paddingqDBjuR0$default(Modifier modifier, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        }
        return m489paddingqDBjuR0(modifier, f11, f12, f13, f14);
    }
}
