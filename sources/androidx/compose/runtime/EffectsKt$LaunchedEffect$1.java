package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class EffectsKt$LaunchedEffect$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f9118g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9119h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EffectsKt$LaunchedEffect$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, int i11) {
        super(2);
        this.f9118g = function2;
        this.f9119h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        EffectsKt.LaunchedEffect(this.f9118g, composer, this.f9119h | 1);
    }
}
