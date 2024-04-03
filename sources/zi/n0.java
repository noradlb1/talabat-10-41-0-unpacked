package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public final /* synthetic */ class n0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Single f58097c;

    public /* synthetic */ n0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Single single) {
        this.f58096b = subcategoriesFragmentViewModelNew;
        this.f58097c = single;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9917subscribeSelectedShelfItemSubject$lambda16(this.f58096b, this.f58097c, (Optional) obj);
    }
}
