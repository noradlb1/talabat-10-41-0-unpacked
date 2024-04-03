package com.talabat.feature.darkstorescampaignmessage.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignProgressStateMapper_Factory implements Factory<CampaignProgressStateMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CampaignProgressStateMapper_Factory INSTANCE = new CampaignProgressStateMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CampaignProgressStateMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CampaignProgressStateMapper newInstance() {
        return new CampaignProgressStateMapper();
    }

    public CampaignProgressStateMapper get() {
        return newInstance();
    }
}
