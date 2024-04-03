package androidx.compose.ui.window;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$Dialog$dialog$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function2<Composer, Integer, Unit>> f10349g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidDialog_androidKt$Dialog$dialog$1$1$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        super(2);
        this.f10349g = state;
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
                ComposerKt.traceEventStart(488261145, i11, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:174)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, (Object) null);
            final State<Function2<Composer, Integer, Unit>> state = this.f10349g;
            AndroidDialog_androidKt.DialogLayout(semantics$default, ComposableLambdaKt.composableLambda(composer, -533674951, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-533674951, i11, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:179)");
                        }
                        AndroidDialog_androidKt.m5724Dialog$lambda0(state).invoke(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
