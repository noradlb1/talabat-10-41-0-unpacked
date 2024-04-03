package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
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
public final class DraggableKt$draggable$9$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<DragInteraction.Start> f2082g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f2083h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$9$1$1(MutableState<DragInteraction.Start> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.f2082g = mutableState;
        this.f2083h = mutableInteractionSource;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new DraggableKt$draggable$9$1$1$invoke$$inlined$onDispose$1(this.f2082g, this.f2083h);
    }
}
