package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ExposedDropdownMenuBoxScope {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: kotlin.jvm.functions.Function2} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: androidx.compose.ui.Modifier$Companion} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0193  */
        /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
        @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        @androidx.compose.runtime.Composable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void ExposedDropdownMenu(@org.jetbrains.annotations.NotNull androidx.compose.material.ExposedDropdownMenuBoxScope r23, boolean r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
            /*
                r6 = r25
                r14 = r27
                r15 = r29
                java.lang.String r0 = "onDismissRequest"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "content"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                r0 = -1165636223(0xffffffffba85cd81, float:-0.001020834)
                r1 = r28
                androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
                r0 = r30 & 1
                r1 = 2
                if (r0 == 0) goto L_0x0023
                r0 = r15 | 6
                r4 = r24
                goto L_0x0035
            L_0x0023:
                r0 = r15 & 14
                r4 = r24
                if (r0 != 0) goto L_0x0034
                boolean r0 = r5.changed((boolean) r4)
                if (r0 == 0) goto L_0x0031
                r0 = 4
                goto L_0x0032
            L_0x0031:
                r0 = r1
            L_0x0032:
                r0 = r0 | r15
                goto L_0x0035
            L_0x0034:
                r0 = r15
            L_0x0035:
                r2 = r30 & 2
                if (r2 == 0) goto L_0x003c
                r0 = r0 | 48
                goto L_0x004c
            L_0x003c:
                r2 = r15 & 112(0x70, float:1.57E-43)
                if (r2 != 0) goto L_0x004c
                boolean r2 = r5.changed((java.lang.Object) r6)
                if (r2 == 0) goto L_0x0049
                r2 = 32
                goto L_0x004b
            L_0x0049:
                r2 = 16
            L_0x004b:
                r0 = r0 | r2
            L_0x004c:
                r2 = r30 & 4
                if (r2 == 0) goto L_0x0053
                r0 = r0 | 384(0x180, float:5.38E-43)
                goto L_0x0066
            L_0x0053:
                r3 = r15 & 896(0x380, float:1.256E-42)
                if (r3 != 0) goto L_0x0066
                r3 = r26
                boolean r7 = r5.changed((java.lang.Object) r3)
                if (r7 == 0) goto L_0x0062
                r7 = 256(0x100, float:3.59E-43)
                goto L_0x0064
            L_0x0062:
                r7 = 128(0x80, float:1.794E-43)
            L_0x0064:
                r0 = r0 | r7
                goto L_0x0068
            L_0x0066:
                r3 = r26
            L_0x0068:
                r7 = r30 & 8
                if (r7 == 0) goto L_0x006f
                r0 = r0 | 3072(0xc00, float:4.305E-42)
                goto L_0x007f
            L_0x006f:
                r7 = r15 & 7168(0x1c00, float:1.0045E-41)
                if (r7 != 0) goto L_0x007f
                boolean r7 = r5.changed((java.lang.Object) r14)
                if (r7 == 0) goto L_0x007c
                r7 = 2048(0x800, float:2.87E-42)
                goto L_0x007e
            L_0x007c:
                r7 = 1024(0x400, float:1.435E-42)
            L_0x007e:
                r0 = r0 | r7
            L_0x007f:
                r7 = r30 & 16
                if (r7 == 0) goto L_0x0088
                r0 = r0 | 24576(0x6000, float:3.4438E-41)
                r13 = r23
                goto L_0x009c
            L_0x0088:
                r7 = 57344(0xe000, float:8.0356E-41)
                r7 = r7 & r15
                r13 = r23
                if (r7 != 0) goto L_0x009c
                boolean r7 = r5.changed((java.lang.Object) r13)
                if (r7 == 0) goto L_0x0099
                r7 = 16384(0x4000, float:2.2959E-41)
                goto L_0x009b
            L_0x0099:
                r7 = 8192(0x2000, float:1.14794E-41)
            L_0x009b:
                r0 = r0 | r7
            L_0x009c:
                r7 = 46811(0xb6db, float:6.5596E-41)
                r7 = r7 & r0
                r8 = 9362(0x2492, float:1.3119E-41)
                if (r7 != r8) goto L_0x00b2
                boolean r7 = r5.getSkipping()
                if (r7 != 0) goto L_0x00ab
                goto L_0x00b2
            L_0x00ab:
                r5.skipToGroupEnd()
                r4 = r3
                r7 = r5
                goto L_0x018c
            L_0x00b2:
                if (r2 == 0) goto L_0x00b9
                androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                r16 = r2
                goto L_0x00bb
            L_0x00b9:
                r16 = r3
            L_0x00bb:
                r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
                r5.startReplaceableGroup(r2)
                java.lang.Object r3 = r5.rememberedValue()
                androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r8 = r7.getEmpty()
                if (r3 != r8) goto L_0x00d7
                androidx.compose.animation.core.MutableTransitionState r3 = new androidx.compose.animation.core.MutableTransitionState
                java.lang.Boolean r8 = java.lang.Boolean.FALSE
                r3.<init>(r8)
                r5.updateRememberedValue(r3)
            L_0x00d7:
                r5.endReplaceableGroup()
                r8 = r3
                androidx.compose.animation.core.MutableTransitionState r8 = (androidx.compose.animation.core.MutableTransitionState) r8
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r24)
                r8.setTargetState(r3)
                java.lang.Object r3 = r8.getCurrentState()
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x0100
                java.lang.Object r3 = r8.getTargetState()
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L_0x00fd
                goto L_0x0100
            L_0x00fd:
                r7 = r5
                goto L_0x018a
            L_0x0100:
                r5.startReplaceableGroup(r2)
                java.lang.Object r2 = r5.rememberedValue()
                java.lang.Object r3 = r7.getEmpty()
                if (r2 != r3) goto L_0x011f
                androidx.compose.ui.graphics.TransformOrigin$Companion r2 = androidx.compose.ui.graphics.TransformOrigin.Companion
                long r2 = r2.m3292getCenterSzJe1aQ()
                androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r2)
                r3 = 0
                androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r3, r1, r3)
                r5.updateRememberedValue(r2)
            L_0x011f:
                r5.endReplaceableGroup()
                r9 = r2
                androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
                androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                java.lang.Object r1 = r5.consume(r1)
                r20 = r1
                androidx.compose.ui.unit.Density r20 = (androidx.compose.ui.unit.Density) r20
                androidx.compose.ui.unit.DpOffset$Companion r1 = androidx.compose.ui.unit.DpOffset.Companion
                long r18 = r1.m5549getZeroRKDOV3M()
                r1 = 1157296644(0x44faf204, float:2007.563)
                r5.startReplaceableGroup(r1)
                boolean r1 = r5.changed((java.lang.Object) r9)
                java.lang.Object r2 = r5.rememberedValue()
                if (r1 != 0) goto L_0x014d
                java.lang.Object r1 = r7.getEmpty()
                if (r2 != r1) goto L_0x0155
            L_0x014d:
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 r2 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
                r2.<init>(r9)
                r5.updateRememberedValue(r2)
            L_0x0155:
                r5.endReplaceableGroup()
                r21 = r2
                kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
                r22 = 0
                androidx.compose.material.DropdownMenuPositionProvider r1 = new androidx.compose.material.DropdownMenuPositionProvider
                r17 = r1
                r17.<init>(r18, r20, r21, r22)
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 r2 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
                r7 = r2
                r10 = r23
                r11 = r16
                r12 = r27
                r13 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13)
                r3 = -406650841(0xffffffffe7c30027, float:-1.8417285E24)
                r7 = 1
                androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r3, r7, r2)
                int r0 = r0 >> 3
                r0 = r0 & 14
                r7 = r0 | 384(0x180, float:5.38E-43)
                r8 = 0
                r0 = r25
                r3 = r5
                r4 = r7
                r7 = r5
                r5 = r8
                androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(r0, r1, r2, r3, r4, r5)
            L_0x018a:
                r4 = r16
            L_0x018c:
                androidx.compose.runtime.ScopeUpdateScope r8 = r7.endRestartGroup()
                if (r8 != 0) goto L_0x0193
                goto L_0x01a8
            L_0x0193:
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 r9 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
                r0 = r9
                r1 = r23
                r2 = r24
                r3 = r25
                r5 = r27
                r6 = r29
                r7 = r30
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                r8.updateScope(r9)
            L_0x01a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
        }

        public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = true;
                }
                return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    void ExposedDropdownMenu(boolean z11, @NotNull Function0<Unit> function0, @Nullable Modifier modifier, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12);

    @NotNull
    Modifier exposedDropdownSize(@NotNull Modifier modifier, boolean z11);
}
