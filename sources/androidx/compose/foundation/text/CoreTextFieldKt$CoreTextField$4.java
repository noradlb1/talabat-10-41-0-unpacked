package androidx.compose.foundation.text;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$4 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextInputService f3367g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3368h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f3369i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ImeOptions f3370j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$4(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
        super(1);
        this.f3367g = textInputService;
        this.f3368h = textFieldState;
        this.f3369i = textFieldValue;
        this.f3370j = imeOptions;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        if (this.f3367g != null && this.f3368h.getHasFocus()) {
            TextFieldState textFieldState = this.f3368h;
            textFieldState.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(this.f3367g, this.f3369i, textFieldState.getProcessor(), this.f3370j, this.f3368h.getOnValueChange(), this.f3368h.getOnImeActionPerformed()));
        }
        return new CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1();
    }
}
