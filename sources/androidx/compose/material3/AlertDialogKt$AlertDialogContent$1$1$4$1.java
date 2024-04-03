package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt$AlertDialogContent$1$1$4$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6276g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6277h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$1$1$4$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f6276g = function2;
        this.f6277h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-433542216, i11, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:112)");
            }
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), this.f6276g, composer, (this.f6277h << 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
