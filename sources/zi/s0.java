package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesListController;
import io.reactivex.functions.Function;

public final /* synthetic */ class s0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesListController f58109b;

    public /* synthetic */ s0(SubcategoriesListController subcategoriesListController) {
        this.f58109b = subcategoriesListController;
    }

    public final Object apply(Object obj) {
        return this.f58109b.getHeadlineIndexToSelect(((Integer) obj).intValue());
    }
}
