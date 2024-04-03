package com.checkout.frames.screen.countrypicker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$CountryItemComponent$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CountryItem $data;
    final /* synthetic */ Function1<String, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$CountryItemComponent$1$1(Function1<? super String, Unit> function1, CountryItem countryItem) {
        super(0);
        this.$onClick = function1;
        this.$data = countryItem;
    }

    public final void invoke() {
        this.$onClick.invoke(this.$data.getIso2());
    }
}
