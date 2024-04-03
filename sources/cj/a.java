package cj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewBottomSheet;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewBottomSheet f50951a;

    public /* synthetic */ a(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet) {
        this.f50951a = categoriesOverviewBottomSheet;
    }

    public final void onChanged(Object obj) {
        CategoriesOverviewBottomSheet.m9936observeSearchCategory$lambda7(this.f50951a, (Result) obj);
    }
}
