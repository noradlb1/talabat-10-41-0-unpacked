package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;
import java.util.Map;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58082a;

    public /* synthetic */ h(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58082a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9893onViewCreated$lambda7(this.f58082a, (Map) obj);
    }
}
