package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aa\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d1  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: DropdownMenu-ILWXrKs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1081DropdownMenuILWXrKs(boolean r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, long r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.PopupProperties r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r7 = r25
            r8 = r30
            r9 = r32
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -840283139(0xffffffffcdea4bfd, float:-4.91356064E8)
            r1 = r31
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r33 & 1
            r1 = 2
            if (r0 == 0) goto L_0x0023
            r0 = r9 | 6
            r11 = r24
            goto L_0x0035
        L_0x0023:
            r0 = r9 & 14
            r11 = r24
            if (r0 != 0) goto L_0x0034
            boolean r0 = r10.changed((boolean) r11)
            if (r0 == 0) goto L_0x0031
            r0 = 4
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            r0 = r0 | r9
            goto L_0x0035
        L_0x0034:
            r0 = r9
        L_0x0035:
            r2 = r33 & 2
            if (r2 == 0) goto L_0x003c
            r0 = r0 | 48
            goto L_0x004c
        L_0x003c:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            boolean r2 = r10.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0049
            r2 = 32
            goto L_0x004b
        L_0x0049:
            r2 = 16
        L_0x004b:
            r0 = r0 | r2
        L_0x004c:
            r2 = r33 & 4
            if (r2 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0066
            r3 = r26
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0062
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r4
            goto L_0x0068
        L_0x0066:
            r3 = r26
        L_0x0068:
            r4 = r33 & 8
            if (r4 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r5 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0082
            r5 = r27
            boolean r12 = r10.changed((long) r5)
            if (r12 == 0) goto L_0x007e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r12
            goto L_0x0084
        L_0x0082:
            r5 = r27
        L_0x0084:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x009f
            r12 = r33 & 16
            if (r12 != 0) goto L_0x0099
            r12 = r29
            boolean r13 = r10.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x009b
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x0099:
            r12 = r29
        L_0x009b:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r0 = r0 | r13
            goto L_0x00a1
        L_0x009f:
            r12 = r29
        L_0x00a1:
            r13 = r33 & 32
            if (r13 == 0) goto L_0x00a9
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x00a7:
            r0 = r0 | r13
            goto L_0x00ba
        L_0x00a9:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00ba
            boolean r13 = r10.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x00b7
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a7
        L_0x00b7:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a7
        L_0x00ba:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r0
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00d1
            boolean r13 = r10.getSkipping()
            if (r13 != 0) goto L_0x00ca
            goto L_0x00d1
        L_0x00ca:
            r10.skipToGroupEnd()
            r4 = r5
            r6 = r12
            goto L_0x0203
        L_0x00d1:
            r10.startDefaults()
            r13 = r9 & 1
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            if (r13 == 0) goto L_0x00f1
            boolean r13 = r10.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00e2
            goto L_0x00f1
        L_0x00e2:
            r10.skipToGroupEnd()
            r2 = r33 & 16
            if (r2 == 0) goto L_0x00ea
            r0 = r0 & r14
        L_0x00ea:
            r19 = r5
            r21 = r12
            r6 = r0
            r12 = r3
            goto L_0x0131
        L_0x00f1:
            if (r2 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x00f7
        L_0x00f6:
            r2 = r3
        L_0x00f7:
            if (r4 == 0) goto L_0x0108
            r3 = 0
            float r3 = (float) r3
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            long r3 = androidx.compose.ui.unit.DpKt.m5499DpOffsetYgX7TsA(r4, r3)
            goto L_0x0109
        L_0x0108:
            r3 = r5
        L_0x0109:
            r5 = r33 & 16
            if (r5 == 0) goto L_0x012b
            androidx.compose.ui.window.PopupProperties r5 = new androidx.compose.ui.window.PopupProperties
            r16 = 1
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 62
            r23 = 0
            r15 = r5
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r0 & r14
            r6 = r0
            r12 = r2
            r19 = r3
            r21 = r5
            goto L_0x0131
        L_0x012b:
            r6 = r0
            r19 = r3
            r21 = r12
            r12 = r2
        L_0x0131:
            r10.endDefaults()
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x0150
            androidx.compose.animation.core.MutableTransitionState r2 = new androidx.compose.animation.core.MutableTransitionState
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r2.<init>(r4)
            r10.updateRememberedValue(r2)
        L_0x0150:
            r10.endReplaceableGroup()
            androidx.compose.animation.core.MutableTransitionState r2 = (androidx.compose.animation.core.MutableTransitionState) r2
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r24)
            r2.setTargetState(r4)
            java.lang.Object r4 = r2.getCurrentState()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0174
            java.lang.Object r4 = r2.getTargetState()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01fe
        L_0x0174:
            r10.startReplaceableGroup(r0)
            java.lang.Object r0 = r10.rememberedValue()
            java.lang.Object r4 = r3.getEmpty()
            if (r0 != r4) goto L_0x0193
            androidx.compose.ui.graphics.TransformOrigin$Companion r0 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r4 = r0.m3292getCenterSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r4)
            r4 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r4, r1, r4)
            r10.updateRememberedValue(r0)
        L_0x0193:
            r10.endReplaceableGroup()
            r4 = r0
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r10.consume(r0)
            r16 = r0
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            r0 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r0)
            boolean r0 = r10.changed((java.lang.Object) r4)
            java.lang.Object r1 = r10.rememberedValue()
            if (r0 != 0) goto L_0x01bb
            java.lang.Object r0 = r3.getEmpty()
            if (r1 != r0) goto L_0x01c3
        L_0x01bb:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 r1 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            r1.<init>(r4)
            r10.updateRememberedValue(r1)
        L_0x01c3:
            r10.endReplaceableGroup()
            r17 = r1
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            r18 = 0
            androidx.compose.material.DropdownMenuPositionProvider r22 = new androidx.compose.material.DropdownMenuPositionProvider
            r13 = r22
            r14 = r19
            r13.<init>(r14, r16, r17, r18)
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1 r13 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
            r0 = r13
            r1 = r2
            r2 = r4
            r3 = r12
            r4 = r30
            r5 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 79632374(0x4bf17f6, float:4.492589E-36)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r0, r1, r13)
            r0 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r6 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r5 = r0 | r1
            r6 = 0
            r0 = r22
            r1 = r25
            r2 = r21
            r4 = r10
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r0, r1, r2, r3, r4, r5, r6)
        L_0x01fe:
            r3 = r12
            r4 = r19
            r6 = r21
        L_0x0203:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x020a
            goto L_0x021d
        L_0x020a:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2 r12 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
            r0 = r12
            r1 = r24
            r2 = r25
            r7 = r30
            r8 = r32
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r10.updateScope(r12)
        L_0x021d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m1081DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItem(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, boolean r19, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r20, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r21, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r9 = r17
            r10 = r22
            r11 = r24
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1988562892(0xffffffff8978f034, float:-2.9964857E-33)
            r1 = r23
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r25 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r11 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r12.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r11
            goto L_0x0030
        L_0x002f:
            r0 = r11
        L_0x0030:
            r1 = r25 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r18
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
            goto L_0x004c
        L_0x004a:
            r2 = r18
        L_0x004c:
            r3 = r25 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r19
            boolean r5 = r12.changed((boolean) r4)
            if (r5 == 0) goto L_0x0062
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r5
            goto L_0x0068
        L_0x0066:
            r4 = r19
        L_0x0068:
            r5 = r25 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r20
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r7
            goto L_0x0084
        L_0x0082:
            r6 = r20
        L_0x0084:
            r7 = r25 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r13 = r11 & r8
            if (r13 != 0) goto L_0x00a1
            r13 = r21
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009d
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r14
            goto L_0x00a3
        L_0x00a1:
            r13 = r21
        L_0x00a3:
            r14 = r25 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ad
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00ab:
            r0 = r0 | r14
            goto L_0x00bd
        L_0x00ad:
            r14 = r11 & r15
            if (r14 != 0) goto L_0x00bd
            boolean r14 = r12.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x00ba
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ab
        L_0x00ba:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ab
        L_0x00bd:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r0
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00d5
            boolean r14 = r12.getSkipping()
            if (r14 != 0) goto L_0x00cd
            goto L_0x00d5
        L_0x00cd:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r13
            goto L_0x0136
        L_0x00d5:
            if (r1 == 0) goto L_0x00db
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r14 = r1
            goto L_0x00dc
        L_0x00db:
            r14 = r2
        L_0x00dc:
            if (r3 == 0) goto L_0x00e1
            r1 = 1
            r15 = r1
            goto L_0x00e2
        L_0x00e1:
            r15 = r4
        L_0x00e2:
            if (r5 == 0) goto L_0x00ed
            androidx.compose.material.MenuDefaults r1 = androidx.compose.material.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getDropdownMenuItemContentPadding()
            r16 = r1
            goto L_0x00ef
        L_0x00ed:
            r16 = r6
        L_0x00ef:
            if (r7 == 0) goto L_0x0110
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r1)
            java.lang.Object r1 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x010a
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r1)
        L_0x010a:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r13 = r1
        L_0x0110:
            r1 = r0 & 14
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r8
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r7 = r1 | r0
            r8 = 0
            r0 = r17
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r13
            r5 = r22
            r6 = r12
            androidx.compose.material.MenuKt.DropdownMenuItemContent(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r5 = r13
            r2 = r14
            r3 = r15
            r4 = r16
        L_0x0136:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x013d
            goto L_0x014e
        L_0x013d:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2 r13 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2
            r0 = r13
            r1 = r17
            r6 = r22
            r7 = r24
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r12.updateScope(r13)
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
