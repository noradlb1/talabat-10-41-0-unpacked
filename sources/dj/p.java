package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.home.HomeFragment;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class p implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56752a;

    public /* synthetic */ p(HomeFragment homeFragment) {
        this.f56752a = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m9950observeNavigationActions$lambda25(this.f56752a, (EventWrapper) obj);
    }
}
