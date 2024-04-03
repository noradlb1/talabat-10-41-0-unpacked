package dj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.home.HomeFragment;

public final /* synthetic */ class q implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56753a;

    public /* synthetic */ q(HomeFragment homeFragment) {
        this.f56753a = homeFragment;
    }

    public final void onChanged(Object obj) {
        this.f56753a.onCartReady((Result) obj);
    }
}
