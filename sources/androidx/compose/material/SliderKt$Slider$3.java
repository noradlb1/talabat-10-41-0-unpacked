package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5176g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5177h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5178i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5179j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5180k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5181l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5182m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Unit>> f5183n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5184o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11, float f11, MutableInteractionSource mutableInteractionSource, boolean z11, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.f5176g = closedFloatingPointRange;
        this.f5177h = i11;
        this.f5178i = f11;
        this.f5179j = mutableInteractionSource;
        this.f5180k = z11;
        this.f5181l = list;
        this.f5182m = sliderColors;
        this.f5183n = state;
        this.f5184o = function0;
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f11) {
        return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f11, floatRef.element, floatRef2.element);
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f11) {
        return SliderKt.scale(floatRef.element, floatRef2.element, f11, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: androidx.compose.material.SliderDraggableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r8 = r32
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r33 & 14
            r3 = 2
            if (r2 != 0) goto L_0x001c
            boolean r2 = r8.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0018
            r2 = 4
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            r2 = r33 | r2
            goto L_0x001e
        L_0x001c:
            r2 = r33
        L_0x001e:
            r2 = r2 & 91
            r4 = 18
            if (r2 != r4) goto L_0x0030
            boolean r2 = r32.getSkipping()
            if (r2 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r32.skipToGroupEnd()
            goto L_0x0258
        L_0x0030:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r8.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r9 = 0
            if (r2 != r4) goto L_0x0041
            r2 = 1
            r19 = r2
            goto L_0x0043
        L_0x0041:
            r19 = r9
        L_0x0043:
            long r1 = r31.m434getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r1)
            float r13 = (float) r1
            kotlin.jvm.internal.Ref$FloatRef r15 = new kotlin.jvm.internal.Ref$FloatRef
            r15.<init>()
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r8.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r2 = r1.m5447toPx0680j_4(r2)
            float r2 = r13 - r2
            r4 = 0
            float r2 = java.lang.Math.max(r2, r4)
            r15.element = r2
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r1 = r1.m5447toPx0680j_4(r2)
            float r2 = r15.element
            float r1 = java.lang.Math.min(r1, r2)
            r14.element = r1
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r8.startReplaceableGroup(r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r1)
            java.lang.Object r2 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r28 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r28.getEmpty()
            if (r2 != r5) goto L_0x00a8
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r8)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r5.<init>(r2)
            r8.updateRememberedValue(r5)
            r2 = r5
        L_0x00a8:
            r32.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r10 = r2.getCoroutineScope()
            r32.endReplaceableGroup()
            float r2 = r0.f5178i
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.f5176g
            r8.startReplaceableGroup(r1)
            java.lang.Object r6 = r32.rememberedValue()
            java.lang.Object r7 = r28.getEmpty()
            r12 = 0
            if (r6 != r7) goto L_0x00d5
            float r2 = invoke$scaleToOffset(r5, r14, r15, r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r12, r3, r12)
            r8.updateRememberedValue(r6)
        L_0x00d5:
            r32.endReplaceableGroup()
            r16 = r6
            androidx.compose.runtime.MutableState r16 = (androidx.compose.runtime.MutableState) r16
            r8.startReplaceableGroup(r1)
            java.lang.Object r1 = r32.rememberedValue()
            java.lang.Object r2 = r28.getEmpty()
            if (r1 != r2) goto L_0x00f4
            java.lang.Float r1 = java.lang.Float.valueOf(r4)
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r12, r3, r12)
            r8.updateRememberedValue(r1)
        L_0x00f4:
            r32.endReplaceableGroup()
            r17 = r1
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            float r1 = r14.element
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            float r2 = r15.element
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.f5176g
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit>> r4 = r0.f5183n
            r5 = 1618982084(0x607fb4c4, float:7.370227E19)
            r8.startReplaceableGroup(r5)
            boolean r1 = r8.changed((java.lang.Object) r1)
            boolean r2 = r8.changed((java.lang.Object) r2)
            r1 = r1 | r2
            boolean r2 = r8.changed((java.lang.Object) r3)
            r1 = r1 | r2
            java.lang.Object r2 = r32.rememberedValue()
            if (r1 != 0) goto L_0x012b
            java.lang.Object r1 = r28.getEmpty()
            if (r2 != r1) goto L_0x0146
        L_0x012b:
            androidx.compose.material.SliderDraggableState r2 = new androidx.compose.material.SliderDraggableState
            androidx.compose.material.SliderKt$Slider$3$draggableState$1$1 r1 = new androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
            r20 = r1
            r21 = r16
            r22 = r17
            r23 = r14
            r24 = r15
            r25 = r4
            r26 = r3
            r20.<init>(r21, r22, r23, r24, r25, r26)
            r2.<init>(r1)
            r8.updateRememberedValue(r2)
        L_0x0146:
            r32.endReplaceableGroup()
            r29 = r2
            androidx.compose.material.SliderDraggableState r29 = (androidx.compose.material.SliderDraggableState) r29
            androidx.compose.material.SliderKt$Slider$3$2 r1 = new androidx.compose.material.SliderKt$Slider$3$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5176g
            r1.<init>(r2, r14, r15)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5176g
            float r3 = r14.element
            float r4 = r15.element
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r3, (float) r4)
            float r5 = r0.f5178i
            int r4 = r0.f5177h
            int r6 = r4 >> 9
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            int r4 = r4 << 12
            r7 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r7
            r7 = r6 | r4
            r4 = r16
            r6 = r32
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1 r1 = new androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            java.util.List<java.lang.Float> r2 = r0.f5181l
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.f5184o
            r20 = r1
            r21 = r16
            r22 = r2
            r23 = r14
            r24 = r15
            r25 = r10
            r26 = r29
            r27 = r3
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r8, r9)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.f5179j
            boolean r4 = r0.f5180k
            r10 = r2
            r11 = r29
            r5 = r12
            r12 = r3
            r3 = r14
            r14 = r19
            r6 = r15
            r15 = r16
            r16 = r1
            r18 = r4
            androidx.compose.ui.Modifier r4 = androidx.compose.material.SliderKt.sliderTapModifier(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            androidx.compose.foundation.gestures.Orientation r12 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r15 = r29.isDragging()
            boolean r13 = r0.f5180k
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r0.f5179j
            r16 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r7)
            boolean r7 = r8.changed((java.lang.Object) r1)
            java.lang.Object r9 = r32.rememberedValue()
            if (r7 != 0) goto L_0x01cf
            java.lang.Object r7 = r28.getEmpty()
            if (r9 != r7) goto L_0x01d7
        L_0x01cf:
            androidx.compose.material.SliderKt$Slider$3$drag$1$1 r9 = new androidx.compose.material.SliderKt$Slider$3$drag$1$1
            r9.<init>(r1, r5)
            r8.updateRememberedValue(r9)
        L_0x01d7:
            r32.endReplaceableGroup()
            r17 = r9
            kotlin.jvm.functions.Function3 r17 = (kotlin.jvm.functions.Function3) r17
            r1 = 32
            r20 = 0
            r10 = r2
            r11 = r29
            r18 = r19
            r19 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            float r2 = r0.f5178i
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.f5176g
            java.lang.Comparable r5 = r5.getStart()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f5176g
            java.lang.Comparable r7 = r7.getEndInclusive()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r2 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r2, (float) r5, (float) r7)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.f5176g
            java.lang.Comparable r5 = r5.getStart()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f5176g
            java.lang.Comparable r7 = r7.getEndInclusive()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r2 = androidx.compose.material.SliderKt.calcFraction(r5, r7, r2)
            boolean r5 = r0.f5180k
            java.util.List<java.lang.Float> r7 = r0.f5181l
            androidx.compose.material.SliderColors r9 = r0.f5182m
            float r6 = r6.element
            float r3 = r3.element
            float r6 = r6 - r3
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = r0.f5179j
            androidx.compose.ui.Modifier r11 = r4.then(r1)
            int r1 = r0.f5177h
            int r3 = r1 >> 9
            r3 = r3 & 14
            r3 = r3 | 512(0x200, float:7.175E-43)
            int r4 = r1 >> 15
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            int r1 = r1 >> 6
            r4 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r4
            r12 = r3 | r1
            r1 = r5
            r3 = r7
            r4 = r9
            r5 = r6
            r6 = r10
            r7 = r11
            r8 = r32
            r9 = r12
            androidx.compose.material.SliderKt.SliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0258:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$Slider$3.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
