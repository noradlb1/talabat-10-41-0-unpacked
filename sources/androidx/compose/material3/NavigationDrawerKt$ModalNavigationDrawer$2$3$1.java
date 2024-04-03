package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$ModalNavigationDrawer$2$3$1 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f7489g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f7490h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DrawerState f7491i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$ModalNavigationDrawer$2$3$1(float f11, float f12, DrawerState drawerState) {
        super(0);
        this.f7489g = f11;
        this.f7490h = f12;
        this.f7491i = drawerState;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(NavigationDrawerKt.calculateFraction(this.f7489g, this.f7490h, this.f7491i.getOffset().getValue().floatValue()));
    }
}
