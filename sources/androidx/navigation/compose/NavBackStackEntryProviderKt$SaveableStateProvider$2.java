package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntryProviderKt$SaveableStateProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolder f36391g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f36392h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f36393i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntryProviderKt$SaveableStateProvider$2(SaveableStateHolder saveableStateHolder, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f36391g = saveableStateHolder;
        this.f36392h = function2;
        this.f36393i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavBackStackEntryProviderKt.SaveableStateProvider(this.f36391g, this.f36392h, composer, this.f36393i | 1);
    }
}
