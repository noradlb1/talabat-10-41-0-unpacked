package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "S", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentScope$slideOutOfContainer$2 extends Lambda implements Function1<Integer, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentScope<S> f1108g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Integer> f1109h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentScope$slideOutOfContainer$2(AnimatedContentScope<S> animatedContentScope, Function1<? super Integer, Integer> function1) {
        super(1);
        this.f1108g = animatedContentScope;
        this.f1109h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Integer invoke(int i11) {
        State state = this.f1108g.getTargetSizeMap$animation_release().get(this.f1108g.getTransition$animation_release().getTargetState());
        return this.f1109h.invoke(Integer.valueOf((-IntOffset.m5596getXimpl(this.f1108g.m13calculateOffsetemnUabE(IntSizeKt.IntSize(i11, i11), state != null ? ((IntSize) state.getValue()).m5642unboximpl() : IntSize.Companion.m5643getZeroYbymL2g()))) - i11));
    }
}
