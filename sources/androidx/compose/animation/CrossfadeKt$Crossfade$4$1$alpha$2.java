package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CrossfadeKt$Crossfade$4$1$alpha$2 extends Lambda implements Function3<Transition.Segment<T>, Composer, Integer, FiniteAnimationSpec<Float>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiniteAnimationSpec<Float> f1228g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CrossfadeKt$Crossfade$4$1$alpha$2(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        super(3);
        this.f1228g = finiteAnimationSpec;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<T> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$animateFloat");
        composer.startReplaceableGroup(438406499);
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.f1228g;
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
