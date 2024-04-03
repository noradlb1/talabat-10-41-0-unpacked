package yi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragment;
import java.util.Map;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragment f58033a;

    public /* synthetic */ h(SubcategoriesFragment subcategoriesFragment) {
        this.f58033a = subcategoriesFragment;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragment.m9870observeData$lambda4(this.f58033a, (Map) obj);
    }
}
