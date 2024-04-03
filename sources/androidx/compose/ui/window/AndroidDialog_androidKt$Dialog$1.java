package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$Dialog$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DialogWrapper f10339g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidDialog_androidKt$Dialog$1(DialogWrapper dialogWrapper) {
        super(1);
        this.f10339g = dialogWrapper;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f10339g.show();
        return new AndroidDialog_androidKt$Dialog$1$invoke$$inlined$onDispose$1(this.f10339g);
    }
}
