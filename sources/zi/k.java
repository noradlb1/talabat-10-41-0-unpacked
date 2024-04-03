package zi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f58088a;

    public /* synthetic */ k(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        this.f58088a = subcategoriesFragmentNew;
    }

    public final void onChanged(Object obj) {
        SubcategoriesFragmentNew.m9889onViewCreated$lambda14(this.f58088a, (Result) obj);
    }
}
