package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class GroceryDetailsViewScreen_MembersInjector implements MembersInjector<GroceryDetailsViewScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public GroceryDetailsViewScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<GroceryDetailsViewScreen> create(Provider<AppVersionProvider> provider) {
        return new GroceryDetailsViewScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.GroceryDetailsViewScreen.appVersionProvider")
    public static void injectAppVersionProvider(GroceryDetailsViewScreen groceryDetailsViewScreen, AppVersionProvider appVersionProvider2) {
        groceryDetailsViewScreen.appVersionProvider = appVersionProvider2;
    }

    public void injectMembers(GroceryDetailsViewScreen groceryDetailsViewScreen) {
        injectAppVersionProvider(groceryDetailsViewScreen, this.appVersionProvider.get());
    }
}
