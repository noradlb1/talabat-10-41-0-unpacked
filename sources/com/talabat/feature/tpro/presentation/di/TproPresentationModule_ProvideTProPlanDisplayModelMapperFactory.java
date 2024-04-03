package com.talabat.feature.tpro.presentation.di;

import com.talabat.feature.tpro.presentation.model.mapper.TProPlanDisplayModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproPresentationModule_ProvideTProPlanDisplayModelMapperFactory implements Factory<TProPlanDisplayModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TproPresentationModule_ProvideTProPlanDisplayModelMapperFactory INSTANCE = new TproPresentationModule_ProvideTProPlanDisplayModelMapperFactory();

        private InstanceHolder() {
        }
    }

    public static TproPresentationModule_ProvideTProPlanDisplayModelMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TProPlanDisplayModelMapper provideTProPlanDisplayModelMapper() {
        return (TProPlanDisplayModelMapper) Preconditions.checkNotNullFromProvides(TproPresentationModule.INSTANCE.provideTProPlanDisplayModelMapper());
    }

    public TProPlanDisplayModelMapper get() {
        return provideTProPlanDisplayModelMapper();
    }
}
