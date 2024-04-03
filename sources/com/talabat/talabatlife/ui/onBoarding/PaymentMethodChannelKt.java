package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0005"}, d2 = {"toPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "", "", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PaymentMethodChannelKt {
    @NotNull
    public static final PaymentInfoDisplayModel toPaymentDisplayModel(@NotNull Map<String, ? extends Object> map) {
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "<this>");
        Object obj = map2.get(TLifeNavigationActions.EXTRA_PLAN);
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            Object obj2 = hashMap.get(BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
            if (obj2 != null) {
                String str = (String) obj2;
                Object obj3 = hashMap.get("nextBillingText");
                if (obj3 != null) {
                    String str2 = (String) obj3;
                    String str3 = (String) hashMap.get("freeTrialTitle");
                    Object obj4 = hashMap.get("freeTrialDays");
                    if (obj4 != null) {
                        int intValue = ((Integer) obj4).intValue();
                        Object obj5 = hashMap.get("subscriptionPaymentDate");
                        if (obj5 != null) {
                            String str4 = (String) obj5;
                            Object obj6 = hashMap.get("actionText");
                            if (obj6 != null) {
                                String str5 = (String) obj6;
                                Object obj7 = hashMap.get("planAmount");
                                if (obj7 != null) {
                                    float doubleValue = (float) ((Double) obj7).doubleValue();
                                    Object obj8 = hashMap.get("nextBillingSubText");
                                    if (obj8 != null) {
                                        return new PaymentInfoDisplayModel(str, str2, str3, intValue, false, str4, str5, doubleValue, WalletBottomSheetPaymentMode.CARDDETAIL, (String) null, (String) null, (WalletPaymentFeature) null, (String) obj8, true, (String) null, 0.0f, (String) null, 118288, (DefaultConstructorMarker) null);
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }
}
