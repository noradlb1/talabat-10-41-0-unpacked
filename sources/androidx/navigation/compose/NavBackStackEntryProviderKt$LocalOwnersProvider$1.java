package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntryProviderKt$LocalOwnersProvider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolder f36383g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f36384h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f36385i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntryProviderKt$LocalOwnersProvider$1(SaveableStateHolder saveableStateHolder, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f36383g = saveableStateHolder;
        this.f36384h = function2;
        this.f36385i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            NavBackStackEntryProviderKt.SaveableStateProvider(this.f36383g, this.f36384h, composer, ((this.f36385i >> 3) & 112) | 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
