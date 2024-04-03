package androidx.compose.ui.window;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$7 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f10378g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$7(PopupLayout popupLayout) {
        super(1);
        this.f10378g = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "childCoordinates");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(parentLayoutCoordinates);
        this.f10378g.updateParentLayoutCoordinates(parentLayoutCoordinates);
    }
}
