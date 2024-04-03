package hu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.filters.FiltersFragment;
import java.util.List;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f62145a;

    public /* synthetic */ a(FiltersFragment filtersFragment) {
        this.f62145a = filtersFragment;
    }

    public final void onChanged(Object obj) {
        FiltersFragment.m10819observeSortsList$lambda3(this.f62145a, (List) obj);
    }
}
