package com.talabat.userandlocation.login.di.factory;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.helpers.BASEURLS;
import com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl;
import com.talabat.user.address.data.local.AddressesLocalDataSource;
import com.talabat.user.address.data.remote.AddressDtoMapper;
import com.talabat.user.address.data.remote.api.AddressApi;
import com.talabat.user.address.data.remote.impl.AddressRemoteDataSourceImpl;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl;
import com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl;
import com.talabat.userandlocation.login.presentation.provider.EnterPasswordStringProvider;
import com.talabat.userandlocation.login.presentation.provider.impl.EnterPasswordStringProviderImpl;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterPasswordViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/login/di/factory/EnterPasswordViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "enterPasswordStringProvider", "Lcom/talabat/userandlocation/login/presentation/provider/EnterPasswordStringProvider;", "verifyLoginPasswordUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/userandlocation/login/presentation/provider/EnterPasswordStringProvider;Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static EnterPasswordViewModel mockedEnterPasswordViewModel;
    @NotNull
    private final EnterPasswordStringProvider enterPasswordStringProvider;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final VerifyLoginPasswordUseCase verifyLoginPasswordUseCase;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/userandlocation/login/di/factory/EnterPasswordViewModelFactory$Companion;", "", "()V", "mockedEnterPasswordViewModel", "Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterPasswordViewModel;", "getMockedEnterPasswordViewModel$annotations", "getMockedEnterPasswordViewModel", "()Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterPasswordViewModel;", "setMockedEnterPasswordViewModel", "(Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterPasswordViewModel;)V", "newInstance", "Lcom/talabat/userandlocation/login/di/factory/EnterPasswordViewModelFactory;", "activity", "Landroid/app/Activity;", "provideAddressApi", "Lcom/talabat/user/address/data/remote/api/AddressApi;", "provideCustomerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideFallbackAddressApi", "provideRefreshCustomerInformationUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase;", "context", "Landroid/content/Context;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "subscriptionsCustomerRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMockedEnterPasswordViewModel$annotations() {
        }

        private final AddressApi provideAddressApi() {
            TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
            String buildUserLocationBaseURL = BASEURLS.buildUserLocationBaseURL("release");
            Intrinsics.checkNotNullExpressionValue(buildUserLocationBaseURL, "buildUserLocationBaseURL(BuildConfig.BUILD_TYPE)");
            return (AddressApi) talabatAPIBuilder.createApi(buildUserLocationBaseURL, AddressApi.class);
        }

        private final CustomerAddressesRepository provideCustomerAddressesRepository(ITalabatFeatureFlag iTalabatFeatureFlag) {
            AddressApi provideAddressApi = provideAddressApi();
            AddressDtoMapper addressDtoMapper = new AddressDtoMapper();
            AddressApi provideFallbackAddressApi = provideFallbackAddressApi();
            Customer instance = Customer.getInstance();
            AddressRemoteDataSourceImpl addressRemoteDataSourceImpl = new AddressRemoteDataSourceImpl(provideAddressApi, addressDtoMapper);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            return new CustomerAddressesRepositoryImpl(provideAddressApi, provideFallbackAddressApi, addressRemoteDataSourceImpl, addressDtoMapper, instance, (AddressesLocalDataSource) null, (CoroutineDispatcher) null, iTalabatFeatureFlag, 96, (DefaultConstructorMarker) null);
        }

        private final AddressApi provideFallbackAddressApi() {
            return (AddressApi) new TalabatAPIBuilder().createApi(AddressApi.class);
        }

        private final RefreshCustomerInformationUseCase provideRefreshCustomerInformationUseCase(Context context, ConfigurationLocalRepository configurationLocalRepository, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository, GetProCentralizationStatusUseCase getProCentralizationStatusUseCase, ITalabatFeatureFlag iTalabatFeatureFlag) {
            GetProCentralizationStatusUseCase getProCentralizationStatusUseCase2 = getProCentralizationStatusUseCase;
            return new RefreshCustomerInformationUseCaseImpl(Dispatchers.getIO(), configurationLocalRepository, provideCustomerAddressesRepository(iTalabatFeatureFlag), new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null), new CustomerInfoRepositoryImpl((CoroutineDispatcher) null, new CustomerInfoLocalDataSourceImpl((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null), new CustomerInfoRemoteDataSourceImpl((CustomerInfoApi) new TalabatAPIBuilder().createApi(CustomerInfoApi.class)), new ProCentralizationStatusWrapper(getProCentralizationStatusUseCase2, iSubscriptionsCustomerRepository), 1, (DefaultConstructorMarker) null));
        }

        @Nullable
        public final EnterPasswordViewModel getMockedEnterPasswordViewModel() {
            return EnterPasswordViewModelFactory.mockedEnterPasswordViewModel;
        }

        @NotNull
        public final EnterPasswordViewModelFactory newInstance(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
            SubscriptionsFeatureApi subscriptionsFeatureApi = (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer(activity).getFeature(SubscriptionsFeatureApi.class);
            IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
            AuthenticationRepository authenticationRepository = ((AuthenticationCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(AuthenticationCoreLibApi.class)).getAuthenticationRepository();
            ITalabatFeatureFlag talabatFeatureFlag = ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
            Resources resources = activity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
            return new EnterPasswordViewModelFactory(new EnterPasswordStringProviderImpl(resources), new VerifyLoginPasswordUseCaseImpl(Dispatchers.getIO(), authenticationRepository, provideRefreshCustomerInformationUseCase(activity, repository, subscriptionsFeatureApi.getSubscriptionsCustomerRepository(), subscriptionsFeatureApi.getGetProCentralizationStatusUseCase(), talabatFeatureFlag)), observabilityManager, (DefaultConstructorMarker) null);
        }

        public final void setMockedEnterPasswordViewModel(@Nullable EnterPasswordViewModel enterPasswordViewModel) {
            EnterPasswordViewModelFactory.mockedEnterPasswordViewModel = enterPasswordViewModel;
        }
    }

    private EnterPasswordViewModelFactory(EnterPasswordStringProvider enterPasswordStringProvider2, VerifyLoginPasswordUseCase verifyLoginPasswordUseCase2, IObservabilityManager iObservabilityManager) {
        this.enterPasswordStringProvider = enterPasswordStringProvider2;
        this.verifyLoginPasswordUseCase = verifyLoginPasswordUseCase2;
        this.observabilityManager = iObservabilityManager;
    }

    public /* synthetic */ EnterPasswordViewModelFactory(EnterPasswordStringProvider enterPasswordStringProvider2, VerifyLoginPasswordUseCase verifyLoginPasswordUseCase2, IObservabilityManager iObservabilityManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterPasswordStringProvider2, verifyLoginPasswordUseCase2, iObservabilityManager);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T t11 = mockedEnterPasswordViewModel;
        return t11 == null ? new EnterPasswordViewModel(this.enterPasswordStringProvider, this.verifyLoginPasswordUseCase, this.observabilityManager) : t11;
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
