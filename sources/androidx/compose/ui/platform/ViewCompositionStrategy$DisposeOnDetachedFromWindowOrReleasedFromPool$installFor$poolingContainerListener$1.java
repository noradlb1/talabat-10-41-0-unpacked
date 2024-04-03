package androidx.compose.ui.platform;

import androidx.customview.poolingcontainer.PoolingContainerListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1 implements PoolingContainerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractComposeView f10055a;

    public ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1(AbstractComposeView abstractComposeView) {
        this.f10055a = abstractComposeView;
    }

    public final void onRelease() {
        this.f10055a.disposeComposition();
    }
}
