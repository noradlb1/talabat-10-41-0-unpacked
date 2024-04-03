package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aM\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u001d\u001aC\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001aK\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001aK\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\"\u001aK\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\"\u001aC\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010(\u001aK\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\"\u001as\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0\u0012\"\u0004\b\u0000\u0010,\"\b\b\u0001\u0010-*\u00020.2\u0006\u0010\u0013\u001a\u0002H,2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H-002\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H,0\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u0001H,2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00101\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnimateAsStateKt {
    @NotNull
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
    @NotNull
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m5476boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, (Object) null);
    @NotNull
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, (Object) null);
    @NotNull
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
    @NotNull
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, (Object) null);
    @NotNull
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m2665boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, (Object) null);
    @NotNull
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, (Object) null);
    @NotNull
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m2733boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, (Object) null);

    @NotNull
    @Composable
    /* renamed from: animateDpAsState-Kz89ssw  reason: not valid java name */
    public static final State<Dp> m102animateDpAsStateKz89ssw(float f11, @Nullable AnimationSpec<Dp> animationSpec, @Nullable Function1<? super Dp, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(704104481);
        if ((i12 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        State<Dp> animateValueAsState = animateValueAsState(Dp.m5476boximpl(f11), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, (Dp) null, function1, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: androidx.compose.animation.core.AnimationSpec<java.lang.Float>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<java.lang.Float> animateFloatAsState(float r9, @org.jetbrains.annotations.Nullable androidx.compose.animation.core.AnimationSpec<java.lang.Float> r10, float r11, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r12, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = 1091643291(0x4111279b, float:9.072169)
            r13.startReplaceableGroup(r0)
            r0 = r15 & 2
            if (r0 == 0) goto L_0x000c
            androidx.compose.animation.core.SpringSpec<java.lang.Float> r10 = defaultAnimation
        L_0x000c:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x0013
            r11 = 1008981770(0x3c23d70a, float:0.01)
        L_0x0013:
            r15 = r15 & 8
            r0 = 0
            if (r15 == 0) goto L_0x001a
            r5 = r0
            goto L_0x001b
        L_0x001a:
            r5 = r12
        L_0x001b:
            r12 = 841393485(0x3226a54d, float:9.700057E-9)
            r13.startReplaceableGroup(r12)
            androidx.compose.animation.core.SpringSpec<java.lang.Float> r12 = defaultAnimation
            r15 = 3
            if (r10 != r12) goto L_0x0054
            java.lang.Float r10 = java.lang.Float.valueOf(r11)
            r12 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r12)
            boolean r10 = r13.changed((java.lang.Object) r10)
            java.lang.Object r12 = r13.rememberedValue()
            if (r10 != 0) goto L_0x0042
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x004e
        L_0x0042:
            java.lang.Float r10 = java.lang.Float.valueOf(r11)
            r12 = 0
            androidx.compose.animation.core.SpringSpec r12 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r12, r12, r10, r15, r0)
            r13.updateRememberedValue(r12)
        L_0x004e:
            r13.endReplaceableGroup()
            r10 = r12
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
        L_0x0054:
            r3 = r10
            r13.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r9)
            kotlin.jvm.internal.FloatCompanionObject r9 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r2 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r9)
            java.lang.Float r4 = java.lang.Float.valueOf(r11)
            r9 = r14 & 14
            int r10 = r14 << 3
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            r7 = r9 | r10
            r8 = 0
            r6 = r13
            androidx.compose.runtime.State r9 = animateValueAsState(r1, r2, r3, r4, r5, r6, r7, r8)
            r13.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(float, androidx.compose.animation.core.AnimationSpec, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    @NotNull
    @Composable
    public static final State<Integer> animateIntAsState(int i11, @Nullable AnimationSpec<Integer> animationSpec, @Nullable Function1<? super Integer, Unit> function1, @Nullable Composer composer, int i12, int i13) {
        composer.startReplaceableGroup(-842612981);
        if ((i13 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec<Integer> animationSpec2 = animationSpec;
        if ((i13 & 4) != 0) {
            function1 = null;
        }
        State<Integer> animateValueAsState = animateValueAsState(Integer.valueOf(i11), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, (Integer) null, function1, composer, (i12 & 14) | ((i12 << 3) & 896) | ((i12 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @NotNull
    @Composable
    /* renamed from: animateIntOffsetAsState-8f6pmRE  reason: not valid java name */
    public static final State<IntOffset> m103animateIntOffsetAsState8f6pmRE(long j11, @Nullable AnimationSpec<IntOffset> animationSpec, @Nullable Function1<? super IntOffset, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(1010307371);
        if ((i12 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec<IntOffset> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        State<IntOffset> animateValueAsState = animateValueAsState(IntOffset.m5587boximpl(j11), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, (IntOffset) null, function1, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @NotNull
    @Composable
    /* renamed from: animateIntSizeAsState-zTRF_AQ  reason: not valid java name */
    public static final State<IntSize> m104animateIntSizeAsStatezTRF_AQ(long j11, @Nullable AnimationSpec<IntSize> animationSpec, @Nullable Function1<? super IntSize, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-1749239765);
        if ((i12 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec<IntSize> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        State<IntSize> animateValueAsState = animateValueAsState(IntSize.m5630boximpl(j11), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, (IntSize) null, function1, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @NotNull
    @Composable
    /* renamed from: animateOffsetAsState-N6fFfp4  reason: not valid java name */
    public static final State<Offset> m105animateOffsetAsStateN6fFfp4(long j11, @Nullable AnimationSpec<Offset> animationSpec, @Nullable Function1<? super Offset, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-456513133);
        if ((i12 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec<Offset> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        State<Offset> animateValueAsState = animateValueAsState(Offset.m2665boximpl(j11), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, (Offset) null, function1, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @NotNull
    @Composable
    public static final State<Rect> animateRectAsState(@NotNull Rect rect, @Nullable AnimationSpec<Rect> animationSpec, @Nullable Function1<? super Rect, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(rect, "targetValue");
        composer.startReplaceableGroup(-782613967);
        if ((i12 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec<Rect> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        Rect rect2 = rect;
        State<Rect> animateValueAsState = animateValueAsState(rect2, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, (Rect) null, function1, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @NotNull
    @Composable
    /* renamed from: animateSizeAsState-LjSzlW0  reason: not valid java name */
    public static final State<Size> m106animateSizeAsStateLjSzlW0(long j11, @Nullable AnimationSpec<Size> animationSpec, @Nullable Function1<? super Size, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(875212471);
        if ((i12 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec<Size> animationSpec2 = animationSpec;
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        State<Size> animateValueAsState = animateValueAsState(Size.m2733boximpl(j11), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, (Size) null, function1, composer, (i11 & 14) | ((i11 << 3) & 896) | ((i11 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @NotNull
    @Composable
    public static final <T, V extends AnimationVector> State<T> animateValueAsState(T t11, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable AnimationSpec<T> animationSpec, @Nullable T t12, @Nullable Function1<? super T, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        AnimationSpec<T> animationSpec2;
        Function1<? super T, Unit> function12;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        composer2.startReplaceableGroup(-846382129);
        if ((i12 & 4) != 0) {
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, t12, 3, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) rememberedValue;
        } else {
            animationSpec2 = animationSpec;
        }
        if ((i12 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        Animatable animatable = rememberedValue2;
        if (rememberedValue2 == companion.getEmpty()) {
            Animatable animatable2 = new Animatable(t11, twoWayConverter, (Object) null, 4, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(animatable2);
            animatable = animatable2;
        }
        composer.endReplaceableGroup();
        Animatable animatable3 = (Animatable) animatable;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function12, composer2, (i11 >> 12) & 14);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(animationSpec2, composer2, (i11 >> 6) & 14);
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Channel channel = (Channel) rememberedValue3;
        EffectsKt.SideEffect(new AnimateAsStateKt$animateValueAsState$2(channel, t11), composer2, 0);
        EffectsKt.LaunchedEffect((Object) channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnimateAsStateKt$animateValueAsState$3(channel, animatable3, rememberUpdatedState2, rememberUpdatedState, (Continuation<? super AnimateAsStateKt$animateValueAsState$3>) null), composer2, 8);
        State<T> asState = animatable3.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    /* renamed from: animateValueAsState$lambda-3  reason: not valid java name */
    public static final <T> Function1<T, Unit> m107animateValueAsState$lambda3(State<? extends Function1<? super T, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateValueAsState$lambda-4  reason: not valid java name */
    public static final <T> AnimationSpec<T> m108animateValueAsState$lambda4(State<? extends AnimationSpec<T>> state) {
        return (AnimationSpec) state.getValue();
    }
}
