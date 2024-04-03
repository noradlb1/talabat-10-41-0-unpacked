package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0002\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aÈ\u0001\u0010+\u001a\u00020\u00042\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2&\u0010,\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2&\u00100\u001a\"\u0012\u0013\u0012\u001101¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u000207H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a+\u0010:\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010?\u001a;\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u0002050D2\u0014\b\u0002\u0010E\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00160\u0006H\u0007¢\u0006\u0002\u0010F\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldLayout", "body", "Lkotlin/ParameterName;", "name", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "Landroidx/compose/runtime/State;", "", "sheetState", "Landroidx/compose/material/BottomSheetState;", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILandroidx/compose/runtime/State;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m5478constructorimpl((float) 16);

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0681  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:370:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0144  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* renamed from: BottomSheetScaffold-bGncdBI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1120BottomSheetScaffoldbGncdBI(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r45, @org.jetbrains.annotations.Nullable androidx.compose.material.BottomSheetScaffoldState r46, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, int r50, boolean r51, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r52, float r53, long r54, long r56, float r58, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, boolean r60, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r61, float r62, long r63, long r65, long r67, long r69, long r71, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r74, int r75, int r76, int r77, int r78) {
        /*
            r1 = r44
            r15 = r73
            r13 = r75
            r14 = r76
            r11 = r77
            r12 = r78
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 46422755(0x2c45ae3, float:2.8851778E-37)
            r2 = r74
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0026
            r2 = r13 | 6
            goto L_0x0036
        L_0x0026:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0035
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0032
            r2 = 4
            goto L_0x0033
        L_0x0032:
            r2 = 2
        L_0x0033:
            r2 = r2 | r13
            goto L_0x0036
        L_0x0035:
            r2 = r13
        L_0x0036:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x003d
            r2 = r2 | 48
            goto L_0x0050
        L_0x003d:
            r7 = r13 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0050
            r7 = r45
            boolean r9 = r0.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x004c
            r9 = 32
            goto L_0x004e
        L_0x004c:
            r9 = 16
        L_0x004e:
            r2 = r2 | r9
            goto L_0x0052
        L_0x0050:
            r7 = r45
        L_0x0052:
            r9 = r13 & 896(0x380, float:1.256E-42)
            r16 = 256(0x100, float:3.59E-43)
            if (r9 != 0) goto L_0x006e
            r9 = r12 & 4
            if (r9 != 0) goto L_0x0067
            r9 = r46
            boolean r17 = r0.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x0069
            r17 = r16
            goto L_0x006b
        L_0x0067:
            r9 = r46
        L_0x0069:
            r17 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r2 = r2 | r17
            goto L_0x0070
        L_0x006e:
            r9 = r46
        L_0x0070:
            r17 = r12 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x007b
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x008f
        L_0x007b:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008f
            r3 = r47
            boolean r20 = r0.changed((java.lang.Object) r3)
            if (r20 == 0) goto L_0x008a
            r20 = r18
            goto L_0x008c
        L_0x008a:
            r20 = r19
        L_0x008c:
            r2 = r2 | r20
            goto L_0x0091
        L_0x008f:
            r3 = r47
        L_0x0091:
            r20 = r12 & 16
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x009c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = r48
            goto L_0x00b2
        L_0x009c:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r13 & r22
            r10 = r48
            if (r22 != 0) goto L_0x00b2
            boolean r23 = r0.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00ae
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b0
        L_0x00ae:
            r23 = r21
        L_0x00b0:
            r2 = r2 | r23
        L_0x00b2:
            r23 = r12 & 32
            r24 = 131072(0x20000, float:1.83671E-40)
            if (r23 == 0) goto L_0x00bf
            r25 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r25
            r8 = r49
            goto L_0x00d4
        L_0x00bf:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r13 & r25
            r8 = r49
            if (r25 != 0) goto L_0x00d4
            boolean r26 = r0.changed((java.lang.Object) r8)
            if (r26 == 0) goto L_0x00d0
            r26 = r24
            goto L_0x00d2
        L_0x00d0:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00d2:
            r2 = r2 | r26
        L_0x00d4:
            r26 = r12 & 64
            r27 = 1048576(0x100000, float:1.469368E-39)
            r28 = 524288(0x80000, float:7.34684E-40)
            if (r26 == 0) goto L_0x00e3
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r7 = r50
            goto L_0x00f8
        L_0x00e3:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r13 & r29
            r7 = r50
            if (r29 != 0) goto L_0x00f8
            boolean r29 = r0.changed((int) r7)
            if (r29 == 0) goto L_0x00f4
            r29 = r27
            goto L_0x00f6
        L_0x00f4:
            r29 = r28
        L_0x00f6:
            r2 = r2 | r29
        L_0x00f8:
            r7 = r12 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0101
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r29
            goto L_0x0119
        L_0x0101:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0119
            r29 = r7
            r7 = r51
            boolean r30 = r0.changed((boolean) r7)
            if (r30 == 0) goto L_0x0114
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0116
        L_0x0114:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0116:
            r2 = r2 | r30
            goto L_0x011d
        L_0x0119:
            r29 = r7
            r7 = r51
        L_0x011d:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r13 & r30
            if (r30 != 0) goto L_0x0139
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0132
            r5 = r52
            boolean r31 = r0.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x0134
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0136
        L_0x0132:
            r5 = r52
        L_0x0134:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0136:
            r2 = r2 | r31
            goto L_0x013b
        L_0x0139:
            r5 = r52
        L_0x013b:
            r7 = r12 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0144
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            goto L_0x015c
        L_0x0144:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x015c
            r31 = r7
            r7 = r53
            boolean r32 = r0.changed((float) r7)
            if (r32 == 0) goto L_0x0157
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0159
        L_0x0157:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0159:
            r2 = r2 | r32
            goto L_0x0160
        L_0x015c:
            r31 = r7
            r7 = r53
        L_0x0160:
            r32 = r14 & 14
            if (r32 != 0) goto L_0x0175
            r6 = r12 & 1024(0x400, float:1.435E-42)
            r7 = r54
            if (r6 != 0) goto L_0x0172
            boolean r6 = r0.changed((long) r7)
            if (r6 == 0) goto L_0x0172
            r6 = 4
            goto L_0x0173
        L_0x0172:
            r6 = 2
        L_0x0173:
            r6 = r6 | r14
            goto L_0x0178
        L_0x0175:
            r7 = r54
            r6 = r14
        L_0x0178:
            r33 = r14 & 112(0x70, float:1.57E-43)
            if (r33 != 0) goto L_0x018f
            r1 = r12 & 2048(0x800, float:2.87E-42)
            r7 = r56
            if (r1 != 0) goto L_0x018b
            boolean r1 = r0.changed((long) r7)
            if (r1 == 0) goto L_0x018b
            r1 = 32
            goto L_0x018d
        L_0x018b:
            r1 = 16
        L_0x018d:
            r6 = r6 | r1
            goto L_0x0191
        L_0x018f:
            r7 = r56
        L_0x0191:
            r1 = r12 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0198
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x01ac
        L_0x0198:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x01ac
            r3 = r58
            boolean r33 = r0.changed((float) r3)
            if (r33 == 0) goto L_0x01a7
            r33 = r16
            goto L_0x01a9
        L_0x01a7:
            r33 = 128(0x80, float:1.794E-43)
        L_0x01a9:
            r6 = r6 | r33
            goto L_0x01ae
        L_0x01ac:
            r3 = r58
        L_0x01ae:
            r7 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01b5
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c7
        L_0x01b5:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01c7
            r8 = r59
            boolean r33 = r0.changed((java.lang.Object) r8)
            if (r33 == 0) goto L_0x01c2
            goto L_0x01c4
        L_0x01c2:
            r18 = r19
        L_0x01c4:
            r6 = r6 | r18
            goto L_0x01c9
        L_0x01c7:
            r8 = r59
        L_0x01c9:
            r18 = r7
            r7 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x01d2
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01e8
        L_0x01d2:
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x01e8
            r19 = r7
            r7 = r60
            boolean r33 = r0.changed((boolean) r7)
            if (r33 == 0) goto L_0x01e5
            r21 = 16384(0x4000, float:2.2959E-41)
        L_0x01e5:
            r6 = r6 | r21
            goto L_0x01ec
        L_0x01e8:
            r19 = r7
            r7 = r60
        L_0x01ec:
            r21 = 458752(0x70000, float:6.42848E-40)
            r21 = r14 & r21
            if (r21 != 0) goto L_0x0209
            r21 = 32768(0x8000, float:4.5918E-41)
            r21 = r12 & r21
            r7 = r61
            if (r21 != 0) goto L_0x0204
            boolean r21 = r0.changed((java.lang.Object) r7)
            if (r21 == 0) goto L_0x0204
            r21 = r24
            goto L_0x0206
        L_0x0204:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x0206:
            r6 = r6 | r21
            goto L_0x020b
        L_0x0209:
            r7 = r61
        L_0x020b:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r12 & r21
            if (r21 == 0) goto L_0x0218
            r33 = 1572864(0x180000, float:2.204052E-39)
            r6 = r6 | r33
            r7 = r62
            goto L_0x022d
        L_0x0218:
            r33 = 3670016(0x380000, float:5.142788E-39)
            r33 = r14 & r33
            r7 = r62
            if (r33 != 0) goto L_0x022d
            boolean r33 = r0.changed((float) r7)
            if (r33 == 0) goto L_0x0229
            r33 = r27
            goto L_0x022b
        L_0x0229:
            r33 = r28
        L_0x022b:
            r6 = r6 | r33
        L_0x022d:
            r33 = 29360128(0x1c00000, float:7.052966E-38)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x0247
            r33 = r12 & r24
            r7 = r63
            if (r33 != 0) goto L_0x0242
            boolean r33 = r0.changed((long) r7)
            if (r33 == 0) goto L_0x0242
            r33 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0244
        L_0x0242:
            r33 = 4194304(0x400000, float:5.877472E-39)
        L_0x0244:
            r6 = r6 | r33
            goto L_0x0249
        L_0x0247:
            r7 = r63
        L_0x0249:
            r33 = 234881024(0xe000000, float:1.5777218E-30)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x0265
            r33 = 262144(0x40000, float:3.67342E-40)
            r33 = r12 & r33
            r7 = r65
            if (r33 != 0) goto L_0x0260
            boolean r33 = r0.changed((long) r7)
            if (r33 == 0) goto L_0x0260
            r33 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0262
        L_0x0260:
            r33 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0262:
            r6 = r6 | r33
            goto L_0x0267
        L_0x0265:
            r7 = r65
        L_0x0267:
            r33 = 1879048192(0x70000000, float:1.58456325E29)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x0281
            r33 = r12 & r28
            r7 = r67
            if (r33 != 0) goto L_0x027c
            boolean r33 = r0.changed((long) r7)
            if (r33 == 0) goto L_0x027c
            r33 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x027e
        L_0x027c:
            r33 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x027e:
            r6 = r6 | r33
            goto L_0x0283
        L_0x0281:
            r7 = r67
        L_0x0283:
            r33 = r6
            r6 = r11 & 14
            if (r6 != 0) goto L_0x029a
            r6 = r12 & r27
            r7 = r69
            if (r6 != 0) goto L_0x0297
            boolean r6 = r0.changed((long) r7)
            if (r6 == 0) goto L_0x0297
            r6 = 4
            goto L_0x0298
        L_0x0297:
            r6 = 2
        L_0x0298:
            r6 = r6 | r11
            goto L_0x029d
        L_0x029a:
            r7 = r69
            r6 = r11
        L_0x029d:
            r34 = r11 & 112(0x70, float:1.57E-43)
            if (r34 != 0) goto L_0x02b7
            r34 = 2097152(0x200000, float:2.938736E-39)
            r34 = r12 & r34
            r7 = r71
            if (r34 != 0) goto L_0x02b2
            boolean r34 = r0.changed((long) r7)
            if (r34 == 0) goto L_0x02b2
            r30 = 32
            goto L_0x02b4
        L_0x02b2:
            r30 = 16
        L_0x02b4:
            r6 = r6 | r30
            goto L_0x02b9
        L_0x02b7:
            r7 = r71
        L_0x02b9:
            r30 = 4194304(0x400000, float:5.877472E-39)
            r30 = r12 & r30
            if (r30 == 0) goto L_0x02c2
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x02d1
        L_0x02c2:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x02d1
            boolean r3 = r0.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x02cd
            goto L_0x02cf
        L_0x02cd:
            r16 = 128(0x80, float:1.794E-43)
        L_0x02cf:
            r6 = r6 | r16
        L_0x02d1:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r2
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x031f
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r33 & r3
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x031f
            r3 = r6 & 731(0x2db, float:1.024E-42)
            r5 = 146(0x92, float:2.05E-43)
            if (r3 != r5) goto L_0x031f
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x02f1
            goto L_0x031f
        L_0x02f1:
            r0.skipToGroupEnd()
            r12 = r45
            r4 = r47
            r6 = r49
            r29 = r54
            r13 = r56
            r15 = r58
            r16 = r59
            r17 = r60
            r18 = r61
            r19 = r62
            r20 = r63
            r22 = r65
            r24 = r67
            r26 = r69
            r2 = r0
            r38 = r7
            r3 = r9
            r5 = r10
            r7 = r50
            r8 = r51
            r9 = r52
            r10 = r53
            goto L_0x067a
        L_0x031f:
            r0.startDefaults()
            r3 = r13 & 1
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r5 = 0
            r7 = 6
            if (r3 == 0) goto L_0x03aa
            boolean r3 = r0.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0333
            goto L_0x03aa
        L_0x0333:
            r0.skipToGroupEnd()
            r1 = r12 & 4
            if (r1 == 0) goto L_0x033c
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x033c:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0342
            r2 = r2 & r16
        L_0x0342:
            r1 = r12 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0348
            r33 = r33 & -15
        L_0x0348:
            r1 = r12 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x034e
            r33 = r33 & -113(0xffffffffffffff8f, float:NaN)
        L_0x034e:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0359
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r33 = r33 & r1
        L_0x0359:
            r1 = r12 & r24
            if (r1 == 0) goto L_0x0362
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r33 = r33 & r1
        L_0x0362:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0369
            r33 = r33 & r16
        L_0x0369:
            r1 = r12 & r28
            if (r1 == 0) goto L_0x0372
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r33 = r33 & r1
        L_0x0372:
            r1 = r12 & r27
            if (r1 == 0) goto L_0x0378
            r6 = r6 & -15
        L_0x0378:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x037f
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x037f:
            r1 = r45
            r4 = r47
            r7 = r50
            r3 = r52
            r18 = r53
            r29 = r54
            r31 = r56
            r8 = r58
            r16 = r59
            r20 = r60
            r21 = r61
            r22 = r62
            r23 = r63
            r26 = r65
            r34 = r67
            r36 = r69
            r38 = r71
            r28 = r6
            r5 = r10
            r6 = r49
            r10 = r51
            goto L_0x054d
        L_0x03aa:
            if (r4 == 0) goto L_0x03b1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r22 = r3
            goto L_0x03b3
        L_0x03b1:
            r22 = r45
        L_0x03b3:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x03df
            r3 = 0
            r4 = 0
            r9 = 0
            r30 = 0
            r32 = 7
            r8 = r2
            r2 = r3
            r3 = r4
            r4 = r9
            r9 = r5
            r5 = r0
            r34 = r6
            r6 = r30
            r9 = r7
            r30 = r19
            r19 = r31
            r43 = r29
            r29 = r18
            r18 = r43
            r7 = r32
            androidx.compose.material.BottomSheetScaffoldState r2 = rememberBottomSheetScaffoldState(r2, r3, r4, r5, r6, r7)
            r3 = r8 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r3
            r3 = r2
            r2 = 0
            goto L_0x03f0
        L_0x03df:
            r8 = r2
            r2 = r5
            r34 = r6
            r9 = r7
            r30 = r19
            r19 = r31
            r43 = r29
            r29 = r18
            r18 = r43
            r3 = r46
        L_0x03f0:
            if (r17 == 0) goto L_0x03f4
            r4 = r2
            goto L_0x03f6
        L_0x03f4:
            r4 = r47
        L_0x03f6:
            if (r20 == 0) goto L_0x03ff
            androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt r5 = androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1204getLambda1$material_release()
            goto L_0x0400
        L_0x03ff:
            r5 = r10
        L_0x0400:
            if (r23 == 0) goto L_0x0404
            r6 = r2
            goto L_0x0406
        L_0x0404:
            r6 = r49
        L_0x0406:
            if (r26 == 0) goto L_0x040f
            androidx.compose.material.FabPosition$Companion r7 = androidx.compose.material.FabPosition.Companion
            int r7 = r7.m1269getEnd5ygKITE()
            goto L_0x0411
        L_0x040f:
            r7 = r50
        L_0x0411:
            if (r18 == 0) goto L_0x0415
            r10 = 1
            goto L_0x0417
        L_0x0415:
            r10 = r51
        L_0x0417:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0428
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r0, r9)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getLarge()
            r8 = r8 & r16
            goto L_0x042a
        L_0x0428:
            r2 = r52
        L_0x042a:
            if (r19 == 0) goto L_0x0433
            androidx.compose.material.BottomSheetScaffoldDefaults r18 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r18 = r18.m1118getSheetElevationD9Ej5fM()
            goto L_0x0435
        L_0x0433:
            r18 = r53
        L_0x0435:
            r9 = r12 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x044d
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            r45 = r2
            r2 = 6
            androidx.compose.material.Colors r9 = r9.getColors(r0, r2)
            long r31 = r9.m1183getSurface0d7_KjU()
            r33 = r33 & -15
            r46 = r3
            r2 = r31
            goto L_0x0453
        L_0x044d:
            r45 = r2
            r46 = r3
            r2 = r54
        L_0x0453:
            r9 = r12 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x0460
            r9 = r33 & 14
            long r31 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r2, r0, r9)
            r33 = r33 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0462
        L_0x0460:
            r31 = r56
        L_0x0462:
            if (r1 == 0) goto L_0x046b
            androidx.compose.material.BottomSheetScaffoldDefaults r1 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r1 = r1.m1119getSheetPeekHeightD9Ej5fM()
            goto L_0x046d
        L_0x046b:
            r1 = r58
        L_0x046d:
            if (r29 == 0) goto L_0x0471
            r9 = 0
            goto L_0x0473
        L_0x0471:
            r9 = r59
        L_0x0473:
            if (r30 == 0) goto L_0x0478
            r20 = 1
            goto L_0x047a
        L_0x0478:
            r20 = r60
        L_0x047a:
            r23 = 32768(0x8000, float:4.5918E-41)
            r23 = r12 & r23
            r47 = r1
            if (r23 == 0) goto L_0x0496
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r29 = r2
            r2 = 6
            androidx.compose.material.Shapes r1 = r1.getShapes(r0, r2)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getLarge()
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r33 = r33 & r2
            goto L_0x049a
        L_0x0496:
            r29 = r2
            r1 = r61
        L_0x049a:
            if (r21 == 0) goto L_0x04a3
            androidx.compose.material.DrawerDefaults r2 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r2 = r2.m1224getElevationD9Ej5fM()
            goto L_0x04a5
        L_0x04a3:
            r2 = r62
        L_0x04a5:
            r3 = r12 & r24
            if (r3 == 0) goto L_0x04c0
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r48 = r1
            r1 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r1)
            long r23 = r3.m1183getSurface0d7_KjU()
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r33 = r33 & r1
            r49 = r2
            r1 = r23
            goto L_0x04c6
        L_0x04c0:
            r48 = r1
            r49 = r2
            r1 = r63
        L_0x04c6:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r12
            if (r3 == 0) goto L_0x04d6
            int r3 = r33 >> 21
            r3 = r3 & 14
            long r23 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r1, r0, r3)
            r33 = r33 & r16
            goto L_0x04d8
        L_0x04d6:
            r23 = r65
        L_0x04d8:
            r3 = r12 & r28
            if (r3 == 0) goto L_0x04ed
            androidx.compose.material.DrawerDefaults r3 = androidx.compose.material.DrawerDefaults.INSTANCE
            r50 = r1
            r1 = 6
            long r2 = r3.getScrimColor(r0, r1)
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r16 = r33 & r16
            r33 = r16
            goto L_0x04f2
        L_0x04ed:
            r50 = r1
            r1 = 6
            r2 = r67
        L_0x04f2:
            r16 = r12 & r27
            r52 = r2
            if (r16 == 0) goto L_0x0507
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r1)
            long r1 = r2.m1172getBackground0d7_KjU()
            r3 = r34 & -15
            r34 = r3
            goto L_0x0509
        L_0x0507:
            r1 = r69
        L_0x0509:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r12
            if (r3 == 0) goto L_0x0532
            r3 = r34 & 14
            long r26 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r1, r0, r3)
            r3 = r34 & -113(0xffffffffffffff8f, float:NaN)
            r21 = r48
            r34 = r52
            r36 = r1
            r28 = r3
            r2 = r8
            r16 = r9
            r1 = r22
            r38 = r26
            r3 = r45
            r9 = r46
            r8 = r47
            r22 = r49
            r26 = r23
            r23 = r50
            goto L_0x054d
        L_0x0532:
            r3 = r45
            r21 = r48
            r38 = r71
            r36 = r1
            r2 = r8
            r16 = r9
            r1 = r22
            r26 = r23
            r28 = r34
            r9 = r46
            r8 = r47
            r22 = r49
            r23 = r50
            r34 = r52
        L_0x054d:
            r0.endDefaults()
            r11 = 773894976(0x2e20b340, float:3.6538994E-11)
            r0.startReplaceableGroup(r11)
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r11)
            java.lang.Object r11 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r40 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r40.getEmpty()
            if (r11 != r12) goto L_0x0577
            kotlin.coroutines.EmptyCoroutineContext r11 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r11 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r11, r0)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r12 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r12.<init>(r11)
            r0.updateRememberedValue(r12)
            r11 = r12
        L_0x0577:
            r0.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r11 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r11
            kotlinx.coroutines.CoroutineScope r11 = r11.getCoroutineScope()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            float r12 = r12.m5447toPx0680j_4(r8)
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r13)
            java.lang.Object r13 = r0.rememberedValue()
            java.lang.Object r14 = r40.getEmpty()
            if (r13 != r14) goto L_0x05ac
            r13 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r13, r14, r13)
            r0.updateRememberedValue(r14)
            r13 = r14
            goto L_0x05ae
        L_0x05ac:
            r45 = r13
        L_0x05ae:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            java.lang.Float r14 = m1122BottomSheetScaffold_bGncdBI$lambda4(r13)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((float) r12, (java.lang.Float) r14)
            if (r14 != 0) goto L_0x05d1
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1 r15 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1
            r15.<init>(r9, r11)
            r11 = 0
            r40 = r0
            r25 = r1
            r0 = 1
            r1 = 0
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r14, r11, r15, r0, r1)
            r0 = r11
            goto L_0x05d7
        L_0x05d1:
            r40 = r0
            r25 = r1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
        L_0x05d7:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1 r1 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1
            r45 = r1
            r46 = r9
            r47 = r4
            r48 = r73
            r49 = r6
            r50 = r8
            r51 = r7
            r52 = r2
            r53 = r28
            r54 = r33
            r55 = r12
            r56 = r10
            r57 = r0
            r58 = r13
            r59 = r3
            r60 = r29
            r62 = r31
            r64 = r18
            r65 = r44
            r66 = r5
            r45.<init>(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r64, r65, r66)
            r0 = 893101063(0x353ba407, float:6.990162E-7)
            r2 = r40
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r11, r1)
            r1 = 0
            r12 = r25
            r13 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r12, r1, r11, r13)
            r11 = 0
            r13 = 0
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1 r15 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1
            r45 = r15
            r46 = r16
            r47 = r0
            r48 = r9
            r49 = r20
            r50 = r21
            r51 = r22
            r52 = r23
            r54 = r26
            r56 = r34
            r58 = r33
            r45.<init>(r46, r47, r48, r49, r50, r51, r52, r54, r56, r58)
            r0 = 1273816607(0x4bece61f, float:3.1050814E7)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r14, r15)
            r14 = 6
            int r14 = r28 << 6
            r15 = r14 & 896(0x380, float:1.256E-42)
            r17 = 1572864(0x180000, float:2.204052E-39)
            r15 = r15 | r17
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | r15
            r15 = 50
            r45 = r1
            r46 = r11
            r47 = r36
            r49 = r38
            r51 = r13
            r1 = 0
            r52 = r1
            r53 = r0
            r54 = r2
            r55 = r14
            r56 = r15
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r45, r46, r47, r49, r51, r52, r53, r54, r55, r56)
            r15 = r8
            r8 = r10
            r10 = r18
            r17 = r20
            r18 = r21
            r19 = r22
            r20 = r23
            r22 = r26
            r13 = r31
            r24 = r34
            r26 = r36
            r43 = r9
            r9 = r3
            r3 = r43
        L_0x067a:
            androidx.compose.runtime.ScopeUpdateScope r11 = r2.endRestartGroup()
            if (r11 != 0) goto L_0x0681
            goto L_0x06a3
        L_0x0681:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2 r2 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r0 = r2
            r1 = r44
            r41 = r2
            r2 = r12
            r42 = r11
            r11 = r29
            r28 = r38
            r30 = r73
            r31 = r75
            r32 = r76
            r33 = r77
            r34 = r78
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r22, r24, r26, r28, r30, r31, r32, r33, r34)
            r1 = r41
            r0 = r42
            r0.updateScope(r1)
        L_0x06a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1120BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][_][androidx.compose.ui.UiComposable][_]]")
    @Composable
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w  reason: not valid java name */
    public static final void m1121BottomSheetScaffoldLayoutKCBPh4w(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, float f11, int i11, State<Float> state, BottomSheetState bottomSheetState, Composer composer, int i12) {
        int i13;
        Composer composer2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function3;
        Function3<? super Integer, ? super Composer, ? super Integer, Unit> function34 = function32;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        State<Float> state2 = state;
        BottomSheetState bottomSheetState2 = bottomSheetState;
        int i24 = i12;
        Composer startRestartGroup = composer.startRestartGroup(499725572);
        if ((i24 & 14) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i23 = 4;
            } else {
                i23 = 2;
            }
            i13 = i23 | i24;
        } else {
            i13 = i24;
        }
        if ((i24 & 112) == 0) {
            if (startRestartGroup.changed((Object) function33)) {
                i22 = 32;
            } else {
                i22 = 16;
            }
            i13 |= i22;
        }
        if ((i24 & 896) == 0) {
            if (startRestartGroup.changed((Object) function34)) {
                i21 = 256;
            } else {
                i21 = 128;
            }
            i13 |= i21;
        }
        if ((i24 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function25)) {
                i19 = 2048;
            } else {
                i19 = 1024;
            }
            i13 |= i19;
        }
        if ((57344 & i24) == 0) {
            if (startRestartGroup.changed((Object) function26)) {
                i18 = 16384;
            } else {
                i18 = 8192;
            }
            i13 |= i18;
        }
        float f12 = f11;
        if ((458752 & i24) == 0) {
            if (startRestartGroup.changed(f12)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i13 |= i17;
        }
        int i25 = i11;
        if ((3670016 & i24) == 0) {
            if (startRestartGroup.changed(i25)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i13 |= i16;
        }
        if ((29360128 & i24) == 0) {
            if (startRestartGroup.changed((Object) state2)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i13 |= i15;
        }
        if ((234881024 & i24) == 0) {
            if (startRestartGroup.changed((Object) bottomSheetState2)) {
                i14 = 67108864;
            } else {
                i14 = 33554432;
            }
            i13 |= i14;
        }
        int i26 = i13;
        if ((i26 & 191739611) != 38347922 || !startRestartGroup.getSkipping()) {
            Object[] objArr = {function34, state2, function24, function33, Dp.m5476boximpl(f11), function25, FabPosition.m1261boximpl(i11), function26, bottomSheetState2};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z11 = false;
            for (int i27 = 0; i27 < 9; i27++) {
                z11 |= startRestartGroup.changed(objArr[i27]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
                BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 = r0;
                composer2 = startRestartGroup;
                BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$12 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(state, function2, function22, i11, f11, function23, bottomSheetState, function32, i26, function3);
                composer2.updateRememberedValue(bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1);
                rememberedValue = bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1;
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) rememberedValue, composer2, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(function2, function3, function32, function22, function23, f11, i11, state, bottomSheetState, i12));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffold_bGncdBI$lambda-4  reason: not valid java name */
    public static final Float m1122BottomSheetScaffold_bGncdBI$lambda4(MutableState<Float> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffold_bGncdBI$lambda-5  reason: not valid java name */
    public static final void m1123BottomSheetScaffold_bGncdBI$lambda5(MutableState<Float> mutableState, Float f11) {
        mutableState.setValue(f11);
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(@Nullable DrawerState drawerState, @Nullable BottomSheetState bottomSheetState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-1353009744);
        if ((i12 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, composer, 6, 2);
        }
        if ((i12 & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, (AnimationSpec<Float>) null, (Function1<? super BottomSheetValue, Boolean>) null, composer, 6, 6);
        }
        if ((i12 & 4) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) drawerState) | composer.changed((Object) bottomSheetState) | composer.changed((Object) snackbarHostState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final BottomSheetState rememberBottomSheetState(@NotNull BottomSheetValue bottomSheetValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function1<? super BottomSheetValue, Boolean> function1, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        SpringSpec<Float> springSpec = animationSpec;
        if ((i12 & 2) != 0) {
            springSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        BottomSheetScaffoldKt$rememberBottomSheetState$1 bottomSheetScaffoldKt$rememberBottomSheetState$1 = function1;
        if ((i12 & 4) != 0) {
            bottomSheetScaffoldKt$rememberBottomSheetState$1 = BottomSheetScaffoldKt$rememberBottomSheetState$1.INSTANCE;
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{springSpec}, BottomSheetState.Companion.Saver(springSpec, bottomSheetScaffoldKt$rememberBottomSheetState$1), (String) null, new BottomSheetScaffoldKt$rememberBottomSheetState$2(bottomSheetValue, springSpec, bottomSheetScaffoldKt$rememberBottomSheetState$1), composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomSheetState;
    }
}
