package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ComposableSingletons$SnackbarHostKt {
    @NotNull
    public static final ComposableSingletons$SnackbarHostKt INSTANCE = new ComposableSingletons$SnackbarHostKt();
    @NotNull

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function3<SnackbarData, Composer, Integer, Unit> f13lambda1 = ComposableLambdaKt.composableLambdaInstance(996639038, false, ComposableSingletons$SnackbarHostKt$lambda1$1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$material_release  reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m1209getLambda1$material_release() {
        return f13lambda1;
    }
}
