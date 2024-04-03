package androidx.compose.ui.input.rotary;

import androidx.compose.ui.input.focus.FocusDirectedInputEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "e", "Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;", "invoke", "(Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class RotaryInputModifierKt$focusAwareCallback$1 extends Lambda implements Function1<FocusDirectedInputEvent, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<RotaryScrollEvent, Boolean> f9838g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RotaryInputModifierKt$focusAwareCallback$1(Function1<? super RotaryScrollEvent, Boolean> function1) {
        super(1);
        this.f9838g = function1;
    }

    @NotNull
    public final Boolean invoke(@NotNull FocusDirectedInputEvent focusDirectedInputEvent) {
        Intrinsics.checkNotNullParameter(focusDirectedInputEvent, "e");
        if (focusDirectedInputEvent instanceof RotaryScrollEvent) {
            return this.f9838g.invoke(focusDirectedInputEvent);
        }
        throw new IllegalStateException("FocusAwareEvent is dispatched to the wrong FocusAwareParent.".toString());
    }
}
