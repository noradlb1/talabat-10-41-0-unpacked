package androidx.compose.ui.platform;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1 implements View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractComposeView f10059b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f10060c;

    public ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1(AbstractComposeView abstractComposeView, Ref.ObjectRef<Function0<Unit>> objectRef) {
        this.f10059b = abstractComposeView;
        this.f10060c = objectRef;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.f10059b);
        AbstractComposeView abstractComposeView = this.f10059b;
        if (lifecycleOwner != null) {
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "checkNotNull(ViewTreeLif…                        }");
            Ref.ObjectRef<Function0<Unit>> objectRef = this.f10060c;
            AbstractComposeView abstractComposeView2 = this.f10059b;
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lco.lifecycle");
            objectRef.element = ViewCompositionStrategy_androidKt.installForLifecycle(abstractComposeView2, lifecycle);
            this.f10059b.removeOnAttachStateChangeListener(this);
            return;
        }
        throw new IllegalStateException(("View tree for " + abstractComposeView + " has no ViewTreeLifecycleOwner").toString());
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }
}
