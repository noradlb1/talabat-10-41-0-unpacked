package h2;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationBarView;

public final /* synthetic */ class f implements NavigationBarView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavController f44337a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f44338b;

    public /* synthetic */ f(NavController navController, boolean z11) {
        this.f44337a = navController;
        this.f44338b = z11;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m9121setupWithNavController$lambda8(this.f44337a, this.f44338b, menuItem);
    }
}
