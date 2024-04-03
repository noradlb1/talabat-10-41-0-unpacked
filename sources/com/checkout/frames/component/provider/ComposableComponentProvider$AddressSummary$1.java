package com.checkout.frames.component.provider;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableComponentProvider$AddressSummary$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $goToBillingAddressForm;
    final /* synthetic */ AddressSummaryComponentStyle $style;
    final /* synthetic */ ComposableComponentProvider $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableComponentProvider$AddressSummary$1(ComposableComponentProvider composableComponentProvider, AddressSummaryComponentStyle addressSummaryComponentStyle, Function0<Unit> function0, int i11) {
        super(2);
        this.$tmp0_rcvr = composableComponentProvider;
        this.$style = addressSummaryComponentStyle;
        this.$goToBillingAddressForm = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.$tmp0_rcvr.AddressSummary(this.$style, this.$goToBillingAddressForm, composer, this.$$changed | 1);
    }
}
