package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.home.HomeFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56737a;

    public /* synthetic */ f(HomeFragment homeFragment) {
        this.f56737a = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m9949observeData$lambda19(this.f56737a, (Result) obj);
    }
}
