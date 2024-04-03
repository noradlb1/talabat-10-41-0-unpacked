package androidx.compose.ui.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutKt$SubcomposeLayout$5$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<SubcomposeLayoutState> f9886g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutKt$SubcomposeLayout$5$1(State<SubcomposeLayoutState> state) {
        super(1);
        this.f9886g = state;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new SubcomposeLayoutKt$SubcomposeLayout$5$1$invoke$$inlined$onDispose$1(this.f9886g);
    }
}
