package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$BottomDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4403g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BottomDrawerState f4404h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4405i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4406j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f4407k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f4408l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4409m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f4410n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f4411o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f4412p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4413q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$1(boolean z11, BottomDrawerState bottomDrawerState, Function2<? super Composer, ? super Integer, Unit> function2, int i11, long j11, Shape shape, long j12, long j13, float f11, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.f4403g = z11;
        this.f4404h = bottomDrawerState;
        this.f4405i = function2;
        this.f4406j = i11;
        this.f4407k = j11;
        this.f4408l = shape;
        this.f4409m = j12;
        this.f4410n = j13;
        this.f4411o = f11;
        this.f4412p = coroutineScope;
        this.f4413q = function3;
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final float m1234invoke$lambda1(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m1235invoke$lambda2(MutableState<Float> mutableState, float f11) {
        mutableState.setValue(Float.valueOf(f11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r29, int r30) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r13 = r29
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r30 & 14
            r3 = 2
            if (r2 != 0) goto L_0x001c
            boolean r2 = r13.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0018
            r2 = 4
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            r2 = r30 | r2
            goto L_0x001e
        L_0x001c:
            r2 = r30
        L_0x001e:
            r2 = r2 & 91
            r4 = 18
            if (r2 != r4) goto L_0x0030
            boolean r2 = r29.getSkipping()
            if (r2 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r29.skipToGroupEnd()
            goto L_0x02e4
        L_0x0030:
            long r4 = r28.m434getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r4)
            float r2 = (float) r2
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            r7 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r7)
            boolean r4 = r13.changed((java.lang.Object) r4)
            java.lang.Object r5 = r29.rememberedValue()
            r8 = 0
            if (r4 != 0) goto L_0x0056
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x0061
        L_0x0056:
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r8, r3, r8)
            r13.updateRememberedValue(r5)
        L_0x0061:
            r29.endReplaceableGroup()
            r9 = r5
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            long r4 = r28.m434getConstraintsmsEJaDk()
            int r4 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r4)
            long r5 = r28.m434getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r5)
            r10 = 1
            r11 = 0
            if (r4 <= r5) goto L_0x007d
            r4 = r10
            goto L_0x007e
        L_0x007d:
            r4 = r11
        L_0x007e:
            r5 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r2
            float r6 = m1234invoke$lambda1(r9)
            float r6 = r2 - r6
            r12 = 0
            float r6 = java.lang.Math.max(r12, r6)
            float r12 = m1234invoke$lambda1(r9)
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 < 0) goto L_0x00c3
            if (r4 == 0) goto L_0x0097
            goto L_0x00c3
        L_0x0097:
            r4 = 3
            kotlin.Pair[] r4 = new kotlin.Pair[r4]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.material.BottomDrawerValue r12 = androidx.compose.material.BottomDrawerValue.Closed
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r12)
            r4[r11] = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r5)
            androidx.compose.material.BottomDrawerValue r5 = androidx.compose.material.BottomDrawerValue.Open
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r4[r10] = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r6)
            androidx.compose.material.BottomDrawerValue r5 = androidx.compose.material.BottomDrawerValue.Expanded
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r4[r3] = r2
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.mapOf(r4)
            goto L_0x00e1
        L_0x00c3:
            kotlin.Pair[] r4 = new kotlin.Pair[r3]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.material.BottomDrawerValue r5 = androidx.compose.material.BottomDrawerValue.Closed
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r4[r11] = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r6)
            androidx.compose.material.BottomDrawerValue r5 = androidx.compose.material.BottomDrawerValue.Expanded
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r4[r10] = r2
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.mapOf(r4)
        L_0x00e1:
            r16 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r18 = 0
            r19 = 0
            long r5 = r28.m434getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r5)
            float r20 = r2.m5444toDpu2uoSUM((int) r5)
            long r5 = r28.m434getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r5)
            float r21 = r2.m5444toDpu2uoSUM((int) r1)
            r22 = 3
            r23 = 0
            r17 = r4
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m562sizeInqDBjuR0$default(r17, r18, r19, r20, r21, r22, r23)
            boolean r1 = r0.f4403g
            if (r1 == 0) goto L_0x0124
            androidx.compose.material.BottomDrawerState r1 = r0.f4404h
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r1 = r1.getNestedScrollConnection$material_release()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r4, r1, r8, r3, r8)
            goto L_0x0125
        L_0x0124:
            r1 = r4
        L_0x0125:
            androidx.compose.ui.Modifier r14 = r4.then(r1)
            androidx.compose.material.BottomDrawerState r15 = r0.f4404h
            androidx.compose.foundation.gestures.Orientation r17 = androidx.compose.foundation.gestures.Orientation.Vertical
            boolean r1 = r0.f4403g
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 368(0x170, float:5.16E-43)
            r25 = 0
            r18 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material.SwipeableKt.m1395swipeablepPrIpRY$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.f4405i
            int r14 = r0.f4406j
            long r3 = r0.f4407k
            androidx.compose.material.BottomDrawerState r15 = r0.f4404h
            androidx.compose.ui.graphics.Shape r6 = r0.f4408l
            r16 = r9
            long r8 = r0.f4409m
            r18 = r8
            long r7 = r0.f4410n
            float r9 = r0.f4411o
            boolean r5 = r0.f4403g
            kotlinx.coroutines.CoroutineScope r10 = r0.f4412p
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.f4413q
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r22 = r6
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r6, r13, r6)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r13.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            r23 = r9
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r9 = r13.consume(r9)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            r24 = r7
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            r28 = r11
            kotlin.jvm.functions.Function0 r11 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r26 = r12
            androidx.compose.runtime.Applier r12 = r29.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x01b1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b1:
            r29.startReusableNode()
            boolean r12 = r29.getInserting()
            if (r12 == 0) goto L_0x01be
            r13.createNode(r11)
            goto L_0x01c1
        L_0x01be:
            r29.useNode()
        L_0x01c1:
            r29.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r29)
            kotlin.jvm.functions.Function2 r12 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r0, r12)
            kotlin.jvm.functions.Function2 r0 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r6, r0)
            kotlin.jvm.functions.Function2 r0 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r9, r0)
            kotlin.jvm.functions.Function2 r0 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r7, r0)
            r29.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r29)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r1.invoke(r0, r13, r7)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r0 = -1660053078(0xffffffff9d0d99aa, float:-1.8740637E-21)
            r13.startReplaceableGroup(r0)
            int r0 = r14 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.invoke(r13, r0)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$1 r0 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$1
            r0.<init>(r5, r15, r10)
            java.lang.Object r1 = r15.getTargetValue()
            androidx.compose.material.BottomDrawerValue r2 = androidx.compose.material.BottomDrawerValue.Closed
            if (r1 == r2) goto L_0x0225
            r5 = 1
            goto L_0x0226
        L_0x0225:
            r5 = 0
        L_0x0226:
            int r1 = r14 >> 24
            r6 = r1 & 14
            r1 = r3
            r3 = r0
            r4 = r5
            r5 = r29
            r0 = r22
            androidx.compose.material.DrawerKt.m1226BottomDrawerScrim3JVO9M(r1, r3, r4, r5, r6)
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m1379getNavigationMenuUdPEhr4()
            r2 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m1382getString4foXLRw(r1, r13, r2)
            r2 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r2)
            boolean r2 = r13.changed((java.lang.Object) r15)
            java.lang.Object r3 = r29.rememberedValue()
            if (r2 != 0) goto L_0x0257
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x025f
        L_0x0257:
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1 r3 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1
            r3.<init>(r15)
            r13.updateRememberedValue(r3)
        L_0x025f:
            r29.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2 = r26
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r3)
            r3 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r3)
            r5 = r16
            boolean r3 = r13.changed((java.lang.Object) r5)
            java.lang.Object r4 = r29.rememberedValue()
            if (r3 != 0) goto L_0x0284
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x028c
        L_0x0284:
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1 r4 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
            r4.<init>(r5)
            r13.updateRememberedValue(r4)
        L_0x028c:
            r29.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r2, r4)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$4 r3 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
            r3.<init>(r1, r15, r10)
            r1 = 0
            r4 = 1
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r5, r3, r4, r1)
            r7 = 0
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$5 r2 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
            r3 = r28
            r2.<init>(r3, r14)
            r3 = 457750254(0x1b48b6ee, float:1.660272E-22)
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r3, r4, r2)
            int r2 = r14 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r3 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r3
            int r3 = r14 >> 12
            r4 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r14
            r11 = r2 | r3
            r12 = 16
            r2 = r0
            r3 = r18
            r5 = r24
            r8 = r23
            r10 = r29
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            r29.endNode()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
        L_0x02e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$BottomDrawer$1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
