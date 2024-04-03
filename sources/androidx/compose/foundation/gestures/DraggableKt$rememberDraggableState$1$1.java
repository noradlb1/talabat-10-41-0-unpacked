package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class DraggableKt$rememberDraggableState$1$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Unit>> f2122g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$rememberDraggableState$1$1(State<? extends Function1<? super Float, Unit>> state) {
        super(1);
        this.f2122g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        this.f2122g.getValue().invoke(Float.valueOf(f11));
    }
}
