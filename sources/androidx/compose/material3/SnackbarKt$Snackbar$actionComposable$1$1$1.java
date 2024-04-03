package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$Snackbar$actionComposable$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8325g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$actionComposable$1$1$1(SnackbarData snackbarData) {
        super(0);
        this.f8325g = snackbarData;
    }

    public final void invoke() {
        this.f8325g.performAction();
    }
}
