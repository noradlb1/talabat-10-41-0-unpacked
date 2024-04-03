package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$pointerModifier$1 extends Lambda implements Function1<Offset, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3456g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FocusRequester f3457h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f3458i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3459j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ OffsetMapping f3460k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$pointerModifier$1(TextFieldState textFieldState, FocusRequester focusRequester, boolean z11, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping) {
        super(1);
        this.f3456g = textFieldState;
        this.f3457h = focusRequester;
        this.f3458i = z11;
        this.f3459j = textFieldSelectionManager;
        this.f3460k = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m842invokek4lQ0M(((Offset) obj).m2686unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m842invokek4lQ0M(long j11) {
        boolean z11 = true;
        CoreTextFieldKt.tapToFocus(this.f3456g, this.f3457h, !this.f3458i);
        if (!this.f3456g.getHasFocus()) {
            return;
        }
        if (this.f3456g.getHandleState() != HandleState.Selection) {
            TextLayoutResultProxy layoutResult = this.f3456g.getLayoutResult();
            if (layoutResult != null) {
                TextFieldState textFieldState = this.f3456g;
                long j12 = j11;
                TextFieldDelegate.Companion.m911setCursorOffsetULxng0E$foundation_release(j12, layoutResult, textFieldState.getProcessor(), this.f3460k, textFieldState.getOnValueChange());
                if (textFieldState.getTextDelegate().getText().length() <= 0) {
                    z11 = false;
                }
                if (z11) {
                    textFieldState.setHandleState(HandleState.Cursor);
                    return;
                }
                return;
            }
            return;
        }
        this.f3459j.m1048deselect_kEHs6E$foundation_release(Offset.m2665boximpl(j11));
    }
}
