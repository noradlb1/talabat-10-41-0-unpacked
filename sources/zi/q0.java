package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesListController;
import java.util.concurrent.Callable;

public final /* synthetic */ class q0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesListController f58105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58106c;

    public /* synthetic */ q0(SubcategoriesListController subcategoriesListController, int i11) {
        this.f58105b = subcategoriesListController;
        this.f58106c = i11;
    }

    public final Object call() {
        return SubcategoriesListController.m9925getHeadlineIndexToSelect$lambda0(this.f58105b, this.f58106c);
    }
}
