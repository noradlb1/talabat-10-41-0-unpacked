package com.designsystem.ds_search_field;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a}\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"DSSearchField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "onTextChange", "Lkotlin/Function1;", "onKeyboardSearchButtonTap", "Lkotlin/Function0;", "onClearButtonTap", "hint", "delay", "", "thresholdLetterCount", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;JILandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSearchFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$1$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$1$1$1} */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x020b, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x020d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0122  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSSearchField(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r27, @org.jetbrains.annotations.Nullable java.lang.String r28, long r29, int r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r10 = r33
            r11 = r34
            r0 = -1627460380(0xffffffff9efeece4, float:-2.6991272E-20)
            r1 = r32
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0017
            r4 = r10 | 6
            r5 = r4
            r4 = r23
            goto L_0x002b
        L_0x0017:
            r4 = r10 & 14
            if (r4 != 0) goto L_0x0028
            r4 = r23
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0025
            r5 = 4
            goto L_0x0026
        L_0x0025:
            r5 = 2
        L_0x0026:
            r5 = r5 | r10
            goto L_0x002b
        L_0x0028:
            r4 = r23
            r5 = r10
        L_0x002b:
            r6 = r11 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r10 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0045
            r7 = r24
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r5 = r5 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r24
        L_0x0047:
            r8 = r11 & 4
            if (r8 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r9 = r10 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0061
            r9 = r25
            boolean r12 = r0.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x005d
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r12 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r5 = r5 | r12
            goto L_0x0063
        L_0x0061:
            r9 = r25
        L_0x0063:
            r12 = r11 & 8
            if (r12 == 0) goto L_0x006a
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x007d
            r13 = r26
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0079
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r5 = r5 | r14
            goto L_0x007f
        L_0x007d:
            r13 = r26
        L_0x007f:
            r14 = r11 & 16
            if (r14 == 0) goto L_0x0086
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0086:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x009c
            r15 = r27
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0097
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r5 = r5 | r16
            goto L_0x009e
        L_0x009c:
            r15 = r27
        L_0x009e:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x00a9
            r17 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r17
            r2 = r28
            goto L_0x00be
        L_0x00a9:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r10 & r17
            r2 = r28
            if (r17 != 0) goto L_0x00be
            boolean r17 = r0.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00ba
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r5 = r5 | r17
        L_0x00be:
            r17 = r11 & 64
            if (r17 == 0) goto L_0x00c9
            r18 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r18
            r3 = r29
            goto L_0x00de
        L_0x00c9:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r10 & r18
            r3 = r29
            if (r18 != 0) goto L_0x00de
            boolean r19 = r0.changed((long) r3)
            if (r19 == 0) goto L_0x00da
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r5 = r5 | r19
        L_0x00de:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e9
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r19
            r3 = r31
            goto L_0x00fd
        L_0x00e9:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r10 & r19
            r3 = r31
            if (r19 != 0) goto L_0x00fd
            boolean r4 = r0.changed((int) r3)
            if (r4 == 0) goto L_0x00fa
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r4 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r5 = r5 | r4
        L_0x00fd:
            r4 = 23967451(0x16db6db, float:4.3661218E-38)
            r4 = r4 & r5
            r19 = 4793490(0x492492, float:6.71711E-39)
            r4 = r4 ^ r19
            if (r4 != 0) goto L_0x0122
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x010f
            goto L_0x0122
        L_0x010f:
            r0.skipToGroupEnd()
            r1 = r23
            r6 = r28
            r2 = r7
            r4 = r13
            r5 = r15
            r7 = r29
        L_0x011b:
            r22 = r9
            r9 = r3
            r3 = r22
            goto L_0x025a
        L_0x0122:
            if (r1 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0129
        L_0x0127:
            r1 = r23
        L_0x0129:
            if (r6 == 0) goto L_0x012e
            java.lang.String r4 = ""
            goto L_0x012f
        L_0x012e:
            r4 = r7
        L_0x012f:
            r6 = 0
            if (r8 == 0) goto L_0x0133
            r9 = r6
        L_0x0133:
            if (r12 == 0) goto L_0x0136
            r13 = r6
        L_0x0136:
            if (r14 == 0) goto L_0x0139
            r15 = r6
        L_0x0139:
            if (r16 == 0) goto L_0x013d
            r7 = r6
            goto L_0x013f
        L_0x013d:
            r7 = r28
        L_0x013f:
            r19 = 0
            if (r17 == 0) goto L_0x0146
            r16 = r19
            goto L_0x0148
        L_0x0146:
            r16 = r29
        L_0x0148:
            if (r2 == 0) goto L_0x014b
            r3 = 0
        L_0x014b:
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r2)
            java.lang.Object r12 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r14.getEmpty()
            if (r12 != r8) goto L_0x0166
            r8 = 2
            androidx.compose.runtime.MutableState r12 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r6, r8, r6)
            r0.updateRememberedValue(r12)
            goto L_0x0167
        L_0x0166:
            r8 = 2
        L_0x0167:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r12 = (androidx.compose.runtime.MutableState) r12
            r0.startReplaceableGroup(r2)
            java.lang.Object r2 = r0.rememberedValue()
            r21 = r4
            java.lang.Object r4 = r14.getEmpty()
            if (r2 != r4) goto L_0x0182
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r6, r8, r6)
            r0.updateRememberedValue(r2)
        L_0x0182:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r4)
            java.lang.Object r4 = r0.rememberedValue()
            java.lang.Object r14 = r14.getEmpty()
            if (r4 != r14) goto L_0x01a2
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r6, r8, r6)
            r0.updateRememberedValue(r4)
        L_0x01a2:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.ui.focus.FocusManager r6 = (androidx.compose.ui.focus.FocusManager) r6
            if (r9 != 0) goto L_0x01be
            r4 = 1088354838(0x40defa16, float:6.968028)
            r0.startReplaceableGroup(r4)
        L_0x01b9:
            r0.endReplaceableGroup()
            goto L_0x022e
        L_0x01be:
            r14 = -1627459765(0xffffffff9efeef4b, float:-2.6992265E-20)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = m8555DSSearchField$lambda4(r2)
            r8 = 5
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r20 = 0
            r10[r20] = r2
            java.lang.Integer r20 = java.lang.Integer.valueOf(r3)
            r19 = 1
            r10[r19] = r20
            java.lang.Long r20 = java.lang.Long.valueOf(r16)
            r18 = 2
            r10[r18] = r20
            r18 = 3
            r10[r18] = r4
            r18 = 4
            r10[r18] = r9
            r8 = -3685570(0xffffffffffc7c33e, float:NaN)
            r0.startReplaceableGroup(r8)
            r8 = 0
            r11 = 5
            r20 = 0
        L_0x01f1:
            if (r8 >= r11) goto L_0x01ff
            r11 = r10[r8]
            int r8 = r8 + 1
            boolean r11 = r0.changed((java.lang.Object) r11)
            r20 = r20 | r11
            r11 = 5
            goto L_0x01f1
        L_0x01ff:
            java.lang.Object r8 = r0.rememberedValue()
            if (r20 != 0) goto L_0x020d
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r8 != r10) goto L_0x0224
        L_0x020d:
            com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$1$1$1 r8 = new com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$1$1$1
            r10 = 0
            r23 = r8
            r24 = r2
            r25 = r3
            r26 = r16
            r28 = r9
            r29 = r4
            r30 = r10
            r23.<init>(r24, r25, r26, r28, r29, r30)
            r0.updateRememberedValue(r8)
        L_0x0224:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r4 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8, (androidx.compose.runtime.Composer) r0, (int) r4)
            goto L_0x01b9
        L_0x022e:
            com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2 r4 = new com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2
            r23 = r4
            r24 = r1
            r25 = r12
            r26 = r2
            r27 = r6
            r28 = r13
            r29 = r7
            r30 = r15
            r31 = r5
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31)
            r2 = -819894012(0xffffffffcf216904, float:-2.70801408E9)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r5, r4)
            r4 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r2, r0, r4)
            r6 = r7
            r4 = r13
            r5 = r15
            r7 = r16
            r2 = r21
            goto L_0x011b
        L_0x025a:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x0261
            goto L_0x026e
        L_0x0261:
            com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$3 r13 = new com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$3
            r0 = r13
            r10 = r33
            r11 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11)
            r12.updateScope(r13)
        L_0x026e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_search_field.DSSearchFieldKt.DSSearchField(androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, java.lang.String, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSearchField$lambda-1  reason: not valid java name */
    public static final String m8553DSSearchField$lambda1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSearchField$lambda-2  reason: not valid java name */
    public static final void m8554DSSearchField$lambda2(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSearchField$lambda-4  reason: not valid java name */
    public static final String m8555DSSearchField$lambda4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSearchField$lambda-5  reason: not valid java name */
    public static final void m8556DSSearchField$lambda5(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSearchField$lambda-7  reason: not valid java name */
    public static final long m8557DSSearchField$lambda7(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSearchField$lambda-8  reason: not valid java name */
    public static final void m8558DSSearchField$lambda8(MutableState<Long> mutableState, long j11) {
        mutableState.setValue(Long.valueOf(j11));
    }
}
