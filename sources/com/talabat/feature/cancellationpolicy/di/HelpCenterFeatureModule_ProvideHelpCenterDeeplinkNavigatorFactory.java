package com.talabat.feature.cancellationpolicy.di;

import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HelpCenterFeatureModule_ProvideHelpCenterDeeplinkNavigatorFactory implements Factory<IHelpCenterDeeplinkBuilder> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HelpCenterFeatureModule_ProvideHelpCenterDeeplinkNavigatorFactory INSTANCE = new HelpCenterFeatureModule_ProvideHelpCenterDeeplinkNavigatorFactory();

        private InstanceHolder() {
        }
    }

    public static HelpCenterFeatureModule_ProvideHelpCenterDeeplinkNavigatorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IHelpCenterDeeplinkBuilder provideHelpCenterDeeplinkNavigator() {
        return (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromProvides(HelpCenterFeatureModule.INSTANCE.provideHelpCenterDeeplinkNavigator());
    }

    public IHelpCenterDeeplinkBuilder get() {
        return provideHelpCenterDeeplinkNavigator();
    }
}
