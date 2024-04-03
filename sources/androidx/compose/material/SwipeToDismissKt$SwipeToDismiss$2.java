package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeToDismissKt$SwipeToDismiss$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set<DismissDirection> f5582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<DismissDirection, ThresholdConfig> f5583h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5584i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DismissState f5585j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f5586k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f5587l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$SwipeToDismiss$2(Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, int i11, DismissState dismissState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32) {
        super(3);
        this.f5582g = set;
        this.f5583h = function1;
        this.f5584i = i11;
        this.f5585j = dismissState;
        this.f5586k = function3;
        this.f5587l = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r3 = r24 & 14
            if (r3 != 0) goto L_0x001b
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0017
            r3 = 4
            goto L_0x0018
        L_0x0017:
            r3 = 2
        L_0x0018:
            r3 = r24 | r3
            goto L_0x001d
        L_0x001b:
            r3 = r24
        L_0x001d:
            r3 = r3 & 91
            r5 = 18
            if (r3 != r5) goto L_0x002f
            boolean r3 = r23.getSkipping()
            if (r3 != 0) goto L_0x002a
            goto L_0x002f
        L_0x002a:
            r23.skipToGroupEnd()
            goto L_0x03bc
        L_0x002f:
            long r5 = r22.m434getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r5)
            float r1 = (float) r1
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r2.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r5 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r6 = 1
            r7 = 0
            if (r3 != r5) goto L_0x0048
            r13 = r6
            goto L_0x0049
        L_0x0048:
            r13 = r7
        L_0x0049:
            kotlin.Pair[] r3 = new kotlin.Pair[r6]
            r5 = 0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.material.DismissValue r8 = androidx.compose.material.DismissValue.Default
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r8)
            r3[r7] = r5
            java.util.Map r10 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r3)
            java.util.Set<androidx.compose.material.DismissDirection> r3 = r0.f5582g
            androidx.compose.material.DismissDirection r5 = androidx.compose.material.DismissDirection.StartToEnd
            boolean r3 = r3.contains(r5)
            if (r3 == 0) goto L_0x007b
            java.lang.Float r3 = java.lang.Float.valueOf(r1)
            androidx.compose.material.DismissValue r9 = androidx.compose.material.DismissValue.DismissedToEnd
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r9)
            java.lang.Object r9 = r3.getFirst()
            java.lang.Object r3 = r3.getSecond()
            r10.put(r9, r3)
        L_0x007b:
            java.util.Set<androidx.compose.material.DismissDirection> r3 = r0.f5582g
            androidx.compose.material.DismissDirection r9 = androidx.compose.material.DismissDirection.EndToStart
            boolean r3 = r3.contains(r9)
            if (r3 == 0) goto L_0x009b
            float r3 = -r1
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.material.DismissValue r11 = androidx.compose.material.DismissValue.DismissedToStart
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r11)
            java.lang.Object r11 = r3.getFirst()
            java.lang.Object r3 = r3.getSecond()
            r10.put(r11, r3)
        L_0x009b:
            kotlin.jvm.functions.Function1<androidx.compose.material.DismissDirection, androidx.compose.material.ThresholdConfig> r3 = r0.f5583h
            r15 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r15)
            boolean r11 = r2.changed((java.lang.Object) r3)
            java.lang.Object r12 = r23.rememberedValue()
            if (r11 != 0) goto L_0x00b5
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x00bd
        L_0x00b5:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 r12 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
            r12.<init>(r3)
            r2.updateRememberedValue(r12)
        L_0x00bd:
            r23.endReplaceableGroup()
            r3 = r12
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.util.Set<androidx.compose.material.DismissDirection> r11 = r0.f5582g
            boolean r9 = r11.contains(r9)
            r11 = 1092616192(0x41200000, float:10.0)
            r12 = 1101004800(0x41a00000, float:20.0)
            if (r9 == 0) goto L_0x00d1
            r9 = r11
            goto L_0x00d2
        L_0x00d1:
            r9 = r12
        L_0x00d2:
            java.util.Set<androidx.compose.material.DismissDirection> r14 = r0.f5582g
            boolean r5 = r14.contains(r5)
            if (r5 == 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r11 = r12
        L_0x00dc:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r12 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.material.DismissState r14 = r0.f5585j
            java.lang.Object r14 = r14.getCurrentValue()
            if (r14 != r8) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r6 = r7
        L_0x00ea:
            androidx.compose.material.ResistanceConfig r14 = new androidx.compose.material.ResistanceConfig
            r14.<init>(r1, r9, r11)
            androidx.compose.material.DismissState r9 = r0.f5585j
            r1 = 0
            r17 = 0
            r18 = 288(0x120, float:4.04E-43)
            r19 = 0
            r8 = r5
            r11 = r12
            r12 = r6
            r6 = r14
            r14 = r1
            r1 = r15
            r15 = r3
            r16 = r6
            androidx.compose.ui.Modifier r3 = androidx.compose.material.SwipeableKt.m1395swipeablepPrIpRY$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.f5586k
            int r8 = r0.f5584i
            androidx.compose.material.DismissState r9 = r0.f5585j
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.f5587l
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r11)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r11.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r7, r2, r7)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r14 = r2.consume(r14)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r1 = r2.consume(r1)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r13 = r23.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0156
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0156:
            r23.startReusableNode()
            boolean r13 = r23.getInserting()
            if (r13 == 0) goto L_0x0163
            r2.createNode(r4)
            goto L_0x0166
        L_0x0163:
            r23.useNode()
        L_0x0166:
            r23.disableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2536constructorimpl(r23)
            kotlin.jvm.functions.Function2 r13 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r12, r13)
            kotlin.jvm.functions.Function2 r12 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r14, r12)
            kotlin.jvm.functions.Function2 r12 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r15, r12)
            kotlin.jvm.functions.Function2 r12 = r17.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r1, r12)
            r23.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r23)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3.invoke(r1, r2, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r2.startReplaceableGroup(r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r4 = 981834387(0x3a859a93, float:0.0010193161)
            r2.startReplaceableGroup(r4)
            androidx.compose.ui.Modifier r3 = r3.matchParentSize(r5)
            int r4 = r8 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            r2.startReplaceableGroup(r7)
            androidx.compose.foundation.layout.Arrangement r12 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r13 = r12.getStart()
            androidx.compose.ui.Alignment$Vertical r14 = r11.getTop()
            int r15 = r4 >> 3
            r19 = r15 & 14
            r15 = r15 & 112(0x70, float:1.57E-43)
            r15 = r19 | r15
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r13, r14, r2, r15)
            int r14 = r4 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r1 = r2.consume(r1)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            kotlin.jvm.functions.Function0 r0 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            int r14 = r14 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r20 = r10
            androidx.compose.runtime.Applier r10 = r23.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0216
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0216:
            r23.startReusableNode()
            boolean r10 = r23.getInserting()
            if (r10 == 0) goto L_0x0223
            r2.createNode(r0)
            goto L_0x0226
        L_0x0223:
            r23.useNode()
        L_0x0226:
            r23.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2536constructorimpl(r23)
            kotlin.jvm.functions.Function2 r10 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r13, r10)
            kotlin.jvm.functions.Function2 r10 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r15, r10)
            kotlin.jvm.functions.Function2 r10 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r7, r10)
            kotlin.jvm.functions.Function2 r7 = r17.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r1, r7)
            r23.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r23)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
            int r1 = r14 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r2, r1)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r14 >> 9
            r0 = r0 & 14
            r1 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r2.startReplaceableGroup(r1)
            r0 = r0 & 11
            r3 = 2
            if (r0 != r3) goto L_0x027f
            boolean r0 = r23.getSkipping()
            if (r0 != 0) goto L_0x027b
            goto L_0x027f
        L_0x027b:
            r23.skipToGroupEnd()
            goto L_0x028e
        L_0x027f:
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r3 = r4 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6.invoke(r0, r2, r3)
        L_0x028e:
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r23.endNode()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r0 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r0)
            boolean r0 = r2.changed((java.lang.Object) r9)
            java.lang.Object r3 = r23.rememberedValue()
            if (r0 != 0) goto L_0x02b5
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x02bd
        L_0x02b5:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1 r3 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
            r3.<init>(r9)
            r2.updateRememberedValue(r3)
        L_0x02bd:
            r23.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.offset(r5, r3)
            int r3 = r8 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r4 = 693286680(0x2952b718, float:4.6788176E-14)
            r2.startReplaceableGroup(r4)
            androidx.compose.foundation.layout.Arrangement$Horizontal r4 = r12.getStart()
            androidx.compose.ui.Alignment$Vertical r5 = r11.getTop()
            int r6 = r3 >> 3
            r7 = r6 & 14
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r4, r5, r2, r6)
            int r5 = r3 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r2.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r8 = r2.consume(r8)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            kotlin.jvm.functions.Function0 r9 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r5 = r5 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | 6
            androidx.compose.runtime.Applier r10 = r23.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0324
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0324:
            r23.startReusableNode()
            boolean r10 = r23.getInserting()
            if (r10 == 0) goto L_0x0331
            r2.createNode(r9)
            goto L_0x0334
        L_0x0331:
            r23.useNode()
        L_0x0334:
            r23.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2536constructorimpl(r23)
            kotlin.jvm.functions.Function2 r10 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r9, r4, r10)
            kotlin.jvm.functions.Function2 r4 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r9, r6, r4)
            kotlin.jvm.functions.Function2 r4 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r9, r7, r4)
            kotlin.jvm.functions.Function2 r4 = r17.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r9, r8, r4)
            r23.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r23)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r4)
            int r6 = r5 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.invoke(r4, r2, r6)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r5 >> 9
            r0 = r0 & 14
            r2.startReplaceableGroup(r1)
            r0 = r0 & 11
            r1 = 2
            if (r0 != r1) goto L_0x038a
            boolean r0 = r23.getSkipping()
            if (r0 != 0) goto L_0x0386
            goto L_0x038a
        L_0x0386:
            r23.skipToGroupEnd()
            goto L_0x039b
        L_0x038a:
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r3 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r20
            r3.invoke(r0, r2, r1)
        L_0x039b:
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r23.endNode()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
            r23.endNode()
            r23.endReplaceableGroup()
            r23.endReplaceableGroup()
        L_0x03bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
