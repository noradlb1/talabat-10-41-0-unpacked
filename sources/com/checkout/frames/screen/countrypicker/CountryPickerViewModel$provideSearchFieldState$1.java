package com.checkout.frames.screen.countrypicker;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerViewModel$provideSearchFieldState$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ CountryPickerViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerViewModel$provideSearchFieldState$1(CountryPickerViewModel countryPickerViewModel) {
        super(0);
        this.this$0 = countryPickerViewModel;
    }

    @NotNull
    public final Boolean invoke() {
        return this.this$0.isSearchActive().getValue();
    }
}
