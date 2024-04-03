package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PlacesSearchScreen_MembersInjector implements MembersInjector<PlacesSearchScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public PlacesSearchScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<PlacesSearchScreen> create(Provider<AppVersionProvider> provider) {
        return new PlacesSearchScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.PlacesSearchScreen.appVersionProvider")
    public static void injectAppVersionProvider(PlacesSearchScreen placesSearchScreen, AppVersionProvider appVersionProvider2) {
        placesSearchScreen.f54537m = appVersionProvider2;
    }

    public void injectMembers(PlacesSearchScreen placesSearchScreen) {
        injectAppVersionProvider(placesSearchScreen, this.appVersionProvider.get());
    }
}
