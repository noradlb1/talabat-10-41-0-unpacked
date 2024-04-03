package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$ModalDrawer$1$2$3$1 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4470g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f4471h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DrawerState f4472i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$1$2$3$1(float f11, float f12, DrawerState drawerState) {
        super(0);
        this.f4470g = f11;
        this.f4471h = f12;
        this.f4472i = drawerState;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(DrawerKt.calculateFraction(this.f4470g, this.f4471h, this.f4472i.getOffset().getValue().floatValue()));
    }
}
