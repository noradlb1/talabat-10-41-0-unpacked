package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m5478constructorimpl((float) 16);
    @NotNull
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r56v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01b8, code lost:
        if (r0.changed(r54) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01d2, code lost:
        if (r0.changed(r56) != false) goto L_0x01d9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x04c3  */
    /* JADX WARNING: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013f  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Scaffold-27mzLpw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1353Scaffold27mzLpw(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r40, @org.jetbrains.annotations.Nullable androidx.compose.material.ScaffoldState r41, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, int r46, boolean r47, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, boolean r49, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r50, float r51, long r52, long r54, long r56, long r58, long r60, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r63, int r64, int r65, int r66) {
        /*
            r15 = r62
            r13 = r64
            r14 = r65
            r12 = r66
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 1037492569(0x3dd6e159, float:0.104922004)
            r1 = r63
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0020
            r4 = r13 | 6
            r5 = r4
            r4 = r40
            goto L_0x0034
        L_0x0020:
            r4 = r13 & 14
            if (r4 != 0) goto L_0x0031
            r4 = r40
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x002e
            r5 = 4
            goto L_0x002f
        L_0x002e:
            r5 = 2
        L_0x002f:
            r5 = r5 | r13
            goto L_0x0034
        L_0x0031:
            r4 = r40
            r5 = r13
        L_0x0034:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004d
            r6 = r12 & 2
            if (r6 != 0) goto L_0x0047
            r6 = r41
            boolean r9 = r0.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x0049
            r9 = 32
            goto L_0x004b
        L_0x0047:
            r6 = r41
        L_0x0049:
            r9 = 16
        L_0x004b:
            r5 = r5 | r9
            goto L_0x004f
        L_0x004d:
            r6 = r41
        L_0x004f:
            r9 = r12 & 4
            if (r9 == 0) goto L_0x0056
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0056:
            r2 = r13 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006a
            r2 = r42
            boolean r16 = r0.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x0065
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r5 = r5 | r16
            goto L_0x006c
        L_0x006a:
            r2 = r42
        L_0x006c:
            r16 = r12 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0077
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x008b
        L_0x0077:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008b
            r3 = r43
            boolean r20 = r0.changed((java.lang.Object) r3)
            if (r20 == 0) goto L_0x0086
            r20 = r17
            goto L_0x0088
        L_0x0086:
            r20 = r18
        L_0x0088:
            r5 = r5 | r20
            goto L_0x008d
        L_0x008b:
            r3 = r43
        L_0x008d:
            r20 = r12 & 16
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 16384(0x4000, float:2.2959E-41)
            r23 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x009d
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r7 = r44
            goto L_0x00b0
        L_0x009d:
            r24 = r13 & r21
            r7 = r44
            if (r24 != 0) goto L_0x00b0
            boolean r25 = r0.changed((java.lang.Object) r7)
            if (r25 == 0) goto L_0x00ac
            r25 = r22
            goto L_0x00ae
        L_0x00ac:
            r25 = r23
        L_0x00ae:
            r5 = r5 | r25
        L_0x00b0:
            r25 = r12 & 32
            r26 = 131072(0x20000, float:1.83671E-40)
            r27 = 458752(0x70000, float:6.42848E-40)
            r28 = 65536(0x10000, float:9.18355E-41)
            if (r25 == 0) goto L_0x00c1
            r29 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r29
            r8 = r45
            goto L_0x00d4
        L_0x00c1:
            r29 = r13 & r27
            r8 = r45
            if (r29 != 0) goto L_0x00d4
            boolean r30 = r0.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x00d0
            r30 = r26
            goto L_0x00d2
        L_0x00d0:
            r30 = r28
        L_0x00d2:
            r5 = r5 | r30
        L_0x00d4:
            r30 = r12 & 64
            r31 = 3670016(0x380000, float:5.142788E-39)
            if (r30 == 0) goto L_0x00e1
            r32 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r32
            r10 = r46
            goto L_0x00f4
        L_0x00e1:
            r32 = r13 & r31
            r10 = r46
            if (r32 != 0) goto L_0x00f4
            boolean r33 = r0.changed((int) r10)
            if (r33 == 0) goto L_0x00f0
            r33 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f2
        L_0x00f0:
            r33 = 524288(0x80000, float:7.34684E-40)
        L_0x00f2:
            r5 = r5 | r33
        L_0x00f4:
            r11 = r12 & 128(0x80, float:1.794E-43)
            r34 = 29360128(0x1c00000, float:7.052966E-38)
            if (r11 == 0) goto L_0x0101
            r35 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r35
            r2 = r47
            goto L_0x0114
        L_0x0101:
            r35 = r13 & r34
            r2 = r47
            if (r35 != 0) goto L_0x0114
            boolean r35 = r0.changed((boolean) r2)
            if (r35 == 0) goto L_0x0110
            r35 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0112
        L_0x0110:
            r35 = 4194304(0x400000, float:5.877472E-39)
        L_0x0112:
            r5 = r5 | r35
        L_0x0114:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x011f
            r35 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r35
            r3 = r48
            goto L_0x0134
        L_0x011f:
            r35 = 234881024(0xe000000, float:1.5777218E-30)
            r35 = r13 & r35
            r3 = r48
            if (r35 != 0) goto L_0x0134
            boolean r35 = r0.changed((java.lang.Object) r3)
            if (r35 == 0) goto L_0x0130
            r35 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0132
        L_0x0130:
            r35 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0132:
            r5 = r5 | r35
        L_0x0134:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x013f
            r35 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r35
            r4 = r49
            goto L_0x0154
        L_0x013f:
            r35 = 1879048192(0x70000000, float:1.58456325E29)
            r35 = r13 & r35
            r4 = r49
            if (r35 != 0) goto L_0x0154
            boolean r35 = r0.changed((boolean) r4)
            if (r35 == 0) goto L_0x0150
            r35 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0152
        L_0x0150:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0152:
            r5 = r5 | r35
        L_0x0154:
            r35 = r14 & 14
            if (r35 != 0) goto L_0x016e
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x0167
            r4 = r50
            boolean r35 = r0.changed((java.lang.Object) r4)
            if (r35 == 0) goto L_0x0169
            r19 = 4
            goto L_0x016b
        L_0x0167:
            r4 = r50
        L_0x0169:
            r19 = 2
        L_0x016b:
            r19 = r14 | r19
            goto L_0x0172
        L_0x016e:
            r4 = r50
            r19 = r14
        L_0x0172:
            r4 = r12 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x017b
            r19 = r19 | 48
            r6 = r51
            goto L_0x018e
        L_0x017b:
            r35 = r14 & 112(0x70, float:1.57E-43)
            r6 = r51
            if (r35 != 0) goto L_0x018e
            boolean r35 = r0.changed((float) r6)
            if (r35 == 0) goto L_0x018a
            r24 = 32
            goto L_0x018c
        L_0x018a:
            r24 = 16
        L_0x018c:
            r19 = r19 | r24
        L_0x018e:
            r6 = r14 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x01a8
            r6 = r12 & 4096(0x1000, float:5.74E-42)
            if (r6 != 0) goto L_0x01a1
            r6 = r52
            boolean r24 = r0.changed((long) r6)
            if (r24 == 0) goto L_0x01a3
            r32 = 256(0x100, float:3.59E-43)
            goto L_0x01a5
        L_0x01a1:
            r6 = r52
        L_0x01a3:
            r32 = 128(0x80, float:1.794E-43)
        L_0x01a5:
            r19 = r19 | r32
            goto L_0x01aa
        L_0x01a8:
            r6 = r52
        L_0x01aa:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x01c2
            r6 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r6 != 0) goto L_0x01bb
            r6 = r54
            boolean r24 = r0.changed((long) r6)
            if (r24 == 0) goto L_0x01bd
            goto L_0x01bf
        L_0x01bb:
            r6 = r54
        L_0x01bd:
            r17 = r18
        L_0x01bf:
            r19 = r19 | r17
            goto L_0x01c4
        L_0x01c2:
            r6 = r54
        L_0x01c4:
            r17 = r14 & r21
            if (r17 != 0) goto L_0x01dc
            r6 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r6 != 0) goto L_0x01d5
            r6 = r56
            boolean r17 = r0.changed((long) r6)
            if (r17 == 0) goto L_0x01d7
            goto L_0x01d9
        L_0x01d5:
            r6 = r56
        L_0x01d7:
            r22 = r23
        L_0x01d9:
            r19 = r19 | r22
            goto L_0x01de
        L_0x01dc:
            r6 = r56
        L_0x01de:
            r17 = r14 & r27
            if (r17 != 0) goto L_0x01f9
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r12 & r17
            r6 = r58
            if (r17 != 0) goto L_0x01f4
            boolean r17 = r0.changed((long) r6)
            if (r17 == 0) goto L_0x01f4
            r17 = r26
            goto L_0x01f6
        L_0x01f4:
            r17 = r28
        L_0x01f6:
            r19 = r19 | r17
            goto L_0x01fb
        L_0x01f9:
            r6 = r58
        L_0x01fb:
            r17 = r14 & r31
            if (r17 != 0) goto L_0x0213
            r17 = r12 & r28
            r6 = r60
            if (r17 != 0) goto L_0x020e
            boolean r17 = r0.changed((long) r6)
            if (r17 == 0) goto L_0x020e
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0210
        L_0x020e:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x0210:
            r19 = r19 | r17
            goto L_0x0215
        L_0x0213:
            r6 = r60
        L_0x0215:
            r17 = r12 & r26
            if (r17 == 0) goto L_0x021e
            r17 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x021b:
            r19 = r19 | r17
            goto L_0x022e
        L_0x021e:
            r17 = r14 & r34
            if (r17 != 0) goto L_0x022e
            boolean r17 = r0.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x022b
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x021b
        L_0x022b:
            r17 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x021b
        L_0x022e:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r5 & r17
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r7) goto L_0x026e
            r6 = 23967451(0x16db6db, float:4.3661218E-38)
            r6 = r19 & r6
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r6 != r7) goto L_0x026e
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x0249
            goto L_0x026e
        L_0x0249:
            r0.skipToGroupEnd()
            r1 = r40
            r2 = r41
            r3 = r42
            r4 = r43
            r5 = r44
            r9 = r48
            r11 = r50
            r12 = r51
            r18 = r52
            r22 = r54
            r24 = r56
            r28 = r58
            r32 = r60
            r6 = r8
            r7 = r10
            r8 = r47
            r10 = r49
            goto L_0x04bc
        L_0x026e:
            r0.startDefaults()
            r6 = r13 & 1
            if (r6 == 0) goto L_0x02d8
            boolean r6 = r0.getDefaultsInvalid()
            if (r6 == 0) goto L_0x027c
            goto L_0x02d8
        L_0x027c:
            r0.skipToGroupEnd()
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0285
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0285:
            r1 = r12 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x028b
            r19 = r19 & -15
        L_0x028b:
            r1 = r19
            r2 = r12 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0293
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0293:
            r2 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0299
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0299:
            r2 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02a1
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x02a1:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x02ab
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
        L_0x02ab:
            r2 = r12 & r28
            if (r2 == 0) goto L_0x02b3
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
        L_0x02b3:
            r2 = r41
            r6 = r42
            r7 = r43
            r11 = r47
            r3 = r48
            r4 = r49
            r16 = r51
            r18 = r52
            r22 = r54
            r24 = r56
            r28 = r58
            r32 = r60
            r17 = r1
            r20 = r5
            r9 = r8
            r1 = r40
            r8 = r44
            r5 = r50
            goto L_0x0401
        L_0x02d8:
            if (r1 == 0) goto L_0x02dd
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x02df
        L_0x02dd:
            r1 = r40
        L_0x02df:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x02f0
            r6 = 0
            r7 = 3
            r40 = r1
            r1 = 0
            r8 = 0
            androidx.compose.material.ScaffoldState r1 = rememberScaffoldState(r1, r8, r0, r6, r7)
            r5 = r5 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02f4
        L_0x02f0:
            r40 = r1
            r1 = r41
        L_0x02f4:
            if (r9 == 0) goto L_0x02fd
            androidx.compose.material.ComposableSingletons$ScaffoldKt r6 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r6 = r6.m1205getLambda1$material_release()
            goto L_0x02ff
        L_0x02fd:
            r6 = r42
        L_0x02ff:
            if (r16 == 0) goto L_0x0308
            androidx.compose.material.ComposableSingletons$ScaffoldKt r7 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m1206getLambda2$material_release()
            goto L_0x030a
        L_0x0308:
            r7 = r43
        L_0x030a:
            if (r20 == 0) goto L_0x0313
            androidx.compose.material.ComposableSingletons$ScaffoldKt r8 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m1207getLambda3$material_release()
            goto L_0x0315
        L_0x0313:
            r8 = r44
        L_0x0315:
            if (r25 == 0) goto L_0x031e
            androidx.compose.material.ComposableSingletons$ScaffoldKt r9 = androidx.compose.material.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r9 = r9.m1208getLambda4$material_release()
            goto L_0x0320
        L_0x031e:
            r9 = r45
        L_0x0320:
            if (r30 == 0) goto L_0x0328
            androidx.compose.material.FabPosition$Companion r10 = androidx.compose.material.FabPosition.Companion
            int r10 = r10.m1269getEnd5ygKITE()
        L_0x0328:
            if (r11 == 0) goto L_0x032c
            r11 = 0
            goto L_0x032e
        L_0x032c:
            r11 = r47
        L_0x032e:
            if (r2 == 0) goto L_0x0332
            r2 = 0
            goto L_0x0334
        L_0x0332:
            r2 = r48
        L_0x0334:
            if (r3 == 0) goto L_0x0338
            r3 = 1
            goto L_0x033a
        L_0x0338:
            r3 = r49
        L_0x033a:
            r41 = r1
            r1 = r12 & 1024(0x400, float:1.435E-42)
            r42 = r2
            r2 = 6
            if (r1 == 0) goto L_0x0350
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r1 = r1.getShapes(r0, r2)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getLarge()
            r19 = r19 & -15
            goto L_0x0352
        L_0x0350:
            r1 = r50
        L_0x0352:
            r36 = r19
            if (r4 == 0) goto L_0x035d
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r4 = r4.m1224getElevationD9Ej5fM()
            goto L_0x035f
        L_0x035d:
            r4 = r51
        L_0x035f:
            r2 = r12 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x037e
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r44 = r1
            r1 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r0, r1)
            long r1 = r2.m1183getSurface0d7_KjU()
            r45 = r1
            r1 = r36
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r39 = r3
            r3 = r1
            r1 = r45
            r45 = r39
            goto L_0x0387
        L_0x037e:
            r44 = r1
            r1 = r36
            r45 = r3
            r3 = r1
            r1 = r52
        L_0x0387:
            r46 = r4
            r4 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x0398
            int r4 = r3 >> 6
            r4 = r4 & 14
            long r16 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r1, r0, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x039a
        L_0x0398:
            r16 = r54
        L_0x039a:
            r4 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x03ac
            androidx.compose.material.DrawerDefaults r4 = androidx.compose.material.DrawerDefaults.INSTANCE
            r18 = r1
            r1 = 6
            long r22 = r4.getScrimColor(r0, r1)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r2
            goto L_0x03b1
        L_0x03ac:
            r18 = r1
            r1 = 6
            r22 = r56
        L_0x03b1:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x03c6
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r2.getColors(r0, r1)
            long r1 = r1.m1172getBackground0d7_KjU()
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r4
            goto L_0x03c8
        L_0x03c6:
            r1 = r58
        L_0x03c8:
            r4 = r12 & r28
            if (r4 == 0) goto L_0x03e9
            int r4 = r3 >> 15
            r4 = r4 & 14
            long r24 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r1, r0, r4)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r4
            r4 = r45
            r28 = r1
            r20 = r5
            r32 = r24
            r1 = r40
            r2 = r41
            r5 = r44
            r24 = r22
            goto L_0x03f9
        L_0x03e9:
            r4 = r45
            r32 = r60
            r28 = r1
            r20 = r5
            r24 = r22
            r1 = r40
            r2 = r41
            r5 = r44
        L_0x03f9:
            r22 = r16
            r16 = r46
            r17 = r3
            r3 = r42
        L_0x0401:
            r0.endDefaults()
            androidx.compose.material.ScaffoldKt$Scaffold$child$1 r12 = new androidx.compose.material.ScaffoldKt$Scaffold$child$1
            r40 = r12
            r41 = r28
            r43 = r32
            r45 = r17
            r46 = r11
            r47 = r10
            r48 = r6
            r49 = r62
            r50 = r9
            r51 = r7
            r52 = r20
            r53 = r8
            r54 = r2
            r40.<init>(r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r56 = r6
            r6 = 1823402604(0x6caeea6c, float:1.691681E27)
            r57 = r7
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r7, r12)
            if (r3 == 0) goto L_0x0494
            r12 = -1013848234(0xffffffffc391e756, float:-291.8073)
            r0.startReplaceableGroup(r12)
            androidx.compose.material.DrawerState r12 = r2.getDrawerState()
            androidx.compose.material.ScaffoldKt$Scaffold$1 r7 = new androidx.compose.material.ScaffoldKt$Scaffold$1
            r7.<init>(r6)
            r6 = 100842932(0x602bdb4, float:2.4589654E-35)
            r58 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r2, r7)
            int r6 = r20 >> 24
            r6 = r6 & 14
            r7 = 805306368(0x30000000, float:4.656613E-10)
            r6 = r6 | r7
            int r7 = r20 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            int r7 = r20 >> 18
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r7
            int r7 = r17 << 12
            r17 = r7 & r21
            r6 = r6 | r17
            r17 = r7 & r27
            r6 = r6 | r17
            r17 = r7 & r31
            r6 = r6 | r17
            r17 = r7 & r34
            r6 = r6 | r17
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r7 & r17
            r6 = r6 | r7
            r7 = 0
            r40 = r3
            r41 = r1
            r42 = r12
            r43 = r4
            r44 = r5
            r45 = r16
            r46 = r18
            r48 = r22
            r50 = r24
            r52 = r2
            r53 = r0
            r54 = r6
            r55 = r7
            androidx.compose.material.DrawerKt.m1228ModalDrawerGs3lGvM(r40, r41, r42, r43, r44, r45, r46, r48, r50, r52, r53, r54, r55)
            r0.endReplaceableGroup()
            goto L_0x04aa
        L_0x0494:
            r58 = r2
            r2 = -1013847725(0xffffffffc391e953, float:-291.82285)
            r0.startReplaceableGroup(r2)
            r2 = r20 & 14
            r2 = r2 | 48
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.invoke(r1, r0, r2)
            r0.endReplaceableGroup()
        L_0x04aa:
            r2 = r58
            r6 = r9
            r7 = r10
            r12 = r16
            r9 = r3
            r10 = r4
            r3 = r56
            r4 = r57
            r39 = r11
            r11 = r5
            r5 = r8
            r8 = r39
        L_0x04bc:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 != 0) goto L_0x04c3
            goto L_0x04e6
        L_0x04c3:
            androidx.compose.material.ScaffoldKt$Scaffold$2 r15 = new androidx.compose.material.ScaffoldKt$Scaffold$2
            r37 = r0
            r0 = r15
            r13 = r18
            r38 = r15
            r15 = r22
            r17 = r24
            r19 = r28
            r21 = r32
            r23 = r62
            r24 = r64
            r25 = r65
            r26 = r66
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r19, r21, r23, r24, r25, r26)
            r0 = r37
            r1 = r38
            r0.updateScope(r1)
        L_0x04e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1353Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    @UiComposable
    /* renamed from: ScaffoldLayout-MDYNRJg  reason: not valid java name */
    public static final void m1354ScaffoldLayoutMDYNRJg(boolean z11, int i11, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        int i24 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-1401632215);
        boolean z12 = z11;
        if ((i24 & 14) == 0) {
            if (startRestartGroup.changed(z12)) {
                i23 = 4;
            } else {
                i23 = 2;
            }
            i13 = i23 | i24;
        } else {
            i13 = i24;
        }
        int i25 = i11;
        if ((i24 & 112) == 0) {
            if (startRestartGroup.changed(i25)) {
                i22 = 32;
            } else {
                i22 = 16;
            }
            i13 |= i22;
        }
        if ((i24 & 896) == 0) {
            if (startRestartGroup.changed((Object) function25)) {
                i21 = 256;
            } else {
                i21 = 128;
            }
            i13 |= i21;
        }
        if ((i24 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
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
        if ((458752 & i24) == 0) {
            if (startRestartGroup.changed((Object) function27)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i13 |= i17;
        }
        if ((3670016 & i24) == 0) {
            if (startRestartGroup.changed((Object) function28)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i13 |= i16;
        }
        int i26 = i13;
        if ((i26 & 2995931) != 599186 || !startRestartGroup.getSkipping()) {
            Object[] objArr = {function25, function26, function27, FabPosition.m1261boximpl(i11), Boolean.valueOf(z11), function28, function32};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z13 = false;
            for (int i27 = 0; i27 < 7; i27++) {
                z13 |= startRestartGroup.changed(objArr[i27]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z13 || rememberedValue == Composer.Companion.getEmpty()) {
                ScaffoldKt$ScaffoldLayout$1$1 scaffoldKt$ScaffoldLayout$1$1 = r0;
                i15 = 1;
                i14 = 0;
                ScaffoldKt$ScaffoldLayout$1$1 scaffoldKt$ScaffoldLayout$1$12 = new ScaffoldKt$ScaffoldLayout$1$1(function2, function22, function23, i11, z11, function24, i26, function3);
                startRestartGroup.updateRememberedValue(scaffoldKt$ScaffoldLayout$1$1);
                rememberedValue = scaffoldKt$ScaffoldLayout$1$1;
            } else {
                i15 = 1;
                i14 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) rememberedValue, startRestartGroup, i14, i15);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(z11, i11, function2, function3, function22, function23, function24, i12));
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    @NotNull
    @Composable
    public static final ScaffoldState rememberScaffoldState(@Nullable DrawerState drawerState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(1569641925);
        if ((i12 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, composer, 6, 2);
        }
        if ((i12 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        return scaffoldState;
    }
}
