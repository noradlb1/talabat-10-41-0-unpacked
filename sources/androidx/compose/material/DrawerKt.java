package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a3\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010#\u001a\u00020\u0014H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a\u0001\u0010&\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020'2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001aA\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010!\u001a\u00020\u0019H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a \u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0002\u001a+\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u00108\u001a+\u00109\u001a\u00020'2\u0006\u00105\u001a\u00020:2\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u0010;\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float BottomDrawerOpenFraction = 0.5f;
    /* access modifiers changed from: private */
    public static final float DrawerVelocityThreshold = Dp.m5478constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float EndDrawerPadding = Dp.m5478constructorimpl((float) 56);

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011a  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* renamed from: BottomDrawer-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1225BottomDrawerGs3lGvM(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r35, @org.jetbrains.annotations.Nullable androidx.compose.material.BottomDrawerState r36, boolean r37, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r38, float r39, long r40, long r42, long r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r15 = r34
            r14 = r46
            r13 = r48
            r12 = r49
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 625649286(0x254aa686, float:1.7577127E-16)
            r1 = r47
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r13
            goto L_0x0032
        L_0x0031:
            r0 = r13
        L_0x0032:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004c
            r3 = r35
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r0 = r0 | r4
            goto L_0x004e
        L_0x004c:
            r3 = r35
        L_0x004e:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0067
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0061
            r4 = r36
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0063
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0061:
            r4 = r36
        L_0x0063:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r5
            goto L_0x0069
        L_0x0067:
            r4 = r36
        L_0x0069:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0083
            r6 = r37
            boolean r7 = r10.changed((boolean) r6)
            if (r7 == 0) goto L_0x007f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r7
            goto L_0x0085
        L_0x0083:
            r6 = r37
        L_0x0085:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a0
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009a
            r7 = r38
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009c
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009a:
            r7 = r38
        L_0x009c:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r0 = r0 | r8
            goto L_0x00a2
        L_0x00a0:
            r7 = r38
        L_0x00a2:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x00aa
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00be
        L_0x00aa:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00be
            r9 = r39
            boolean r11 = r10.changed((float) r9)
            if (r11 == 0) goto L_0x00ba
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r0 = r0 | r11
            goto L_0x00c0
        L_0x00be:
            r9 = r39
        L_0x00c0:
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x00dd
            r11 = r12 & 64
            if (r11 != 0) goto L_0x00d5
            r11 = r2
            r1 = r40
            boolean r16 = r10.changed((long) r1)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d5:
            r11 = r2
            r1 = r40
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r16
            goto L_0x00e0
        L_0x00dd:
            r11 = r2
            r1 = r40
        L_0x00e0:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00fc
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00f5
            r1 = r42
            boolean r16 = r10.changed((long) r1)
            if (r16 == 0) goto L_0x00f7
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f5:
            r1 = r42
        L_0x00f7:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r0 = r0 | r16
            goto L_0x00fe
        L_0x00fc:
            r1 = r42
        L_0x00fe:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x011a
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0113
            r1 = r44
            boolean r16 = r10.changed((long) r1)
            if (r16 == 0) goto L_0x0115
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0113:
            r1 = r44
        L_0x0115:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r0 = r0 | r16
            goto L_0x011c
        L_0x011a:
            r1 = r44
        L_0x011c:
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0124
            r1 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0122:
            r0 = r0 | r1
            goto L_0x0135
        L_0x0124:
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x0135
            boolean r1 = r10.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0132
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0122
        L_0x0132:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0122
        L_0x0135:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0156
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x0145
            goto L_0x0156
        L_0x0145:
            r10.skipToGroupEnd()
            r11 = r44
            r2 = r3
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r1 = r10
            r7 = r40
            r9 = r42
            goto L_0x02ba
        L_0x0156:
            r10.startDefaults()
            r1 = r13 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x01a2
            boolean r1 = r10.getDefaultsInvalid()
            if (r1 == 0) goto L_0x016d
            goto L_0x01a2
        L_0x016d:
            r10.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x0176
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0176:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x017c
            r0 = r0 & r18
        L_0x017c:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0182
            r0 = r0 & r17
        L_0x0182:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0188
            r0 = r0 & r16
        L_0x0188:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0190
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0190:
            r21 = r40
            r23 = r42
            r25 = r44
            r11 = r3
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r9
            r4 = r0
            goto L_0x022b
        L_0x01a2:
            if (r11 == 0) goto L_0x01a7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x01a8
        L_0x01a7:
            r1 = r3
        L_0x01a8:
            r3 = r12 & 4
            r11 = 6
            if (r3 == 0) goto L_0x01b8
            androidx.compose.material.BottomDrawerValue r3 = androidx.compose.material.BottomDrawerValue.Closed
            r2 = 2
            r4 = 0
            androidx.compose.material.BottomDrawerState r2 = rememberBottomDrawerState(r3, r4, r10, r11, r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01b9
        L_0x01b8:
            r2 = r4
        L_0x01b9:
            if (r5 == 0) goto L_0x01bc
            r6 = 1
        L_0x01bc:
            r3 = r12 & 16
            if (r3 == 0) goto L_0x01cd
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r3 = r3.getShapes(r10, r11)
            androidx.compose.foundation.shape.CornerBasedShape r3 = r3.getLarge()
            r0 = r0 & r18
            goto L_0x01ce
        L_0x01cd:
            r3 = r7
        L_0x01ce:
            if (r8 == 0) goto L_0x01d7
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r4 = r4.m1224getElevationD9Ej5fM()
            goto L_0x01d8
        L_0x01d7:
            r4 = r9
        L_0x01d8:
            r5 = r12 & 64
            if (r5 == 0) goto L_0x01e9
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r10, r11)
            long r7 = r5.m1183getSurface0d7_KjU()
            r0 = r0 & r17
            goto L_0x01eb
        L_0x01e9:
            r7 = r40
        L_0x01eb:
            r5 = r12 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x01fa
            int r5 = r0 >> 18
            r5 = r5 & 14
            long r17 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r7, r10, r5)
            r0 = r0 & r16
            goto L_0x01fc
        L_0x01fa:
            r17 = r42
        L_0x01fc:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x021b
            androidx.compose.material.DrawerDefaults r5 = androidx.compose.material.DrawerDefaults.INSTANCE
            long r21 = r5.getScrimColor(r10, r11)
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r5
            r11 = r1
            r16 = r2
            r19 = r4
            r23 = r17
            r25 = r21
            r4 = r0
            r18 = r3
            r17 = r6
            r21 = r7
            goto L_0x022b
        L_0x021b:
            r25 = r44
            r11 = r1
            r16 = r2
            r19 = r4
            r21 = r7
            r23 = r17
            r4 = r0
            r18 = r3
            r17 = r6
        L_0x022b:
            r10.endDefaults()
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0255
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r10.updateRememberedValue(r1)
            r0 = r1
        L_0x0255:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r27 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r0 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r11, r0, r2, r1)
            r28 = 0
            r29 = 0
            androidx.compose.material.DrawerKt$BottomDrawer$1 r8 = new androidx.compose.material.DrawerKt$BottomDrawer$1
            r0 = r8
            r1 = r17
            r9 = r2
            r2 = r16
            r3 = r46
            r5 = r25
            r7 = r18
            r15 = r8
            r8 = r21
            r30 = r10
            r31 = r11
            r10 = r23
            r12 = r19
            r13 = r27
            r14 = r34
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r10, r12, r13, r14)
            r0 = 1220102512(0x48b94970, float:379467.5)
            r1 = r30
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r2, r15)
            r2 = 3072(0xc00, float:4.305E-42)
            r3 = 6
            r35 = r20
            r36 = r28
            r37 = r29
            r38 = r0
            r39 = r1
            r40 = r2
            r41 = r3
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r35, r36, r37, r38, r39, r40, r41)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r21
            r9 = r23
            r11 = r25
            r2 = r31
        L_0x02ba:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x02c1
            goto L_0x02da
        L_0x02c1:
            androidx.compose.material.DrawerKt$BottomDrawer$2 r14 = new androidx.compose.material.DrawerKt$BottomDrawer$2
            r0 = r14
            r1 = r34
            r13 = r46
            r32 = r14
            r14 = r48
            r33 = r15
            r15 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r1 = r32
            r0 = r33
            r0.updateScope(r1)
        L_0x02da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1225BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: BottomDrawerScrim-3J-VO9M  reason: not valid java name */
    public static final void m1226BottomDrawerScrim3JVO9M(long j11, Function0<Unit> function0, boolean z11, Composer composer, int i11) {
        int i12;
        boolean z12;
        float f11;
        Modifier modifier;
        int i13;
        int i14;
        int i15;
        long j12 = j11;
        Function0<Unit> function02 = function0;
        boolean z13 = z11;
        int i16 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-513067266);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed(j12)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(z13)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if ((i12 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (j12 != Color.Companion.m2955getUnspecified0d7_KjU()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (z13) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.0f;
                }
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 0, 12);
                String r72 = Strings_androidKt.m1382getString4foXLRw(Strings.Companion.m1375getCloseDrawerUdPEhr4(), startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1298949409);
                if (z13) {
                    Modifier.Companion companion = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed((Object) function02);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function02, (Continuation<? super DrawerKt$BottomDrawerScrim$dismissModifier$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion, (Object) function02, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                    startRestartGroup.startReplaceableGroup(511388516);
                    boolean changed2 = startRestartGroup.changed((Object) r72) | startRestartGroup.changed((Object) function02);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new DrawerKt$BottomDrawerScrim$dismissModifier$2$1(r72, function02);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                Color r92 = Color.m2909boximpl(j11);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed3 = startRestartGroup.changed((Object) r92) | startRestartGroup.changed((Object) animateFloatAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new DrawerKt$BottomDrawerScrim$1$1(j12, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DrawerKt$BottomDrawerScrim$2(j11, function0, z11, i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim_3J_VO9M$lambda-0  reason: not valid java name */
    public static final float m1227BottomDrawerScrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011a  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: ModalDrawer-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1228ModalDrawerGs3lGvM(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r36, @org.jetbrains.annotations.Nullable androidx.compose.material.DrawerState r37, boolean r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r39, float r40, long r41, long r43, long r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r15 = r35
            r14 = r47
            r13 = r49
            r12 = r50
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1305806945(0x4dd50861, float:4.46762016E8)
            r1 = r48
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r13
            goto L_0x0032
        L_0x0031:
            r0 = r13
        L_0x0032:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004c
            r3 = r36
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r0 = r0 | r4
            goto L_0x004e
        L_0x004c:
            r3 = r36
        L_0x004e:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0067
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0061
            r4 = r37
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0063
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0061:
            r4 = r37
        L_0x0063:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r5
            goto L_0x0069
        L_0x0067:
            r4 = r37
        L_0x0069:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0083
            r6 = r38
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x007f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r7
            goto L_0x0085
        L_0x0083:
            r6 = r38
        L_0x0085:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a0
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009a
            r7 = r39
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009c
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009a:
            r7 = r39
        L_0x009c:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r0 = r0 | r8
            goto L_0x00a2
        L_0x00a0:
            r7 = r39
        L_0x00a2:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x00aa
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00be
        L_0x00aa:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00be
            r9 = r40
            boolean r10 = r11.changed((float) r9)
            if (r10 == 0) goto L_0x00ba
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r0 = r0 | r10
            goto L_0x00c0
        L_0x00be:
            r9 = r40
        L_0x00c0:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00dd
            r10 = r12 & 64
            if (r10 != 0) goto L_0x00d5
            r10 = r2
            r1 = r41
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d5:
            r10 = r2
            r1 = r41
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r16
            goto L_0x00e0
        L_0x00dd:
            r10 = r2
            r1 = r41
        L_0x00e0:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00fc
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00f5
            r1 = r43
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00f7
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f5:
            r1 = r43
        L_0x00f7:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r0 = r0 | r16
            goto L_0x00fe
        L_0x00fc:
            r1 = r43
        L_0x00fe:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x011a
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0113
            r1 = r45
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x0115
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0113:
            r1 = r45
        L_0x0115:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r0 = r0 | r16
            goto L_0x011c
        L_0x011a:
            r1 = r45
        L_0x011c:
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0124
            r1 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0122:
            r0 = r0 | r1
            goto L_0x0135
        L_0x0124:
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x0135
            boolean r1 = r11.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0132
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0122
        L_0x0132:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0122
        L_0x0135:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x0156
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0145
            goto L_0x0156
        L_0x0145:
            r11.skipToGroupEnd()
            r2 = r3
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r1 = r11
            r7 = r41
            r9 = r43
            r11 = r45
            goto L_0x02b5
        L_0x0156:
            r11.startDefaults()
            r1 = r13 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x01a2
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x016d
            goto L_0x01a2
        L_0x016d:
            r11.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x0176
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0176:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x017c
            r0 = r0 & r18
        L_0x017c:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0182
            r0 = r0 & r17
        L_0x0182:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0188
            r0 = r0 & r16
        L_0x0188:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0190
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0190:
            r21 = r41
            r23 = r43
            r25 = r45
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r9
            r9 = r3
        L_0x019f:
            r3 = r0
            goto L_0x0227
        L_0x01a2:
            if (r10 == 0) goto L_0x01a7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x01a8
        L_0x01a7:
            r1 = r3
        L_0x01a8:
            r3 = r12 & 4
            r10 = 6
            if (r3 == 0) goto L_0x01b8
            androidx.compose.material.DrawerValue r3 = androidx.compose.material.DrawerValue.Closed
            r2 = 2
            r4 = 0
            androidx.compose.material.DrawerState r2 = rememberDrawerState(r3, r4, r11, r10, r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01b9
        L_0x01b8:
            r2 = r4
        L_0x01b9:
            if (r5 == 0) goto L_0x01bc
            r6 = 1
        L_0x01bc:
            r3 = r12 & 16
            if (r3 == 0) goto L_0x01cd
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r3 = r3.getShapes(r11, r10)
            androidx.compose.foundation.shape.CornerBasedShape r3 = r3.getLarge()
            r0 = r0 & r18
            goto L_0x01ce
        L_0x01cd:
            r3 = r7
        L_0x01ce:
            if (r8 == 0) goto L_0x01d7
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r4 = r4.m1224getElevationD9Ej5fM()
            goto L_0x01d8
        L_0x01d7:
            r4 = r9
        L_0x01d8:
            r5 = r12 & 64
            if (r5 == 0) goto L_0x01e9
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r11, r10)
            long r7 = r5.m1183getSurface0d7_KjU()
            r0 = r0 & r17
            goto L_0x01eb
        L_0x01e9:
            r7 = r41
        L_0x01eb:
            r5 = r12 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x01fa
            int r5 = r0 >> 18
            r5 = r5 & 14
            long r17 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r7, r11, r5)
            r0 = r0 & r16
            goto L_0x01fc
        L_0x01fa:
            r17 = r43
        L_0x01fc:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0216
            androidx.compose.material.DrawerDefaults r5 = androidx.compose.material.DrawerDefaults.INSTANCE
            long r9 = r5.getScrimColor(r11, r10)
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r5
            r16 = r2
            r19 = r4
            r21 = r7
            r25 = r9
            r23 = r17
            r9 = r1
            goto L_0x0221
        L_0x0216:
            r25 = r45
            r9 = r1
            r16 = r2
            r19 = r4
            r21 = r7
            r23 = r17
        L_0x0221:
            r18 = r3
            r17 = r6
            goto L_0x019f
        L_0x0227:
            r11.endDefaults()
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0251
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r11)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r11.updateRememberedValue(r1)
            r0 = r1
        L_0x0251:
            r11.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r27 = r0.getCoroutineScope()
            r11.endReplaceableGroup()
            r0 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r20 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r9, r0, r2, r1)
            r28 = 0
            r29 = 0
            androidx.compose.material.DrawerKt$ModalDrawer$1 r10 = new androidx.compose.material.DrawerKt$ModalDrawer$1
            r0 = r10
            r1 = r16
            r7 = r2
            r2 = r17
            r4 = r25
            r6 = r18
            r15 = r7
            r7 = r21
            r30 = r9
            r31 = r10
            r9 = r23
            r32 = r11
            r11 = r19
            r12 = r47
            r13 = r27
            r14 = r35
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14)
            r0 = 816674999(0x30ad78b7, float:1.2621716E-9)
            r2 = r31
            r1 = r32
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r15, r2)
            r2 = 3072(0xc00, float:4.305E-42)
            r3 = 6
            r36 = r20
            r37 = r28
            r38 = r29
            r39 = r0
            r40 = r1
            r41 = r2
            r42 = r3
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r36, r37, r38, r39, r40, r41, r42)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r11 = r25
            r2 = r30
        L_0x02b5:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x02bc
            goto L_0x02d5
        L_0x02bc:
            androidx.compose.material.DrawerKt$ModalDrawer$2 r14 = new androidx.compose.material.DrawerKt$ModalDrawer$2
            r0 = r14
            r1 = r35
            r13 = r47
            r33 = r14
            r14 = r49
            r34 = r15
            r15 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r1 = r33
            r0 = r34
            r0.updateScope(r1)
        L_0x02d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1228ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    public static final void m1229ScrimBx497Mc(boolean z11, Function0<Unit> function0, Function0<Float> function02, long j11, Composer composer, int i11) {
        int i12;
        Modifier modifier;
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1983403750);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed(j11)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if ((i12 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            String r02 = Strings_androidKt.m1382getString4foXLRw(Strings.Companion.m1375getCloseDrawerUdPEhr4(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1010554047);
            if (z11) {
                Modifier.Companion companion = Modifier.Companion;
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed = startRestartGroup.changed((Object) function0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, (Continuation<? super DrawerKt$Scrim$dismissDrawer$1$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed2 = startRestartGroup.changed((Object) r02) | startRestartGroup.changed((Object) function0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new DrawerKt$Scrim$dismissDrawer$2$1(r02, function0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
            } else {
                modifier = Modifier.Companion;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
            Color r22 = Color.m2909boximpl(j11);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed3 = startRestartGroup.changed((Object) r22) | startRestartGroup.changed((Object) function02);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new DrawerKt$Scrim$1$1(j11, function02);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DrawerKt$Scrim$2(z11, function0, function02, j11, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float f11, float f12, float f13) {
        return RangesKt___RangesKt.coerceIn((f13 - f11) / (f12 - f11), 0.0f, 1.0f);
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final BottomDrawerState rememberBottomDrawerState(@NotNull BottomDrawerValue bottomDrawerValue, @Nullable Function1<? super BottomDrawerValue, Boolean> function1, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bottomDrawerValue, "initialValue");
        composer.startReplaceableGroup(-598115156);
        Function1 function12 = function1;
        if ((i12 & 2) != 0) {
            function12 = DrawerKt$rememberBottomDrawerState$1.INSTANCE;
        }
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.rememberSaveable(new Object[0], BottomDrawerState.Companion.Saver(function12), (String) null, new DrawerKt$rememberBottomDrawerState$2(bottomDrawerValue, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    @NotNull
    @Composable
    public static final DrawerState rememberDrawerState(@NotNull DrawerValue drawerValue, @Nullable Function1<? super DrawerValue, Boolean> function1, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(drawerValue, "initialValue");
        composer.startReplaceableGroup(-1435874229);
        Function1 function12 = function1;
        if ((i12 & 2) != 0) {
            function12 = DrawerKt$rememberDrawerState$1.INSTANCE;
        }
        DrawerState drawerState = (DrawerState) RememberSaveableKt.rememberSaveable(new Object[0], DrawerState.Companion.Saver(function12), (String) null, new DrawerKt$rememberDrawerState$2(drawerValue, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return drawerState;
    }
}
