package mj;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.talabat.darkstores.feature.search.SearchFragment;

public final /* synthetic */ class g implements NavController.OnDestinationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f57035a;

    public /* synthetic */ g(SearchFragment searchFragment) {
        this.f57035a = searchFragment;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        SearchFragment.m10060createDestinationListener$lambda2(this.f57035a, navController, navDestination, bundle);
    }
}
