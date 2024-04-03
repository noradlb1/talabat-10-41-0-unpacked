package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.checkout.frames.screen.navigation.Screen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NavHostController $navController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$2(NavHostController navHostController) {
        super(0);
        this.$navController = navHostController;
    }

    public final void invoke() {
        NavController.navigate$default(this.$navController, Screen.CountryPicker.INSTANCE.getRoute(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }
}
