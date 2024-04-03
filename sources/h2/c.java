package h2;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationBarView;

public final /* synthetic */ class c implements NavigationBarView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavController f44332a;

    public /* synthetic */ c(NavController navController) {
        this.f44332a = navController;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m9120setupWithNavController$lambda6(this.f44332a, menuItem);
    }
}
