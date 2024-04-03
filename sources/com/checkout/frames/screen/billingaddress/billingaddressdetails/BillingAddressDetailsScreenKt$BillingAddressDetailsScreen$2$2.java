package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavHostController;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ BillingAddressDetailsStyle $style;
    final /* synthetic */ BillingAddressDetailsViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2(BillingAddressDetailsViewModel billingAddressDetailsViewModel, BillingAddressDetailsStyle billingAddressDetailsStyle, Injector injector, int i11, NavHostController navHostController) {
        super(1);
        this.$viewModel = billingAddressDetailsViewModel;
        this.$style = billingAddressDetailsStyle;
        this.$injector = injector;
        this.$$dirty = i11;
        this.$navController = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        List<BillingAddressInputComponentState> inputComponentsStateList = this.$viewModel.getInputComponentsStateList();
        lazyListScope.items(inputComponentsStateList.size(), (Function1<? super Integer, ? extends Object>) null, new BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$invoke$$inlined$itemsIndexed$default$2(inputComponentsStateList), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$invoke$$inlined$itemsIndexed$default$3(inputComponentsStateList, this.$style, this.$injector, this.$$dirty, this.$viewModel, this.$navController)));
    }
}
