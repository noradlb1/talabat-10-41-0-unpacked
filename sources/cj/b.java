package cj;

import android.view.View;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewBottomSheet;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewBottomSheet f50952b;

    public /* synthetic */ b(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet) {
        this.f50952b = categoriesOverviewBottomSheet;
    }

    public final void onFocusChange(View view, boolean z11) {
        CategoriesOverviewBottomSheet.m9938setupSearchView$lambda5$lambda4(this.f50952b, view, z11);
    }
}
