package curtains.internal;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
public final class NextDrawListener$onDraw$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NextDrawListener f13801b;

    public NextDrawListener$onDraw$1(NextDrawListener nextDrawListener) {
        this.f13801b = nextDrawListener;
    }

    public final void run() {
        ViewTreeObserver viewTreeObserver = this.f13801b.view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnDrawListener(this.f13801b);
        }
    }
}
