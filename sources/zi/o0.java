package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class o0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58099b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f58100c;

    public /* synthetic */ o0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, List list) {
        this.f58099b = subcategoriesFragmentViewModelNew;
        this.f58100c = list;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9899getProductsForShelfView$lambda43$lambda42(this.f58099b, this.f58100c, (Optional) obj);
    }
}
