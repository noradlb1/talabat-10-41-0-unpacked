package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
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
public final class HoverableKt$hoverable$2$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<HoverInteraction.Enter> f1682g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1683h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HoverableKt$hoverable$2$1$1(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f1682g = mutableState;
        this.f1683h = mutableInteractionSource;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new HoverableKt$hoverable$2$1$1$invoke$$inlined$onDispose$1(this.f1682g, this.f1683h);
    }
}
