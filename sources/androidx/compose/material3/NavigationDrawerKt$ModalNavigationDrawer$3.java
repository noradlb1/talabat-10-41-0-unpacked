package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$ModalNavigationDrawer$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7500g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7501h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DrawerState f7502i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7503j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f7504k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7505l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7506m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7507n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$ModalNavigationDrawer$3(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z11, long j11, Function2<? super Composer, ? super Integer, Unit> function22, int i11, int i12) {
        super(2);
        this.f7500g = function2;
        this.f7501h = modifier;
        this.f7502i = drawerState;
        this.f7503j = z11;
        this.f7504k = j11;
        this.f7505l = function22;
        this.f7506m = i11;
        this.f7507n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.m1766ModalNavigationDrawerFHprtrg(this.f7500g, this.f7501h, this.f7502i, this.f7503j, this.f7504k, this.f7505l, composer, this.f7506m | 1, this.f7507n);
    }
}
