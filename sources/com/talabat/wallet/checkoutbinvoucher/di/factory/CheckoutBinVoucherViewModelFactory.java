package com.talabat.wallet.checkoutbinvoucher.di.factory;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.data.impl.CheckoutPaymentManagerRepositoryImpl;
import com.talabat.wallet.checkoutbinvoucher.domain.application.usecase.GetBNPLBinVoucherFeatureUseCase;
import com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetBinVoucherCheckEligibility;
import com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase;
import com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel.CheckoutBinVoucherViewModel;
import com.talabat.wallet.checkoutpaymentmanager.di.module.DomainModule;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/di/factory/CheckoutBinVoucherViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getOrderVoucherUseCase", "Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetOrderVoucherUseCase;", "(Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetOrderVoucherUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutBinVoucherViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static CheckoutBinVoucherViewModel mockedCheckoutBinVoucherViewModel;
    @NotNull
    private final GetOrderVoucherUseCase getOrderVoucherUseCase;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/di/factory/CheckoutBinVoucherViewModelFactory$Companion;", "", "()V", "mockedCheckoutBinVoucherViewModel", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/viewmodel/CheckoutBinVoucherViewModel;", "getMockedCheckoutBinVoucherViewModel$annotations", "getMockedCheckoutBinVoucherViewModel", "()Lcom/talabat/wallet/checkoutbinvoucher/presentation/viewmodel/CheckoutBinVoucherViewModel;", "setMockedCheckoutBinVoucherViewModel", "(Lcom/talabat/wallet/checkoutbinvoucher/presentation/viewmodel/CheckoutBinVoucherViewModel;)V", "create", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMockedCheckoutBinVoucherViewModel$annotations() {
        }

        @NotNull
        public final CheckoutBinVoucherViewModel create(@NotNull AppCompatActivity appCompatActivity) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "appCompatActivity");
            DomainModule domainModule = DomainModule.INSTANCE;
            Application application = appCompatActivity.getApplication();
            if (application != null) {
                ITalabatFeatureFlag provideFeatureFlagRepository = domainModule.provideFeatureFlagRepository((ApiContainer) application);
                CheckoutBinVoucherViewModel mockedCheckoutBinVoucherViewModel = getMockedCheckoutBinVoucherViewModel();
                if (mockedCheckoutBinVoucherViewModel == null) {
                    return (CheckoutBinVoucherViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity, (ViewModelProvider.Factory) new CheckoutBinVoucherViewModelFactory(new GetOrderVoucherUseCase(new GetBinVoucherCheckEligibility(new CheckoutPaymentManagerRepositoryImpl()), new GetBNPLBinVoucherFeatureUseCase(provideFeatureFlagRepository)), (DefaultConstructorMarker) null)).get(CheckoutBinVoucherViewModel.class);
                }
                return mockedCheckoutBinVoucherViewModel;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }

        @Nullable
        public final CheckoutBinVoucherViewModel getMockedCheckoutBinVoucherViewModel() {
            return CheckoutBinVoucherViewModelFactory.mockedCheckoutBinVoucherViewModel;
        }

        public final void setMockedCheckoutBinVoucherViewModel(@Nullable CheckoutBinVoucherViewModel checkoutBinVoucherViewModel) {
            CheckoutBinVoucherViewModelFactory.mockedCheckoutBinVoucherViewModel = checkoutBinVoucherViewModel;
        }
    }

    private CheckoutBinVoucherViewModelFactory(GetOrderVoucherUseCase getOrderVoucherUseCase2) {
        this.getOrderVoucherUseCase = getOrderVoucherUseCase2;
    }

    public /* synthetic */ CheckoutBinVoucherViewModelFactory(GetOrderVoucherUseCase getOrderVoucherUseCase2, DefaultConstructorMarker defaultConstructorMarker) {
        this(getOrderVoucherUseCase2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new CheckoutBinVoucherViewModel(this.getOrderVoucherUseCase);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
