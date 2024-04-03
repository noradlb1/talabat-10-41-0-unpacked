package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u001a\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5478constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float HorizontalTextPadding = Dp.m5478constructorimpl((float) 16);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    /* access modifiers changed from: private */
    public static final float LargeTabHeight = Dp.m5478constructorimpl((float) 72);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5478constructorimpl((float) 14);
    /* access modifiers changed from: private */
    public static final float SmallTabHeight = Dp.m5478constructorimpl((float) 48);
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    /* access modifiers changed from: private */
    public static final float TextDistanceFromLeadingIcon = Dp.m5478constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0124  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: LeadingIconTab-0nD-MI0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1407LeadingIconTab0nDMI0(boolean r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, boolean r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r34, long r35, long r37, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r40
            r14 = r41
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1499861761(0xffffffffa699ecff, float:-1.0680746E-15)
            r1 = r39
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x002b
            r0 = r13 | 6
            r9 = r28
            goto L_0x003d
        L_0x002b:
            r0 = r13 & 14
            r9 = r28
            if (r0 != 0) goto L_0x003c
            boolean r0 = r15.changed((boolean) r9)
            if (r0 == 0) goto L_0x0039
            r0 = 4
            goto L_0x003a
        L_0x0039:
            r0 = 2
        L_0x003a:
            r0 = r0 | r13
            goto L_0x003d
        L_0x003c:
            r0 = r13
        L_0x003d:
            r1 = r14 & 2
            if (r1 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r1 = r13 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0054
            boolean r1 = r15.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0051
            r1 = 32
            goto L_0x0053
        L_0x0051:
            r1 = 16
        L_0x0053:
            r0 = r0 | r1
        L_0x0054:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x005b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x005b:
            r1 = r13 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x006b
            boolean r1 = r15.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0068
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r1 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r1
        L_0x006b:
            r1 = r14 & 8
            if (r1 == 0) goto L_0x0072
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x0072:
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0082
            boolean r1 = r15.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x007f
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r1
        L_0x0082:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x0089
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x009e
            r2 = r32
            boolean r3 = r15.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x009a
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r0 = r0 | r3
            goto L_0x00a0
        L_0x009e:
            r2 = r32
        L_0x00a0:
            r3 = r14 & 32
            if (r3 == 0) goto L_0x00a8
            r4 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r4
            goto L_0x00bc
        L_0x00a8:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00bc
            r4 = r33
            boolean r5 = r15.changed((boolean) r4)
            if (r5 == 0) goto L_0x00b8
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r0 = r0 | r5
            goto L_0x00be
        L_0x00bc:
            r4 = r33
        L_0x00be:
            r5 = r14 & 64
            if (r5 == 0) goto L_0x00c6
            r6 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r6
            goto L_0x00da
        L_0x00c6:
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00da
            r6 = r34
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00d6
            r7 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r7 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r0 = r0 | r7
            goto L_0x00dc
        L_0x00da:
            r6 = r34
        L_0x00dc:
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00f7
            r7 = r14 & 128(0x80, float:1.794E-43)
            if (r7 != 0) goto L_0x00f0
            r7 = r35
            boolean r16 = r15.changed((long) r7)
            if (r16 == 0) goto L_0x00f2
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f0:
            r7 = r35
        L_0x00f2:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r0 = r0 | r16
            goto L_0x00f9
        L_0x00f7:
            r7 = r35
        L_0x00f9:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0112
            r2 = r14 & 256(0x100, float:3.59E-43)
            r6 = r37
            if (r2 != 0) goto L_0x010e
            boolean r2 = r15.changed((long) r6)
            if (r2 == 0) goto L_0x010e
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0110
        L_0x010e:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0110:
            r0 = r0 | r2
            goto L_0x0114
        L_0x0112:
            r6 = r37
        L_0x0114:
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r0
            r8 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r8) goto L_0x0131
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x0124
            goto L_0x0131
        L_0x0124:
            r15.skipToGroupEnd()
            r5 = r32
            r8 = r35
            r10 = r6
            r7 = r34
            r6 = r4
            goto L_0x023c
        L_0x0131:
            r15.startDefaults()
            r2 = r13 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r8 = 1
            if (r2 == 0) goto L_0x0162
            boolean r2 = r15.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0143
            goto L_0x0162
        L_0x0143:
            r15.skipToGroupEnd()
            r1 = r14 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x014c
            r0 = r0 & r16
        L_0x014c:
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0154
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0154:
            r16 = r32
            r19 = r34
            r20 = r35
            r24 = r0
            r18 = r4
            r22 = r6
            goto L_0x01d8
        L_0x0162:
            if (r1 == 0) goto L_0x0167
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0169
        L_0x0167:
            r1 = r32
        L_0x0169:
            if (r3 == 0) goto L_0x016c
            r4 = r8
        L_0x016c:
            if (r5 == 0) goto L_0x018d
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0187
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r2)
        L_0x0187:
            r15.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x018f
        L_0x018d:
            r2 = r34
        L_0x018f:
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x01a4
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r3 = r15.consume(r3)
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r18 = r3.m2929unboximpl()
            r0 = r0 & r16
            goto L_0x01a6
        L_0x01a4:
            r18 = r35
        L_0x01a6:
            r3 = r14 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x01cc
            androidx.compose.material.ContentAlpha r3 = androidx.compose.material.ContentAlpha.INSTANCE
            r5 = 6
            float r22 = r3.getMedium(r15, r5)
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 14
            r27 = 0
            r20 = r18
            long r5 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r20, r22, r23, r24, r25, r26, r27)
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r3
            r24 = r0
            r16 = r1
            r22 = r5
            goto L_0x01d4
        L_0x01cc:
            r24 = r0
            r16 = r1
            r22 = r6
            r20 = r18
        L_0x01d4:
            r19 = r2
            r18 = r4
        L_0x01d8:
            r15.endDefaults()
            r0 = 1
            r1 = 0
            int r2 = r24 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r17 = 6
            r2 = r2 | 6
            r3 = 2
            r32 = r0
            r33 = r1
            r34 = r20
            r36 = r15
            r37 = r2
            r38 = r3
            androidx.compose.foundation.Indication r4 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r32, r33, r34, r36, r37, r38)
            androidx.compose.material.TabKt$LeadingIconTab$2 r7 = new androidx.compose.material.TabKt$LeadingIconTab$2
            r0 = r7
            r1 = r16
            r2 = r28
            r3 = r19
            r5 = r18
            r6 = r29
            r10 = r7
            r7 = r31
            r11 = r8
            r8 = r24
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 866677691(0x33a873bb, float:7.844161E-8)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r11, r10)
            int r1 = r24 >> 21
            r2 = r1 & 14
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r24 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r32 = r20
            r34 = r22
            r36 = r28
            r37 = r0
            r38 = r15
            r39 = r1
            m1410TabTransitionKlgxPg(r32, r34, r36, r37, r38, r39)
            r5 = r16
            r6 = r18
            r7 = r19
            r8 = r20
            r10 = r22
        L_0x023c:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0243
            goto L_0x0259
        L_0x0243:
            androidx.compose.material.TabKt$LeadingIconTab$3 r4 = new androidx.compose.material.TabKt$LeadingIconTab$3
            r0 = r4
            r1 = r28
            r2 = r29
            r3 = r30
            r14 = r4
            r4 = r31
            r12 = r40
            r13 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r15.updateScope(r14)
        L_0x0259:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1407LeadingIconTab0nDMI0(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0114  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Tab-0nD-MI0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1408Tab0nDMI0(boolean r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, boolean r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r35, long r36, long r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r13 = r30
            r14 = r41
            r15 = r42
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1486097588(0xffffffffa76bf34c, float:-3.2744693E-15)
            r1 = r40
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x001d
            r0 = r14 | 6
            r11 = r29
            goto L_0x002f
        L_0x001d:
            r0 = r14 & 14
            r11 = r29
            if (r0 != 0) goto L_0x002e
            boolean r0 = r12.changed((boolean) r11)
            if (r0 == 0) goto L_0x002b
            r0 = 4
            goto L_0x002c
        L_0x002b:
            r0 = 2
        L_0x002c:
            r0 = r0 | r14
            goto L_0x002f
        L_0x002e:
            r0 = r14
        L_0x002f:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x0036
            r0 = r0 | 48
            goto L_0x0046
        L_0x0036:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0046
            boolean r1 = r12.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0043
            r1 = 32
            goto L_0x0045
        L_0x0043:
            r1 = 16
        L_0x0045:
            r0 = r0 | r1
        L_0x0046:
            r1 = r15 & 4
            if (r1 == 0) goto L_0x004d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0060
            r2 = r31
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005c
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r0 = r0 | r3
            goto L_0x0062
        L_0x0060:
            r2 = r31
        L_0x0062:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0069
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007c
            r4 = r32
            boolean r5 = r12.changed((boolean) r4)
            if (r5 == 0) goto L_0x0078
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r0 = r0 | r5
            goto L_0x007e
        L_0x007c:
            r4 = r32
        L_0x007e:
            r5 = r15 & 16
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x0088
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0088:
            r7 = r14 & r6
            if (r7 != 0) goto L_0x009b
            r7 = r33
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0097
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r0 = r0 | r8
            goto L_0x009d
        L_0x009b:
            r7 = r33
        L_0x009d:
            r8 = r15 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00a7
            r10 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r10
            goto L_0x00bb
        L_0x00a7:
            r10 = r14 & r9
            if (r10 != 0) goto L_0x00bb
            r10 = r34
            boolean r16 = r12.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r0 = r0 | r16
            goto L_0x00bd
        L_0x00bb:
            r10 = r34
        L_0x00bd:
            r16 = r15 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00ca
            r18 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r18
            r9 = r35
            goto L_0x00dd
        L_0x00ca:
            r18 = r14 & r17
            r9 = r35
            if (r18 != 0) goto L_0x00dd
            boolean r18 = r12.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x00d9
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r0 = r0 | r18
        L_0x00dd:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x00f9
            r6 = r15 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x00f2
            r6 = r36
            boolean r19 = r12.changed((long) r6)
            if (r19 == 0) goto L_0x00f4
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f6
        L_0x00f2:
            r6 = r36
        L_0x00f4:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f6:
            r0 = r0 | r19
            goto L_0x00fb
        L_0x00f9:
            r6 = r36
        L_0x00fb:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x0114
            r2 = r15 & 256(0x100, float:3.59E-43)
            r6 = r38
            if (r2 != 0) goto L_0x0110
            boolean r2 = r12.changed((long) r6)
            if (r2 == 0) goto L_0x0110
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x0110:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r0 = r0 | r2
            goto L_0x0116
        L_0x0114:
            r6 = r38
        L_0x0116:
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r0
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r4) goto L_0x013b
            boolean r2 = r12.getSkipping()
            if (r2 != 0) goto L_0x0126
            goto L_0x013b
        L_0x0126:
            r12.skipToGroupEnd()
            r3 = r31
            r4 = r32
            r5 = r33
            r17 = r12
            r27 = r6
            r7 = r9
            r8 = r36
            r6 = r10
            r10 = r27
            goto L_0x0261
        L_0x013b:
            r12.startDefaults()
            r2 = r14 & 1
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r20 = 0
            if (r2 == 0) goto L_0x016e
            boolean r2 = r12.getDefaultsInvalid()
            if (r2 == 0) goto L_0x014e
            goto L_0x016e
        L_0x014e:
            r12.skipToGroupEnd()
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0157
            r0 = r0 & r19
        L_0x0157:
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x015f
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x015f:
            r19 = r31
            r21 = r32
            r23 = r36
            r25 = r6
            r22 = r9
            r9 = r10
            r10 = r33
            goto L_0x01f4
        L_0x016e:
            if (r1 == 0) goto L_0x0173
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0175
        L_0x0173:
            r1 = r31
        L_0x0175:
            if (r3 == 0) goto L_0x0179
            r2 = 1
            goto L_0x017b
        L_0x0179:
            r2 = r32
        L_0x017b:
            if (r5 == 0) goto L_0x0180
            r3 = r20
            goto L_0x0182
        L_0x0180:
            r3 = r33
        L_0x0182:
            if (r8 == 0) goto L_0x0186
            r10 = r20
        L_0x0186:
            if (r16 == 0) goto L_0x01a7
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r5)
            java.lang.Object r5 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x01a1
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r5)
        L_0x01a1:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            goto L_0x01a8
        L_0x01a7:
            r5 = r9
        L_0x01a8:
            r8 = r15 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01bd
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r8 = r12.consume(r8)
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r8 = r8.m2929unboximpl()
            r0 = r0 & r19
            goto L_0x01bf
        L_0x01bd:
            r8 = r36
        L_0x01bf:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x01e8
            androidx.compose.material.ContentAlpha r4 = androidx.compose.material.ContentAlpha.INSTANCE
            r6 = 6
            float r4 = r4.getMedium(r12, r6)
            r6 = 0
            r7 = 0
            r19 = 0
            r22 = 14
            r23 = 0
            r31 = r8
            r33 = r4
            r34 = r6
            r35 = r7
            r36 = r19
            r37 = r22
            r38 = r23
            long r6 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r31, r33, r34, r35, r36, r37, r38)
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r4
        L_0x01e8:
            r19 = r1
            r21 = r2
            r22 = r5
            r25 = r6
            r23 = r8
            r9 = r10
            r10 = r3
        L_0x01f4:
            r12.endDefaults()
            if (r10 == 0) goto L_0x0207
            androidx.compose.material.TabKt$Tab$styledText$1$1 r1 = new androidx.compose.material.TabKt$Tab$styledText$1$1
            r1.<init>(r10, r0)
            r2 = -1729014781(0xffffffff98f15403, float:-6.238187E-24)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r20 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r2, r3, r1)
            goto L_0x0208
        L_0x0207:
            r3 = 1
        L_0x0208:
            r1 = r20
            androidx.compose.material.TabKt$Tab$2 r2 = new androidx.compose.material.TabKt$Tab$2
            r2.<init>(r1, r9, r0)
            r1 = -178151495(0xfffffffff5619fb9, float:-2.860123E32)
            androidx.compose.runtime.internal.ComposableLambda r16 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r1, r3, r2)
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r0 & 14
            r1 = r1 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 6
            int r0 = r0 >> r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r0
            r1 = r1 | r2
            r0 = r0 & r17
            r17 = r1 | r0
            r18 = 0
            r0 = r29
            r1 = r30
            r2 = r19
            r3 = r21
            r4 = r22
            r5 = r23
            r7 = r25
            r20 = r9
            r9 = r16
            r16 = r10
            r10 = r12
            r11 = r17
            r17 = r12
            r12 = r18
            m1409TabEVJuX4I(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            r5 = r16
            r3 = r19
            r6 = r20
            r4 = r21
            r7 = r22
            r8 = r23
            r10 = r25
        L_0x0261:
            androidx.compose.runtime.ScopeUpdateScope r12 = r17.endRestartGroup()
            if (r12 != 0) goto L_0x0268
            goto L_0x027c
        L_0x0268:
            androidx.compose.material.TabKt$Tab$3 r2 = new androidx.compose.material.TabKt$Tab$3
            r0 = r2
            r1 = r29
            r14 = r2
            r2 = r30
            r13 = r12
            r12 = r41
            r15 = r13
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r15.updateScope(r14)
        L_0x027c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1408Tab0nDMI0(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010d  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Tab-EVJuX4I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1409TabEVJuX4I(boolean r27, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, boolean r30, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r31, long r32, long r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r9 = r28
            r10 = r36
            r11 = r38
            r12 = r39
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 713679175(0x2a89e147, float:2.4492406E-13)
            r1 = r37
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r11 | 6
            r14 = r27
            goto L_0x0036
        L_0x0024:
            r0 = r11 & 14
            r14 = r27
            if (r0 != 0) goto L_0x0035
            boolean r0 = r13.changed((boolean) r14)
            if (r0 == 0) goto L_0x0032
            r0 = 4
            goto L_0x0033
        L_0x0032:
            r0 = 2
        L_0x0033:
            r0 = r0 | r11
            goto L_0x0036
        L_0x0035:
            r0 = r11
        L_0x0036:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x003d
            r0 = r0 | 48
            goto L_0x004d
        L_0x003d:
            r1 = r11 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004d
            boolean r1 = r13.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x004a
            r1 = 32
            goto L_0x004c
        L_0x004a:
            r1 = 16
        L_0x004c:
            r0 = r0 | r1
        L_0x004d:
            r1 = r12 & 4
            if (r1 == 0) goto L_0x0054
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0067
            r2 = r29
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0063
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r3
            goto L_0x0069
        L_0x0067:
            r2 = r29
        L_0x0069:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0083
            r4 = r30
            boolean r5 = r13.changed((boolean) r4)
            if (r5 == 0) goto L_0x007f
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r5
            goto L_0x0085
        L_0x0083:
            r4 = r30
        L_0x0085:
            r5 = r12 & 16
            if (r5 == 0) goto L_0x008c
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008c:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x00a1
            r6 = r31
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x009d
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r7
            goto L_0x00a3
        L_0x00a1:
            r6 = r31
        L_0x00a3:
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00bd
            r7 = r12 & 32
            if (r7 != 0) goto L_0x00b7
            r7 = r32
            boolean r15 = r13.changed((long) r7)
            if (r15 == 0) goto L_0x00b9
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b7:
            r7 = r32
        L_0x00b9:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r0 = r0 | r15
            goto L_0x00bf
        L_0x00bd:
            r7 = r32
        L_0x00bf:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00d7
            r15 = r12 & 64
            r6 = r34
            if (r15 != 0) goto L_0x00d3
            boolean r8 = r13.changed((long) r6)
            if (r8 == 0) goto L_0x00d3
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r0 = r0 | r8
            goto L_0x00d9
        L_0x00d7:
            r6 = r34
        L_0x00d9:
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00e1
            r8 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00df:
            r0 = r0 | r8
            goto L_0x00f2
        L_0x00e1:
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00f2
            boolean r8 = r13.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x00ef
            r8 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00df
        L_0x00ef:
            r8 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00df
        L_0x00f2:
            r8 = 23967451(0x16db6db, float:4.3661218E-38)
            r8 = r8 & r0
            r15 = 4793490(0x492492, float:6.71711E-39)
            if (r8 != r15) goto L_0x010d
            boolean r8 = r13.getSkipping()
            if (r8 != 0) goto L_0x0102
            goto L_0x010d
        L_0x0102:
            r13.skipToGroupEnd()
            r5 = r31
            r3 = r2
            r8 = r6
            r6 = r32
            goto L_0x020f
        L_0x010d:
            r13.startDefaults()
            r8 = r11 & 1
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r15 = 1
            if (r8 == 0) goto L_0x013e
            boolean r8 = r13.getDefaultsInvalid()
            if (r8 == 0) goto L_0x011f
            goto L_0x013e
        L_0x011f:
            r13.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0128
            r0 = r0 & r16
        L_0x0128:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0130
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r1
        L_0x0130:
            r18 = r31
            r19 = r32
            r23 = r0
            r16 = r2
            r17 = r4
            r21 = r6
            goto L_0x01b3
        L_0x013e:
            if (r1 == 0) goto L_0x0143
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0144
        L_0x0143:
            r1 = r2
        L_0x0144:
            if (r3 == 0) goto L_0x0147
            r4 = r15
        L_0x0147:
            if (r5 == 0) goto L_0x0168
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r2)
            java.lang.Object r2 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0162
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r13.updateRememberedValue(r2)
        L_0x0162:
            r13.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x016a
        L_0x0168:
            r2 = r31
        L_0x016a:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x017f
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r17 = r3.m2929unboximpl()
            r0 = r0 & r16
            goto L_0x0181
        L_0x017f:
            r17 = r32
        L_0x0181:
            r3 = r12 & 64
            if (r3 == 0) goto L_0x01a7
            androidx.compose.material.ContentAlpha r3 = androidx.compose.material.ContentAlpha.INSTANCE
            r5 = 6
            float r21 = r3.getMedium(r13, r5)
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 14
            r26 = 0
            r19 = r17
            long r5 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r19, r21, r22, r23, r24, r25, r26)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r3
            r23 = r0
            r16 = r1
            r21 = r5
            goto L_0x01af
        L_0x01a7:
            r23 = r0
            r16 = r1
            r21 = r6
            r19 = r17
        L_0x01af:
            r18 = r2
            r17 = r4
        L_0x01b3:
            r13.endDefaults()
            r0 = 1
            r1 = 0
            int r2 = r23 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r3 = 6
            r2 = r2 | r3
            r3 = 2
            r29 = r0
            r30 = r1
            r31 = r19
            r33 = r13
            r34 = r2
            r35 = r3
            androidx.compose.foundation.Indication r4 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r29, r30, r31, r33, r34, r35)
            androidx.compose.material.TabKt$Tab$5 r8 = new androidx.compose.material.TabKt$Tab$5
            r0 = r8
            r1 = r16
            r2 = r27
            r3 = r18
            r5 = r17
            r6 = r28
            r7 = r36
            r9 = r8
            r8 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = -1237246709(0xffffffffb6411d0b, float:-2.8776146E-6)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r15, r9)
            int r0 = r23 >> 15
            r1 = r0 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 6
            int r1 = r23 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r8 = r0 | r1
            r1 = r19
            r3 = r21
            r5 = r27
            r7 = r13
            m1410TabTransitionKlgxPg(r1, r3, r5, r6, r7, r8)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r8 = r21
        L_0x020f:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0216
            goto L_0x0229
        L_0x0216:
            androidx.compose.material.TabKt$Tab$6 r15 = new androidx.compose.material.TabKt$Tab$6
            r0 = r15
            r1 = r27
            r2 = r28
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12)
            r13.updateScope(r15)
        L_0x0229:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1409TabEVJuX4I(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(1249848471);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if ((i15 & 112) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            TabKt$TabBaselineLayout$2 tabKt$TabBaselineLayout$2 = new TabKt$TabBaselineLayout$2(function23, function24);
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
            Updater.m2543setimpl(r13, tabKt$TabBaselineLayout$2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r13, density, companion2.getSetDensity());
            Updater.m2543setimpl(r13, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r13, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1142473408);
            startRestartGroup.startReplaceableGroup(-2141028452);
            if (function23 != null) {
                Modifier r52 = PaddingKt.m488paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), HorizontalTextPadding, 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r52);
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
                Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r72, density2, companion2.getSetDensity());
                Updater.m2543setimpl(r72, layoutDirection2, companion2.getSetLayoutDirection());
                Updater.m2543setimpl(r72, viewConfiguration2, companion2.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-459869377);
                function23.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(companion, "icon");
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(layoutId);
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
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(892169960);
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
            endRestartGroup.updateScope(new TabKt$TabBaselineLayout$3(function23, function24, i15));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    @androidx.compose.runtime.Composable
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1410TabTransitionKlgxPg(long r18, long r20, boolean r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r6 = r23
            r7 = r25
            r0 = -405571117(0xffffffffe7d379d3, float:-1.9973332E24)
            r1 = r24
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r7 & 14
            r2 = 2
            r3 = r18
            if (r1 != 0) goto L_0x001f
            boolean r1 = r0.changed((long) r3)
            if (r1 == 0) goto L_0x001c
            r1 = 4
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            r1 = r1 | r7
            goto L_0x0020
        L_0x001f:
            r1 = r7
        L_0x0020:
            r5 = r7 & 112(0x70, float:1.57E-43)
            r14 = r20
            if (r5 != 0) goto L_0x0032
            boolean r5 = r0.changed((long) r14)
            if (r5 == 0) goto L_0x002f
            r5 = 32
            goto L_0x0031
        L_0x002f:
            r5 = 16
        L_0x0031:
            r1 = r1 | r5
        L_0x0032:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0045
            r5 = r22
            boolean r8 = r0.changed((boolean) r5)
            if (r8 == 0) goto L_0x0041
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0043
        L_0x0041:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0043:
            r1 = r1 | r8
            goto L_0x0047
        L_0x0045:
            r5 = r22
        L_0x0047:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0057
            boolean r8 = r0.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0054
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0056
        L_0x0054:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0056:
            r1 = r1 | r8
        L_0x0057:
            r8 = r1 & 5851(0x16db, float:8.199E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r8 != r9) goto L_0x0069
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0064
            goto L_0x0069
        L_0x0064:
            r0.skipToGroupEnd()
            goto L_0x0165
        L_0x0069:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r22)
            int r1 = r1 >> 6
            r9 = r1 & 14
            r10 = 0
            androidx.compose.animation.core.Transition r8 = androidx.compose.animation.core.TransitionKt.updateTransition(r8, (java.lang.String) r10, (androidx.compose.runtime.Composer) r0, (int) r9, (int) r2)
            androidx.compose.material.TabKt$TabTransition$color$2 r9 = androidx.compose.material.TabKt$TabTransition$color$2.INSTANCE
            r10 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r0.startReplaceableGroup(r10)
            java.lang.String r13 = "ColorAnimation"
            java.lang.Object r10 = r8.getTargetState()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r11 = 1445938070(0x562f4396, float:4.8176204E13)
            r0.startReplaceableGroup(r11)
            if (r10 == 0) goto L_0x0095
            r16 = r3
            goto L_0x0097
        L_0x0095:
            r16 = r14
        L_0x0097:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r10 = androidx.compose.ui.graphics.Color.m2923getColorSpaceimpl(r16)
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r12)
            boolean r12 = r0.changed((java.lang.Object) r10)
            java.lang.Object r2 = r0.rememberedValue()
            if (r12 != 0) goto L_0x00b6
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r2 != r12) goto L_0x00c5
        L_0x00b6:
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r2 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r2)
            java.lang.Object r2 = r2.invoke(r10)
            androidx.compose.animation.core.TwoWayConverter r2 = (androidx.compose.animation.core.TwoWayConverter) r2
            r0.updateRememberedValue(r2)
        L_0x00c5:
            r0.endReplaceableGroup()
            r12 = r2
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r2)
            java.lang.Object r2 = r8.getCurrentState()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r0.startReplaceableGroup(r11)
            if (r2 == 0) goto L_0x00e3
            r16 = r3
            goto L_0x00e5
        L_0x00e3:
            r16 = r14
        L_0x00e5:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m2909boximpl(r16)
            java.lang.Object r10 = r8.getTargetState()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r0.startReplaceableGroup(r11)
            if (r10 == 0) goto L_0x00fd
            r10 = r3
            goto L_0x00fe
        L_0x00fd:
            r10 = r14
        L_0x00fe:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r10 = androidx.compose.ui.graphics.Color.m2909boximpl(r10)
            androidx.compose.animation.core.Transition$Segment r11 = r8.getSegment()
            r16 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            java.lang.Object r3 = r9.invoke(r11, r0, r3)
            r11 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r11 = (androidx.compose.animation.core.FiniteAnimationSpec) r11
            r3 = 32768(0x8000, float:4.5918E-41)
            r9 = r2
            r14 = r0
            r15 = r3
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r8, r9, r10, r11, r12, r13, r14, r15)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = 2
            androidx.compose.runtime.ProvidedValue[] r3 = new androidx.compose.runtime.ProvidedValue[r3]
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            long r8 = m1411TabTransition_Klgx_Pg$lambda5(r2)
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            long r8 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r8, r10, r11, r12, r13, r14, r15)
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m2909boximpl(r8)
            androidx.compose.runtime.ProvidedValue r4 = r4.provides(r8)
            r3[r16] = r4
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            long r8 = m1411TabTransition_Klgx_Pg$lambda5(r2)
            float r2 = androidx.compose.ui.graphics.Color.m2921getAlphaimpl(r8)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.ProvidedValue r2 = r4.provides(r2)
            r4 = 1
            r3[r4] = r2
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (androidx.compose.runtime.Composer) r0, (int) r1)
        L_0x0165:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x016c
            goto L_0x017f
        L_0x016c:
            androidx.compose.material.TabKt$TabTransition$1 r9 = new androidx.compose.material.TabKt$TabTransition$1
            r0 = r9
            r1 = r18
            r3 = r20
            r5 = r22
            r6 = r23
            r7 = r25
            r0.<init>(r1, r3, r5, r6, r7)
            r8.updateScope(r9)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1410TabTransitionKlgxPg(long, long, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: TabTransition_Klgx_Pg$lambda-5  reason: not valid java name */
    private static final long m1411TabTransition_Klgx_Pg$lambda5(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i11, int i12, int i13, int i14) {
        float f11;
        Density density2 = density;
        int i15 = i13;
        int i16 = i14;
        if (i15 == i16) {
            f11 = SingleLineTextBaselineWithIcon;
        } else {
            f11 = DoubleLineTextBaselineWithIcon;
        }
        int r32 = density.m5441roundToPx0680j_4(f11) + density.m5441roundToPx0680j_4(TabRowDefaults.INSTANCE.m1420getIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.m5440roundToPxR2X_6o(IconDistanceFromBaseline)) - i15;
        int i17 = (i12 - i16) - r32;
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, (i11 - placeable.getWidth()) / 2, i17, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, (i11 - placeable2.getWidth()) / 2, i17 - height, 0.0f, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i11) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i11 - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
    }
}
