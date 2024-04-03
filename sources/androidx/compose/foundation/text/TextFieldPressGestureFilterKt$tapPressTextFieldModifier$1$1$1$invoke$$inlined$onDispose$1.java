package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MutableState f3582a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3583b;

    public TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1$invoke$$inlined$onDispose$1(MutableState mutableState, MutableInteractionSource mutableInteractionSource) {
        this.f3582a = mutableState;
        this.f3583b = mutableInteractionSource;
    }

    public void dispose() {
        PressInteraction.Press press = (PressInteraction.Press) this.f3582a.getValue();
        if (press != null) {
            PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
            MutableInteractionSource mutableInteractionSource = this.f3583b;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(cancel);
            }
            this.f3582a.setValue(null);
        }
    }
}
