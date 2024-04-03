package yi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class r implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModel f58043b;

    public /* synthetic */ r(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel) {
        this.f58043b = subcategoriesFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModel.m9879lambda2$lambda0(this.f58043b, (SubcategorySwimalnesResponse) obj);
    }
}
