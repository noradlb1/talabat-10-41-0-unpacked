package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$popBackStackInternal$2 extends Lambda implements Function1<NavBackStackEntry, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f36316g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f36317h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NavController f36318i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f36319j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayDeque<NavBackStackEntryState> f36320k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$popBackStackInternal$2(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, NavController navController, boolean z11, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        super(1);
        this.f36316g = booleanRef;
        this.f36317h = booleanRef2;
        this.f36318i = navController;
        this.f36319j = z11;
        this.f36320k = arrayDeque;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        this.f36316g.element = true;
        this.f36317h.element = true;
        this.f36318i.popEntryFromBackStack(navBackStackEntry, this.f36319j, this.f36320k);
    }
}
