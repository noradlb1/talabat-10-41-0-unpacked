package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a-\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010 \u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010!\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010\"\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a!\u0010#\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a-\u0010&\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u001f\u001a!\u0010*\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010%\u001a-\u0010,\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u001f\u001a!\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010%\u001a)\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u001f\u001a!\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aA\u00106\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001a!\u0010;\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010%\u001a-\u0010=\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010\u001f\u001a!\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010%\u001a)\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010\u001f\u001a!\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u00105\u001aA\u0010B\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010:\u001a!\u00101\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010%\u001a-\u0010E\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010\u001f\u001a \u0010G\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a \u0010H\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a \u0010I\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillModifier;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentModifier;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "createFillHeightModifier", "fraction", "", "createFillSizeModifier", "createFillWidthModifier", "createWrapContentHeightModifier", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "createWrapContentSizeModifier", "Landroidx/compose/ui/Alignment;", "createWrapContentWidthModifier", "Landroidx/compose/ui/Alignment$Horizontal;", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "wrapContentSize", "wrapContentWidth", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SizeKt {
    @NotNull
    private static final FillModifier FillWholeMaxHeight = createFillHeightModifier(1.0f);
    @NotNull
    private static final FillModifier FillWholeMaxSize = createFillSizeModifier(1.0f);
    @NotNull
    private static final FillModifier FillWholeMaxWidth = createFillWidthModifier(1.0f);
    @NotNull
    private static final WrapContentModifier WrapContentHeightCenter;
    @NotNull
    private static final WrapContentModifier WrapContentHeightTop;
    @NotNull
    private static final WrapContentModifier WrapContentSizeCenter;
    @NotNull
    private static final WrapContentModifier WrapContentSizeTopStart;
    @NotNull
    private static final WrapContentModifier WrapContentWidthCenter;
    @NotNull
    private static final WrapContentModifier WrapContentWidthStart;

    static {
        Alignment.Companion companion = Alignment.Companion;
        WrapContentWidthCenter = createWrapContentWidthModifier(companion.getCenterHorizontally(), false);
        WrapContentWidthStart = createWrapContentWidthModifier(companion.getStart(), false);
        WrapContentHeightCenter = createWrapContentHeightModifier(companion.getCenterVertically(), false);
        WrapContentHeightTop = createWrapContentHeightModifier(companion.getTop(), false);
        WrapContentSizeCenter = createWrapContentSizeModifier(companion.getCenter(), false);
        WrapContentSizeTopStart = createWrapContentSizeModifier(companion.getTopStart(), false);
    }

    private static final FillModifier createFillHeightModifier(float f11) {
        return new FillModifier(Direction.Vertical, f11, new SizeKt$createFillHeightModifier$1(f11));
    }

    private static final FillModifier createFillSizeModifier(float f11) {
        return new FillModifier(Direction.Both, f11, new SizeKt$createFillSizeModifier$1(f11));
    }

    private static final FillModifier createFillWidthModifier(float f11) {
        return new FillModifier(Direction.Horizontal, f11, new SizeKt$createFillWidthModifier$1(f11));
    }

    private static final WrapContentModifier createWrapContentHeightModifier(Alignment.Vertical vertical, boolean z11) {
        return new WrapContentModifier(Direction.Vertical, z11, new SizeKt$createWrapContentHeightModifier$1(vertical), vertical, new SizeKt$createWrapContentHeightModifier$2(vertical, z11));
    }

    private static final WrapContentModifier createWrapContentSizeModifier(Alignment alignment, boolean z11) {
        return new WrapContentModifier(Direction.Both, z11, new SizeKt$createWrapContentSizeModifier$1(alignment), alignment, new SizeKt$createWrapContentSizeModifier$2(alignment, z11));
    }

    private static final WrapContentModifier createWrapContentWidthModifier(Alignment.Horizontal horizontal, boolean z11) {
        return new WrapContentModifier(Direction.Horizontal, z11, new SizeKt$createWrapContentWidthModifier$1(horizontal), horizontal, new SizeKt$createWrapContentWidthModifier$2(horizontal, z11));
    }

    @NotNull
    @Stable
    /* renamed from: defaultMinSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m542defaultMinSizeVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$defaultMinSize");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$defaultMinSizeVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new UnspecifiedConstraintsModifier(f11, f12, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: defaultMinSize-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m543defaultMinSizeVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m542defaultMinSizeVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    public static final Modifier fillMaxHeight(@NotNull Modifier modifier, float f11) {
        boolean z11;
        FillModifier fillModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f11 == 1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            fillModifier = FillWholeMaxHeight;
        } else {
            fillModifier = createFillHeightModifier(f11);
        }
        return modifier.then(fillModifier);
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return fillMaxHeight(modifier, f11);
    }

    @NotNull
    @Stable
    public static final Modifier fillMaxSize(@NotNull Modifier modifier, float f11) {
        boolean z11;
        FillModifier fillModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f11 == 1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            fillModifier = FillWholeMaxSize;
        } else {
            fillModifier = createFillSizeModifier(f11);
        }
        return modifier.then(fillModifier);
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return fillMaxSize(modifier, f11);
    }

    @NotNull
    @Stable
    public static final Modifier fillMaxWidth(@NotNull Modifier modifier, float f11) {
        boolean z11;
        FillModifier fillModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f11 == 1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            fillModifier = FillWholeMaxWidth;
        } else {
            fillModifier = createFillWidthModifier(f11);
        }
        return modifier.then(fillModifier);
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        return fillMaxWidth(modifier, f11);
    }

    @NotNull
    @Stable
    /* renamed from: height-3ABfNKs  reason: not valid java name */
    public static final Modifier m544height3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$height");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$height3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(0.0f, f11, 0.0f, f11, true, function1, 5, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: heightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m545heightInVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$heightIn");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$heightInVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(0.0f, f11, 0.0f, f12, true, function1, 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: heightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m546heightInVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m545heightInVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    /* renamed from: requiredHeight-3ABfNKs  reason: not valid java name */
    public static final Modifier m547requiredHeight3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredHeight");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredHeight3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(0.0f, f11, 0.0f, f11, false, function1, 5, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: requiredHeightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m548requiredHeightInVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredHeightIn");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredHeightInVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(0.0f, f11, 0.0f, f12, false, function1, 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m549requiredHeightInVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m548requiredHeightInVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    /* renamed from: requiredSize-3ABfNKs  reason: not valid java name */
    public static final Modifier m550requiredSize3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, f11, f11, f11, false, function1, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: requiredSize-6HolHcs  reason: not valid java name */
    public static final Modifier m551requiredSize6HolHcs(@NotNull Modifier modifier, long j11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return m552requiredSizeVpY3zN4(modifier, DpSize.m5576getWidthD9Ej5fM(j11), DpSize.m5574getHeightD9Ej5fM(j11));
    }

    @NotNull
    @Stable
    /* renamed from: requiredSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m552requiredSizeVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredSizeVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, f12, f11, f12, false, function1, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: requiredSizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m553requiredSizeInqDBjuR0(@NotNull Modifier modifier, float f11, float f12, float f13, float f14) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSizeIn");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(f11, f12, f13, f14);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, f12, f13, f14, false, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m554requiredSizeInqDBjuR0$default(Modifier modifier, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m553requiredSizeInqDBjuR0(modifier, f11, f12, f13, f14);
    }

    @NotNull
    @Stable
    /* renamed from: requiredWidth-3ABfNKs  reason: not valid java name */
    public static final Modifier m555requiredWidth3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredWidth");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredWidth3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, 0.0f, f11, 0.0f, false, function1, 10, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: requiredWidthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m556requiredWidthInVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredWidthIn");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$requiredWidthInVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, 0.0f, f12, 0.0f, false, function1, 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m557requiredWidthInVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m556requiredWidthInVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    /* renamed from: size-3ABfNKs  reason: not valid java name */
    public static final Modifier m558size3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$size3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, f11, f11, f11, true, function1, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: size-6HolHcs  reason: not valid java name */
    public static final Modifier m559size6HolHcs(@NotNull Modifier modifier, long j11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return m560sizeVpY3zN4(modifier, DpSize.m5576getWidthD9Ej5fM(j11), DpSize.m5574getHeightD9Ej5fM(j11));
    }

    @NotNull
    @Stable
    /* renamed from: size-VpY3zN4  reason: not valid java name */
    public static final Modifier m560sizeVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$sizeVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, f12, f11, f12, true, function1, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: sizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m561sizeInqDBjuR0(@NotNull Modifier modifier, float f11, float f12, float f13, float f14) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$sizeIn");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(f11, f12, f13, f14);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, f12, f13, f14, true, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: sizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m562sizeInqDBjuR0$default(Modifier modifier, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m561sizeInqDBjuR0(modifier, f11, f12, f13, f14);
    }

    @NotNull
    @Stable
    /* renamed from: width-3ABfNKs  reason: not valid java name */
    public static final Modifier m563width3ABfNKs(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$width");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$width3ABfNKs$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, 0.0f, f11, 0.0f, true, function1, 10, (DefaultConstructorMarker) null));
    }

    @NotNull
    @Stable
    /* renamed from: widthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m564widthInVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$widthIn");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new SizeKt$widthInVpY3zN4$$inlined$debugInspectorInfo$1(f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new SizeModifier(f11, 0.0f, f12, 0.0f, true, function1, 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: widthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m565widthInVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m564widthInVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    public static final Modifier wrapContentHeight(@NotNull Modifier modifier, @NotNull Alignment.Vertical vertical, boolean z11) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(vertical, "align");
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual((Object) vertical, (Object) companion.getCenterVertically()) && !z11) {
            wrapContentModifier = WrapContentHeightCenter;
        } else if (!Intrinsics.areEqual((Object) vertical, (Object) companion.getTop()) || z11) {
            wrapContentModifier = createWrapContentHeightModifier(vertical, z11);
        } else {
            wrapContentModifier = WrapContentHeightTop;
        }
        return modifier.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return wrapContentHeight(modifier, vertical, z11);
    }

    @NotNull
    @Stable
    public static final Modifier wrapContentSize(@NotNull Modifier modifier, @NotNull Alignment alignment, boolean z11) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "align");
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual((Object) alignment, (Object) companion.getCenter()) && !z11) {
            wrapContentModifier = WrapContentSizeCenter;
        } else if (!Intrinsics.areEqual((Object) alignment, (Object) companion.getTopStart()) || z11) {
            wrapContentModifier = createWrapContentSizeModifier(alignment, z11);
        } else {
            wrapContentModifier = WrapContentSizeTopStart;
        }
        return modifier.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return wrapContentSize(modifier, alignment, z11);
    }

    @NotNull
    @Stable
    public static final Modifier wrapContentWidth(@NotNull Modifier modifier, @NotNull Alignment.Horizontal horizontal, boolean z11) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(horizontal, "align");
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual((Object) horizontal, (Object) companion.getCenterHorizontally()) && !z11) {
            wrapContentModifier = WrapContentWidthCenter;
        } else if (!Intrinsics.areEqual((Object) horizontal, (Object) companion.getStart()) || z11) {
            wrapContentModifier = createWrapContentWidthModifier(horizontal, z11);
        } else {
            wrapContentModifier = WrapContentWidthStart;
        }
        return modifier.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return wrapContentWidth(modifier, horizontal, z11);
    }
}
