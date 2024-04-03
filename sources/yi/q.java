package yi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModel f58042b;

    public /* synthetic */ q(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel) {
        this.f58042b = subcategoriesFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModel.m9882lambda8$lambda7(this.f58042b, (SubcategorySwimalnesResponse) obj);
    }
}
