package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySaveableStateHolder$SaveableStateProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazySaveableStateHolder f3068g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f3069h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3070i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3071j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolder$SaveableStateProvider$2(LazySaveableStateHolder lazySaveableStateHolder, Object obj, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3068g = lazySaveableStateHolder;
        this.f3069h = obj;
        this.f3070i = function2;
        this.f3071j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f3068g.SaveableStateProvider(this.f3069h, this.f3070i, composer, this.f3071j | 1);
    }
}
