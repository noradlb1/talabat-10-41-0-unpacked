package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58086a;

    public /* synthetic */ j(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58086a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9887onViewCreated$lambda12(this.f58086a, (Result) obj);
    }
}
