package zi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.BiFunction;

public final /* synthetic */ class g0 implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58081b;

    public /* synthetic */ g0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58081b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj, Object obj2) {
        return SubcategoriesFragmentViewModelNew.m9922subscribeSelectedShelfItemSubject$lambda30(this.f58081b, (String) obj, (SubcategorySwimalnesResponse) obj2);
    }
}
