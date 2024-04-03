package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountriesEmptyState$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31867g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31868h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountriesEmptyState$2(PhoneInputCountriesFragment phoneInputCountriesFragment, int i11) {
        super(2);
        this.f31867g = phoneInputCountriesFragment;
        this.f31868h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f31867g.CountriesEmptyState(composer, this.f31868h | 1);
    }
}
