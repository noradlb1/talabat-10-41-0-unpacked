package ku;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchFragment f62226a;

    public /* synthetic */ b(GlobalSearchFragment globalSearchFragment) {
        this.f62226a = globalSearchFragment;
    }

    public final void onChanged(Object obj) {
        GlobalSearchFragment.m10832onActivityCreated$lambda1(this.f62226a, (Boolean) obj);
    }
}
