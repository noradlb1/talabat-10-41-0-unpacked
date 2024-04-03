package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class GroceryMenuSearchActivity_MembersInjector implements MembersInjector<GroceryMenuSearchActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public GroceryMenuSearchActivity_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<GroceryMenuSearchActivity> create(Provider<AppVersionProvider> provider) {
        return new GroceryMenuSearchActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuSearchActivity.appVersionProvider")
    public static void injectAppVersionProvider(GroceryMenuSearchActivity groceryMenuSearchActivity, AppVersionProvider appVersionProvider2) {
        groceryMenuSearchActivity.f54188l = appVersionProvider2;
    }

    public void injectMembers(GroceryMenuSearchActivity groceryMenuSearchActivity) {
        injectAppVersionProvider(groceryMenuSearchActivity, this.appVersionProvider.get());
    }
}
