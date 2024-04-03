package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Function;

public final /* synthetic */ class e0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58078b;

    public /* synthetic */ e0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58078b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9920subscribeSelectedShelfItemSubject$lambda28(this.f58078b, (Optional) obj);
    }
}
