package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntryProviderKt$LocalOwnersProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36386g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolder f36387h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f36388i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f36389j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntryProviderKt$LocalOwnersProvider$2(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f36386g = navBackStackEntry;
        this.f36387h = saveableStateHolder;
        this.f36388i = function2;
        this.f36389j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavBackStackEntryProviderKt.LocalOwnersProvider(this.f36386g, this.f36387h, this.f36388i, composer, this.f36389j | 1);
    }
}
