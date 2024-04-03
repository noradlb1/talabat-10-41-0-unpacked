package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class InfiniteTransition$run$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ InfiniteTransition f1335g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1336h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfiniteTransition$run$2(InfiniteTransition infiniteTransition, int i11) {
        super(2);
        this.f1335g = infiniteTransition;
        this.f1336h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f1335g.run$animation_core_release(composer, this.f1336h | 1);
    }
}
