package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f9015g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5(PopupLayout popupLayout) {
        super(1);
        this.f9015g = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "childCoordinates");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(parentLayoutCoordinates);
        long r02 = parentLayoutCoordinates.m4473getSizeYbymL2g();
        long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
        this.f9015g.setParentBounds(IntRectKt.m5628IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m2676getXimpl(positionInWindow)), MathKt__MathJVMKt.roundToInt(Offset.m2677getYimpl(positionInWindow))), r02));
        this.f9015g.updatePosition();
    }
}
