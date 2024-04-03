package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateHandle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntry$savedStateHandle$2 extends Lambda implements Function0<SavedStateHandle> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36302g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$savedStateHandle$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.f36302g = navBackStackEntry;
    }

    @NotNull
    public final SavedStateHandle invoke() {
        if (this.f36302g.savedStateRegistryAttached) {
            if (this.f36302g.lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                NavBackStackEntry navBackStackEntry = this.f36302g;
                return ((NavBackStackEntry.SavedStateViewModel) new ViewModelProvider((ViewModelStoreOwner) navBackStackEntry, (ViewModelProvider.Factory) new NavBackStackEntry.NavResultSavedStateFactory(navBackStackEntry)).get(NavBackStackEntry.SavedStateViewModel.class)).getHandle();
            }
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }
}
