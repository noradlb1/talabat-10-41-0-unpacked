package androidx.navigation;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/navigation/NavBackStackEntry;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8 extends Lambda implements Function0<NavBackStackEntry> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f36350g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f36351h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(Fragment fragment, String str) {
        super(0);
        this.f36350g = fragment;
        this.f36351h = str;
    }

    @NotNull
    public final NavBackStackEntry invoke() {
        return FragmentKt.findNavController(this.f36350g).getBackStackEntry(this.f36351h);
    }
}
