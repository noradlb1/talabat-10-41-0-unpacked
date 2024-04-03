package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001aS\u0010\u001e\u001a\u00020\u00112\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0002\u0010!\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\"\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\"\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\"\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\"\u0019\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"BadgeContentFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "BadgeHorizontalOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeHorizontalOffset", "()F", "F", "BadgeRadius", "getBadgeRadius", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentRadius", "getBadgeWithContentRadius", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BadgeKt {
    /* access modifiers changed from: private */
    public static final long BadgeContentFontSize = TextUnitKt.getSp(10);
    private static final float BadgeHorizontalOffset;
    private static final float BadgeRadius;
    private static final float BadgeWithContentHorizontalOffset = Dp.m5478constructorimpl(-Dp.m5478constructorimpl((float) 6));
    private static final float BadgeWithContentHorizontalPadding;
    private static final float BadgeWithContentRadius = Dp.m5478constructorimpl((float) 8);

    static {
        float f11 = (float) 4;
        BadgeRadius = Dp.m5478constructorimpl(f11);
        BadgeWithContentHorizontalPadding = Dp.m5478constructorimpl(f11);
        BadgeHorizontalOffset = Dp.m5478constructorimpl(-Dp.m5478constructorimpl(f11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Badge-eopBjH0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1103BadgeeopBjH0(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r16, long r17, long r19, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r23
            r0 = 1133484502(0x438f99d6, float:287.20184)
            r1 = r22
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r24 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0016
            r3 = r7 | 6
            r4 = r3
            r3 = r16
            goto L_0x002a
        L_0x0016:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x0027
            r3 = r16
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0024
            r4 = 4
            goto L_0x0025
        L_0x0024:
            r4 = r2
        L_0x0025:
            r4 = r4 | r7
            goto L_0x002a
        L_0x0027:
            r3 = r16
            r4 = r7
        L_0x002a:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0043
            r5 = r24 & 2
            if (r5 != 0) goto L_0x003d
            r5 = r17
            boolean r8 = r0.changed((long) r5)
            if (r8 == 0) goto L_0x003f
            r8 = 32
            goto L_0x0041
        L_0x003d:
            r5 = r17
        L_0x003f:
            r8 = 16
        L_0x0041:
            r4 = r4 | r8
            goto L_0x0045
        L_0x0043:
            r5 = r17
        L_0x0045:
            r8 = r7 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005e
            r8 = r24 & 4
            if (r8 != 0) goto L_0x0058
            r8 = r19
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x005a
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r8 = r19
        L_0x005a:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r10
            goto L_0x0060
        L_0x005e:
            r8 = r19
        L_0x0060:
            r10 = r24 & 8
            if (r10 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r11 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007a
            r11 = r21
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0076
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r12
            goto L_0x007c
        L_0x007a:
            r11 = r21
        L_0x007c:
            r12 = r4 & 5851(0x16db, float:8.199E-42)
            r13 = 1170(0x492, float:1.64E-42)
            if (r12 != r13) goto L_0x0092
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x0089
            goto L_0x0092
        L_0x0089:
            r0.skipToGroupEnd()
            r1 = r3
        L_0x008d:
            r2 = r5
            r4 = r8
            r6 = r11
            goto L_0x01ee
        L_0x0092:
            r0.startDefaults()
            r12 = r7 & 1
            r13 = 0
            r14 = 6
            if (r12 == 0) goto L_0x00b3
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00a2
            goto L_0x00b3
        L_0x00a2:
            r0.skipToGroupEnd()
            r1 = r24 & 2
            if (r1 == 0) goto L_0x00ab
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ab:
            r1 = r24 & 4
            if (r1 == 0) goto L_0x00b1
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b1:
            r1 = r3
            goto L_0x00db
        L_0x00b3:
            if (r1 == 0) goto L_0x00b8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00b9
        L_0x00b8:
            r1 = r3
        L_0x00b9:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x00c9
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r3 = r3.getColors(r0, r14)
            long r5 = r3.m1173getError0d7_KjU()
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c9:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x00d8
            int r3 = r4 >> 3
            r3 = r3 & 14
            long r8 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r5, r0, r3)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x00d8:
            if (r10 == 0) goto L_0x00db
            r11 = r13
        L_0x00db:
            r0.endDefaults()
            if (r11 == 0) goto L_0x00e3
            float r3 = BadgeWithContentRadius
            goto L_0x00e5
        L_0x00e3:
            float r3 = BadgeRadius
        L_0x00e5:
            androidx.compose.foundation.shape.RoundedCornerShape r10 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r3)
            float r12 = (float) r2
            float r3 = r3 * r12
            float r12 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m542defaultMinSizeVpY3zN4(r1, r12, r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r3, r5, r10)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clip(r3, r10)
            float r10 = BadgeWithContentHorizontalPadding
            r12 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m488paddingVpY3zN4$default(r3, r10, r12, r2, r13)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r10 = r10.getCenter()
            r12 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r12)
            r12 = 54
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r10, r3, r0, r12)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r16 = r1
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0159
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0159:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x0166
            r0.createNode(r14)
            goto L_0x0169
        L_0x0166:
            r0.useNode()
        L_0x0169:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r14 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r3, r14)
            kotlin.jvm.functions.Function2 r3 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r10, r3)
            kotlin.jvm.functions.Function2 r3 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r12, r3)
            kotlin.jvm.functions.Function2 r3 = r15.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r13, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r3 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            r2.invoke(r1, r0, r10)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r2 = -1024875974(0xffffffffc2e9a23a, float:-116.81685)
            r0.startReplaceableGroup(r2)
            if (r11 == 0) goto L_0x01d8
            r2 = 1
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r2]
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r13 = androidx.compose.ui.graphics.Color.m2909boximpl(r8)
            androidx.compose.runtime.ProvidedValue r12 = r12.provides(r13)
            r10[r3] = r12
            androidx.compose.material.BadgeKt$Badge$1$1 r3 = new androidx.compose.material.BadgeKt$Badge$1$1
            r12 = 6
            r3.<init>(r11, r1, r12, r4)
            r1 = 1784526485(0x6a5db695, float:6.7008706E25)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r2, r3)
            r2 = 56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r10, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r2)
        L_0x01d8:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r1 = r16
            goto L_0x008d
        L_0x01ee:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x01f5
            goto L_0x0202
        L_0x01f5:
            androidx.compose.material.BadgeKt$Badge$2 r10 = new androidx.compose.material.BadgeKt$Badge$2
            r0 = r10
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r4, r6, r7, r8)
            r9.updateScope(r10)
        L_0x0202:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BadgeKt.m1103BadgeeopBjH0(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BadgedBox(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r18
            r3 = r20
            r4 = r22
            java.lang.String r0 = "badge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 859805272(0x333f9658, float:4.460739E-8)
            r5 = r21
            androidx.compose.runtime.Composer r2 = r5.startRestartGroup(r2)
            r5 = r23 & 1
            if (r5 == 0) goto L_0x0020
            r5 = r4 | 6
            goto L_0x0030
        L_0x0020:
            r5 = r4 & 14
            if (r5 != 0) goto L_0x002f
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r4
            goto L_0x0030
        L_0x002f:
            r5 = r4
        L_0x0030:
            r7 = r23 & 2
            if (r7 == 0) goto L_0x0037
            r5 = r5 | 48
            goto L_0x004a
        L_0x0037:
            r8 = r4 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004a
            r8 = r19
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r5 = r5 | r9
            goto L_0x004c
        L_0x004a:
            r8 = r19
        L_0x004c:
            r9 = r23 & 4
            if (r9 == 0) goto L_0x0053
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0053:
            r9 = r4 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0063
            boolean r9 = r2.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r5 = r5 | r9
        L_0x0063:
            r9 = r5 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x0078
            boolean r9 = r2.getSkipping()
            if (r9 != 0) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            r2.skipToGroupEnd()
            r4 = r1
            r17 = r8
            goto L_0x0314
        L_0x0078:
            if (r7 == 0) goto L_0x007d
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            goto L_0x007e
        L_0x007d:
            r7 = r8
        L_0x007e:
            androidx.compose.material.BadgeKt$BadgedBox$2 r8 = androidx.compose.material.BadgeKt$BadgedBox$2.INSTANCE
            r9 = r5 & 112(0x70, float:1.57E-43)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r10)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r2.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r2.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r13 = r2.consume(r13)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            int r9 = r9 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            androidx.compose.runtime.Applier r6 = r2.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x00c1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00c1:
            r2.startReusableNode()
            boolean r6 = r2.getInserting()
            if (r6 == 0) goto L_0x00ce
            r2.createNode(r15)
            goto L_0x00d1
        L_0x00ce:
            r2.useNode()
        L_0x00d1:
            r2.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2536constructorimpl(r2)
            kotlin.jvm.functions.Function2 r15 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r8, r15)
            kotlin.jvm.functions.Function2 r8 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r11, r8)
            kotlin.jvm.functions.Function2 r8 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r12, r8)
            kotlin.jvm.functions.Function2 r8 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r13, r8)
            r2.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r6)
            int r8 = r9 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.invoke(r6, r2, r8)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r6)
            int r8 = r9 >> 9
            r8 = r8 & 14
            r9 = 1799938959(0x6b48e38f, float:2.4285978E26)
            r2.startReplaceableGroup(r9)
            r8 = r8 & 11
            r9 = 2
            if (r8 != r9) goto L_0x012e
            boolean r8 = r2.getSkipping()
            if (r8 != 0) goto L_0x0126
            goto L_0x012e
        L_0x0126:
            r2.skipToGroupEnd()
            r4 = r1
            r17 = r7
            goto L_0x0308
        L_0x012e:
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            java.lang.String r9 = "anchor"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r9)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r10.getCenter()
            int r12 = r5 << 3
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | 54
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r13)
            int r15 = r12 >> 3
            r16 = r15 & 14
            r15 = r15 & 112(0x70, float:1.57E-43)
            r15 = r16 | r15
            r13 = 0
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r13, r2, r15)
            int r15 = r12 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r13 = r2.consume(r13)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r6 = r2.consume(r6)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r4 = r2.consume(r4)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            r17 = r7
            kotlin.jvm.functions.Function0 r7 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.materializerOf(r9)
            int r15 = r15 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r15 = r15 | 6
            androidx.compose.runtime.Applier r1 = r2.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0198
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0198:
            r2.startReusableNode()
            boolean r1 = r2.getInserting()
            if (r1 == 0) goto L_0x01a5
            r2.createNode(r7)
            goto L_0x01a8
        L_0x01a5:
            r2.useNode()
        L_0x01a8:
            r2.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r2)
            kotlin.jvm.functions.Function2 r7 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r11, r7)
            kotlin.jvm.functions.Function2 r7 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r13, r7)
            kotlin.jvm.functions.Function2 r7 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r6, r7)
            kotlin.jvm.functions.Function2 r6 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r4, r6)
            r2.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            int r4 = r15 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r9.invoke(r1, r2, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            int r1 = r15 >> 9
            r1 = r1 & 14
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r2.startReplaceableGroup(r4)
            r1 = r1 & 11
            r6 = 2
            if (r1 != r6) goto L_0x0201
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x01fd
            goto L_0x0201
        L_0x01fd:
            r2.skipToGroupEnd()
            goto L_0x0210
        L_0x0201:
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r12 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3.invoke(r1, r2, r6)
        L_0x0210:
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r0)
            int r1 = r5 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r5)
            androidx.compose.ui.Alignment r5 = r10.getTopStart()
            int r6 = r1 >> 3
            r7 = r6 & 14
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r7, r2, r6)
            int r6 = r1 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r8 = r2.consume(r8)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r9 = r2.consume(r9)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            kotlin.jvm.functions.Function0 r10 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r6 = r6 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | 6
            androidx.compose.runtime.Applier r11 = r2.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0280
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0280:
            r2.startReusableNode()
            boolean r11 = r2.getInserting()
            if (r11 == 0) goto L_0x028d
            r2.createNode(r10)
            goto L_0x0290
        L_0x028d:
            r2.useNode()
        L_0x0290:
            r2.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2536constructorimpl(r2)
            kotlin.jvm.functions.Function2 r11 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r5, r11)
            kotlin.jvm.functions.Function2 r5 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r7, r5)
            kotlin.jvm.functions.Function2 r5 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r8, r5)
            kotlin.jvm.functions.Function2 r5 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r9, r5)
            r2.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r5)
            int r7 = r6 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.invoke(r5, r2, r7)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r6 >> 9
            r0 = r0 & 14
            r2.startReplaceableGroup(r4)
            r0 = r0 & 11
            r4 = 2
            if (r0 != r4) goto L_0x02e8
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x02e2
            goto L_0x02e8
        L_0x02e2:
            r2.skipToGroupEnd()
            r4 = r18
            goto L_0x02f9
        L_0x02e8:
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r1 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4 = r18
            r4.invoke(r0, r2, r1)
        L_0x02f9:
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
        L_0x0308:
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
        L_0x0314:
            androidx.compose.runtime.ScopeUpdateScope r6 = r2.endRestartGroup()
            if (r6 != 0) goto L_0x031b
            goto L_0x032e
        L_0x031b:
            androidx.compose.material.BadgeKt$BadgedBox$3 r7 = new androidx.compose.material.BadgeKt$BadgedBox$3
            r0 = r7
            r1 = r18
            r2 = r17
            r3 = r20
            r4 = r22
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BadgeKt.BadgedBox(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getBadgeHorizontalOffset() {
        return BadgeHorizontalOffset;
    }

    public static final float getBadgeRadius() {
        return BadgeRadius;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentRadius() {
        return BadgeWithContentRadius;
    }
}
