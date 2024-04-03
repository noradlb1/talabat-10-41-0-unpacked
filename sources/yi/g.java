package yi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragment f58032a;

    public /* synthetic */ g(SubcategoriesFragment subcategoriesFragment) {
        this.f58032a = subcategoriesFragment;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragment.m9869observeData$lambda3(this.f58032a, (Result) obj);
    }
}
