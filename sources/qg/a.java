package qg;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.core.flutter.channels.impl.data.vendorlist.InlineAdsChannelCallbackImpl;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f57190b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InlineAdsChannelCallbackImpl f57191c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f57192d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f57193e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f57194f;

    public /* synthetic */ a(List list, InlineAdsChannelCallbackImpl inlineAdsChannelCallbackImpl, Ref.IntRef intRef, List list2, MethodChannel.Result result) {
        this.f57190b = list;
        this.f57191c = inlineAdsChannelCallbackImpl;
        this.f57192d = intRef;
        this.f57193e = list2;
        this.f57194f = result;
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        InlineAdsChannelCallbackImpl.m9587handleLoadInlineAds$lambda2$lambda0(this.f57190b, this.f57191c, this.f57192d, this.f57193e, this.f57194f, nativeCustomTemplateAd);
    }
}
