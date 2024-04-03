package zi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.Function;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58110b;

    public /* synthetic */ t(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58110b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9895getProducts$lambda33(this.f58110b, (SubcategorySwimalnesResponse) obj);
    }
}
