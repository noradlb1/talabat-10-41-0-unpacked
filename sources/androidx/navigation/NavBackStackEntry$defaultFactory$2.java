package androidx.navigation;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateViewModelFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntry$defaultFactory$2 extends Lambda implements Function0<SavedStateViewModelFactory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36301g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry$defaultFactory$2(NavBackStackEntry navBackStackEntry) {
        super(0);
        this.f36301g = navBackStackEntry;
    }

    @NotNull
    public final SavedStateViewModelFactory invoke() {
        Context access$getContext$p = this.f36301g.context;
        Application application = null;
        Context applicationContext = access$getContext$p != null ? access$getContext$p.getApplicationContext() : null;
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        }
        NavBackStackEntry navBackStackEntry = this.f36301g;
        return new SavedStateViewModelFactory(application, navBackStackEntry, navBackStackEntry.getArguments());
    }
}
