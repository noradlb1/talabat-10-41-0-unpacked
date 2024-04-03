package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class Transition$updateTarget$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1412g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ S f1413h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1414i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transition$updateTarget$2(Transition<S> transition, S s11, int i11) {
        super(2);
        this.f1412g = transition;
        this.f1413h = s11;
        this.f1414i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f1412g.updateTarget$animation_core_release(this.f1413h, composer, this.f1414i | 1);
    }
}
