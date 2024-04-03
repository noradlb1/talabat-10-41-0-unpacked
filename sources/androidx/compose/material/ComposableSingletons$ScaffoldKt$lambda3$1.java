package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/material/SnackbarHostState;", "invoke", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-3$1  reason: invalid class name */
public final class ComposableSingletons$ScaffoldKt$lambda3$1 extends Lambda implements Function3<SnackbarHostState, Composer, Integer, Unit> {
    public static final ComposableSingletons$ScaffoldKt$lambda3$1 INSTANCE = new ComposableSingletons$ScaffoldKt$lambda3$1();

    public ComposableSingletons$ScaffoldKt$lambda3$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SnackbarHostState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull SnackbarHostState snackbarHostState, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(snackbarHostState, "it");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) snackbarHostState) ? 4 : 2;
        }
        if ((i11 & 91) != 18 || !composer.getSkipping()) {
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit>) null, composer, i11 & 14, 6);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
