package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$SliderImpl$gestureEndAction$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SliderDraggableState f8092g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8093h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$gestureEndAction$1(SliderDraggableState sliderDraggableState, Function0<Unit> function0) {
        super(0);
        this.f8092g = sliderDraggableState;
        this.f8093h = function0;
    }

    public final void invoke() {
        Function0<Unit> function0;
        if (!this.f8092g.isDragging() && (function0 = this.f8093h) != null) {
            function0.invoke();
        }
    }
}
