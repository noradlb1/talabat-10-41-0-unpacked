package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BasicTextKt {
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0109  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m833BasicText4YKlhWE(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.AnnotatedString r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r35, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r36, int r37, boolean r38, int r39, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r10 = r33
            r11 = r42
            r12 = r43
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            r1 = r41
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r11 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r13.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r11
            goto L_0x002b
        L_0x002a:
            r1 = r11
        L_0x002b:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0045
            r4 = r34
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r1 = r1 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r34
        L_0x0047:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r11 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0061
            r7 = r35
            boolean r8 = r13.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r35
        L_0x0063:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r9 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007d
            r9 = r36
            boolean r14 = r13.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x0079
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r14
            goto L_0x007f
        L_0x007d:
            r9 = r36
        L_0x007f:
            r14 = r12 & 16
            if (r14 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0086:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x009c
            r15 = r37
            boolean r16 = r13.changed((int) r15)
            if (r16 == 0) goto L_0x0097
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r1 = r1 | r16
            goto L_0x009e
        L_0x009c:
            r15 = r37
        L_0x009e:
            r16 = r12 & 32
            if (r16 == 0) goto L_0x00a9
            r17 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r17
            r2 = r38
            goto L_0x00be
        L_0x00a9:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r11 & r17
            r2 = r38
            if (r17 != 0) goto L_0x00be
            boolean r17 = r13.changed((boolean) r2)
            if (r17 == 0) goto L_0x00ba
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r1 = r1 | r17
        L_0x00be:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x00c9
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r0 = r39
            goto L_0x00de
        L_0x00c9:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r11 & r18
            r0 = r39
            if (r18 != 0) goto L_0x00de
            boolean r19 = r13.changed((int) r0)
            if (r19 == 0) goto L_0x00da
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r1 = r1 | r19
        L_0x00de:
            r6 = r12 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00e6
            r20 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 | r20
        L_0x00e6:
            r0 = 128(0x80, float:1.794E-43)
            if (r6 != r0) goto L_0x0109
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0109
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00fa
            goto L_0x0109
        L_0x00fa:
            r13.skipToGroupEnd()
            r6 = r38
            r8 = r40
            r2 = r4
            r3 = r7
            r4 = r9
            r5 = r15
            r7 = r39
            goto L_0x0380
        L_0x0109:
            r13.startDefaults()
            r0 = r11 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r9 = 1
            if (r0 == 0) goto L_0x012f
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x011b
            goto L_0x012f
        L_0x011b:
            r13.skipToGroupEnd()
            if (r6 == 0) goto L_0x0121
            r1 = r1 & r2
        L_0x0121:
            r8 = r36
            r17 = r38
            r19 = r39
            r6 = r1
            r14 = r4
        L_0x0129:
            r16 = r15
            r15 = r7
            r7 = r40
            goto L_0x0177
        L_0x012f:
            if (r3 == 0) goto L_0x0134
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0135
        L_0x0134:
            r0 = r4
        L_0x0135:
            if (r5 == 0) goto L_0x013e
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            r7 = r3
        L_0x013e:
            if (r8 == 0) goto L_0x0143
            androidx.compose.foundation.text.BasicTextKt$BasicText$4 r3 = androidx.compose.foundation.text.BasicTextKt$BasicText$4.INSTANCE
            goto L_0x0145
        L_0x0143:
            r3 = r36
        L_0x0145:
            if (r14 == 0) goto L_0x014e
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m5402getClipgIe3tQ8()
            r15 = r4
        L_0x014e:
            if (r16 == 0) goto L_0x0152
            r4 = r9
            goto L_0x0154
        L_0x0152:
            r4 = r38
        L_0x0154:
            if (r17 == 0) goto L_0x015a
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x015c
        L_0x015a:
            r5 = r39
        L_0x015c:
            if (r6 == 0) goto L_0x016f
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r1 = r1 & r2
            r14 = r0
            r8 = r3
            r17 = r4
            r19 = r5
            r16 = r15
            r15 = r7
            r7 = r6
            r6 = r1
            goto L_0x0177
        L_0x016f:
            r14 = r0
            r6 = r1
            r8 = r3
            r17 = r4
            r19 = r5
            goto L_0x0129
        L_0x0177:
            r13.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0189
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.BasicText (BasicText.kt:159)"
            r2 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x0189:
            r18 = 0
            if (r19 <= 0) goto L_0x018f
            r0 = r9
            goto L_0x0191
        L_0x018f:
            r0 = r18
        L_0x0191:
            if (r0 == 0) goto L_0x0397
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            java.lang.Object r0 = r13.consume(r0)
            r5 = r0
            androidx.compose.foundation.text.selection.SelectionRegistrar r5 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r5
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r13.consume(r0)
            r20 = r0
            androidx.compose.ui.unit.Density r20 = (androidx.compose.ui.unit.Density) r20
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            java.lang.Object r0 = r13.consume(r0)
            r21 = r0
            androidx.compose.ui.text.font.FontFamily$Resolver r21 = (androidx.compose.ui.text.font.FontFamily.Resolver) r21
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            long r3 = r0.m1073getBackgroundColor0d7_KjU()
            kotlin.Pair r0 = androidx.compose.foundation.text.CoreTextKt.resolveInlineContent(r10, r7)
            java.lang.Object r1 = r0.component1()
            r22 = r1
            java.util.List r22 = (java.util.List) r22
            java.lang.Object r0 = r0.component2()
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            r0 = 959243020(0x392ce30c, float:1.648778E-4)
            r13.startReplaceableGroup(r0)
            if (r5 != 0) goto L_0x01e2
            r0 = 0
            goto L_0x0210
        L_0x01e2:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r18] = r10
            r0[r9] = r5
            androidx.compose.runtime.saveable.Saver r1 = selectionIdSaver(r5)
            r23 = 0
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2 r9 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2
            r9.<init>(r5)
            r24 = 72
            r25 = 4
            r34 = r0
            r35 = r1
            r36 = r23
            r37 = r9
            r38 = r13
            r39 = r24
            r40 = r25
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r34, r35, (java.lang.String) r36, r37, (androidx.compose.runtime.Composer) r38, (int) r39, (int) r40)
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
        L_0x0210:
            r13.endReplaceableGroup()
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r9)
            java.lang.Object r9 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r34 = r0
            java.lang.Object r0 = r23.getEmpty()
            if (r9 != r0) goto L_0x0269
            androidx.compose.foundation.text.TextController r9 = new androidx.compose.foundation.text.TextController
            androidx.compose.foundation.text.TextState r1 = new androidx.compose.foundation.text.TextState
            androidx.compose.foundation.text.TextDelegate r0 = new androidx.compose.foundation.text.TextDelegate
            r23 = 0
            r26 = r34
            r34 = r0
            r28 = r1
            r1 = r33
            r35 = r2
            r2 = r15
            r29 = r3
            r3 = r19
            r4 = r17
            r31 = r5
            r5 = r16
            r32 = r6
            r6 = r20
            r24 = r7
            r7 = r21
            r11 = r8
            r8 = r22
            r12 = r9
            r25 = r14
            r14 = 1
            r9 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r34
            r0 = r26
            r2 = r28
            r2.<init>(r3, r0)
            r12.<init>(r2)
            r13.updateRememberedValue(r12)
            r9 = r12
            goto L_0x0277
        L_0x0269:
            r35 = r2
            r29 = r3
            r31 = r5
            r32 = r6
            r24 = r7
            r11 = r8
            r25 = r14
            r14 = 1
        L_0x0277:
            r13.endReplaceableGroup()
            androidx.compose.foundation.text.TextController r9 = (androidx.compose.foundation.text.TextController) r9
            androidx.compose.foundation.text.TextState r12 = r9.getState()
            boolean r0 = r13.getInserting()
            if (r0 != 0) goto L_0x02a0
            androidx.compose.foundation.text.TextDelegate r0 = r12.getTextDelegate()
            r1 = r33
            r2 = r15
            r3 = r20
            r4 = r21
            r5 = r17
            r6 = r16
            r7 = r19
            r8 = r22
            androidx.compose.foundation.text.TextDelegate r0 = androidx.compose.foundation.text.CoreTextKt.m844updateTextDelegatex_uQXYA(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r9.setTextDelegate(r0)
        L_0x02a0:
            r12.setOnTextLayout(r11)
            r0 = r29
            r12.m941setSelectionBackgroundColor8_81llA(r0)
            r0 = r31
            r9.update(r0)
            boolean r0 = r35.isEmpty()
            if (r0 == 0) goto L_0x02ba
            androidx.compose.foundation.text.ComposableSingletons$BasicTextKt r0 = androidx.compose.foundation.text.ComposableSingletons$BasicTextKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m839getLambda1$foundation_release()
            goto L_0x02ca
        L_0x02ba:
            androidx.compose.foundation.text.BasicTextKt$BasicText$6 r0 = new androidx.compose.foundation.text.BasicTextKt$BasicText$6
            r2 = r35
            r1 = r32
            r0.<init>(r10, r2, r1)
            r1 = 1892283635(0x70c9f4f3, float:5.000209E29)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r1, r14, r0)
        L_0x02ca:
            androidx.compose.ui.Modifier r1 = r9.getModifiers()
            r4 = r25
            androidx.compose.ui.Modifier r1 = r4.then(r1)
            androidx.compose.ui.layout.MeasurePolicy r2 = r9.getMeasurePolicy()
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r5 = r13.consume(r5)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r6 = r13.consume(r6)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r9 = r13.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0311
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0311:
            r13.startReusableNode()
            boolean r9 = r13.getInserting()
            if (r9 == 0) goto L_0x031e
            r13.createNode(r8)
            goto L_0x0321
        L_0x031e:
            r13.useNode()
        L_0x0321:
            r13.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2536constructorimpl(r13)
            kotlin.jvm.functions.Function2 r9 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r2, r9)
            kotlin.jvm.functions.Function2 r2 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r3, r2)
            kotlin.jvm.functions.Function2 r2 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r5, r2)
            kotlin.jvm.functions.Function2 r2 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r6, r2)
            r13.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            r1.invoke(r2, r13, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            r0.invoke(r13, r1)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0375
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0375:
            r2 = r4
            r4 = r11
            r3 = r15
            r5 = r16
            r6 = r17
            r7 = r19
            r8 = r24
        L_0x0380:
            androidx.compose.runtime.ScopeUpdateScope r11 = r13.endRestartGroup()
            if (r11 != 0) goto L_0x0387
            goto L_0x0396
        L_0x0387:
            androidx.compose.foundation.text.BasicTextKt$BasicText$7 r12 = new androidx.compose.foundation.text.BasicTextKt$BasicText$7
            r0 = r12
            r1 = r33
            r9 = r42
            r10 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x0396:
            return
        L_0x0397:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m833BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f6  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m834BasicTextBpD7jsM(@org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r33, int r34, boolean r35, int r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r8 = r30
            r9 = r38
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1022429478(0x3cf10926, float:0.029423308)
            r1 = r37
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r1 = r39 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r10.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r9
            goto L_0x0029
        L_0x0028:
            r1 = r9
        L_0x0029:
            r3 = r39 & 2
            if (r3 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r31
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x003f
            r5 = 32
            goto L_0x0041
        L_0x003f:
            r5 = 16
        L_0x0041:
            r1 = r1 | r5
            goto L_0x0045
        L_0x0043:
            r4 = r31
        L_0x0045:
            r5 = r39 & 4
            if (r5 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x005f
            r6 = r32
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005b
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r7
            goto L_0x0061
        L_0x005f:
            r6 = r32
        L_0x0061:
            r7 = r39 & 8
            if (r7 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007b
            r11 = r33
            boolean r12 = r10.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0077
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r12
            goto L_0x007d
        L_0x007b:
            r11 = r33
        L_0x007d:
            r12 = r39 & 16
            if (r12 == 0) goto L_0x0084
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x0099
            r13 = r34
            boolean r14 = r10.changed((int) r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r34
        L_0x009b:
            r14 = r39 & 32
            if (r14 == 0) goto L_0x00a3
            r15 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r15
            goto L_0x00b8
        L_0x00a3:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00b8
            r15 = r35
            boolean r16 = r10.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r1 = r1 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r35
        L_0x00ba:
            r16 = r39 & 64
            if (r16 == 0) goto L_0x00c5
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r2 = r36
            goto L_0x00da
        L_0x00c5:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r9 & r17
            r2 = r36
            if (r17 != 0) goto L_0x00da
            boolean r17 = r10.changed((int) r2)
            if (r17 == 0) goto L_0x00d6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r1 = r1 | r17
        L_0x00da:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r1 & r17
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r0) goto L_0x00f6
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00eb
            goto L_0x00f6
        L_0x00eb:
            r10.skipToGroupEnd()
            r7 = r2
            r2 = r4
            r3 = r6
            r4 = r11
            r5 = r13
            r6 = r15
            goto L_0x02dc
        L_0x00f6:
            if (r3 == 0) goto L_0x00fb
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r4 = r0
        L_0x00fb:
            if (r5 == 0) goto L_0x0106
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r29 = r0
            goto L_0x0108
        L_0x0106:
            r29 = r6
        L_0x0108:
            if (r7 == 0) goto L_0x010d
            androidx.compose.foundation.text.BasicTextKt$BasicText$1 r0 = androidx.compose.foundation.text.BasicTextKt$BasicText$1.INSTANCE
            r11 = r0
        L_0x010d:
            if (r12 == 0) goto L_0x0116
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m5402getClipgIe3tQ8()
            r13 = r0
        L_0x0116:
            r0 = 1
            if (r14 == 0) goto L_0x011a
            r15 = r0
        L_0x011a:
            if (r16 == 0) goto L_0x0121
            r1 = 2147483647(0x7fffffff, float:NaN)
            r12 = r1
            goto L_0x0122
        L_0x0121:
            r12 = r2
        L_0x0122:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0131
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.BasicText (BasicText.kt:58)"
            r3 = 1022429478(0x3cf10926, float:0.029423308)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r9, r1, r2)
        L_0x0131:
            r1 = 0
            if (r12 <= 0) goto L_0x0136
            r2 = r0
            goto L_0x0137
        L_0x0136:
            r2 = r1
        L_0x0137:
            if (r2 == 0) goto L_0x02f3
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            java.lang.Object r2 = r10.consume(r2)
            r14 = r2
            androidx.compose.foundation.text.selection.SelectionRegistrar r14 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r14
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r10.consume(r2)
            r3 = r2
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            java.lang.Object r2 = r10.consume(r2)
            r5 = r2
            androidx.compose.ui.text.font.FontFamily$Resolver r5 = (androidx.compose.ui.text.font.FontFamily.Resolver) r5
            r2 = 959238313(0x392cd0a9, float:1.648093E-4)
            r10.startReplaceableGroup(r2)
            if (r14 != 0) goto L_0x0165
            r0 = 0
            goto L_0x0192
        L_0x0165:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r8
            r2[r0] = r14
            androidx.compose.runtime.saveable.Saver r0 = selectionIdSaver(r14)
            r1 = 0
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1 r6 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1
            r6.<init>(r14)
            r7 = 72
            r16 = 4
            r31 = r2
            r32 = r0
            r33 = r1
            r34 = r6
            r35 = r10
            r36 = r7
            r37 = r16
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r31, r32, (java.lang.String) r33, r34, (androidx.compose.runtime.Composer) r35, (int) r36, (int) r37)
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
        L_0x0192:
            r10.endReplaceableGroup()
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r2 != r6) goto L_0x01e5
            androidx.compose.foundation.text.TextController r2 = new androidx.compose.foundation.text.TextController
            androidx.compose.foundation.text.TextState r6 = new androidx.compose.foundation.text.TextState
            androidx.compose.ui.text.AnnotatedString r19 = new androidx.compose.ui.text.AnnotatedString
            r7 = 0
            r16 = 0
            r17 = 6
            r18 = 0
            r31 = r19
            r32 = r30
            r33 = r7
            r34 = r16
            r35 = r17
            r36 = r18
            r31.<init>(r32, r33, r34, r35, r36)
            androidx.compose.foundation.text.TextDelegate r7 = new androidx.compose.foundation.text.TextDelegate
            r26 = 0
            r27 = 128(0x80, float:1.794E-43)
            r28 = 0
            r18 = r7
            r20 = r29
            r21 = r12
            r22 = r15
            r23 = r13
            r24 = r3
            r25 = r5
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r6.<init>(r7, r0)
            r2.<init>(r6)
            r10.updateRememberedValue(r2)
        L_0x01e5:
            r10.endReplaceableGroup()
            r7 = r2
            androidx.compose.foundation.text.TextController r7 = (androidx.compose.foundation.text.TextController) r7
            androidx.compose.foundation.text.TextState r6 = r7.getState()
            boolean r0 = r10.getInserting()
            if (r0 != 0) goto L_0x020e
            androidx.compose.foundation.text.TextDelegate r0 = r6.getTextDelegate()
            r1 = r30
            r2 = r29
            r8 = r4
            r4 = r5
            r5 = r15
            r9 = r6
            r6 = r13
            r31 = r13
            r13 = r7
            r7 = r12
            androidx.compose.foundation.text.TextDelegate r0 = androidx.compose.foundation.text.CoreTextKt.m846updateTextDelegatey0kMQk(r0, r1, r2, r3, r4, r5, r6, r7)
            r13.setTextDelegate(r0)
            goto L_0x0213
        L_0x020e:
            r8 = r4
            r9 = r6
            r31 = r13
            r13 = r7
        L_0x0213:
            r9.setOnTextLayout(r11)
            r13.update(r14)
            r0 = 959239630(0x392cd5ce, float:1.6482847E-4)
            r10.startReplaceableGroup(r0)
            if (r14 == 0) goto L_0x0232
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            long r0 = r0.m1073getBackgroundColor0d7_KjU()
            r9.m941setSelectionBackgroundColor8_81llA(r0)
        L_0x0232:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = r13.getModifiers()
            androidx.compose.ui.Modifier r0 = r8.then(r0)
            androidx.compose.ui.layout.MeasurePolicy r1 = r13.getMeasurePolicy()
            r2 = 544976794(0x207baf9a, float:2.1318629E-19)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materialize(r10, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r5.getConstructor()
            r7 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r10.startReplaceableGroup(r7)
            androidx.compose.runtime.Applier r7 = r10.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0280
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0280:
            r10.startReusableNode()
            boolean r7 = r10.getInserting()
            if (r7 == 0) goto L_0x0292
            androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1 r7 = new androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1
            r7.<init>(r6)
            r10.createNode(r7)
            goto L_0x0295
        L_0x0292:
            r10.useNode()
        L_0x0295:
            r10.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2536constructorimpl(r10)
            kotlin.jvm.functions.Function2 r7 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r1, r7)
            kotlin.jvm.functions.Function2 r1 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r3, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetModifier()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r0, r1)
            r10.enableReusing()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02d4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d4:
            r5 = r31
            r2 = r8
            r4 = r11
            r7 = r12
            r6 = r15
            r3 = r29
        L_0x02dc:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x02e3
            goto L_0x02f2
        L_0x02e3:
            androidx.compose.foundation.text.BasicTextKt$BasicText$3 r11 = new androidx.compose.foundation.text.BasicTextKt$BasicText$3
            r0 = r11
            r1 = r30
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x02f2:
            return
        L_0x02f3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m834BasicTextBpD7jsM(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }
}
