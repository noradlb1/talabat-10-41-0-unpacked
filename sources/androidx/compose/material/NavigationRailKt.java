package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\u0006\u0010+\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010,\u001aU\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a)\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u000206*\u0002072\u0006\u0010?\u001a\u0002092\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010A\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt {
    /* access modifiers changed from: private */
    public static final float HeaderPadding;
    private static final float ItemIconTopOffset = Dp.m5478constructorimpl((float) 14);
    private static final float ItemLabelBaselineBottomOffset = Dp.m5478constructorimpl((float) 16);
    @NotNull
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    private static final float NavigationRailItemCompactSize = Dp.m5478constructorimpl((float) 56);
    private static final float NavigationRailItemSize = Dp.m5478constructorimpl((float) 72);
    /* access modifiers changed from: private */
    public static final float NavigationRailPadding;

    static {
        float f11 = (float) 8;
        NavigationRailPadding = Dp.m5478constructorimpl(f11);
        HeaderPadding = Dp.m5478constructorimpl(f11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x016b  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: NavigationRail-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1305NavigationRailHsRjFd4(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, long r25, long r27, float r29, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r8 = r31
            r9 = r33
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1790971523(0x6ac00e83, float:1.1609114E26)
            r1 = r32
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r34 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r9 | 6
            r3 = r2
            r2 = r24
            goto L_0x0030
        L_0x001c:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r24
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r9
            goto L_0x0030
        L_0x002d:
            r2 = r24
            r3 = r9
        L_0x0030:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0049
            r4 = r34 & 2
            if (r4 != 0) goto L_0x0043
            r4 = r25
            boolean r6 = r0.changed((long) r4)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0043:
            r4 = r25
        L_0x0045:
            r6 = 16
        L_0x0047:
            r3 = r3 | r6
            goto L_0x004b
        L_0x0049:
            r4 = r25
        L_0x004b:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0064
            r6 = r34 & 4
            if (r6 != 0) goto L_0x005e
            r6 = r27
            boolean r10 = r0.changed((long) r6)
            if (r10 == 0) goto L_0x0060
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r6 = r27
        L_0x0060:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r10
            goto L_0x0066
        L_0x0064:
            r6 = r27
        L_0x0066:
            r10 = r34 & 8
            if (r10 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0080
            r11 = r29
            boolean r12 = r0.changed((float) r11)
            if (r12 == 0) goto L_0x007c
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r12
            goto L_0x0082
        L_0x0080:
            r11 = r29
        L_0x0082:
            r12 = r34 & 16
            if (r12 == 0) goto L_0x0089
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x009e
            r13 = r30
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009a
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r14
            goto L_0x00a0
        L_0x009e:
            r13 = r30
        L_0x00a0:
            r14 = r34 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00aa
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00a8:
            r3 = r3 | r14
            goto L_0x00ba
        L_0x00aa:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00ba
            boolean r14 = r0.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x00b7
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a8
        L_0x00b7:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a8
        L_0x00ba:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r3
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00d4
            boolean r14 = r0.getSkipping()
            if (r14 != 0) goto L_0x00ca
            goto L_0x00d4
        L_0x00ca:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r4
            r4 = r6
            r6 = r11
            r7 = r13
            goto L_0x0164
        L_0x00d4:
            r0.startDefaults()
            r14 = r9 & 1
            r15 = 6
            if (r14 == 0) goto L_0x00f7
            boolean r14 = r0.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00e3
            goto L_0x00f7
        L_0x00e3:
            r0.skipToGroupEnd()
            r1 = r34 & 2
            if (r1 == 0) goto L_0x00ec
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ec:
            r1 = r34 & 4
            if (r1 == 0) goto L_0x00f2
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00f2:
            r1 = r2
        L_0x00f3:
            r10 = r3
            r2 = r11
            r3 = r13
            goto L_0x012b
        L_0x00f7:
            if (r1 == 0) goto L_0x00fc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00fd
        L_0x00fc:
            r1 = r2
        L_0x00fd:
            r2 = r34 & 2
            if (r2 == 0) goto L_0x010d
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r15)
            long r4 = r2.m1183getSurface0d7_KjU()
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x010d:
            r2 = r34 & 4
            if (r2 == 0) goto L_0x011c
            int r2 = r3 >> 3
            r2 = r2 & 14
            long r6 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r4, r0, r2)
            r2 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r3 = r2
        L_0x011c:
            if (r10 == 0) goto L_0x0125
            androidx.compose.material.NavigationRailDefaults r2 = androidx.compose.material.NavigationRailDefaults.INSTANCE
            float r2 = r2.m1304getElevationD9Ej5fM()
            r11 = r2
        L_0x0125:
            if (r12 == 0) goto L_0x00f3
            r2 = 0
            r10 = r3
            r3 = r2
            r2 = r11
        L_0x012b:
            r0.endDefaults()
            r11 = 0
            r16 = 0
            androidx.compose.material.NavigationRailKt$NavigationRail$1 r12 = new androidx.compose.material.NavigationRailKt$NavigationRail$1
            r12.<init>(r3, r10, r8)
            r13 = -1571506489(0xffffffffa254b6c7, float:-2.882812E-18)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r18 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r13, r14, r12)
            r12 = r10 & 14
            r13 = 1572864(0x180000, float:2.204052E-39)
            r12 = r12 | r13
            int r13 = r10 << 3
            r14 = r13 & 896(0x380, float:1.256E-42)
            r12 = r12 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            int r10 = r10 << r15
            r13 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r13
            r20 = r12 | r10
            r21 = 18
            r10 = r1
            r12 = r4
            r14 = r6
            r17 = r2
            r19 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21)
            r22 = r6
            r6 = r2
            r7 = r3
            r2 = r4
            r4 = r22
        L_0x0164:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x016b
            goto L_0x017a
        L_0x016b:
            androidx.compose.material.NavigationRailKt$NavigationRail$2 r12 = new androidx.compose.material.NavigationRailKt$NavigationRail$2
            r0 = r12
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m1305NavigationRailHsRjFd4(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0121  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: NavigationRailItem-0S3VyRs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1306NavigationRailItem0S3VyRs(boolean r23, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, boolean r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, boolean r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r30, long r31, long r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r2 = r24
            r3 = r25
            r13 = r36
            r14 = r37
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = -1813548445(0xffffffff93e77263, float:-5.8425392E-27)
            r1 = r35
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0025
            r1 = r13 | 6
            r4 = r1
            r1 = r23
            goto L_0x0039
        L_0x0025:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0036
            r1 = r23
            boolean r4 = r0.changed((boolean) r1)
            if (r4 == 0) goto L_0x0033
            r4 = 4
            goto L_0x0034
        L_0x0033:
            r4 = 2
        L_0x0034:
            r4 = r4 | r13
            goto L_0x0039
        L_0x0036:
            r1 = r23
            r4 = r13
        L_0x0039:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0040
            r4 = r4 | 48
            goto L_0x0050
        L_0x0040:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0050
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x004d
            r5 = 32
            goto L_0x004f
        L_0x004d:
            r5 = 16
        L_0x004f:
            r4 = r4 | r5
        L_0x0050:
            r5 = r14 & 4
            if (r5 == 0) goto L_0x0057
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0057:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0067
            boolean r5 = r0.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r5
        L_0x0067:
            r5 = r14 & 8
            if (r5 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0081
            r6 = r26
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007d
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r7
            goto L_0x0083
        L_0x0081:
            r6 = r26
        L_0x0083:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x009f
            r8 = r27
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x009b
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r4 = r4 | r9
            goto L_0x00a1
        L_0x009f:
            r8 = r27
        L_0x00a1:
            r9 = r14 & 32
            if (r9 == 0) goto L_0x00a9
            r10 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r10
            goto L_0x00bd
        L_0x00a9:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00bd
            r10 = r28
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x00b9
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r4 = r4 | r11
            goto L_0x00bf
        L_0x00bd:
            r10 = r28
        L_0x00bf:
            r11 = r14 & 64
            if (r11 == 0) goto L_0x00c7
            r12 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r12
            goto L_0x00db
        L_0x00c7:
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r13
            if (r12 != 0) goto L_0x00db
            r12 = r29
            boolean r15 = r0.changed((boolean) r12)
            if (r15 == 0) goto L_0x00d7
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r4 = r4 | r15
            goto L_0x00dd
        L_0x00db:
            r12 = r29
        L_0x00dd:
            r15 = r14 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x00e8
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r16
            r1 = r30
            goto L_0x00fd
        L_0x00e8:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            r1 = r30
            if (r16 != 0) goto L_0x00fd
            boolean r16 = r0.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00f9
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f9:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r4 = r4 | r16
        L_0x00fd:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0119
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0112
            r1 = r31
            boolean r16 = r0.changed((long) r1)
            if (r16 == 0) goto L_0x0114
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0116
        L_0x0112:
            r1 = r31
        L_0x0114:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0116:
            r4 = r4 | r16
            goto L_0x011b
        L_0x0119:
            r1 = r31
        L_0x011b:
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0137
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x0130
            r1 = r33
            boolean r16 = r0.changed((long) r1)
            if (r16 == 0) goto L_0x0132
            r16 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0134
        L_0x0130:
            r1 = r33
        L_0x0132:
            r16 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0134:
            r4 = r4 | r16
            goto L_0x0139
        L_0x0137:
            r1 = r33
        L_0x0139:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r4 & r16
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0159
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x014a
            goto L_0x0159
        L_0x014a:
            r0.skipToGroupEnd()
            r4 = r6
            r5 = r8
            r6 = r10
            r7 = r12
            r8 = r30
            r9 = r31
            r11 = r33
            goto L_0x0354
        L_0x0159:
            r0.startDefaults()
            r1 = r13 & 1
            r16 = 0
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = 1
            if (r1 == 0) goto L_0x0187
            boolean r1 = r0.getDefaultsInvalid()
            if (r1 == 0) goto L_0x016d
            goto L_0x0187
        L_0x016d:
            r0.skipToGroupEnd()
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0176
            r4 = r4 & r17
        L_0x0176:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x017e
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = r4 & r1
        L_0x017e:
            r5 = r30
            r18 = r33
            r1 = r6
            r6 = r31
            goto L_0x0208
        L_0x0187:
            if (r5 == 0) goto L_0x018c
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x018d
        L_0x018c:
            r1 = r6
        L_0x018d:
            if (r7 == 0) goto L_0x0190
            r8 = r2
        L_0x0190:
            if (r9 == 0) goto L_0x0194
            r10 = r16
        L_0x0194:
            if (r11 == 0) goto L_0x0197
            r12 = r2
        L_0x0197:
            if (r15 == 0) goto L_0x01b8
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r5)
            java.lang.Object r5 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x01b2
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r5)
        L_0x01b2:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            goto L_0x01ba
        L_0x01b8:
            r5 = r30
        L_0x01ba:
            r6 = r14 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x01cc
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 6
            androidx.compose.material.Colors r6 = r6.getColors(r0, r7)
            long r6 = r6.m1179getPrimary0d7_KjU()
            r4 = r4 & r17
            goto L_0x01ce
        L_0x01cc:
            r6 = r31
        L_0x01ce:
            r9 = r14 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0206
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.graphics.Color r9 = (androidx.compose.ui.graphics.Color) r9
            long r18 = r9.m2929unboximpl()
            androidx.compose.material.ContentAlpha r9 = androidx.compose.material.ContentAlpha.INSTANCE
            r11 = 6
            float r9 = r9.getMedium(r0, r11)
            r11 = 0
            r15 = 0
            r17 = 0
            r20 = 14
            r21 = 0
            r26 = r18
            r28 = r9
            r29 = r11
            r30 = r15
            r31 = r17
            r32 = r20
            r33 = r21
            long r18 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r26, r28, r29, r30, r31, r32, r33)
            r9 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = r4 & r9
            goto L_0x0208
        L_0x0206:
            r18 = r33
        L_0x0208:
            r0.endDefaults()
            if (r10 == 0) goto L_0x0219
            androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1 r9 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
            r9.<init>(r10, r4)
            r11 = -180398615(0xfffffffff53f55e9, float:-2.4254667E32)
            androidx.compose.runtime.internal.ComposableLambda r16 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r2, r9)
        L_0x0219:
            r9 = r16
            if (r10 != 0) goto L_0x0220
            float r11 = NavigationRailItemCompactSize
            goto L_0x0222
        L_0x0220:
            float r11 = NavigationRailItemSize
        L_0x0222:
            r15 = 0
            r16 = 0
            int r2 = r4 >> 18
            r2 = r2 & 896(0x380, float:1.256E-42)
            r17 = 6
            r2 = r2 | 6
            r17 = 2
            r26 = r15
            r27 = r16
            r28 = r6
            r30 = r0
            r31 = r2
            r32 = r17
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r26, r27, r28, r30, r31, r32)
            androidx.compose.ui.semantics.Role$Companion r15 = androidx.compose.ui.semantics.Role.Companion
            int r15 = r15.m4916getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r15 = androidx.compose.ui.semantics.Role.m4904boximpl(r15)
            r26 = r1
            r27 = r23
            r28 = r5
            r29 = r2
            r30 = r8
            r31 = r15
            r32 = r24
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableKt.m782selectableO2vRcR0(r26, r27, r28, r29, r30, r31, r32)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r2, r11)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getCenter()
            r15 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r15)
            r15 = 0
            r34 = r1
            r1 = 6
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r15, r0, r1)
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            r16 = r5
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r20 = r8
            kotlin.jvm.functions.Function0 r8 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r21 = r10
            androidx.compose.runtime.Applier r10 = r0.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x02b2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02b2:
            r0.startReusableNode()
            boolean r10 = r0.getInserting()
            if (r10 == 0) goto L_0x02bf
            r0.createNode(r8)
            goto L_0x02c2
        L_0x02bf:
            r0.useNode()
        L_0x02c2:
            r0.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r10 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r11, r10)
            kotlin.jvm.functions.Function2 r10 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r1, r10)
            kotlin.jvm.functions.Function2 r1 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r15, r1)
            kotlin.jvm.functions.Function2 r1 = r17.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r5, r1)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2.invoke(r1, r0, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r1 = -172871267(0xfffffffff5b2319d, float:-4.5177496E32)
            r0.startReplaceableGroup(r1)
            androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1 r1 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
            r1.<init>(r12, r3, r9, r4)
            r2 = 670576792(0x27f83098, float:6.8886513E-15)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r5, r1)
            int r2 = r4 >> 24
            r5 = r2 & 14
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            r5 = 6
            int r4 = r4 << r5
            r4 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r26 = r6
            r28 = r18
            r30 = r23
            r31 = r1
            r32 = r0
            r33 = r2
            m1307NavigationRailTransitionKlgxPg(r26, r28, r30, r31, r32, r33)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r4 = r34
            r9 = r6
            r7 = r12
            r8 = r16
            r11 = r18
            r5 = r20
            r6 = r21
        L_0x0354:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 != 0) goto L_0x035b
            goto L_0x0372
        L_0x035b:
            androidx.compose.material.NavigationRailKt$NavigationRailItem$3 r2 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$3
            r0 = r2
            r1 = r23
            r22 = r2
            r2 = r24
            r3 = r25
            r13 = r36
            r14 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14)
            r0 = r22
            r15.updateScope(r0)
        L_0x0372:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m1306NavigationRailItem0S3VyRs(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void NavigationRailItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, float f11, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        float f12 = f11;
        int i16 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1903861684);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(f12)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if ((i12 & 731) != 146 || !startRestartGroup.getSkipping()) {
            NavigationRailKt$NavigationRailItemBaselineLayout$2 navigationRailKt$NavigationRailItemBaselineLayout$2 = new NavigationRailKt$NavigationRailItemBaselineLayout$2(function24, f12);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r13 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r13, navigationRailKt$NavigationRailItemBaselineLayout$2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r13, density, companion2.getSetDensity());
            Updater.m2543setimpl(r13, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r13, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1943278197);
            Modifier layoutId = LayoutIdKt.layoutId(companion, "icon");
            startRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(layoutId);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r62, viewConfiguration2, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1405563567);
            function23.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier alpha = AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), f12);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(alpha);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r132 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r132, rememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r132, density3, companion2.getSetDensity());
                Updater.m2543setimpl(r132, layoutDirection3, companion2.getSetLayoutDirection());
                Updater.m2543setimpl(r132, viewConfiguration3, companion2.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                startRestartGroup.startReplaceableGroup(2107148020);
                function24.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItemBaselineLayout$3(function23, function24, f12, i16));
        }
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    /* renamed from: NavigationRailTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1307NavigationRailTransitionKlgxPg(long j11, long j12, boolean z11, Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        int i14;
        int i15;
        int i16;
        long j13 = j11;
        long j14 = j12;
        boolean z12 = z11;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i17 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-207161906);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed(j13)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i17;
        } else {
            i12 = i17;
        }
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed(j14)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i17 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i17 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        int i18 = i12;
        if ((i18 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (z12) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11, NavigationRailAnimationSpec, 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 12);
            long r92 = ColorKt.m2971lerpjxsXWHM(j14, j13, m1308NavigationRailTransition_Klgx_Pg$lambda3(animateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(Color.m2918copywmQWz5c$default(r92, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(r92)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1688205042, true, new NavigationRailKt$NavigationRailTransition$1(function32, i18, animateFloatAsState)), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailTransition$2(j11, j12, z11, function3, i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationRailTransition_Klgx_Pg$lambda-3  reason: not valid java name */
    public static final float m1308NavigationRailTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m1313placeIcon3p2s80s(MeasureScope measureScope, Placeable placeable, long j11) {
        return MeasureScope.CC.p(measureScope, Constraints.m5422getMaxWidthimpl(j11), Constraints.m5421getMaxHeightimpl(j11), (Map) null, new NavigationRailKt$placeIcon$1(placeable, Math.max(0, (Constraints.m5422getMaxWidthimpl(j11) - placeable.getWidth()) / 2), Math.max(0, (Constraints.m5421getMaxHeightimpl(j11) - placeable.getHeight()) / 2)), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m1314placeLabelAndIconDIyivk0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, long j11, float f11) {
        int i11 = placeable.get(AlignmentLineKt.getLastBaseline());
        int r62 = (Constraints.m5421getMaxHeightimpl(j11) - i11) - measureScope.m5441roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        int r52 = (Constraints.m5422getMaxWidthimpl(j11) - placeable.getWidth()) / 2;
        int r102 = measureScope.m5441roundToPx0680j_4(ItemIconTopOffset);
        int r92 = (Constraints.m5422getMaxWidthimpl(j11) - placeable2.getWidth()) / 2;
        int roundToInt = MathKt__MathJVMKt.roundToInt(((float) (((Constraints.m5421getMaxHeightimpl(j11) - placeable2.getHeight()) / 2) - r102)) * (((float) 1) - f11));
        return MeasureScope.CC.p(measureScope, Constraints.m5422getMaxWidthimpl(j11), Constraints.m5421getMaxHeightimpl(j11), (Map) null, new NavigationRailKt$placeLabelAndIcon$1(f11, placeable, r52, r62, roundToInt, placeable2, r92, r102), 4, (Object) null);
    }
}
