package tracking.observability;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorInfoAPIObservabilityImpl_Factory implements Factory<VendorInfoAPIObservabilityImpl> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<IObservabilityManager> observabilityTrackerProvider;

    public VendorInfoAPIObservabilityImpl_Factory(Provider<IObservabilityManager> provider, Provider<AppVersionProvider> provider2) {
        this.observabilityTrackerProvider = provider;
        this.appVersionProvider = provider2;
    }

    public static VendorInfoAPIObservabilityImpl_Factory create(Provider<IObservabilityManager> provider, Provider<AppVersionProvider> provider2) {
        return new VendorInfoAPIObservabilityImpl_Factory(provider, provider2);
    }

    public static VendorInfoAPIObservabilityImpl newInstance(IObservabilityManager iObservabilityManager, AppVersionProvider appVersionProvider2) {
        return new VendorInfoAPIObservabilityImpl(iObservabilityManager, appVersionProvider2);
    }

    public VendorInfoAPIObservabilityImpl get() {
        return newInstance(this.observabilityTrackerProvider.get(), this.appVersionProvider.get());
    }
}
