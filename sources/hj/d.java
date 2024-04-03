package hj;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;

public final /* synthetic */ class d implements NavController.OnDestinationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56877a;

    public /* synthetic */ d(DarkstoresMainActivity darkstoresMainActivity) {
        this.f56877a = darkstoresMainActivity;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        DarkstoresMainActivity.m9996setupBottomCartView$lambda26(this.f56877a, navController, navDestination, bundle);
    }
}
