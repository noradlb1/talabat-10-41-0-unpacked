package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "motionEvent", "Landroid/view/MotionEvent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PointerInteropFilter$pointerInputFilter$1$dispatchToView$2 extends Lambda implements Function1<MotionEvent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PointerInteropFilter f9788g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PointerInteropFilter$pointerInputFilter$1$dispatchToView$2(PointerInteropFilter pointerInteropFilter) {
        super(1);
        this.f9788g = pointerInteropFilter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MotionEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        this.f9788g.getOnTouchEvent().invoke(motionEvent);
    }
}
