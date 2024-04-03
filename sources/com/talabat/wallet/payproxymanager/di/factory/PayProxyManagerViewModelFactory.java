package com.talabat.wallet.payproxymanager.di.factory;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.checkoutpaymentmanager.di.module.DomainModule;
import com.talabat.wallet.payproxymanager.di.domain.PayProxyManagerDomainModule;
import com.talabat.wallet.payproxymanager.domain.application.usecase.GetPayProxyCVVFeatureFlagUseCase;
import com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase;
import com.talabat.wallet.payproxymanager.preesentation.viewmodel.PayProxyManagerViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/payproxymanager/di/factory/PayProxyManagerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getSendCVVToProxyUseCase", "Lcom/talabat/wallet/payproxymanager/domain/business/GetSendCVVToProxyUseCase;", "(Lcom/talabat/wallet/payproxymanager/domain/business/GetSendCVVToProxyUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyManagerViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static PayProxyManagerViewModel mockedPayProxyManagerViewModel;
    @NotNull
    private final GetSendCVVToProxyUseCase getSendCVVToProxyUseCase;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/payproxymanager/di/factory/PayProxyManagerViewModelFactory$Companion;", "", "()V", "mockedPayProxyManagerViewModel", "Lcom/talabat/wallet/payproxymanager/preesentation/viewmodel/PayProxyManagerViewModel;", "getMockedPayProxyManagerViewModel", "()Lcom/talabat/wallet/payproxymanager/preesentation/viewmodel/PayProxyManagerViewModel;", "setMockedPayProxyManagerViewModel", "(Lcom/talabat/wallet/payproxymanager/preesentation/viewmodel/PayProxyManagerViewModel;)V", "create", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PayProxyManagerViewModel create(@NotNull AppCompatActivity appCompatActivity, @NotNull IObservabilityManager iObservabilityManager) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "appCompatActivity");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            DomainModule domainModule = DomainModule.INSTANCE;
            Application application = appCompatActivity.getApplication();
            if (application != null) {
                ITalabatFeatureFlag provideFeatureFlagRepository = domainModule.provideFeatureFlagRepository((ApiContainer) application);
                PayProxyManagerViewModel mockedPayProxyManagerViewModel = getMockedPayProxyManagerViewModel();
                if (mockedPayProxyManagerViewModel == null) {
                    return (PayProxyManagerViewModel) new ViewModelProvider((ViewModelStoreOwner) appCompatActivity, (ViewModelProvider.Factory) new PayProxyManagerViewModelFactory(new GetSendCVVToProxyUseCase(new GetPayProxyCVVFeatureFlagUseCase(provideFeatureFlagRepository), PayProxyManagerDomainModule.INSTANCE.providePayProxyManagerRepository(), (CoroutineDispatcher) null, iObservabilityManager, 4, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null)).get(PayProxyManagerViewModel.class);
                }
                return mockedPayProxyManagerViewModel;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }

        @Nullable
        public final PayProxyManagerViewModel getMockedPayProxyManagerViewModel() {
            return PayProxyManagerViewModelFactory.mockedPayProxyManagerViewModel;
        }

        public final void setMockedPayProxyManagerViewModel(@Nullable PayProxyManagerViewModel payProxyManagerViewModel) {
            PayProxyManagerViewModelFactory.mockedPayProxyManagerViewModel = payProxyManagerViewModel;
        }
    }

    private PayProxyManagerViewModelFactory(GetSendCVVToProxyUseCase getSendCVVToProxyUseCase2) {
        this.getSendCVVToProxyUseCase = getSendCVVToProxyUseCase2;
    }

    public /* synthetic */ PayProxyManagerViewModelFactory(GetSendCVVToProxyUseCase getSendCVVToProxyUseCase2, DefaultConstructorMarker defaultConstructorMarker) {
        this(getSendCVVToProxyUseCase2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new PayProxyManagerViewModel(this.getSendCVVToProxyUseCase);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
