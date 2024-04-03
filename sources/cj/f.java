package cj;

import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewFragmentViewModel;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewFragmentViewModel f50956b;

    public /* synthetic */ f(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel) {
        this.f50956b = categoriesOverviewFragmentViewModel;
    }

    public final boolean test(Object obj) {
        return CategoriesOverviewFragmentViewModel.m9939createSearchCategoryObservable$lambda0(this.f50956b, (String) obj);
    }
}
