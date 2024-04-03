package androidx.compose.ui.platform;

import androidx.compose.ui.input.InputMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/InputMode;", "invoke-iuPiT84", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView$_inputModeManager$1 extends Lambda implements Function1<InputMode, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9976g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$_inputModeManager$1(AndroidComposeView androidComposeView) {
        super(1);
        this.f9976g = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m4809invokeiuPiT84(((InputMode) obj).m3577unboximpl());
    }

    @NotNull
    /* renamed from: invoke-iuPiT84  reason: not valid java name */
    public final Boolean m4809invokeiuPiT84(int i11) {
        boolean z11;
        InputMode.Companion companion = InputMode.Companion;
        if (InputMode.m3574equalsimpl0(i11, companion.m3579getTouchaOaMEAU())) {
            z11 = this.f9976g.isInTouchMode();
        } else if (!InputMode.m3574equalsimpl0(i11, companion.m3578getKeyboardaOaMEAU())) {
            z11 = false;
        } else if (this.f9976g.isInTouchMode()) {
            z11 = this.f9976g.requestFocusFromTouch();
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }
}
