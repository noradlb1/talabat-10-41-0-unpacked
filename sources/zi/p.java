package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class p implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58101b;

    public /* synthetic */ p(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58101b = subcategoriesFragmentViewModelNew;
    }

    public final boolean test(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9908initControl$lambda8(this.f58101b, (Integer) obj);
    }
}
