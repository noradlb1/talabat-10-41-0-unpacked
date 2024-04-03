package ku;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchFragment f62227a;

    public /* synthetic */ c(GlobalSearchFragment globalSearchFragment) {
        this.f62227a = globalSearchFragment;
    }

    public final void onChanged(Object obj) {
        GlobalSearchFragment.m10833onActivityCreated$lambda2(this.f62227a, (Boolean) obj);
    }
}
