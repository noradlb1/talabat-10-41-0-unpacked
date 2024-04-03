package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$popBackStackInternal$4 extends Lambda implements Function1<NavDestination, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavController f36321g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$popBackStackInternal$4(NavController navController) {
        super(1);
        this.f36321g = navController;
    }

    @NotNull
    public final Boolean invoke(@NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        return Boolean.valueOf(!this.f36321g.backStackMap.containsKey(Integer.valueOf(navDestination.getId())));
    }
}
