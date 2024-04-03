package com.talabat.feature.tpro.presentation.di;

import com.talabat.feature.tpro.presentation.model.mapper.TProMultiPlanDisplayModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproPresentationModule_ProvideTProMultiPlanDisplayModelMapperFactory implements Factory<TProMultiPlanDisplayModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TproPresentationModule_ProvideTProMultiPlanDisplayModelMapperFactory INSTANCE = new TproPresentationModule_ProvideTProMultiPlanDisplayModelMapperFactory();

        private InstanceHolder() {
        }
    }

    public static TproPresentationModule_ProvideTProMultiPlanDisplayModelMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TProMultiPlanDisplayModelMapper provideTProMultiPlanDisplayModelMapper() {
        return (TProMultiPlanDisplayModelMapper) Preconditions.checkNotNullFromProvides(TproPresentationModule.INSTANCE.provideTProMultiPlanDisplayModelMapper());
    }

    public TProMultiPlanDisplayModelMapper get() {
        return provideTProMultiPlanDisplayModelMapper();
    }
}
