package zi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.Function;

public final /* synthetic */ class i0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58085b;

    public /* synthetic */ i0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58085b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9901initControl$lambda11$lambda10(this.f58085b, (SubcategorySwimalnesResponse) obj);
    }
}
