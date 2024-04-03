package com.talabat.gms.maps.data.di;

import com.talabat.maps.domain.ui.MapFragment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsMapsModule_Companion_SupportMapFragmentFactory implements Factory<MapFragment> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GmsMapsModule_Companion_SupportMapFragmentFactory INSTANCE = new GmsMapsModule_Companion_SupportMapFragmentFactory();

        private InstanceHolder() {
        }
    }

    public static GmsMapsModule_Companion_SupportMapFragmentFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MapFragment supportMapFragment() {
        return (MapFragment) Preconditions.checkNotNullFromProvides(GmsMapsModule.Companion.supportMapFragment());
    }

    public MapFragment get() {
        return supportMapFragment();
    }
}
