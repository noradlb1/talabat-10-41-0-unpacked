package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R%\u0010\u0002\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R%\u0010\t\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/text/TextController$update$1", "Landroidx/compose/foundation/text/TextDragObserver;", "dragTotalDistance", "Landroidx/compose/ui/geometry/Offset;", "getDragTotalDistance", "()J", "setDragTotalDistance", "(J)V", "J", "lastPosition", "getLastPosition", "setLastPosition", "onCancel", "", "onDown", "point", "onDown-k-4lQ0M", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextController$update$1 implements TextDragObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextController f3545a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectionRegistrar f3546b;
    private long dragTotalDistance;
    private long lastPosition;

    public TextController$update$1(TextController textController, SelectionRegistrar selectionRegistrar) {
        this.f3545a = textController;
        this.f3546b = selectionRegistrar;
        Offset.Companion companion = Offset.Companion;
        this.lastPosition = companion.m2692getZeroF1C5BW0();
        this.dragTotalDistance = companion.m2692getZeroF1C5BW0();
    }

    public final long getDragTotalDistance() {
        return this.dragTotalDistance;
    }

    public final long getLastPosition() {
        return this.lastPosition;
    }

    public void onCancel() {
        if (SelectionRegistrarKt.hasSelection(this.f3546b, this.f3545a.getState().getSelectableId())) {
            this.f3546b.notifySelectionUpdateEnd();
        }
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m892onDownk4lQ0M(long j11) {
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m893onDragk4lQ0M(long j11) {
        LayoutCoordinates layoutCoordinates = this.f3545a.getState().getLayoutCoordinates();
        if (layoutCoordinates != null) {
            SelectionRegistrar selectionRegistrar = this.f3546b;
            TextController textController = this.f3545a;
            if (layoutCoordinates.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar, textController.getState().getSelectableId())) {
                long r102 = Offset.m2681plusMKHz9U(this.dragTotalDistance, j11);
                this.dragTotalDistance = r102;
                long r103 = Offset.m2681plusMKHz9U(this.lastPosition, r102);
                if (!textController.m890outOfBoundary0a9Yr6o(this.lastPosition, r103)) {
                    if (selectionRegistrar.m1035notifySelectionUpdate5iVPX68(layoutCoordinates, r103, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                        this.lastPosition = r103;
                        this.dragTotalDistance = Offset.Companion.m2692getZeroF1C5BW0();
                    }
                }
            }
        }
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m894onStartk4lQ0M(long j11) {
        LayoutCoordinates layoutCoordinates = this.f3545a.getState().getLayoutCoordinates();
        if (layoutCoordinates != null) {
            TextController textController = this.f3545a;
            SelectionRegistrar selectionRegistrar = this.f3546b;
            if (layoutCoordinates.isAttached()) {
                if (textController.m890outOfBoundary0a9Yr6o(j11, j11)) {
                    selectionRegistrar.notifySelectionUpdateSelectAll(textController.getState().getSelectableId());
                } else {
                    selectionRegistrar.m1036notifySelectionUpdateStartd4ec7I(layoutCoordinates, j11, SelectionAdjustment.Companion.getWord());
                }
                this.lastPosition = j11;
            } else {
                return;
            }
        }
        if (SelectionRegistrarKt.hasSelection(this.f3546b, this.f3545a.getState().getSelectableId())) {
            this.dragTotalDistance = Offset.Companion.m2692getZeroF1C5BW0();
        }
    }

    public void onStop() {
        if (SelectionRegistrarKt.hasSelection(this.f3546b, this.f3545a.getState().getSelectableId())) {
            this.f3546b.notifySelectionUpdateEnd();
        }
    }

    public void onUp() {
    }

    public final void setDragTotalDistance(long j11) {
        this.dragTotalDistance = j11;
    }

    public final void setLastPosition(long j11) {
        this.lastPosition = j11;
    }
}
