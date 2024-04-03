package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> f8225g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8226h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8227i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, SnackbarData snackbarData, int i11) {
        super(2);
        this.f8225g = function3;
        this.f8226h = snackbarData;
        this.f8227i = i11;
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
                ComposerKt.traceEventStart(-1462081411, i11, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:403)");
            }
            Function3<SnackbarData, Composer, Integer, Unit> function3 = this.f8225g;
            SnackbarData snackbarData = this.f8226h;
            Intrinsics.checkNotNull(snackbarData);
            function3.invoke(snackbarData, composer, Integer.valueOf((this.f8227i >> 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
