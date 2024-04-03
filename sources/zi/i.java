package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58084a;

    public /* synthetic */ i(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58084a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9894onViewCreated$lambda9(this.f58084a, (Result) obj);
    }
}
