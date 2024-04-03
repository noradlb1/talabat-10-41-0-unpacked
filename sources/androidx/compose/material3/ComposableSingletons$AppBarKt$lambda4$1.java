package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.material3.ComposableSingletons$AppBarKt$lambda-4$1  reason: invalid class name */
public final class ComposableSingletons$AppBarKt$lambda4$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$AppBarKt$lambda4$1 INSTANCE = new ComposableSingletons$AppBarKt$lambda4$1();

    public ComposableSingletons$AppBarKt$lambda4$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$null");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2098467925, i11, -1, "androidx.compose.material3.ComposableSingletons$AppBarKt.lambda-4.<anonymous> (AppBar.kt:186)");
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
