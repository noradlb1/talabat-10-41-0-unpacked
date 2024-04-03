package vs;

import com.google.android.material.appbar.AppBarLayout;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class a implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62969a;

    public /* synthetic */ a(OfferCollectionActivity offerCollectionActivity) {
        this.f62969a = offerCollectionActivity;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        OfferCollectionActivity.m10683configureToolbarAndStatusBar$lambda12(this.f62969a, appBarLayout, i11);
    }
}
