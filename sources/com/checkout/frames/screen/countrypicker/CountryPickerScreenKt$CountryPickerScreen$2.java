package com.checkout.frames.screen.countrypicker;

import androidx.compose.runtime.Composer;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.screen.CountryPickerStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$CountryPickerScreen$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ CountryPickerStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$CountryPickerScreen$2(CountryPickerStyle countryPickerStyle, Injector injector, Function0<Unit> function0, int i11) {
        super(2);
        this.$style = countryPickerStyle;
        this.$injector = injector;
        this.$onClose = function0;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CountryPickerScreenKt.CountryPickerScreen(this.$style, this.$injector, this.$onClose, composer, this.$$changed | 1);
    }
}
