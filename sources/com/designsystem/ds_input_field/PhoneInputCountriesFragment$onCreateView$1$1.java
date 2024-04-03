package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.designsystem.ds_theme.DSThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneInputCountriesFragment$onCreateView$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31888g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$onCreateView$1$1(PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(2);
        this.f31888g = phoneInputCountriesFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            final PhoneInputCountriesFragment phoneInputCountriesFragment = this.f31888g;
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(composer, -819893662, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        phoneInputCountriesFragment.CountryPicker$marshmallow_release(composer, 8);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 6);
            return;
        }
        composer.skipToGroupEnd();
    }
}
