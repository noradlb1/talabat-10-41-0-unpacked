package androidx.compose.material3;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1 INSTANCE = new ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1();

    public ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) (KeyframesSpec.KeyframesSpecConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1800);
        keyframesSpecConfig.with(keyframesSpecConfig.at(Float.valueOf(0.0f), 1267), ProgressIndicatorKt.SecondLineTailEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1800);
    }
}
