package com.talabat.talabatnavigation.checkout;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatnavigation/checkout/CheckoutNavigationActions;", "", "()V", "ENCRYPTED_ORDER_ID", "", "OPEN_ORDER_TRACKING", "TRANSACTION_ID", "createNavigationModelToOrderTracking", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "encryptedOrderId", "transactionId", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutNavigationActions {
    @NotNull
    private static final String ENCRYPTED_ORDER_ID = "encryptedOrderId";
    @NotNull
    public static final CheckoutNavigationActions INSTANCE = new CheckoutNavigationActions();
    @NotNull
    public static final String OPEN_ORDER_TRACKING = "talabat.action.OrderTrackingFlutterActivity";
    @NotNull
    private static final String TRANSACTION_ID = "transId";

    private CheckoutNavigationActions() {
    }

    @NotNull
    public final NavigatorModel createNavigationModelToOrderTracking(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        Intrinsics.checkNotNullParameter(str2, "transactionId");
        Bundle bundle = new Bundle();
        bundle.putString("encryptedOrderId", str);
        bundle.putString("transId", str2);
        return new NavigatorModel(OPEN_ORDER_TRACKING, bundle, CheckoutNavigationActions$createNavigationModelToOrderTracking$2.INSTANCE);
    }
}
