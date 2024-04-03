package com.talabat.darkstores.feature.campaigns;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignProgressSourceMapper_Factory implements Factory<CampaignProgressSourceMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CampaignProgressSourceMapper_Factory INSTANCE = new CampaignProgressSourceMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CampaignProgressSourceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CampaignProgressSourceMapper newInstance() {
        return new CampaignProgressSourceMapper();
    }

    public CampaignProgressSourceMapper get() {
        return newInstance();
    }
}
