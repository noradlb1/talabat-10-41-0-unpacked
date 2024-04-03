package ue;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.talabat.RestaurantMenuScreenR;

public final /* synthetic */ class kd implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR f57614a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollapsingToolbarLayout f57615b;

    public /* synthetic */ kd(RestaurantMenuScreenR restaurantMenuScreenR, CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f57614a = restaurantMenuScreenR;
        this.f57615b = collapsingToolbarLayout;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        this.f57614a.lambda$initVariables$2(this.f57615b, appBarLayout, i11);
    }
}
