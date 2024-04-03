package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManager$handleDragObserver$1 implements TextDragObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3745b;

    public TextFieldSelectionManager$handleDragObserver$1(TextFieldSelectionManager textFieldSelectionManager, boolean z11) {
        this.f3744a = textFieldSelectionManager;
        this.f3745b = z11;
    }

    public void onCancel() {
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1055onDownk4lQ0M(long j11) {
        Handle handle;
        TextFieldSelectionManager textFieldSelectionManager = this.f3744a;
        if (this.f3745b) {
            handle = Handle.SelectionStart;
        } else {
            handle = Handle.SelectionEnd;
        }
        textFieldSelectionManager.setDraggingHandle(handle);
        TextFieldSelectionManager textFieldSelectionManager2 = this.f3744a;
        textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager2.m1051getHandlePositiontuRUvjQ$foundation_release(this.f3745b))));
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1056onDragk4lQ0M(long j11) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int i11;
        int i12;
        TextFieldSelectionManager textFieldSelectionManager = this.f3744a;
        textFieldSelectionManager.dragTotalDistance = Offset.m2681plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j11);
        TextFieldState state$foundation_release = this.f3744a.getState$foundation_release();
        if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
            TextFieldSelectionManager textFieldSelectionManager2 = this.f3744a;
            boolean z11 = this.f3745b;
            textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(Offset.m2681plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
            if (z11) {
                Offset r92 = textFieldSelectionManager2.m1049getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r92);
                i11 = value.m5013getOffsetForPositionk4lQ0M(r92.m2686unboximpl());
            } else {
                i11 = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5038getStartimpl(textFieldSelectionManager2.getValue$foundation_release().m5234getSelectiond9O1mEE()));
            }
            int i13 = i11;
            if (z11) {
                i12 = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5033getEndimpl(textFieldSelectionManager2.getValue$foundation_release().m5234getSelectiond9O1mEE()));
            } else {
                Offset r93 = textFieldSelectionManager2.m1049getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r93);
                i12 = value.m5013getOffsetForPositionk4lQ0M(r93.m2686unboximpl());
            }
            textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i13, i12, z11, SelectionAdjustment.Companion.getCharacter());
        }
        TextFieldState state$foundation_release2 = this.f3744a.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowFloatingToolbar(false);
        }
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1057onStartk4lQ0M(long j11) {
        Handle handle;
        TextFieldSelectionManager textFieldSelectionManager = this.f3744a;
        textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1051getHandlePositiontuRUvjQ$foundation_release(this.f3745b));
        TextFieldSelectionManager textFieldSelectionManager2 = this.f3744a;
        textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(textFieldSelectionManager2.dragBeginPosition));
        this.f3744a.dragTotalDistance = Offset.Companion.m2692getZeroF1C5BW0();
        TextFieldSelectionManager textFieldSelectionManager3 = this.f3744a;
        if (this.f3745b) {
            handle = Handle.SelectionStart;
        } else {
            handle = Handle.SelectionEnd;
        }
        textFieldSelectionManager3.setDraggingHandle(handle);
        TextFieldState state$foundation_release = this.f3744a.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(false);
        }
    }

    public void onStop() {
        TextToolbarStatus textToolbarStatus = null;
        this.f3744a.setDraggingHandle((Handle) null);
        this.f3744a.m1046setCurrentDragPosition_kEHs6E((Offset) null);
        TextFieldState state$foundation_release = this.f3744a.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.f3744a.getTextToolbar();
        if (textToolbar != null) {
            textToolbarStatus = textToolbar.getStatus();
        }
        if (textToolbarStatus == TextToolbarStatus.Hidden) {
            this.f3744a.showSelectionToolbar$foundation_release();
        }
    }

    public void onUp() {
        this.f3744a.setDraggingHandle((Handle) null);
        this.f3744a.m1046setCurrentDragPosition_kEHs6E((Offset) null);
    }
}
