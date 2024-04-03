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
public final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5096g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5097h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5098i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> f5099j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5100k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5101l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f5102m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5103n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5104o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5105p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5106q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i11, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z11, List<Float> list, int i12, SliderColors sliderColors, Function0<Unit> function0) {
        super(3);
        this.f5096g = closedFloatingPointRange;
        this.f5097h = closedFloatingPointRange2;
        this.f5098i = i11;
        this.f5099j = state;
        this.f5100k = mutableInteractionSource;
        this.f5101l = mutableInteractionSource2;
        this.f5102m = z11;
        this.f5103n = list;
        this.f5104o = i12;
        this.f5105p = sliderColors;
        this.f5106q = function0;
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f11) {
        return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f11, floatRef.element, floatRef2.element);
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return SliderKt.scale(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1} */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01d5, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x01d7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r12 = r32
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r33 & 14
            r9 = 2
            if (r2 != 0) goto L_0x001c
            boolean r2 = r12.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0018
            r2 = 4
            goto L_0x0019
        L_0x0018:
            r2 = r9
        L_0x0019:
            r2 = r33 | r2
            goto L_0x001e
        L_0x001c:
            r2 = r33
        L_0x001e:
            r2 = r2 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0030
            boolean r2 = r32.getSkipping()
            if (r2 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r32.skipToGroupEnd()
            goto L_0x0374
        L_0x0030:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r12.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r10 = 1
            r11 = 0
            if (r2 != r3) goto L_0x0041
            r19 = r10
            goto L_0x0043
        L_0x0041:
            r19 = r11
        L_0x0043:
            long r1 = r31.m434getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r1)
            float r15 = (float) r1
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            kotlin.jvm.internal.Ref$FloatRef r13 = new kotlin.jvm.internal.Ref$FloatRef
            r13.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r12.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r2 = r1.m5447toPx0680j_4(r2)
            float r2 = r15 - r2
            r14.element = r2
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r1 = r1.m5447toPx0680j_4(r2)
            r13.element = r1
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.f5097h
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r7)
            java.lang.Object r3 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r16.getEmpty()
            r5 = 0
            if (r3 != r4) goto L_0x00a8
            java.lang.Comparable r1 = r1.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = invoke$scaleToOffset(r2, r13, r14, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r9, r5)
            r12.updateRememberedValue(r3)
        L_0x00a8:
            r32.endReplaceableGroup()
            r17 = r3
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.f5097h
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            r12.startReplaceableGroup(r7)
            java.lang.Object r3 = r32.rememberedValue()
            java.lang.Object r4 = r16.getEmpty()
            if (r3 != r4) goto L_0x00d9
            java.lang.Comparable r1 = r1.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = invoke$scaleToOffset(r2, r13, r14, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r9, r5)
            r12.updateRememberedValue(r3)
        L_0x00d9:
            r32.endReplaceableGroup()
            r18 = r3
            androidx.compose.runtime.MutableState r18 = (androidx.compose.runtime.MutableState) r18
            androidx.compose.material.SliderKt$RangeSlider$2$2 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            r1.<init>(r2, r13, r14)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            float r3 = r13.element
            float r4 = r14.element
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f5097h
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r5 = r4.floatValue()
            int r4 = r0.f5098i
            int r4 = r4 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r6 = r4 | 3072(0xc00, float:4.305E-42)
            r4 = r17
            r20 = r6
            r6 = r32
            r8 = r7
            r7 = r20
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.material.SliderKt$RangeSlider$2$3 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$3
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            r1.<init>(r2, r13, r14)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            float r3 = r13.element
            float r4 = r14.element
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f5097h
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r5 = r4.floatValue()
            int r4 = r0.f5098i
            int r4 = r4 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r7 = r4 | 3072(0xc00, float:4.305E-42)
            r4 = r18
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6, r7)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r12.startReplaceableGroup(r1)
            r12.startReplaceableGroup(r8)
            java.lang.Object r1 = r32.rememberedValue()
            java.lang.Object r2 = r16.getEmpty()
            if (r1 != r2) goto L_0x015d
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r12)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r12.updateRememberedValue(r2)
            r1 = r2
        L_0x015d:
            r32.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r27 = r1.getCoroutineScope()
            r32.endReplaceableGroup()
            androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
            java.util.List<java.lang.Float> r2 = r0.f5103n
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.f5106q
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r4 = r0.f5099j
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.f5096g
            r20 = r1
            r21 = r17
            r22 = r18
            r23 = r2
            r24 = r13
            r25 = r14
            r26 = r3
            r28 = r4
            r29 = r5
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r11)
            r2 = 7
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r3[r11] = r17
            r3[r10] = r18
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f5096g
            r3[r9] = r4
            float r4 = r13.element
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5 = 3
            r3[r5] = r4
            float r4 = r14.element
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5 = 4
            r3[r5] = r4
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f5097h
            r5 = 5
            r3[r5] = r4
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.f5099j
            r6 = 6
            r3[r6] = r5
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.f5096g
            r7 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r12.startReplaceableGroup(r7)
            r7 = r11
            r8 = r7
        L_0x01bd:
            if (r7 >= r2) goto L_0x01c9
            r9 = r3[r7]
            boolean r9 = r12.changed((java.lang.Object) r9)
            r8 = r8 | r9
            int r7 = r7 + 1
            goto L_0x01bd
        L_0x01c9:
            java.lang.Object r2 = r32.rememberedValue()
            if (r8 != 0) goto L_0x01d7
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x01ef
        L_0x01d7:
            androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1 r2 = new androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
            r20 = r2
            r21 = r17
            r22 = r18
            r23 = r4
            r24 = r13
            r25 = r14
            r26 = r5
            r27 = r6
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            r12.updateRememberedValue(r2)
        L_0x01ef:
            r32.endReplaceableGroup()
            androidx.compose.runtime.State r23 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r12, r11)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r0.f5100k
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.f5101l
            boolean r4 = r0.f5102m
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.f5096g
            r10 = r13
            r13 = r9
            r11 = r14
            r14 = r2
            r2 = r15
            r15 = r3
            r16 = r17
            r17 = r18
            r18 = r4
            r20 = r2
            r21 = r5
            r22 = r1
            androidx.compose.ui.Modifier r13 = androidx.compose.material.SliderKt.rangeSliderPressDragModifier(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.f5097h
            java.lang.Comparable r1 = r1.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.f5097h
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r1 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r1, (float) r2, (float) r3)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5097h
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.f5097h
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f5096g
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r14 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.f5096g
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r15 = androidx.compose.material.SliderKt.calcFraction(r2, r3, r1)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.f5096g
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r16 = androidx.compose.material.SliderKt.calcFraction(r2, r3, r14)
            java.util.List<java.lang.Float> r4 = r0.f5103n
            boolean r5 = r0.f5102m
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r2 = r0.f5099j
            java.lang.Float r3 = java.lang.Float.valueOf(r14)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r6 = r0.f5099j
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r8)
            boolean r2 = r12.changed((java.lang.Object) r2)
            boolean r3 = r12.changed((java.lang.Object) r3)
            r2 = r2 | r3
            java.lang.Object r3 = r32.rememberedValue()
            if (r2 != 0) goto L_0x02c7
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x02cf
        L_0x02c7:
            androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1 r3 = new androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
            r3.<init>(r6, r14)
            r12.updateRememberedValue(r3)
        L_0x02cf:
            r32.endReplaceableGroup()
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r7 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r2, (float) r14)
            int r3 = r0.f5104o
            r2 = r9
            r17 = r3
            r3 = r1
            r31 = r13
            r13 = r8
            r8 = r17
            androidx.compose.ui.Modifier r17 = androidx.compose.material.SliderKt.sliderSemantics(r2, r3, r4, r5, r6, r7, r8)
            java.util.List<java.lang.Float> r4 = r0.f5103n
            boolean r5 = r0.f5102m
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r2 = r0.f5099j
            java.lang.Float r3 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r6 = r0.f5099j
            r12.startReplaceableGroup(r13)
            boolean r2 = r12.changed((java.lang.Object) r2)
            boolean r3 = r12.changed((java.lang.Object) r3)
            r2 = r2 | r3
            java.lang.Object r3 = r32.rememberedValue()
            if (r2 != 0) goto L_0x031a
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0322
        L_0x031a:
            androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1 r3 = new androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
            r3.<init>(r6, r1)
            r12.updateRememberedValue(r3)
        L_0x0322:
            r32.endReplaceableGroup()
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.f5096g
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r7 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r1, (float) r2)
            int r8 = r0.f5104o
            r2 = r9
            r3 = r14
            androidx.compose.ui.Modifier r13 = androidx.compose.material.SliderKt.sliderSemantics(r2, r3, r4, r5, r6, r7, r8)
            boolean r1 = r0.f5102m
            java.util.List<java.lang.Float> r4 = r0.f5103n
            androidx.compose.material.SliderColors r5 = r0.f5105p
            float r2 = r11.element
            float r3 = r10.element
            float r6 = r2 - r3
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r0.f5100k
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r0.f5101l
            int r2 = r0.f5098i
            int r3 = r2 >> 9
            r3 = r3 & 14
            r9 = 14159872(0xd81000, float:1.9842207E-38)
            r3 = r3 | r9
            r9 = 57344(0xe000, float:8.0356E-41)
            int r2 = r2 >> 9
            r2 = r2 & r9
            r14 = r3 | r2
            r18 = 0
            r2 = r15
            r3 = r16
            r9 = r31
            r10 = r17
            r11 = r13
            r12 = r32
            r13 = r14
            r14 = r18
            androidx.compose.material.SliderKt.RangeSliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x0374:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$RangeSlider$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
