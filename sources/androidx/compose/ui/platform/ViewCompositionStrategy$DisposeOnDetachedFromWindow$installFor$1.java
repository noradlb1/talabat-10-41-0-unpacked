package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractComposeView f10048g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1 f10049h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$1(AbstractComposeView abstractComposeView, ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1 viewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1) {
        super(0);
        this.f10048g = abstractComposeView;
        this.f10049h = viewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1;
    }

    public final void invoke() {
        this.f10048g.removeOnAttachStateChangeListener(this.f10049h);
    }
}
