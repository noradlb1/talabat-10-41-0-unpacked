package yi;

import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModel f58045b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f58046c;

    public /* synthetic */ t(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, List list) {
        this.f58045b = subcategoriesFragmentViewModel;
        this.f58046c = list;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModel.m9876lambda10$lambda9(this.f58045b, this.f58046c, (Vendor) obj);
    }
}
