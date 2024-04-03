package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollableStateKt$rememberScrollableState$1$1 extends Lambda implements Function1<Float, Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Float>> f2196g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableStateKt$rememberScrollableState$1$1(State<? extends Function1<? super Float, Float>> state) {
        super(1);
        this.f2196g = state;
    }

    @NotNull
    public final Float invoke(float f11) {
        return (Float) this.f2196g.getValue().invoke(Float.valueOf(f11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
