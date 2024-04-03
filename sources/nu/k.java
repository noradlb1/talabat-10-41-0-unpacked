package nu;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.sdsquad.ui.vendorslist.VendorsListFragment;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.Ad;

public final /* synthetic */ class k implements NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f62381b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ad f62382c;

    public /* synthetic */ k(VendorsListFragment vendorsListFragment, Ad ad2) {
        this.f62381b = vendorsListFragment;
        this.f62382c = ad2;
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        VendorsListFragment.m10862observeInLineAds$lambda11$lambda9(this.f62381b, this.f62382c, nativeCustomTemplateAd);
    }
}
