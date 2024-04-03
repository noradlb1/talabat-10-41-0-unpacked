package com.talabat.hms.maps.data;

import com.talabat.maps.domain.ui.MapFragment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultHmsMapsViewsRepository_Factory implements Factory<DefaultHmsMapsViewsRepository> {
    private final Provider<MapFragment> supportFragmentProvider;

    public DefaultHmsMapsViewsRepository_Factory(Provider<MapFragment> provider) {
        this.supportFragmentProvider = provider;
    }

    public static DefaultHmsMapsViewsRepository_Factory create(Provider<MapFragment> provider) {
        return new DefaultHmsMapsViewsRepository_Factory(provider);
    }

    public static DefaultHmsMapsViewsRepository newInstance(Provider<MapFragment> provider) {
        return new DefaultHmsMapsViewsRepository(provider);
    }

    public DefaultHmsMapsViewsRepository get() {
        return newInstance(this.supportFragmentProvider);
    }
}
