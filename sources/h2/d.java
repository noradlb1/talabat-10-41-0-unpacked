package h2;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;

public final /* synthetic */ class d implements NavigationView.OnNavigationItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavController f44333a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavigationView f44334b;

    public /* synthetic */ d(NavController navController, NavigationView navigationView) {
        this.f44333a = navController;
        this.f44334b = navigationView;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m9118setupWithNavController$lambda3(this.f44333a, this.f44334b, menuItem);
    }
}
