package com.checkout.frames.component.addresssummary;

import androidx.compose.runtime.Composer;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentKt$AddressSummaryComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $goToBillingAddressForm;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ AddressSummaryComponentStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressSummaryComponentKt$AddressSummaryComponent$2(AddressSummaryComponentStyle addressSummaryComponentStyle, Injector injector, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = addressSummaryComponentStyle;
        this.$injector = injector;
        this.$goToBillingAddressForm = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AddressSummaryComponentKt.AddressSummaryComponent(this.$style, this.$injector, this.$goToBillingAddressForm, composer, this.$$changed | 1);
    }
}
