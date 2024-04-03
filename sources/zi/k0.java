package zi;

import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class k0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58089b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f58090c;

    public /* synthetic */ k0(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, List list) {
        this.f58089b = subcategoriesFragmentViewModelNew;
        this.f58090c = list;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9897getProductsForShelfView$lambda38$lambda37(this.f58089b, this.f58090c, (Optional) obj);
    }
}
