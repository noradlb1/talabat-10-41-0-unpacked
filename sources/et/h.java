package et;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.talabat.restaurants.inlineads.RxAdLoader;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class h implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdLoader.Builder f62009a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdManagerAdRequest f62010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RxAdLoader f62011c;

    public /* synthetic */ h(AdLoader.Builder builder, AdManagerAdRequest adManagerAdRequest, RxAdLoader rxAdLoader) {
        this.f62009a = builder;
        this.f62010b = adManagerAdRequest;
        this.f62011c = rxAdLoader;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        RxAdLoader.m10724loadNativeCustomTemplateAd$lambda9(this.f62009a, this.f62010b, this.f62011c, singleEmitter);
    }
}
