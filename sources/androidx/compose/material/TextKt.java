package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextKt {
    @NotNull
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void ProvideTextStyle(@NotNull TextStyle textStyle, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(textStyle, "value");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1772272796);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) textStyle)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            ProvidableCompositionLocal providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) startRestartGroup.consume(providableCompositionLocal)).merge(textStyle))}, function2, startRestartGroup, (i12 & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(textStyle, function2, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x042e  */
    /* JADX WARNING: Removed duplicated region for block: B:257:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0130  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1460Text4IGK_g(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.AnnotatedString r59, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r60, long r61, long r63, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontStyle r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontWeight r66, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontFamily r67, long r68, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextDecoration r70, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextAlign r71, long r72, int r74, boolean r75, int r76, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r79, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r80, int r81, int r82, int r83) {
        /*
            r1 = r59
            r14 = r81
            r15 = r82
            r13 = r83
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -422393234(0xffffffffe6d2ca6e, float:-4.9771557E23)
            r2 = r80
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r14 | 6
            goto L_0x002d
        L_0x001d:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r14
            goto L_0x002d
        L_0x002c:
            r2 = r14
        L_0x002d:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0047
            r8 = r60
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0043
            r9 = 32
            goto L_0x0045
        L_0x0043:
            r9 = 16
        L_0x0045:
            r2 = r2 | r9
            goto L_0x0049
        L_0x0047:
            r8 = r60
        L_0x0049:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            r3 = r61
            goto L_0x0065
        L_0x0052:
            r12 = r14 & 896(0x380, float:1.256E-42)
            r3 = r61
            if (r12 != 0) goto L_0x0065
            boolean r16 = r0.changed((long) r3)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r2 = r2 | r16
        L_0x0065:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0072
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r63
            goto L_0x0085
        L_0x0072:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r7 = r63
            if (r6 != 0) goto L_0x0085
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0081
            r20 = r17
            goto L_0x0083
        L_0x0081:
            r20 = r18
        L_0x0083:
            r2 = r2 | r20
        L_0x0085:
            r20 = r13 & 16
            if (r20 == 0) goto L_0x008e
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = r65
            goto L_0x00a4
        L_0x008e:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r14 & r22
            r10 = r65
            if (r22 != 0) goto L_0x00a4
            boolean r23 = r0.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00a0
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r2 = r2 | r23
        L_0x00a4:
            r23 = r13 & 32
            r24 = 458752(0x70000, float:6.42848E-40)
            r25 = 65536(0x10000, float:9.18355E-41)
            if (r23 == 0) goto L_0x00b3
            r26 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r26
            r11 = r66
            goto L_0x00c6
        L_0x00b3:
            r26 = r14 & r24
            r11 = r66
            if (r26 != 0) goto L_0x00c6
            boolean r27 = r0.changed((java.lang.Object) r11)
            if (r27 == 0) goto L_0x00c2
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r27 = r25
        L_0x00c4:
            r2 = r2 | r27
        L_0x00c6:
            r27 = r13 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r27 == 0) goto L_0x00d3
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r12 = r67
            goto L_0x00e6
        L_0x00d3:
            r29 = r14 & r28
            r12 = r67
            if (r29 != 0) goto L_0x00e6
            boolean r30 = r0.changed((java.lang.Object) r12)
            if (r30 == 0) goto L_0x00e2
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e4
        L_0x00e2:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00e4:
            r2 = r2 | r30
        L_0x00e6:
            r6 = r13 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00f1
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r31
            r3 = r68
            goto L_0x0106
        L_0x00f1:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r14 & r31
            r3 = r68
            if (r31 != 0) goto L_0x0106
            boolean r31 = r0.changed((long) r3)
            if (r31 == 0) goto L_0x0102
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0104
        L_0x0102:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0104:
            r2 = r2 | r31
        L_0x0106:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0111
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r31
            r3 = r70
            goto L_0x0125
        L_0x0111:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r14 & r31
            r3 = r70
            if (r31 != 0) goto L_0x0125
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0122
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r2 = r2 | r4
        L_0x0125:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0130
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            r3 = r71
            goto L_0x0145
        L_0x0130:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r14 & r31
            r3 = r71
            if (r31 != 0) goto L_0x0145
            boolean r31 = r0.changed((java.lang.Object) r3)
            if (r31 == 0) goto L_0x0141
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0143
        L_0x0141:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0143:
            r2 = r2 | r31
        L_0x0145:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014e
            r29 = r15 | 6
            r7 = r72
            goto L_0x0164
        L_0x014e:
            r31 = r15 & 14
            r7 = r72
            if (r31 != 0) goto L_0x0162
            boolean r31 = r0.changed((long) r7)
            if (r31 == 0) goto L_0x015d
            r29 = 4
            goto L_0x015f
        L_0x015d:
            r29 = 2
        L_0x015f:
            r29 = r15 | r29
            goto L_0x0164
        L_0x0162:
            r29 = r15
        L_0x0164:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x016b
            r29 = r29 | 48
            goto L_0x0181
        L_0x016b:
            r8 = r15 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x017f
            r8 = r74
            boolean r31 = r0.changed((int) r8)
            if (r31 == 0) goto L_0x017a
            r19 = 32
            goto L_0x017c
        L_0x017a:
            r19 = 16
        L_0x017c:
            r29 = r29 | r19
            goto L_0x0181
        L_0x017f:
            r8 = r74
        L_0x0181:
            r8 = r29
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x018a
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x019e
        L_0x018a:
            r11 = r15 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x019e
            r11 = r75
            boolean r19 = r0.changed((boolean) r11)
            if (r19 == 0) goto L_0x0199
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x019b
        L_0x0199:
            r26 = 128(0x80, float:1.794E-43)
        L_0x019b:
            r8 = r8 | r26
            goto L_0x01a0
        L_0x019e:
            r11 = r75
        L_0x01a0:
            r11 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01a7
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b9
        L_0x01a7:
            r12 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01b9
            r12 = r76
            boolean r19 = r0.changed((int) r12)
            if (r19 == 0) goto L_0x01b4
            goto L_0x01b6
        L_0x01b4:
            r17 = r18
        L_0x01b6:
            r8 = r8 | r17
            goto L_0x01bb
        L_0x01b9:
            r12 = r76
        L_0x01bb:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c1
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
        L_0x01c1:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x01cd
            r18 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 | r18
            goto L_0x01e3
        L_0x01cd:
            r18 = r15 & r24
            if (r18 != 0) goto L_0x01e3
            r18 = r11
            r11 = r78
            boolean r19 = r0.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x01de
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e0
        L_0x01de:
            r19 = r25
        L_0x01e0:
            r8 = r8 | r19
            goto L_0x01e7
        L_0x01e3:
            r18 = r11
            r11 = r78
        L_0x01e7:
            r19 = r15 & r28
            if (r19 != 0) goto L_0x01ff
            r19 = r13 & r25
            r11 = r79
            if (r19 != 0) goto L_0x01fa
            boolean r19 = r0.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x01fa
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x01fc
        L_0x01fa:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x01fc:
            r8 = r8 | r19
            goto L_0x0201
        L_0x01ff:
            r11 = r79
        L_0x0201:
            r11 = 16384(0x4000, float:2.2959E-41)
            if (r12 != r11) goto L_0x0243
            r11 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r11 & r2
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x0243
            r11 = 2995931(0x2db6db, float:4.198194E-39)
            r11 = r11 & r8
            r15 = 599186(0x92492, float:8.39638E-40)
            if (r11 != r15) goto L_0x0243
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x021e
            goto L_0x0243
        L_0x021e:
            r0.skipToGroupEnd()
            r2 = r60
            r3 = r61
            r5 = r63
            r7 = r65
            r8 = r66
            r9 = r67
            r10 = r68
            r12 = r70
            r13 = r71
            r15 = r72
            r17 = r74
            r18 = r75
            r19 = r76
            r20 = r77
            r21 = r78
            r22 = r79
            goto L_0x0427
        L_0x0243:
            r0.startDefaults()
            r11 = r14 & 1
            if (r11 == 0) goto L_0x0286
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x0251
            goto L_0x0286
        L_0x0251:
            r0.skipToGroupEnd()
            if (r12 == 0) goto L_0x025a
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r1
        L_0x025a:
            r1 = r13 & r25
            if (r1 == 0) goto L_0x0262
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r1
        L_0x0262:
            r5 = r60
            r21 = r61
            r3 = r63
            r11 = r65
            r16 = r66
            r19 = r67
            r26 = r68
            r1 = r70
            r9 = r71
            r6 = r72
            r10 = r75
            r12 = r76
            r15 = r77
            r17 = r78
            r71 = r79
            r18 = r8
            r8 = r74
            goto L_0x032a
        L_0x0286:
            if (r5 == 0) goto L_0x028b
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            goto L_0x028d
        L_0x028b:
            r5 = r60
        L_0x028d:
            if (r9 == 0) goto L_0x0296
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r9.m2955getUnspecified0d7_KjU()
            goto L_0x0298
        L_0x0296:
            r21 = r61
        L_0x0298:
            if (r16 == 0) goto L_0x02a1
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r29 = r9.m5670getUnspecifiedXSAIIZE()
            goto L_0x02a3
        L_0x02a1:
            r29 = r63
        L_0x02a3:
            r9 = 0
            if (r20 == 0) goto L_0x02a8
            r11 = r9
            goto L_0x02aa
        L_0x02a8:
            r11 = r65
        L_0x02aa:
            if (r23 == 0) goto L_0x02af
            r16 = r9
            goto L_0x02b1
        L_0x02af:
            r16 = r66
        L_0x02b1:
            if (r27 == 0) goto L_0x02b6
            r19 = r9
            goto L_0x02b8
        L_0x02b6:
            r19 = r67
        L_0x02b8:
            if (r6 == 0) goto L_0x02c1
            androidx.compose.ui.unit.TextUnit$Companion r6 = androidx.compose.ui.unit.TextUnit.Companion
            long r26 = r6.m5670getUnspecifiedXSAIIZE()
            goto L_0x02c3
        L_0x02c1:
            r26 = r68
        L_0x02c3:
            if (r1 == 0) goto L_0x02c7
            r1 = r9
            goto L_0x02c9
        L_0x02c7:
            r1 = r70
        L_0x02c9:
            if (r4 == 0) goto L_0x02cc
            goto L_0x02ce
        L_0x02cc:
            r9 = r71
        L_0x02ce:
            if (r3 == 0) goto L_0x02d7
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x02d9
        L_0x02d7:
            r3 = r72
        L_0x02d9:
            if (r7 == 0) goto L_0x02e2
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r6 = r6.m5402getClipgIe3tQ8()
            goto L_0x02e4
        L_0x02e2:
            r6 = r74
        L_0x02e4:
            if (r10 == 0) goto L_0x02e8
            r7 = 1
            goto L_0x02ea
        L_0x02e8:
            r7 = r75
        L_0x02ea:
            if (r18 == 0) goto L_0x02f0
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02f2
        L_0x02f0:
            r10 = r76
        L_0x02f2:
            if (r12 == 0) goto L_0x02fe
            java.util.Map r12 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r18
            goto L_0x0300
        L_0x02fe:
            r12 = r77
        L_0x0300:
            if (r17 == 0) goto L_0x0305
            androidx.compose.material.TextKt$Text$3 r17 = androidx.compose.material.TextKt$Text$3.INSTANCE
            goto L_0x0307
        L_0x0305:
            r17 = r78
        L_0x0307:
            r18 = r13 & r25
            if (r18 == 0) goto L_0x031f
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r15 = LocalTextStyle
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.ui.text.TextStyle r15 = (androidx.compose.ui.text.TextStyle) r15
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r18
            r18 = r8
            r71 = r15
            r8 = r6
            r15 = r12
            goto L_0x0325
        L_0x031f:
            r71 = r79
            r18 = r8
            r15 = r12
            r8 = r6
        L_0x0325:
            r12 = r10
            r10 = r7
            r6 = r3
            r3 = r29
        L_0x032a:
            r0.endDefaults()
            r13 = 1557618192(0x5cd75e10, float:4.84964342E17)
            r0.startReplaceableGroup(r13)
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r13.m2955getUnspecified0d7_KjU()
            int r20 = (r21 > r29 ? 1 : (r21 == r29 ? 0 : -1))
            if (r20 == 0) goto L_0x0340
            r20 = 1
            goto L_0x0342
        L_0x0340:
            r20 = 0
        L_0x0342:
            if (r20 == 0) goto L_0x0347
            r30 = r21
            goto L_0x0393
        L_0x0347:
            long r29 = r71.m5056getColor0d7_KjU()
            long r31 = r13.m2955getUnspecified0d7_KjU()
            int r13 = (r29 > r31 ? 1 : (r29 == r31 ? 0 : -1))
            if (r13 == 0) goto L_0x0355
            r13 = 1
            goto L_0x0356
        L_0x0355:
            r13 = 0
        L_0x0356:
            if (r13 == 0) goto L_0x0359
            goto L_0x0391
        L_0x0359:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.graphics.Color r13 = (androidx.compose.ui.graphics.Color) r13
            long r29 = r13.m2929unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            java.lang.Object r13 = r0.consume(r13)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r20 = 0
            r23 = 0
            r25 = 0
            r31 = 14
            r32 = 0
            r60 = r29
            r62 = r13
            r63 = r20
            r64 = r23
            r65 = r25
            r66 = r31
            r67 = r32
            long r29 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r60, r62, r63, r64, r65, r66, r67)
        L_0x0391:
            r30 = r29
        L_0x0393:
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r13 = new androidx.compose.ui.text.TextStyle
            r29 = r13
            r36 = 0
            r38 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r47 = 0
            r49 = 0
            r52 = 0
            r53 = 175952(0x2af50, float:2.46561E-40)
            r54 = 0
            r32 = r3
            r34 = r16
            r35 = r11
            r37 = r19
            r39 = r26
            r46 = r1
            r48 = r9
            r50 = r6
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (int) r53, (kotlin.jvm.internal.DefaultConstructorMarker) r54)
            r72 = r1
            r1 = r71
            androidx.compose.ui.text.TextStyle r13 = r1.merge((androidx.compose.ui.text.TextStyle) r13)
            r20 = 16777216(0x1000000, float:2.3509887E-38)
            r23 = r2 & 14
            r20 = r23 | r20
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r20 | r2
            r20 = r1
            int r1 = r18 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r18 << 9
            r18 = 57344(0xe000, float:8.0356E-41)
            r18 = r2 & r18
            r1 = r1 | r18
            r18 = r2 & r24
            r1 = r1 | r18
            r2 = r2 & r28
            r1 = r1 | r2
            r2 = 0
            r60 = r59
            r61 = r5
            r62 = r13
            r63 = r17
            r64 = r8
            r65 = r10
            r66 = r12
            r67 = r15
            r68 = r0
            r69 = r1
            r70 = r2
            androidx.compose.foundation.text.BasicTextKt.m833BasicText4YKlhWE(r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70)
            r2 = r5
            r13 = r9
            r18 = r10
            r9 = r19
            r19 = r12
            r12 = r72
            r56 = r17
            r17 = r8
            r8 = r16
            r57 = r6
            r7 = r11
            r5 = r3
            r3 = r21
            r10 = r26
            r21 = r56
            r22 = r20
            r20 = r15
            r15 = r57
        L_0x0427:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x042e
            goto L_0x0453
        L_0x042e:
            androidx.compose.material.TextKt$Text$4 r0 = new androidx.compose.material.TextKt$Text$4
            r60 = r0
            r55 = r1
            r1 = r59
            r14 = r15
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r81
            r23 = r82
            r24 = r83
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r1 = r60
            r0 = r55
            r0.updateScope(r1)
        L_0x0453:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1460Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0132  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1461TextfLXpl1I(@org.jetbrains.annotations.NotNull java.lang.String r54, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r55, long r56, long r58, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontStyle r60, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontWeight r61, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontFamily r62, long r63, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextDecoration r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextAlign r66, long r67, int r69, boolean r70, int r71, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r73, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r74, int r75, int r76, int r77) {
        /*
            r1 = r54
            r14 = r75
            r15 = r76
            r13 = r77
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -366126944(0xffffffffea2d58a0, float:-5.239067E25)
            r2 = r74
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r14 | 6
            goto L_0x002d
        L_0x001d:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r14
            goto L_0x002d
        L_0x002c:
            r2 = r14
        L_0x002d:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0047
            r8 = r55
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0043
            r9 = 32
            goto L_0x0045
        L_0x0043:
            r9 = 16
        L_0x0045:
            r2 = r2 | r9
            goto L_0x0049
        L_0x0047:
            r8 = r55
        L_0x0049:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            r3 = r56
            goto L_0x0065
        L_0x0052:
            r12 = r14 & 896(0x380, float:1.256E-42)
            r3 = r56
            if (r12 != 0) goto L_0x0065
            boolean r16 = r0.changed((long) r3)
            if (r16 == 0) goto L_0x0061
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r2 = r2 | r16
        L_0x0065:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0072
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r58
            goto L_0x0085
        L_0x0072:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r7 = r58
            if (r6 != 0) goto L_0x0085
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0081
            r20 = r17
            goto L_0x0083
        L_0x0081:
            r20 = r18
        L_0x0083:
            r2 = r2 | r20
        L_0x0085:
            r20 = r13 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 57344(0xe000, float:8.0356E-41)
            if (r20 == 0) goto L_0x0095
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r6 = r60
            goto L_0x00a8
        L_0x0095:
            r24 = r14 & r23
            r6 = r60
            if (r24 != 0) goto L_0x00a8
            boolean r25 = r0.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00a4
            r25 = r21
            goto L_0x00a6
        L_0x00a4:
            r25 = r22
        L_0x00a6:
            r2 = r2 | r25
        L_0x00a8:
            r25 = r13 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            if (r25 == 0) goto L_0x00b5
            r27 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r27
            r10 = r61
            goto L_0x00c8
        L_0x00b5:
            r27 = r14 & r26
            r10 = r61
            if (r27 != 0) goto L_0x00c8
            boolean r28 = r0.changed((java.lang.Object) r10)
            if (r28 == 0) goto L_0x00c4
            r28 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r28 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r2 = r2 | r28
        L_0x00c8:
            r28 = r13 & 64
            if (r28 == 0) goto L_0x00d3
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r11 = r62
            goto L_0x00e8
        L_0x00d3:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r14 & r29
            r11 = r62
            if (r29 != 0) goto L_0x00e8
            boolean r30 = r0.changed((java.lang.Object) r11)
            if (r30 == 0) goto L_0x00e4
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e6
        L_0x00e4:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00e6:
            r2 = r2 | r30
        L_0x00e8:
            r12 = r13 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x00f3
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r31
            r3 = r63
            goto L_0x0108
        L_0x00f3:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r14 & r31
            r3 = r63
            if (r31 != 0) goto L_0x0108
            boolean r31 = r0.changed((long) r3)
            if (r31 == 0) goto L_0x0104
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0106
        L_0x0104:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0106:
            r2 = r2 | r31
        L_0x0108:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0113
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r31
            r3 = r65
            goto L_0x0127
        L_0x0113:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r14 & r31
            r3 = r65
            if (r31 != 0) goto L_0x0127
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0124
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0126
        L_0x0124:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0126:
            r2 = r2 | r4
        L_0x0127:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0132
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            r3 = r66
            goto L_0x0147
        L_0x0132:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r14 & r31
            r3 = r66
            if (r31 != 0) goto L_0x0147
            boolean r31 = r0.changed((java.lang.Object) r3)
            if (r31 == 0) goto L_0x0143
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0143:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r2 = r2 | r31
        L_0x0147:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0150
            r30 = r15 | 6
            r6 = r67
            goto L_0x0166
        L_0x0150:
            r31 = r15 & 14
            r6 = r67
            if (r31 != 0) goto L_0x0164
            boolean r8 = r0.changed((long) r6)
            if (r8 == 0) goto L_0x015f
            r30 = 4
            goto L_0x0161
        L_0x015f:
            r30 = 2
        L_0x0161:
            r30 = r15 | r30
            goto L_0x0166
        L_0x0164:
            r30 = r15
        L_0x0166:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x016f
            r30 = r30 | 48
            r6 = r69
            goto L_0x0182
        L_0x016f:
            r31 = r15 & 112(0x70, float:1.57E-43)
            r6 = r69
            if (r31 != 0) goto L_0x0182
            boolean r7 = r0.changed((int) r6)
            if (r7 == 0) goto L_0x017e
            r24 = 32
            goto L_0x0180
        L_0x017e:
            r24 = 16
        L_0x0180:
            r30 = r30 | r24
        L_0x0182:
            r7 = r30
            r6 = r13 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x018b
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x019f
        L_0x018b:
            r10 = r15 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x019f
            r10 = r70
            boolean r19 = r0.changed((boolean) r10)
            if (r19 == 0) goto L_0x019a
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x019c
        L_0x019a:
            r27 = 128(0x80, float:1.794E-43)
        L_0x019c:
            r7 = r7 | r27
            goto L_0x01a1
        L_0x019f:
            r10 = r70
        L_0x01a1:
            r10 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01a8
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ba
        L_0x01a8:
            r11 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01ba
            r11 = r71
            boolean r19 = r0.changed((int) r11)
            if (r19 == 0) goto L_0x01b5
            goto L_0x01b7
        L_0x01b5:
            r17 = r18
        L_0x01b7:
            r7 = r7 | r17
            goto L_0x01bc
        L_0x01ba:
            r11 = r71
        L_0x01bc:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c3
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01d7
        L_0x01c3:
            r17 = r15 & r23
            if (r17 != 0) goto L_0x01d7
            r17 = r11
            r11 = r72
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r21 = r22
        L_0x01d4:
            r7 = r7 | r21
            goto L_0x01db
        L_0x01d7:
            r17 = r11
            r11 = r72
        L_0x01db:
            r18 = r15 & r26
            r19 = 32768(0x8000, float:4.5918E-41)
            if (r18 != 0) goto L_0x01f6
            r18 = r13 & r19
            r11 = r73
            if (r18 != 0) goto L_0x01f1
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01f1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f3
        L_0x01f1:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01f3:
            r7 = r7 | r18
            goto L_0x01f8
        L_0x01f6:
            r11 = r73
        L_0x01f8:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r2 & r18
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r15) goto L_0x0235
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r7
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r15) goto L_0x0235
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x0212
            goto L_0x0235
        L_0x0212:
            r0.skipToGroupEnd()
            r2 = r55
            r3 = r56
            r5 = r58
            r7 = r60
            r8 = r61
            r9 = r62
            r10 = r63
            r12 = r65
            r13 = r66
            r15 = r67
            r17 = r69
            r18 = r70
            r19 = r71
            r20 = r72
            r21 = r73
            goto L_0x03f2
        L_0x0235:
            r0.startDefaults()
            r11 = r14 & 1
            if (r11 == 0) goto L_0x0270
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x0243
            goto L_0x0270
        L_0x0243:
            r0.skipToGroupEnd()
            r1 = r13 & r19
            if (r1 == 0) goto L_0x024e
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r7 = r7 & r1
        L_0x024e:
            r5 = r55
            r21 = r56
            r3 = r58
            r11 = r60
            r16 = r61
            r18 = r62
            r24 = r63
            r1 = r65
            r9 = r66
            r8 = r69
            r10 = r70
            r12 = r71
            r15 = r72
            r65 = r73
            r17 = r7
            r6 = r67
            goto L_0x0303
        L_0x0270:
            if (r5 == 0) goto L_0x0275
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            goto L_0x0277
        L_0x0275:
            r5 = r55
        L_0x0277:
            if (r9 == 0) goto L_0x0280
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r9.m2955getUnspecified0d7_KjU()
            goto L_0x0282
        L_0x0280:
            r21 = r56
        L_0x0282:
            if (r16 == 0) goto L_0x028b
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r29 = r9.m5670getUnspecifiedXSAIIZE()
            goto L_0x028d
        L_0x028b:
            r29 = r58
        L_0x028d:
            r9 = 0
            if (r20 == 0) goto L_0x0292
            r11 = r9
            goto L_0x0294
        L_0x0292:
            r11 = r60
        L_0x0294:
            if (r25 == 0) goto L_0x0299
            r16 = r9
            goto L_0x029b
        L_0x0299:
            r16 = r61
        L_0x029b:
            if (r28 == 0) goto L_0x02a0
            r18 = r9
            goto L_0x02a2
        L_0x02a0:
            r18 = r62
        L_0x02a2:
            if (r12 == 0) goto L_0x02ab
            androidx.compose.ui.unit.TextUnit$Companion r12 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r12.m5670getUnspecifiedXSAIIZE()
            goto L_0x02ad
        L_0x02ab:
            r24 = r63
        L_0x02ad:
            if (r1 == 0) goto L_0x02b1
            r1 = r9
            goto L_0x02b3
        L_0x02b1:
            r1 = r65
        L_0x02b3:
            if (r4 == 0) goto L_0x02b6
            goto L_0x02b8
        L_0x02b6:
            r9 = r66
        L_0x02b8:
            if (r3 == 0) goto L_0x02c1
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x02c3
        L_0x02c1:
            r3 = r67
        L_0x02c3:
            if (r8 == 0) goto L_0x02cc
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m5402getClipgIe3tQ8()
            goto L_0x02ce
        L_0x02cc:
            r8 = r69
        L_0x02ce:
            if (r6 == 0) goto L_0x02d2
            r6 = 1
            goto L_0x02d4
        L_0x02d2:
            r6 = r70
        L_0x02d4:
            if (r10 == 0) goto L_0x02da
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02dc
        L_0x02da:
            r10 = r71
        L_0x02dc:
            if (r17 == 0) goto L_0x02e1
            androidx.compose.material.TextKt$Text$1 r12 = androidx.compose.material.TextKt$Text$1.INSTANCE
            goto L_0x02e3
        L_0x02e1:
            r12 = r72
        L_0x02e3:
            r17 = r13 & r19
            if (r17 == 0) goto L_0x02f9
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r15 = LocalTextStyle
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.ui.text.TextStyle r15 = (androidx.compose.ui.text.TextStyle) r15
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r7 = r7 & r17
            r17 = r7
            r65 = r15
            goto L_0x02fd
        L_0x02f9:
            r65 = r73
            r17 = r7
        L_0x02fd:
            r15 = r12
            r12 = r10
            r10 = r6
            r6 = r3
            r3 = r29
        L_0x0303:
            r0.endDefaults()
            r13 = 1557613088(0x5cd74a20, float:4.8478897E17)
            r0.startReplaceableGroup(r13)
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion
            long r19 = r13.m2955getUnspecified0d7_KjU()
            int r19 = (r21 > r19 ? 1 : (r21 == r19 ? 0 : -1))
            if (r19 == 0) goto L_0x0319
            r19 = 1
            goto L_0x031b
        L_0x0319:
            r19 = 0
        L_0x031b:
            if (r19 == 0) goto L_0x0320
            r28 = r21
            goto L_0x036c
        L_0x0320:
            long r19 = r65.m5056getColor0d7_KjU()
            long r27 = r13.m2955getUnspecified0d7_KjU()
            int r13 = (r19 > r27 ? 1 : (r19 == r27 ? 0 : -1))
            if (r13 == 0) goto L_0x032e
            r13 = 1
            goto L_0x032f
        L_0x032e:
            r13 = 0
        L_0x032f:
            if (r13 == 0) goto L_0x0332
            goto L_0x036a
        L_0x0332:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.graphics.Color r13 = (androidx.compose.ui.graphics.Color) r13
            long r19 = r13.m2929unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            java.lang.Object r13 = r0.consume(r13)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 14
            r31 = 0
            r55 = r19
            r57 = r13
            r58 = r27
            r59 = r28
            r60 = r29
            r61 = r30
            r62 = r31
            long r19 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r55, r57, r58, r59, r60, r61, r62)
        L_0x036a:
            r28 = r19
        L_0x036c:
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r13 = new androidx.compose.ui.text.TextStyle
            r27 = r13
            r34 = 0
            r36 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r45 = 0
            r47 = 0
            r50 = 0
            r51 = 175952(0x2af50, float:2.46561E-40)
            r52 = 0
            r30 = r3
            r32 = r16
            r33 = r11
            r35 = r18
            r37 = r24
            r44 = r1
            r46 = r9
            r48 = r6
            r27.<init>((long) r28, (long) r30, (androidx.compose.ui.text.font.FontWeight) r32, (androidx.compose.ui.text.font.FontStyle) r33, (androidx.compose.ui.text.font.FontSynthesis) r34, (androidx.compose.ui.text.font.FontFamily) r35, (java.lang.String) r36, (long) r37, (androidx.compose.ui.text.style.BaselineShift) r39, (androidx.compose.ui.text.style.TextGeometricTransform) r40, (androidx.compose.ui.text.intl.LocaleList) r41, (long) r42, (androidx.compose.ui.text.style.TextDecoration) r44, (androidx.compose.ui.graphics.Shadow) r45, (androidx.compose.ui.text.style.TextAlign) r46, (androidx.compose.ui.text.style.TextDirection) r47, (long) r48, (androidx.compose.ui.text.style.TextIndent) r50, (int) r51, (kotlin.jvm.internal.DefaultConstructorMarker) r52)
            r66 = r1
            r1 = r65
            androidx.compose.ui.text.TextStyle r13 = r1.merge((androidx.compose.ui.text.TextStyle) r13)
            r19 = r2 & 14
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r19 | r2
            r19 = r1
            int r1 = r17 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r17 << 9
            r17 = r2 & r23
            r1 = r1 | r17
            r17 = r2 & r26
            r1 = r1 | r17
            r17 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r17
            r1 = r1 | r2
            r2 = 0
            r55 = r54
            r56 = r5
            r57 = r13
            r58 = r15
            r59 = r8
            r60 = r10
            r61 = r12
            r62 = r0
            r63 = r1
            r64 = r2
            androidx.compose.foundation.text.BasicTextKt.m834BasicTextBpD7jsM(r55, r56, r57, r58, r59, r60, r61, r62, r63, r64)
            r2 = r5
            r17 = r8
            r13 = r9
            r20 = r15
            r8 = r16
            r9 = r18
            r15 = r6
            r18 = r10
            r7 = r11
            r10 = r24
            r5 = r3
            r3 = r21
            r21 = r19
            r19 = r12
            r12 = r66
        L_0x03f2:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x03f9
            goto L_0x041c
        L_0x03f9:
            androidx.compose.material.TextKt$Text$2 r0 = new androidx.compose.material.TextKt$Text$2
            r55 = r0
            r53 = r1
            r1 = r54
            r14 = r15
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r75
            r22 = r76
            r23 = r77
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            r1 = r55
            r0 = r53
            r0.updateScope(r1)
        L_0x041c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1461TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @NotNull
    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }
}
