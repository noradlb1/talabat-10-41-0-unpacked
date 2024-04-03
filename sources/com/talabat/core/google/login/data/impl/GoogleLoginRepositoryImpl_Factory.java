package com.talabat.core.google.login.data.impl;

import com.talabat.core.google.login.data.datasource.GoogleLoginDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleLoginRepositoryImpl_Factory implements Factory<GoogleLoginRepositoryImpl> {
    private final Provider<GoogleLoginDataSource> googleLoginDataSourceProvider;

    public GoogleLoginRepositoryImpl_Factory(Provider<GoogleLoginDataSource> provider) {
        this.googleLoginDataSourceProvider = provider;
    }

    public static GoogleLoginRepositoryImpl_Factory create(Provider<GoogleLoginDataSource> provider) {
        return new GoogleLoginRepositoryImpl_Factory(provider);
    }

    public static GoogleLoginRepositoryImpl newInstance(GoogleLoginDataSource googleLoginDataSource) {
        return new GoogleLoginRepositoryImpl(googleLoginDataSource);
    }

    public GoogleLoginRepositoryImpl get() {
        return newInstance(this.googleLoginDataSourceProvider.get());
    }
}
