package com.talabat.core.flutter.channels.impl.data.vendorlist;

import android.app.Activity;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelCallback;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
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
import qg.a;
import qg.b;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J<\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00040\u000b0\u00042\u0016\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00040\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/vendorlist/InlineAdsChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/vendorlist/InlineAdsChannelCallback;", "()V", "getAdFlutterMap", "", "", "nativeAd", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "getAdRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "getResultFlutterMap", "", "nativeAdList", "", "getVendorIdFromDeepLink", "", "adLink", "handleLoadInlineAds", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "activity", "Landroid/app/Activity;", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdsChannelCallbackImpl implements InlineAdsChannelCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TALABAT_AD_UNIT_KEY = "/160416261/";
    @NotNull
    public static final String TEMPLATE_ID = "11765624";
    @NotNull
    public static final String VENDOR_ID_DEEPLINK_QUERY_PATH = "v";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/vendorlist/InlineAdsChannelCallbackImpl$Companion;", "", "()V", "TALABAT_AD_UNIT_KEY", "", "TEMPLATE_ID", "VENDOR_ID_DEEPLINK_QUERY_PATH", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* access modifiers changed from: private */
    /* renamed from: handleLoadInlineAds$lambda-2$lambda-0  reason: not valid java name */
    public static final void m9587handleLoadInlineAds$lambda2$lambda0(List list, InlineAdsChannelCallbackImpl inlineAdsChannelCallbackImpl, Ref.IntRef intRef, List list2, MethodChannel.Result result, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Intrinsics.checkNotNullParameter(list, "$listAds");
        Intrinsics.checkNotNullParameter(inlineAdsChannelCallbackImpl, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$counter");
        Intrinsics.checkNotNullParameter(list2, "$adUnits");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullExpressionValue(nativeCustomTemplateAd, "nativeAd");
        list.add(inlineAdsChannelCallbackImpl.getAdFlutterMap(nativeCustomTemplateAd));
        int i11 = intRef.element + 1;
        intRef.element = i11;
        if (i11 >= list2.size()) {
            result.success(inlineAdsChannelCallbackImpl.getResultFlutterMap(list));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleLoadInlineAds$lambda-2$lambda-1  reason: not valid java name */
    public static final void m9588handleLoadInlineAds$lambda2$lambda1(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
    }

    public void handleLoadInlineAds(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(activity, "activity");
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
                    new AdLoader.Builder(activity, "/160416261/" + str).forCustomTemplateAd("11765624", new a(arrayList, this, intRef, list, result), new b()).withAdListener(new InlineAdsChannelCallbackImpl$handleLoadInlineAds$1$3(intRef)).build().loadAd(getAdRequest());
                    TalabatUtils.changeLocale(activity, GlobalDataModel.SelectedLanguage);
                    arrayList2.add(Unit.INSTANCE);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }
}
