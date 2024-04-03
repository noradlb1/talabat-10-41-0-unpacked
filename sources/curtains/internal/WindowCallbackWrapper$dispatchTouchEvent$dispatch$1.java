package curtains.internal;

import android.view.MotionEvent;
import curtains.DispatchState;
import curtains.TouchEventInterceptor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"curtains/internal/WindowCallbackWrapper$dispatchTouchEvent$dispatch$1", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lcurtains/DispatchState;", "invoke", "interceptedEvent", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowCallbackWrapper$dispatchTouchEvent$dispatch$1 implements Function1<MotionEvent, DispatchState> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowCallbackWrapper f13806b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Iterator f13807c;

    public WindowCallbackWrapper$dispatchTouchEvent$dispatch$1(WindowCallbackWrapper windowCallbackWrapper, Iterator it) {
        this.f13806b = windowCallbackWrapper;
        this.f13807c = it;
    }

    @NotNull
    public DispatchState invoke(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "interceptedEvent");
        if (this.f13807c.hasNext()) {
            return ((TouchEventInterceptor) this.f13807c.next()).intercept(motionEvent, this);
        }
        return DispatchState.Companion.from$curtains_release(this.f13806b.delegate.dispatchTouchEvent(motionEvent));
    }
}
