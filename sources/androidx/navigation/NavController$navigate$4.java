package androidx.navigation;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$navigate$4 extends Lambda implements Function1<NavBackStackEntry, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f36311g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavController f36312h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NavDestination f36313i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Bundle f36314j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$navigate$4(Ref.BooleanRef booleanRef, NavController navController, NavDestination navDestination, Bundle bundle) {
        super(1);
        this.f36311g = booleanRef;
        this.f36312h = navController;
        this.f36313i = navDestination;
        this.f36314j = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        this.f36311g.element = true;
        NavController.b(this.f36312h, this.f36313i, this.f36314j, navBackStackEntry, (List) null, 8, (Object) null);
    }
}
