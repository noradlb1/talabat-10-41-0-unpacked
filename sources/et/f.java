package et;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.restaurants.inlineads.RxAdLoader;
import com.talabat.restaurants.inlineads.data.Ad;
import io.reactivex.functions.Function;
import library.talabat.inlineadsengine.AdsWrapper;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdsWrapper f62006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ad f62007c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RxAdLoader f62008d;

    public /* synthetic */ f(AdsWrapper adsWrapper, Ad ad2, RxAdLoader rxAdLoader) {
        this.f62006b = adsWrapper;
        this.f62007c = ad2;
        this.f62008d = rxAdLoader;
    }

    public final Object apply(Object obj) {
        return RxAdLoader.m10722loadFromDFP$lambda5(this.f62006b, this.f62007c, this.f62008d, (NativeCustomTemplateAd) obj);
    }
}
