package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.data.googleclientid.GoogleClientIdProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreImplLibModule_Companion_ProvideGoogleClientIdLocalStorageFactory implements Factory<GoogleClientIdProvider> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FlutterChannelsCoreImplLibModule_Companion_ProvideGoogleClientIdLocalStorageFactory INSTANCE = new FlutterChannelsCoreImplLibModule_Companion_ProvideGoogleClientIdLocalStorageFactory();

        private InstanceHolder() {
        }
    }

    public static FlutterChannelsCoreImplLibModule_Companion_ProvideGoogleClientIdLocalStorageFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GoogleClientIdProvider provideGoogleClientIdLocalStorage() {
        return (GoogleClientIdProvider) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreImplLibModule.Companion.provideGoogleClientIdLocalStorage());
    }

    public GoogleClientIdProvider get() {
        return provideGoogleClientIdLocalStorage();
    }
}
