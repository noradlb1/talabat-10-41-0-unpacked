package com.checkout.frames.screen.countrypicker;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$items$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List $items;
    final /* synthetic */ CountryPickerViewModel $viewModel$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$4(List list, CountryPickerViewModel countryPickerViewModel) {
        super(4);
        this.$items = list;
        this.$viewModel$inlined = countryPickerViewModel;
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
        int i14 = 32;
        if ((i12 & 112) == 0) {
            i13 |= composer.changed(i11) ? 32 : 16;
        }
        if ((i13 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-632812321, i13, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:144)");
            }
            int i15 = i13 & 14;
            CountryItem countryItem = (CountryItem) this.$items.get(i11);
            if ((i15 & 112) == 0) {
                if (!composer.changed((Object) countryItem)) {
                    i14 = 16;
                }
                i15 |= i14;
            }
            if ((i15 & 721) != 144 || !composer.getSkipping()) {
                CountryPickerScreenKt.CountryItemComponent(this.$viewModel$inlined.getSearchItemStyle(), countryItem, new CountryPickerScreenKt$CountryPickerScreen$1$3$1$1(this.$viewModel$inlined), composer, (i15 & 112) | 8);
            } else {
                composer.skipToGroupEnd();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
