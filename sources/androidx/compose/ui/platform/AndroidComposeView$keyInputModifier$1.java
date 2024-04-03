package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView$keyInputModifier$1 extends Lambda implements Function1<KeyEvent, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9980g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$keyInputModifier$1(AndroidComposeView androidComposeView) {
        super(1);
        this.f9980g = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m4810invokeZmokQxo(((KeyEvent) obj).m4172unboximpl());
    }

    @NotNull
    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m4810invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "it");
        FocusDirection r02 = this.f9980g.m4804getFocusDirectionP8AzH3I(keyEvent);
        if (r02 == null || !KeyEventType.m4176equalsimpl0(KeyEvent_androidKt.m4184getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4180getKeyDownCS__XNY())) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(this.f9980g.getFocusManager().m2618moveFocus3ESFkO8(r02.m2603unboximpl()));
    }
}
