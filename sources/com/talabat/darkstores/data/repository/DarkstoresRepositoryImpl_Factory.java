package com.talabat.darkstores.data.repository;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.darkstores.data.vendors.remote.VendorsApi;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named", "com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class DarkstoresRepositoryImpl_Factory implements Factory<DarkstoresRepositoryImpl> {
    private final Provider<DarkstoresCartRepository> cartRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<Integer> selectedAreaIdProvider;
    private final Provider<Integer> selectedCountryIdProvider;
    private final Provider<String> selectedLatitudeProvider;
    private final Provider<String> selectedLongitudeProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<VendorsApi> vendorsApiProvider;

    public DarkstoresRepositoryImpl_Factory(Provider<DarkstoresCartRepository> provider, Provider<SharedPreferences> provider2, Provider<VendorsApi> provider3, Provider<Integer> provider4, Provider<String> provider5, Provider<String> provider6, Provider<Integer> provider7, Provider<Scheduler> provider8, Provider<CoroutineDispatchersFactory> provider9, Provider<Gson> provider10) {
        this.cartRepositoryProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.vendorsApiProvider = provider3;
        this.selectedAreaIdProvider = provider4;
        this.selectedLatitudeProvider = provider5;
        this.selectedLongitudeProvider = provider6;
        this.selectedCountryIdProvider = provider7;
        this.ioSchedulerProvider = provider8;
        this.coroutineDispatchersFactoryProvider = provider9;
        this.gsonProvider = provider10;
    }

    public static DarkstoresRepositoryImpl_Factory create(Provider<DarkstoresCartRepository> provider, Provider<SharedPreferences> provider2, Provider<VendorsApi> provider3, Provider<Integer> provider4, Provider<String> provider5, Provider<String> provider6, Provider<Integer> provider7, Provider<Scheduler> provider8, Provider<CoroutineDispatchersFactory> provider9, Provider<Gson> provider10) {
        return new DarkstoresRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static DarkstoresRepositoryImpl newInstance(DarkstoresCartRepository darkstoresCartRepository, SharedPreferences sharedPreferences, VendorsApi vendorsApi, Provider<Integer> provider, Provider<String> provider2, Provider<String> provider3, Provider<Integer> provider4, Scheduler scheduler, CoroutineDispatchersFactory coroutineDispatchersFactory, Gson gson) {
        return new DarkstoresRepositoryImpl(darkstoresCartRepository, sharedPreferences, vendorsApi, provider, provider2, provider3, provider4, scheduler, coroutineDispatchersFactory, gson);
    }

    public DarkstoresRepositoryImpl get() {
        return newInstance(this.cartRepositoryProvider.get(), this.sharedPreferencesProvider.get(), this.vendorsApiProvider.get(), this.selectedAreaIdProvider, this.selectedLatitudeProvider, this.selectedLongitudeProvider, this.selectedCountryIdProvider, this.ioSchedulerProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.gsonProvider.get());
    }
}
