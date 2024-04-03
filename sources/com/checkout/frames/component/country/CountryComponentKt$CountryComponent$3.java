package com.checkout.frames.component.country;

import androidx.compose.runtime.Composer;
import com.checkout.base.model.Country;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.CountryComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryComponentKt$CountryComponent$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $goToCountryPicker;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ Function1<Country, Unit> $onCountryUpdated;
    final /* synthetic */ CountryComponentStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryComponentKt$CountryComponent$3(CountryComponentStyle countryComponentStyle, Injector injector, Function1<? super Country, Unit> function1, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = countryComponentStyle;
        this.$injector = injector;
        this.$onCountryUpdated = function1;
        this.$goToCountryPicker = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CountryComponentKt.CountryComponent(this.$style, this.$injector, this.$onCountryUpdated, this.$goToCountryPicker, composer, this.$$changed | 1);
    }
}
