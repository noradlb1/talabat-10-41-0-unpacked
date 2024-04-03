package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorPainter$RenderVector$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Composition f9730g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorPainter$RenderVector$2(Composition composition) {
        super(1);
        this.f9730g = composition;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new VectorPainter$RenderVector$2$invoke$$inlined$onDispose$1(this.f9730g);
    }
}
