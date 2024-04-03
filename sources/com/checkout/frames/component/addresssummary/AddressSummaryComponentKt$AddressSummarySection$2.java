package com.checkout.frames.component.addresssummary;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentKt$AddressSummarySection$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TextLabelState $addressPreviewState;
    final /* synthetic */ InternalButtonState $editAddressButtonState;
    final /* synthetic */ Function0<Unit> $onEditButtonPress;
    final /* synthetic */ AddressSummarySectionViewStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressSummaryComponentKt$AddressSummarySection$2(AddressSummarySectionViewStyle addressSummarySectionViewStyle, TextLabelState textLabelState, InternalButtonState internalButtonState, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = addressSummarySectionViewStyle;
        this.$addressPreviewState = textLabelState;
        this.$editAddressButtonState = internalButtonState;
        this.$onEditButtonPress = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AddressSummaryComponentKt.AddressSummarySection(this.$style, this.$addressPreviewState, this.$editAddressButtonState, this.$onEditButtonPress, composer, this.$$changed | 1);
    }
}
