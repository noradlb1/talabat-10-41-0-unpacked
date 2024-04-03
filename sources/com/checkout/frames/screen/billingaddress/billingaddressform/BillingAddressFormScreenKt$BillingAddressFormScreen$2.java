package com.checkout.frames.screen.billingaddress.billingaddressform;

import androidx.compose.runtime.Composer;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.screen.BillingFormStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressFormScreenKt$BillingAddressFormScreen$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ BillingFormStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressFormScreenKt$BillingAddressFormScreen$2(BillingFormStyle billingFormStyle, Injector injector, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = billingFormStyle;
        this.$injector = injector;
        this.$onClose = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BillingAddressFormScreenKt.BillingAddressFormScreen(this.$style, this.$injector, this.$onClose, composer, this.$$changed | 1);
    }
}
