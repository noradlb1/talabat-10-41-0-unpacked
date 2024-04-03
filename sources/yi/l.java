package yi;

import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class l implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModel f58038b;

    public /* synthetic */ l(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel) {
        this.f58038b = subcategoriesFragmentViewModel;
    }

    public final boolean test(Object obj) {
        return SubcategoriesFragmentViewModel.m9874_init_$lambda5(this.f58038b, (Integer) obj);
    }
}
