package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableSingletons$Wrapper_androidKt {
    @NotNull
    public static final ComposableSingletons$Wrapper_androidKt INSTANCE = new ComposableSingletons$Wrapper_androidKt();
    @NotNull

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f42lambda1 = ComposableLambdaKt.composableLambdaInstance(-1759434350, false, ComposableSingletons$Wrapper_androidKt$lambda1$1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$ui_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4828getLambda1$ui_release() {
        return f42lambda1;
    }
}
