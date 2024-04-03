package androidx.navigation;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$NavControllerNavigatorState$pop$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavController.NavControllerNavigatorState f36305g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36306h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f36307i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$NavControllerNavigatorState$pop$1(NavController.NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z11) {
        super(0);
        this.f36305g = navControllerNavigatorState;
        this.f36306h = navBackStackEntry;
        this.f36307i = z11;
    }

    public final void invoke() {
        NavController$NavControllerNavigatorState$pop$1.super.pop(this.f36306h, this.f36307i);
    }
}
