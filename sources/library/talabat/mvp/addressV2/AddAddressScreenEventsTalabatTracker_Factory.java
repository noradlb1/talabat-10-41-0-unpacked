package library.talabat.mvp.addressV2;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddAddressScreenEventsTalabatTracker_Factory implements Factory<AddAddressScreenEventsTalabatTracker> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public AddAddressScreenEventsTalabatTracker_Factory(Provider<TalabatTracker> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.talabatTrackerProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static AddAddressScreenEventsTalabatTracker_Factory create(Provider<TalabatTracker> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new AddAddressScreenEventsTalabatTracker_Factory(provider, provider2);
    }

    public static AddAddressScreenEventsTalabatTracker newInstance(TalabatTracker talabatTracker, ConfigurationLocalRepository configurationLocalRepository) {
        return new AddAddressScreenEventsTalabatTracker(talabatTracker, configurationLocalRepository);
    }

    public AddAddressScreenEventsTalabatTracker get() {
        return newInstance(this.talabatTrackerProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
