package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1 implements View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractComposeView f10050b;

    public ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1(AbstractComposeView abstractComposeView) {
        this.f10050b = abstractComposeView;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        this.f10050b.disposeComposition();
    }
}
