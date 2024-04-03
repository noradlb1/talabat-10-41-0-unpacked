package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "S", "it", "invoke-YEO4UFw", "(Ljava/lang/Object;)J"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentScope$SizeModifier$measure$size$2 extends Lambda implements Function1<S, IntSize> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentScope<S> f1099g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentScope$SizeModifier$measure$size$2(AnimatedContentScope<S> animatedContentScope) {
        super(1);
        this.f1099g = animatedContentScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m5630boximpl(m26invokeYEO4UFw(obj));
    }

    /* renamed from: invoke-YEO4UFw  reason: not valid java name */
    public final long m26invokeYEO4UFw(S s11) {
        State state = this.f1099g.getTargetSizeMap$animation_release().get(s11);
        return state != null ? ((IntSize) state.getValue()).m5642unboximpl() : IntSize.Companion.m5643getZeroYbymL2g();
    }
}
