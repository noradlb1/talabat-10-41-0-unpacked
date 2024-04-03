package cs;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;
import com.talabat.home.HomeScreenActivity;

public final /* synthetic */ class h implements NavigationBarView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f61806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavController f61807b;

    public /* synthetic */ h(HomeScreenActivity homeScreenActivity, NavController navController) {
        this.f61806a = homeScreenActivity;
        this.f61807b = navController;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return HomeScreenActivity.m10638addFragment$lambda16$lambda15(this.f61806a, this.f61807b, menuItem);
    }
}
