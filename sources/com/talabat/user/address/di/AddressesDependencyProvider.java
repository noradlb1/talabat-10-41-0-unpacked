package com.talabat.user.address.di;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.helpers.BASEURLS;
import com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl;
import com.talabat.user.address.data.local.AddressesLocalDataSource;
import com.talabat.user.address.data.remote.AddressDtoMapper;
import com.talabat.user.address.data.remote.api.AddressApi;
import com.talabat.user.address.data.remote.impl.AddressRemoteDataSourceImpl;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u0010"}, d2 = {"Lcom/talabat/user/address/di/AddressesDependencyProvider;", "", "()V", "provideAddressApi", "Lcom/talabat/user/address/data/remote/api/AddressApi;", "provideCustomerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideCustomerRepository", "Llibrary/talabat/mvp/login/data/repository/impl/CustomerRepositoryImpl;", "context", "Landroid/content/Context;", "provideFallbackAddressApi", "provideRetrieveAndCacheCustomerAddressesUseCase", "Lcom/talabat/user/address/domain/usecases/RetrieveAndCacheCustomerAddressesUseCase;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressesDependencyProvider {
    @NotNull
    public static final AddressesDependencyProvider INSTANCE = new AddressesDependencyProvider();

    private AddressesDependencyProvider() {
    }

    @NotNull
    public final AddressApi provideAddressApi() {
        TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
        String buildUserLocationBaseURL = BASEURLS.buildUserLocationBaseURL("release");
        Intrinsics.checkNotNullExpressionValue(buildUserLocationBaseURL, "buildUserLocationBaseURL(BuildConfig.BUILD_TYPE)");
        return (AddressApi) talabatAPIBuilder.createApi(buildUserLocationBaseURL, AddressApi.class);
    }

    @NotNull
    public final CustomerAddressesRepository provideCustomerAddressesRepository(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        AddressApi provideAddressApi = provideAddressApi();
        AddressDtoMapper addressDtoMapper = new AddressDtoMapper();
        AddressApi provideFallbackAddressApi = provideFallbackAddressApi();
        Customer instance = Customer.getInstance();
        AddressRemoteDataSourceImpl addressRemoteDataSourceImpl = new AddressRemoteDataSourceImpl(provideAddressApi, addressDtoMapper);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new CustomerAddressesRepositoryImpl(provideAddressApi, provideFallbackAddressApi, addressRemoteDataSourceImpl, addressDtoMapper, instance, (AddressesLocalDataSource) null, (CoroutineDispatcher) null, iTalabatFeatureFlag, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final CustomerRepositoryImpl provideCustomerRepository(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new CustomerRepositoryImpl(context, instance, (Function1) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final AddressApi provideFallbackAddressApi() {
        return (AddressApi) new TalabatAPIBuilder().createApi(AddressApi.class);
    }

    @NotNull
    public final RetrieveAndCacheCustomerAddressesUseCase provideRetrieveAndCacheCustomerAddressesUseCase(@NotNull Context context, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        return new RetrieveAndCacheCustomerAddressesUseCaseImpl(provideCustomerAddressesRepository(iTalabatFeatureFlag), provideCustomerRepository(context));
    }
}
