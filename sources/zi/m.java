package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58093b;

    public /* synthetic */ m(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58093b = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9923subscribeTopLevelCategories$lambda32(this.f58093b, (Observable) obj);
    }
}
