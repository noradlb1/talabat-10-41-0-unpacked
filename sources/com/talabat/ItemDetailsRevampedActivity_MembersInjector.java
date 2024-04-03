package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ItemDetailsRevampedActivity_MembersInjector implements MembersInjector<ItemDetailsRevampedActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public ItemDetailsRevampedActivity_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<ItemDetailsRevampedActivity> create(Provider<AppVersionProvider> provider) {
        return new ItemDetailsRevampedActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.ItemDetailsRevampedActivity.appVersionProvider")
    public static void injectAppVersionProvider(ItemDetailsRevampedActivity itemDetailsRevampedActivity, AppVersionProvider appVersionProvider2) {
        itemDetailsRevampedActivity.f54262o = appVersionProvider2;
    }

    public void injectMembers(ItemDetailsRevampedActivity itemDetailsRevampedActivity) {
        injectAppVersionProvider(itemDetailsRevampedActivity, this.appVersionProvider.get());
    }
}
