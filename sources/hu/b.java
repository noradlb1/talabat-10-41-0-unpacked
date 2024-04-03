package hu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.filters.FiltersFragment;
import java.util.List;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f62146a;

    public /* synthetic */ b(FiltersFragment filtersFragment) {
        this.f62146a = filtersFragment;
    }

    public final void onChanged(Object obj) {
        FiltersFragment.m10818observeFiltersList$lambda4(this.f62146a, (List) obj);
    }
}
