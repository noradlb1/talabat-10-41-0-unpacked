package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0002\b\u00132\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/OneLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class OneLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    @NotNull
    public static final OneLine INSTANCE = new OneLine();
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth = Dp.m5478constructorimpl((float) 40);
    private static final float IconVerticalPadding = Dp.m5478constructorimpl((float) 8);
    private static final float MinHeight = Dp.m5478constructorimpl((float) 48);
    private static final float MinHeightWithIcon = Dp.m5478constructorimpl((float) 56);
    private static final float TrailingRightPadding;

    static {
        float f11 = (float) 16;
        IconLeftPadding = Dp.m5478constructorimpl(f11);
        ContentLeftPadding = Dp.m5478constructorimpl(f11);
        ContentRightPadding = Dp.m5478constructorimpl(f11);
        TrailingRightPadding = Dp.m5478constructorimpl(f11);
    }

    private OneLine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ListItem(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r31 = this;
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r37
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -1884451315(0xffffffff8fad8e0d, float:-1.7113833E-29)
            r1 = r36
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r38 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0021
            r7 = r6 | 6
            r8 = r7
            r7 = r32
            goto L_0x0035
        L_0x0021:
            r7 = r6 & 14
            if (r7 != 0) goto L_0x0032
            r7 = r32
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x002f
            r8 = 4
            goto L_0x0030
        L_0x002f:
            r8 = r2
        L_0x0030:
            r8 = r8 | r6
            goto L_0x0035
        L_0x0032:
            r7 = r32
            r8 = r6
        L_0x0035:
            r9 = r38 & 2
            if (r9 == 0) goto L_0x003c
            r8 = r8 | 48
            goto L_0x004c
        L_0x003c:
            r9 = r6 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x004c
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0049
            r9 = 32
            goto L_0x004b
        L_0x0049:
            r9 = 16
        L_0x004b:
            r8 = r8 | r9
        L_0x004c:
            r9 = r38 & 4
            if (r9 == 0) goto L_0x0053
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0053:
            r9 = r6 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0063
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r8 = r8 | r9
        L_0x0063:
            r9 = r38 & 8
            if (r9 == 0) goto L_0x006a
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r9 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007a
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x0077
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r8 = r8 | r9
        L_0x007a:
            r9 = r38 & 16
            if (r9 == 0) goto L_0x0081
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0081:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r6
            if (r9 != 0) goto L_0x0096
            r9 = r31
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0092
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r8 = r8 | r10
            goto L_0x0098
        L_0x0096:
            r9 = r31
        L_0x0098:
            r10 = 46811(0xb6db, float:6.5596E-41)
            r10 = r10 & r8
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r10 != r11) goto L_0x00ad
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x00a7
            goto L_0x00ad
        L_0x00a7:
            r0.skipToGroupEnd()
            r2 = r7
            goto L_0x0432
        L_0x00ad:
            if (r1 == 0) goto L_0x00b2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00b3
        L_0x00b2:
            r1 = r7
        L_0x00b3:
            if (r3 != 0) goto L_0x00b8
            float r7 = MinHeight
            goto L_0x00ba
        L_0x00b8:
            float r7 = MinHeightWithIcon
        L_0x00ba:
            r10 = 0
            r11 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m546heightInVpY3zN4$default(r1, r7, r10, r2, r11)
            r12 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r12)
            androidx.compose.foundation.layout.Arrangement r12 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r12 = r12.getStart()
            androidx.compose.ui.Alignment$Companion r13 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r14 = r13.getTop()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r12, r14, r0, r15)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0110
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0110:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x011d
            r0.createNode(r11)
            goto L_0x0120
        L_0x011d:
            r0.useNode()
        L_0x0120:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r12, r15)
            kotlin.jvm.functions.Function2 r12 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r14, r12)
            kotlin.jvm.functions.Function2 r12 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r2, r12)
            kotlin.jvm.functions.Function2 r2 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r10, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.invoke(r2, r0, r11)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r7 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r7)
            androidx.compose.foundation.layout.RowScopeInstance r7 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r10 = -2040473487(0xffffffff8660d871, float:-4.2288734E-35)
            r0.startReplaceableGroup(r10)
            r10 = 1825884304(0x6cd4c890, float:2.0579152E27)
            r0.startReplaceableGroup(r10)
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            if (r3 == 0) goto L_0x025c
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Alignment$Vertical r15 = r13.getCenterVertically()
            androidx.compose.ui.Modifier r14 = r7.align(r14, r15)
            float r18 = IconLeftPadding
            float r15 = IconMinPaddedWidth
            float r15 = r18 + r15
            float r15 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r15)
            r2 = 0
            r10 = 0
            r12 = 2
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.layout.SizeKt.m565widthInVpY3zN4$default(r14, r15, r2, r12, r10)
            float r21 = IconVerticalPadding
            r20 = 0
            r22 = 4
            r23 = 0
            r19 = r21
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r17, r18, r19, r20, r21, r22, r23)
            androidx.compose.ui.Alignment r10 = r13.getCenterStart()
            r0.startReplaceableGroup(r11)
            r12 = 6
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r14, r0, r12)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.ui.platform.ViewConfiguration r15 = (androidx.compose.ui.platform.ViewConfiguration) r15
            kotlin.jvm.functions.Function0 r11 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r23 = r1
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x01e4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01e4:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x01f1
            r0.createNode(r11)
            goto L_0x01f4
        L_0x01f1:
            r0.useNode()
        L_0x01f4:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r11 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r10, r11)
            kotlin.jvm.functions.Function2 r10 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r12, r10)
            kotlin.jvm.functions.Function2 r10 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r14, r10)
            kotlin.jvm.functions.Function2 r10 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r15, r10)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r2.invoke(r1, r0, r11)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r1 = 722575250(0x2b119f92, float:5.1735797E-13)
            r0.startReplaceableGroup(r1)
            int r1 = r8 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x025e
        L_0x025c:
            r23 = r1
        L_0x025e:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r21 = 2
            r22 = 0
            r17 = r7
            r18 = r1
            androidx.compose.ui.Modifier r2 = p.e.a(r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Alignment$Vertical r10 = r13.getCenterVertically()
            androidx.compose.ui.Modifier r24 = r7.align(r2, r10)
            float r25 = ContentLeftPadding
            r26 = 0
            float r27 = ContentRightPadding
            r28 = 0
            r29 = 10
            r30 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r24, r25, r26, r27, r28, r29, r30)
            androidx.compose.ui.Alignment r10 = r13.getCenterStart()
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r11)
            r11 = 6
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r12, r0, r11)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            kotlin.jvm.functions.Function0 r15 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r3 = r0.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x02d2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02d2:
            r0.startReusableNode()
            boolean r3 = r0.getInserting()
            if (r3 == 0) goto L_0x02df
            r0.createNode(r15)
            goto L_0x02e2
        L_0x02df:
            r0.useNode()
        L_0x02e2:
            r0.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r10, r15)
            kotlin.jvm.functions.Function2 r10 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r11, r10)
            kotlin.jvm.functions.Function2 r10 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r12, r10)
            kotlin.jvm.functions.Function2 r10 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r14, r10)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r3)
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r2.invoke(r3, r0, r11)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r2)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r2 = -869001737(0xffffffffcc3415f7, float:-4.7208412E7)
            r0.startReplaceableGroup(r2)
            int r2 = r8 >> 6
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.invoke(r0, r2)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            if (r5 == 0) goto L_0x041e
            androidx.compose.ui.Alignment$Vertical r2 = r13.getCenterVertically()
            androidx.compose.ui.Modifier r24 = r7.align(r1, r2)
            r25 = 0
            r26 = 0
            float r27 = TrailingRightPadding
            r28 = 0
            r29 = 11
            r30 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r24, r25, r26, r27, r28, r29, r30)
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r2)
            androidx.compose.ui.Alignment r2 = r13.getTopStart()
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r3, r0, r3)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            kotlin.jvm.functions.Function0 r11 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r12 = r0.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x03a9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03a9:
            r0.startReusableNode()
            boolean r12 = r0.getInserting()
            if (r12 == 0) goto L_0x03b6
            r0.createNode(r11)
            goto L_0x03b9
        L_0x03b6:
            r0.useNode()
        L_0x03b9:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r12 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r2, r12)
            kotlin.jvm.functions.Function2 r2 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r3, r2)
            kotlin.jvm.functions.Function2 r2 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r7, r2)
            kotlin.jvm.functions.Function2 r2 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r10, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.invoke(r2, r0, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            r1 = 9272137(0x8d7b49, float:1.2993031E-38)
            r0.startReplaceableGroup(r1)
            int r1 = r8 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r5.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x041e:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r23
        L_0x0432:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0439
            goto L_0x044e
        L_0x0439:
            androidx.compose.material.OneLine$ListItem$2 r10 = new androidx.compose.material.OneLine$ListItem$2
            r0 = r10
            r1 = r31
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r37
            r7 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r10)
        L_0x044e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OneLine.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
