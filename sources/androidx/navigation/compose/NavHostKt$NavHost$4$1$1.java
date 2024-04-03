package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt$NavHost$4$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f36416g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<List<NavBackStackEntry>> f36417h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ComposeNavigator f36418i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$4$1$1(MutableState<Boolean> mutableState, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator) {
        super(1);
        this.f36416g = mutableState;
        this.f36417h = state;
        this.f36418i = composeNavigator;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        if (NavHostKt.m9109NavHost$lambda7(this.f36416g)) {
            ComposeNavigator composeNavigator = this.f36418i;
            for (NavBackStackEntry onTransitionComplete$navigation_compose_release : NavHostKt.m9108NavHost$lambda5(this.f36417h)) {
                composeNavigator.onTransitionComplete$navigation_compose_release(onTransitionComplete$navigation_compose_release);
            }
            NavHostKt.m9110NavHost$lambda8(this.f36416g, false);
        }
        return new NavHostKt$NavHost$4$1$1$invoke$$inlined$onDispose$1(this.f36417h, this.f36418i);
    }
}
