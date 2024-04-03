package com.talabat.flutter.channels;

import android.net.Uri;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import eq.a;
import eq.b;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J<\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\u00060\r0\u00062\u0016\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\u00060\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/flutter/channels/InlineAdsMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/flutter/channels/IInlineAdsMethodCallback;", "getAdFlutterMap", "", "", "nativeAd", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "getAdRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "getResultFlutterMap", "", "nativeAdList", "", "getVendorIdFromDeepLink", "", "adLink", "handleLoadInlineAds", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall", "setCallback", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdsMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String LOAD_INLINE_ADS = "loadAds";
    @NotNull
    public static final String VENDOR_ID_DEEPLINK_QUERY_PATH = "v";
    private IInlineAdsMethodCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/flutter/channels/InlineAdsMethodCallHandler$Companion;", "", "()V", "LOAD_INLINE_ADS", "", "VENDOR_ID_DEEPLINK_QUERY_PATH", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Map<String, ?> getAdFlutterMap(NativeCustomTemplateAd nativeCustomTemplateAd) {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("vendorId", Integer.valueOf(getVendorIdFromDeepLink(nativeCustomTemplateAd.getText("link").toString()))), TuplesKt.to("imageURL", nativeCustomTemplateAd.getText("imageurl").toString()), TuplesKt.to("adsLink", nativeCustomTemplateAd.getText("link").toString()));
    }

    private final AdManagerAdRequest getAdRequest() {
        int lastFavVerticalId = SharedPreferencesManager.getInstance().getLastFavVerticalId();
        AdManagerAdRequest.Builder addCustomTargeting = new AdManagerAdRequest.Builder().addCustomTargeting("area", String.valueOf(GlobalDataModel.SelectedAreaId));
        if (lastFavVerticalId != 0) {
            addCustomTargeting.addCustomTargeting(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL, String.valueOf(lastFavVerticalId));
        }
        AdManagerAdRequest build = addCustomTargeting.build();
        Intrinsics.checkNotNullExpressionValue(build, "adRequestBuilder.build()");
        return build;
    }

    private final Map<String, List<Map<String, ?>>> getResultFlutterMap(List<Map<String, ?>> list) {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("googleAds", list));
    }

    private final int getVendorIdFromDeepLink(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("v");
        if (queryParameter != null) {
            try {
                return Integer.parseInt(queryParameter);
            } catch (NumberFormatException unused) {
                LogManager.logException(new Exception("RxAdLoader can not parse adLink: " + str));
            }
        }
        return -1;
    }

    private final void handleLoadInlineAds(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            Object obj2 = ((HashMap) obj).get("adUnitIds");
            if (obj2 != null) {
                List list = (List) obj2;
                Ref.IntRef intRef = new Ref.IntRef();
                ArrayList arrayList = new ArrayList();
                Iterable<String> iterable = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (String str : iterable) {
                    IInlineAdsMethodCallback iInlineAdsMethodCallback = this.callback;
                    IInlineAdsMethodCallback iInlineAdsMethodCallback2 = null;
                    if (iInlineAdsMethodCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                        iInlineAdsMethodCallback = null;
                    }
                    new AdLoader.Builder(iInlineAdsMethodCallback.getContext(), "/160416261/" + str).forCustomTemplateAd("11765624", new a(arrayList, this, intRef, list, result), new b()).withAdListener(new InlineAdsMethodCallHandler$handleLoadInlineAds$1$3(intRef)).build().loadAd(getAdRequest());
                    IInlineAdsMethodCallback iInlineAdsMethodCallback3 = this.callback;
                    if (iInlineAdsMethodCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                    } else {
                        iInlineAdsMethodCallback2 = iInlineAdsMethodCallback3;
                    }
                    TalabatUtils.changeLocale(iInlineAdsMethodCallback2.getContext(), GlobalDataModel.SelectedLanguage);
                    arrayList2.add(Unit.INSTANCE);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLoadInlineAds$lambda-2$lambda-0  reason: not valid java name */
    public static final void m10467handleLoadInlineAds$lambda2$lambda0(List list, InlineAdsMethodCallHandler inlineAdsMethodCallHandler, Ref.IntRef intRef, List list2, MethodChannel.Result result, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Intrinsics.checkNotNullParameter(list, "$listAds");
        Intrinsics.checkNotNullParameter(inlineAdsMethodCallHandler, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$counter");
        Intrinsics.checkNotNullParameter(list2, "$adUnits");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullExpressionValue(nativeCustomTemplateAd, "nativeAd");
        list.add(inlineAdsMethodCallHandler.getAdFlutterMap(nativeCustomTemplateAd));
        int i11 = intRef.element + 1;
        intRef.element = i11;
        if (i11 >= list2.size()) {
            result.success(inlineAdsMethodCallHandler.getResultFlutterMap(list));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLoadInlineAds$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10468handleLoadInlineAds$lambda2$lambda1(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) LOAD_INLINE_ADS)) {
            handleLoadInlineAds(methodCall, result);
        }
    }

    public final void setCallback(@NotNull IInlineAdsMethodCallback iInlineAdsMethodCallback) {
        Intrinsics.checkNotNullParameter(iInlineAdsMethodCallback, "callback");
        this.callback = iInlineAdsMethodCallback;
    }
}
