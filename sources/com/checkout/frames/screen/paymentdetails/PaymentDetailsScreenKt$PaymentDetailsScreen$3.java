package com.checkout.frames.screen.paymentdetails;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavController;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.screen.PaymentDetailsStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class PaymentDetailsScreenKt$PaymentDetailsScreen$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ NavController $navController;
    final /* synthetic */ PaymentDetailsStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentDetailsScreenKt$PaymentDetailsScreen$3(PaymentDetailsStyle paymentDetailsStyle, Injector injector, NavController navController, int i11) {
        super(2);
        this.$style = paymentDetailsStyle;
        this.$injector = injector;
        this.$navController = navController;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        PaymentDetailsScreenKt.PaymentDetailsScreen(this.$style, this.$injector, this.$navController, composer, this.$$changed | 1);
    }
}
