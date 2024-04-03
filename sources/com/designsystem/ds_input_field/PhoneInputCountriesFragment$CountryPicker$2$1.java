package com.designsystem.ds_input_field;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountryPicker$2$1 extends Lambda implements Function1<LazyListScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31877g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountryPicker$2$1(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(1);
        this.f31877g = phoneInputCountriesFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        List access$getDisplayedCountries = this.f31877g.getDisplayedCountries();
        lazyListScope.items(access$getDisplayedCountries.size(), (Function1) null, ComposableLambdaKt.composableLambdaInstance(-985536724, true, new PhoneInputCountriesFragment$CountryPicker$2$1$invoke$$inlined$itemsIndexed$default$2(access$getDisplayedCountries, this.f31877g)));
    }
}
