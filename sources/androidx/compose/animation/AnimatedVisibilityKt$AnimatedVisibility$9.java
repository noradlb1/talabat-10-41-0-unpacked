package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$9 extends Lambda implements Function1<Boolean, Boolean> {
    public static final AnimatedVisibilityKt$AnimatedVisibility$9 INSTANCE = new AnimatedVisibilityKt$AnimatedVisibility$9();

    public AnimatedVisibilityKt$AnimatedVisibility$9() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(boolean z11) {
        return Boolean.valueOf(z11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }
}
