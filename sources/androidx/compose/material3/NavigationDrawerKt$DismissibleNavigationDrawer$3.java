package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$DismissibleNavigationDrawer$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7456g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7457h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DrawerState f7458i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7459j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7460k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7461l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7462m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$DismissibleNavigationDrawer$3(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, int i11, int i12) {
        super(2);
        this.f7456g = function2;
        this.f7457h = modifier;
        this.f7458i = drawerState;
        this.f7459j = z11;
        this.f7460k = function22;
        this.f7461l = i11;
        this.f7462m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.DismissibleNavigationDrawer(this.f7456g, this.f7457h, this.f7458i, this.f7459j, this.f7460k, composer, this.f7461l | 1, this.f7462m);
    }
}
