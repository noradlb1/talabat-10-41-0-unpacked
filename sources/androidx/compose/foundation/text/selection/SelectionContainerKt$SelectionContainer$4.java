package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt$SelectionContainer$4 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3685g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$SelectionContainer$4(SelectionManager selectionManager) {
        super(1);
        this.f3685g = selectionManager;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1(this.f3685g);
    }
}
