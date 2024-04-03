package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/SelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SelectionManager$handleDragObserver$1 implements TextDragObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3718a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3719b;

    public SelectionManager$handleDragObserver$1(SelectionManager selectionManager, boolean z11) {
        this.f3718a = selectionManager;
        this.f3719b = z11;
    }

    public void onCancel() {
        this.f3718a.showSelectionToolbar$foundation_release();
        this.f3718a.setDraggingHandle((Handle) null);
        this.f3718a.m1000setCurrentDragPosition_kEHs6E((Offset) null);
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1016onDownk4lQ0M(long j11) {
        Selection.AnchorInfo anchorInfo;
        LayoutCoordinates layoutCoordinates;
        Handle handle;
        Selection selection = this.f3718a.getSelection();
        if (selection != null) {
            if (this.f3719b) {
                anchorInfo = selection.getStart();
            } else {
                anchorInfo = selection.getEnd();
            }
            Selectable anchorSelectable$foundation_release = this.f3718a.getAnchorSelectable$foundation_release(anchorInfo);
            if (anchorSelectable$foundation_release != null && (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) != null) {
                long r42 = SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(anchorSelectable$foundation_release.m961getHandlePositiondBAh8RU(selection, this.f3719b));
                SelectionManager selectionManager = this.f3718a;
                selectionManager.m1000setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(selectionManager.requireContainerCoordinates$foundation_release().m4474localPositionOfR5De75A(layoutCoordinates, r42)));
                SelectionManager selectionManager2 = this.f3718a;
                if (this.f3719b) {
                    handle = Handle.SelectionStart;
                } else {
                    handle = Handle.SelectionEnd;
                }
                selectionManager2.setDraggingHandle(handle);
            }
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1017onDragk4lQ0M(long j11) {
        SelectionManager selectionManager = this.f3718a;
        selectionManager.m1002setDragTotalDistancek4lQ0M(Offset.m2681plusMKHz9U(selectionManager.m1009getDragTotalDistanceF1C5BW0$foundation_release(), j11));
        long r62 = Offset.m2681plusMKHz9U(this.f3718a.m1008getDragBeginPositionF1C5BW0$foundation_release(), this.f3718a.m1009getDragTotalDistanceF1C5BW0$foundation_release());
        if (this.f3718a.m1013updateSelectionRHHTvR4$foundation_release(Offset.m2665boximpl(r62), Offset.m2665boximpl(this.f3718a.m1008getDragBeginPositionF1C5BW0$foundation_release()), this.f3719b, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
            this.f3718a.m1001setDragBeginPositionk4lQ0M(r62);
            this.f3718a.m1002setDragTotalDistancek4lQ0M(Offset.Companion.m2692getZeroF1C5BW0());
        }
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1018onStartk4lQ0M(long j11) {
        long j12;
        this.f3718a.hideSelectionToolbar$foundation_release();
        Selection selection = this.f3718a.getSelection();
        Intrinsics.checkNotNull(selection);
        Selectable selectable = this.f3718a.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
        Selectable selectable2 = this.f3718a.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
        LayoutCoordinates layoutCoordinates = null;
        if (this.f3719b) {
            if (selectable != null) {
                layoutCoordinates = selectable.getLayoutCoordinates();
            }
            Intrinsics.checkNotNull(layoutCoordinates);
        } else {
            if (selectable2 != null) {
                layoutCoordinates = selectable2.getLayoutCoordinates();
            }
            Intrinsics.checkNotNull(layoutCoordinates);
        }
        if (this.f3719b) {
            Intrinsics.checkNotNull(selectable);
            j12 = selectable.m961getHandlePositiondBAh8RU(selection, true);
        } else {
            Intrinsics.checkNotNull(selectable2);
            j12 = selectable2.m961getHandlePositiondBAh8RU(selection, false);
        }
        long r42 = SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(j12);
        SelectionManager selectionManager = this.f3718a;
        selectionManager.m1001setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().m4474localPositionOfR5De75A(layoutCoordinates, r42));
        this.f3718a.m1002setDragTotalDistancek4lQ0M(Offset.Companion.m2692getZeroF1C5BW0());
    }

    public void onStop() {
        this.f3718a.showSelectionToolbar$foundation_release();
        this.f3718a.setDraggingHandle((Handle) null);
        this.f3718a.m1000setCurrentDragPosition_kEHs6E((Offset) null);
    }

    public void onUp() {
        this.f3718a.setDraggingHandle((Handle) null);
        this.f3718a.m1000setCurrentDragPosition_kEHs6E((Offset) null);
    }
}
