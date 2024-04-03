package com.checkout.frames.component.billingaddressfields;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ BillingAddressInputComponentState $inputComponentState;
    final /* synthetic */ BillingAddressInputComponentViewStyle $inputComponentViewStyle;
    final /* synthetic */ Function2<Integer, Boolean, Unit> $onFocusChanged;
    final /* synthetic */ Function2<Integer, String, Unit> $onValueChange;
    final /* synthetic */ int $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$3(int i11, BillingAddressInputComponentViewStyle billingAddressInputComponentViewStyle, BillingAddressInputComponentState billingAddressInputComponentState, Function2<? super Integer, ? super Boolean, Unit> function2, Function2<? super Integer, ? super String, Unit> function22, int i12) {
        super(2);
        this.$position = i11;
        this.$inputComponentViewStyle = billingAddressInputComponentViewStyle;
        this.$inputComponentState = billingAddressInputComponentState;
        this.$onFocusChanged = function2;
        this.$onValueChange = function22;
        this.$$changed = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BillingAddressDynamicInputComponentKt.BillingAddressDynamicInputComponent(this.$position, this.$inputComponentViewStyle, this.$inputComponentState, this.$onFocusChanged, this.$onValueChange, composer, this.$$changed | 1);
    }
}
