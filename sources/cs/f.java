package cs;

import androidx.lifecycle.Observer;
import com.talabat.home.HomeScreenActivity;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f61804a;

    public /* synthetic */ f(HomeScreenActivity homeScreenActivity) {
        this.f61804a = homeScreenActivity;
    }

    public final void onChanged(Object obj) {
        HomeScreenActivity.m10639checkCobrandedCcNotification$lambda5(this.f61804a, (Boolean) obj);
    }
}
