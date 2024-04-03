package yi;

import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Single f58039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModel f58040c;

    public /* synthetic */ m(Single single, SubcategoriesFragmentViewModel subcategoriesFragmentViewModel) {
        this.f58039b = single;
        this.f58040c = subcategoriesFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModel.m9875_init_$lambda8(this.f58039b, this.f58040c, (Integer) obj);
    }
}
