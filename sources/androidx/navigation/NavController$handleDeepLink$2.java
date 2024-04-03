package androidx.navigation;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$handleDeepLink$2 extends Lambda implements Function1<NavOptionsBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavDestination f36308g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavController f36309h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.f36308g = navDestination;
        this.f36309h = navController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavOptionsBuilder navOptionsBuilder) {
        boolean z11;
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
        navOptionsBuilder.anim(AnonymousClass1.INSTANCE);
        NavDestination navDestination = this.f36308g;
        boolean z12 = false;
        if (navDestination instanceof NavGraph) {
            Sequence<NavDestination> hierarchy = NavDestination.Companion.getHierarchy(navDestination);
            NavController navController = this.f36309h;
            Iterator<NavDestination> it = hierarchy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = true;
                    break;
                }
                NavDestination next = it.next();
                NavDestination currentDestination = navController.getCurrentDestination();
                if (Intrinsics.areEqual((Object) next, (Object) currentDestination != null ? currentDestination.getParent() : null)) {
                    z11 = false;
                    break;
                }
            }
            if (z11) {
                z12 = true;
            }
        }
        if (z12 && NavController.deepLinkSaveState) {
            navOptionsBuilder.popUpTo(NavGraph.Companion.findStartDestination(this.f36309h.getGraph()).getId(), (Function1<? super PopUpToBuilder, Unit>) AnonymousClass2.INSTANCE);
        }
    }
}
