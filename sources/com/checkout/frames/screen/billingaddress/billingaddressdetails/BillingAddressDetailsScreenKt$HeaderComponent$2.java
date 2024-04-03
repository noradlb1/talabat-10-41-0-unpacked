package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$HeaderComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $onTapDoneButton;
    final /* synthetic */ InternalButtonState $screenButtonState;
    final /* synthetic */ InternalButtonViewStyle $screenButtonStyle;
    final /* synthetic */ TextLabelState $screenTitleState;
    final /* synthetic */ TextLabelViewStyle $screenTitleStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$HeaderComponent$2(TextLabelViewStyle textLabelViewStyle, TextLabelState textLabelState, InternalButtonViewStyle internalButtonViewStyle, InternalButtonState internalButtonState, Function0<Unit> function0, int i11) {
        super(2);
        this.$screenTitleStyle = textLabelViewStyle;
        this.$screenTitleState = textLabelState;
        this.$screenButtonStyle = internalButtonViewStyle;
        this.$screenButtonState = internalButtonState;
        this.$onTapDoneButton = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BillingAddressDetailsScreenKt.HeaderComponent(this.$screenTitleStyle, this.$screenTitleState, this.$screenButtonStyle, this.$screenButtonState, this.$onTapDoneButton, composer, this.$$changed | 1);
    }
}
