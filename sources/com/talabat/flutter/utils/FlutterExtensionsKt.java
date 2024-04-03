package com.talabat.flutter.utils;

import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0007"}, d2 = {"toPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "", "", "", "toPaymentStatusUpdateDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterExtensionsKt {
    @NotNull
    public static final PaymentInfoDisplayModel toPaymentDisplayModel(@NotNull Map<String, ? extends Object> map) {
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "<this>");
        WalletBottomSheetPaymentMode.Companion companion = WalletBottomSheetPaymentMode.Companion;
        Object obj = map2.get(SessionsConfigParameter.SYNC_MODE);
        if (obj != null) {
            WalletBottomSheetPaymentMode fromInt = companion.fromInt(((Integer) obj).intValue());
            Object obj2 = map2.get("amount");
            if (obj2 != null) {
                float floatValue = ((Float) obj2).floatValue();
                Object obj3 = map2.get("title");
                if (obj3 != null) {
                    String str = (String) obj3;
                    Object obj4 = map2.get("description");
                    if (obj4 != null) {
                        String str2 = (String) obj4;
                        Object obj5 = map2.get("buttonTitle");
                        if (obj5 != null) {
                            String str3 = (String) obj5;
                            WalletPaymentFeature.Companion companion2 = WalletPaymentFeature.Companion;
                            Object obj6 = map2.get("feature");
                            if (obj6 != null) {
                                return new PaymentInfoDisplayModel((String) null, str, (String) null, 0, false, (String) null, str3, floatValue, fromInt, (String) null, (String) null, companion2.fromInt(Integer.valueOf(((Integer) obj6).intValue())), str2, false, (String) null, 0.0f, (String) null, 124477, (DefaultConstructorMarker) null);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @NotNull
    public static final BottomSheetPaymentStatusModel toPaymentStatusUpdateDisplayModel(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        WalletPaymentStatus.Companion companion = WalletPaymentStatus.Companion;
        Object obj = map.get("status");
        if (obj != null) {
            WalletPaymentStatus fromInt = companion.fromInt(((Integer) obj).intValue());
            Object obj2 = map.get("title");
            if (obj2 != null) {
                String str = (String) obj2;
                Object obj3 = map.get("description");
                if (obj3 != null) {
                    return new BottomSheetPaymentStatusModel(fromInt, str, (String) obj3, (String) null, (String) null, 24, (DefaultConstructorMarker) null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
