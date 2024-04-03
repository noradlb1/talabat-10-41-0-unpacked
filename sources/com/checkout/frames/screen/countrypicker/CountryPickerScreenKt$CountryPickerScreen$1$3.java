package com.checkout.frames.screen.countrypicker;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$CountryPickerScreen$1$3 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ CountryPickerViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$CountryPickerScreen$1$3(CountryPickerViewModel countryPickerViewModel) {
        super(1);
        this.$viewModel = countryPickerViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        List value = this.$viewModel.getSearchCountries().getValue();
        CountryPickerViewModel countryPickerViewModel = this.$viewModel;
        lazyListScope.items(value.size(), (Function1<? super Integer, ? extends Object>) null, new CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$3(CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$1.INSTANCE, value), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$4(value, countryPickerViewModel)));
    }
}
