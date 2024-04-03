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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$restoreStateInternal$4 extends Lambda implements Function1<NavBackStackEntry, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f36324g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<NavBackStackEntry> f36325h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f36326i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ NavController f36327j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Bundle f36328k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$restoreStateInternal$4(Ref.BooleanRef booleanRef, List<NavBackStackEntry> list, Ref.IntRef intRef, NavController navController, Bundle bundle) {
        super(1);
        this.f36324g = booleanRef;
        this.f36325h = list;
        this.f36326i = intRef;
        this.f36327j = navController;
        this.f36328k = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavBackStackEntry navBackStackEntry) {
        List<NavBackStackEntry> list;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        this.f36324g.element = true;
        int indexOf = this.f36325h.indexOf(navBackStackEntry);
        if (indexOf != -1) {
            int i11 = indexOf + 1;
            list = this.f36325h.subList(this.f36326i.element, i11);
            this.f36326i.element = i11;
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this.f36327j.addEntryToBackStack(navBackStackEntry.getDestination(), this.f36328k, navBackStackEntry, list);
    }
}
