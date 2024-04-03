package curtains;

import android.view.View;
import android.view.Window;
import curtains.internal.WindowListeners;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"curtains/WindowsKt$onDecorViewReady$1$1", "Lcurtains/OnContentChangedListener;", "onContentChanged", "", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowsKt$onDecorViewReady$$inlined$run$lambda$1 implements OnContentChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowListeners f13797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Window f13798b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f13799c;

    public WindowsKt$onDecorViewReady$$inlined$run$lambda$1(WindowListeners windowListeners, Window window, Function1 function1) {
        this.f13797a = windowListeners;
        this.f13798b = window;
        this.f13799c = function1;
    }

    public void onContentChanged() {
        this.f13797a.getOnContentChangedListeners().remove(this);
        Function1 function1 = this.f13799c;
        View peekDecorView = this.f13798b.peekDecorView();
        Intrinsics.checkNotNullExpressionValue(peekDecorView, "peekDecorView()");
        function1.invoke(peekDecorView);
    }
}
