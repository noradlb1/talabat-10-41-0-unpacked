package com.talabat.feature.subscriptions.data.di;

import com.talabat.helpers.DateUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsUserDataModule_ProvidesDateUtilsFactory implements Factory<DateUtils> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionsUserDataModule_ProvidesDateUtilsFactory INSTANCE = new SubscriptionsUserDataModule_ProvidesDateUtilsFactory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionsUserDataModule_ProvidesDateUtilsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DateUtils providesDateUtils() {
        return (DateUtils) Preconditions.checkNotNullFromProvides(SubscriptionsUserDataModule.INSTANCE.providesDateUtils());
    }

    public DateUtils get() {
        return providesDateUtils();
    }
}
