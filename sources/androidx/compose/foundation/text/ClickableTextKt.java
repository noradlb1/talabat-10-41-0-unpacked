package androidx.compose.foundation.text;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ClickableTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: androidx.compose.foundation.text.ClickableTextKt$ClickableText$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: androidx.compose.ui.Modifier$Companion} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011b  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: ClickableText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m835ClickableText4YKlhWE(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.AnnotatedString r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r27, boolean r28, int r29, int r30, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r25
            r12 = r32
            r13 = r34
            r14 = r35
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            r1 = r33
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0022
            r1 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0031
            boolean r1 = r15.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x002e
            r1 = 4
            goto L_0x002f
        L_0x002e:
            r1 = 2
        L_0x002f:
            r1 = r1 | r13
            goto L_0x0032
        L_0x0031:
            r1 = r13
        L_0x0032:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x0039
            r1 = r1 | 48
            goto L_0x004c
        L_0x0039:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004c
            r4 = r26
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0048
            r5 = 32
            goto L_0x004a
        L_0x0048:
            r5 = 16
        L_0x004a:
            r1 = r1 | r5
            goto L_0x004e
        L_0x004c:
            r4 = r26
        L_0x004e:
            r5 = r14 & 4
            if (r5 == 0) goto L_0x0055
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0068
            r6 = r27
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0064
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r1 = r1 | r7
            goto L_0x006a
        L_0x0068:
            r6 = r27
        L_0x006a:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0071
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0084
            r8 = r28
            boolean r9 = r15.changed((boolean) r8)
            if (r9 == 0) goto L_0x0080
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r1 = r1 | r9
            goto L_0x0086
        L_0x0084:
            r8 = r28
        L_0x0086:
            r9 = r14 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r29
            goto L_0x00a5
        L_0x0092:
            r16 = r13 & r10
            r10 = r29
            if (r16 != 0) goto L_0x00a5
            boolean r16 = r15.changed((int) r10)
            if (r16 == 0) goto L_0x00a1
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r16
        L_0x00a5:
            r16 = r14 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b2
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r2 = r30
            goto L_0x00c5
        L_0x00b2:
            r18 = r13 & r17
            r2 = r30
            if (r18 != 0) goto L_0x00c5
            boolean r19 = r15.changed((int) r2)
            if (r19 == 0) goto L_0x00c1
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r1 = r1 | r19
        L_0x00c5:
            r19 = r14 & 64
            r20 = 3670016(0x380000, float:5.142788E-39)
            if (r19 == 0) goto L_0x00d2
            r21 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r21
            r0 = r31
            goto L_0x00e5
        L_0x00d2:
            r21 = r13 & r20
            r0 = r31
            if (r21 != 0) goto L_0x00e5
            boolean r22 = r15.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x00e1
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r1 = r1 | r22
        L_0x00e5:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00ed
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00eb:
            r1 = r1 | r0
            goto L_0x00fe
        L_0x00ed:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x00fe
            boolean r0 = r15.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x00fb
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00fb:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00eb
        L_0x00fe:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011b
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x010e
            goto L_0x011b
        L_0x010e:
            r15.skipToGroupEnd()
            r7 = r31
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r10
            r6 = r30
            goto L_0x021e
        L_0x011b:
            if (r3 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r4 = r0
        L_0x0120:
            if (r5 == 0) goto L_0x012b
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r22 = r0
            goto L_0x012d
        L_0x012b:
            r22 = r6
        L_0x012d:
            if (r7 == 0) goto L_0x0133
            r0 = 1
            r23 = r0
            goto L_0x0135
        L_0x0133:
            r23 = r8
        L_0x0135:
            if (r9 == 0) goto L_0x0140
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m5402getClipgIe3tQ8()
            r24 = r0
            goto L_0x0142
        L_0x0140:
            r24 = r10
        L_0x0142:
            if (r16 == 0) goto L_0x014a
            r0 = 2147483647(0x7fffffff, float:NaN)
            r16 = r0
            goto L_0x014c
        L_0x014a:
            r16 = r30
        L_0x014c:
            if (r19 == 0) goto L_0x0152
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$1 r0 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$1.INSTANCE
            r10 = r0
            goto L_0x0154
        L_0x0152:
            r10 = r31
        L_0x0154:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0163
            r0 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:63)"
            r3 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0163:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r0)
            java.lang.Object r0 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r2.getEmpty()
            r5 = 0
            if (r0 != r3) goto L_0x017e
            r3 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r5, r3, r5)
            r15.updateRememberedValue(r0)
        L_0x017e:
            r15.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r6)
            boolean r7 = r15.changed((java.lang.Object) r0)
            boolean r8 = r15.changed((java.lang.Object) r12)
            r7 = r7 | r8
            java.lang.Object r8 = r15.rememberedValue()
            if (r7 != 0) goto L_0x01a0
            java.lang.Object r7 = r2.getEmpty()
            if (r8 != r7) goto L_0x01a8
        L_0x01a0:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1 r8 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1
            r8.<init>(r0, r12, r5)
            r15.updateRememberedValue(r8)
        L_0x01a8:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r3, (java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8)
            androidx.compose.ui.Modifier r3 = r4.then(r3)
            r15.startReplaceableGroup(r6)
            boolean r5 = r15.changed((java.lang.Object) r0)
            boolean r6 = r15.changed((java.lang.Object) r10)
            r5 = r5 | r6
            java.lang.Object r6 = r15.rememberedValue()
            if (r5 != 0) goto L_0x01cd
            java.lang.Object r2 = r2.getEmpty()
            if (r6 != r2) goto L_0x01d5
        L_0x01cd:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1 r6 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            r6.<init>(r0, r10)
            r15.updateRememberedValue(r6)
        L_0x01d5:
            r15.endReplaceableGroup()
            r5 = r6
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r7 = 0
            r0 = r1 & 14
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            int r2 = r1 << 6
            r2 = r2 & r17
            r0 = r0 | r2
            int r1 = r1 << 3
            r1 = r1 & r20
            r9 = r0 | r1
            r17 = 128(0x80, float:1.794E-43)
            r0 = r25
            r1 = r3
            r2 = r22
            r3 = r5
            r18 = r4
            r4 = r24
            r5 = r23
            r6 = r16
            r8 = r15
            r19 = r10
            r10 = r17
            androidx.compose.foundation.text.BasicTextKt.m833BasicText4YKlhWE(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0212
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0212:
            r6 = r16
            r2 = r18
            r7 = r19
            r3 = r22
            r4 = r23
            r5 = r24
        L_0x021e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0225
            goto L_0x0237
        L_0x0225:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$3 r10 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
            r0 = r10
            r1 = r25
            r8 = r32
            r9 = r34
            r11 = r10
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r15.updateScope(r11)
        L_0x0237:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m835ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
