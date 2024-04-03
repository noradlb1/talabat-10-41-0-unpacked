package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J~\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010\u001eR\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\r\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0010\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0012\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/material/TwoLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "OverlineBaselineOffset", "OverlineToPrimaryBaselineOffset", "PrimaryBaselineOffsetNoIcon", "PrimaryBaselineOffsetWithIcon", "PrimaryToSecondaryBaselineOffsetNoIcon", "PrimaryToSecondaryBaselineOffsetWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class TwoLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    @NotNull
    public static final TwoLine INSTANCE = new TwoLine();
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth = Dp.m5478constructorimpl((float) 40);
    private static final float IconVerticalPadding;
    private static final float MinHeight = Dp.m5478constructorimpl((float) 64);
    private static final float MinHeightWithIcon = Dp.m5478constructorimpl((float) 72);
    private static final float OverlineBaselineOffset = Dp.m5478constructorimpl((float) 24);
    private static final float OverlineToPrimaryBaselineOffset;
    private static final float PrimaryBaselineOffsetNoIcon = Dp.m5478constructorimpl((float) 28);
    private static final float PrimaryBaselineOffsetWithIcon = Dp.m5478constructorimpl((float) 32);
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon;
    /* access modifiers changed from: private */
    public static final float TrailingRightPadding;

    static {
        float f11 = (float) 16;
        IconLeftPadding = Dp.m5478constructorimpl(f11);
        IconVerticalPadding = Dp.m5478constructorimpl(f11);
        ContentLeftPadding = Dp.m5478constructorimpl(f11);
        ContentRightPadding = Dp.m5478constructorimpl(f11);
        float f12 = (float) 20;
        OverlineToPrimaryBaselineOffset = Dp.m5478constructorimpl(f12);
        PrimaryToSecondaryBaselineOffsetNoIcon = Dp.m5478constructorimpl(f12);
        PrimaryToSecondaryBaselineOffsetWithIcon = Dp.m5478constructorimpl(f12);
        TrailingRightPadding = Dp.m5478constructorimpl(f11);
    }

    private TwoLine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e4  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ListItem(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r33, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r32 = this;
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r8 = r40
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -1340612993(0xffffffffb017de7f, float:-5.5249666E-10)
            r1 = r39
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r41 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0025
            r9 = r8 | 6
            r10 = r9
            r9 = r33
            goto L_0x0039
        L_0x0025:
            r9 = r8 & 14
            if (r9 != 0) goto L_0x0036
            r9 = r33
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0033
            r10 = 4
            goto L_0x0034
        L_0x0033:
            r10 = r2
        L_0x0034:
            r10 = r10 | r8
            goto L_0x0039
        L_0x0036:
            r9 = r33
            r10 = r8
        L_0x0039:
            r11 = r41 & 2
            if (r11 == 0) goto L_0x0040
            r10 = r10 | 48
            goto L_0x0050
        L_0x0040:
            r11 = r8 & 112(0x70, float:1.57E-43)
            if (r11 != 0) goto L_0x0050
            boolean r11 = r0.changed((java.lang.Object) r3)
            if (r11 == 0) goto L_0x004d
            r11 = 32
            goto L_0x004f
        L_0x004d:
            r11 = 16
        L_0x004f:
            r10 = r10 | r11
        L_0x0050:
            r11 = r41 & 4
            if (r11 == 0) goto L_0x0057
            r10 = r10 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0057:
            r11 = r8 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x0067
            boolean r11 = r0.changed((java.lang.Object) r4)
            if (r11 == 0) goto L_0x0064
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r10 = r10 | r11
        L_0x0067:
            r11 = r41 & 8
            if (r11 == 0) goto L_0x006e
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006e:
            r11 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007e
            boolean r11 = r0.changed((java.lang.Object) r5)
            if (r11 == 0) goto L_0x007b
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r10 = r10 | r11
        L_0x007e:
            r11 = r41 & 16
            if (r11 == 0) goto L_0x0085
            r10 = r10 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0085:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r8
            if (r11 != 0) goto L_0x0097
            boolean r11 = r0.changed((java.lang.Object) r6)
            if (r11 == 0) goto L_0x0094
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r10 = r10 | r11
        L_0x0097:
            r11 = r41 & 32
            if (r11 == 0) goto L_0x009f
            r11 = 196608(0x30000, float:2.75506E-40)
        L_0x009d:
            r10 = r10 | r11
            goto L_0x00b0
        L_0x009f:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r8
            if (r11 != 0) goto L_0x00b0
            boolean r11 = r0.changed((java.lang.Object) r7)
            if (r11 == 0) goto L_0x00ad
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x009d
        L_0x00ad:
            r11 = 65536(0x10000, float:9.18355E-41)
            goto L_0x009d
        L_0x00b0:
            r11 = r41 & 64
            if (r11 == 0) goto L_0x00ba
            r11 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 | r11
            r15 = r32
            goto L_0x00cd
        L_0x00ba:
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r8
            r15 = r32
            if (r11 != 0) goto L_0x00cd
            boolean r11 = r0.changed((java.lang.Object) r15)
            if (r11 == 0) goto L_0x00ca
            r11 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r11 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r10 = r10 | r11
        L_0x00cd:
            r14 = r10
            r10 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r10 & r14
            r11 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r11) goto L_0x00e4
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x00de
            goto L_0x00e4
        L_0x00de:
            r0.skipToGroupEnd()
            r2 = r9
            goto L_0x0364
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00ea
        L_0x00e9:
            r1 = r9
        L_0x00ea:
            if (r3 != 0) goto L_0x00ef
            float r9 = MinHeight
            goto L_0x00f1
        L_0x00ef:
            float r9 = MinHeightWithIcon
        L_0x00f1:
            r13 = r9
            r9 = 0
            r10 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m546heightInVpY3zN4$default(r1, r13, r9, r2, r10)
            r10 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r10 = r10.getStart()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r12 = r11.getTop()
            r2 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r10, r12, r0, r2)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            r23 = r1
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r24 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r24.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.materializerOf(r9)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x014a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x014a:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x0157
            r0.createNode(r8)
            goto L_0x015a
        L_0x0157:
            r0.useNode()
        L_0x015a:
            r0.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r10, r15)
            kotlin.jvm.functions.Function2 r10 = r24.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r12, r10)
            kotlin.jvm.functions.Function2 r10 = r24.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r2, r10)
            kotlin.jvm.functions.Function2 r2 = r24.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r1, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r2 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r9.invoke(r1, r0, r8)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r2)
            androidx.compose.foundation.layout.RowScopeInstance r15 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r2 = 1912737507(0x72020ee3, float:2.576067E30)
            r0.startReplaceableGroup(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r17 = 1065353216(0x3f800000, float:1.0)
            r18 = 0
            r19 = 2
            r20 = 0
            r16 = r2
            androidx.compose.ui.Modifier r25 = p.e.a(r15, r16, r17, r18, r19, r20)
            float r26 = ContentLeftPadding
            r27 = 0
            float r28 = ContentRightPadding
            r29 = 0
            r30 = 10
            r31 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r25, r26, r27, r28, r29, r30, r31)
            r8 = -269995367(0xffffffffefe83299, float:-1.4372338E29)
            r0.startReplaceableGroup(r8)
            if (r3 == 0) goto L_0x02b3
            float r8 = IconLeftPadding
            float r9 = IconMinPaddedWidth
            float r9 = r9 + r8
            float r17 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r9)
            r19 = 0
            r20 = 0
            r21 = 12
            r22 = 0
            r16 = r2
            r18 = r13
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m562sizeInqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            float r19 = IconVerticalPadding
            r18 = 0
            r20 = 4
            r21 = 0
            r16 = r8
            r17 = r19
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.ui.Alignment r8 = r11.getTopStart()
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r9)
            r9 = 6
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r11, r0, r9)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            kotlin.jvm.functions.Function0 r15 = r24.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x023c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x023c:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x0249
            r0.createNode(r15)
            goto L_0x024c
        L_0x0249:
            r0.useNode()
        L_0x024c:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r8, r15)
            kotlin.jvm.functions.Function2 r8 = r24.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r9, r8)
            kotlin.jvm.functions.Function2 r8 = r24.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r11, r8)
            kotlin.jvm.functions.Function2 r8 = r24.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r12, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r2.invoke(r1, r0, r9)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r1 = 1698757508(0x6540fb84, float:5.6958376E22)
            r0.startReplaceableGroup(r1)
            int r1 = r14 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x02b3:
            r0.endReplaceableGroup()
            r1 = 1
            if (r6 == 0) goto L_0x02f2
            r2 = -269994745(0xffffffffefe83507, float:-1.4372926E29)
            r0.startReplaceableGroup(r2)
            r2 = 2
            androidx.compose.ui.unit.Dp[] r2 = new androidx.compose.ui.unit.Dp[r2]
            float r8 = OverlineBaselineOffset
            androidx.compose.ui.unit.Dp r8 = androidx.compose.ui.unit.Dp.m5476boximpl(r8)
            r9 = 0
            r2[r9] = r8
            float r8 = OverlineToPrimaryBaselineOffset
            androidx.compose.ui.unit.Dp r8 = androidx.compose.ui.unit.Dp.m5476boximpl(r8)
            r2[r1] = r8
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r2)
            androidx.compose.material.TwoLine$ListItem$1$2 r2 = new androidx.compose.material.TwoLine$ListItem$1$2
            r2.<init>(r6, r14, r4)
            r8 = -1675021441(0xffffffff9c29337f, float:-5.5983967E-22)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r8, r1, r2)
            r2 = 384(0x180, float:5.38E-43)
            r8 = 0
            r12 = r0
            r15 = r13
            r13 = r2
            r2 = r14
            r14 = r8
            androidx.compose.material.ListItemKt.BaselinesOffsetColumn(r9, r10, r11, r12, r13, r14)
            r0.endReplaceableGroup()
            goto L_0x0332
        L_0x02f2:
            r15 = r13
            r2 = r14
            r8 = -269994465(0xffffffffefe8361f, float:-1.437319E29)
            r0.startReplaceableGroup(r8)
            r8 = 2
            androidx.compose.ui.unit.Dp[] r8 = new androidx.compose.ui.unit.Dp[r8]
            if (r3 == 0) goto L_0x0302
            float r9 = PrimaryBaselineOffsetWithIcon
            goto L_0x0304
        L_0x0302:
            float r9 = PrimaryBaselineOffsetNoIcon
        L_0x0304:
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r9)
            r11 = 0
            r8[r11] = r9
            if (r3 == 0) goto L_0x0310
            float r9 = PrimaryToSecondaryBaselineOffsetWithIcon
            goto L_0x0312
        L_0x0310:
            float r9 = PrimaryToSecondaryBaselineOffsetNoIcon
        L_0x0312:
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r9)
            r8[r1] = r9
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r8)
            androidx.compose.material.TwoLine$ListItem$1$3 r8 = new androidx.compose.material.TwoLine$ListItem$1$3
            r8.<init>(r4, r2, r5)
            r11 = 993836488(0x3b3cbdc8, float:0.0028799642)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r1, r8)
            r13 = 384(0x180, float:5.38E-43)
            r14 = 0
            r12 = r0
            androidx.compose.material.ListItemKt.BaselinesOffsetColumn(r9, r10, r11, r12, r13, r14)
            r0.endReplaceableGroup()
        L_0x0332:
            if (r7 == 0) goto L_0x0350
            if (r3 == 0) goto L_0x0339
            float r8 = PrimaryBaselineOffsetWithIcon
            goto L_0x033b
        L_0x0339:
            float r8 = PrimaryBaselineOffsetNoIcon
        L_0x033b:
            r9 = r8
            r10 = 0
            androidx.compose.material.TwoLine$ListItem$1$4 r8 = new androidx.compose.material.TwoLine$ListItem$1$4
            r8.<init>(r15, r7, r2)
            r2 = -1696992176(0xffffffff9ad9f450, float:-9.0143805E-23)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r1, r8)
            r13 = 384(0x180, float:5.38E-43)
            r14 = 2
            r12 = r0
            androidx.compose.material.ListItemKt.m1281OffsetToBaselineOrCenterKz89ssw(r9, r10, r11, r12, r13, r14)
        L_0x0350:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r23
        L_0x0364:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x036b
            goto L_0x0384
        L_0x036b:
            androidx.compose.material.TwoLine$ListItem$2 r11 = new androidx.compose.material.TwoLine$ListItem$2
            r0 = r11
            r1 = r32
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r8 = r40
            r9 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x0384:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TwoLine.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
