package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58080a;

    public /* synthetic */ g(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58080a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9892onViewCreated$lambda6(this.f58080a, (Result) obj);
    }
}
