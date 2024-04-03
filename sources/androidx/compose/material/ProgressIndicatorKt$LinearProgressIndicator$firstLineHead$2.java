package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2 INSTANCE = new ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2();

    public ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) (KeyframesSpec.KeyframesSpecConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1800);
        keyframesSpecConfig.with(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.FirstLineHeadEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 750);
    }
}
