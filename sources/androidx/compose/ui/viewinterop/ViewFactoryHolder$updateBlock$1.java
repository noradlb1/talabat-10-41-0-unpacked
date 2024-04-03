package androidx.compose.ui.viewinterop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ViewFactoryHolder$updateBlock$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewFactoryHolder<T> f10335g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder$updateBlock$1(ViewFactoryHolder<T> viewFactoryHolder) {
        super(0);
        this.f10335g = viewFactoryHolder;
    }

    public final void invoke() {
        T typedView$ui_release = this.f10335g.getTypedView$ui_release();
        if (typedView$ui_release != null) {
            this.f10335g.getUpdateBlock().invoke(typedView$ui_release);
        }
    }
}
