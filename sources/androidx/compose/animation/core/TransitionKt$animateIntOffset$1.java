package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class TransitionKt$animateIntOffset$1 extends Lambda implements Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntOffset>> {
    public static final TransitionKt$animateIntOffset$1 INSTANCE = new TransitionKt$animateIntOffset$1();

    public TransitionKt$animateIntOffset$1() {
        super(3);
    }

    @NotNull
    @Composable
    public final SpringSpec<IntOffset> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$null");
        composer.startReplaceableGroup(-1953479610);
        SpringSpec<IntOffset> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5587boximpl(IntOffsetKt.IntOffset(1, 1)), 3, (Object) null);
        composer.endReplaceableGroup();
        return spring$default;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
