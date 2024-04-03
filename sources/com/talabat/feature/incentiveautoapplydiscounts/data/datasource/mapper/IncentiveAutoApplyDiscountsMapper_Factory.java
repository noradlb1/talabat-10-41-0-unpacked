package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IncentiveAutoApplyDiscountsMapper_Factory implements Factory<IncentiveAutoApplyDiscountsMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IncentiveAutoApplyDiscountsMapper_Factory INSTANCE = new IncentiveAutoApplyDiscountsMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static IncentiveAutoApplyDiscountsMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IncentiveAutoApplyDiscountsMapper newInstance() {
        return new IncentiveAutoApplyDiscountsMapper();
    }

    public IncentiveAutoApplyDiscountsMapper get() {
        return newInstance();
    }
}
