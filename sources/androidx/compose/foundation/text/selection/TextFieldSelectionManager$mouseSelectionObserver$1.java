package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$mouseSelectionObserver$1", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "onDrag", "", "dragPosition", "Landroidx/compose/ui/geometry/Offset;", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSelectionManager$mouseSelectionObserver$1 implements MouseSelectionObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3746a;

    public TextFieldSelectionManager$mouseSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.f3746a = textFieldSelectionManager;
    }

    /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
    public boolean m1058onDrag3MmeM6k(long j11, @NotNull SelectionAdjustment selectionAdjustment) {
        boolean z11;
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (this.f3746a.getValue$foundation_release().getText().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || (state$foundation_release = this.f3746a.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.f3746a;
        int r62 = layoutResult.m934getOffsetForPosition3MmeM6k(j11, false);
        TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
        Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager.dragBeginOffsetInText;
        Intrinsics.checkNotNull(access$getDragBeginOffsetInText$p);
        textFieldSelectionManager.updateSelection(value$foundation_release, access$getDragBeginOffsetInText$p.intValue(), r62, false, selectionAdjustment);
        return true;
    }

    /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
    public boolean m1059onExtendk4lQ0M(long j11) {
        TextLayoutResultProxy layoutResult;
        TextFieldState state$foundation_release = this.f3746a.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.f3746a;
        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
        textFieldSelectionManager2.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5038getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE())), TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(layoutResult, j11, false, 2, (Object) null), false, SelectionAdjustment.Companion.getNone());
        return true;
    }

    /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
    public boolean m1060onExtendDragk4lQ0M(long j11) {
        boolean z11;
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult;
        if (this.f3746a.getValue$foundation_release().getText().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || (state$foundation_release = this.f3746a.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.f3746a;
        textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5038getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5234getSelectiond9O1mEE())), layoutResult.m934getOffsetForPosition3MmeM6k(j11, false), false, SelectionAdjustment.Companion.getNone());
        return true;
    }

    /* renamed from: onStart-3MmeM6k  reason: not valid java name */
    public boolean m1061onStart3MmeM6k(long j11, @NotNull SelectionAdjustment selectionAdjustment) {
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        FocusRequester focusRequester = this.f3746a.getFocusRequester();
        if (focusRequester != null) {
            focusRequester.requestFocus();
        }
        this.f3746a.dragBeginPosition = j11;
        TextFieldState state$foundation_release = this.f3746a.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.f3746a;
        TextLayoutResultProxy textLayoutResultProxy = layoutResult;
        textFieldSelectionManager.dragBeginOffsetInText = Integer.valueOf(TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, j11, false, 2, (Object) null));
        int r42 = TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, textFieldSelectionManager.dragBeginPosition, false, 2, (Object) null);
        textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), r42, r42, false, selectionAdjustment);
        return true;
    }
}
