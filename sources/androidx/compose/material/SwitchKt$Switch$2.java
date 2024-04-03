package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwitchKt$Switch$2 extends Lambda implements Function2<Boolean, Boolean, ThresholdConfig> {
    public static final SwitchKt$Switch$2 INSTANCE = new SwitchKt$Switch$2();

    public SwitchKt$Switch$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
    }

    @NotNull
    public final ThresholdConfig invoke(boolean z11, boolean z12) {
        return new FractionalThreshold(0.5f);
    }
}
