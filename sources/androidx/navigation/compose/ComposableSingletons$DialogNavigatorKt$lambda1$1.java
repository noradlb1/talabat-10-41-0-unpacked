package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke", "(Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.navigation.compose.ComposableSingletons$DialogNavigatorKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$DialogNavigatorKt$lambda1$1 extends Lambda implements Function3<NavBackStackEntry, Composer, Integer, Unit> {
    public static final ComposableSingletons$DialogNavigatorKt$lambda1$1 INSTANCE = new ComposableSingletons$DialogNavigatorKt$lambda1$1();

    public ComposableSingletons$DialogNavigatorKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull NavBackStackEntry navBackStackEntry, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
    }
}
