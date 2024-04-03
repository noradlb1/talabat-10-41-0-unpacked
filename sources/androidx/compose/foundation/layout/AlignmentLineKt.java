package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aA\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AlignmentLineKt {
    /* access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA  reason: not valid java name */
    public static final MeasureResult m369alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, AlignmentLine alignmentLine, float f11, float f12, Measurable measurable, long j11) {
        long j12;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        MeasureScope measureScope2 = measureScope;
        float f13 = f11;
        float f14 = f12;
        if (getHorizontal(alignmentLine)) {
            j12 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 11, (Object) null);
        } else {
            j12 = Constraints.m5413copyZbe2FdA$default(j11, 0, 0, 0, 0, 14, (Object) null);
        }
        Placeable r72 = measurable.m4508measureBRTryo0(j12);
        AlignmentLine alignmentLine2 = alignmentLine;
        int i17 = r72.get(alignmentLine);
        if (i17 == Integer.MIN_VALUE) {
            i17 = 0;
        }
        if (getHorizontal(alignmentLine)) {
            i11 = r72.getHeight();
        } else {
            i11 = r72.getWidth();
        }
        if (getHorizontal(alignmentLine)) {
            i12 = Constraints.m5421getMaxHeightimpl(j11);
        } else {
            i12 = Constraints.m5422getMaxWidthimpl(j11);
        }
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m5483equalsimpl0(f13, companion.m5498getUnspecifiedD9Ej5fM())) {
            i13 = measureScope.m5441roundToPx0680j_4(f13);
        } else {
            i13 = 0;
        }
        int i18 = i12 - i11;
        int coerceIn = RangesKt___RangesKt.coerceIn(i13 - i17, 0, i18);
        if (!Dp.m5483equalsimpl0(f14, companion.m5498getUnspecifiedD9Ej5fM())) {
            i14 = measureScope.m5441roundToPx0680j_4(f14);
        } else {
            i14 = 0;
        }
        int coerceIn2 = RangesKt___RangesKt.coerceIn((i14 - i11) + i17, 0, i18 - coerceIn);
        if (getHorizontal(alignmentLine)) {
            i15 = r72.getWidth();
        } else {
            i15 = Math.max(r72.getWidth() + coerceIn + coerceIn2, Constraints.m5424getMinWidthimpl(j11));
        }
        int i19 = i15;
        if (getHorizontal(alignmentLine)) {
            i16 = Math.max(r72.getHeight() + coerceIn + coerceIn2, Constraints.m5423getMinHeightimpl(j11));
        } else {
            i16 = r72.getHeight();
        }
        int i21 = i16;
        return MeasureScope.CC.p(measureScope, i19, i21, (Map) null, new AlignmentLineKt$alignmentLineOffsetMeasure$1(alignmentLine, f11, coerceIn, i19, coerceIn2, r72, i21), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @NotNull
    @Stable
    /* renamed from: paddingFrom-4j6BHR0  reason: not valid java name */
    public static final Modifier m370paddingFrom4j6BHR0(@NotNull Modifier modifier, @NotNull AlignmentLine alignmentLine, float f11, float f12) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(alignmentLine, f11, f12);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetDp(alignmentLine, f11, f12, function1, (DefaultConstructorMarker) null));
    }

    /* renamed from: paddingFrom-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m371paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 4) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m370paddingFrom4j6BHR0(modifier, alignmentLine, f11, f12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Stable
    /* renamed from: paddingFrom-Y_r0B1c  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m372paddingFromY_r0B1c(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.layout.AlignmentLine r10, long r11, long r13) {
        /*
            java.lang.String r0 = "$this$paddingFrom"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "alignmentLine"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.foundation.layout.AlignmentLineOffsetTextUnit r0 = new androidx.compose.foundation.layout.AlignmentLineOffsetTextUnit
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x001c
            androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r10
            r4 = r11
            r6 = r13
            r2.<init>(r3, r4, r6)
            goto L_0x0020
        L_0x001c:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0020:
            r7 = r1
            r8 = 0
            r1 = r0
            r2 = r10
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5, r7, r8)
            androidx.compose.ui.Modifier r9 = r9.then(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.AlignmentLineKt.m372paddingFromY_r0B1c(androidx.compose.ui.Modifier, androidx.compose.ui.layout.AlignmentLine, long, long):androidx.compose.ui.Modifier");
    }

    /* renamed from: paddingFrom-Y_r0B1c$default  reason: not valid java name */
    public static /* synthetic */ Modifier m373paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = TextUnit.Companion.m5670getUnspecifiedXSAIIZE();
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = TextUnit.Companion.m5670getUnspecifiedXSAIIZE();
        }
        return m372paddingFromY_r0B1c(modifier, alignmentLine, j13, j12);
    }

    @NotNull
    @Stable
    /* renamed from: paddingFromBaseline-VpY3zN4  reason: not valid java name */
    public static final Modifier m374paddingFromBaselineVpY3zN4(@NotNull Modifier modifier, float f11, float f12) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFromBaseline");
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m5483equalsimpl0(f12, companion.m5498getUnspecifiedD9Ej5fM())) {
            modifier2 = m371paddingFrom4j6BHR0$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f12, 2, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        Modifier then = modifier.then(modifier2);
        if (!Dp.m5483equalsimpl0(f11, companion.m5498getUnspecifiedD9Ej5fM())) {
            modifier3 = m371paddingFrom4j6BHR0$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f11, 0.0f, 4, (Object) null);
        } else {
            modifier3 = Modifier.Companion;
        }
        return then.then(modifier3);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m375paddingFromBaselineVpY3zN4$default(Modifier modifier, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        return m374paddingFromBaselineVpY3zN4(modifier, f11, f12);
    }

    @NotNull
    @Stable
    /* renamed from: paddingFromBaseline-wCyjxdI  reason: not valid java name */
    public static final Modifier m376paddingFromBaselinewCyjxdI(@NotNull Modifier modifier, long j11, long j12) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFromBaseline");
        if (!TextUnitKt.m5677isUnspecifiedR2X_6o(j12)) {
            modifier2 = m373paddingFromY_r0B1c$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0, j12, 2, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        Modifier then = modifier.then(modifier2);
        if (!TextUnitKt.m5677isUnspecifiedR2X_6o(j11)) {
            modifier3 = m373paddingFromY_r0B1c$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j11, 0, 4, (Object) null);
        } else {
            modifier3 = Modifier.Companion;
        }
        return then.then(modifier3);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m377paddingFromBaselinewCyjxdI$default(Modifier modifier, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = TextUnit.Companion.m5670getUnspecifiedXSAIIZE();
        }
        if ((i11 & 2) != 0) {
            j12 = TextUnit.Companion.m5670getUnspecifiedXSAIIZE();
        }
        return m376paddingFromBaselinewCyjxdI(modifier, j11, j12);
    }
}
