package zi;

import com.talabat.darkstores.data.discovery.model.TagResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.functions.Function;

public final /* synthetic */ class h0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TagResponse f58083b;

    public /* synthetic */ h0(TagResponse tagResponse) {
        this.f58083b = tagResponse;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9914mapToShelfItems$lambda56$lambda55(this.f58083b, (Optional) obj);
    }
}
