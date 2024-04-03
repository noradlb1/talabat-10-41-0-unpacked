package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ItemDetailsActivity_MembersInjector implements MembersInjector<ItemDetailsActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public ItemDetailsActivity_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<ItemDetailsActivity> create(Provider<AppVersionProvider> provider) {
        return new ItemDetailsActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.ItemDetailsActivity.appVersionProvider")
    public static void injectAppVersionProvider(ItemDetailsActivity itemDetailsActivity, AppVersionProvider appVersionProvider2) {
        itemDetailsActivity.f54243o = appVersionProvider2;
    }

    public void injectMembers(ItemDetailsActivity itemDetailsActivity) {
        injectAppVersionProvider(itemDetailsActivity, this.appVersionProvider.get());
    }
}
