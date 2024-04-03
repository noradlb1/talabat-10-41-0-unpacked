package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m0.y1;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"installForLifecycle", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewCompositionStrategy_androidKt {
    /* access modifiers changed from: private */
    public static final Function0<Unit> installForLifecycle(AbstractComposeView abstractComposeView, Lifecycle lifecycle) {
        boolean z11;
        if (lifecycle.getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            y1 y1Var = new y1(abstractComposeView);
            lifecycle.addObserver(y1Var);
            return new ViewCompositionStrategy_androidKt$installForLifecycle$2(lifecycle, y1Var);
        }
        throw new IllegalStateException(("Cannot configure " + abstractComposeView + " to disposeComposition at Lifecycle ON_DESTROY: " + lifecycle + "is already destroyed").toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: installForLifecycle$lambda-1  reason: not valid java name */
    public static final void m4880installForLifecycle$lambda1(AbstractComposeView abstractComposeView, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(abstractComposeView, "$view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            abstractComposeView.disposeComposition();
        }
    }
}
