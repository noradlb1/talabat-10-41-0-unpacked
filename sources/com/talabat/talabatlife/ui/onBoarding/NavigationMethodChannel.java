package com.talabat.talabatlife.ui.onBoarding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/NavigationMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "handleNavigation", "", "arguments", "", "", "", "navigateToTDineOfferDetailsScreen", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DATA = "data";
    @NotNull
    private static final String NAVIGATE_TO_NATIVE_METHOD_CALL = "navigateToNative";
    @NotNull
    private static final String SCREENNAME = "screenName";
    @NotNull
    private static final String TDINE_OFFER_DETAILS = "tDineOfferDetails";
    @NotNull
    private final Activity activity;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/NavigationMethodChannel$Companion;", "", "()V", "DATA", "", "NAVIGATE_TO_NATIVE_METHOD_CALL", "SCREENNAME", "TDINE_OFFER_DETAILS", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NavigationMethodChannel(@NotNull Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    private final void handleNavigation(Map<String, ? extends Object> map) {
        if (map.containsKey("screenName")) {
            Object obj = map.get("screenName");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else if (Intrinsics.areEqual((Object) (String) obj, (Object) "tDineOfferDetails")) {
                navigateToTDineOfferDetailsScreen(map);
            }
        }
    }

    private final void navigateToTDineOfferDetailsScreen(Map<String, ? extends Object> map) {
        Object obj = map.get("data");
        if (obj != null) {
            Map map2 = (Map) obj;
            Integer num = (Integer) map2.get("vendorId");
            String str = (String) map2.get(BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
            String str2 = (String) map2.get("planTitle");
            Double d11 = (Double) map2.get("planAmount");
            String str3 = (String) map2.get("actionText");
            String str4 = (String) map2.get("freeTrialTitle");
            Boolean bool = (Boolean) map2.get("freeTrialEligible");
            String str5 = (String) map2.get("onBoardingTitle");
            String str6 = (String) map2.get("onBoardingSubTitle");
            String str7 = (String) map2.get("nextBillingText");
            String str8 = (String) map2.get("subscriptionPaymentDate");
            if (str == null) {
                str = "";
            }
            String str9 = str;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else if (str8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else if (d11 != null) {
                float doubleValue = (float) d11.doubleValue();
                if (str6 != null) {
                    PaymentInfoDisplayModel paymentInfoDisplayModel = new PaymentInfoDisplayModel(str9, str2, str4, 0, false, str8, str3, doubleValue, WalletBottomSheetPaymentMode.CARDDETAIL, (String) null, (String) null, (WalletPaymentFeature) null, str6, true, (String) null, 0.0f, (String) null, 118288, (DefaultConstructorMarker) null);
                    if (num != null) {
                        int intValue = num.intValue();
                        Bundle bundle = new Bundle();
                        bundle.putString("vendorID", String.valueOf(intValue));
                        bundle.putParcelable(TLifeNavigationActions.EXTRA_PLAN, paymentInfoDisplayModel);
                        Navigator.Companion.navigate((Context) this.activity, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDOR_OFFERS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "navigateToNative")) {
            Object obj = methodCall.arguments;
            LogManager.debug("navigateToNative" + obj);
            Object obj2 = methodCall.arguments;
            if (obj2 != null) {
                handleNavigation((Map) obj2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
        LogManager.debug("Not Implemented");
    }
}
