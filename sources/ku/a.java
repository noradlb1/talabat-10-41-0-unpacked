package ku;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchFragment;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchFragment f62225a;

    public /* synthetic */ a(GlobalSearchFragment globalSearchFragment) {
        this.f62225a = globalSearchFragment;
    }

    public final void onChanged(Object obj) {
        GlobalSearchFragment.m10831onActivityCreated$lambda0(this.f62225a, (List) obj);
    }
}
