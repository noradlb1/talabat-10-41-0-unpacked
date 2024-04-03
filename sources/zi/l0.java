package zi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.Function;

public final /* synthetic */ class l0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58092b;

    public /* synthetic */ l0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58092b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9898getProductsForShelfView$lambda43(this.f58092b, (SubcategorySwimalnesResponse) obj);
    }
}
