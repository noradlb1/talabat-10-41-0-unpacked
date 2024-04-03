package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BottomNavigationKt {
    @NotNull
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float BottomNavigationHeight = Dp.m5478constructorimpl((float) 56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;

    static {
        float f11 = (float) 12;
        BottomNavigationItemHorizontalPadding = Dp.m5478constructorimpl(f11);
        CombinedItemTextBaseline = Dp.m5478constructorimpl(f11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: BottomNavigation-PEIptTM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1107BottomNavigationPEIptTM(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r23, long r24, long r26, float r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r7 = r29
            r8 = r31
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 456489494(0x1b357a16, float:1.5011417E-22)
            r1 = r30
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r32 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r23
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r23
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r23
            r3 = r8
        L_0x0030:
            r4 = r8 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0049
            r4 = r32 & 2
            if (r4 != 0) goto L_0x0043
            r4 = r24
            boolean r6 = r0.changed((long) r4)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0043:
            r4 = r24
        L_0x0045:
            r6 = 16
        L_0x0047:
            r3 = r3 | r6
            goto L_0x004b
        L_0x0049:
            r4 = r24
        L_0x004b:
            r6 = r8 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0062
            r6 = r32 & 4
            r9 = r26
            if (r6 != 0) goto L_0x005e
            boolean r6 = r0.changed((long) r9)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r6
            goto L_0x0064
        L_0x0062:
            r9 = r26
        L_0x0064:
            r6 = r32 & 8
            if (r6 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r11 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007e
            r11 = r28
            boolean r12 = r0.changed((float) r11)
            if (r12 == 0) goto L_0x007a
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r12
            goto L_0x0080
        L_0x007e:
            r11 = r28
        L_0x0080:
            r12 = r32 & 16
            if (r12 == 0) goto L_0x0087
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0087:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x0099
            boolean r12 = r0.changed((java.lang.Object) r7)
            if (r12 == 0) goto L_0x0096
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r12
        L_0x0099:
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r3
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00b1
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x00a8
            goto L_0x00b1
        L_0x00a8:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r4
            r4 = r9
            r6 = r11
            goto L_0x013c
        L_0x00b1:
            r0.startDefaults()
            r12 = r8 & 1
            r13 = 6
            if (r12 == 0) goto L_0x00d7
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00c0
            goto L_0x00d7
        L_0x00c0:
            r0.skipToGroupEnd()
            r1 = r32 & 2
            if (r1 == 0) goto L_0x00c9
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c9:
            r1 = r32 & 4
            if (r1 == 0) goto L_0x00cf
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00cf:
            r1 = r2
        L_0x00d0:
            r6 = r11
        L_0x00d1:
            r21 = r9
            r9 = r3
            r2 = r21
            goto L_0x0106
        L_0x00d7:
            if (r1 == 0) goto L_0x00dc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00dd
        L_0x00dc:
            r1 = r2
        L_0x00dd:
            r2 = r32 & 2
            if (r2 == 0) goto L_0x00ed
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r13)
            long r4 = androidx.compose.material.ColorsKt.getPrimarySurface(r2)
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ed:
            r2 = r32 & 4
            if (r2 == 0) goto L_0x00fc
            int r2 = r3 >> 3
            r2 = r2 & 14
            long r9 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r4, r0, r2)
            r2 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r3 = r2
        L_0x00fc:
            if (r6 == 0) goto L_0x00d0
            androidx.compose.material.BottomNavigationDefaults r2 = androidx.compose.material.BottomNavigationDefaults.INSTANCE
            float r2 = r2.m1106getElevationD9Ej5fM()
            r6 = r2
            goto L_0x00d1
        L_0x0106:
            r0.endDefaults()
            r10 = 0
            r15 = 0
            androidx.compose.material.BottomNavigationKt$BottomNavigation$1 r11 = new androidx.compose.material.BottomNavigationKt$BottomNavigation$1
            r11.<init>(r7, r9)
            r12 = 678339930(0x286ea55a, float:1.3247509E-14)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r17 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r14, r11)
            r11 = r9 & 14
            r12 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 | r12
            int r12 = r9 << 3
            r14 = r12 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            int r9 = r9 << r13
            r9 = r9 & r12
            r19 = r11 | r9
            r20 = 18
            r9 = r1
            r11 = r4
            r13 = r2
            r16 = r6
            r18 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r9, r10, r11, r13, r15, r16, r17, r18, r19, r20)
            r21 = r2
            r2 = r4
            r4 = r21
        L_0x013c:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0143
            goto L_0x0152
        L_0x0143:
            androidx.compose.material.BottomNavigationKt$BottomNavigation$2 r11 = new androidx.compose.material.BottomNavigationKt$BottomNavigation$2
            r0 = r11
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r4, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1107BottomNavigationPEIptTM(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0125  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: BottomNavigationItem-jY6E1Zs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1108BottomNavigationItemjY6E1Zs(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.RowScope r24, boolean r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, boolean r29, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r32, long r33, long r35, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39, int r40) {
        /*
            r1 = r24
            r3 = r26
            r4 = r27
            r14 = r38
            r15 = r40
            java.lang.String r0 = "$this$BottomNavigationItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -1473735525(0xffffffffa828949b, float:-9.358097E-15)
            r2 = r37
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r15
            if (r2 == 0) goto L_0x002a
            r2 = r14 | 6
            goto L_0x003a
        L_0x002a:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0039
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r2 = r2 | r14
            goto L_0x003a
        L_0x0039:
            r2 = r14
        L_0x003a:
            r7 = r15 & 1
            if (r7 == 0) goto L_0x0041
            r2 = r2 | 48
            goto L_0x0054
        L_0x0041:
            r7 = r14 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0054
            r7 = r25
            boolean r8 = r0.changed((boolean) r7)
            if (r8 == 0) goto L_0x0050
            r8 = 32
            goto L_0x0052
        L_0x0050:
            r8 = 16
        L_0x0052:
            r2 = r2 | r8
            goto L_0x0056
        L_0x0054:
            r7 = r25
        L_0x0056:
            r8 = r15 & 2
            if (r8 == 0) goto L_0x005d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005d:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006d
            boolean r8 = r0.changed((java.lang.Object) r3)
            if (r8 == 0) goto L_0x006a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r2 = r2 | r8
        L_0x006d:
            r8 = r15 & 4
            if (r8 == 0) goto L_0x0074
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0074:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0084
            boolean r8 = r0.changed((java.lang.Object) r4)
            if (r8 == 0) goto L_0x0081
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r2 = r2 | r8
        L_0x0084:
            r8 = r15 & 8
            if (r8 == 0) goto L_0x008b
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a0
            r9 = r28
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x009c
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r2 = r2 | r10
            goto L_0x00a2
        L_0x00a0:
            r9 = r28
        L_0x00a2:
            r10 = r15 & 16
            if (r10 == 0) goto L_0x00aa
            r11 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r11
            goto L_0x00be
        L_0x00aa:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r14
            if (r11 != 0) goto L_0x00be
            r11 = r29
            boolean r12 = r0.changed((boolean) r11)
            if (r12 == 0) goto L_0x00ba
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r2 = r2 | r12
            goto L_0x00c0
        L_0x00be:
            r11 = r29
        L_0x00c0:
            r12 = r15 & 32
            if (r12 == 0) goto L_0x00c8
            r13 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r13
            goto L_0x00dd
        L_0x00c8:
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r14
            if (r13 != 0) goto L_0x00dd
            r13 = r30
            boolean r16 = r0.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r2 = r2 | r16
            goto L_0x00df
        L_0x00dd:
            r13 = r30
        L_0x00df:
            r16 = r15 & 64
            if (r16 == 0) goto L_0x00ea
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r17
            r5 = r31
            goto L_0x00ff
        L_0x00ea:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r14 & r17
            r5 = r31
            if (r17 != 0) goto L_0x00ff
            boolean r17 = r0.changed((boolean) r5)
            if (r17 == 0) goto L_0x00fb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fd
        L_0x00fb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fd:
            r2 = r2 | r17
        L_0x00ff:
            r6 = r15 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x010a
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r18
            r1 = r32
            goto L_0x011f
        L_0x010a:
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r14 & r18
            r1 = r32
            if (r18 != 0) goto L_0x011f
            boolean r18 = r0.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x011b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011d
        L_0x011b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011d:
            r2 = r2 | r18
        L_0x011f:
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x0138
            r1 = r15 & 512(0x200, float:7.175E-43)
            r3 = r33
            if (r1 != 0) goto L_0x0134
            boolean r1 = r0.changed((long) r3)
            if (r1 == 0) goto L_0x0134
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0136
        L_0x0134:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0136:
            r2 = r2 | r1
            goto L_0x013a
        L_0x0138:
            r3 = r33
        L_0x013a:
            r1 = r39 & 14
            if (r1 != 0) goto L_0x0150
            r1 = r15 & 1024(0x400, float:1.435E-42)
            r3 = r35
            if (r1 != 0) goto L_0x014c
            boolean r1 = r0.changed((long) r3)
            if (r1 == 0) goto L_0x014c
            r1 = 4
            goto L_0x014d
        L_0x014c:
            r1 = 2
        L_0x014d:
            r1 = r39 | r1
            goto L_0x0154
        L_0x0150:
            r3 = r35
            r1 = r39
        L_0x0154:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r2 & r18
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r4) goto L_0x017b
            r3 = r1 & 11
            r4 = 2
            if (r3 != r4) goto L_0x017b
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x016a
            goto L_0x017b
        L_0x016a:
            r0.skipToGroupEnd()
            r4 = r27
            r8 = r5
            r5 = r9
            r6 = r11
            r7 = r13
            r9 = r32
            r10 = r33
            r12 = r35
            goto L_0x0374
        L_0x017b:
            r0.startDefaults()
            r3 = r14 & 1
            r17 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = 1
            if (r3 == 0) goto L_0x01a5
            boolean r3 = r0.getDefaultsInvalid()
            if (r3 == 0) goto L_0x018d
            goto L_0x01a5
        L_0x018d:
            r0.skipToGroupEnd()
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0196
            r2 = r2 & r17
        L_0x0196:
            r3 = r15 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x019c
            r1 = r1 & -15
        L_0x019c:
            r6 = r32
            r16 = r35
            r3 = r9
            r8 = r33
            goto L_0x0219
        L_0x01a5:
            if (r8 == 0) goto L_0x01aa
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x01ab
        L_0x01aa:
            r3 = r9
        L_0x01ab:
            if (r10 == 0) goto L_0x01ae
            r11 = r4
        L_0x01ae:
            if (r12 == 0) goto L_0x01b1
            r13 = 0
        L_0x01b1:
            if (r16 == 0) goto L_0x01b4
            r5 = r4
        L_0x01b4:
            if (r6 == 0) goto L_0x01d5
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x01cf
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r6)
        L_0x01cf:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            goto L_0x01d7
        L_0x01d5:
            r6 = r32
        L_0x01d7:
            r8 = r15 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x01ec
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r8 = r8.m2929unboximpl()
            r2 = r2 & r17
            goto L_0x01ee
        L_0x01ec:
            r8 = r33
        L_0x01ee:
            r10 = r15 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0217
            androidx.compose.material.ContentAlpha r10 = androidx.compose.material.ContentAlpha.INSTANCE
            r12 = 6
            float r10 = r10.getMedium(r0, r12)
            r12 = 0
            r16 = 0
            r17 = 0
            r19 = 14
            r20 = 0
            r28 = r8
            r30 = r10
            r31 = r12
            r32 = r16
            r33 = r17
            r34 = r19
            r35 = r20
            long r16 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r28, r30, r31, r32, r33, r34, r35)
            r1 = r1 & -15
            goto L_0x0219
        L_0x0217:
            r16 = r35
        L_0x0219:
            r0.endDefaults()
            if (r13 == 0) goto L_0x022b
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1 r10 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
            r10.<init>(r13, r2)
            r12 = 1343298261(0x50111ad5, float:9.7378191E9)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r4, r10)
            goto L_0x022c
        L_0x022b:
            r10 = 0
        L_0x022c:
            r12 = 0
            r19 = 0
            int r4 = r2 >> 21
            r4 = r4 & 896(0x380, float:1.256E-42)
            r18 = 6
            r4 = r4 | 6
            r20 = 2
            r28 = r12
            r29 = r19
            r30 = r8
            r32 = r0
            r33 = r4
            r34 = r20
            androidx.compose.foundation.Indication r4 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r28, r29, r30, r32, r33, r34)
            androidx.compose.ui.semantics.Role$Companion r12 = androidx.compose.ui.semantics.Role.Companion
            int r12 = r12.m4916getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r12 = androidx.compose.ui.semantics.Role.m4904boximpl(r12)
            r28 = r3
            r29 = r25
            r30 = r6
            r31 = r4
            r32 = r11
            r33 = r12
            r34 = r26
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.selection.SelectableKt.m782selectableO2vRcR0(r28, r29, r30, r31, r32, r33, r34)
            r12 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            r21 = 0
            r28 = r24
            r29 = r4
            r30 = r12
            r31 = r19
            r32 = r20
            r33 = r21
            androidx.compose.ui.Modifier r4 = p.e.a(r28, r29, r30, r31, r32, r33)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getCenter()
            r36 = r3
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r3)
            r3 = 0
            r19 = r6
            r6 = 6
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r3, r0, r6)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r20 = r11
            kotlin.jvm.functions.Function0 r11 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            r21 = r13
            androidx.compose.runtime.Applier r13 = r0.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x02ce
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02ce:
            r0.startReusableNode()
            boolean r13 = r0.getInserting()
            if (r13 == 0) goto L_0x02db
            r0.createNode(r11)
            goto L_0x02de
        L_0x02db:
            r0.useNode()
        L_0x02de:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r13 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r6, r13)
            kotlin.jvm.functions.Function2 r6 = r18.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r12, r6)
            kotlin.jvm.functions.Function2 r6 = r18.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r3, r6)
            kotlin.jvm.functions.Function2 r3 = r18.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r7, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r3)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4.invoke(r3, r0, r6)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r3)
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r3 = -1538530399(0xffffffffa44be3a1, float:-4.4211417E-17)
            r0.startReplaceableGroup(r3)
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1 r3 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
            r4 = r27
            r3.<init>(r5, r4, r10, r2)
            r6 = -1411872801(0xffffffffabd887df, float:-1.5385435E-12)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r7, r3)
            int r6 = r2 >> 27
            r6 = r6 & 14
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            int r1 = r1 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r6
            int r2 = r2 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r28 = r8
            r30 = r16
            r32 = r25
            r33 = r3
            r34 = r0
            r35 = r1
            m1109BottomNavigationTransitionKlgxPg(r28, r30, r32, r33, r34, r35)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r10 = r8
            r12 = r16
            r9 = r19
            r6 = r20
            r7 = r21
            r8 = r5
            r5 = r36
        L_0x0374:
            androidx.compose.runtime.ScopeUpdateScope r3 = r0.endRestartGroup()
            if (r3 != 0) goto L_0x037b
            goto L_0x039a
        L_0x037b:
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3 r2 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
            r0 = r2
            r1 = r24
            r22 = r2
            r2 = r25
            r23 = r3
            r3 = r26
            r4 = r27
            r14 = r38
            r15 = r39
            r16 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16)
            r1 = r22
            r0 = r23
            r0.updateScope(r1)
        L_0x039a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1108BottomNavigationItemjY6E1Zs(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void BottomNavigationItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, float f11, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        float f12 = f11;
        int i16 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1162995092);
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
            BottomNavigationKt$BottomNavigationItemBaselineLayout$2 bottomNavigationKt$BottomNavigationItemBaselineLayout$2 = new BottomNavigationKt$BottomNavigationItemBaselineLayout$2(function24, f12);
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
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, bottomNavigationKt$BottomNavigationItemBaselineLayout$2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion2.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r62, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(395677717);
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
            Composer r63 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r63, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r63, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r63, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r63, viewConfiguration2, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1943403697);
            function23.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier r72 = PaddingKt.m488paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(companion, "label"), f12), BottomNavigationItemHorizontalPadding, 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r72);
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
                Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r12, rememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r12, density3, companion2.getSetDensity());
                Updater.m2543setimpl(r12, layoutDirection3, companion2.getSetLayoutDirection());
                Updater.m2543setimpl(r12, viewConfiguration3, companion2.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                startRestartGroup.startReplaceableGroup(150842644);
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
            endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationItemBaselineLayout$3(function23, function24, f12, i16));
        }
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    /* renamed from: BottomNavigationTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1109BottomNavigationTransitionKlgxPg(long j11, long j12, boolean z11, Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i11) {
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
        Composer startRestartGroup = composer.startRestartGroup(-985175058);
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
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11, BottomNavigationAnimationSpec, 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 12);
            long r92 = ColorKt.m2971lerpjxsXWHM(j14, j13, m1110BottomNavigationTransition_Klgx_Pg$lambda3(animateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(Color.m2918copywmQWz5c$default(r92, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(r92)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -138092754, true, new BottomNavigationKt$BottomNavigationTransition$1(function32, i18, animateFloatAsState)), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationTransition$2(j11, j12, z11, function3, i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition_Klgx_Pg$lambda-3  reason: not valid java name */
    public static final float m1110BottomNavigationTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m1115placeIcon3p2s80s(MeasureScope measureScope, Placeable placeable, long j11) {
        int r22 = Constraints.m5421getMaxHeightimpl(j11);
        return MeasureScope.CC.p(measureScope, placeable.getWidth(), r22, (Map) null, new BottomNavigationKt$placeIcon$1(placeable, (r22 - placeable.getHeight()) / 2), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m1116placeLabelAndIconDIyivk0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, long j11, float f11) {
        int r22 = Constraints.m5421getMaxHeightimpl(j11);
        int i11 = placeable.get(AlignmentLineKt.getLastBaseline());
        int r32 = measureScope.m5441roundToPx0680j_4(CombinedItemTextBaseline);
        int i12 = (r22 - i11) - r32;
        int height = (r22 - (r32 * 2)) - placeable2.getHeight();
        int max = Math.max(placeable.getWidth(), placeable2.getWidth());
        return MeasureScope.CC.p(measureScope, max, r22, (Map) null, new BottomNavigationKt$placeLabelAndIcon$1(f11, placeable, (max - placeable.getWidth()) / 2, i12, MathKt__MathJVMKt.roundToInt(((float) (((r22 - placeable2.getHeight()) / 2) - height)) * (((float) 1) - f11)), placeable2, (max - placeable2.getWidth()) / 2, height), 4, (Object) null);
    }
}
