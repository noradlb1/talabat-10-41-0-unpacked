package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.view.DividerViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressSummaryModule_Companion_ProvideDividerMapperFactory implements Factory<Mapper<DividerStyle, DividerViewStyle>> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddressSummaryModule_Companion_ProvideDividerMapperFactory INSTANCE = new AddressSummaryModule_Companion_ProvideDividerMapperFactory();

        private InstanceHolder() {
        }
    }

    public static AddressSummaryModule_Companion_ProvideDividerMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Mapper<DividerStyle, DividerViewStyle> provideDividerMapper() {
        return (Mapper) Preconditions.checkNotNullFromProvides(AddressSummaryModule.Companion.provideDividerMapper());
    }

    public Mapper<DividerStyle, DividerViewStyle> get() {
        return provideDividerMapper();
    }
}
