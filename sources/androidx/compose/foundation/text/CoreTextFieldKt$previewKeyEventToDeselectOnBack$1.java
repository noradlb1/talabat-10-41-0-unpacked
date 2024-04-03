package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$previewKeyEventToDeselectOnBack$1 extends Lambda implements Function1<KeyEvent, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3498g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldSelectionManager f3499h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        super(1);
        this.f3498g = textFieldState;
        this.f3499h = textFieldSelectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m843invokeZmokQxo(((KeyEvent) obj).m4172unboximpl());
    }

    @NotNull
    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m843invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        if (this.f3498g.getHandleState() != HandleState.Selection || !KeyEventHelpers_androidKt.m850cancelsTextSelectionZmokQxo(keyEvent)) {
            z11 = false;
        } else {
            z11 = true;
            TextFieldSelectionManager.m1045deselect_kEHs6E$foundation_release$default(this.f3499h, (Offset) null, 1, (Object) null);
        }
        return Boolean.valueOf(z11);
    }
}
