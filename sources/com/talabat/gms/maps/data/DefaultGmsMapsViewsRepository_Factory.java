package com.talabat.gms.maps.data;

import com.talabat.maps.domain.ui.MapFragment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGmsMapsViewsRepository_Factory implements Factory<DefaultGmsMapsViewsRepository> {
    private final Provider<MapFragment> supportFragmentProvider;

    public DefaultGmsMapsViewsRepository_Factory(Provider<MapFragment> provider) {
        this.supportFragmentProvider = provider;
    }

    public static DefaultGmsMapsViewsRepository_Factory create(Provider<MapFragment> provider) {
        return new DefaultGmsMapsViewsRepository_Factory(provider);
    }

    public static DefaultGmsMapsViewsRepository newInstance(Provider<MapFragment> provider) {
        return new DefaultGmsMapsViewsRepository(provider);
    }

    public DefaultGmsMapsViewsRepository get() {
        return newInstance(this.supportFragmentProvider);
    }
}
