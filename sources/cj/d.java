package cj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewBottomSheet;
import com.talabat.wrapper.EventWrapper;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewBottomSheet f50954a;

    public /* synthetic */ d(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet) {
        this.f50954a = categoriesOverviewBottomSheet;
    }

    public final void onChanged(Object obj) {
        CategoriesOverviewBottomSheet.m9935observeNavigationActions$lambda3(this.f50954a, (EventWrapper) obj);
    }
}
