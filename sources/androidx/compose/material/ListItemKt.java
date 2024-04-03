package androidx.compose.material;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt {
    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void BaselinesOffsetColumn(List<Dp> list, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11, int i12) {
        Composer startRestartGroup = composer.startRestartGroup(1631148337);
        if ((i12 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        ListItemKt$BaselinesOffsetColumn$1 listItemKt$BaselinesOffsetColumn$1 = new ListItemKt$BaselinesOffsetColumn$1(list);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
        int i13 = (((((i11 >> 6) & 14) | (i11 & 112)) << 9) & 7168) | 6;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r62, listItemKt$BaselinesOffsetColumn$1, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r62, density, companion.getSetDensity());
        Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r62, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i13 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        function2.invoke(startRestartGroup, Integer.valueOf((i13 >> 9) & 14));
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$BaselinesOffsetColumn$2(list, modifier2, function2, i11, i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fb  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][_][_][_]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ListItem(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, boolean r24, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r7 = r27
            r8 = r29
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -450923337(0xffffffffe51f74b7, float:-4.706308E22)
            r1 = r28
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r30 & 1
            if (r1 == 0) goto L_0x001c
            r2 = r8 | 6
            r3 = r2
            r2 = r21
            goto L_0x0030
        L_0x001c:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r21
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r8
            goto L_0x0030
        L_0x002d:
            r2 = r21
            r3 = r8
        L_0x0030:
            r4 = r30 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r8 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r22
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r22
        L_0x004c:
            r6 = r30 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r9 = r8 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0066
            r9 = r23
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0062
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r10
            goto L_0x0068
        L_0x0066:
            r9 = r23
        L_0x0068:
            r10 = r30 & 8
            if (r10 == 0) goto L_0x006f
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r11 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0082
            r11 = r24
            boolean r12 = r0.changed((boolean) r11)
            if (r12 == 0) goto L_0x007e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r12
            goto L_0x0084
        L_0x0082:
            r11 = r24
        L_0x0084:
            r12 = r30 & 16
            if (r12 == 0) goto L_0x008b
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00a0
            r13 = r25
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009c
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r3 = r3 | r14
            goto L_0x00a2
        L_0x00a0:
            r13 = r25
        L_0x00a2:
            r14 = r30 & 32
            if (r14 == 0) goto L_0x00aa
            r15 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r15
            goto L_0x00bf
        L_0x00aa:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00bf
            r15 = r26
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ba
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00c1
        L_0x00bf:
            r15 = r26
        L_0x00c1:
            r16 = r30 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00ca
            r3 = r3 | r17
            goto L_0x00dd
        L_0x00ca:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r8 & r16
            if (r16 != 0) goto L_0x00dd
            boolean r16 = r0.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x00d9
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r3 = r3 | r16
        L_0x00dd:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r2 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r2 != r5) goto L_0x00fb
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00ee
            goto L_0x00fb
        L_0x00ee:
            r0.skipToGroupEnd()
            r1 = r21
            r2 = r22
            r3 = r9
            r4 = r11
            r5 = r13
            r6 = r15
            goto L_0x01c8
        L_0x00fb:
            if (r1 == 0) goto L_0x0100
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0102
        L_0x0100:
            r1 = r21
        L_0x0102:
            r2 = 0
            if (r4 == 0) goto L_0x0107
            r4 = r2
            goto L_0x0109
        L_0x0107:
            r4 = r22
        L_0x0109:
            if (r6 == 0) goto L_0x010d
            r5 = r2
            goto L_0x010e
        L_0x010d:
            r5 = r9
        L_0x010e:
            if (r10 == 0) goto L_0x0113
            r19 = 1
            goto L_0x0115
        L_0x0113:
            r19 = r11
        L_0x0115:
            if (r12 == 0) goto L_0x0118
            r13 = r2
        L_0x0118:
            if (r14 == 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r2 = r15
        L_0x011c:
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            r10 = 6
            androidx.compose.material.Typography r9 = r9.getTypography(r0, r10)
            androidx.compose.ui.text.TextStyle r11 = r9.getSubtitle1()
            androidx.compose.material.ContentAlpha r12 = androidx.compose.material.ContentAlpha.INSTANCE
            float r14 = r12.getHigh(r0, r10)
            kotlin.jvm.functions.Function2 r14 = applyTextStyle(r11, r14, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            androidx.compose.ui.text.TextStyle r11 = r9.getBody2()
            float r15 = r12.getMedium(r0, r10)
            kotlin.jvm.functions.Function2 r15 = applyTextStyle(r11, r15, r5)
            androidx.compose.ui.text.TextStyle r11 = r9.getOverline()
            float r6 = r12.getHigh(r0, r10)
            kotlin.jvm.functions.Function2 r6 = applyTextStyle(r11, r6, r13)
            androidx.compose.ui.text.TextStyle r9 = r9.getCaption()
            float r10 = r12.getHigh(r0, r10)
            kotlin.jvm.functions.Function2 r16 = applyTextStyle(r9, r10, r2)
            androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1 r9 = androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1.INSTANCE
            r10 = 1
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r1, r10, r9)
            if (r15 != 0) goto L_0x0180
            if (r6 != 0) goto L_0x0180
            r6 = -210280579(0xfffffffff3775f7d, float:-1.9598908E31)
            r0.startReplaceableGroup(r6)
            androidx.compose.material.OneLine r9 = androidx.compose.material.OneLine.INSTANCE
            r3 = r3 & 112(0x70, float:1.57E-43)
            r15 = r3 | 24576(0x6000, float:3.4438E-41)
            r3 = 0
            r11 = r4
            r12 = r14
            r20 = r13
            r13 = r16
            r14 = r0
            r16 = r3
            r9.ListItem(r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            goto L_0x01c1
        L_0x0180:
            r20 = r13
            if (r6 != 0) goto L_0x0186
            if (r19 != 0) goto L_0x0188
        L_0x0186:
            if (r15 != 0) goto L_0x01a5
        L_0x0188:
            r9 = -210280382(0xfffffffff3776042, float:-1.9599146E31)
            r0.startReplaceableGroup(r9)
            androidx.compose.material.TwoLine r9 = androidx.compose.material.TwoLine.INSTANCE
            r3 = r3 & 112(0x70, float:1.57E-43)
            r17 = r3 | r17
            r18 = 0
            r11 = r4
            r12 = r14
            r13 = r15
            r14 = r6
            r15 = r16
            r16 = r0
            r9.ListItem(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.endReplaceableGroup()
            goto L_0x01c1
        L_0x01a5:
            r9 = -210280168(0xfffffffff3776118, float:-1.9599405E31)
            r0.startReplaceableGroup(r9)
            androidx.compose.material.ThreeLine r9 = androidx.compose.material.ThreeLine.INSTANCE
            r3 = r3 & 112(0x70, float:1.57E-43)
            r17 = r3 | r17
            r18 = 0
            r11 = r4
            r12 = r14
            r13 = r15
            r14 = r6
            r15 = r16
            r16 = r0
            r9.ListItem(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.endReplaceableGroup()
        L_0x01c1:
            r6 = r2
            r2 = r4
            r3 = r5
            r4 = r19
            r5 = r20
        L_0x01c8:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x01cf
            goto L_0x01de
        L_0x01cf:
            androidx.compose.material.ListItemKt$ListItem$1 r11 = new androidx.compose.material.ListItemKt$ListItem$1
            r0 = r11
            r7 = r27
            r8 = r29
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ListItemKt.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: OffsetToBaselineOrCenter-Kz89ssw  reason: not valid java name */
    public static final void m1281OffsetToBaselineOrCenterKz89ssw(float f11, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1062692685);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(f11)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        int i17 = i12 & 2;
        if (i17 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if ((i13 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                modifier = Modifier.Companion;
            }
            ListItemKt$OffsetToBaselineOrCenter$1 listItemKt$OffsetToBaselineOrCenter$1 = new ListItemKt$OffsetToBaselineOrCenter$1(f11);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i18 = ((((i13 & 112) | ((i13 >> 6) & 14)) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, listItemKt$OffsetToBaselineOrCenter$1, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r62, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i18 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i18 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$OffsetToBaselineOrCenter$2(f11, modifier2, function2, i11, i12));
        }
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(TextStyle textStyle, float f11, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new ListItemKt$applyTextStyle$1(f11, textStyle, function2));
    }
}
