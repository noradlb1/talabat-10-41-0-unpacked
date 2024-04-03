package com.designsystem.ds_input_field;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneInputCountriesFragment$emptyStateDetails$2 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31885g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$emptyStateDetails$2(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(0);
        this.f31885g = phoneInputCountriesFragment;
    }

    @NotNull
    public final String invoke() {
        String string = this.f31885g.requireArguments().getString("PHONE_INPUT_EMPTY_STATE_DETAILS");
        if (string != null) {
            return string;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
