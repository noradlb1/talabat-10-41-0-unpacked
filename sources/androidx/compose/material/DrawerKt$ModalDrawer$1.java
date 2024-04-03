package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$ModalDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DrawerState f4454g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4455h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4456i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f4457j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f4458k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f4459l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4460m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f4461n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4462o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f4463p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4464q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$1(DrawerState drawerState, boolean z11, int i11, long j11, Shape shape, long j12, long j13, float f11, Function2<? super Composer, ? super Integer, Unit> function2, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.f4454g = drawerState;
        this.f4455h = z11;
        this.f4456i = i11;
        this.f4457j = j11;
        this.f4458k = shape;
        this.f4459l = j12;
        this.f4460m = j13;
        this.f4461n = f11;
        this.f4462o = function2;
        this.f4463p = coroutineScope;
        this.f4464q = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r13 = r34
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r35 & 14
            r3 = 2
            if (r2 != 0) goto L_0x001c
            boolean r2 = r13.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0018
            r2 = 4
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            r2 = r35 | r2
            goto L_0x001e
        L_0x001c:
            r2 = r35
        L_0x001e:
            r2 = r2 & 91
            r4 = 18
            if (r2 != r4) goto L_0x0030
            boolean r2 = r34.getSkipping()
            if (r2 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r34.skipToGroupEnd()
            goto L_0x032f
        L_0x0030:
            long r8 = r33.m434getConstraintsmsEJaDk()
            boolean r1 = androidx.compose.ui.unit.Constraints.m5418getHasBoundedWidthimpl(r8)
            if (r1 == 0) goto L_0x0330
            int r1 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r8)
            float r1 = (float) r1
            float r1 = -r1
            kotlin.Pair[] r2 = new kotlin.Pair[r3]
            java.lang.Float r3 = java.lang.Float.valueOf(r1)
            androidx.compose.material.DrawerValue r4 = androidx.compose.material.DrawerValue.Closed
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r10 = 0
            r2[r10] = r3
            r3 = 0
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            androidx.compose.material.DrawerValue r5 = androidx.compose.material.DrawerValue.Open
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            r11 = 1
            r2[r11] = r4
            java.util.Map r16 = kotlin.collections.MapsKt__MapsKt.mapOf(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r2 != r4) goto L_0x0070
            r19 = r11
            goto L_0x0072
        L_0x0070:
            r19 = r10
        L_0x0072:
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material.DrawerState r2 = r0.f4454g
            androidx.compose.material.SwipeableState r15 = r2.getSwipeableState$material_release()
            androidx.compose.foundation.gestures.Orientation r17 = androidx.compose.foundation.gestures.Orientation.Horizontal
            float r23 = androidx.compose.material.DrawerKt.DrawerVelocityThreshold
            boolean r2 = r0.f4455h
            r20 = 0
            androidx.compose.material.DrawerKt$ModalDrawer$1$1 r21 = androidx.compose.material.DrawerKt$ModalDrawer$1.AnonymousClass1.INSTANCE
            r22 = 0
            r24 = 32
            r25 = 0
            r14 = r12
            r18 = r2
            androidx.compose.ui.Modifier r2 = androidx.compose.material.SwipeableKt.m1395swipeablepPrIpRY$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            androidx.compose.material.DrawerState r14 = r0.f4454g
            int r15 = r0.f4456i
            long r4 = r0.f4457j
            androidx.compose.ui.graphics.Shape r7 = r0.f4458k
            r16 = r4
            long r3 = r0.f4459l
            long r5 = r0.f4460m
            float r11 = r0.f4461n
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.f4462o
            r19 = r3
            boolean r3 = r0.f4455h
            kotlinx.coroutines.CoroutineScope r4 = r0.f4463p
            r21 = r11
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.f4464q
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r0)
            androidx.compose.ui.Alignment$Companion r22 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r22.getTopStart()
            r24 = r5
            r5 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r5, r13, r5)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r13.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r5 = r13.consume(r5)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            r27 = r7
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r28 = androidx.compose.ui.node.ComposeUiNode.Companion
            r29 = r11
            kotlin.jvm.functions.Function0 r11 = r28.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r30 = r8
            androidx.compose.runtime.Applier r8 = r34.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0101
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0101:
            r34.startReusableNode()
            boolean r8 = r34.getInserting()
            if (r8 == 0) goto L_0x010e
            r13.createNode(r11)
            goto L_0x0111
        L_0x010e:
            r34.useNode()
        L_0x0111:
            r34.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2536constructorimpl(r34)
            kotlin.jvm.functions.Function2 r9 = r28.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r0, r9)
            kotlin.jvm.functions.Function2 r0 = r28.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r6, r0)
            kotlin.jvm.functions.Function2 r0 = r28.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r5, r0)
            kotlin.jvm.functions.Function2 r0 = r28.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r8, r7, r0)
            r34.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r34)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r2.invoke(r0, r13, r6)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r2)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r5 = -1263168067(0xffffffffb4b595bd, float:-3.3822826E-7)
            r13.startReplaceableGroup(r5)
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r5)
            androidx.compose.ui.Alignment r5 = r22.getTopStart()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r6, r13, r6)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r13.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r8 = r13.consume(r8)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            kotlin.jvm.functions.Function0 r9 = r28.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.materializerOf(r12)
            androidx.compose.runtime.Applier r2 = r34.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x01a1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a1:
            r34.startReusableNode()
            boolean r2 = r34.getInserting()
            if (r2 == 0) goto L_0x01ae
            r13.createNode(r9)
            goto L_0x01b1
        L_0x01ae:
            r34.useNode()
        L_0x01b1:
            r34.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2536constructorimpl(r34)
            kotlin.jvm.functions.Function2 r9 = r28.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r5, r9)
            kotlin.jvm.functions.Function2 r5 = r28.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r6, r5)
            kotlin.jvm.functions.Function2 r5 = r28.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r7, r5)
            kotlin.jvm.functions.Function2 r5 = r28.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r8, r5)
            r34.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r34)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r11.invoke(r2, r13, r6)
            r13.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r0)
            r0 = 32495683(0x1efd843, float:8.8105055E-38)
            r13.startReplaceableGroup(r0)
            int r0 = r15 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.invoke(r13, r0)
            r34.endReplaceableGroup()
            r34.endReplaceableGroup()
            r34.endReplaceableGroup()
            r34.endNode()
            r34.endReplaceableGroup()
            r34.endReplaceableGroup()
            boolean r0 = r14.isOpen()
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$2 r2 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
            r2.<init>(r3, r14, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r1)
            r5 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r5)
            r5 = 1618982084(0x607fb4c4, float:7.370227E19)
            r13.startReplaceableGroup(r5)
            boolean r3 = r13.changed((java.lang.Object) r3)
            boolean r5 = r13.changed((java.lang.Object) r6)
            r3 = r3 | r5
            boolean r5 = r13.changed((java.lang.Object) r14)
            r3 = r3 | r5
            java.lang.Object r5 = r34.rememberedValue()
            if (r3 != 0) goto L_0x0247
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0250
        L_0x0247:
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1 r5 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
            r3 = 0
            r5.<init>(r1, r3, r14)
            r13.updateRememberedValue(r5)
        L_0x0250:
            r34.endReplaceableGroup()
            r3 = r5
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            int r1 = r15 >> 15
            r7 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r0
            r8 = r19
            r0 = r4
            r10 = r24
            r4 = r16
            r6 = r34
            r16 = r27
            androidx.compose.material.DrawerKt.m1229ScrimBx497Mc(r1, r2, r3, r4, r6, r7)
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m1379getNavigationMenuUdPEhr4()
            r2 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m1382getString4foXLRw(r1, r13, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            int r3 = androidx.compose.ui.unit.Constraints.m5424getMinWidthimpl(r30)
            float r3 = r2.m5444toDpu2uoSUM((int) r3)
            int r4 = androidx.compose.ui.unit.Constraints.m5423getMinHeightimpl(r30)
            float r4 = r2.m5444toDpu2uoSUM((int) r4)
            int r5 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r30)
            float r5 = r2.m5444toDpu2uoSUM((int) r5)
            int r6 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r30)
            float r2 = r2.m5444toDpu2uoSUM((int) r6)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m561sizeInqDBjuR0(r12, r3, r4, r5, r2)
            r3 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r3)
            boolean r3 = r13.changed((java.lang.Object) r14)
            java.lang.Object r4 = r34.rememberedValue()
            if (r3 != 0) goto L_0x02ba
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02c2
        L_0x02ba:
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1 r4 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
            r4.<init>(r14)
            r13.updateRememberedValue(r4)
        L_0x02c2:
            r34.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r4)
            r23 = 0
            r24 = 0
            float r25 = androidx.compose.material.DrawerKt.EndDrawerPadding
            r26 = 0
            r27 = 11
            r28 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$6 r3 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
            r3.<init>(r1, r14, r0)
            r0 = 0
            r1 = 1
            r4 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r4, r3, r1, r0)
            r7 = 0
            androidx.compose.material.DrawerKt$ModalDrawer$1$2$7 r2 = new androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
            r3 = r29
            r2.<init>(r3, r15)
            r3 = -1941234439(0xffffffff8c4b1cf9, float:-1.564727E-31)
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r3, r1, r2)
            int r1 = r15 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r2 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r2
            int r2 = r15 >> 12
            r3 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r15
            r14 = r1 | r2
            r15 = 16
            r1 = r0
            r2 = r16
            r3 = r8
            r5 = r10
            r8 = r21
            r9 = r12
            r10 = r34
            r11 = r14
            r12 = r15
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r34.endReplaceableGroup()
            r34.endReplaceableGroup()
            r34.endReplaceableGroup()
            r34.endNode()
            r34.endReplaceableGroup()
            r34.endReplaceableGroup()
        L_0x032f:
            return
        L_0x0330:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Drawer shouldn't have infinite width"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$ModalDrawer$1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
