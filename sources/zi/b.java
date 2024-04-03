package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58071a;

    public /* synthetic */ b(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58071a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9886observeNavigationActions$lambda17(this.f58071a, (EventWrapper) obj);
    }
}
