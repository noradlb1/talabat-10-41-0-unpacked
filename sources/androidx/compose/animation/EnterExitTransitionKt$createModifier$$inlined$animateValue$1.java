package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterExitTransitionKt$createModifier$$inlined$animateValue$1 extends Lambda implements Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>> {
    public static final EnterExitTransitionKt$createModifier$$inlined$animateValue$1 INSTANCE = new EnterExitTransitionKt$createModifier$$inlined$animateValue$1();

    public EnterExitTransitionKt$createModifier$$inlined$animateValue$1() {
        super(3);
    }

    @NotNull
    @Composable
    public final SpringSpec<TransformOrigin> invoke(@NotNull Transition.Segment<EnterExitState> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$null");
        composer.startReplaceableGroup(-895531546);
        SpringSpec<TransformOrigin> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        composer.endReplaceableGroup();
        return spring$default;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<EnterExitState>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
