package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$touchSelectionObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManager$touchSelectionObserver$1 implements TextDragObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3751a;

    public TextFieldSelectionManager$touchSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.f3751a = textFieldSelectionManager;
    }

    public void onCancel() {
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1062onDownk4lQ0M(long j11) {
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1063onDragk4lQ0M(long j11) {
        boolean z11;
        TextLayoutResultProxy layoutResult;
        int i11;
        if (this.f3751a.getValue$foundation_release().getText().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            TextFieldSelectionManager textFieldSelectionManager = this.f3751a;
            textFieldSelectionManager.dragTotalDistance = Offset.m2681plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j11);
            TextFieldState state$foundation_release = this.f3751a.getState$foundation_release();
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                TextFieldSelectionManager textFieldSelectionManager2 = this.f3751a;
                textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(Offset.m2681plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager2.dragBeginOffsetInText;
                if (access$getDragBeginOffsetInText$p != null) {
                    i11 = access$getDragBeginOffsetInText$p.intValue();
                } else {
                    i11 = layoutResult.m934getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                }
                int i12 = i11;
                Offset r102 = textFieldSelectionManager2.m1049getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r102);
                textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i12, layoutResult.m934getOffsetForPosition3MmeM6k(r102.m2686unboximpl(), false), false, SelectionAdjustment.Companion.getWord());
            }
            TextFieldState state$foundation_release2 = this.f3751a.getState$foundation_release();
            if (state$foundation_release2 != null) {
                state$foundation_release2.setShowFloatingToolbar(false);
            }
        }
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1064onStartk4lQ0M(long j11) {
        boolean z11;
        TextLayoutResultProxy layoutResult;
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult2;
        TextLayoutResultProxy layoutResult3;
        if (this.f3751a.getDraggingHandle() == null) {
            this.f3751a.setDraggingHandle(Handle.SelectionEnd);
            this.f3751a.hideSelectionToolbar$foundation_release();
            TextFieldState state$foundation_release2 = this.f3751a.getState$foundation_release();
            boolean z12 = true;
            if (state$foundation_release2 == null || (layoutResult3 = state$foundation_release2.getLayoutResult()) == null || !layoutResult3.m935isPositionOnTextk4lQ0M(j11)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11 || (state$foundation_release = this.f3751a.getState$foundation_release()) == null || (layoutResult2 = state$foundation_release.getLayoutResult()) == null) {
                if (this.f3751a.getValue$foundation_release().getText().length() != 0) {
                    z12 = false;
                }
                if (!z12) {
                    this.f3751a.enterSelectionMode$foundation_release();
                    TextFieldState state$foundation_release3 = this.f3751a.getState$foundation_release();
                    if (!(state$foundation_release3 == null || (layoutResult = state$foundation_release3.getLayoutResult()) == null)) {
                        TextFieldSelectionManager textFieldSelectionManager = this.f3751a;
                        int r12 = TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(layoutResult, j11, false, 2, (Object) null);
                        textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), r12, r12, false, SelectionAdjustment.Companion.getWord());
                        textFieldSelectionManager.dragBeginOffsetInText = Integer.valueOf(r12);
                    }
                    this.f3751a.dragBeginPosition = j11;
                    TextFieldSelectionManager textFieldSelectionManager2 = this.f3751a;
                    textFieldSelectionManager2.m1046setCurrentDragPosition_kEHs6E(Offset.m2665boximpl(textFieldSelectionManager2.dragBeginPosition));
                    this.f3751a.dragTotalDistance = Offset.Companion.m2692getZeroF1C5BW0();
                    return;
                }
                return;
            }
            TextFieldSelectionManager textFieldSelectionManager3 = this.f3751a;
            int transformedToOriginal = textFieldSelectionManager3.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.getLineEnd$default(layoutResult2, layoutResult2.getLineForVerticalPosition(Offset.m2677getYimpl(j11)), false, 2, (Object) null));
            HapticFeedback hapticFeedBack = textFieldSelectionManager3.getHapticFeedBack();
            if (hapticFeedBack != null) {
                hapticFeedBack.m3558performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3567getTextHandleMove5zf0vsI());
            }
            TextFieldValue r92 = textFieldSelectionManager3.m1044createTextFieldValueFDrldGo(textFieldSelectionManager3.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
            textFieldSelectionManager3.enterSelectionMode$foundation_release();
            textFieldSelectionManager3.getOnValueChange$foundation_release().invoke(r92);
        }
    }

    public void onStop() {
        TextToolbarStatus textToolbarStatus;
        this.f3751a.setDraggingHandle((Handle) null);
        this.f3751a.m1046setCurrentDragPosition_kEHs6E((Offset) null);
        TextFieldState state$foundation_release = this.f3751a.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.f3751a.getTextToolbar();
        if (textToolbar != null) {
            textToolbarStatus = textToolbar.getStatus();
        } else {
            textToolbarStatus = null;
        }
        if (textToolbarStatus == TextToolbarStatus.Hidden) {
            this.f3751a.showSelectionToolbar$foundation_release();
        }
        this.f3751a.dragBeginOffsetInText = null;
    }

    public void onUp() {
    }
}
