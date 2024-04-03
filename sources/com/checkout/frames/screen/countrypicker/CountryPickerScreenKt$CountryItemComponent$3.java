package com.checkout.frames.screen.countrypicker;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$CountryItemComponent$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ CountryItem $data;
    final /* synthetic */ TextLabelViewStyle $labelStyle;
    final /* synthetic */ Function1<String, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$CountryItemComponent$3(TextLabelViewStyle textLabelViewStyle, CountryItem countryItem, Function1<? super String, Unit> function1, int i11) {
        super(2);
        this.$labelStyle = textLabelViewStyle;
        this.$data = countryItem;
        this.$onClick = function1;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CountryPickerScreenKt.CountryItemComponent(this.$labelStyle, this.$data, this.$onClick, composer, this.$$changed | 1);
    }
}
