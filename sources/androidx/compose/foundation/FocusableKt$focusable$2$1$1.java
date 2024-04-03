package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FocusableKt$focusable$2$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<FocusInteraction.Focus> f1638g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1639h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusableKt$focusable$2$1$1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f1638g = mutableState;
        this.f1639h = mutableInteractionSource;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new FocusableKt$focusable$2$1$1$invoke$$inlined$onDispose$1(this.f1638g, this.f1639h);
    }
}
