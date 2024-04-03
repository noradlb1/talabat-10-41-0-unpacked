package cs;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.talabat.home.HomeScreenActivity;

public final /* synthetic */ class g implements NavController.OnDestinationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f61805a;

    public /* synthetic */ g(HomeScreenActivity homeScreenActivity) {
        this.f61805a = homeScreenActivity;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        HomeScreenActivity.m10637addFragment$lambda16$lambda11(this.f61805a, navController, navDestination, bundle);
    }
}
