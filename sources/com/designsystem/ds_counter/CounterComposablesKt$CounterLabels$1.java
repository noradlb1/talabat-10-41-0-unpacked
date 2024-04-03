package com.designsystem.ds_counter;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt$CounterLabels$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f31007g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f31008h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CounterChange f31009i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31010j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f31011k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31012l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f31013m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f31014n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31015o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterLabels$1(float f11, float f12, CounterChange counterChange, String str, boolean z11, int i11, String str2, long j11, TextStyle textStyle) {
        super(2);
        this.f31007g = f11;
        this.f31008h = f12;
        this.f31009i = counterChange;
        this.f31010j = str;
        this.f31011k = z11;
        this.f31012l = i11;
        this.f31013m = str2;
        this.f31014n = j11;
        this.f31015o = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: androidx.compose.animation.core.Animatable} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r8 = r25
            r1 = r26 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r25.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r25.skipToGroupEnd()
            goto L_0x0123
        L_0x0016:
            float r1 = r0.f31007g
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r8.startReplaceableGroup(r2)
            java.lang.Object r3 = r25.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            r9 = 0
            if (r3 != r5) goto L_0x0046
            androidx.compose.animation.core.Animatable r3 = new androidx.compose.animation.core.Animatable
            float r5 = (float) r9
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r5)
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r5)
            androidx.compose.ui.unit.Dp$Companion r5 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r12 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r5)
            r13 = 0
            r14 = 4
            r15 = 0
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15)
            r8.updateRememberedValue(r3)
        L_0x0046:
            r25.endReplaceableGroup()
            r21 = r3
            androidx.compose.animation.core.Animatable r21 = (androidx.compose.animation.core.Animatable) r21
            r8.startReplaceableGroup(r2)
            java.lang.Object r2 = r25.rememberedValue()
            java.lang.Object r3 = r4.getEmpty()
            if (r2 != r3) goto L_0x0070
            androidx.compose.animation.core.Animatable r2 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r1)
            androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r12 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r1)
            r13 = 0
            r14 = 4
            r15 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15)
            r8.updateRememberedValue(r2)
        L_0x0070:
            r25.endReplaceableGroup()
            r22 = r2
            androidx.compose.animation.core.Animatable r22 = (androidx.compose.animation.core.Animatable) r22
            java.lang.Object r1 = r21.getTargetValue()
            androidx.compose.ui.unit.Dp r1 = (androidx.compose.ui.unit.Dp) r1
            float r1 = r1.m5492unboximpl()
            float r2 = (float) r9
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r2)
            boolean r23 = androidx.compose.ui.unit.Dp.m5483equalsimpl0(r1, r3)
            java.lang.Object r1 = r22.getTargetValue()
            androidx.compose.ui.unit.Dp r1 = (androidx.compose.ui.unit.Dp) r1
            float r1 = r1.m5492unboximpl()
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r2)
            boolean r20 = androidx.compose.ui.unit.Dp.m5483equalsimpl0(r1, r2)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            float r2 = r0.f31008h
            float r3 = r0.f31007g
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m562sizeInqDBjuR0$default(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r3 = 3
            androidx.compose.ui.Modifier r1 = androidx.compose.animation.AnimationModifierKt.animateContentSize$default(r1, r2, r2, r3, r2)
            r3 = 0
            com.designsystem.ds_counter.CounterComposablesKt$CounterLabels$1$1 r4 = new com.designsystem.ds_counter.CounterComposablesKt$CounterLabels$1$1
            java.lang.String r13 = r0.f31010j
            java.lang.String r14 = r0.f31013m
            long r5 = r0.f31014n
            androidx.compose.ui.text.TextStyle r7 = r0.f31015o
            int r15 = r0.f31012l
            r10 = r4
            r11 = r21
            r12 = r23
            r18 = r15
            r15 = r5
            r17 = r7
            r19 = r22
            r10.<init>(r11, r12, r13, r14, r15, r17, r18, r19, r20)
            r5 = -819893789(0xffffffffcf2169e3, float:-2.70807117E9)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r5, r10, r4)
            r6 = 3072(0xc00, float:4.305E-42)
            r7 = 6
            r5 = r25
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r1, r2, r3, r4, r5, r6, r7)
            com.designsystem.ds_counter.CounterChange r1 = r0.f31009i
            if (r23 == 0) goto L_0x00e4
            r2 = r21
            goto L_0x00e6
        L_0x00e4:
            r2 = r22
        L_0x00e6:
            if (r23 != 0) goto L_0x00eb
            r3 = r21
            goto L_0x00ed
        L_0x00eb:
            r3 = r22
        L_0x00ed:
            java.lang.String r4 = r0.f31010j
            float r5 = r0.f31007g
            boolean r6 = r0.f31011k
            if (r6 != 0) goto L_0x0104
            boolean r6 = r21.isRunning()
            if (r6 != 0) goto L_0x0104
            boolean r6 = r22.isRunning()
            if (r6 == 0) goto L_0x0102
            goto L_0x0104
        L_0x0102:
            r6 = r9
            goto L_0x0105
        L_0x0104:
            r6 = r10
        L_0x0105:
            int r7 = r0.f31012l
            int r9 = r7 >> 3
            r9 = r9 & 14
            int r10 = androidx.compose.animation.core.Animatable.$stable
            int r11 = r10 << 3
            r9 = r9 | r11
            int r10 = r10 << 6
            r9 = r9 | r10
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r10
            int r7 = r7 >> 12
            r10 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r10
            r9 = r9 | r7
            r7 = r25
            r8 = r9
            com.designsystem.ds_counter.CounterComposablesKt.m8318CounterAnimationFJfuzF0(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0123:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_counter.CounterComposablesKt$CounterLabels$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
