package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class TransitionKt$animateOffset$1 extends Lambda implements Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Offset>> {
    public static final TransitionKt$animateOffset$1 INSTANCE = new TransitionKt$animateOffset$1();

    public TransitionKt$animateOffset$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final SpringSpec<Offset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$null");
        composer.startReplaceableGroup(1623385561);
        SpringSpec<Offset> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m2665boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, (Object) null);
        composer.endReplaceableGroup();
        return spring$default;
    }
}
