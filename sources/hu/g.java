package hu;

import com.talabat.sdsquad.ui.filters.FiltersViewModel;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterSortWrapper;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f62150b;

    public /* synthetic */ g(FiltersViewModel filtersViewModel) {
        this.f62150b = filtersViewModel;
    }

    public final void accept(Object obj) {
        FiltersViewModel.m10824getSortAndFilters$lambda5(this.f62150b, (FilterSortWrapper) obj);
    }
}
