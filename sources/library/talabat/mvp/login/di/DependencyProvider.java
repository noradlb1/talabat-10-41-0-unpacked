package library.talabat.mvp.login.di;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.helpers.AppUrls;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.impl.EnableShowLocationSelectionInHomeScreenUseCaseImpl;
import library.talabat.mvp.home.domain.repository.ShowLocationSelectionRepository;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.data.HomeMapCache;
import library.talabat.mvp.homemap.data.HomeMapCacheImpl;
import library.talabat.mvp.homemap.domain.AddressSortHelper;
import library.talabat.mvp.login.LoginPresenter2;
import library.talabat.mvp.login.LoginView;
import library.talabat.mvp.login.data.api.DeliveryAreaDetailsApi;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import library.talabat.mvp.login.data.repository.impl.DeliveryAreaDetailsRepositoryImpl;
import library.talabat.mvp.login.domain.repository.DeliveryAreaDetailsRepository;
import library.talabat.mvp.login.domain.usecases.LoginUseCases;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import library.talabat.mvp.login.domain.usecases.impl.LoginUseCasesImpl;
import library.talabat.mvp.login.domain.usecases.impl.SelectSavedAddressIfCanDeliverToVendorUseCaseImpl;
import library.talabat.mvp.login.experiments.LoginExperimentProvider;
import library.talabat.mvp.login.experiments.impl.LoginExperimentProviderImpl;
import library.talabat.mvp.login.impl.LoginPresenter2Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u001e\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000fR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\""}, d2 = {"Llibrary/talabat/mvp/login/di/DependencyProvider;", "", "()V", "mockedLoginPresenter2", "Llibrary/talabat/mvp/login/LoginPresenter2;", "getMockedLoginPresenter2$annotations", "getMockedLoginPresenter2", "()Llibrary/talabat/mvp/login/LoginPresenter2;", "setMockedLoginPresenter2", "(Llibrary/talabat/mvp/login/LoginPresenter2;)V", "provideCustomerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "context", "Landroid/content/Context;", "provideDeliverAreaDetailsNetworkRepository", "Llibrary/talabat/mvp/login/domain/repository/DeliveryAreaDetailsRepository;", "deliveryAreaDetailsApi", "Llibrary/talabat/mvp/login/data/api/DeliveryAreaDetailsApi;", "provideDeliveryAreaDetailsApi", "provideHomeMapCache", "Llibrary/talabat/mvp/homemap/data/HomeMapCache;", "provideLoginExperimentProvider", "Llibrary/talabat/mvp/login/experiments/LoginExperimentProvider;", "provideLoginPresenter2", "loginView", "Llibrary/talabat/mvp/login/LoginView;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "provideLoginUseCases", "Llibrary/talabat/mvp/login/domain/usecases/LoginUseCases;", "homeMapCache", "deliveryAreaDetailsRepository", "provideSelectSavedAddressIfCanDeliverToVendorUseCase", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DependencyProvider {
    @NotNull
    public static final DependencyProvider INSTANCE = new DependencyProvider();
    @Nullable
    private static LoginPresenter2 mockedLoginPresenter2;

    private DependencyProvider() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMockedLoginPresenter2$annotations() {
    }

    private final LoginExperimentProvider provideLoginExperimentProvider() {
        return new LoginExperimentProviderImpl();
    }

    private final LoginUseCases provideLoginUseCases(HomeMapCache homeMapCache, CustomerRepository customerRepository, DeliveryAreaDetailsRepository deliveryAreaDetailsRepository) {
        return new LoginUseCasesImpl(provideSelectSavedAddressIfCanDeliverToVendorUseCase(homeMapCache, customerRepository, deliveryAreaDetailsRepository), new EnableShowLocationSelectionInHomeScreenUseCaseImpl((ShowLocationSelectionRepository) null, 1, (DefaultConstructorMarker) null));
    }

    @Nullable
    public final LoginPresenter2 getMockedLoginPresenter2() {
        return mockedLoginPresenter2;
    }

    @NotNull
    public final library.talabat.mvp.login.domain.repository.CustomerRepository provideCustomerRepository(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final DeliveryAreaDetailsRepository provideDeliverAreaDetailsNetworkRepository(@NotNull DeliveryAreaDetailsApi deliveryAreaDetailsApi) {
        Intrinsics.checkNotNullParameter(deliveryAreaDetailsApi, "deliveryAreaDetailsApi");
        return new DeliveryAreaDetailsRepositoryImpl(deliveryAreaDetailsApi);
    }

    @NotNull
    public final DeliveryAreaDetailsApi provideDeliveryAreaDetailsApi() {
        Object create = ApiHandler.getInstance().getRetrofit().newBuilder().baseUrl(AppUrls.VENDORS_URL).build().create(DeliveryAreaDetailsApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "getInstance()\n        .r…eaDetailsApi::class.java)");
        return (DeliveryAreaDetailsApi) create;
    }

    @NotNull
    public final HomeMapCache provideHomeMapCache(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new HomeMapCacheImpl(context, (HomeMapTemp) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final LoginPresenter2 provideLoginPresenter2(@NotNull Context context, @NotNull LoginView loginView, @NotNull CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(loginView, "loginView");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        LoginPresenter2 loginPresenter2 = mockedLoginPresenter2;
        if (loginPresenter2 != null) {
            return loginPresenter2;
        }
        return new LoginPresenter2Impl(provideLoginExperimentProvider(), loginView, provideLoginUseCases(provideHomeMapCache(context), customerRepository, provideDeliverAreaDetailsNetworkRepository(provideDeliveryAreaDetailsApi())), (Scheduler) null, (Scheduler) null, 24, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final SelectSavedAddressIfCanDeliverToVendorUseCase provideSelectSavedAddressIfCanDeliverToVendorUseCase(@NotNull HomeMapCache homeMapCache, @NotNull CustomerRepository customerRepository, @NotNull DeliveryAreaDetailsRepository deliveryAreaDetailsRepository) {
        Intrinsics.checkNotNullParameter(homeMapCache, "homeMapCache");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(deliveryAreaDetailsRepository, "deliveryAreaDetailsRepository");
        return new SelectSavedAddressIfCanDeliverToVendorUseCaseImpl(homeMapCache, customerRepository, (AddressSortHelper) null, deliveryAreaDetailsRepository, (Cart) null, 20, (DefaultConstructorMarker) null);
    }

    public final void setMockedLoginPresenter2(@Nullable LoginPresenter2 loginPresenter2) {
        mockedLoginPresenter2 = loginPresenter2;
    }
}
