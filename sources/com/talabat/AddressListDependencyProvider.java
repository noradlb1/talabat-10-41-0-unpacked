package com.talabat;

import androidx.annotation.VisibleForTesting;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.user.address.di.AddressesDependencyProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.addresslist.AddressListInteractor;
import library.talabat.mvp.addresslist.AddressListPresenter;
import library.talabat.mvp.addresslist.AddressListView;
import library.talabat.mvp.addresslist.IAddressListInteractor;
import library.talabat.mvp.addresslist.IAddressListPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/talabat/AddressListDependencyProvider;", "", "()V", "mockedAddressListPresenter", "Llibrary/talabat/mvp/addresslist/IAddressListPresenter;", "getMockedAddressListPresenter$annotations", "getMockedAddressListPresenter", "()Llibrary/talabat/mvp/addresslist/IAddressListPresenter;", "setMockedAddressListPresenter", "(Llibrary/talabat/mvp/addresslist/IAddressListPresenter;)V", "createAddressListInteractor", "Llibrary/talabat/mvp/addresslist/AddressListInteractor;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "createAddressListPresenter", "addressListView", "Llibrary/talabat/mvp/addresslist/AddressListView;", "addressListInteractor", "Llibrary/talabat/mvp/addresslist/IAddressListInteractor;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressListDependencyProvider {
    @NotNull
    public static final AddressListDependencyProvider INSTANCE = new AddressListDependencyProvider();
    @Nullable
    private static IAddressListPresenter mockedAddressListPresenter;

    private AddressListDependencyProvider() {
    }

    @JvmStatic
    @NotNull
    public static final AddressListInteractor createAddressListInteractor(@NotNull AppVersionProvider appVersionProvider, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        return new AddressListInteractor(appVersionProvider, AddressesDependencyProvider.INSTANCE.provideCustomerAddressesRepository(iTalabatFeatureFlag), Schedulers.io(), AndroidSchedulers.mainThread());
    }

    @JvmStatic
    @NotNull
    public static final IAddressListPresenter createAddressListPresenter(@NotNull AddressListView addressListView, @NotNull IAddressListInteractor iAddressListInteractor, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(addressListView, "addressListView");
        Intrinsics.checkNotNullParameter(iAddressListInteractor, "addressListInteractor");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        IAddressListPresenter iAddressListPresenter = mockedAddressListPresenter;
        if (iAddressListPresenter == null) {
            return new AddressListPresenter(addressListView, iAddressListInteractor, configurationLocalRepository, locationConfigurationRepository);
        }
        return iAddressListPresenter;
    }

    @VisibleForTesting
    public static /* synthetic */ void getMockedAddressListPresenter$annotations() {
    }

    @Nullable
    public final IAddressListPresenter getMockedAddressListPresenter() {
        return mockedAddressListPresenter;
    }

    public final void setMockedAddressListPresenter(@Nullable IAddressListPresenter iAddressListPresenter) {
        mockedAddressListPresenter = iAddressListPresenter;
    }
}
