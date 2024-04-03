package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58079a;

    public /* synthetic */ f(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58079a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9891onViewCreated$lambda4(this.f58079a, (Result) obj);
    }
}
