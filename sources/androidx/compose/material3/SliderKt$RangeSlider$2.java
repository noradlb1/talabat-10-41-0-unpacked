package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7949g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7950h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7951i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7952j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7953k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7954l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7955m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7956n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> f7957o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float[] f7958p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ SliderColors f7959q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2(Function0<Unit> function0, int i11, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i12, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, float[] fArr, SliderColors sliderColors) {
        super(3);
        this.f7949g = function0;
        this.f7950h = i11;
        this.f7951i = mutableInteractionSource;
        this.f7952j = mutableInteractionSource2;
        this.f7953k = z11;
        this.f7954l = closedFloatingPointRange;
        this.f7955m = closedFloatingPointRange2;
        this.f7956n = i12;
        this.f7957o = state;
        this.f7958p = fArr;
        this.f7959q = sliderColors;
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r12 = r33
            r2 = r34
            java.lang.String r3 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r3 = r2 & 14
            r4 = 2
            if (r3 != 0) goto L_0x001d
            boolean r3 = r12.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x001a
            r3 = 4
            goto L_0x001b
        L_0x001a:
            r3 = r4
        L_0x001b:
            r3 = r3 | r2
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            r3 = r3 & 91
            r5 = 18
            if (r3 != r5) goto L_0x0030
            boolean r3 = r33.getSkipping()
            if (r3 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r33.skipToGroupEnd()
            goto L_0x02d9
        L_0x0030:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x003f
            r3 = -1
            java.lang.String r5 = "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:412)"
            r6 = -990606702(0xffffffffc4f48a92, float:-1956.3303)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x003f:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r12.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r5 = 0
            if (r2 != r3) goto L_0x0050
            r2 = 1
            r19 = r2
            goto L_0x0052
        L_0x0050:
            r19 = r5
        L_0x0052:
            long r1 = r32.m434getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m5422getMaxWidthimpl(r1)
            float r1 = (float) r1
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r12.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            float r7 = androidx.compose.material3.SliderKt.getThumbWidth()
            float r7 = r6.m5447toPx0680j_4(r7)
            float r8 = (float) r4
            float r7 = r7 / r8
            float r7 = r1 - r7
            r2.element = r7
            float r7 = androidx.compose.material3.SliderKt.getThumbWidth()
            float r6 = r6.m5447toPx0680j_4(r7)
            float r6 = r6 / r8
            r3.element = r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.f7955m
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7954l
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r8)
            java.lang.Object r9 = r33.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r10.getEmpty()
            r13 = 0
            if (r9 != r11) goto L_0x00ba
            java.lang.Comparable r6 = r6.getStart()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r6 = invoke$scaleToOffset(r7, r3, r2, r6)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r13, r4, r13)
            r12.updateRememberedValue(r9)
        L_0x00ba:
            r33.endReplaceableGroup()
            r16 = r9
            androidx.compose.runtime.MutableState r16 = (androidx.compose.runtime.MutableState) r16
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.f7955m
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7954l
            r12.startReplaceableGroup(r8)
            java.lang.Object r8 = r33.rememberedValue()
            java.lang.Object r9 = r10.getEmpty()
            if (r8 != r9) goto L_0x00eb
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r6 = invoke$scaleToOffset(r7, r3, r2, r6)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r13, r4, r13)
            r12.updateRememberedValue(r8)
        L_0x00eb:
            r33.endReplaceableGroup()
            r17 = r8
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r0.f7949g
            r6 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r6)
            boolean r6 = r12.changed((java.lang.Object) r4)
            java.lang.Object r7 = r33.rememberedValue()
            if (r6 != 0) goto L_0x010a
            java.lang.Object r6 = r10.getEmpty()
            if (r7 != r6) goto L_0x0112
        L_0x010a:
            androidx.compose.material3.SliderKt$RangeSlider$2$gestureEndAction$1$1 r7 = new androidx.compose.material3.SliderKt$RangeSlider$2$gestureEndAction$1$1
            r7.<init>(r4)
            r12.updateRememberedValue(r7)
        L_0x0112:
            r33.endReplaceableGroup()
            androidx.compose.runtime.State r4 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r7, r12, r5)
            androidx.compose.material3.SliderKt$RangeSlider$2$onDrag$1 r6 = new androidx.compose.material3.SliderKt$RangeSlider$2$onDrag$1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7955m
            float[] r8 = r0.f7958p
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r9 = r0.f7957o
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r11 = r0.f7954l
            r20 = r6
            r21 = r16
            r22 = r17
            r23 = r7
            r24 = r3
            r25 = r8
            r26 = r2
            r27 = r9
            r28 = r11
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.runtime.State r23 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r6, r12, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r0.f7951i
            androidx.compose.foundation.interaction.MutableInteractionSource r15 = r0.f7952j
            boolean r6 = r0.f7953k
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7954l
            r13 = r5
            r18 = r6
            r20 = r1
            r21 = r7
            r22 = r4
            androidx.compose.ui.Modifier r9 = androidx.compose.material3.SliderKt.rangeSliderPressDragModifier(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.f7955m
            java.lang.Comparable r1 = r1.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f7954l
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.f7955m
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r1 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r1, (float) r4, (float) r6)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.f7955m
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.f7955m
            java.lang.Comparable r6 = r6.getStart()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7954l
            java.lang.Comparable r7 = r7.getEndInclusive()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r4 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r4, (float) r6, (float) r7)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.f7954l
            java.lang.Comparable r6 = r6.getStart()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7954l
            java.lang.Comparable r7 = r7.getEndInclusive()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r6 = androidx.compose.material3.SliderKt.calcFraction(r6, r7, r1)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r7 = r0.f7954l
            java.lang.Comparable r7 = r7.getStart()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r8 = r0.f7954l
            java.lang.Comparable r8 = r8.getEndInclusive()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r7 = androidx.compose.material3.SliderKt.calcFraction(r7, r8, r4)
            int r8 = r0.f7956n
            float r8 = (float) r8
            float r8 = r8 * r7
            double r13 = (double) r8
            double r13 = java.lang.Math.floor(r13)
            float r8 = (float) r13
            int r8 = (int) r8
            int r11 = r0.f7956n
            float r11 = (float) r11
            r13 = 1065353216(0x3f800000, float:1.0)
            float r13 = r13 - r6
            float r11 = r11 * r13
            double r13 = (double) r11
            double r13 = java.lang.Math.floor(r13)
            float r11 = (float) r13
            int r11 = (int) r11
            boolean r13 = r0.f7953k
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r14 = r0.f7957o
            java.lang.Float r15 = java.lang.Float.valueOf(r4)
            r32 = r9
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r9 = r0.f7957o
            r34 = r7
            r7 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r7)
            boolean r14 = r12.changed((java.lang.Object) r14)
            boolean r15 = r12.changed((java.lang.Object) r15)
            r14 = r14 | r15
            java.lang.Object r15 = r33.rememberedValue()
            if (r14 != 0) goto L_0x021d
            java.lang.Object r14 = r10.getEmpty()
            if (r15 != r14) goto L_0x0225
        L_0x021d:
            androidx.compose.material3.SliderKt$RangeSlider$2$startThumbSemantics$1$1 r15 = new androidx.compose.material3.SliderKt$RangeSlider$2$startThumbSemantics$1$1
            r15.<init>(r9, r4)
            r12.updateRememberedValue(r15)
        L_0x0225:
            r33.endReplaceableGroup()
            r27 = r15
            kotlin.jvm.functions.Function1 r27 = (kotlin.jvm.functions.Function1) r27
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r0.f7949g
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r14 = r0.f7954l
            java.lang.Comparable r14 = r14.getStart()
            java.lang.Number r14 = (java.lang.Number) r14
            float r14 = r14.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r29 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r14, (float) r4)
            r24 = r5
            r25 = r1
            r26 = r13
            r28 = r9
            r30 = r8
            androidx.compose.ui.Modifier r13 = androidx.compose.material3.SliderKt.sliderSemantics(r24, r25, r26, r27, r28, r29, r30)
            boolean r8 = r0.f7953k
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r9 = r0.f7957o
            java.lang.Float r14 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r15 = r0.f7957o
            r12.startReplaceableGroup(r7)
            boolean r7 = r12.changed((java.lang.Object) r9)
            boolean r9 = r12.changed((java.lang.Object) r14)
            r7 = r7 | r9
            java.lang.Object r9 = r33.rememberedValue()
            if (r7 != 0) goto L_0x026e
            java.lang.Object r7 = r10.getEmpty()
            if (r9 != r7) goto L_0x0276
        L_0x026e:
            androidx.compose.material3.SliderKt$RangeSlider$2$endThumbSemantics$1$1 r9 = new androidx.compose.material3.SliderKt$RangeSlider$2$endThumbSemantics$1$1
            r9.<init>(r15, r1)
            r12.updateRememberedValue(r9)
        L_0x0276:
            r33.endReplaceableGroup()
            r27 = r9
            kotlin.jvm.functions.Function1 r27 = (kotlin.jvm.functions.Function1) r27
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r0.f7949g
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r9 = r0.f7954l
            java.lang.Comparable r9 = r9.getEndInclusive()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r29 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r1, (float) r9)
            r24 = r5
            r25 = r4
            r26 = r8
            r28 = r7
            r30 = r11
            androidx.compose.ui.Modifier r11 = androidx.compose.material3.SliderKt.sliderSemantics(r24, r25, r26, r27, r28, r29, r30)
            boolean r1 = r0.f7953k
            float[] r4 = r0.f7958p
            androidx.compose.material3.SliderColors r5 = r0.f7959q
            float r2 = r2.element
            float r3 = r3.element
            float r7 = r2 - r3
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r0.f7951i
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.f7952j
            int r2 = r0.f7950h
            int r3 = r2 >> 9
            r3 = r3 & 14
            r10 = 14159872(0xd81000, float:1.9842207E-38)
            r3 = r3 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            int r2 = r2 >> 9
            r2 = r2 & r10
            r14 = r3 | r2
            r15 = 0
            r2 = r6
            r3 = r34
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r32
            r10 = r13
            r12 = r33
            r13 = r14
            r14 = r15
            androidx.compose.material3.SliderKt.RangeSliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt$RangeSlider$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
