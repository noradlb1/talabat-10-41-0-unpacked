package qg;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.core.flutter.channels.impl.data.vendorlist.InlineAdsChannelCallbackImpl;

public final /* synthetic */ class b implements NativeCustomTemplateAd.OnCustomClickListener {
    public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        InlineAdsChannelCallbackImpl.m9588handleLoadInlineAds$lambda2$lambda1(nativeCustomTemplateAd, str);
    }
}
