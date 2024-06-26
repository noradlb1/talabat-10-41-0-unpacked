package com.designsystem.ds_input_field;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$animateHintOffset$1 extends Lambda implements Function3<Transition.Segment<InputState>, Composer, Integer, FiniteAnimationSpec<Offset>> {
    public static final InputFieldCommonComposablesKt$animateHintOffset$1 INSTANCE = new InputFieldCommonComposablesKt$animateHintOffset$1();

    public InputFieldCommonComposablesKt$animateHintOffset$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Offset> invoke(@NotNull Transition.Segment<InputState> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$animateValue");
        composer.startReplaceableGroup(1050291817);
        TweenSpec tween$default = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
        composer.endReplaceableGroup();
        return tween$default;
    }
}
