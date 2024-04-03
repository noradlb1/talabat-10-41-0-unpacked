package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ViewCompositionStrategy_androidKt$installForLifecycle$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f10061g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LifecycleEventObserver f10062h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewCompositionStrategy_androidKt$installForLifecycle$2(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        super(0);
        this.f10061g = lifecycle;
        this.f10062h = lifecycleEventObserver;
    }

    public final void invoke() {
        this.f10061g.removeObserver(this.f10062h);
    }
}
