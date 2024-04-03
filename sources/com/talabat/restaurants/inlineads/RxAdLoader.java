package com.talabat.restaurants.inlineads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.inlineads.data.Ad;
import com.talabat.restaurants.inlineads.data.InLineAdsResponse;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import et.a;
import et.b;
import et.c;
import et.d;
import et.e;
import et.f;
import et.g;
import et.h;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002J,\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0002J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\bH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/restaurants/inlineads/RxAdLoader;", "Lcom/talabat/restaurants/inlineads/IAdLoader;", "context", "Landroid/content/Context;", "repository", "Lcom/talabat/restaurants/inlineads/InlineAdsRepository;", "(Landroid/content/Context;Lcom/talabat/restaurants/inlineads/InlineAdsRepository;)V", "getAdRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "verticalId", "", "areaId", "", "getRestaurantIdFromDeepLink", "adLink", "loadAds", "Lio/reactivex/Single;", "", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "countryId", "loadAdsConfiguration", "Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "loadFromDFP", "ad", "Lcom/talabat/restaurants/inlineads/data/Ad;", "loadNativeCustomTemplateAd", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "adUnit", "adRequest", "AdRequestError", "AdRequestErrorException", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxAdLoader implements IAdLoader {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TALABAT_AD_UNIT_KEY = "/160416261/";
    @NotNull
    public static final String TEMPLATE_ID = "11765624";
    @Nullable
    private final Context context;
    @NotNull
    private final InlineAdsRepository repository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/inlineads/RxAdLoader$AdRequestError;", "", "adRequestError", "", "(I)V", "getMessage", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AdRequestError {
        private final int adRequestError;

        public AdRequestError(int i11) {
            this.adRequestError = i11;
        }

        @NotNull
        public final String getMessage() {
            int i11 = this.adRequestError;
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? "Couldn't load ad" : "Couldn't load ad. The ad request was successful, but no ad was returned due to lack of ad inventory.. Error code : 3" : "Couldn't load ad. The ad request was unsuccessful due to network connectivity. Error code : 2" : "Couldn't load ad. The ad request was invalid; for instance, the ad unit ID was incorrect. Error code : 1" : "Couldn't load ad. Something happened internally; for instance, an invalid response was received from the ad server. Error code : 0";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/restaurants/inlineads/RxAdLoader$AdRequestErrorException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "adRequestError", "Lcom/talabat/restaurants/inlineads/RxAdLoader$AdRequestError;", "(Lcom/talabat/restaurants/inlineads/RxAdLoader$AdRequestError;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AdRequestErrorException extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdRequestErrorException(@NotNull AdRequestError adRequestError) {
            super(adRequestError.getMessage());
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/restaurants/inlineads/RxAdLoader$Companion;", "", "()V", "TALABAT_AD_UNIT_KEY", "", "TEMPLATE_ID", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RxAdLoader(@Nullable Context context2, @NotNull InlineAdsRepository inlineAdsRepository) {
        Intrinsics.checkNotNullParameter(inlineAdsRepository, "repository");
        this.context = context2;
        this.repository = inlineAdsRepository;
    }

    private final AdManagerAdRequest getAdRequest(int i11, String str) {
        AdManagerAdRequest.Builder addCustomTargeting = new AdManagerAdRequest.Builder().addCustomTargeting("area", str);
        if (i11 != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i11);
            addCustomTargeting.addCustomTargeting(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL, sb2.toString());
        }
        AdManagerAdRequest build = addCustomTargeting.build();
        Intrinsics.checkNotNullExpressionValue(build, "adRequestBuilder.build()");
        return build;
    }

    private final int getRestaurantIdFromDeepLink(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("v");
        if (queryParameter != null) {
            try {
                return Integer.parseInt(queryParameter);
            } catch (Exception unused) {
                LogManager.logException(new Exception("RxAdLoader can not parse adLink: " + str));
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAds$lambda-0  reason: not valid java name */
    public static final List m10719loadAds$lambda0(InLineAdsResponse inLineAdsResponse) {
        Intrinsics.checkNotNullParameter(inLineAdsResponse, "it");
        ArrayList<Ad> ads = inLineAdsResponse.getAds();
        if (ads != null) {
            return ads;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAds$lambda-2  reason: not valid java name */
    public static final List m10720loadAds$lambda2(RxAdLoader rxAdLoader, int i11, String str, List list) {
        Intrinsics.checkNotNullParameter(rxAdLoader, "this$0");
        Intrinsics.checkNotNullParameter(str, "$areaId");
        Intrinsics.checkNotNullParameter(list, "adsList");
        Iterable<Ad> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Ad loadFromDFP : iterable) {
            arrayList.add(rxAdLoader.loadFromDFP(loadFromDFP, i11, str));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAds$lambda-4  reason: not valid java name */
    public static final List m10721loadAds$lambda4(List list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((AdsWrapper) next).getNativeCustomTemplateAd() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final Single<InLineAdsResponse> loadAdsConfiguration(int i11) {
        return this.repository.getInlineAds(i11);
    }

    private final AdsWrapper loadFromDFP(Ad ad2, int i11, String str) {
        R blockingGet = loadNativeCustomTemplateAd(ad2.getAdUnit(), getAdRequest(i11, str)).map(new f(new AdsWrapper(), ad2, this)).onErrorReturn(new g()).blockingGet();
        Intrinsics.checkNotNullExpressionValue(blockingGet, "loadNativeCustomTemplate…           .blockingGet()");
        return (AdsWrapper) blockingGet;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFromDFP$lambda-5  reason: not valid java name */
    public static final AdsWrapper m10722loadFromDFP$lambda5(AdsWrapper adsWrapper, Ad ad2, RxAdLoader rxAdLoader, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Intrinsics.checkNotNullParameter(adsWrapper, "$adsWrapper");
        Intrinsics.checkNotNullParameter(ad2, "$ad");
        Intrinsics.checkNotNullParameter(rxAdLoader, "this$0");
        Intrinsics.checkNotNullParameter(nativeCustomTemplateAd, "nativeCustomAd");
        adsWrapper.setAdsImage(nativeCustomTemplateAd.getText("imageurl").toString());
        adsWrapper.setAdsLink(nativeCustomTemplateAd.getText("link").toString());
        adsWrapper.setNativeCustomTemplateAd(nativeCustomTemplateAd);
        adsWrapper.setAdsPosition(ad2.getPosition());
        adsWrapper.setVendorId(rxAdLoader.getRestaurantIdFromDeepLink(adsWrapper.getAdsLink()));
        return adsWrapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFromDFP$lambda-6  reason: not valid java name */
    public static final AdsWrapper m10723loadFromDFP$lambda6(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        LogManager.logException(th2);
        return new AdsWrapper();
    }

    private final Single<NativeCustomTemplateAd> loadNativeCustomTemplateAd(String str, AdManagerAdRequest adManagerAdRequest) {
        Context context2 = this.context;
        Single<NativeCustomTemplateAd> create = Single.create(new h(new AdLoader.Builder(context2, "/160416261/" + str), adManagerAdRequest, this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …lectedLanguage)\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadNativeCustomTemplateAd$lambda-9  reason: not valid java name */
    public static final void m10724loadNativeCustomTemplateAd$lambda9(AdLoader.Builder builder, AdManagerAdRequest adManagerAdRequest, RxAdLoader rxAdLoader, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(builder, "$adLoader");
        Intrinsics.checkNotNullParameter(adManagerAdRequest, "$adRequest");
        Intrinsics.checkNotNullParameter(rxAdLoader, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        builder.forCustomTemplateAd("11765624", new d(singleEmitter), new e()).withAdListener(new RxAdLoader$loadNativeCustomTemplateAd$1$3(singleEmitter)).build().loadAd(adManagerAdRequest);
        TalabatUtils.changeLocale(rxAdLoader.context, GlobalDataModel.SelectedLanguage);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadNativeCustomTemplateAd$lambda-9$lambda-7  reason: not valid java name */
    public static final void m10725loadNativeCustomTemplateAd$lambda9$lambda7(SingleEmitter singleEmitter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Intrinsics.checkNotNullParameter(singleEmitter, "$emitter");
        singleEmitter.onSuccess(nativeCustomTemplateAd);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadNativeCustomTemplateAd$lambda-9$lambda-8  reason: not valid java name */
    public static final void m10726loadNativeCustomTemplateAd$lambda9$lambda8(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
    }

    @NotNull
    public Single<List<AdsWrapper>> loadAds(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "areaId");
        Single<R> map = loadAdsConfiguration(i12).map(new a()).map(new b(this, i11, str)).map(new c());
        Intrinsics.checkNotNullExpressionValue(map, "loadAdsConfiguration(cou…d != null }\n            }");
        return map;
    }
}
