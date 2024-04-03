package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$Snackbar$dismissActionComposable$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8329g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$dismissActionComposable$1$1$1(SnackbarData snackbarData) {
        super(0);
        this.f8329g = snackbarData;
    }

    public final void invoke() {
        this.f8329g.dismiss();
    }
}
