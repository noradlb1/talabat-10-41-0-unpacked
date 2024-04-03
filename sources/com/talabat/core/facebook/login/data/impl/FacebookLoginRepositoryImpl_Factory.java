package com.talabat.core.facebook.login.data.impl;

import com.talabat.core.facebook.login.data.datasource.FacebookLoginDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginRepositoryImpl_Factory implements Factory<FacebookLoginRepositoryImpl> {
    private final Provider<FacebookLoginDataSource> facebookLoginDataSourceProvider;

    public FacebookLoginRepositoryImpl_Factory(Provider<FacebookLoginDataSource> provider) {
        this.facebookLoginDataSourceProvider = provider;
    }

    public static FacebookLoginRepositoryImpl_Factory create(Provider<FacebookLoginDataSource> provider) {
        return new FacebookLoginRepositoryImpl_Factory(provider);
    }

    public static FacebookLoginRepositoryImpl newInstance(FacebookLoginDataSource facebookLoginDataSource) {
        return new FacebookLoginRepositoryImpl(facebookLoginDataSource);
    }

    public FacebookLoginRepositoryImpl get() {
        return newInstance(this.facebookLoginDataSourceProvider.get());
    }
}
