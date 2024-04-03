package com.designsystem.ds_input_field;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_input_field.country.DSCountryModel;
import com.designsystem.ds_list_item_v2.DSDividerKt;
import com.designsystem.ds_theme.DSTheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u000b¨\u0006\u0005"}, d2 = {"T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "", "it", "", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneInputCountriesFragment$CountryPicker$2$1$invoke$$inlined$itemsIndexed$default$2 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List f31865g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31866h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountryPicker$2$1$invoke$$inlined$itemsIndexed$default$2(List list, PhoneInputCountriesFragment phoneInputCountriesFragment) {
        super(4);
        this.f31865g = list;
        this.f31866h = phoneInputCountriesFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull LazyItemScope lazyItemScope, int i11, @Nullable Composer composer, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        if ((i12 & 14) == 0) {
            i13 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            i13 |= composer.changed(i11) ? 32 : 16;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !composer.getSkipping()) {
            this.f31866h.CountryListItem((DSCountryModel) this.f31865g.get(i11), composer, 72);
            if (i11 < this.f31866h.getCountries().size() - 1) {
                DSDividerKt.m8478DSDividerWMci_g0((Modifier) null, DSTheme.INSTANCE.getDimens(composer, 0).m8847getDsXxxlD9Ej5fM(), 0.0f, composer, 0, 5);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
