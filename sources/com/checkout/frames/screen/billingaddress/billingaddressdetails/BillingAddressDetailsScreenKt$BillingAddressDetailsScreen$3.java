package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavHostController;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ BillingAddressDetailsStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$3(BillingAddressDetailsStyle billingAddressDetailsStyle, Injector injector, NavHostController navHostController, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = billingAddressDetailsStyle;
        this.$injector = injector;
        this.$navController = navHostController;
        this.$onClose = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BillingAddressDetailsScreenKt.BillingAddressDetailsScreen(this.$style, this.$injector, this.$navController, this.$onClose, composer, this.$$changed | 1);
    }
}
