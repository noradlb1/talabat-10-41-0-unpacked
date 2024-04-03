package com.talabat.feature.bnplcheckout.presentation.channel;

import androidx.core.app.NotificationCompat;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.bnplcheckout.presentation.CardInfo;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/bnplcheckout/presentation/channel/BNPLCheckoutMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "callback", "Lcom/talabat/feature/bnplcheckout/presentation/channel/BNPLCheckoutChannelCallback;", "planId", "", "orderAmount", "(Lcom/talabat/feature/bnplcheckout/presentation/channel/BNPLCheckoutChannelCallback;Ljava/lang/String;Ljava/lang/String;)V", "getFormattedExpiryDate", "expiryDate", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLCheckoutMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    @Deprecated
    private static final String BACK_NAVIGATION = "backNavigation";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String GET_ESTIMATE_INSTALLMENTS_REQUEST = "getEstimateInstallmentsRequest";
    @NotNull
    @Deprecated
    private static final String IS_CHANGE_CARD_CLICKED = "isChangeCardClicked";
    @NotNull
    @Deprecated
    private static final String OPEN_TERMS_AND_CONDITIONS = "openTermsAndConditions";
    @NotNull
    @Deprecated
    private static final String PLACE_BNPL_ORDER = "placeBnplOrder";
    @NotNull
    private final BNPLCheckoutChannelCallback callback;
    @Nullable
    private final String orderAmount;
    @Nullable
    private final String planId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/bnplcheckout/presentation/channel/BNPLCheckoutMethodCallHandler$Companion;", "", "()V", "BACK_NAVIGATION", "", "GET_ESTIMATE_INSTALLMENTS_REQUEST", "IS_CHANGE_CARD_CLICKED", "OPEN_TERMS_AND_CONDITIONS", "PLACE_BNPL_ORDER", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public BNPLCheckoutMethodCallHandler(@NotNull BNPLCheckoutChannelCallback bNPLCheckoutChannelCallback, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(bNPLCheckoutChannelCallback, "callback");
        this.callback = bNPLCheckoutChannelCallback;
        this.planId = str;
        this.orderAmount = str2;
    }

    private final String getFormattedExpiryDate(String str) {
        try {
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy", locale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/yyyy", locale);
            if (str == null) {
                str = "";
            }
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            String format = simpleDateFormat2.format(parse);
            Intrinsics.checkNotNullExpressionValue(format, "{\n            val actual…t(actualDate!!)\n        }");
            return format;
        } catch (Exception unused) {
            return StringUtils.empty(StringCompanionObject.INSTANCE);
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str5 = methodCall.method;
        if (str5 != null) {
            switch (str5.hashCode()) {
                case -529689705:
                    if (str5.equals(GET_ESTIMATE_INSTALLMENTS_REQUEST)) {
                        result.success(MapsKt__MapsKt.mapOf(TuplesKt.to(BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA, this.planId), TuplesKt.to(TalabatCommonUrlConstantsKt.ORDER_AMOUNT_PATH, this.orderAmount)));
                        return;
                    }
                    return;
                case -240241061:
                    if (str5.equals(BACK_NAVIGATION)) {
                        this.callback.closeBottomSheet();
                        return;
                    }
                    return;
                case 235088799:
                    if (str5.equals(PLACE_BNPL_ORDER)) {
                        String str6 = (String) methodCall.argument("cardTokenId");
                        String str7 = (String) methodCall.argument("expiryDate");
                        String str8 = (String) methodCall.argument("cardNetwork");
                        String str9 = (String) methodCall.argument("binNumber");
                        String str10 = (String) methodCall.argument("last4Digits");
                        if (str6 == null) {
                            str = "";
                        } else {
                            str = str6;
                        }
                        String formattedExpiryDate = getFormattedExpiryDate(str7);
                        if (str8 == null) {
                            str2 = "";
                        } else {
                            str2 = str8;
                        }
                        if (str9 == null) {
                            str3 = "";
                        } else {
                            str3 = str9;
                        }
                        if (str10 == null) {
                            str4 = "";
                        } else {
                            str4 = str10;
                        }
                        this.callback.placeOrder(new CardInfo(str, formattedExpiryDate, str2, str3, str4));
                        return;
                    }
                    return;
                case 973106461:
                    if (str5.equals("isChangeCardClicked")) {
                        result.success(Boolean.valueOf(this.callback.isChangeCardClicked()));
                        return;
                    }
                    return;
                case 1579280786:
                    if (str5.equals(OPEN_TERMS_AND_CONDITIONS)) {
                        this.callback.openTermsAndConditionsScreen();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
