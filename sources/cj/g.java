package cj;

import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewFragmentViewModel f50957b;

    public /* synthetic */ g(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel) {
        this.f50957b = categoriesOverviewFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CategoriesOverviewFragmentViewModel.m9940createSearchCategoryObservable$lambda1(this.f50957b, (String) obj);
    }
}
