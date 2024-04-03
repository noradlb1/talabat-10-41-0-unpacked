package yi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragment f58031a;

    public /* synthetic */ f(SubcategoriesFragment subcategoriesFragment) {
        this.f58031a = subcategoriesFragment;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragment.m9868observeData$lambda1(this.f58031a, (Integer) obj);
    }
}
