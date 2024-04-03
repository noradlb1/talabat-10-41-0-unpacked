package com.talabat.feature.rating.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingFeedBackBaseUrl_Factory implements Factory<RatingFeedBackBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RatingFeedBackBaseUrl_Factory INSTANCE = new RatingFeedBackBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static RatingFeedBackBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RatingFeedBackBaseUrl newInstance() {
        return new RatingFeedBackBaseUrl();
    }

    public RatingFeedBackBaseUrl get() {
        return newInstance();
    }
}
