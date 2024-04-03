package com.talabat.core.google.login.data.datasource.impl;

import android.content.Context;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleLoginDataSourceImpl_Factory implements Factory<GoogleLoginDataSourceImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<GoogleLoginActivityIntegration> googleLoginActivityIntegrationProvider;

    public GoogleLoginDataSourceImpl_Factory(Provider<Context> provider, Provider<GoogleLoginActivityIntegration> provider2) {
        this.contextProvider = provider;
        this.googleLoginActivityIntegrationProvider = provider2;
    }

    public static GoogleLoginDataSourceImpl_Factory create(Provider<Context> provider, Provider<GoogleLoginActivityIntegration> provider2) {
        return new GoogleLoginDataSourceImpl_Factory(provider, provider2);
    }

    public static GoogleLoginDataSourceImpl newInstance(Context context, GoogleLoginActivityIntegration googleLoginActivityIntegration) {
        return new GoogleLoginDataSourceImpl(context, googleLoginActivityIntegration);
    }

    public GoogleLoginDataSourceImpl get() {
        return newInstance(this.contextProvider.get(), this.googleLoginActivityIntegrationProvider.get());
    }
}
