package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavHostController;
import com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.component.country.CountryComponentKt;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$invoke$$inlined$itemsIndexed$default$3 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty$inlined;
    final /* synthetic */ Injector $injector$inlined;
    final /* synthetic */ List $items;
    final /* synthetic */ NavHostController $navController$inlined;
    final /* synthetic */ BillingAddressDetailsStyle $style$inlined;
    final /* synthetic */ BillingAddressDetailsViewModel $viewModel$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$invoke$$inlined$itemsIndexed$default$3(List list, BillingAddressDetailsStyle billingAddressDetailsStyle, Injector injector, int i11, BillingAddressDetailsViewModel billingAddressDetailsViewModel, NavHostController navHostController) {
        super(4);
        this.$items = list;
        this.$style$inlined = billingAddressDetailsStyle;
        this.$injector$inlined = injector;
        this.$$dirty$inlined = i11;
        this.$viewModel$inlined = billingAddressDetailsViewModel;
        this.$navController$inlined = navHostController;
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
        if ((i13 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091073711, i13, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:179)");
            }
            int i14 = (i13 & 112) | (i13 & 14);
            BillingAddressInputComponentState billingAddressInputComponentState = (BillingAddressInputComponentState) this.$items.get(i11);
            if (Intrinsics.areEqual((Object) billingAddressInputComponentState.getAddressFieldName(), (Object) BillingFormFields.Country.name())) {
                composer.startReplaceableGroup(1788837305);
                CountryComponentKt.CountryComponent(this.$style$inlined.getCountryComponentStyle(), this.$injector$inlined, new BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$1(this.$viewModel$inlined, billingAddressInputComponentState), new BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$2(this.$navController$inlined), composer, (this.$$dirty$inlined & 112) | 8);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1788837709);
                BillingAddressDynamicInputComponentKt.BillingAddressDynamicInputComponent(i11, this.$viewModel$inlined.getInputComponentViewStyleList().get(i11), billingAddressInputComponentState, new BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$3(this.$viewModel$inlined), new BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$4(this.$viewModel$inlined), composer, ((i14 >> 3) & 14) | 576);
                composer.endReplaceableGroup();
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
