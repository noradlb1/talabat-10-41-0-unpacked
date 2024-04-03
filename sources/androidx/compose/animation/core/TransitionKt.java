package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a3\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001c0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020!0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020#0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020%0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020'0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a©\u0001\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00040\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00040\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0001¢\u0006\u0002\u0010-\u001a_\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000f0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010/\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002H\u00040\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0001¢\u0006\u0002\u00101\u001aA\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0006\u00103\u001a\u0002H\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\u0006\u00104\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00105\u001aa\u00106\u001a\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)07R\b\u0012\u0004\u0012\u0002H\u000f0\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u00108\u001am\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00040\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0006\u0010:\u001a\u0002H\u00042\u0006\u0010;\u001a\u0002H\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006>"}, d2 = {"AnimationDebugDurationScale", "", "updateTransition", "Landroidx/compose/animation/core/Transition;", "T", "targetState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<Dp> animateDp(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Dp> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(184732935);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateDp$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<Dp> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<Float> animateFloat(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Float> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-1338768149);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateFloat$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<Float> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<Integer> animateInt(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Integer> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(1318902782);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateInt$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<Integer> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<IntOffset> animateIntOffset(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, IntOffset> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(776131825);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateIntOffset$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<IntOffset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<IntSize> animateIntSize(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, IntSize> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-2104123233);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateIntSize$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<IntSize> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<Offset> animateOffset(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Offset> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(2078477582);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateOffset$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<Offset> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<Rect> animateRect(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Rect> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(1496278239);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateRect$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<Rect> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S> State<Size> animateSize(@NotNull Transition<S> transition, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, Size> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-802210820);
        if ((i12 & 1) != 0) {
            function3 = TransitionKt$animateSize$1.INSTANCE;
        }
        if ((i12 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        int i13 = i11 & 14;
        int i14 = i11 << 3;
        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i16 = (i15 >> 9) & 112;
        State<Size> createTransitionAnimation = createTransitionAnimation(transition, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i16)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i16)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i15 >> 3) & 112)), vectorConverter, str2, composer, (i15 & 14) | ((i15 << 9) & 57344) | ((i15 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    @Composable
    public static final <S, T, V extends AnimationVector> State<T> animateValue(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, ? extends T> function32, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(function32, "targetValueByState");
        composer.startReplaceableGroup(-142660079);
        if ((i12 & 2) != 0) {
            function3 = TransitionKt$animateValue$1.INSTANCE;
        }
        if ((i12 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i13 = (i11 >> 9) & 112;
        Transition<S> transition2 = transition;
        TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
        State<T> createTransitionAnimation = createTransitionAnimation(transition2, function32.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), function32.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, Integer.valueOf((i11 >> 3) & 112)), twoWayConverter2, str, composer, (i11 & 14) | (57344 & (i11 << 9)) | ((i11 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @ExperimentalTransitionApi
    @NotNull
    @Composable
    public static final <S, T> Transition<T> createChildTransition(@NotNull Transition<S> transition, @Nullable String str, @NotNull Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(function3, "transformToChildState");
        composer.startReplaceableGroup(1215497572);
        if ((i12 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i13 = i11 & 14;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) transition);
        S rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        if (transition.isSeeking()) {
            rememberedValue = transition.getCurrentState();
        }
        int i14 = (i11 >> 3) & 112;
        Transition<T> createChildTransitionInternal = createChildTransitionInternal(transition, function3.invoke(rememberedValue, composer, Integer.valueOf(i14)), function3.invoke(transition.getTargetState(), composer, Integer.valueOf(i14)), str2, composer, i13 | ((i11 << 6) & 7168));
        composer.endReplaceableGroup();
        return createChildTransitionInternal;
    }

    @PublishedApi
    @NotNull
    @Composable
    public static final <S, T> Transition<T> createChildTransitionInternal(@NotNull Transition<S> transition, T t11, T t12, @NotNull String str, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(str, "childLabel");
        composer.startReplaceableGroup(-198307638);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            MutableTransitionState mutableTransitionState = new MutableTransitionState(t11);
            rememberedValue = new Transition(mutableTransitionState, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition2 = (Transition) rememberedValue;
        EffectsKt.DisposableEffect((Object) transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TransitionKt$createChildTransitionInternal$1(transition, transition2), composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t11, t12, transition.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t12, composer, ((i11 >> 3) & 8) | ((i11 >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        composer.endReplaceableGroup();
        return transition2;
    }

    @InternalAnimationApi
    @NotNull
    @Composable
    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(@NotNull Transition<S> transition, @NotNull TwoWayConverter<T, V> twoWayConverter, @Nullable String str, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        composer.startReplaceableGroup(-1714122528);
        if ((i12 & 2) != 0) {
            str = "DeferredAnimation";
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition.DeferredAnimation(transition, twoWayConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) rememberedValue;
        EffectsKt.DisposableEffect((Object) deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TransitionKt$createDeferredAnimation$1(transition, deferredAnimation), composer, 8);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        composer.endReplaceableGroup();
        return deferredAnimation;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.compose.animation.core.Transition$TransitionAnimationState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.compose.animation.core.Transition$TransitionAnimationState} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0030, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0032;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.runtime.State<T> createTransitionAnimation(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<S> r7, T r8, T r9, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.FiniteAnimationSpec<T> r10, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.TwoWayConverter<T, V> r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r13, int r14) {
        /*
            java.lang.String r14 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r14)
            java.lang.String r14 = "animationSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r14)
            java.lang.String r14 = "typeConverter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r14)
            java.lang.String r14 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r14)
            r14 = -304821198(0xffffffffedd4cc32, float:-8.23221E27)
            r13.startReplaceableGroup(r14)
            r14 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r14)
            boolean r14 = r13.changed((java.lang.Object) r7)
            java.lang.Object r0 = r13.rememberedValue()
            if (r14 != 0) goto L_0x0032
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r0 != r14) goto L_0x0043
        L_0x0032:
            androidx.compose.animation.core.Transition$TransitionAnimationState r0 = new androidx.compose.animation.core.Transition$TransitionAnimationState
            androidx.compose.animation.core.AnimationVector r4 = androidx.compose.animation.core.AnimationStateKt.createZeroVectorFrom(r11, r9)
            r1 = r0
            r2 = r7
            r3 = r8
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r13.updateRememberedValue(r0)
        L_0x0043:
            r13.endReplaceableGroup()
            androidx.compose.animation.core.Transition$TransitionAnimationState r0 = (androidx.compose.animation.core.Transition.TransitionAnimationState) r0
            boolean r11 = r7.isSeeking()
            if (r11 == 0) goto L_0x0052
            r0.updateInitialAndTargetValue$animation_core_release(r8, r9, r10)
            goto L_0x0055
        L_0x0052:
            r0.updateTargetValue$animation_core_release(r9, r10)
        L_0x0055:
            androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1 r8 = new androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1
            r8.<init>(r7, r0)
            r7 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r8, (androidx.compose.runtime.Composer) r13, (int) r7)
            r13.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.TransitionKt.createTransitionAnimation(androidx.compose.animation.core.Transition, java.lang.Object, java.lang.Object, androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.TwoWayConverter, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    @NotNull
    @Composable
    public static final <T> Transition<T> updateTransition(T t11, @Nullable String str, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(2029166765);
        if ((i12 & 2) != 0) {
            str = null;
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(t11, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(t11, composer, (i11 & 8) | 48 | (i11 & 14));
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TransitionKt$updateTransition$1(transition), composer, 6);
        composer.endReplaceableGroup();
        return transition;
    }

    @NotNull
    @Composable
    public static final <T> Transition<T> updateTransition(@NotNull MutableTransitionState<T> mutableTransitionState, @Nullable String str, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(mutableTransitionState, "transitionState");
        composer.startReplaceableGroup(882913843);
        if ((i12 & 2) != 0) {
            str = null;
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) mutableTransitionState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Transition(mutableTransitionState, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(mutableTransitionState.getTargetState(), composer, 0);
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TransitionKt$updateTransition$2(transition), composer, 0);
        composer.endReplaceableGroup();
        return transition;
    }
}
