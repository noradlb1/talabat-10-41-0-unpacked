package zi;

import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import io.reactivex.functions.Function;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58107b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f58108c;

    public /* synthetic */ s(String str, SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f58107b = str;
        this.f58108c = subcategoriesFragmentViewModelNew;
    }

    public final Object apply(Object obj) {
        return SubcategoriesFragmentViewModelNew.m9919subscribeSelectedShelfItemSubject$lambda16$lambda15$lambda14(this.f58107b, this.f58108c, (SubcategorySwimalnesResponse) obj);
    }
}
