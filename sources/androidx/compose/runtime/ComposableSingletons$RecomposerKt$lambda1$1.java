package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.runtime.ComposableSingletons$RecomposerKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$RecomposerKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$RecomposerKt$lambda1$1 INSTANCE = new ComposableSingletons$RecomposerKt$lambda1$1();

    public ComposableSingletons$RecomposerKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091980426, i11, -1, "androidx.compose.runtime.ComposableSingletons$RecomposerKt.lambda-1.<anonymous> (Recomposer.kt:380)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
