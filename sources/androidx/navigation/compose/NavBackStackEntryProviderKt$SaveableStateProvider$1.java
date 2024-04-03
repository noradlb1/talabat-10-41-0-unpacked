package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntryProviderKt$SaveableStateProvider$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BackStackEntryIdViewModel f36390g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntryProviderKt$SaveableStateProvider$1(BackStackEntryIdViewModel backStackEntryIdViewModel) {
        super(1);
        this.f36390g = backStackEntryIdViewModel;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new NavBackStackEntryProviderKt$SaveableStateProvider$1$invoke$$inlined$onDispose$1(this.f36390g);
    }
}
