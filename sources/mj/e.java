package mj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.search.SearchFragment;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f57033a;

    public /* synthetic */ e(SearchFragment searchFragment) {
        this.f57033a = searchFragment;
    }

    public final void onChanged(Object obj) {
        SearchFragment.m10062observeNavigation$lambda5(this.f57033a, (EventWrapper) obj);
    }
}
