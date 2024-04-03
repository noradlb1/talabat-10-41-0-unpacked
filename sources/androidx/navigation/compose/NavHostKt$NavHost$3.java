package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt$NavHost$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavHostController f36411g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$3(NavHostController navHostController) {
        super(1);
        this.f36411g = navHostController;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f36411g.enableOnBackPressed(true);
        return new NavHostKt$NavHost$3$invoke$$inlined$onDispose$1(this.f36411g);
    }
}
