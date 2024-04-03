package zi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.Function;

public final /* synthetic */ class u implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58111b;

    public /* synthetic */ u(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58111b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9896getProductsForShelfView$lambda38(this.f58111b, (SubcategorySwimalnesResponse) obj);
    }
}
