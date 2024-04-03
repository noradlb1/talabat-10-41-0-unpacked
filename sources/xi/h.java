package xi;

import com.talabat.darkstores.feature.categories.CategoriesFragmentViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesFragmentViewModel f57994b;

    public /* synthetic */ h(CategoriesFragmentViewModel categoriesFragmentViewModel) {
        this.f57994b = categoriesFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return CategoriesFragmentViewModel.m9860_init_$lambda3(this.f57994b, (Observable) obj);
    }
}
