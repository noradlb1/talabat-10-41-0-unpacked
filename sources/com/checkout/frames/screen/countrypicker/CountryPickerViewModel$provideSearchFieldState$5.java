package com.checkout.frames.screen.countrypicker;

import com.checkout.frames.view.InputFieldState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerViewModel$provideSearchFieldState$5 extends Lambda implements Function0<String> {
    final /* synthetic */ InputFieldState $viewState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerViewModel$provideSearchFieldState$5(InputFieldState inputFieldState) {
        super(0);
        this.$viewState = inputFieldState;
    }

    @NotNull
    public final String invoke() {
        return this.$viewState.getText().getValue();
    }
}
