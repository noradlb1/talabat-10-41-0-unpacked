package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$cursorDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManager$cursorDragObserver$1 implements TextDragObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3743a;

    public TextFieldSelectionManager$cursorDragObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.f3743a = textFieldSelectionManager;
    }

    public void onCancel() {
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1052onDownk4lQ0M(long j11) {
        this.f3743a.setDraggingHandle(Handle.Cursor);
        TextFieldSelectionManager textFieldSelectionManager = this.f3743a;
        textFieldSelectionManager.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1051getHandlePositiontuRUvjQ$foundation_release(true))));
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1053onDragk4lQ0M(long j11) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        TextFieldSelectionManager textFieldSelectionManager = this.f3743a;
        textFieldSelectionManager.dragTotalDistance = Offset.m2681plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j11);
        TextFieldState state$foundation_release = this.f3743a.getState$foundation_release();
        if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
            TextFieldSelectionManager textFieldSelectionManager2 = this.f3743a;
            textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(Offset.m2681plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
            OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
            Offset r12 = textFieldSelectionManager2.m1049getCurrentDragPosition_m7T9E();
            Intrinsics.checkNotNull(r12);
            int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(value.m5013getOffsetForPositionk4lQ0M(r12.m2686unboximpl()));
            long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
            if (!TextRange.m5031equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().m5234getSelectiond9O1mEE())) {
                HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
                if (hapticFeedBack != null) {
                    hapticFeedBack.m3558performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3567getTextHandleMove5zf0vsI());
                }
                textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(textFieldSelectionManager2.m1044createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange));
            }
        }
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1054onStartk4lQ0M(long j11) {
        TextFieldSelectionManager textFieldSelectionManager = this.f3743a;
        textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m982getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1051getHandlePositiontuRUvjQ$foundation_release(true));
        TextFieldSelectionManager textFieldSelectionManager2 = this.f3743a;
        textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(textFieldSelectionManager2.dragBeginPosition));
        this.f3743a.dragTotalDistance = Offset.Companion.m2692getZeroF1C5BW0();
        this.f3743a.setDraggingHandle(Handle.Cursor);
    }

    public void onStop() {
        this.f3743a.setDraggingHandle((Handle) null);
        this.f3743a.m1046setCurrentDragPosition_kEHs6E((Offset) null);
    }

    public void onUp() {
        this.f3743a.setDraggingHandle((Handle) null);
        this.f3743a.m1046setCurrentDragPosition_kEHs6E((Offset) null);
    }
}
