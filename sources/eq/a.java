package eq;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.flutter.channels.InlineAdsMethodCallHandler;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f61993b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InlineAdsMethodCallHandler f61994c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f61995d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f61996e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61997f;

    public /* synthetic */ a(List list, InlineAdsMethodCallHandler inlineAdsMethodCallHandler, Ref.IntRef intRef, List list2, MethodChannel.Result result) {
        this.f61993b = list;
        this.f61994c = inlineAdsMethodCallHandler;
        this.f61995d = intRef;
        this.f61996e = list2;
        this.f61997f = result;
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        InlineAdsMethodCallHandler.m10467handleLoadInlineAds$lambda2$lambda0(this.f61993b, this.f61994c, this.f61995d, this.f61996e, this.f61997f, nativeCustomTemplateAd);
    }
}
