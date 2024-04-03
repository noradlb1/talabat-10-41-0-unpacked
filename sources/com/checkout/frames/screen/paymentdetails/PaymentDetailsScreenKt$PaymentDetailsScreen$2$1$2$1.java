package com.checkout.frames.screen.paymentdetails;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.checkout.frames.screen.navigation.Screen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class PaymentDetailsScreenKt$PaymentDetailsScreen$2$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NavController $navController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentDetailsScreenKt$PaymentDetailsScreen$2$1$2$1(NavController navController) {
        super(0);
        this.$navController = navController;
    }

    public final void invoke() {
        NavController.navigate$default(this.$navController, Screen.BillingFormScreen.INSTANCE.getRoute(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }
}
