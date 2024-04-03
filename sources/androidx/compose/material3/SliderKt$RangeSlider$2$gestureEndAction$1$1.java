package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSlider$2$gestureEndAction$1$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7962g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2$gestureEndAction$1$1(Function0<Unit> function0) {
        super(1);
        this.f7962g = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        Function0<Unit> function0 = this.f7962g;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
