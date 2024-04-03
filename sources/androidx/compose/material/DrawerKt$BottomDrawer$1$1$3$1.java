package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$BottomDrawer$1$1$3$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f4420g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$1$1$3$1(MutableState<Float> mutableState) {
        super(1);
        this.f4420g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "position");
        DrawerKt$BottomDrawer$1.m1235invoke$lambda2(this.f4420g, (float) IntSize.m5637getHeightimpl(layoutCoordinates.m4473getSizeYbymL2g()));
    }
}
