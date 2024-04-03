package cj;

import com.talabat.darkstores.data.search.model.SearchCategoryResponse;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewFragmentViewModel f50955b;

    public /* synthetic */ e(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel) {
        this.f50955b = categoriesOverviewFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CategoriesOverviewFragmentViewModel.m9942loadCategories$lambda6$lambda5(this.f50955b, (SearchCategoryResponse) obj);
    }
}
