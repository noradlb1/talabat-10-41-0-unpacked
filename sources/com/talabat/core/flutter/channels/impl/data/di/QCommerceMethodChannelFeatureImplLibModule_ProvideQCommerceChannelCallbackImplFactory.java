package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceChannelCallbackImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceMethodChannelFeatureImplLibModule_ProvideQCommerceChannelCallbackImplFactory implements Factory<QCommerceChannelCallback> {
    private final QCommerceMethodChannelFeatureImplLibModule module;
    private final Provider<QCommerceChannelCallbackImpl> qCommerceChannelCallbackImplProvider;

    public QCommerceMethodChannelFeatureImplLibModule_ProvideQCommerceChannelCallbackImplFactory(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule, Provider<QCommerceChannelCallbackImpl> provider) {
        this.module = qCommerceMethodChannelFeatureImplLibModule;
        this.qCommerceChannelCallbackImplProvider = provider;
    }

    public static QCommerceMethodChannelFeatureImplLibModule_ProvideQCommerceChannelCallbackImplFactory create(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule, Provider<QCommerceChannelCallbackImpl> provider) {
        return new QCommerceMethodChannelFeatureImplLibModule_ProvideQCommerceChannelCallbackImplFactory(qCommerceMethodChannelFeatureImplLibModule, provider);
    }

    public static QCommerceChannelCallback provideQCommerceChannelCallbackImpl(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule, QCommerceChannelCallbackImpl qCommerceChannelCallbackImpl) {
        return (QCommerceChannelCallback) Preconditions.checkNotNullFromProvides(qCommerceMethodChannelFeatureImplLibModule.provideQCommerceChannelCallbackImpl(qCommerceChannelCallbackImpl));
    }

    public QCommerceChannelCallback get() {
        return provideQCommerceChannelCallbackImpl(this.module, this.qCommerceChannelCallbackImplProvider.get());
    }
}
