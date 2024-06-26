package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"androidx/navigation/ui/NavigationUI$setupWithNavController$7", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationUI$setupWithNavController$7 implements NavController.OnDestinationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference<NavigationView> f36444a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavController f36445b;

    public NavigationUI$setupWithNavController$7(WeakReference<NavigationView> weakReference, NavController navController) {
        this.f36444a = weakReference;
        this.f36445b = navController;
    }

    public void onDestinationChanged(@NotNull NavController navController, @NotNull NavDestination navDestination, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        NavigationView navigationView = this.f36444a.get();
        if (navigationView == null) {
            this.f36445b.removeOnDestinationChangedListener(this);
            return;
        }
        Menu menu = navigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "view.menu");
        int size = menu.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = menu.getItem(i11);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            item.setChecked(NavigationUI.matchDestination$navigation_ui_release(navDestination, item.getItemId()));
        }
    }
}
