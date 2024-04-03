package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.key.Key;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$PressedInteractionSourceDisposableEffect$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<PressInteraction.Press> f1518g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<Key, PressInteraction.Press> f1519h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1520i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$PressedInteractionSourceDisposableEffect$1(MutableState<PressInteraction.Press> mutableState, Map<Key, PressInteraction.Press> map, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f1518g = mutableState;
        this.f1519h = map;
        this.f1520i = mutableInteractionSource;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1(this.f1518g, this.f1519h, this.f1520i);
    }
}
