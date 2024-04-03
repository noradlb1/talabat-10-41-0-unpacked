package cj;

import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewFragmentViewModel f50958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50959c;

    public /* synthetic */ h(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel, String str) {
        this.f50958b = categoriesOverviewFragmentViewModel;
        this.f50959c = str;
    }

    public final Object apply(Object obj) {
        return CategoriesOverviewFragmentViewModel.m9941loadCategories$lambda6(this.f50958b, this.f50959c, (Long) obj);
    }
}
