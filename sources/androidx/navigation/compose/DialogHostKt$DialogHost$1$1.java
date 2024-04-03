package androidx.navigation.compose;

import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt$DialogHost$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DialogNavigator f36365g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36366h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogHostKt$DialogHost$1$1(DialogNavigator dialogNavigator, NavBackStackEntry navBackStackEntry) {
        super(0);
        this.f36365g = dialogNavigator;
        this.f36366h = navBackStackEntry;
    }

    public final void invoke() {
        this.f36365g.dismiss$navigation_compose_release(this.f36366h);
    }
}
