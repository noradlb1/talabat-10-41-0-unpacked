package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Single f58103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58104c;

    public /* synthetic */ q(Single single, SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58103b = single;
        this.f58104c = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9900initControl$lambda11(this.f58103b, this.f58104c, (Integer) obj);
    }
}
