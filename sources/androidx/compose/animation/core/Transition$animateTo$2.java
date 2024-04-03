package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class Transition$animateTo$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1408g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ S f1409h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1410i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transition$animateTo$2(Transition<S> transition, S s11, int i11) {
        super(2);
        this.f1408g = transition;
        this.f1409h = s11;
        this.f1410i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f1408g.animateTo$animation_core_release(this.f1409h, composer, this.f1410i | 1);
    }
}
