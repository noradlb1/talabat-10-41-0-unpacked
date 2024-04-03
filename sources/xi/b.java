package xi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categories.CategoriesFragment;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CategoriesFragment f57987a;

    public /* synthetic */ b(CategoriesFragment categoriesFragment) {
        this.f57987a = categoriesFragment;
    }

    public final void onChanged(Object obj) {
        CategoriesFragment.m9855observeNavigationActions$lambda5(this.f57987a, (EventWrapper) obj);
    }
}
