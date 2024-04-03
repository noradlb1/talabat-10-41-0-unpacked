package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableSingletons$CompositionKt {
    @NotNull
    public static final ComposableSingletons$CompositionKt INSTANCE = new ComposableSingletons$CompositionKt();
    @NotNull

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f38lambda1 = ComposableLambdaKt.composableLambdaInstance(954879418, false, ComposableSingletons$CompositionKt$lambda1$1.INSTANCE);
    @NotNull

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f39lambda2 = ComposableLambdaKt.composableLambdaInstance(1918065384, false, ComposableSingletons$CompositionKt$lambda2$1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$runtime_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2522getLambda1$runtime_release() {
        return f38lambda1;
    }

    @NotNull
    /* renamed from: getLambda-2$runtime_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2523getLambda2$runtime_release() {
        return f39lambda2;
    }
}
