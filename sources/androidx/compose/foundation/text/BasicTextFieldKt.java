package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020#2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BasicTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v3, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v4, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v5, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v6, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b2, code lost:
        if (r3.changed((java.lang.Object) r52) != false) goto L_0x01b9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0137  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(@org.jetbrains.annotations.NotNull java.lang.String r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r40, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r41, boolean r42, boolean r43, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r44, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r45, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r46, boolean r47, int r48, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r49, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r50, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r51, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Brush r52, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r54, int r55, int r56, int r57) {
        /*
            r1 = r39
            r2 = r40
            r15 = r55
            r14 = r56
            r13 = r57
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            r3 = r54
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            r4 = r13 & 1
            if (r4 == 0) goto L_0x0024
            r4 = r15 | 6
            goto L_0x0034
        L_0x0024:
            r4 = r15 & 14
            if (r4 != 0) goto L_0x0033
            boolean r4 = r3.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r4 = r4 | r15
            goto L_0x0034
        L_0x0033:
            r4 = r15
        L_0x0034:
            r7 = r13 & 2
            if (r7 == 0) goto L_0x003b
            r4 = r4 | 48
            goto L_0x004b
        L_0x003b:
            r7 = r15 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004b
            boolean r7 = r3.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r4 = r4 | r7
        L_0x004b:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0052
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0052:
            r12 = r15 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x0066
            r12 = r41
            boolean r16 = r3.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r16
            goto L_0x0068
        L_0x0066:
            r12 = r41
        L_0x0068:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0073
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0073:
            r5 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0087
            r5 = r42
            boolean r19 = r3.changed((boolean) r5)
            if (r19 == 0) goto L_0x0082
            r19 = r17
            goto L_0x0084
        L_0x0082:
            r19 = r18
        L_0x0084:
            r4 = r4 | r19
            goto L_0x0089
        L_0x0087:
            r5 = r42
        L_0x0089:
            r19 = r13 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0099
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r8 = r43
            goto L_0x00ac
        L_0x0099:
            r23 = r15 & r21
            r8 = r43
            if (r23 != 0) goto L_0x00ac
            boolean r24 = r3.changed((boolean) r8)
            if (r24 == 0) goto L_0x00a8
            r24 = r20
            goto L_0x00aa
        L_0x00a8:
            r24 = r22
        L_0x00aa:
            r4 = r4 | r24
        L_0x00ac:
            r24 = r13 & 32
            if (r24 == 0) goto L_0x00b7
            r25 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r25
            r9 = r44
            goto L_0x00cc
        L_0x00b7:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r15 & r25
            r9 = r44
            if (r25 != 0) goto L_0x00cc
            boolean r26 = r3.changed((java.lang.Object) r9)
            if (r26 == 0) goto L_0x00c8
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r4 = r4 | r26
        L_0x00cc:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00d7
            r27 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r27
            r10 = r45
            goto L_0x00ec
        L_0x00d7:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r10 = r45
            if (r27 != 0) goto L_0x00ec
            boolean r28 = r3.changed((java.lang.Object) r10)
            if (r28 == 0) goto L_0x00e8
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r4 = r4 | r28
        L_0x00ec:
            r11 = r13 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x00f7
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r29
            r6 = r46
            goto L_0x010c
        L_0x00f7:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r6 = r46
            if (r29 != 0) goto L_0x010c
            boolean r30 = r3.changed((java.lang.Object) r6)
            if (r30 == 0) goto L_0x0108
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r4 = r4 | r30
        L_0x010c:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0117
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r31
            r5 = r47
            goto L_0x012c
        L_0x0117:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r15 & r31
            r5 = r47
            if (r31 != 0) goto L_0x012c
            boolean r31 = r3.changed((boolean) r5)
            if (r31 == 0) goto L_0x0128
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r4 = r4 | r31
        L_0x012c:
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0137
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r4 = r4 | r31
            r6 = r48
            goto L_0x014c
        L_0x0137:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r15 & r31
            r6 = r48
            if (r31 != 0) goto L_0x014c
            boolean r31 = r3.changed((int) r6)
            if (r31 == 0) goto L_0x0148
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014a
        L_0x0148:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014a:
            r4 = r4 | r31
        L_0x014c:
            r6 = r13 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0155
            r31 = r14 | 6
            r8 = r49
            goto L_0x016b
        L_0x0155:
            r31 = r14 & 14
            r8 = r49
            if (r31 != 0) goto L_0x0169
            boolean r31 = r3.changed((java.lang.Object) r8)
            if (r31 == 0) goto L_0x0164
            r31 = 4
            goto L_0x0166
        L_0x0164:
            r31 = 2
        L_0x0166:
            r31 = r14 | r31
            goto L_0x016b
        L_0x0169:
            r31 = r14
        L_0x016b:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0172
            r31 = r31 | 48
            goto L_0x0185
        L_0x0172:
            r32 = r14 & 112(0x70, float:1.57E-43)
            r9 = r50
            if (r32 != 0) goto L_0x0185
            boolean r32 = r3.changed((java.lang.Object) r9)
            if (r32 == 0) goto L_0x0181
            r23 = 32
            goto L_0x0183
        L_0x0181:
            r23 = 16
        L_0x0183:
            r31 = r31 | r23
        L_0x0185:
            r9 = r31
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x018e
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x01a2
        L_0x018e:
            r12 = r14 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01a2
            r12 = r51
            boolean r23 = r3.changed((java.lang.Object) r12)
            if (r23 == 0) goto L_0x019d
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x019f
        L_0x019d:
            r27 = 128(0x80, float:1.794E-43)
        L_0x019f:
            r9 = r9 | r27
            goto L_0x01a4
        L_0x01a2:
            r12 = r51
        L_0x01a4:
            r12 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01bc
            r12 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r12 != 0) goto L_0x01b5
            r12 = r52
            boolean r23 = r3.changed((java.lang.Object) r12)
            if (r23 == 0) goto L_0x01b7
            goto L_0x01b9
        L_0x01b5:
            r12 = r52
        L_0x01b7:
            r17 = r18
        L_0x01b9:
            r9 = r9 | r17
            goto L_0x01be
        L_0x01bc:
            r12 = r52
        L_0x01be:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c7
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r14 = r53
            goto L_0x01d8
        L_0x01c7:
            r17 = r14 & r21
            r14 = r53
            if (r17 != 0) goto L_0x01d8
            boolean r17 = r3.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x01d4
            goto L_0x01d6
        L_0x01d4:
            r20 = r22
        L_0x01d6:
            r9 = r9 | r20
        L_0x01d8:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r14 = r4 & r17
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r14 != r2) goto L_0x0212
            r2 = 46811(0xb6db, float:6.5596E-41)
            r2 = r2 & r9
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r2 != r14) goto L_0x0212
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x01f1
            goto L_0x0212
        L_0x01f1:
            r3.skipToGroupEnd()
            r6 = r40
            r4 = r41
            r5 = r42
            r7 = r43
            r8 = r44
            r9 = r45
            r10 = r46
            r11 = r47
            r12 = r48
            r13 = r49
            r14 = r50
            r15 = r51
            r35 = r52
            r36 = r53
            goto L_0x045f
        L_0x0212:
            r3.startDefaults()
            r2 = r15 & 1
            r17 = 1
            if (r2 == 0) goto L_0x0245
            boolean r2 = r3.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0222
            goto L_0x0245
        L_0x0222:
            r3.skipToGroupEnd()
            r0 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x022b
            r9 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x022b:
            r2 = r41
            r7 = r42
            r0 = r43
            r5 = r44
            r6 = r45
            r11 = r46
            r8 = r47
            r10 = r49
            r12 = r50
            r14 = r51
            r35 = r52
            r36 = r53
            goto L_0x02ff
        L_0x0245:
            if (r7 == 0) goto L_0x024a
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x024c
        L_0x024a:
            r2 = r41
        L_0x024c:
            if (r16 == 0) goto L_0x0251
            r7 = r17
            goto L_0x0253
        L_0x0251:
            r7 = r42
        L_0x0253:
            if (r19 == 0) goto L_0x0258
            r16 = 0
            goto L_0x025a
        L_0x0258:
            r16 = r43
        L_0x025a:
            if (r24 == 0) goto L_0x0263
            androidx.compose.ui.text.TextStyle$Companion r18 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r18 = r18.getDefault()
            goto L_0x0265
        L_0x0263:
            r18 = r44
        L_0x0265:
            if (r26 == 0) goto L_0x026e
            androidx.compose.foundation.text.KeyboardOptions$Companion r19 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r19 = r19.getDefault()
            goto L_0x0270
        L_0x026e:
            r19 = r45
        L_0x0270:
            if (r11 == 0) goto L_0x0279
            androidx.compose.foundation.text.KeyboardActions$Companion r11 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r11 = r11.getDefault()
            goto L_0x027b
        L_0x0279:
            r11 = r46
        L_0x027b:
            if (r0 == 0) goto L_0x027f
            r0 = 0
            goto L_0x0281
        L_0x027f:
            r0 = r47
        L_0x0281:
            if (r5 == 0) goto L_0x0287
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0289
        L_0x0287:
            r5 = r48
        L_0x0289:
            if (r6 == 0) goto L_0x0292
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x0294
        L_0x0292:
            r6 = r49
        L_0x0294:
            if (r8 == 0) goto L_0x0299
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1 r8 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1.INSTANCE
            goto L_0x029b
        L_0x0299:
            r8 = r50
        L_0x029b:
            if (r10 == 0) goto L_0x02bc
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r10)
            java.lang.Object r10 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r20.getEmpty()
            if (r10 != r14) goto L_0x02b6
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r10)
        L_0x02b6:
            r3.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = (androidx.compose.foundation.interaction.MutableInteractionSource) r10
            goto L_0x02be
        L_0x02bc:
            r10 = r51
        L_0x02be:
            r14 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x02d8
            androidx.compose.ui.graphics.SolidColor r14 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            r41 = r5
            r42 = r6
            long r5 = r20.m2945getBlack0d7_KjU()
            r43 = r0
            r0 = 0
            r14.<init>(r5, r0)
            r0 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r0
            goto L_0x02e0
        L_0x02d8:
            r43 = r0
            r41 = r5
            r42 = r6
            r14 = r52
        L_0x02e0:
            if (r12 == 0) goto L_0x02ed
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r0 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m837getLambda1$foundation_release()
            r48 = r41
            r36 = r0
            goto L_0x02f1
        L_0x02ed:
            r48 = r41
            r36 = r53
        L_0x02f1:
            r12 = r8
            r35 = r14
            r0 = r16
            r5 = r18
            r6 = r19
            r8 = r43
            r14 = r10
            r10 = r42
        L_0x02ff:
            r3.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0310
            java.lang.String r13 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:121)"
            r15 = -454732590(0xffffffffe4e554d2, float:-3.384333E22)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r4, r9, r13)
        L_0x0310:
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r13)
            java.lang.Object r13 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            r49 = r0
            java.lang.Object r0 = r15.getEmpty()
            if (r13 != r0) goto L_0x0349
            androidx.compose.ui.text.input.TextFieldValue r0 = new androidx.compose.ui.text.input.TextFieldValue
            r18 = 0
            r13 = 0
            r16 = 6
            r20 = 0
            r41 = r0
            r42 = r39
            r43 = r18
            r45 = r13
            r46 = r16
            r47 = r20
            r41.<init>((java.lang.String) r42, (long) r43, (androidx.compose.ui.text.TextRange) r45, (int) r46, (kotlin.jvm.internal.DefaultConstructorMarker) r47)
            r50 = r7
            r7 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r13, r7, r13)
            r3.updateRememberedValue(r0)
            r13 = r0
            goto L_0x034b
        L_0x0349:
            r50 = r7
        L_0x034b:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            androidx.compose.ui.text.input.TextFieldValue r0 = m825BasicTextField$lambda2(r13)
            r18 = 0
            r7 = 0
            r16 = 6
            r20 = 0
            r41 = r0
            r42 = r39
            r43 = r18
            r45 = r7
            r46 = r16
            r47 = r20
            androidx.compose.ui.text.input.TextFieldValue r0 = androidx.compose.ui.text.input.TextFieldValue.m5230copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r41, (java.lang.String) r42, (long) r43, (androidx.compose.ui.text.TextRange) r45, (int) r46, (java.lang.Object) r47)
            r7 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r7)
            boolean r7 = r3.changed((java.lang.Object) r0)
            boolean r16 = r3.changed((java.lang.Object) r13)
            r7 = r7 | r16
            r41 = r11
            java.lang.Object r11 = r3.rememberedValue()
            if (r7 != 0) goto L_0x0389
            java.lang.Object r7 = r15.getEmpty()
            if (r11 != r7) goto L_0x0391
        L_0x0389:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1 r11 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            r11.<init>(r0, r13)
            r3.updateRememberedValue(r11)
        L_0x0391:
            r3.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r7 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r11, r3, r7)
            r7 = 1157296644(0x44faf204, float:2007.563)
            r3.startReplaceableGroup(r7)
            boolean r7 = r3.changed((java.lang.Object) r1)
            java.lang.Object r11 = r3.rememberedValue()
            if (r7 != 0) goto L_0x03b0
            java.lang.Object r7 = r15.getEmpty()
            if (r11 != r7) goto L_0x03b9
        L_0x03b0:
            r7 = 0
            r11 = 2
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r7, r11, r7)
            r3.updateRememberedValue(r11)
        L_0x03b9:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            androidx.compose.ui.text.input.ImeOptions r26 = r6.toImeOptions$foundation_release(r8)
            r24 = r8 ^ 1
            if (r8 == 0) goto L_0x03c9
            r25 = r17
            goto L_0x03cb
        L_0x03c9:
            r25 = r48
        L_0x03cb:
            r7 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r7)
            boolean r7 = r3.changed((java.lang.Object) r13)
            boolean r16 = r3.changed((java.lang.Object) r11)
            r7 = r7 | r16
            r42 = r6
            r6 = r40
            boolean r16 = r3.changed((java.lang.Object) r6)
            r7 = r7 | r16
            java.lang.Object r1 = r3.rememberedValue()
            if (r7 != 0) goto L_0x03f1
            java.lang.Object r7 = r15.getEmpty()
            if (r1 != r7) goto L_0x03f9
        L_0x03f1:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
            r1.<init>(r6, r13, r11)
            r3.updateRememberedValue(r1)
        L_0x03f9:
            r3.endReplaceableGroup()
            r17 = r1
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r1 = r4 & 896(0x380, float:1.256E-42)
            int r7 = r4 >> 6
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r7
            int r7 = r9 << 12
            r11 = r7 & r21
            r1 = r1 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r7
            r1 = r1 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r7
            r1 = r1 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r11
            r32 = r1 | r7
            int r1 = r4 >> 18
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r4 = r4 >> 3
            r7 = r4 & 896(0x380, float:1.256E-42)
            r1 = r1 | r7
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r4
            r4 = r9 & r21
            r33 = r1 | r4
            r34 = 0
            r16 = r0
            r18 = r2
            r19 = r5
            r20 = r10
            r21 = r12
            r22 = r14
            r23 = r35
            r27 = r41
            r28 = r50
            r29 = r49
            r30 = r36
            r31 = r3
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x044f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x044f:
            r9 = r42
            r7 = r49
            r4 = r2
            r11 = r8
            r13 = r10
            r15 = r14
            r10 = r41
            r8 = r5
            r14 = r12
            r12 = r48
            r5 = r50
        L_0x045f:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x0466
            goto L_0x049a
        L_0x0466:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5 r2 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
            r0 = r2
            r1 = r39
            r37 = r2
            r2 = r40
            r6 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r10
            r10 = r12
            r12 = r11
            r11 = r13
            r13 = r12
            r12 = r14
            r14 = r13
            r13 = r15
            r15 = r14
            r14 = r35
            r38 = r15
            r15 = r36
            r16 = r55
            r17 = r56
            r18 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = r37
            r0 = r38
            r0.updateScope(r1)
        L_0x049a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-2  reason: not valid java name */
    public static final TextFieldValue m825BasicTextField$lambda2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-3  reason: not valid java name */
    public static final void m826BasicTextField$lambda3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-6  reason: not valid java name */
    public static final String m827BasicTextField$lambda6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-7  reason: not valid java name */
    public static final void m828BasicTextField$lambda7(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b2, code lost:
        if (r10.changed((java.lang.Object) r48) != false) goto L_0x01b9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0137  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, boolean r38, boolean r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r40, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r41, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r42, boolean r43, int r44, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r45, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r46, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r47, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Brush r48, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            r15 = r35
            r14 = r36
            r13 = r51
            r12 = r52
            r11 = r53
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            r1 = r50
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0024
            r1 = r13 | 6
            goto L_0x0034
        L_0x0024:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0033
            boolean r1 = r10.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x0030
            r1 = 4
            goto L_0x0031
        L_0x0030:
            r1 = 2
        L_0x0031:
            r1 = r1 | r13
            goto L_0x0034
        L_0x0033:
            r1 = r13
        L_0x0034:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x003b
            r1 = r1 | 48
            goto L_0x004b
        L_0x003b:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004b
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r1 = r1 | r4
        L_0x004b:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0052
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0052:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0066
            r9 = r37
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r16
            goto L_0x0068
        L_0x0066:
            r9 = r37
        L_0x0068:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0073
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0073:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0087
            r2 = r38
            boolean r19 = r10.changed((boolean) r2)
            if (r19 == 0) goto L_0x0082
            r19 = r17
            goto L_0x0084
        L_0x0082:
            r19 = r18
        L_0x0084:
            r1 = r1 | r19
            goto L_0x0089
        L_0x0087:
            r2 = r38
        L_0x0089:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 57344(0xe000, float:8.0356E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r3 = r39
            goto L_0x00ac
        L_0x0099:
            r23 = r13 & r21
            r3 = r39
            if (r23 != 0) goto L_0x00ac
            boolean r24 = r10.changed((boolean) r3)
            if (r24 == 0) goto L_0x00a8
            r24 = r20
            goto L_0x00aa
        L_0x00a8:
            r24 = r22
        L_0x00aa:
            r1 = r1 | r24
        L_0x00ac:
            r24 = r11 & 32
            r25 = 458752(0x70000, float:6.42848E-40)
            if (r24 == 0) goto L_0x00b9
            r26 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r26
            r5 = r40
            goto L_0x00cc
        L_0x00b9:
            r26 = r13 & r25
            r5 = r40
            if (r26 != 0) goto L_0x00cc
            boolean r27 = r10.changed((java.lang.Object) r5)
            if (r27 == 0) goto L_0x00c8
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r1 = r1 | r27
        L_0x00cc:
            r27 = r11 & 64
            if (r27 == 0) goto L_0x00d7
            r28 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r28
            r6 = r41
            goto L_0x00ec
        L_0x00d7:
            r28 = 3670016(0x380000, float:5.142788E-39)
            r28 = r13 & r28
            r6 = r41
            if (r28 != 0) goto L_0x00ec
            boolean r29 = r10.changed((java.lang.Object) r6)
            if (r29 == 0) goto L_0x00e8
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r1 = r1 | r29
        L_0x00ec:
            r7 = r11 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00f7
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r30
            r8 = r42
            goto L_0x010c
        L_0x00f7:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r13 & r30
            r8 = r42
            if (r30 != 0) goto L_0x010c
            boolean r31 = r10.changed((java.lang.Object) r8)
            if (r31 == 0) goto L_0x0108
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r1 = r1 | r31
        L_0x010c:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0117
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r32
            r2 = r43
            goto L_0x012c
        L_0x0117:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r13 & r32
            r2 = r43
            if (r32 != 0) goto L_0x012c
            boolean r32 = r10.changed((boolean) r2)
            if (r32 == 0) goto L_0x0128
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r1 = r1 | r32
        L_0x012c:
            r2 = r11 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0137
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r32
            r3 = r44
            goto L_0x014c
        L_0x0137:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r13 & r32
            r3 = r44
            if (r32 != 0) goto L_0x014c
            boolean r32 = r10.changed((int) r3)
            if (r32 == 0) goto L_0x0148
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014a
        L_0x0148:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014a:
            r1 = r1 | r32
        L_0x014c:
            r3 = r11 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0155
            r23 = r12 | 6
            r5 = r45
            goto L_0x016b
        L_0x0155:
            r32 = r12 & 14
            r5 = r45
            if (r32 != 0) goto L_0x0169
            boolean r32 = r10.changed((java.lang.Object) r5)
            if (r32 == 0) goto L_0x0164
            r23 = 4
            goto L_0x0166
        L_0x0164:
            r23 = 2
        L_0x0166:
            r23 = r12 | r23
            goto L_0x016b
        L_0x0169:
            r23 = r12
        L_0x016b:
            r5 = r11 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0172
            r23 = r23 | 48
            goto L_0x0185
        L_0x0172:
            r32 = r12 & 112(0x70, float:1.57E-43)
            r6 = r46
            if (r32 != 0) goto L_0x0185
            boolean r32 = r10.changed((java.lang.Object) r6)
            if (r32 == 0) goto L_0x0181
            r26 = 32
            goto L_0x0183
        L_0x0181:
            r26 = 16
        L_0x0183:
            r23 = r23 | r26
        L_0x0185:
            r6 = r23
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x018e
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x01a2
        L_0x018e:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01a2
            r9 = r47
            boolean r23 = r10.changed((java.lang.Object) r9)
            if (r23 == 0) goto L_0x019d
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x019f
        L_0x019d:
            r29 = 128(0x80, float:1.794E-43)
        L_0x019f:
            r6 = r6 | r29
            goto L_0x01a4
        L_0x01a2:
            r9 = r47
        L_0x01a4:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01bc
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01b5
            r9 = r48
            boolean r23 = r10.changed((java.lang.Object) r9)
            if (r23 == 0) goto L_0x01b7
            goto L_0x01b9
        L_0x01b5:
            r9 = r48
        L_0x01b7:
            r17 = r18
        L_0x01b9:
            r6 = r6 | r17
            goto L_0x01be
        L_0x01bc:
            r9 = r48
        L_0x01be:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01c7
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r12 = r49
            goto L_0x01d8
        L_0x01c7:
            r17 = r12 & r21
            r12 = r49
            if (r17 != 0) goto L_0x01d8
            boolean r17 = r10.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x01d4
            goto L_0x01d6
        L_0x01d4:
            r20 = r22
        L_0x01d6:
            r6 = r6 | r20
        L_0x01d8:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r17
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0212
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r6
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r14) goto L_0x0212
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x01f1
            goto L_0x0212
        L_0x01f1:
            r10.skipToGroupEnd()
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r41
            r8 = r42
            r9 = r43
            r11 = r45
            r12 = r46
            r13 = r47
            r14 = r48
            r15 = r49
            r21 = r10
            r10 = r44
            goto L_0x03c7
        L_0x0212:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x0245
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0220
            goto L_0x0245
        L_0x0220:
            r10.skipToGroupEnd()
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0229
            r6 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0229:
            r19 = r37
            r20 = r38
            r22 = r39
            r23 = r40
            r14 = r41
            r24 = r42
            r12 = r43
            r26 = r44
            r27 = r45
            r28 = r46
            r29 = r47
            r30 = r48
            r32 = r49
            goto L_0x0308
        L_0x0245:
            if (r4 == 0) goto L_0x024a
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            goto L_0x024c
        L_0x024a:
            r4 = r37
        L_0x024c:
            if (r16 == 0) goto L_0x0250
            r12 = 1
            goto L_0x0252
        L_0x0250:
            r12 = r38
        L_0x0252:
            if (r19 == 0) goto L_0x0257
            r16 = 0
            goto L_0x0259
        L_0x0257:
            r16 = r39
        L_0x0259:
            if (r24 == 0) goto L_0x0262
            androidx.compose.ui.text.TextStyle$Companion r17 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r17 = r17.getDefault()
            goto L_0x0264
        L_0x0262:
            r17 = r40
        L_0x0264:
            if (r27 == 0) goto L_0x026d
            androidx.compose.foundation.text.KeyboardOptions$Companion r18 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r18 = r18.getDefault()
            goto L_0x026f
        L_0x026d:
            r18 = r41
        L_0x026f:
            if (r7 == 0) goto L_0x0278
            androidx.compose.foundation.text.KeyboardActions$Companion r7 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r7 = r7.getDefault()
            goto L_0x027a
        L_0x0278:
            r7 = r42
        L_0x027a:
            if (r0 == 0) goto L_0x027e
            r0 = 0
            goto L_0x0280
        L_0x027e:
            r0 = r43
        L_0x0280:
            if (r2 == 0) goto L_0x0286
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0288
        L_0x0286:
            r2 = r44
        L_0x0288:
            if (r3 == 0) goto L_0x0291
            androidx.compose.ui.text.input.VisualTransformation$Companion r3 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r3 = r3.getNone()
            goto L_0x0293
        L_0x0291:
            r3 = r45
        L_0x0293:
            if (r5 == 0) goto L_0x0298
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6 r5 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6.INSTANCE
            goto L_0x029a
        L_0x0298:
            r5 = r46
        L_0x029a:
            if (r8 == 0) goto L_0x02bb
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r8)
            java.lang.Object r8 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r19.getEmpty()
            if (r8 != r14) goto L_0x02b5
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r8)
        L_0x02b5:
            r10.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = (androidx.compose.foundation.interaction.MutableInteractionSource) r8
            goto L_0x02bd
        L_0x02bb:
            r8 = r47
        L_0x02bd:
            r14 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x02d7
            androidx.compose.ui.graphics.SolidColor r14 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r19 = androidx.compose.ui.graphics.Color.Companion
            r37 = r2
            r38 = r3
            long r2 = r19.m2945getBlack0d7_KjU()
            r39 = r0
            r0 = 0
            r14.<init>(r2, r0)
            r0 = r6 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r0
            goto L_0x02df
        L_0x02d7:
            r39 = r0
            r37 = r2
            r38 = r3
            r14 = r48
        L_0x02df:
            if (r9 == 0) goto L_0x02ee
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r0 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m838getLambda2$foundation_release()
            r26 = r37
            r27 = r38
            r32 = r0
            goto L_0x02f4
        L_0x02ee:
            r26 = r37
            r27 = r38
            r32 = r49
        L_0x02f4:
            r19 = r4
            r28 = r5
            r24 = r7
            r29 = r8
            r20 = r12
            r30 = r14
            r22 = r16
            r23 = r17
            r14 = r18
            r12 = r39
        L_0x0308:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0319
            java.lang.String r0 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:264)"
            r2 = -560482651(0xffffffffde97b6a5, float:-5.4660533E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r6, r0)
        L_0x0319:
            androidx.compose.ui.text.input.ImeOptions r31 = r14.toImeOptions$foundation_release(r12)
            r8 = r12 ^ 1
            if (r12 == 0) goto L_0x0323
            r9 = 1
            goto L_0x0325
        L_0x0323:
            r9 = r26
        L_0x0325:
            r0 = r1 & 14
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            boolean r2 = r10.changed((java.lang.Object) r15)
            r7 = r36
            boolean r3 = r10.changed((java.lang.Object) r7)
            r2 = r2 | r3
            java.lang.Object r3 = r10.rememberedValue()
            if (r2 != 0) goto L_0x0346
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x034e
        L_0x0346:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1 r3 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
            r3.<init>(r15, r7)
            r10.updateRememberedValue(r3)
        L_0x034e:
            r10.endReplaceableGroup()
            r2 = r3
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = r1
            r1 = r2
            r2 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r3 >> 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r6 << 12
            r4 = r2 & r21
            r0 = r0 | r4
            r4 = r2 & r25
            r0 = r0 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r2
            r0 = r0 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r4
            r16 = r0 | r2
            int r0 = r3 >> 18
            r0 = r0 & 112(0x70, float:1.57E-43)
            int r2 = r3 >> 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = r6 & r21
            r17 = r0 | r2
            r18 = 0
            r0 = r35
            r2 = r19
            r3 = r23
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r21 = r10
            r10 = r31
            r11 = r24
            r25 = r12
            r12 = r20
            r13 = r22
            r31 = r14
            r14 = r32
            r15 = r21
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03ad:
            r3 = r19
            r4 = r20
            r5 = r22
            r6 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r7 = r31
            r15 = r32
        L_0x03c7:
            androidx.compose.runtime.ScopeUpdateScope r2 = r21.endRestartGroup()
            if (r2 != 0) goto L_0x03ce
            goto L_0x03e9
        L_0x03ce:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
            r0 = r1
            r33 = r1
            r1 = r35
            r34 = r2
            r2 = r36
            r16 = r51
            r17 = r52
            r18 = r53
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = r33
            r0 = r34
            r0.updateScope(r1)
        L_0x03e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
