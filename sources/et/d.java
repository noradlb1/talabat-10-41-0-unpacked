package et;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.restaurants.inlineads.RxAdLoader;
import io.reactivex.SingleEmitter;

public final /* synthetic */ class d implements NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f62005b;

    public /* synthetic */ d(SingleEmitter singleEmitter) {
        this.f62005b = singleEmitter;
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        RxAdLoader.m10725loadNativeCustomTemplateAd$lambda9$lambda7(this.f62005b, nativeCustomTemplateAd);
    }
}
