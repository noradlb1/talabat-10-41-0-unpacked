package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt$NavHost$dialogNavigator$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavHostController f36430g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavGraph f36431h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f36432i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f36433j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f36434k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$dialogNavigator$1(NavHostController navHostController, NavGraph navGraph, Modifier modifier, int i11, int i12) {
        super(2);
        this.f36430g = navHostController;
        this.f36431h = navGraph;
        this.f36432i = modifier;
        this.f36433j = i11;
        this.f36434k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavHostKt.NavHost(this.f36430g, this.f36431h, this.f36432i, composer, this.f36433j | 1, this.f36434k);
    }
}
