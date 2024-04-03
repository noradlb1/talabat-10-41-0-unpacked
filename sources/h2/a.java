package h2;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;

public final /* synthetic */ class a implements NavigationView.OnNavigationItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavController f44327a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f44328b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NavigationView f44329c;

    public /* synthetic */ a(NavController navController, boolean z11, NavigationView navigationView) {
        this.f44327a = navController;
        this.f44328b = z11;
        this.f44329c = navigationView;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m9119setupWithNavController$lambda5(this.f44327a, this.f44328b, this.f44329c, menuItem);
    }
}
