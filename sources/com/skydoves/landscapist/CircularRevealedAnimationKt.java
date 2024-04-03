package com.skydoves.landscapist;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"circularReveal", "Landroidx/compose/ui/graphics/painter/Painter;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "durationMs", "", "onFinishListener", "Lcom/skydoves/landscapist/CircularRevealFinishListener;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/ImageBitmap;ILcom/skydoves/landscapist/CircularRevealFinishListener;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/painter/Painter;", "landscapist_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CircularRevealedAnimationKt {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CircularRevealState.values().length];
            iArr[CircularRevealState.None.ordinal()] = 1;
            iArr[CircularRevealState.Finished.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    @Composable
    public static final Painter circularReveal(@NotNull Painter painter, @NotNull ImageBitmap imageBitmap, int i11, @Nullable CircularRevealFinishListener circularRevealFinishListener, @Nullable Composer composer, int i12, int i13) {
        CircularRevealFinishListener circularRevealFinishListener2;
        float f11;
        float f12;
        Painter painter2 = painter;
        ImageBitmap imageBitmap2 = imageBitmap;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(painter2, "<this>");
        Intrinsics.checkNotNullParameter(imageBitmap2, "imageBitmap");
        composer2.startReplaceableGroup(-234649234);
        if ((i13 & 4) != 0) {
            circularRevealFinishListener2 = null;
        } else {
            circularRevealFinishListener2 = circularRevealFinishListener;
        }
        composer2.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new MutableTransitionState(CircularRevealState.None);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableTransitionState mutableTransitionState = (MutableTransitionState) rememberedValue;
        mutableTransitionState.setTargetState(CircularRevealState.Finished);
        Transition updateTransition = TransitionKt.updateTransition(mutableTransitionState, (String) null, composer2, MutableTransitionState.$stable | 48, 0);
        CircularRevealedAnimationKt$circularReveal$radius$2 circularRevealedAnimationKt$circularReveal$radius$2 = new CircularRevealedAnimationKt$circularReveal$radius$2(i11);
        composer2.startReplaceableGroup(1399888299);
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        composer2.startReplaceableGroup(1847721878);
        composer2.startReplaceableGroup(-511059282);
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i14 = iArr[((CircularRevealState) updateTransition.getCurrentState()).ordinal()];
        if (i14 == 1) {
            f11 = 0.0f;
        } else if (i14 == 2) {
            if (circularRevealFinishListener2 != null) {
                circularRevealFinishListener2.onFinish();
            }
            f11 = 1.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        Float valueOf = Float.valueOf(f11);
        composer2.startReplaceableGroup(-511059282);
        int i15 = iArr[((CircularRevealState) updateTransition.getTargetState()).ordinal()];
        if (i15 == 1) {
            f12 = 0.0f;
        } else if (i15 == 2) {
            if (circularRevealFinishListener2 != null) {
                circularRevealFinishListener2.onFinish();
            }
            f12 = 1.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f12), (FiniteAnimationSpec) circularRevealedAnimationKt$circularReveal$radius$2.invoke(updateTransition.getSegment(), composer2, 0), vectorConverter, "FloatAnimation", composer, 196608);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer2.startReplaceableGroup(-3686930);
        boolean changed = composer2.changed((Object) painter2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new CircularRevealedPainter(imageBitmap2, painter2);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        CircularRevealedPainter circularRevealedPainter = (CircularRevealedPainter) rememberedValue2;
        circularRevealedPainter.setRadius(m9391circularReveal$lambda2(createTransitionAnimation));
        composer.endReplaceableGroup();
        return circularRevealedPainter;
    }

    /* renamed from: circularReveal$lambda-2  reason: not valid java name */
    private static final float m9391circularReveal$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
