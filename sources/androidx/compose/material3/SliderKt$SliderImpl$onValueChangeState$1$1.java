package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$SliderImpl$onValueChangeState$1$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8094g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f8095h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$onValueChangeState$1$1(float f11, Function1<? super Float, Unit> function1) {
        super(1);
        this.f8094g = f11;
        this.f8095h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        if (!(f11 == this.f8094g)) {
            this.f8095h.invoke(Float.valueOf(f11));
        }
    }
}
