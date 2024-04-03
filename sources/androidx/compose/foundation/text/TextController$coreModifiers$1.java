package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextController$coreModifiers$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextController f3536g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextController$coreModifiers$1(TextController textController) {
        super(1);
        this.f3536g = textController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        SelectionRegistrar access$getSelectionRegistrar$p;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        this.f3536g.getState().setLayoutCoordinates(layoutCoordinates);
        if (SelectionRegistrarKt.hasSelection(this.f3536g.selectionRegistrar, this.f3536g.getState().getSelectableId())) {
            long positionInWindow = LayoutCoordinatesKt.positionInWindow(layoutCoordinates);
            if (!Offset.m2673equalsimpl0(positionInWindow, this.f3536g.getState().m938getPreviousGlobalPositionF1C5BW0()) && (access$getSelectionRegistrar$p = this.f3536g.selectionRegistrar) != null) {
                access$getSelectionRegistrar$p.notifyPositionChange(this.f3536g.getState().getSelectableId());
            }
            this.f3536g.getState().m940setPreviousGlobalPositionk4lQ0M(positionInWindow);
        }
    }
}
