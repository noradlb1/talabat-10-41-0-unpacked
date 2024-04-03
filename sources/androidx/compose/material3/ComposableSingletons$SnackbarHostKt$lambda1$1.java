package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/material3/SnackbarData;", "invoke", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.material3.ComposableSingletons$SnackbarHostKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$SnackbarHostKt$lambda1$1 extends Lambda implements Function3<SnackbarData, Composer, Integer, Unit> {
    public static final ComposableSingletons$SnackbarHostKt$lambda1$1 INSTANCE = new ComposableSingletons$SnackbarHostKt$lambda1$1();

    public ComposableSingletons$SnackbarHostKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SnackbarData) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull SnackbarData snackbarData, @Nullable Composer composer, int i11) {
        int i12;
        SnackbarData snackbarData2 = snackbarData;
        Intrinsics.checkNotNullParameter(snackbarData2, "it");
        Composer composer2 = composer;
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) snackbarData2) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(818736383, i12, -1, "androidx.compose.material3.ComposableSingletons$SnackbarHostKt.lambda-1.<anonymous> (SnackbarHost.kt:221)");
            }
            SnackbarKt.m1828SnackbarsDKtq54(snackbarData, (Modifier) null, false, (Shape) null, 0, 0, 0, 0, 0, composer, i12 & 14, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
