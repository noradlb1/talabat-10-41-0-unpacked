package yi;

import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Single f58034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModel f58035c;

    public /* synthetic */ i(Single single, SubcategoriesFragmentViewModel subcategoriesFragmentViewModel) {
        this.f58034b = single;
        this.f58035c = subcategoriesFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModel.m9873_init_$lambda2(this.f58034b, this.f58035c, obj);
    }
}
