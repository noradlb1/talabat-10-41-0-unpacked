package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackdropScaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3929g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3930h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Constraints, Constraints> f3931i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f3932j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f3933k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f3934l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BackdropScaffoldState f3935m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f3936n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3937o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Shape f3938p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f3939q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ long f3940r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ float f3941s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f3942t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ float f3943u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ float f3944v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3945w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ long f3946x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> f3947y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, float f11, boolean z11, boolean z12, BackdropScaffoldState backdropScaffoldState, float f12, int i11, Shape shape, long j11, long j12, float f13, int i12, float f14, float f15, Function2<? super Composer, ? super Integer, Unit> function22, long j13, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f3929g = modifier;
        this.f3930h = function2;
        this.f3931i = function1;
        this.f3932j = f11;
        this.f3933k = z11;
        this.f3934l = z12;
        this.f3935m = backdropScaffoldState;
        this.f3936n = f12;
        this.f3937o = i11;
        this.f3938p = shape;
        this.f3939q = j11;
        this.f3940r = j12;
        this.f3941s = f13;
        this.f3942t = i12;
        this.f3943u = f14;
        this.f3944v = f15;
        this.f3945w = function22;
        this.f3946x = j13;
        this.f3947y = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            composer2.startReplaceableGroup(773894976);
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(this.f3929g, 0.0f, 1, (Object) null);
            Function2<Composer, Integer, Unit> function2 = this.f3930h;
            Function1<Constraints, Constraints> function1 = this.f3931i;
            final float f11 = this.f3932j;
            final boolean z11 = this.f3933k;
            final boolean z12 = this.f3934l;
            final BackdropScaffoldState backdropScaffoldState = this.f3935m;
            final float f12 = this.f3936n;
            final int i12 = this.f3937o;
            final Shape shape = this.f3938p;
            Function1<Constraints, Constraints> function12 = function1;
            AnonymousClass1 r32 = r6;
            final long j11 = this.f3939q;
            final long j12 = this.f3940r;
            final float f13 = this.f3941s;
            final int i13 = this.f3942t;
            final float f14 = this.f3943u;
            final float f15 = this.f3944v;
            final Function2<Composer, Integer, Unit> function22 = this.f3945w;
            final long j13 = this.f3946x;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function3 = this.f3947y;
            AnonymousClass1 r62 = new Function4<Constraints, Float, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m1098invokejYbf7pk(((Constraints) obj).m5428unboximpl(), ((Number) obj2).floatValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:43:0x01c3  */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x01cf  */
                /* JADX WARNING: Removed duplicated region for block: B:47:0x01d3  */
                @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @androidx.compose.runtime.Composable
                /* renamed from: invoke-jYbf7pk  reason: not valid java name */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void m1098invokejYbf7pk(long r32, float r34, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36) {
                    /*
                        r31 = this;
                        r0 = r31
                        r1 = r34
                        r13 = r35
                        r2 = r36 & 14
                        r3 = 2
                        r4 = r32
                        if (r2 != 0) goto L_0x0019
                        boolean r2 = r13.changed((long) r4)
                        if (r2 == 0) goto L_0x0015
                        r2 = 4
                        goto L_0x0016
                    L_0x0015:
                        r2 = r3
                    L_0x0016:
                        r2 = r36 | r2
                        goto L_0x001b
                    L_0x0019:
                        r2 = r36
                    L_0x001b:
                        r6 = r36 & 112(0x70, float:1.57E-43)
                        if (r6 != 0) goto L_0x002b
                        boolean r6 = r13.changed((float) r1)
                        if (r6 == 0) goto L_0x0028
                        r6 = 32
                        goto L_0x002a
                    L_0x0028:
                        r6 = 16
                    L_0x002a:
                        r2 = r2 | r6
                    L_0x002b:
                        r2 = r2 & 731(0x2db, float:1.024E-42)
                        r6 = 146(0x92, float:2.05E-43)
                        if (r2 != r6) goto L_0x003d
                        boolean r2 = r35.getSkipping()
                        if (r2 != 0) goto L_0x0038
                        goto L_0x003d
                    L_0x0038:
                        r35.skipToGroupEnd()
                        goto L_0x0240
                    L_0x003d:
                        int r2 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r32)
                        float r14 = (float) r2
                        float r2 = r7
                        float r2 = r14 - r2
                        boolean r4 = r8
                        if (r4 == 0) goto L_0x004e
                        float r2 = java.lang.Math.min(r2, r1)
                    L_0x004e:
                        r15 = r2
                        boolean r1 = r9
                        r2 = 0
                        if (r1 == 0) goto L_0x0061
                        androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.material.BackdropScaffoldState r4 = r10
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = r4.getNestedScrollConnection$material_release()
                        androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r1, r4, r2, r3, r2)
                        goto L_0x0063
                    L_0x0061:
                        androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                    L_0x0063:
                        androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r16 = r12.then(r1)
                        androidx.compose.material.BackdropScaffoldState r1 = r10
                        kotlin.Pair[] r3 = new kotlin.Pair[r3]
                        float r4 = r11
                        java.lang.Float r4 = java.lang.Float.valueOf(r4)
                        androidx.compose.material.BackdropValue r5 = androidx.compose.material.BackdropValue.Concealed
                        kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
                        r11 = 0
                        r3[r11] = r4
                        java.lang.Float r4 = java.lang.Float.valueOf(r15)
                        androidx.compose.material.BackdropValue r5 = androidx.compose.material.BackdropValue.Revealed
                        kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
                        r10 = 1
                        r3[r10] = r4
                        java.util.Map r18 = kotlin.collections.MapsKt__MapsKt.mapOf(r3)
                        androidx.compose.foundation.gestures.Orientation r19 = androidx.compose.foundation.gestures.Orientation.Vertical
                        boolean r3 = r9
                        r21 = 0
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 496(0x1f0, float:6.95E-43)
                        r27 = 0
                        r17 = r1
                        r20 = r3
                        androidx.compose.ui.Modifier r1 = androidx.compose.material.SwipeableKt.m1395swipeablepPrIpRY$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1 r3 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
                        androidx.compose.material.BackdropScaffoldState r4 = r10
                        kotlinx.coroutines.CoroutineScope r5 = r21
                        r3.<init>(r4, r5)
                        androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r11, r3, r10, r2)
                        androidx.compose.material.BackdropScaffoldState r2 = r10
                        r3 = 1157296644(0x44faf204, float:2007.563)
                        r13.startReplaceableGroup(r3)
                        boolean r3 = r13.changed((java.lang.Object) r2)
                        java.lang.Object r4 = r35.rememberedValue()
                        if (r3 != 0) goto L_0x00ce
                        androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r3 = r3.getEmpty()
                        if (r4 != r3) goto L_0x00d6
                    L_0x00ce:
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1 r4 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                        r4.<init>(r2)
                        r13.updateRememberedValue(r4)
                    L_0x00d6:
                        r35.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.offset(r12, r4)
                        androidx.compose.ui.Modifier r1 = r2.then(r1)
                        androidx.compose.ui.graphics.Shape r2 = r13
                        long r3 = r14
                        long r5 = r16
                        float r8 = r18
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2 r9 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2
                        float r11 = r22
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r23
                        int r10 = r12
                        r26 = r14
                        r36 = r15
                        long r14 = r24
                        r27 = r12
                        androidx.compose.material.BackdropScaffoldState r12 = r10
                        r28 = r8
                        int r8 = r19
                        r29 = r5
                        boolean r5 = r9
                        kotlinx.coroutines.CoroutineScope r6 = r21
                        r16 = r9
                        r17 = r11
                        r18 = r7
                        r19 = r10
                        r20 = r14
                        r22 = r12
                        r23 = r8
                        r24 = r5
                        r25 = r6
                        r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25)
                        r5 = -1065299503(0xffffffffc080d1d1, float:-4.0256124)
                        r10 = 1
                        androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r5, r10, r9)
                        int r5 = r19
                        int r6 = r5 >> 3
                        r6 = r6 & 112(0x70, float:1.57E-43)
                        r7 = 1572864(0x180000, float:2.204052E-39)
                        r6 = r6 | r7
                        int r7 = r5 >> 6
                        r7 = r7 & 896(0x380, float:1.256E-42)
                        r6 = r6 | r7
                        int r7 = r5 >> 6
                        r7 = r7 & 7168(0x1c00, float:1.0045E-41)
                        r6 = r6 | r7
                        r7 = 458752(0x70000, float:6.42848E-40)
                        r14 = 6
                        int r5 = r5 << r14
                        r5 = r5 & r7
                        r11 = r6 | r5
                        r12 = 16
                        r5 = r29
                        r7 = 0
                        r8 = r28
                        r15 = r10
                        r10 = r35
                        r15 = 0
                        r16 = r27
                        androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
                        r5 = 0
                        r6 = 0
                        r7 = 0
                        androidx.compose.material.BackdropScaffoldState r1 = r10
                        boolean r1 = r1.isRevealed()
                        if (r1 == 0) goto L_0x0169
                        float r1 = r7
                        float r1 = r26 - r1
                        int r1 = (r36 > r1 ? 1 : (r36 == r1 ? 0 : -1))
                        if (r1 != 0) goto L_0x0163
                        r11 = 1
                        goto L_0x0164
                    L_0x0163:
                        r11 = r15
                    L_0x0164:
                        if (r11 == 0) goto L_0x0169
                        float r1 = r20
                        goto L_0x016e
                    L_0x0169:
                        float r1 = (float) r15
                        float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
                    L_0x016e:
                        r8 = r1
                        r9 = 7
                        r10 = 0
                        r4 = r16
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r4, r5, r6, r7, r8, r9, r10)
                        androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r2 = r2.getBottomCenter()
                        kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r26
                        androidx.compose.material.BackdropScaffoldState r4 = r10
                        int r5 = r19
                        r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                        r13.startReplaceableGroup(r6)
                        androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r15, r13, r14)
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
                        androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r10 = r9.getConstructor()
                        kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
                        androidx.compose.runtime.Applier r11 = r35.getApplier()
                        boolean r11 = r11 instanceof androidx.compose.runtime.Applier
                        if (r11 != 0) goto L_0x01c6
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x01c6:
                        r35.startReusableNode()
                        boolean r11 = r35.getInserting()
                        if (r11 == 0) goto L_0x01d3
                        r13.createNode(r10)
                        goto L_0x01d6
                    L_0x01d3:
                        r35.useNode()
                    L_0x01d6:
                        r35.disableReusing()
                        androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2536constructorimpl(r35)
                        kotlin.jvm.functions.Function2 r11 = r9.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r2, r11)
                        kotlin.jvm.functions.Function2 r2 = r9.getSetDensity()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r6, r2)
                        kotlin.jvm.functions.Function2 r2 = r9.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r7, r2)
                        kotlin.jvm.functions.Function2 r2 = r9.getSetViewConfiguration()
                        androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r8, r2)
                        r35.enableReusing()
                        androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r35)
                        androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
                        java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
                        r1.invoke(r2, r13, r6)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r13.startReplaceableGroup(r1)
                        r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
                        r13.startReplaceableGroup(r1)
                        androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        r1 = 1815906203(0x6c3c879b, float:9.116737E26)
                        r13.startReplaceableGroup(r1)
                        androidx.compose.material.SnackbarHostState r1 = r4.getSnackbarHostState()
                        int r2 = r5 >> 18
                        r2 = r2 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                        r3.invoke(r1, r13, r2)
                        r35.endReplaceableGroup()
                        r35.endReplaceableGroup()
                        r35.endReplaceableGroup()
                        r35.endNode()
                        r35.endReplaceableGroup()
                        r35.endReplaceableGroup()
                    L_0x0240:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.AnonymousClass1.m1098invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                }
            };
            Composer composer3 = composer;
            BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function2, function12, ComposableLambdaKt.composableLambda(composer3, 1800047509, true, r32), composer3, 3120);
            return;
        }
        composer.skipToGroupEnd();
    }
}
