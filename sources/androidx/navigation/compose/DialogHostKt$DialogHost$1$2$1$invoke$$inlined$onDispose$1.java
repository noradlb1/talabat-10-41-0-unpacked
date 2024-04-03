package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt$DialogHost$1$2$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogNavigator f36361a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36362b;

    public DialogHostKt$DialogHost$1$2$1$invoke$$inlined$onDispose$1(DialogNavigator dialogNavigator, NavBackStackEntry navBackStackEntry) {
        this.f36361a = dialogNavigator;
        this.f36362b = navBackStackEntry;
    }

    public void dispose() {
        this.f36361a.onTransitionComplete$navigation_compose_release(this.f36362b);
    }
}
