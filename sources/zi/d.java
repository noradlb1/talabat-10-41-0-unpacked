package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;
import kotlin.Unit;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58075a;

    public /* synthetic */ d(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58075a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9885observeBasketLifetimeTooltip$lambda18(this.f58075a, (Unit) obj);
    }
}
